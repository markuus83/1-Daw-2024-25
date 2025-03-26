-- Base de Datos Veterinario
--*****************************


DROP DATABASE IF EXISTS   Veterinario_DAW_25;
GO
CREATE DATABASE Veterinario_DAW_25;
GO
USE Veterinario_DAW_25;




CREATE TABLE COLABORADORES(
	Codigo_C		INT  PRIMARY KEY,
    Dni 			CHAR(9) NOT NULL  CONSTRAINT UNQ_DNIC UNIQUE  
									  CONSTRAINT CHK_FORMAC CHECK(DNI LIKE   
									  ('[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]')),
    Nombre 			CHAR(20) not null,    -- Requerido Administrador
    Ape1  	        CHAR(20) not null,    -- Requerido Administrador
    Ape2 	        CHAR(20),
	Fehca_A			DATE,
    Domicilio 		VARCHAR(30),
    Aportadores		BIT  NOT NULL,
	Voluntarios		BIT  NOT NULL,
	Donadores		BIT  NOT NULL,
);


--1.- Que informaci�n nos da tabla Colaboradores? La 



CREATE TABLE APORTADORES (
    Codigo_C	INT,
  	Cantidad	TINYINT				CONSTRAINT CHK_CANTIDAD CHECK (Cantidad  BETWEEN 100 AND 200),
    PRIMARY KEY (Codigo_C),
    CONSTRAINT  FK_APORTADOR FOREIGN KEY (Codigo_C) REFERENCES Colaboradores(Codigo_C)
	ON UPDATE CASCADE ON DELETE CASCADE		-- Por ser un Colaborador
);

CREATE TABLE VOLUNTARIOS (
    Codigo_C INT,
    PRIMARY KEY (Codigo_C),
    CONSTRAINT FK_VOLUNTARIO FOREIGN KEY (Codigo_C) REFERENCES Colaboradores(Codigo_C)
	ON UPDATE CASCADE ON DELETE CASCADE		-- Por ser un Colaborador
);


CREATE TABLE DONADORES (
    Codigo_C	INT,
	NumSocio	CHAR(10) NOT NULL	CONSTRAINT UNQ_NUMSOC UNIQUE,
    PRIMARY KEY (Codigo_C),
    CONSTRAINT FK_DONADOR FOREIGN KEY (Codigo_C) REFERENCES Colaboradores(Codigo_C)
	ON UPDATE CASCADE ON DELETE CASCADE		-- Por ser un Colaborador
);


--2.- A la vista de la soluci�n que han hecho, �qu� opinas de esta? �Se podr�a realizar de
--otra forma?



CREATE TABLE PERSONAL (
    Codigo_P SMALLINT PRIMARY KEY,
    Dni		 CHAR(9)  NOT NULL   CONSTRAINT UNQ_DNIP UNIQUE 
								 CONSTRAINT CHK_FORMAP CHECK(DNI LIKE   
									  ('[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]')),		-- Requerido Administrador
    Nombre	 CHAR(30) NOT NULL ,	-- Requerido Administrador
    Ape1	 CHAR(30) NOT NULL,		-- Requerido Administrador
    Ape2     CHAR(30),
    Turno    CHAR(1) NOT NULL CONSTRAINT DF_TURNO DEFAULT 'M' ,  -- Requerido Administrador
	Tipo     CHAR(1) NOT NULL CONSTRAINT CHK_TIPOPERSONAL CHECK(tipo IN('E','G')),

);


CREATE TABLE TELEFONOS (
    Codigo_P SMALLINT,
	Telefono CHAR(9),
    PRIMARY KEY (Codigo_P, Telefono),
    FOREIGN KEY (Codigo_P) REFERENCES PERSONAL(codigo_P) ON UPDATE CASCADE ON DELETE CASCADE -- POR DEPENDIENTE
);


