CREATE DATABASE BD_MUEBLERIA_MarcosCh;
GO
USE BD_MUEBLERIA_MarcosCh;
go


-- CREACIÓN DE TABLAS

CREATE TABLE empleado (

	numero INT NOT NULL,
	nif CHAR (9) NOT NULL,
	nombre VARCHAR(30) NOT NULL,
	ape1 VARCHAR(30) NOT NULL,
	ape2 VARCHAR(30) NULL,
	ccc_entidad CHAR (4) NOT NULL,
	ccc_oficina CHAR (4) NOT NULL,
	ccc_dc CHAR (2) NOT NULL,
	ccc_NumCuenta CHAR (10) NOT NULL,
	tlfn1 VARCHAR (9) NULL,
	tlfn2 VARCHAR (9) NULL,
	salario DECIMAL (4,2) NOT NULL,
	cargo CHAR (3) NOT NULL

	CONSTRAINT PK_empleado_numero PRIMARY KEY (numero),
	CONSTRAINT UQ_empleado_nif UNIQUE (nif)
);


CREATE TABLE personal_ap (
	
	num_personalAp INT NOT NULL,
	objetivoVentas DECIMAL (5,3),
	funcion CHAR(3) NOT NULL,

	CONSTRAINT PK_personal_ap_num_personalAP PRIMARY KEY (num_personalAp),

);


CREATE TABLE montador (

	num_Montador INT NOT NULL,
	id_mueble SMALLINT NOT NULL

	CONSTRAINT PK_montador_num_Montador PRIMARY KEY (num_Montador),

);


CREATE TABLE repartidor (

	num_Repartidor INT NOT NULL,

	CONSTRAINT PK_repartidor_num_Repartidor PRIMARY KEY (num_Repartidor),

);


CREATE TABLE entrega (

	fechaHoraEntrega DATETIME NOT NULL,
	fechaHoraDevolucion DATETIME NULL,

	CONSTRAINT PK_entrega_fechaHoraEntrega PRIMARY KEY (fechaHoraEntrega),

);


CREATE TABLE mueble (

	identificador SMALLINT NOT NULL,
	marca VARCHAR (50) NOT NULL,
	precio DECIMAL (5,2) NOT NULL,
	fechaFabricacion DATE NULL,
	num_Montador INT NOT NULL,

	CONSTRAINT PK_mueble_identificador PRIMARY KEY (identificador),

);


CREATE TABLE vendedor (

	num_vendedor INT NOT NULL,

	CONSTRAINT PK_vendedor_num_vendedor PRIMARY KEY (num_vendedor)

);


CREATE TABLE vigila (

	num_vendedor_vigilado_por INT NOT NULL,

);




-- CLAVES FORÁNEAS EONO--

	-- FK_"nombre tabla de donde viene"_"nombre atributo en tabla de donde es foránea"
	--		FOREIGN KEY ("nombre atributo")
	--		REFERENCES "nombre tabla de donde viene"("nombre atributo de la tabla principal"),

--TABLA PERSONAL_AP 

ALTER TABLE personal_ap
ADD

	CONSTRAINT FK_empleado_num_PersonalAp
		FOREIGN KEY (num_PersonalAp)
		REFERENCES empleado(numero);

--TABLA MONTADOR

ALTER TABLE montador
ADD

	CONSTRAINT FK_empleado_num_Montador
		FOREIGN KEY (num_montador)
		REFERENCES empleado(numero);

--TABLA REPARTIDOR

ALTER TABLE repartidor
ADD

	CONSTRAINT FK_empleado_num_Repartidor
		FOREIGN KEY (num_Repartidor)
		REFERENCES empleado(numero);

--TABLA MUEBLE

ALTER TABLE mueble
ADD

	CONSTRAINT FK_montador_num_Montador
		FOREIGN KEY (num_Montador)
		REFERENCES montador(numero);


