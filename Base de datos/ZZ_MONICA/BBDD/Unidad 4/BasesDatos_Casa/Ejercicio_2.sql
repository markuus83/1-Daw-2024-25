CREATE DATABASE Ejercicio_2;
go
USE Ejercicio_2
go

CREATE TABLE partido (

	fechaHora DATETIME NOT NULL,
	observaciones VARCHAR (150) NULL,
	id_equipo_juega_visitante INT NOT NULL,

	CONSTRAINT PK_partido_fechaHora PRIMARY KEY (fechaHora),
	CONSTRAINT UQ_partido_id_equipo_juega_visitante  UNIQUE (id_equipo_juega_visitante ),

);


CREATE TABLE equipo (

	identificador INT NOT NULL,
	nombre VARCHAR (30) NOT NULL,
	cif CHAR (9) NOT NULL,
	presupuesto DECIMAL(14,2) NOT NULL,
	cod_division INT NOT NULL,

	CONSTRAINT PK_equipo_identificador PRIMARY KEY (identificador),
	CONSTRAINT UQ_equipo_nombre_cif UNIQUE (nombre, cif),

);


CREATE TABLE division (

	codigo INT NOT NULL,
	nombre VARCHAR(70) NOT NULL,
	categoria CHAR(4) NULL,

	CONSTRAINT PK_division_codigo PRIMARY KEY (codigo),
	CONSTRAINT UQ_divisiom_nombre UNIQUE (nombre),

);


CREATE TABLE campo (

	numero INT NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	capacidad INT NOT NULL,
	id_equipo INT NOT NULL,

	CONSTRAINT PK_campo_numero PRIMARY KEY (numero),
	CONSTRAINT UQ_campo_nombre UNIQUE (nombre),

);


-------------------------------------- CLAVES FORÁNEAS --------------------------------------


ALTER TABLE partido
ADD

	CONSTRAINT FK_id_equipo_juega_visitante
	FOREIGN KEY (id_equipo_juega_visitante)
	REFERENCES equipo (identificador)

;



ALTER TABLE equipo
ADD

	CONSTRAINT FK_cod_division
	FOREIGN KEY (cod_division)
	REFERENCES division (codigo)

;



ALTER TABLE campo
ADD

	CONSTRAINT FK_id_equipo
	FOREIGN KEY (id_equipo)
	REFERENCES equipo (identificador)

;