CREATE TABLE RAZAS (
	Cod_Raza     SMALLINT PRIMARY KEY,
	Nombre       CHAR(30),
	Descripcion  VARCHAR(100), 
	Cod_SubRaza  SMALLINT  
	CONSTRAINT FK_RAZA FOREIGN KEY (Cod_SubRaza) REFERENCES RAZAS 
	ON UPDATE NO ACTION ON DELETE NO ACTION
	);	

	--La recursiva no permite los comportamientos del enunciado, NO ACTION en las dos.

	--3.- Que podr�as decir de las Razas seg�n su tabla?

	
CREATE TABLE ANIMALES (
    Cod_Animal		INT				IDENTITY(100,2) PRIMARY KEY,
	Nombre			CHAR(30)		NOT NULL,									 -- Requerido Administrador
    Fecha_Donacion	DATE			Not Null CONSTRAINT DF_FECDONA DEFAULT GETDATE(),-- Requerido Administrador																	 
    Fecha_Acogida	DATE ,														 
    Codigo_P    	SMALLINT		NOT NULL CONSTRAINT DF_ENCARGADO DEFAULT 0,	 -- Personal Encargado
    Codigo_C		INT				NOT NULL CONSTRAINT DF_DONADOR   DEFAULT 0,	 -- Donador
	Codigo_R		SMALLINT		NOT NULL									 -- Raza
    CONSTRAINT fk_Emp_Ani FOREIGN KEY (Codigo_P)  REFERENCES PERSONAL  (Codigo_P) 
	ON UPDATE CASCADE ON DELETE SET DEFAULT, 
    CONSTRAINT fk_Don_Ani FOREIGN KEY (Codigo_C)  REFERENCES DONADORES (Codigo_C)
	ON UPDATE CASCADE ON DELETE SET DEFAULT,
	CONSTRAINT fk_Raz_Ani FOREIGN KEY (Codigo_R)  REFERENCES RAZAS (Cod_Raza) 
	ON UPDATE CASCADE ON DELETE NO ACTION
);

 
-- Las FK de Empleados  y Donadores, las pongo como dice.
-- Para ello  tengo que definir Defaults en las FK correspondientes.
-- En Raza, puedo escoger DSD o DNA. Escojo DNA.





CREATE TABLE CUIDA (
Cod_Animal  INT,
Codigo_C    INT
PRIMARY KEY (Cod_Animal, Codigo_C) 
CONSTRAINT fk_CUIDA_ANI foreign key (Cod_Animal) References  Animales	
on update cascade on delete cascade , 
CONSTRAINT fk_CUIDA_VOL foreign key (Codigo_C)   References  Voluntarios 
on update NO ACTION  ON DELETE  NO ACTION  
);

--4.- Que informaci�n nos da la tabla Cuida?


--Restricciones a�adidas en la creaci�n de las tablas  de la BD.

--a.- Los datos de los DNI tienen que tener el formato de este y no se pueden repetir.
--b.- A�adir todas la Foreings Keys necesarias y su comportamiento.
--c.- El campo Cantidad de los Aportadores estar� comprendido entre 100 y 200.
--d.- El Campo Turno de la tabla Personal tiene por defecto el valor M.
--e.- El campo Fecha_Donacion de la tabla Animales tendr� como defecto la fecha actual.
--f.- El campo clave de la tabla Animales se generar� autom�ticamente, desde 100 y de dos en dos.
--g.- Ponerle nombre a todas las restricciones que creeis menos donde pone el enunciado.
--h.- Los campos tendr�n que tener el tipo de datos y el tama�o m�s adecuado. 
--Si en alguno creeis que puede haber otras posibilidades, explicar por que cogeis esta.



--*****************************************************************
--	DDL************************************************************
--*****************************************************************

---2.- Modificar el tipo del campo Descricion de la tabla Razas a char(15) y que por defecto
--ponga 'DESCONOCIDO' de forma que no altere la estructura de la tabla.
--Comprueba con una instrucci�n que tiene la restricci�n default activa. 0.5

			SELECT  * FROM  RAZAS
-- Mal, da error
--ALTER TABLE RAZAS alter column Descricion  VARCHAR(15) default 'Desconocido';


