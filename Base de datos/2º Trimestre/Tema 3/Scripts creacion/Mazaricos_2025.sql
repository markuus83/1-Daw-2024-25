--Microsoft SQL Server
--**************************************************************
-- En esta version omitimos el DC de la tabla Empleados en las dos FK.
-- Tambien omitimos el  DC de la tabla Traballa en las dos FK
--**************************************************************

--Crear BD

--Microsoft SQL Server

--Crear BD

create database mazaricos_2025;

go

use  mazaricos_2025;

-- Creaci?n de la BD de Mazaricos Software.


/*
1.- Crear la BD en Ms Sql Server. 
2.- Introducir Valores.
*/



-- Crear Tablas

	CREATE TABLE DEPARTAMENTO (
		Cod_Dept	CHAR(2) NOT NULL,
		Nome_Dept	VARCHAR(20) NOT NULL,
		CONSTRAINT PKDEPARTAMENTO PRIMARY KEY (Cod_Dept)
		);

	SELECT * FROM DEPARTAMENTO

	CREATE TABLE CATEGORIA (
		Cod_Cat		CHAR(2) NOT NULL,
		Nome_Cat	VARCHAR(30) NOT NULL,
		Soldo		SMALLMONEY NOT NULL,            
		Desconto	FLOAT NOT NULL CONSTRAINT CHKDESCONTO CHECK(Desconto <= 25),
		SReal AS (Soldo - (Soldo*Desconto/100)),
		Prezo_H_Extr SMALLMONEY CONSTRAINT CHKH_EXTRA CHECK (Prezo_H_Extr <= 90)
		CONSTRAINT PKCAT PRIMARY KEY (Cod_Cat)
		);

		
		SELECT * FROM CATEGORIA		
		

		
-- Ahora ya puedo crear empleado referenciando las claves foraneas:


	CREATE TABLE EMPLEADO (
	DNI			CHAR(9) NOT NULL,
	NSS			CHAR(15) NOT NULL,
	Nome_Empreg VARCHAR(30) NOT NULL,
	Enderezo	VARCHAR(100),
	Telefono	CHAR(9),
	Horas_Extr  SMALLINT,
	Cod_Dept    CHAR(2) NOT NULL,
	Cod_Cat     CHAR(2) NOT NULL

	CONSTRAINT PKEMPLEADO PRIMARY KEY (DNI),

	CONSTRAINT FKCDEPA FOREIGN KEY (Cod_Dept) REFERENCES Departamento(Cod_Dept) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT FKCCATE FOREIGN KEY (Cod_Cat) REFERENCES Categoria(Cod_Cat) ON UPDATE CASCADE ON DELETE NO ACTION,
); 
    SELECT * FROM EMPLEADO;	


	CREATE TABLE CLIENTE (
		CIF				CHAR(9) NOT NULL CONSTRAINT PKCIF PRIMARY KEY,
		Nome			VARCHAR(20) NOT NULL, 
		Apellidos		VARCHAR(20) NOT NULL, 
-- A?adimos una columna calculada, en este caso junta dos cadenas con la funcion CONCAT
-- Fijaros que no le damos tama?o.
		NombreCompleto AS CONCAT(Nome, Apellidos),
		Enderezo		VARCHAR(100) SPARSE,-- Sparse da un tratamiento especial a los NULOS
		Telefono		CHAR(9),
		fecha_nac		DATE
);
		
   SELECT * FROM CLIENTE	
		
	CREATE TABLE APLICACION (
		Cod_Aplic	CHAR(4)		NOT NULL,
		Nome_Aplic	VARCHAR(30) NOT NULL,
		CIF			CHAR(9)		NOT NULL  CONSTRAINT DFCIF default 'XXXXXXXXX' ,
		
		CONSTRAINT PKAPLIC PRIMARY KEY (Cod_Aplic),
		CONSTRAINT FKCIF FOREIGN KEY (CIF) REFERENCES CLIENTE(CIF) on update cascade on delete set default
		);
	
	   SELECT * FROM APLICACION;	

	CREATE TABLE PROXECTO (
		Cod_Aplic CHAR(4) NOT NULL, 
		Cod_Proxec CHAR(4) NOT NULL,
		Nome_Proxec VARCHAR(30) NOT NULL,
		Horas_Estimadas INT,
		Horas_reais INT,

		CONSTRAINT PKPROX PRIMARY KEY (Cod_Aplic,Cod_Proxec),
		CONSTRAINT FKAPLI FOREIGN KEY (Cod_Aplic) REFERENCES APLICACION(Cod_Aplic)
		on update cascade on delete cascade 
		);

		   SELECT * FROM PROXECTO;
		

	CREATE TABLE TRABALLA (
		Cod_Aplic CHAR(4)		NOT NULL,
		Cod_Proxec CHAR(4)		NOT NULL,
		DNI CHAR(9)				NOT NULL,
		CONSTRAINT PKTRABALLA PRIMARY KEY (Cod_Aplic,Cod_Proxec,DNI),

		CONSTRAINT FKPROX FOREIGN KEY (Cod_Aplic,Cod_Proxec)  REFERENCES PROXECTO (Cod_Aplic,Cod_Proxec)
		on update no action  on delete no action,
		CONSTRAINT FKEMPL FOREIGN KEY (DNI)	REFERENCES EMPLEADO(DNI) on update cascade on delete cascade
		);

		SELECT * FROM TRABALLA;	

