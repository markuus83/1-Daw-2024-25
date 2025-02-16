CREATE DATABASE BD_EUROVISION_MarcosCh;
GO
USE BD_EUROVISION_MarcosCh;
GO
-- *************ESTA PARTE LA HA HECHO MÓNICA*************

create table interprete(

	numero int not null,
	nombre varchar (40) not null,
	fechanac date null,
	num_cancion int not null,

	CONSTRAINT PK_interprete_numero PRIMARY KEY(numero),
	CONSTRAINT UQ_interprete_nombre UNIQUE (nombre),
	CONSTRAINT CHK_interprete_edad_minima CHECK (datediff(year,fechanac,getdate()) > 15  )
);

create table cancion(

	numero int not null,
	titulo varchar (80) not null,
	id_pais int not null,

	CONSTRAINT PK_cancion_numero PRIMARY KEY(numero),
	CONSTRAINT UQ_cancion_id_pais UNIQUE (id_pais),
);

create table pais(

	identificador int not null,
	denominacion varchar(70) not null,
	
	CONSTRAINT PK_pais_identificador PRIMARY KEY(identificador),
	CONSTRAINT UQ_pais_denominacion UNIQUE (denominacion),
);

create table votacion(

	id_pais_votante int not null,
	id_pais_votado int not null,
	puntos int not null CONSTRAINT DF_votacion_puntos DEFAULT (0),
	
	CONSTRAINT PK_votacion_id_pais_votado_id_pais_votante PRIMARY KEY(id_pais_votante,id_pais_votado),
);

-- OTRO MODO DE HACERLO SERÍA:
--ALTER TABLE votacion ADD CONTRAINT DF_votacion_puntos DEFAULT (0) FOR puntos;	

--/CLAVES FORÁNEAS