-- Esta es la mejor opcion, ya que no alteramos la estructura de la tabla.
	ALTER TABLE RAZAS
	ALTER COLUMN DESCRIPCION  VARCHAR(15);

	ALTER TABLE RAZAS 
	ADD CONSTRAINT DefProDes DEFAULT 'DESCONOCIDO' FOR DESCRIPCION;

	select * from sys.default_constraints  razas;

	sp_help razas;





--3.- Queremos guardar el campo Profesion de los Colaboradores, a�adir el campo con el tama�o que
--querais y un valor por defecto  que sea 'Estudiante'. Hacer esta restriccion sin nombre.
--A continuacion nos parece una tonter�a ponerle el valor por defecto y se lo borramos. 0.25


	ALTER TABLE COLABORADORES 
		ADD   Profesion CHAR(30)  DEFAULT 'ESTUDIANTE';

	SELECT * FROM  COLABORADORES;
	
	
	ALTER TABLE COLABORADORES 
		DROP CONSTRAINT  DF__COLABORAD__Profe__5BE2A6F2;

-- Cada uno tendr� que buscar su nombre y borrarla.


--4.- A�adirle un nuevo campo a los colaboradores con la fecha de nacimiento y 
--que compruebe que la edad es mayor de 18 a�os.0.25

	

	ALTER TABLE COLABORADORES
		ADD Fec_Nac  DATE  CONSTRAINT CHK_EDAD CHECK(dateadd(YEAR , 18, Fec_Nac) < GETDATE() ) ;

--PRUEBAS
			--		IF dateadd(YEAR , 18, '02-04-2006') < GETDATE() PRINT  'mayor'
			--		else print 'menor'
			--		--mayor

			--		IF dateadd(YEAR , 18, '03-04-2006') < GETDATE() PRINT  'mayor'
			--		else print 'menor'
			--		--mayor

			--		IF dateadd(YEAR , 18, '04-04-2006') < GETDATE() PRINT  'mayor'
			--		else print 'menor'
			--		--menor

			--SELECT * FROM COLABORADORES;

-- Otra forma valida
	ALTER TABLE COLABORADORES
		ADD Fec_Nac  DATE  CONSTRAINT CHK_EDAD CHECK(YEAR(GETDATE()) - YEAR(Fec_Nac) >= 18 );


--PRUEBAS
			PRINT YEAR(GETDATE()) - YEAR('04-04-2006')

--*****************************************************************
--	DML************************************************************
--*****************************************************************

-- 5.- Insertar tres o cuatro filas en cada tabla  de forma que los datos sean congruentes.1.5

-- COLABORADORES

SELECT * FROM COLABORADORES;


INSERT INTO COLABORADORES (Codigo_C, Dni, Nombre, Ape1, Ape2,  Domicilio, Aportadores, VoluNtarios, Donadores,
Profesion, Fec_Nac )
VALUES
(0, '00000000Z', '', '', '' ,'', 1,1,1, '',NULL);    -- VALOR POR DEFECTO


INSERT INTO COLABORADORES (Codigo_C, Dni, Nombre, Ape1, Ape2,  Domicilio, Aportadores, Voluntarios, Donadores, Profesion, Fec_Nac )
VALUES
(1, '17237324C', 'Jose Francisco', 'Rico', 'Prado' ,'Cuesta Juan Ram�n Jim�nez', 1,1,0, 'Med','25-06-2000');  --0 V D



INSERT INTO COLABORADORES (Codigo_C, Dni, Nombre, Ape1, Ape2,  Domicilio, Aportadores, Voluntarios, Donadores, Profesion, Fec_Nac )
VALUES (2,'38108174A', 'Violeta', 'Quesada', 'Casanova','Carrera San Roque 234',  1,1,1,'Est','12-05-2000');  --A V D

INSERT INTO COLABORADORES (Codigo_C, Dni, Nombre, Ape1, Ape2,  Domicilio, Aportadores, Voluntarios, Donadores, Profesion, Fec_Nac )
VALUES(3,'03981383Z', 'Jimena', 'Ruano', 'Domingo', 'Rambla Juan Ram�n Jim�nez 6',  1,0,1,'Est', '06-04-2002'); -- A 0 D

