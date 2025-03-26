CREATE DATABASE a23marcoscc_Examen1;
GO
USE a23marcoscc_Examen1;


CREATE TABLE CLIENTE (
    ClienteID INT IDENTITY(1,1) PRIMARY KEY, -- Identificador único
    Nombre NVARCHAR(100) NOT NULL, -- Nombre del cliente
    Telefono CHAR(10) CHECK (Telefono LIKE '[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9]'), -- Validación de formato
    Credito DECIMAL(10, 2) NOT NULL, -- Crédito máximo permitido
    Debe DECIMAL(10, 2) DEFAULT 0 CHECK (Debe >= 0), -- Dinero que nos debe
    Haber DECIMAL(10, 2) DEFAULT 0 CHECK (Haber >= 0), -- Dinero a su favor
    Deuda AS (Debe - Haber) PERSISTED, -- Columna calculada
    Antiguedad DATE CHECK (Antiguedad < GETDATE()), -- Fecha de antigüedad menor a la fecha actual
    CONSTRAINT CHK_Deuda_Credito CHECK ((Debe - Haber) <= Credito) -- Restricción a nivel de tabla
);



CREATE TABLE PRODUCTO (
    ProductoID INT IDENTITY(200, 2) PRIMARY KEY, -- Identificador único autoincrementado
    Descripcion NVARCHAR(255) NOT NULL, -- Descripción del producto
    Precio_actual DECIMAL(10, 2) NOT NULL, -- Precio actual del producto
    Stock INT DEFAULT 0 CHECK (Stock >= 0), -- Stock disponible
    Valor_actual_stock AS (Precio_actual * Stock) PERSISTED -- Columna calculada: valor del stock
);

CREATE TABLE PEDIDO (
    PedidoID INT IDENTITY(1,1) PRIMARY KEY, -- Identificador único para cada pedido
    ClienteID INT NOT NULL, -- Cliente que realiza el pedido
    ProductoID INT NOT NULL, -- Producto solicitado
    Unidades INT CHECK (Unidades > 0), -- Cantidad de unidades solicitadas
    Fecha_hora_pedido DATETIME DEFAULT GETDATE(), -- Fecha y hora del pedido
    CONSTRAINT FK_Pedidos_Clientes FOREIGN KEY (ClienteID) REFERENCES CLIENTE(ClienteID)
        ON UPDATE CASCADE ON DELETE NO ACTION, -- Reglas de actualización y eliminación
    CONSTRAINT FK_Pedidos_Productos FOREIGN KEY (ProductoID) REFERENCES PRODUCTO(ProductoID)
        ON UPDATE CASCADE ON DELETE NO ACTION -- Reglas de actualización y eliminación
);

INSERT INTO CLIENTE (Nombre, Telefono, Credito, Debe, Haber, Antiguedad)
VALUES 
('Juan Pérez', '123-456789', 1000.00, 200.00, 50.00, '2022-01-15'),
('María López', '456-123789', 2000.00, 500.00, 200.00, '2020-05-20'),
('Carlos García', '789-123456', 1500.00, 300.00, 150.00, '2021-03-10');

-- Insertar filas en la tabla Productos
INSERT INTO PRODUCTO (Descripcion, Precio_actual, Stock)
VALUES 
('Producto A', 10.00, 50),
('Producto B', 20.00, 30),
('Producto C', 15.00, 100);

-- Insertar filas en la tabla Pedidos
INSERT INTO PEDIDO (ClienteID, ProductoID, Unidades)
VALUES 
(1, 200, 5),
(2, 202, 10),
(3, 204, 15);

-- Eliminar un producto que tenga algún pedido
DELETE FROM PRODUCTO 
WHERE ProductoID = (
    SELECT TOP 1 ProductoID
    FROM PEDIDO
    WHERE ProductoID = PRODUCTO.ProductoID
);


SELECT * FROM CLIENTE;
SELECT * FROM PRODUCTO;
SELECT * FROM PEDIDO;