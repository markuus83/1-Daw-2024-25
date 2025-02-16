CREATE DATABASE Ejercicio_3
go
USE Ejercicio_3
go


CREATE TABLE empleado (

	codigo TINYINT NOT NULL,
	tipo_doc CHAR(5) NOT NULL,
	num_doc VARCHAR(15) NOT NULL,
	tlfn1 CHAR (9) NULL,
	tlfn2 CHAR (9) NULL,
	tlfn3 CHAR (9) NULL,
	fecha_contrato DATE NOT NULL,

	CONSTRAINT PK_empleado_codigo PRIMARY KEY (codigo),
	
);


CREATE TABLE edicion (

	numero SMALLINT NOT NULL,
	fecha_hora_inicio DATETIME NOT NULL,
	cod_empleado TINYINT NOT NULL,
	cod_curso TINYINT NOT NULL,


);



CREATE TABLE curso (

	codigo TINYINT NOT NULL,
	titulo VARCHAR(80) NOT NULL
	num_horas TINYINT NOT NULL
	num_edicion SMALLINT NOT NULL,


);



CREATE TABLE prerrequisito (

	tipo CHAR(1) NULL,


);