INSERT INTO COLABORADORES (Codigo_C, Dni, Nombre, Ape1, Ape2,  Domicilio, Aportadores, Voluntarios, Donadores, Profesion, Fec_Nac )
VALUES(4,'32198488Y', 'Almudena', 'Carrera', 'Paez', 'Rambla Lorca 574', 0,1,1, 'Abo', '19-08-1995');  -- 0 V D


INSERT INTO COLABORADORES (Codigo_C, Dni, Nombre, Ape1, Ape2,  Domicilio, Aportadores, Voluntarios, Donadores, Profesion, Fec_Nac )
VALUES(5, '96470603R', 'Angel Luis', 'Moya', 'Granados','Rambla Lorca 574', 0,1,1, 'Est', '29-04-1992');  --0 V D 

INSERT INTO COLABORADORES (Codigo_C, Dni, Nombre, Ape1, Ape2,  Domicilio, Aportadores, Voluntarios, Donadores, Profesion, Fec_Nac )
VALUES(6,'69235212Z', 'Paola', 'Alfonso', 'Mateo',  'V�a Iglesia 21', 1,1,1,'Est','01-03-1990');  --A V D

INSERT INTO COLABORADORES (Codigo_C, Dni, Nombre, Ape1, Ape2,  Domicilio, Aportadores, Voluntarios, Donadores, Profesion, Fec_Nac )
VALUES(8,'53934572D', 'Saul', 'Royo', 'Marrero','Pasaje Madrid 275', 1,0,0,'Pro', '25-10-1994' );-- A 0 0


INSERT INTO COLABORADORES (Codigo_C, Dni, Nombre, Ape1, Ape2,  Domicilio, Aportadores, Voluntarios, Donadores, Profesion, Fec_Nac )
VALUES(7, '61588495S', 'Antonia', 'Menendez', 'Morillo',  'Calle Real 303',  1,0,1, 'Pro', '28-08-2001'); -- A 0 D


INSERT INTO COLABORADORES (Codigo_C, Dni, Nombre, Ape1, Ape2,  Domicilio, Aportadores, Voluntarios, Donadores, Profesion, Fec_Nac )
VALUES(9,'72420004L', 'Araceli', 'Aguilera', 'Llorens','Ronda Pablo Picasso 907', 0,1,0, 'Ven', '04-01-2004'); -- 0 V 0

--El siguiente da error con la restriccion de mayores de 18 a�os
INSERT INTO COLABORADORES (Codigo_C, Dni, Nombre, Ape1, Ape2,  Domicilio, Aportadores, Voluntarios, Donadores, Profesion, Fec_Nac )
VALUES(10,'99999999L', 'Araceli', 'Aguilera', 'Llorens','Ronda Pablo Picasso 907', 0,1,1, 'Vet', '04-04-2006');--0 V D

--Este no da error
INSERT INTO COLABORADORES (Codigo_C, Dni, Nombre, Ape1, Ape2,  Domicilio, Aportadores, Voluntarios, Donadores, Profesion, Fec_Nac )
VALUES(11,'89999999L', 'Araceli', 'Aguilera', 'Llorens','Ronda Pablo Picasso 907',  1,1,1, 'Vet', '03-04-2006'); -- A V D

-- APORTADORES
SELECT * FROM COLABORADORES WHERE APORTADORES = 1;
SELECT * FROM APORTADORES;

INSERT INTO aportadores (Codigo_C, Cantidad)
VALUES
(1,100),
(3,100),
(6,100),
(7,150),
(11,200);

--VOLUNTARIOS
SELECT * FROM COLABORADORES WHERE VOLUNTARIOS = 1;
SELECT *FROM VOLUNTARIOS;

INSERT INTO voluntarios (Codigo_C)
VALUES
(0),
(1),
(4),
(5),
(6),
(9),
(11)
;


--DONADORES
SELECT * FROM COLABORADORES WHERE DONADORES  = 1;
SELECT *FROM DONADORES;

