CREATE DATABASE a23MarcosCC_MazaricosBD;

GO

USE a23MarcosCC_MazaricosBD;


CREATE TABLE DEPARTAMENTO(

	Cod_Dept TINYINT PRIMARY KEY,
	Nome_Dept VARCHAR(30) NOT NULL

);


CREATE TABLE CATEGORIA (

	Cod_Cat TINYINT PRIMARY KEY,
	Nome_Cat VARCHAR(30) NOT NULL,
	Soldo SMALLMONEY NOT NULL,
	Desconto DECIMAL(5, 2) NOT NULL,
	Prezo_H_Extr SMALLMONEY NOT NULL

);


CREATE TABLE CLIENTE (

	CIF TINYINT PRIMARY KEY,
	Nome_Cli VARCHAR(30) NOT NULL,
	Enderezo VARCHAR(30),
	Telefono CHAR(9)

);


CREATE TABLE APLICACION (

	Cod_Aplic TINYINT PRIMARY KEY,
	Nome_Aplic VARCHAR(30) NOT NULL,
	CIF TINYINT NOT NULL,
	
	CONSTRAINT FK_CIF_APLICACION FOREIGN KEY(CIF) REFERENCES CLIENTE(CIF) ON UPDATE CASCADE ON DELETE NO ACTION
	
);


CREATE TABLE EMPREGADO (

	DNI VARCHAR(9) PRIMARY KEY,
	NSS VARCHAR(11) NOT NULL,
	Nome_Empreg VARCHAR(30) NOT NULL,
	Enderezo VARCHAR(30),
	Telefono CHAR(9),
	Horas_Extr SMALLMONEY,
	Cod_Dept TINYINT NOT NULL,
	Cod_Cat TINYINT NOT NULL,

	CONSTRAINT FK_COD_DEPT_EPREGADO FOREIGN KEY (Cod_Dept) REFERENCES DEPARTAMENTO(Cod_Dept) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT FK_COD_CAT_EMPREGADO FOREIGN KEY (Cod_Cat) REFERENCES CATEGORIA (Cod_Cat) ON UPDATE CASCADE ON DELETE NO ACTION
);


CREATE TABLE PROXECTO (

	Cod_Proxec TINYINT,
	Cod_Aplic TINYINT,
	Nome_Proxect VARCHAR(30) NOT NULL,
	Horas_estimadas SMALLINT,
	Horas_Reais SMALLINT,

	CONSTRAINT PK_PROXECTO PRIMARY KEY (Cod_Proxec, Cod_Aplic),
	CONSTRAINT FK_COD_APLICAC_PROXECTO FOREIGN KEY (Cod_Aplic) REFERENCES APLICACION (Cod_Aplic) ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE TRABALLA (

	Cod_Aplic TINYINT,
	Cod_Proxec TINYINT,
	DNI VARCHAR(9),
	
	CONSTRAINT PK_TRABALLA PRIMARY KEY (Cod_Aplic, Cod_Proxec, DNI),

	-- HACER LAS FOREIGN KEY PARA CAD ATRIBUTO DE LA TABLA DE ESTA BBDD--
	-- Vemos que en "REFERENCES PROXECTO(Cod_Proxec, Cod_Aplic)" tenemos que seguir el orden de la tabla PROXECTO.
	CONSTRAINT FK_COD_APLIC_TRABALLA FOREIGN KEY (Cod_Aplic, Cod_Proxec) REFERENCES PROXECTO(Cod_Proxec, Cod_Aplic) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FK_DNI_TRABALLA FOREIGN KEY (DNI) REFERENCES EMPREGADO(DNI) ON UPDATE CASCADE ON DELETE CASCADE
);