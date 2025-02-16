CREATE DATABASE BD_VIDEOTECA_MarcosCh;
GO
USE BD_VIDEOTECA_MarcosCh;
GO


CREATE TABLE productora (

	identificador SMALLINT NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	cod_pelicula INT NOT NULL,

	CONSTRAINT PK_productora_identificador PRIMARY KEY (identificador),
	CONSTRAINT UQ_productora_nombre UNIQUE (nombre),
);


CREATE TABLE pelicula (

	codigo INT NOT NULL,
	titulo VARCHAR(150) NOT NULL,
	fechaEstreno DATE NULL,

	CONSTRAINT PK_pelicula_codigo PRIMARY KEY (codigo),
	CONSTRAINT UQ_pelicula_titulo UNIQUE (titulo),
);


CREATE TABLE copia (

	numero INT NOT NULL,
	formato CHAR(1) NOT NULL,
	cod_pelicula_copia INT NOT NULL,

	CONSTRAINT PK_copia_numero PRIMARY KEY (numero),

);


CREATE TABLE caja (

	numero TINYINT NOT NULL,
	estanteria TINYINT NOT NULL,
	balda TINYINT NOT NULL,

	CONSTRAINT PK_caja_numero PRIMARY KEY (numero),
);


CREATE TABLE alquila (

	num_copia TINYINT NOT NULL,
	cod_socio INT NOT NULL,
	cod_pelicula INT NOT NULL,

	CONSTRAINT PK_alquila_num_copia_cod_socio_cod_pelicula PRIMARY KEY (num_copia, cod_socio, cod_pelicula)


);


CREATE TABLE persona (

	codigo INT NOT NULL,
	numDoc VARCHAR (15) NOT NULL,
	tipoDoc VARCHAR(5) NOT NULL,
	nombre VARCHAR(30) NOT NULL,
	ape1 VARCHAR(30) NOT NULL,
	ape2 VARCHAR (30) NULL,
	tipo CHAR(3) NOT NULL 
	-- ACRDARME DE HACERLE EL CHECK

	CONSTRAINT PK_persona_codigo PRIMARY KEY (codigo),
	CONSTRAINT UQ_persona_tipoDoc_numDoc UNIQUE (tipoDoc, numDoc),
	
);


CREATE TABLE socio (

	cod_socio INT NOT NULL,

	CONSTRAINT PK_socio_cod_socio PRIMARY KEY (cod_socio),
);


CREATE TABLE empleado (

	cod_empleado INT NOT NULL,

	CONSTRAINT PK_empleado_cod_empleado PRIMARY KEY (cod_empleado),
);


CREATE TABLE manda_en (

	cod_empleado_supervisado_por INT NOT NULL,

);



-------------------------- CLAVES FORÁNEAS DE TODA LA BASE DE DATOS -------------------------- 