CREATE DATABASE a23marcoscc_BD_ExercicioAlter2;
GO
USE a23marcoscc_BD_ExercicioAlter2;

CREATE TABLE TFNO_PROFE (

	codprof INT,
	numero CHAR(9),
	principal CHAR(1),
	
	CONSTRAINT PK_TFNO_PROFE
	PRIMARY KEY (codprof, numero),
	
	CONSTRAINT CHK_NUMERO
	CHECK (numero like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	
	CONSTRAINT CHK_PRINCIPAL
	CHECK (principal IN('S', 'N'))

);


CREATE TABLE PROFESOR (

	codprof INT IDENTITY(1,1) PRIMARY KEY,
	dni CHAR(9) UNIQUE,
	nombre VARCHAR(30),
	direccion VARCHAR(30),
	tipocarnet CHAR(2),
	
	
	CONSTRAINT CHK_DNI
	CHECK (dni like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]'),
	
	CONSTRAINT CHK_TIPOCARNET
	CHECK (tipocarnet IN ('A1', 'A2', 'B1', 'B2'))

);


CREATE TABLE MODULO (

	codmod INT IDENTITY(1,1) PRIMARY KEY,
	nombre VARCHAR(30),
	codprof INT,
	coddelegado INT,
	ciclo VARCHAR(4),
	
	CONSTRAINT CHK_CICLO
	CHECK (ciclo IN ('SMIR', 'ASIR', 'DAM', 'DAW')),

);


CREATE TABLE MATRICULA (

	codmod INT,
	codalumno INT,
	fecmatricula DATETIME,

	CONSTRAINT PK_MATRICULA
	PRIMARY KEY (codmod, codalumno)
);


CREATE TABLE ALUMNO (

	numexp INT IDENTITY(1,1) PRIMARY KEY,
	nombre VARCHAR(30),
	apellidos VARCHAR(30),
	fecnac DATE,

);


-- ####################
-- ### FOREIGN KEYS ###
-- ####################


	--TFNO_PROFE
		ALTER TABLE TFNO_PROFE
		ADD CONSTRAINT FK_TFNO_PROFE_PROFESOR
			FOREIGN KEY (codprof)
			REFERENCES PROFESOR(codprof)
			ON UPDATE CASCADE ON DELETE CASCADE;


	--MODULO
	
		ALTER TABLE MODULO
		ADD CONSTRAINT FK_MODULO_PROFESOR
			FOREIGN KEY (codprof)
			REFERENCES PROFESOR(codprof)
			ON UPDATE CASCADE ON DELETE SET NULL;
		
		ALTER TABLE MODULO	
		ADD CONSTRAINT FK_MODULO_ALUMNO
			FOREIGN KEY (coddelegado)
			REFERENCES ALUMNO(numexp)
			ON UPDATE CASCADE ON DELETE SET NULL;


	--MATRICULA
	
		ALTER TABLE MATRICULA
		ADD CONSTRAINT FK_MATRICULA_MODULO
			FOREIGN KEY (codmod)
			REFERENCES MODULO(codmod)
			ON UPDATE CASCADE ON DELETE NO ACTION;
		
		ALTER TABLE MATRICULA	
		ADD CONSTRAINT FK_MATRICULA_ALUMNO
			FOREIGN KEY (codalumno)
			REFERENCES ALUMNO(numexp)
			ON UPDATE NO ACTION ON DELETE NO ACTION; -- CAMBIADO A UPDATE NO ACTION POR ERRORES CON EL GESTOR


-- ########################
-- ### CAMBIOS DE ALTER ###
-- ########################

 -- Añadir campos a la tabla PROFESOR
 
	SELECT * FROM PROFESOR
	
		ALTER TABLE PROFESOR
			ADD apellido1 VARCHAR (30);
			
		ALTER TABLE PROFESOR
			ADD apellido2 VARCHAR (30);
	
	SELECT * FROM PROFESOR
	
	
-- Modificar el campo fecnac de la tabla ALUMNO

	select * from ALUMNO
	
		EXEC sp_rename 'ALUMNO.fecnac', 'fechanac', 'COLUMN';
	
	select * from ALUMNO

	
-- Cambiar nombre de la tabla TFNO_PROFE

	SELECT * FROM TFNO_PROFE
	
		EXEC sp_rename 'TFNO_PROFE', 'TELEFONOS';
		
	SELECT * FROM TELEFONOS
	

-- Eliminar la FK que tiene el campo coddelegado

	ALTER TABLE MODULO
		DROP FK_MODULO_ALUMNO

		
-- Añade en la tabla MODULO un campo llamado "seguimiento", que será un número entero de tamaño máximo 999999

	ALTER TABLE MODULO
		ADD seguimiento INT 
		CONSTRAINT CHK_SEGUIMIENTO
		CHECK (seguimiento <= 999999);

		
-- Modifica el campo MODULO.codprof para que no pueda ser nulo

	ALTER TABLE MODULO
		ALTER COLUMN codprof INT NOT NULL;
		

-- Nos interesa emplear la tabla de TFNO_PROFE para guardar teléfonos también de los alumnos, 
-- por lo que necesitamos añadir un nuevo campo a la tabla que indique el tipo de teléfono (podrá ser ‘ALUMNO’ o ‘PROFESOR’) 
-- y eliminar la foreign key que teníamos en el campo codprof.

	ALTER TABLE TELEFONOS
		ADD tipoTelefono VARCHAR(8) CONSTRAINT CHK_TIPOTELEFONO
									CHECK (tipoTelefono IN('ALUMNO', 'PROFESOR'));
									
	ALTER TABLE TELEFONOS
		DROP FK_TFNO_PROFE_PROFESOR;