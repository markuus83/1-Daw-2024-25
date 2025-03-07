CREATE DATABASE a23marcoscc_BD_ExercicioAlter1;
GO
USE a23marcoscc_BD_ExercicioAlter1;


CREATE TABLE EMPLEADO(

	codemp INT IDENTITY (1,1) PRIMARY KEY,
	nombre VARCHAR(30) NOT NULL,
	apellido1 VARCHAR(30) NOT NULL,
	apellido2 VARCHAR(30) NOT NULL,
	direccion VARCHAR(30),
	provincia VARCHAR(30) DEFAULT('Pontevedra'),
	dni CHAR(9), 
	coddepto INT, -- FOREIGN KEY
	salario SMALLMONEY DEFAULT (0),
	fecalta CHAR(12) UNIQUE, -- CHECK
	dto DECIMAL(4,2), 
	
	CONSTRAINT CHK_DNI
	CHECK (dni LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]'),
	
	CONSTRAINT CHK_FECALTA
	CHECK (fecalta LIKE '[0-3][0-9]/[0-1][0-9]/[1-2][0-9][0-9][0-9]')

);


CREATE TABLE DEPARTAMENTO(

	coddepto INT IDENTITY (1,1) PRIMARY KEY,
	depto VARCHAR(30),
	codjefe INT, --FOREIGN KEY
	presupuesto MONEY DEFAULT(0),

);


CREATE TABLE HORAS_EXTRA(

	codemp INT,
	fecha DATETIME,
	num_horas int,

	CONSTRAINT PK_HORAS_EXTRA
	PRIMARY KEY (codemp, fecha)
);


-- ##################
-- ## FOREIGN KEYS ##
-- ##################

	-- EMPLEADO

		ALTER TABLE EMPLEADO ADD 
		CONSTRAINT FK_EMPLEADO_DEPARTAMENTO
			FOREIGN KEY (coddepto)
			REFERENCES DEPARTAMENTO (coddepto)
			ON UPDATE CASCADE ON DELETE CASCADE
			
	-- DEPARTAMENTO

		ALTER TABLE DEPARTAMENTO ADD 
		CONSTRAINT FK_DEPARTAMENTO_EMPLEADO
			FOREIGN KEY (codjefe)
			REFERENCES EMPLEADO (codemp)
			ON UPDATE NO ACTION ON DELETE NO ACTION
			
			
	-- HORAS_EXTRA
		ALTER TABLE HORAS_EXTRA ADD 
		CONSTRAINT FK_HORAS_EXTRA_EMPLEADO
			FOREIGN KEY (codemp)
			REFERENCES EMPLEADO (codemp)
			ON UPDATE CASCADE ON DELETE CASCADE



-- ##################
-- ## ALTER TABLES ##
-- ##################

-- AÑade un campo a la tabla empleado para guardar el importe que cobra el empleado por sus horas extra.

	ALTER TABLE EMPLEADO
	ADD importe_horas_extra MONEY;


-- Todos los empleados del mismo departamento cobran lo mismo, 
--así que mejor elimina el campo que acabas de crear y añádelo a la tabla departamento

	ALTER TABLE EMPLEADO
	DROP COLUMN importe_horas_extra;
	
	ALTER TABLE DEPARTAMENTO
	ADD importe_horas_extra MONEY;



-- Se han dado cuenta que guardar la fecha de alta del empleado como texto es una tontería, 
-- así que cambiaremos para que sea una fecha. Además debe tomar por defecto el valor de la fecha actual.

	-- Debemos borrar la clave del CHECK
	ALTER TABLE EMPLEADO
	DROP CONSTRAINT CHK_FECALTA;

	-- Debemos borrar la clave del UNIQUE
	ALTER TABLE EMPLEADO
	DROP CONSTRAINT UQ__EMPLEADO__FEB4AD8F1273C1CD;

	-- Borramos la columna
	ALTER TABLE EMPLEADO
	DROP COLUMN fecalta;
	
	-- La añadimos de nuevo
	ALTER TABLE EMPLEADO
	ADD fecalta DATETIME UNIQUE DEFAULT GETDATE()
	


-- Modifica el campo DNI del empleado para que tenga que ser indicado obligatoriamente.

	ALTER TABLE EMPLEADO
	ALTER COLUMN dni CHAR(9) not null


-- Cambia el nombre del campo 'Empleado.dto' por 'Empleado.descuento' y del campo 'Departamento.depto' por 'Departamento.departamento'
	
	SELECT * FROM EMPLEADO

		EXEC sp_rename 'EMPLEADO.dto', 'descuento', 'COLUMN'

	SELECT * FROM EMPLEADO


	SELECT * FROM DEPARTAMENTO

		EXEC sp_rename 'DEPARTAMENTO.depto', 'departamento', 'COLUMN'
		
	SELECT * FROM DEPARTAMENTO