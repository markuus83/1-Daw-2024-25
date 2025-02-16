create database Ejercicio_5;
use Ejercicio_5;


create table empleado (

	numero INT NOT NULL,
	nif CHAR (9) NOT NULL,
	salario DECIMAL(4,2) NOT NULL,
	cargo CHAR(3) NOT NULL,
	ccc_entidad CHAR(4) NOT NULL,
	ccc_oficina CHAR (4) NOT NULL,
	ccc_dc CHAR (2) NOT NULL,
	ccc_numCuenta CHAR (10) NOT NULL ,
	nombre VARCHAR (30) NOT NULL,
	ape1 VARCHAR (30) NOT NULL,
	ape2 VARCHAR (30) NULL,
	tlfn1 CHAR (9) NULL,
	tlfn2 CHAR (9) NULL,
	
	 
	CONSTRAINT PK_empleado_numero PRIMARY KEY (numero),
	CONSTRAINT UQ_empleado_nif UNIQUE (nif),
	CONSTRAINT CHK_empleado_cargo CHECK (cargo in ('PAP', 'MON', 'REP'))


);


create table PERSONAL_AP (
	num_PersonalAP int not null,
	objetivoVentas decimal (8,3) not null,
	funcion char(3) not null
);

alter table PERSONAL_AP

add constraint PK_personal_ap_num_PersonalAP primary key (num_personalAP),
	constraint DF_personal_ap_objetivoVentas default 0 for objetivoVentas,
	constraint CHK_personal_ap_objetivoVentas_rango check(objetivoVentas between 0 and 15000.999);



create table montador (

	num_montador INT NOT NULL,
	
	CONSTRAINT PK_montador_num_montador PRIMARY KEY (num_montador),

);


create table repartidor (

	num_repartidor INT NOT NULL,

	CONSTRAINT PK_repartidor_num_repartidor PRIMARY KEY (num_repartidor),

);


create table mueble(

	identificador SMALLINT NOT NULL,
	marca VARCHAR(50) NOT NULL,
	precio DECIMAL(7,2) NOT NULL,
	fechaFabricacion DATE NULL,
	num_montador INT NULL,

	CONSTRAINT PK_mueble_identificador PRIMARY KEY (identificador),
	CONSTRAINT CHK_mueble_precio_maximo CHECK (precio BETWEEN 0 AND 20000.55),
	CONSTRAINT CHK_mueble_fechaFabricacion CHECK (fechaFabricacion >= '01/01/2000')


);
 

create table entrega (

	fechaHoraEntrega DATETIME NOT NULL,
	fechaHoraDevolucion DATETIME NULL,
	
	num_repartidor INT NOT NULL,
	id_mueble SMALLINT NOT NULL,

	CONSTRAINT PK_entrega_fechaHoraEntrega_num_repartidor_id_mueble PRIMARY KEY (fechaHoraEntrega, num_repartidor, id_mueble),
	CONSTRAINT CHK_entrega_entrega_controlfechas CHECK (fechaHoradevolucion>fechaHoraEntrega)
);


create table vendedor (

	num_vendedor INT NOT NULL,

	CONSTRAINT PK_vendedor_num_vendedor PRIMARY KEY (num_vendedor),

);


create table vigila (

	num_vendedor INT NOT NULL,
	num_vigilante INT NOT NULL,

	CONSTRAINT PK_vigila_vendedor_num_vendedor PRIMARY KEY (num_vendedor),
	CONSTRAINT UQ_vigila_num_vigilante UNIQUE (num_vigilante)
 

);


-------------------------------------------- CLAVES FORÁNEAS -------------------------------------------- 

--TABLA PERSONAL

ALTER TABLE personal_ap
ADD

	CONSTRAINT FK_empleado_num_personalAP
	FOREIGN KEY (num_personalAP)
	REFERENCES empleado (numero)
	ON DELETE NO ACTION
	ON UPDATE CASCADE;

	

-- TABLA MONTADOR

ALTER TABLE montador
ADD

	CONSTRAINT FK_empleado_num_montador
	FOREIGN KEY (num_montador)
	REFERENCES empleado (numero)
	ON DELETE NO ACTION
	ON UPDATE CASCADE;



-- TABLA REPARTIDOR

ALTER TABLE repartidor
ADD

	CONSTRAINT FK_empleado_num_repartidor
	FOREIGN KEY (num_repartidor)
	REFERENCES empleado (numero)
	ON DELETE NO ACTION
	ON UPDATE CASCADE;


-- TABLA VENDEDOR

ALTER TABLE vendedor 
ADD

	CONSTRAINT FK_vendedor_personal_ap_num_vendedor FOREIGN KEY (num_vendedor) REFERENCES personal_AP (num_PersonalAP)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION;


-- TABLA ENTREGA

ALTER TABLE entrega
ADD

	CONSTRAINT FK_repartidor_num_repartidor
	FOREIGN KEY (num_repartidor)
	REFERENCES repartidor (num_repartidor)
	ON DELETE NO ACTION
	ON UPDATE CASCADE,

	CONSTRAINT FK_entrega_mueble_id_mueble
	FOREIGN KEY (id_mueble)
	REFERENCES mueble (identificador)
	ON DELETE NO ACTION
	ON UPDATE CASCADE;


-- TABLA MUEBLE

ALTER TABLE mueble
ADD

	CONSTRAINT FK_mueble_montador_num_montador FOREIGN KEY (num_montador) REFERENCES MONTADOR(num_montador)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION;


-- TABLA VIGILA

ALTER TABLE vigila
ADD

	CONSTRAINT FK_vigila_vendedor_num_vendedor FOREIGN KEY (num_vendedor) REFERENCES VENDEDOR(num_vendedor)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION,

	CONSTRAINT FK_vigila_vendedor_num_vigilante FOREIGN KEY (num_vigilante) REFERENCES VENDEDOR(num_vendedor)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION;
