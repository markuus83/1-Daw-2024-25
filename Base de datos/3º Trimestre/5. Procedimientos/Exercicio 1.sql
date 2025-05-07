/* Ejercicios PROCEDIMIENTOS ALMACENADOS*/
 -- Es necesario definir la creación de los procedimientos y añadir ejemplos de ejecución de cada uno
 -- En el condigo de los procedimientos es necesario contemplar los posibles errores o nulls al introducir los datos



/* 1. Realizar un procedimiento que acepte un departamento como argumento y visualice todos los datos de los empleados que en él trabajan.
*/
CREATE PROCEDURE ObtenerEmpleadosPorDepartamento
    @IDDepartamento INT
AS
BEGIN
    IF @IDDepartamento IS NULL
    BEGIN
        PRINT 'Debe proporcionar un ID de departamento.'
        RETURN
    END

    SELECT *
    FROM EMPLEADOS
    WHERE IDDepartamento = @IDDepartamento
END
GO

-- Ejemplo de uso
EXEC ObtenerEmpleadosPorDepartamento @IDDepartamento = 10;



/* 2. Realizar un procedimiento que acepte un nombre de departamento y devuelva mediante dos parámetros de tipo OUTPUT su número y nombre del director (director).
*/

    CREATE PROCEDURE ObtenerInfoDepartamentoPorNombre
        @NombreDepto NVARCHAR(50),
        @IDDepartamento INT OUTPUT,
        @NombreDirector NVARCHAR(100) OUTPUT
    AS
    BEGIN
        DECLARE @IDDir INT

        SELECT TOP 1 @IDDepartamento = D.IDDepartamento,
                    @IDDir = E.Director
        FROM DEPARTAMENTOS D
        JOIN EMPLEADOS E ON D.IDDepartamento = E.IDDepartamento
        WHERE D.Nombre = @NombreDepto

        SELECT @NombreDirector = Nombre
        FROM EMPLEADOS
        WHERE IDEmpleado = @IDDir
    END
    GO


-- Ejemplo de uso
DECLARE @ID INT, @Director NVARCHAR(100)
EXEC ObtenerInfoDepartamentoPorNombre 'Ventas', @ID OUTPUT, @Director OUTPUT
SELECT @ID AS IDDepartamento, @Director AS Director


/* 3. Crear un procedimiento almacenado que inserte un pedido nuevo y devuelva el id*/

CREATE PROCEDURE InsertarPedido
    @IDProducto INT,
    @IDCliente INT,
    @Unidades INT,
    @IDPedido INT OUTPUT
AS
BEGIN
    BEGIN TRY
        INSERT INTO PEDIDOS (IDProducto, IDCliente, Unidades, Fecha_pedido)
        VALUES (@IDProducto, @IDCliente, @Unidades, GETDATE())

        SET @IDPedido = SCOPE_IDENTITY()
    END TRY
    BEGIN CATCH
        PRINT 'Error al insertar el pedido.'
    END CATCH
END
GO

-- Ejemplo de uso
DECLARE @NuevoID INT
EXEC InsertarPedido 3, 2, 10, @NuevoID OUTPUT
SELECT @NuevoID AS IDNuevoPedido



/* 4. Desarrollar un procedimiento que permita insertar nuevos departamentos
- Se pasará al procedimiento el nombre del departamento y la localidad.
- El procedimiento insertará la fila nueva asignando como número de departamento la decena siguiente al número mayor de la tabla.
*/

 CREATE PROCEDURE InsertarDepartamento
    @Nombre NVARCHAR(50),
    @Localidad NVARCHAR(50)
AS
BEGIN
    DECLARE @NuevoID INT

    SELECT @NuevoID = (CEILING(MAX(IDDepartamento) / 10.0) + 1) * 10
    FROM DEPARTAMENTOS

    INSERT INTO DEPARTAMENTOS (IDDepartamento, Nombre, Localidad)
    VALUES (@NuevoID, @Nombre, @Localidad)