--- Obs�rvese que se introducen valores para t?dos los atributos de cada tabla en el mismo orden
--- en que est?n definidos los atributos en la tabla. Cuando no se sabe un valor, ponemos NULL.

--- Insertar valores en departamento. ---------------------------------------------

--- Si no se ponen los nombres de los campos se debe insertar la informaci?n en el mismo orden en
--- el que se crearon os campos de la t?bla.

		INSERT INTO DEPARTAMENTO values ('PR','Programaci�n');
		INSERT INTO DEPARTAMENTO values ('RH','Rec Humanos');
		INSERT INTO DEPARTAMENTO values ('IN','Intendencia'); -- NO HAY EMPLEADOS
		SELECT * FROM DEPARTAMENTO;

---Si se ponen los nombres de los campos se d?be insertar la informaci?n en el mismo orden en
-- el que se ponen los nombres de los campos en la sentencia.

		INSERT INTO DEPARTAMENTO(Nome_Dept,Cod_Dept) values ('Contabilidade','CT');

--- Insertar valores en categoria MS SqlServer.--------------------------------------

		SELECT * FROM CATEGORIA;

		INSERT INTO CATEGORIA values ('AN','Anal?sta', 2500, 23.57, 90);
		INSERT INTO CATEGORIA values ('PR','Programador', 1500, 13.21, 25);
		INSERT INTO CATEGORIA values ('CT','Contable', 1500, 20, 80);
		INSERT INTO CATEGORIA values ('MT','Tecnico', 1500, 10.5, 65);--NO HAY EMPLEADOS

		INSERT INTO CATEGORIA values ('JE','Jefe', 1500, 30, 65);-- Da error en el check de desconto
		INSERT INTO CATEGORIA values ('JE','Jefe', 1500, 20, 91);-- Da error en el check de hora extra


--- Insertar valores en empregado ---------------------------------------------------



		INSERT INTO EMPLEADO VALUES ('12345678Z', '00/123456789012', 'Manolo Alvarez', 'Rua, 2', NULL, 20, 'PR', 'PR');

		INSERT INTO EMPLEADO (DNI, NSS, Nome_Empreg, Enderezo, Telefono, Cod_Dept,Cod_Cat)
		VALUES ('11111111Z', '00/123456789000', 'Ana Pin', 'Rua,2', '986123456', 'PR', 'AN');

		INSERT INTO EMPLEADO (DNI, NSS, Nome_Empreg, Enderezo, Telefono, Cod_Dept,Cod_Cat)
		VALUES ('22222222B', '00/123456789000', 'Luis Alvarez', 'Calle,2', '986111111', 'RH', 'CT');

		INSERT INTO EMPLEADO (DNI, NSS, Nome_Empreg, Enderezo, Telefono, Cod_Dept,Cod_Cat)
		VALUES ('33333333C', '00/123456789000', 'Juan Solo', 'Villa,2', '986122222', 'RH', 'CT');

		SELECT * FROM Empleado;
	
		
		
--- Insertar valores en cliente ---------------------------------------------------


		SELECT * FROM CLIENTE;
		INSERT INTO CLIENTE VALUES ('A11111111','PEPE','LOPEZ PEREZ', 'Vilar 25','981111111', '07/10/56');
		INSERT INTO CLIENTE VALUES ('A22222222','JUAN','RUIZ PEREZ','Nova 2','981222222', '06/12/60');
		INSERT INTO CLIENTE VALUES ('A33333333','LUISE','ABAL RUIZ',NULL,'981333333', NULL);
		INSERT INTO CLIENTE VALUES ('A44444444','ROSA','VIEITES VEIGA','NULL','981444444', '09/2/59');--No tiene Aplicacion
		SELECT * FROM CLIENTE;