INSERT INTO DONADORES (Codigo_C,NumSocio)
VALUES
(0,'10'),
(3,'20'),
(4,'30'),
(5,'40'),
(6,'50'),
(7,'60'),
(11,'70')
;






--PERSONAL

SELECT * FROM Personal;


INSERT INTO PERSONAL (Codigo_P, Dni, Nombre, Ape1, Ape2, Turno, Tipo) VALUES
(0,  '00000000Z','', '', NULL, DEFAULT, 'E'),
(11, '46177676R', 'David', 'Lago', 'Pla', 'M', 'E'),
(22, '42112934A', 'Beatriz', 'Ortiz', 'Blanco', 'T', 'E'),
(33, '97388345C', 'Joaquina', 'Estevez', 'Bosch', 'N', 'E'),
(44, '84620389P', 'Gabriel', 'Galan', 'Poveda', 'M', 'E'),
(55, '24029162G', 'Elisabet', 'Coll', 'Luis', 'T', 'E'),
(66, '24643394K', 'Maria Remedios', 'Rebollo', 'Parra', 'N', 'E'),
(77, '75788001B', 'Miguel', 'Villegas', 'Casanova', 'M', 'G'),
(88, '93727211A', 'Felisa', 'Valencia', 'Camacho', 'T', 'G'),
(99, '66841581Q', 'Joan', 'Barrera', 'Quintana', 'N', 'G'),
(100, '82301285V', 'Aina', 'Luna', 'Rojo', 'M', 'G');




--TELEFONOS
SELECT  * FROM  PERSONAL;
SELECT  * FROM  TELEFONOS;


INSERT INTO TELEFONOS(Codigo_P, Telefono) VALUES
(11,'123456789'),
(11,'234567890'),
(22,'345678901'),
(55,'456789012'),
(55,'567890123'),
(66,'678901234'),
(99,'789012345'),
(100,'890123456'),
(100,'901234567'),
(100,'012345678');

--RAZAS
Select * from RAZAS;


insert into RAZAS 
( Cod_Raza, Nombre, Descripcion, Cod_Subraza)
values(111,'Golden', 'Muy bonito', Null);


insert into RAZAS 
( Cod_Raza, Nombre, Descripcion, Cod_Subraza)
values(222,'Fox Terrier', 'Mal Caracter', Null);

insert into RAZAS 
( Cod_Raza, Nombre, Descripcion, Cod_Subraza)
values(333,'Labrador', 'Comil�n', Null);

insert into RAZAS 
( Cod_Raza, Nombre, Descripcion, Cod_Subraza)
values(444,'Especial', 'Comil�n', 111);



--ANIMALES
SELECT * FROM PERSONAL;
SELECT * FROM DONADORES;
SELECT * FROM RAZAS;


INSERT INTO ANIMALES (Nombre, Fecha_Donacion, Fecha_Acogida, Codigo_P, Codigo_C, Codigo_R) VALUES
('Churry', '2023-02-20', '2023-08-11', 11, 3, '111'),
('Tuly', '2023-04-12', '2023-12-24', 22, 4, '111'),
('Lino', '2023-04-20', '2024-01-05', 22, 5, '222'),
('Black', '2023-09-28', '2024-01-25', 66,  6, '333'),
('Tuly', '2023-07-15', '2024-02-28', 77,  7, '222');

-- CUIDA


SELECT * FROM ANIMALES;
SELECT * FROM VOLUNTARIOS;
SELECT * FROM CUIDA;


INSERT INTO CUIDA(Cod_Animal,Codigo_C) VALUES
(100,4),
(100,5),
(102,9),
(102,5),
(104,4);


--6.- Insertar una nueva raza en la tabla Razas que, utilizando la propiedad DEFAULT
--ponga el valor por defecto en el campo descripci�n. Hazlo de dos formas distintas. 0.5



insert into RAZAS 
( Cod_Raza, Nombre, Descripcion, Cod_Subraza)
values(112,'GoldenB', DEFAULT, Null);

insert into RAZAS 
( Cod_Raza, Nombre,  Cod_Subraza)
values(110,'GoldenN', Null);


			

