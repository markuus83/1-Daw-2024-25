CREATE DATABASE a23marcoscc_Pruebas_Alter_Drop;
USE a23marcoscc_Pruebas_Alter_Drop;

--Creamos la tabla de ejemplo
CREATE TABLE Ejemplo1(
	nuevo1 tinyint
);

SELECT * FROM Ejemplo1;


--ALTERACIONES PARA AÑADIR NUEVAS COLUMNAS

	-- Alteramos la tabla 
	ALTER TABLE Ejemplo1
		ADD nuevo2 int CONSTRAINT valores_validos CHECK(nuevo2>10);

	--Vemos los nuevos cambios
	SELECT * FROM Ejemplo1;

	--Alteramos nuevamente la tabla
	ALTER TABLE Ejemplo1
		ADD nuevo3 char(2) CONSTRAINT valor_no DEFAULT('NO');

	--Vemos los nuevos cambios
	SELECT * FROM Ejemplo1;

	--Alteramos nuevamente la tabla
	ALTER TABLE Ejemplo1
		ADD nuevo4 char(4) CONSTRAINT valorno4 DEFAULT ('NO') WITH VALUES;

	--Vemos los nuevos cambios
	SELECT * FROM Ejemplo1;



-- ALTERACIONES PARA ELIMINAR COLUMNAS

	--Eliminamos una columna
	ALTER TABLE Ejemplo1
		DROP COLUMN nuevo1;

	--Vemos los nuevos cambios
	SELECT * FROM Ejemplo1;

	--Volvemos a añadir la columna
	ALTER TABLE Ejemplo1
		ADD nuevo1 tinyint;

	--Vemos los nuevos cambios
	--Observamos como la columna se crea al final de todo, perdiendo la primera posición
	SELECT * FROM Ejemplo1;



-- AÑADIMOS CONSTRAINTS

	--Añadimos una constraint a la columna "nuevo2"
	ALTER TABLE Ejemplo1
		ADD CONSTRAINT res1 CHECK (nuevo2 BETWEEN 1 AND 100);

	--Añadimos una constraint a la columna "nuevo3"
	ALTER TABLE Ejemplo1
		ADD CONSTRAINT res2 CHECK (nuevo3 > 100);



-- ELIMINAMOS LAS CONSTRAINTS

	--Definimos que la columna "nuevo2" es UNIQUE
	ALTER TABLE Ejemplo1
		ADD CONSTRAINT nuevo2_unique UNIQUE(nuevo2);

	--Eliminamos la constraint de la columna "nuevo2"
	--Observamos que para eliminarlo, tenemos que poner el nombre de la CONSTRAINT
	ALTER TABLE Ejemplo1
		DROP nuevo2_unique;



-- MODIFICAMOS EL TIPO DE DATOS

	--Modificamos el tipo de dato de la columna "nuevo1"
	ALTER TABLE Ejemplo1
		ALTER COLUMN nuevo1 varchar(30);


	
--ELIMINAR COLUMNAS
	
	--Observamos como se encuentra la tabla antes de ejecutar los cambios
	SELECT * FROM Ejemplo1;

	--Eliminamos la columna "nuevo1"
	ALTER TABLE Ejemplo1
		DROP COLUMN nuevo1;

	--Observamos los cambios
	SELECT * FROM Ejemplo1;



--TRUNCATE TABLE EJEMPLO DE USO

	--Observamos como se encuentra la tabla antes de ejecutar los cambios
	SELECT * FROM Ejemplo1;

	--Eliminamos la tabla
	TRUNCATE TABLE Ejemplo1

	--Observamos los cambios (Como no hay dato ingresados, se queda tal cual)
	SELECT * FROM Ejemplo1;



--COSAS A TENER EN CUENTA:
-- No se puede utilizar DROP TABLE para quitar una tabla a la que haga referencia una restricción FOREIGN KEY. Primero se debe quitar la restricción FOREIGN KEY a la tabla de referencia