--- Insertar valores en aplicacion ------------------------------------------------
		SELECT * FROM APLICACION;
		INSERT INTO APLICACION VALUES ('Con1','Xesti?n Empresa Construc.','A11111111');
		INSERT INTO APLICACION VALUES ('Car1','Xesti?n Empresa Carpint.','A22222222');
		INSERT INTO APLICACION VALUES ('Pro1','Xesti?n de Promoci?ns','A22222222');--No tiene Proyecto
		INSERT INTO APLICACION VALUES ('Pro2','Xesti?n de Promoci?ns','A11111111');--No tiene Proyecto
		INSERT INTO APLICACION VALUES ('Pro3','Xesti?n de Promoci?ns','A33333333');--No tiene Proyecto
		
	
--- Insertar valores en proxecto ---------------------------------------------------------
		SELECT * FROM PROXECTO;
		INSERT INTO PROXECTO VALUES ('Con1','Req1','An?lise de Req. de Constru 6',20,25);
		INSERT INTO PROXECTO VALUES ('Con1','ER1','Modelo ER de Constru',30,NULL);
		INSERT INTO PROXECTO VALUES ('Car1','Req1','An?lise de Req. dunha Carpint.',15,5);
		INSERT INTO PROXECTO VALUES ('Car1','Req2','An?lise de Req. dunha Carpint.',15,5);
		INSERT INTO PROXECTO VALUES ('Car1','Req3','An?lise de Req. dunha Carpint.',15,5); -- No tiene TRABALLA

		
		
--- Insertar valores en traballa ------------------------------------------------
		
		SELECT * FROM TRABALLA;

		INSERT INTO TRABALLA VALUES ('Con1','Req1','11111111Z');
		INSERT INTO TRABALLA VALUES ('Con1','ER1', '11111111Z');
		INSERT INTO TRABALLA VALUES ('Car1','Req1','11111111Z');
		INSERT INTO TRABALLA VALUES ('Car1','Req2','11111111Z');
		INSERT INTO TRABALLA VALUES ('Car1','Req1','22222222B');
		INSERT INTO TRABALLA VALUES ('Car1','Req1','33333333C');
		
		SELECT * FROM DEPARTAMENTO
		SELECT * FROM CATEGORIA
		SELECT * FROM EMPLEADO
		SELECT * FROM CLIENTE
		SELECT * FROM APLICACION
		SELECT * FROM PROXECTO
		SELECT * FROM TRABALLA
		
		
		

	

-- Consultas sobre datos de la BD, estos son los Metadatos.


-- Muestra las tablas y vistas de la BD.

		select * from information_schema.TABLES;

-- Muestra todas las constraints (restricciones) de las tablas de la BD

		select CONSTRAINT_NAME, TABLE_NAME, CONSTRAINT_TYPE  from information_schema.TABLE_CONSTRAINTS ORDER BY CONSTRAINT_NAME;

-- Muestra solo  las LLaves foraneas de la BD.

		
		select * from information_schema.TABLE_CONSTRAINTS;

		select * from information_schema.REFERENTIAL_CONSTRAINTS;

-- Lo mismo, pero preguntando solo por algunas columnas de las claves foraneas.

		select CONSTRAINT_NAME,  UPDATE_RULE, DELETE_RULE from information_schema.REFERENTIAL_CONSTRAINTS; 

		select information_schema.TABLE_CONSTRAINTS.CONSTRAINT_NAME, UPDATE_RULE, DELETE_RULE,TABLE_NAME
		FROM information_schema.TABLE_CONSTRAINTS, information_schema.REFERENTIAL_CONSTRAINTS
		WHERE information_schema.REFERENTIAL_CONSTRAINTS.CONSTRAINT_NAME = information_schema.TABLE_CONSTRAINTS.CONSTRAINT_NAME


-- Muestra las foreign keys que tengo definidas.		
 
