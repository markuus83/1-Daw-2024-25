CREATE DATABASE BS_LIGA_MarcosCh;
GO
USE BS_LIGA_MarcosCh;
GO

-- CREACION DE LAS TABLAS

create table division(

	codigo int not null,
	nombre varchar(70) not null,
	categoria char (4) CONSTRAINT DF_division_categoria default '1DIV',

	CONSTRAINT PK_division_codigo PRIMARY KEY (codigo),
	CONSTRAINT UQ_division_nombre UNIQUE (nombre),
	
);


create table equipo(

	identificador int not null ,
	nombre varchar(30) not null,
	CIF char(9) not null,
	presupuesto decimal (12,2) not null,
	cod_division int not null,
	
	CONSTRAINT PK_equipo_identificador PRIMARY KEY (identificador),
	CONSTRAINT UQ_equipo_nombre UNIQUE (nombre),
	CONSTRAINT UQ_equipo_CIF UNIQUE (CIF),

	CONSTRAINT FK_division_cod_division 
		FOREIGN KEY (cod_division) 
		REFERENCES DIVISION (codigo),

);


create table partido(

	fechaHora datetime not null,
	observaciones varchar(150) null,
	id_equipo_local int not null,
	id_equipo_visitante int not null,
	
	CONSTRAINT PK_partido_fechaHora PRIMARY KEY (fechaHora),

	CONSTRAINT FK_equipo_id_equipo_local 
		FOREIGN KEY (id_equipo_local) 
		REFERENCES EQUIPO (identificador),

	CONSTRAINT FK_equipo_id_equipo_visitante
		FOREIGN KEY (id_equipo_visitante) 
		REFERENCES EQUIPO (identificador),

);


create table campo(

	numero int not null,
	nombre varchar (100) not null,
	capacidad int not null,
	id_equipo int not null,

	CONSTRAINT PK_campo_numero PRIMARY KEY (numero),
	CONSTRAINT UQ_campo_nombre UNIQUE (nombre),

	CONSTRAINT FK_equipo_id_equipo
		FOREIGN KEY (id_equipo)
		REFERENCES EQUIPO (identificador),

	CONSTRAINT CHK_control_capacidad check (capacidad <= 500)
);