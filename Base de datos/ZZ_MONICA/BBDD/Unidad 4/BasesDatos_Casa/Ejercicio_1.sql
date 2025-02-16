CREATE DATABASE Ejercicio_1;
GO
USE Ejercicio_1;

CREATE TABLE interprete (

	numero INT NOT NULL,
	nombre VARCHAR(40) NOT NULL,
	fechanac DATE NULL,
	num_cancion INT NOT NULL,

	CONSTRAINT PK_interprete_numero PRIMARY KEY (numero),
	CONSTRAINT UQ_interprete_nombre UNIQUE (nombre),

--METER LOS CHECKS (FALTA POR HACER)
);


CREATE TABLE cancion (

	numero INT NOT NULL,
	titulo VARCHAR(80) NOT NULL,
	id_pais INT NOT NULL,

	CONSTRAINT PK_cancion_numero PRIMARY KEY (numero),

-- REVISAR Y ENTENDER ESTE UNIQUE
	CONSTRAINT UQ_cancion_id_pais UNIQUE (id_pais),

);


CREATE TABLE pais (

	identificador INT NOT NULL,
	denominacion VARCHAR (70) NOT NULL,
	
	CONSTRAINT PK_pais_identificador PRIMARY KEY (identificador),
	CONSTRAINT UQ_pais_denominacion UNIQUE (denominacion),
	
);


CREATE TABLE votacion (

	puntos INT NOT NULL,
	id_pais_votado INT NOT NULL,
	id_pais_votante INT NOT NULL,

	CONSTRAINT  PK_votacion PRIMARY KEY (id_pais_votante, id_pais_votado),
	

);

------ CLAVES FORÁNEAS

alter table interprete 
add constraint FK_interprete_cancion
foreign key(num_cancion)
references cancion(numero)
on update cascade;




alter table cancion
add constraint FK_cancion_pais
foreign key(id_pais)
references pais(identificador)
on update cascade;




alter table votacion
add constraint FK_votacion_pais_votante
foreign key(id_pais_votante)
references pais(identificador),
constraint FK_votacion_pais_votado
foreign key(id_pais_votado)
references pais(identificador);