--CONSTRAINT_NAME			UPDATE_RULE			DELETE_RULE			TABLENAME
	--FKCDEPA					CASCADE				NO ACTION			EMPLEADO
	--FKCCATE					CASCADE				NO ACTION			EMPLEADO
	--FKCIF						CASCADE				SET DEFAULT			APLICACION
	--FKAPLI					CASCADE				CASCADE				PROXECTO
	--FKPROX					NO ACTION			NO ACTION			TRABALLA
	--FKEMPL					CASCADE				CASCADE				TRABALLA





--1.- Modificar la clave de un departamento que tenga empleados.

--CONSTRAINT_NAME			UPDATE_RULE			DELETE_RULE			TABLENAME
	--FKCDEPA				CASCADE				NO ACTION			EMPLEADO
		
		update departamento set Cod_Dept = 'RR' where Cod_Dept = 'RH';

-- Comprobar la repercusion en enpleado y explicar la razon.
		select * from DEPARTAMENTO;
		select * from EMPLEADO;
-- Como tiene UPDATE CASCADE lo modifica en cascada

--2.- Borrar una categoria que tenga empleados. Ten�amos 

--CONSTRAINT_NAME			UPDATE_RULE			DELETE_RULE			TABLENAME
--	FKCCATE					CASCADE				NO ACTION			EMPLEADO

-- Comprobar la repercusion en enpleado

		delete  CATEGORIA where Cod_Cat ='PR';

-- No deja borrarla pues tiene la restriccion de No Action.
-- Tendr� que borrarla a mano.

		select * from CATEGORIA;
		select * from EMPLEADO;

-- Borro primero esa categoria de los hijos

-- Por ejemplo les pongo otro valor que tendr� que ser una categor�a que ya exista.

		UPDATE EMPLEADO SET Cod_Cat = 'AN' WHERE Cod_Cat = 'PR';

-- Ahora ya puedo borrarla

		DELETE  CATEGORIA WHERE Cod_Cat ='PR';


--3.- Modificar un cliente.

-- Comprobar la repercusion en aplicacion

--CONSTRAINT_NAME			UPDATE_RULE			DELETE_RULE			TABLENAME
--	FKCIF					CASCADE				SET DEFAULT			APLICACION

		update CLIENTE set CIF = 'J77777777' where CIF ='A22222222';

-- Sin problema gracias al UPDATE CASCADE

		select * from CLIENTE;
		select * from APLICACION;

--4.- Borrar un cliente.
-- Comprobar la repercusion en aplicacion.


--CONSTRAINT_NAME			UPDATE_RULE			DELETE_RULE			TABLENAME
--	FKCIF					CASCADE				SET DEFAULT			APLICACION

		delete CLIENTE  where CIF ='J77777777';

-- No deja, pues no hay valor por defecto, ya que el valor por defecto establecido no existe 
-- en la tabla CLIENTE.

-- Lo inserto:

		insert into CLIENTE(Cif, Nome, Apellidos) values ('XXXXXXXXX','No tiene','No tiene');

-- Lo vuelvo a intentar:

		delete CLIENTE  where CIF ='J77777777';

-- Ya lo borra y pone el valor por defecto

		select * from CLIENTE;
		select * from APLICACION;

--5.- Modificar una aplicacion.

--CONSTRAINT_NAME			UPDATE_RULE			DELETE_RULE			TABLENAME
--FKAPLI					CASCADE				CASCADE				PROXECTO
--FKPROX					NO ACTION			NO ACTION			TRABALLA

-- Seg�n las restricciones al modificar en aplicacion se modifica directamente en PROYECTO
-- Pero no en TRABALLA.

		update APLICACION set Cod_Aplic= 'Cart' where Cod_Aplic= 'Car1';

-- Fijaros que el error lo da en TRABALLA, pero no deja cambiarla en PROXECT, logicamente.
			
		select * from APLICACION;
		select * from PROXECTO;
		select * from TRABALLA;

-- 

-- Tenemos que borrar
-- los hijos que tiene en traballa para poder luego modificar la clave y luego volver
-- a darlos de alta con la nueva clave de aplicacion.

		DELETE TRABALLA WHERE Cod_Aplic = 'Car1';

-- Ahora vuelvo a intentar la modificacion:

		update APLICACION set Cod_Aplic= 'Cart' where Cod_Aplic= 'Car1';


		select * from APLICACION;
		select * from PROXECTO;
		select * from TRABALLA;

-- Ahora funciono gracias al UC de Proxecto.		



-- Una vez borradas funciona en proxecto, ya que tiene Update Cascade

		