END
GO

-- Ejemplo de uso
EXEC InsertarDepartamento 'Investigación', 'Madrid'



/* 5. Realizar un procedimiento que reciba el nombre de un cliente como argumento y visualice todos los pedidos que ha realizado, con el nombre de los productos las unidades y ordenados por fecha desde el más reciente
*/


CREATE PROCEDURE VerPedidosCliente
    @NombreCliente NVARCHAR(100)
AS
BEGIN
    SELECT P.IDPedido, PR.Descripcion, P.Unidades, P.Fecha_pedido
    FROM CLIENTES C
    JOIN PEDIDOS P ON C.IDCliente = P.IDCliente
    JOIN PRODUCTOS PR ON P.IDProducto = PR.IDProducto
    WHERE C.Nombre = @NombreCliente
    ORDER BY P.Fecha_pedido DESC
END
GO

-- Ejemplo de uso
EXEC VerPedidosCliente 'Juan Pérez'



/* 6. Para trabajar con la tabla clientes crear los siguientes procedimientos:
        1- Aceptando los datos básicos dar de alta un cliente
        2- Modificar los datos de crédito debe y haber, pidiéndolos como parámetros
        3- Eliminar un cliente
        4- Crear un procedimiento que muestre los datos de un cliente si se le da el nombre y si no todos los clientes
*/

CREATE PROCEDURE AltaCliente
    @Nombre NVARCHAR(100),
    @Localidad NVARCHAR(50),
    @IDComercial INT,
    @Debe DECIMAL(10,2),
    @Haber DECIMAL(10,2),
    @Credito DECIMAL(10,2)
AS
BEGIN
    INSERT INTO CLIENTES (Nombre, Localidad, IDComercial, Debe, Haber, Credito)
    VALUES (@Nombre, @Localidad, @IDComercial, @Debe, @Haber, @Credito)
END
GO


/* 7. Crear un procedimiento almacenado en el que se defina la transacción para realizar un pedido de un producto
 para un cliente, pidiendo el nombre del cliente, el nombre del producto y el stock
   - Si se realiza el pedido se tiene que descontar el stock
   - También se tiene que añadir en el debe del cliente la cantidad del total del pedido.
 */
    
CREATE PROCEDURE RealizarPedidoCompleto
    @NombreCliente NVARCHAR(100),
    @NombreProducto NVARCHAR(100),
    @Unidades INT
AS
BEGIN
    DECLARE @IDCliente INT, @IDProducto INT, @Precio DECIMAL(10,2), @Total DECIMAL(10,2)

    BEGIN TRY
        BEGIN TRAN

        SELECT @IDCliente = IDCliente FROM CLIENTES WHERE Nombre = @NombreCliente
        IF @IDCliente IS NULL
            THROW 50000, 'Cliente no encontrado.', 1

        SELECT @IDProducto = IDProducto, @Precio = PrecioActual, Stock FROM PRODUCTOS WHERE Descripcion = @NombreProducto
        IF @IDProducto IS NULL
            THROW 50001, 'Producto no encontrado.', 1

        IF @Unidades > (SELECT Stock FROM PRODUCTOS WHERE IDProducto = @IDProducto)
            THROW 50002, 'Stock insuficiente.', 1

        SET @Total = @Precio * @Unidades

        INSERT INTO PEDIDOS (IDProducto, IDCliente, Unidades, Fecha_pedido)
        VALUES (@IDProducto, @IDCliente, @Unidades, GETDATE())

        UPDATE PRODUCTOS SET Stock = Stock - @Unidades WHERE IDProducto = @IDProducto

        UPDATE CLIENTES SET Debe = Debe + @Total WHERE IDCliente = @IDCliente

        COMMIT
    END TRY
    BEGIN CATCH
        ROLLBACK
        PRINT ERROR_MESSAGE()
    END CATCH
END
GO

-- Ejemplo
EXEC RealizarPedidoCompleto 'Juan Pérez', 'Impresora HP', 3

