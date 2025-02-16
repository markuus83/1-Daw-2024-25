CREATE DATABASE BD_ACADEMIA_EXAME_MarcosCh;
GO
USE BD_ACADEMIA_EXAME_MarcosCh;
USE BD_EUROVISION;
GO

create TABLE edicion(

	numero smallint not null,
	fecha_hora_inicio datetime not null,

	CONSTRAINT PK_edicion_numero PRIMARY KEY (numero),
);


CREATE TABLE empleado(

	codigo tinyint not null,
	tipo_doc varchar(5) not null,
	num_doc varchar(15) not null ,
	tlfn1 char (9) null ,
	tlfn2 char (9) null,
	tlfn3 char (9) null,
	fecha_contrato  date not null,
	num_edicion smallint not null,

	CONSTRAINT PK_empleado_codigo PRIMARY KEY (codigo),

	CONSTRAINT FK_edicion_num_edicion
		FOREIGN KEY (num_edicion)
		REFERENCES edicion(numero),
);


CREATE TABLE curso(

	codigo tinyint not null,
	titulo varchar (80) not null,
	num_horas tinyint not null,
	num_edicion smallint not null,

	CONSTRAINT PK_curso_codigo PRIMARY KEY (codigo),
	CONSTRAINT UQ_curso_titulo UNIQUE (titulo),

	CONSTRAINT FK_edicion_num_edicion
		FOREIGN KEY (num_edicion)
		REFERENCES EDICION (numero),
);


CREATE TABLE prerrequisito(

	tipo char(1) null,
	cod_prerrequisito_de tinyint not null,

);



------- CLAVES FORÁNEAS