-- Volvemos a insertar las entrada de Traballa que borramos ahora 
-- con el nuevo nombre de la aplicacion.


		INSERT INTO TRABALLA VALUES ('Cart','Req1','11111111Z');
		INSERT INTO TRABALLA VALUES ('Cart','Req2','11111111Z');
		INSERT INTO TRABALLA VALUES ('Cart','Req1','22222222B');
		INSERT INTO TRABALLA VALUES ('Cart','Req1','33333333C');



		select * from APLICACION;
		select * from PROXECTO;
		select * from TRABALLA;


--6.- Borrar una aplicacion.

--CONSTRAINT_NAME			UPDATE_RULE			DELETE_RULE			TABLENAME
--FKAPLI					CASCADE				CASCADE				PROXECTO
--FKPROX					NO ACTION			NO ACTION			TRABALLA

-- Pasa lo mismo que la anterior, falla el paso de PROXECTO A TRABALLA.

		delete  APLICACION  where Cod_Aplic= 'Con1';

		select * from APLICACION;
		select * from PROXECTO;
		select * from TRABALLA;


-- Tenemos que borrar
-- los hijos que tiene en traballa para poder luego modificar la clave y luego volver
-- a darlos de alta con la nueva clave de aplicacion.

-- Fijaros que el error lo da en TRABALLA, pero no deja cambiarla en PROXECT, logicamente.

		


-- Tenemos que borrar
-- los hijos que tiene en traballa para poder luego modificar la clave y luego volver
-- a darlos de alta con la nueva clave de aplicacion.

		DELETE TRABALLA WHERE Cod_Aplic = 'Con1';

-- Ahora vuelvo a intentar el borrado:

		delete  APLICACION  where Cod_Aplic= 'Con1';


		select * from APLICACION;
		select * from PROXECTO;
		select * from TRABALLA;

-- Ahora funciono gracias al UC de Proxecto.	
-- No tiene sentido introducir las entradas en traballa 
-- de una Aplicacion que ya no existe.







--7.- Modificar un trabador.


--CONSTRAINT_NAME			UPDATE_RULE			DELETE_RULE			TABLENAME
	--FKEMPL					CASCADE				CASCADE				TRABALLA

			update EMPLEADO set DNI ='99999999X' where DNI = '11111111Z'

		select * from EMPLEADO;
		select * from TRABALLA;

--8.- Borrar un trabajador.

--CONSTRAINT_NAME			UPDATE_RULE			DELETE_RULE			TABLENAME
--FKEMPL					CASCADE				CASCADE				TRABALLA

		delete EMPLEADO where DNI ='99999999X'

		select * from EMPLEADO;
		select * from TRABALLA;


		select * from APLICACION;
		select * from PROXECTO;
		select * from TRABALLA;
		select * from EMPLEADO;


--9.- Borrar un proyecto que tenga TRABALLA


--CONSTRAINT_NAME			UPDATE_RULE			DELETE_RULE			TABLENAME
--FKPROX					NO ACTION			NO ACTION			TRABALLA


		delete PROXECTO where Cod_Aplic= 'cart' and Cod_Proxec='Req1';
		select * from EMPLEADO;
		select * from PROXECTO;
		select * from TRABALLA;
-- Da error pues tiene el Delete No Action
-- Tendr� que borrar en TRABALLA antes las entradas del PROXECTO que quiero borrar:

		delete TRABALLA where Cod_Aplic= 'cart' and Cod_Proxec='Req1';

-- Ahora ya podr� borrar el PROXECTO.

		
		
-- Cuestiones con SELECT. Proximamente.

--1.- Indica el sueldo base de cada empleado, y el precio que tiene por hora_extra que trabaje.

		SELECT Nome_Empreg,soldo,prezo_h_extr
		FROM empleado as e JOIN categoria 
		as c ON(e.cod_cat=c.cod_cat);

--2.- Indica lo que va a cobrar este mes cada empleado, una vez calculadas las horas extras 
--    y aplicado el descuento correspondiente y los impuestos.
		
		SELECT Nome_Empreg,(soldo+prezo_h_extr*horas_extr)*(1-DESCONTO/100) as Salario_Neto
		FROM empleado as e JOIN categoria as c ON(e.cod_cat=c.cod_cat)
		WHERE horas_extr is not null

		UNION
		
		SELECT Nome_Empreg,soldo*(1-DESCONTO/100) as Salario_Neto
		FROM empleado as e JOIN categoria as c ON(e.cod_cat=c.cod_cat)
		WHERE horas_extr is null;



	
	