SELECT * FROM RAZAS;



--7. -Insertar un nuevo animal en la tabla Animal con el c�digo 101.      0.5



		Select * from ANIMALES;
		select * from RAZAS
		sp_help razas


		Set identity_insert Animales on; 

	INSERT INTO ANIMALES (Cod_Animal, Nombre, Fecha_Donacion, Fecha_Acogida, Codigo_P, Codigo_C, Codigo_R) VALUES
(101, 'Churry', '2023-02-20', '2023-08-11', 11, 3, '111');
		
		Set identity_insert Animales off; 


	
-- 8.- Borrar una persona que sea Donadora y que nos haya donado alg�n animal. 
-- Explicar el proceso. �Y si fuera tambi�n un Voluntario que cuidara alg�n animal?
--�qu� ocurrir�a? Hacerlo y explicarlo. 1
 


		SELECT * FROM COLABORADORES;
		SELECT * FROM DONADORES;
		SELECT * FROM ANIMALES;
		SELECT * FROM CUIDA


		DELETE COLABORADORES WHERE Codigo_C = 5;-- Nos dio a Lino (3)  y Cuida  a Churry(1) y a Tuly (2) 


-- Este colaborador aparece como llave for�nea en las tablas DONADORES y VOLUNTARIOS
-- En esta aparece como FK UC DC :

    select * from COLABORADORES where Codigo_C = 5;

	select CONSTRAINT_NAME, UPDATE_RULE, DELETE_RULE from information_schema.REFERENTIAL_CONSTRAINTS;

------CONSTRAINT_NAME	UPDATE_RULE	DELETE_RULE
-----------------------------------------------
------FK_VOLUNTARIO	    CASCADE	    CASCADE
------FK_DONADOR	    CASCADE	    CASCADE



-- Esto hace que al borrar el COLABORADORES se borre en DONADORES y en VOLUNTARIOS automaticamente.


-- Aparece tambien en la tabla ANIMALES, como  DONADOR identificado
-- con el campo Codigo_C. Aqui la FK aparece con UC DSD

--------CONSTRAINT_NAME	UPDATE_RULE	DELETE_RULE
-----------------------------------------------
--------fk_Don_Ani	    CASCADE	    SET DEFAULT

--Aqu� pone el valor por defecto que es el 0


-- Pro no lo borra pues est� tambien en CUIDA


-- Y si como es tambien VOLUNTARIO  que cuida  a Churry (1) y a Tuly (2) 
-- 
---- CONSTRAINT_NAME	UPDATE_RULE	DELETE_RULE
-----------------------------------------------
---- fk_CUIDA_VOL	    NO ACTION	NO ACTION

---- No nos lo borrarra automaticamente, tenemos que solucionarlo de otra forma



	DELETE COLABORADORES WHERE Codigo_C = 5;
	select * from RAZAS


--Msg 547, Level 16, State 0, Line 417
--Instrucci�n DELETE en conflicto con la restricci�n REFERENCE 'fk_CUIDA_VOL'.
--El conflicto ha aparecido en la base de datos 'Veterinario_2024_ASIR', tabla 'dbo.CUIDA', column 'Codigo_C'.
--Se termin� la instrucci�n.

			select * from cuida
			update cuida set Codigo_C = 0 
						 where Codigo_C = 5;

-- Vuelvo a intentarlo

DELETE COLABORADORES WHERE Codigo_C = 5;

-- Esto hace que en el campo Codigo_C de la Tabla ANIMALES se rellene con el valor por defecto,
-- que en este caso es el 
-- voluntario de codigo cero, ya que este Codigo_C apunta a VOLUNTARIOS

 SELECT * FROM COLABORADORES; --Desapareci� el 5
 SELECT * FROM DONADORES;     --Desapareci� el 5
 SELECT * FROM ANIMALES;      --Al animal que habia donado el Numero 5, que era Lino con el numero 3 ahora aparece 
							  --ahora aparece donado por el 0
 SELECT * FROM CUIDA;         --tambien se cambi� pero hecho por nosotros.












