CREATE DATABASE Ejercicio_Examen;
USE Ejercicio_Examen;


CREATE TABLE medioTransporte (

	codigo INT NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	tipo CHAR(3) NOT NULL,

	CONSTRAINT PK_medioTransporte_codigo PRIMARY KEY (codigo),
	CONSTRAINT UQ_medioTransporte_nombre UNIQUE (nombre),

);



CREATE TABLE persona (

	numero SMALLINT NOT NULL,
	tipoDoc VARCHAR(5) NOT NULL,
	numDoc VARCHAR(5) NOT NULL,
	nombre VARCHAR(30) NOT NULL,
	ape1 VARCHAR(30) NOT NULL,
	ape2 VARCHAR(30) NULL,
	tlfn1 VARCHAR(9) NULL,
	tlfn2 VARCHAR(9) NULL,
	tlfn3 VARCHAR(9) NULL,
	cod_MTransporte_Privado SMALLINT NOT NULL,
	fechaCompra DATETIME NULL,

	-- CLAVES FORÁNEAS

	cod_MTransporte_Colectivo SMALLINT NOT NULL,

	CONSTRAINT PK_persona_numero PRIMARY KEY (numero),
	CONSTRAINT UQ_persona_docID_tipoDoc_numDoc UNIQUE (numDoc, tipoDoc, cod_MTransporte_Privado),
	CONSTRAINT UQ_persona_cod_MTransporte_Privado UNIQUE (cod_MTransporte_Privado),
	CONSTRAINT CHK_persona_tipoDoc CHECK (tipoDoc IN ('NIF','NIE', 'PASAP' , 'DOCUE')),
);



CREATE TABLE conducidoPor (

	-- CLAVES FORÁNEAS

	cod_MedioTransporte INT NOT NULL,
	num_persona SMALLINT NOT NULL,

	CONSTRAINT PK_conducidoPor_cod_MedioTransporte_num_persona PRIMARY KEY (cod_MedioTransporte, num_persona),
);



CREATE TABLE medioPrivado (

	cod_MTransporte_Privado SMALLINT NOT NULL,

	CONSTRAINT PK_medioPrivado_cod_MTransporte_Privado PRIMARY KEY (cod_MTransporte_Privado),

);



CREATE TABLE medioColectivo (

	cod_MTransporte_Colectivo SMALLINT NOT NULL,
	precio DECIMAL(5,2) NOT NULL,
	IVA numeric (3,2) not null,
	importeBillete as(precio*(1+IVA)),
	
	CONSTRAINT PK_medioColectivo_cod_MTransporte_Colectivo PRIMARY KEY (cod_MTransporte_Colectivo),
	CONSTRAINT CHK_medioColectivo_precio_colectivo CHECK (precio >=0),
	CONSTRAINT CHK_medioColectivo_rango_iva CHECK (IVA BETWEEN 0 AND 0.21),
	

);



CREATE TABLE parada (

	numero TINYINT NOT NULL,
	descripcion VARCHAR(70) NOT NULL,

	-- CLAVES FORÁNEAS

	cod_MTransporte_Colectivo SMALLINT NOT NULL,

	CONSTRAINT PK_parada_numero PRIMARY KEY (numero),
	CONSTRAINT UQ_parada_cod_MTransporte_Colectivo UNIQUE (cod_MTransporte_Colectivo),
);



CREATE TABLE marquesina (

	identificador TINYINT NOT NULL,
	nombreVia VARCHAR(200) NOT NULL,
	numeroVia TINYINT NOT NULL,

	CONSTRAINT PK_marquesina_identificador PRIMARY KEY (identificador)

);


CREATE TABLE realizadaEn (

	-- CLAVES FORÁNEAS

	num_parada TINYINT NOT NULL,
	id_marquesina TINYINT NOT NULL,
	cod_MTransporte_Colectivo SMALLINT NOT NULL,

	CONSTRAINT PK_realizadaEn_num_parada PRIMARY KEY (num_parada),
	CONSTRAINT UQ_realizadaEn_id_marquesina_cod_MTransporte_Colectivo UNIQUE (id_marquesina, cod_MTransporte_Colectivo)
); 


-- CLAVES FORÁNEAS TOTALES

--MEDIO DE TRANSPORTE 

ALTER TABLE persona
ADD

	CONSTRAINT FK_medioPrivado_cod_MTransporte_Colectivo
	FOREIGN KEY (cod_MTransporte_Colectivo)
	REFERENCES medioPrivado (cod_MTransporte_Colectivo);


-- CONDUCIDO POR
ALTER TABLE conducidoPor
ADD

	CONSTRAINT FK_medioTransporte_cod_MedioTransporte
	FOREIGN KEY (cod_MedioTransporte)
	REFERENCES medioTransporte (codigo),

	CONSTRAINT FK_persona_num_persona
	FOREIGN KEY (num_persona)
	REFERENCES persona (numero);


-- PARADA
ALTER TABLE parada
ADD

	CONSTRAINT FK_medioColectivo_cod_MTransporte_Colectivo
	FOREIGN KEY (cod_MTransporte_Colectivo)
	REFERENCES medioColectivo (cod_MTransporte_Colectivo);


-- REALIZADAEN
ALTER TABLE realizadaEn
ADD

	CONSTRAINT FK_parada_num_parada
	FOREIGN KEY (num_parada)
	REFERENCES parada (numero) ,

	CONSTRAINT FK_marquesina_is_marquesina
	FOREIGN KEY (id_marquesina)
	REFERENCES marquesina (identificador),

	CONSTRAINT FK_medioTransporte_cod_MTransporte_Colectivo
	FOREIGN KEY (cod_MTransporte_Colectivo)
	REFERENCES medioTransporte (codigo),



