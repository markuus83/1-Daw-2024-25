create database a23marcos_Taxis_Garaxes;

GO

use a23marcos_Taxis_Garaxes;


CREATE TABLE MODELO (

	cod_Modelo char(4) primary key,
	nome_Modelo varchar(30) not null,
	marca varchar(30) not null,
	potencia smallint

);



CREATE TABLE TAXI (

	matricula char(7) primary key,
	data_merca date,
	prezo smallmoney,
	cod_Modelo char(4) not null,
	
	constraint FK_Cod_Modelo_Taxi
	foreign key (cod_Modelo)
	references MODELO(cod_Modelo)
	on update cascade on delete no action

);



CREATE TABLE GARAXE (

	cod_Garaxe char(4) primary key,
	enderezo varchar(30) not null,
	n_Prazas smallint,

);



CREATE TABLE CHOFER (

	NIF char(9) primary key constraint CKNIF check (NIF LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]'),
	nome varchar(30) not null,
	apellidos varchar(30) not null

);



CREATE TABLE INCIDENTE (

	matricula char(7),
	data date,
	hora datetime,
	tipo varchar(30),
	concepto varchar(30),
	custe decimal(12, 2),
	
	constraint PK_Incidente
	primary key (matricula, data, hora, tipo),
	
	constraint FK_Matricula_Incidente
	foreign key (matricula)
	references TAXI(matricula)
	on update cascade on delete cascade

);



CREATE TABLE GARDASE (

	matricula char(7),
	cod_Garaxe char(4),
	data date,
	hora_e datetime2,
	hora_s datetime2,
	praza smallint,

	constraint PK_Gardase
	primary key (matricula, cod_Garaxe, data, hora_e, hora_s),
	
	
	constraint FK_Matricula_Gardase
	foreign key (matricula)
	references TAXI(matricula)
	on update cascade on delete cascade,
	
	constraint FK_Cod_Garaxe_Gardase
	foreign key (cod_Garaxe)
	references GARAXE(cod_Garaxe)
	on update cascade on delete cascade
);



CREATE TABLE SERVIZO (

	matricula char(7),
	NIF char(9) constraint CKNIF2 check (NIF LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]'),
	data_ini date,
	hora_ini datetime2,
	data_fin date,
	hora_fin datetime,
	lugar_ini varchar(30) not null,
	lugar_fin varchar(30),
	prezo smallmoney,

	constraint PK_Servizo
	primary key (matricula, NIF, data_ini, hora_ini),
	
	constraint FK_Matricula_Servizo
	foreign key (matricula)
	references TAXI(matricula)
	on update cascade on delete cascade,
	
	constraint FK_NIF_Servizo
	foreign key (NIF)
	references CHOFER(NIF)
	on update cascade on delete cascade,
);


CREATE TABLE ACCIDENTE (

	matricula char(7),
	NIF char(9) constraint CKNIF3 check (NIF LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]'),
	lugar varchar(30),
	custe smallmoney,
	
	constraint PK_Accidente
	primary key (matricula, NIF),
	
	constraint FK_Matricula_Accidente
	foreign key (matricula)
	references TAXI(matricula)
	on update cascade on delete cascade,
	
	constraint FK_NIF_Accidente
	foreign key (NIF)
	references CHOFER(NIF)
	on update cascade on delete cascade,

);
