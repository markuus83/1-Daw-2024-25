CREATE DATABASE n_usuario_ALMACEN;
GO
USE n_usuario_ALMACEN;  


	CREATE TABLE PRODUCTOS(
		CODIGO CHAR(2) PRIMARY KEY,
		NOMBRE CHAR(30) NOT NULL ,
		DESCRIPCION CHAR(19)  ,
		TALLA CHAR(1) DEFAULT 'U',
		PRECIO SMALLINT 
	);

-- Insercion usando la lista de columnas 

	INSERT INTO Productos (Codigo, Nombre, Descripcion,Talla, Precio) 
			VALUES ('1','Sudadera manga larga','Estilosa', 'S',25);
			SELECT * FROM Productos;


-- Intento  insertar sin valor para Descricion

   INSERT INTO Productos (Codigo, Nombre, Talla, Precio) 
			VALUES ('2',' Sudadera manga larga','S',25);
			SELECT * FROM Productos;

-- Rellena Descripcion con NULL

--Cambiamos la columna precio de forma que no permita NULL

ALTER TABLE PRODUCTOS ALTER COLUMN Precio SMALLINT  NOT NULL;

-- Comprobar en el Explorador de Objetos que se borr�
-- Intento en insertar sin valor para precio. 

-- No deja insertar pues ahora PRECIO no permite NULL

INSERT INTO Productos (Codigo, Nombre, Descripcion, Talla) 
			VALUES ('3',' Sudadera manga larga','Verde', 'S');
			SELECT * FROM Productos;

-- Intento en insertar sin valor para Talla
-- Deja insertar y pone el valor por defecto.


INSERT INTO Productos (Codigo,Nombre, Descripcion, Precio) 
   VALUES (4,'Sudadera manga corta','Roja',25);

   SELECT * FROM Productos;

-- Podr�a insertar tambien en Talla el valor NULL, pues no dice quea NOT NULL

INSERT INTO Productos (Codigo,Nombre, Descripcion, Talla, Precio) 
		VALUES (5,'Sudadera sin manga','ROJO',NULL,25);

--Insert sin lista de columnas. Todos los valores y en el mismo orden.

INSERT INTO Productos VALUES (6,'Camisa','Blanca','M',55);

-- Insertar varias filas a la vez

INSERT INTO PRODUCTOS
  (Codigo,Nombre, Descripcion,  Precio )
VALUES
(7,'Camiseta','Blanca',55),
(8,'Sweeter rayado','Negro',45),
(9,'Pantal�n deportivo','Negro',50),
(10,'Short ba�o','Varios colores',35);

   SELECT * FROM Productos;

--********************************************************
--*********************IDENTITY***************************
--********************************************************


CREATE TABLE Material (
idProducto SMALLINT IDENTITY PRIMARY KEY,
Descripcion VARCHAR(30),
cantidad INT
);

INSERT INTO Material (Descripcion, cantidad) 
    VALUES ('L�pices', 24), ('Bol�grafos', 18), ('Escuadras', 8), ('Cartab�n',9);

SELECT * FROM Material;

--Insertar un valor distinto.


INSERT INTO Material (idProducto ,Descripcion, cantidad) 
    VALUES (25,'Rotuladores', 24);

-- Da error


-- Activamos el identity_insert

SET IDENTITY_INSERT Material  ON

-- Vuelvo a intentar

INSERT INTO Material (idProducto ,Descripcion, cantidad) 
    VALUES (25,'Rotuladores', 24);
	--Apago el Identity_insert

SET IDENTITY_INSERT Material OFF

-- Vuelvo a intentar.

INSERT INTO Material (Descripcion, cantidad) 
 VALUES ('Rotuladores', 29);

 --Funciona

SELECT * FROM Material;

--Otro ejemplo:
-- Quiero insertar el producto 30

INSERT INTO Material 
    VALUES (30,'Tipex', 24);

-- Enciendo el identity_insert

SET IDENTITY_INSERT Material  ON;

-- Vuelvo a intentarcon lista de columnas

INSERT INTO Material (idProducto, Descripcion, cantidad) 
 VALUES (30, 'Rotuladores', 29);

	--Apago el Identity_insert

SET IDENTITY_INSERT Material OFF;


select * from Material;


--********************************************************
--*********************DELETE***************************
--********************************************************
SELECT * FROM PRODUCTOS;

DELETE FROM PRODUCTOS
WHERE talla = 'M'
;

SELECT * FROM PRODUCTOS;

-- Borra tres
DELETE TOP(3)
FROM PRODUCTOS
WHERE talla = 'U';


INSERT INTO PRODUCTOS VALUES(6, 'LACOSTE','VERDE','U', 25);


SELECT * FROM PRODUCTOS;

--Probar

DELETE TOP(25) PERCENT
FROM PRODUCTOS
WHERE PRECIO = 25;


DELETE TOP(25) PERCENT
FROM PRODUCTOS
WHERE PRECIO = 25 AND DESCRIPCION ='ROJO';



SELECT * FROM PRODUCTOS;


--********************************************************
--*********************UPDATE*****************************
--********************************************************

SELECT * FROM PRODUCTOS;

	UPDATE PRODUCTOS
	 SET nombre = 'Camisola',
      PRECIO  = 60
	WHERE NOMBRE = 'Lacoste';

	SELECT * FROM PRODUCTOS;

-- A�adimos una columna a la tabla. Se rellena los valores nuevos con NULL

	ALTER TABLE PRODUCTOS  ADD  IVA TINYINT;   --Si no decimos nada, permite nulos

	SELECT * FROM PRODUCTOS;

--Poner los IVAS a 1

	UPDATE PRODUCTOS SET IVA = 1;

-- Como consecuencia del convenio se aumenta el PRECIO a todos los PRODUCTOS
-- en un 5.33% y la comision en un 6.19% a todos los vendedores.

	UPDATE PRODUCTOS
				SET PRECIO  = PRECIO*1.0533,
				IVA = IVA*1.0619;


	SELECT * FROM PRODUCTOS;

--Al estar IVa como entero, no coge los decimales. Cambio a decimales

	ALTER TABLE PRODUCTOS
		ALTER   COLUMN IVA DECIMAL(4,2) -- 2 ENTEROS Y 2 DECIMALES

	ALTER TABLE PRODUCTOS
		ALTER COLUMN PRECIO DECIMAL(4,2);   -- 2 ENTEROS Y 2 DECIMALES
	SELECT * FROM PRODUCTOS;


UPDATE PRODUCTOS
				SET PRECIO  = PRECIO*1.0533,
				IVA = IVA*1.0619;

	SELECT * FROM PRODUCTOS;