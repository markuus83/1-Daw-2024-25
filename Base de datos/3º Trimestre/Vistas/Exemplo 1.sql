-- Creacion de Vistas

-- Crear una vista de los empleados con salario > 200

			CREATE OR ALTER VIEW VEMPLE200 
			AS SELECT *
			FROM TEMPLE WHERE SALAR > 200;

			SELECT * FROM TEMPLE;
			SELECT * FROM VEMPLE200;

-- Crear una vista que nos de n�mero y nombre de los empleados 
-- con salario > 200.

-- Se podr�a hacer a partir de la tabla TEMPLE o de la vista VEMPLE200.
-- Aqu� la vista la hago a partir de la vista.

			CREATE OR ALTER VIEW VEMPLE2001 
			AS SELECT NUMEM, NOMEM
			FROM VEMPLE200;
			
		
			SELECT * FROM VEMPLE2001;
			
			
-- Para borrar una vista
	
			DROP VIEW VEMPLE200;

--Si consultamos ahora la VEMPLE2001 que iba sobre la VEMPLE200
--da error.
			
			SELECT * FROM VEMPLE2001;

--Para modificar una vista
		
		    CREATE OR ALTER VIEW VEMPLE200
			AS SELECT *
			FROM TEMPLE WHERE SALAR > 250;

-- En este caso la crea, ya que la hab�amos borrado

-- Voy a modificarlo, volviendo a poner 200 

		CREATE OR ALTER VIEW	VEMPLE200
				AS SELECT *
				FROM TEMPLE WHERE SALAR > 200;

			
			SELECT * FROM VEMPLE200;	
			SELECT * FROM VEMPLE2001;

--Si quiero saber como son:
			Exec sp_helptext VEMPLE200;
			Exec sp_helptext VEMPLE2001;

			
-- **************************************************************************************			
-- **************************************************************************************			
-- Modificar datos a traves de una vista
-- **************************************************************************************
-- **************************************************************************************



-- *******************************************
-- a) Insertar datos a traves de una vista****
-- *******************************************

-- La instrucci�n INSERT de una vista de varias tablas debe utilizar una 
-- column_list que solamente haga referencia a columnas de una tabla base.
--
-- **********************************************************************
-- Sin CHECKOPTION ******************************************************
-- **********************************************************************
			select * from TDEPTO

-- Inserta cualquier dato este o no en la vista.  Solo tiene que cumplir 
-- las condiciones de insert de la vista

            SELECT * FROM TEMPLE;
			SELECT * FROM VEMPLE200;
			SELECT * FROM VEMPLE2001;
	
			INSERT INTO VEMPLE2001 VALUES (105,'Prueba0');
		
					
--No aparece 105 en la vista ya que su sueldo no es mayor que 200, pero se inserta =
			
			SELECT * FROM VEMPLE2001;

--pero si aparece en Temple ya que se insert�.

			SELECT * FROM TEMPLE;


-- Creamos una nueva vista a partir de la vista VEMPLE200

			CREATE OR ALTER VIEW VEMPLE2002 
			AS SELECT NUMEM, NOMEM, SALAR
			FROM VEMPLE200;
			
			SELECT * FROM VEMPLE2002;
			SELECT * FROM TEMPLE;
	
-- Insertamos ahora 

			INSERT INTO VEMPLE2002 VALUES (108,'Prueba1',100);-- No aparece en la vista, pero si en la tabla
			INSERT INTO VEMPLE2002 VALUES (112,'Prueba2',500);-- Si aparece en la vista y en la tabla

--Los borro a traves de la tabla. 
			
		  
		DELETE TEMPLE WHERE NUMEM = 112   
		DELETE TEMPLE WHERE NUMEM = 105       
		DELETE TEMPLE WHERE NUMEM = 108	     
		
					
-- **********************************************************************
-- Con CHECKOPTION ******************************************************
-- **********************************************************************		
-- Si la vista fue creada con la cl�usula 'WITH CHECK OPTION'.  
-- solo inserta en la tabla subyacente los que cumplen la condicion de la vista.

-- Da error. 

            SELECT * FROM TEMPLE;
            
            CREATE OR ALTER VIEW VEMPLE2003
			AS SELECT NUMEM, NOMEM, SALAR 
			FROM VEMPLE200 with check option;

	       INSERT INTO VEMPLE2003 VALUES (108,'Prueba3',100);   -- Da error, no cumple las condiciones de la vista
		   INSERT INTO VEMPLE2003 VALUES (109,'Prueba4',500);	-- Si lo inserta
		   
		   SELECT * FROM TEMPLE;
		   SELECT * FROM VEMPLE2003;
			

-- *******************************************
-- Modificar datos a traves de una vista******
-- *******************************************

-- **********************************************************************
-- Sin CHECKOPTION ******************************************************
-- **********************************************************************

-- Solo modifica los datos que estan en la vista

            SELECT * FROM TEMPLE;
			SELECT * FROM VEMPLE200;

			SELECT * FROM VEMPLE200
			WHERE NUMEM = 150;-- Est� en la vista

-- Si lo hace, ya que est� en la vista. Modificar el nombre a �ngel


			UPDATE VEMPLE200  
			SET nomem ='�ngel' 
			WHERE numem =150;

			SELECT * FROM VEMPLE200
			WHERE NUMEM = 150;
			
-- No Deja    

			SELECT * FROM VEMPLE2001
			WHERE NUMEM = 370; -- No est� en la vista


--Si intento cambiar el nombre al 370 no lo hace.
			UPDATE VEMPLE2001  
			SET nomem ='Lasa,Mata' 
			WHERE numem =370
			
			
			SELECT * FROM temple
			SELECT * FROM VEMPLE2001


			
			
-- Que pasa si en la modificacion el dato hace que este  desaparezca de la vista:

-- Creamos otra vista sin 'WITH CHECK OPTION'

			CREATE OR ALTER VIEW VEMPLE2004
			AS SELECT NUMEM, NOMEM, SALAR
			FROM VEMPLE200;
			
			SELECT * FROM VEMPLE2004;
			SELECT * FROM TEMPLE;
			
-- Si el dato no esta en la vista, no lo actualiza		
	
			UPDATE VEMPLE2004 SET SALAR = 100 WHERE NUMEM = 370;
								
-- Si esta en la vista, lo modifica, aunque desaparezca de ella

			SELECT * FROM TEMPLE;
			SELECT * FROM VEMPLE2004;

			UPDATE VEMPLE2004 SET SALAR = 100 WHERE NUMEM = 110;
	
	
	
	
-- Con  'WITH CHECK OPTION' 

			CREATE OR ALTER  VIEW VEMPLE2004 
			AS SELECT NUMEM, NOMEM, SALAR 
			FROM VEMPLE200 WITH CHECK OPTION ;


			
			
-- Si esta en la vista, no lo modifica, 
-- si la modificacion implica que la tupla desaparezca de ella.			
			
			SELECT * FROM VEMPLE2004;
			
-- No deja, da error.
			
			UPDATE VEMPLE2004 SET SALAR = 100 WHERE NUMEM = 190;
			
-- Pero si puedo modificarlo en la tabla.
			
			UPDATE TEMPLE SET SALAR = 100 WHERE NUMEM = 190;
			
							
			SELECT * FROM TEMPLE
			
			
			
			
			
			
-- ****************************************************************************			
--Borrar: Solo borra los datos que estan en la vista. No influye el CHECKOPTION
-- ****************************************************************************

-- VEMPLE2001 no tiene check option

			exec sp_helptext VEMPLE2001;
			exec sp_helptext VEMPLE2002;
			exec sp_helptext VEMPLE2003;

-- Deja
			SELECT * FROM TEMPLE
			SELECT * FROM VEMPLE2001
			DELETE VEMPLE2001 WHERE numem = 150;
			
-- No deja		
	
			DELETE VEMPLE2001 WHERE numem = 108;






			

-- Para ponerle nombre a las columnas las enumeramos.
-- y da error si el n�mero de columnas no coincide.
-- Se pueden poner los alias en la clausula SELECT:


			CREATE OR ALTER VIEW VEMPLE2002 (N�mero, Nombre)
			AS SELECT NUMEM, NOMEM
			FROM TEMPLE WHERE SALAR > 200;
			

SELECT * FROM VEMPLE2002
SELECT * FROM temple


			
-- Crear una vista vemple2005 con los empleados de vemple2001 que tengan
-- la palabra Perez en su nombre. Al n�mero de empleado le llamaremos ID 
-- y al nombre NOMBRE, e ir?n en este orden:NOMBRE, ID.

			CREATE OR ALTER VIEW VEMPLE2005 (NOMBRE, ID)
			AS SELECT NOMEM, NUMEM
			FROM VEMPLE2001 WHERE NOMEM like '%PEREZ%';
			
			SELECT * FROM VEMPLE2001;
			SELECT * FROM VEMPLE2002;
			
-- Crear una vista vemple2006, con los empleados de VEMPLE200 y
-- cinco columnas: el n?mero de empleado,nombre,n?mero de departamento,edad y a?os de servicio
-- en la empresa. 



			CREATE OR ALTER VIEW VEMPLE2006 (ID, NOMBRE, DEPARTAMENTO, EDAD, ANTIG�EDAD)
			AS SELECT NUMEM, NOMEM, NUMDE,
			ABS(DATEDIFF(YEAR, getdate(), fecna)), ABS(DATEDIFF(YEAR, getdate(), fecin))
			FROM VEMPLE200;
				
			SELECT * FROM VEMPLE2006;
			select * from temple
			
			
-- Obtener las medias de edad y antig�edad de cada departamento.

			SELECT DEPARTAMENTO, AVG(EDAD)as 'Media de Edad',
			AVG(ANTIG�EDAD)as 'Media Antig�edad'
			FROM VEMPLE2006
			GROUP BY DEPARTAMENTO
			ORDER BY DEPARTAMENTO;
 
 -- Crear una vista VEMPLE2007 en la que aparezcan por departamento las 
 -- edades m?nima, max?ma y media de los empleados incluidos en
 -- VEMPLE2006.
 
 
			 CREATE OR ALTER VIEW VEMPLE2007
			 (DEPTO,MINIMA,MAXIMA,MEDIA)
			 AS SELECT DEPARTAMENTO, MIN(EDAD),MAX(EDAD),AVG(EDAD)
			 FROM VEMPLE2006
			 GROUP BY DEPARTAMENTO;
			 		 	 	 
			 SELECT * FROM VEMPLE2006;
			 
			  
-- Utilidad de las vistas:

-- 1) Prohibir el acceso a datos confidenciales. Si hay datos 
-- confidenciales se crea una vista en la que estos no aparezcan
-- y se les da permiso a los usuarios para consultar la vista.
-- Se pueden ocultar columnas completas o solo filas que cumplan
-- ciertas condiciones.

-- 2) Simplificar la formulaci?n de consultas. Para consultas 
-- complicadas se guardan estas como vistas y a partir de ahi se
-- hacen SELECTs sencillas de la vista.


-- 3) Aumentar la independencia de los programas con respecto a 
-- los datos. Si tenemos que reestructurar tablas podemos definir
-- vistas usando la nomenclatura vieja y as� podremos seguir 
-- usando las SELECTs existentes.

			 
-- Si queremos poner a disposicion de un gran numero de usuarios un 
-- directorio donde figuren, para cada empleado: n?mero de empleado,
-- nombre, numero del departamento en que trabaja,nombre de este y
-- su extension telefonica. Estos datos estan en su mayoria en la
-- tabla de empleados, pero no queremos que se pueda acceder a esta 
-- directamente pues contiene datos que se consideran confidenciales:		 
-- Creamos una vista:

			CREATE OR ALTER VIEW DIRECTORIO
			(ID,NOMBRE, NUMDEP, DEPTO,TELEFONO)
			AS SELECT NUMEM, NOMEM, E.NUMDE,NOMDE,EXTEL
			FROM TEMPLE E, TDEPTO D
			WHERE E.NUMDE = D.NUMDE;	

-- Insertar un empleado. Los datos tienen que ser de una sola tabla			

			insert into directorio (id) values(105); 
			
			SELECT * FROM TDEPTO
			select * from TEMPLE
			
			SELECT * FROM directorio
				 
-- Supongamos que queremos permitir a todos los directores de 
-- departamentos que puedan acceder a todos los datos de la tabla 
-- de empleados, pero solo aquellos de los que son directores 
-- inmediatos y no a otros.

-- Creamos la vista:
			
			CREATE VIEW	VSALCO
			AS SELECT TEMPLE.*
			FROM TDEPTO,TEMPLE
			WHERE TEMPLE.NUMDE = '112' and 
				  TDEPTO.NUMDE = TEMPLE.NUMDE;	
				  
			
			SELECT * FROM VSALCO	 
		

	--------------------------------------------------------------------------------------------
INSERT INTO TEMPLE VALUES (110, 112,  350, '10-11-1929', '15-02-1950', 987,  NULL,   3,     'PONS, CESAR');
INSERT INTO TEMPLE VALUES (120, 112,  840, '09-06-1935', '01-10-1968', 350,  110,    2,     'LASA, MAYO');
INSERT INTO TEMPLE VALUES (130, 112,  810, '09-09-1945', '01-02-1969', 290,  110,    2,     'TEROL, LUCIANO');
INSERT INTO TEMPLE VALUES (150, 121,  340, '10-08-1930', '15-01-1948', 440,  NULL,   0,     'PEREZ, JULIO');
INSERT INTO TEMPLE VALUES (160, 110,  740, '09-07-1939', '11-11-1968', 310,  110,    2,     'AGUIRRE, AUREO');
INSERT INTO TEMPLE VALUES (180, 110,  508, '18-10-1934', '18-03-1956', 480,  50,     2,     'PEREZ, MARCOS');
INSERT INTO TEMPLE VALUES (190, 121,  350, '12-05-1932', '11-02-1962', 300,  NULL,   4,     'VEIGA, JULIANA');
INSERT INTO TEMPLE VALUES (210, 100,  200, '28-09-1940', '22-01-1959', 380,  0,      2,     'GALVEZ, PILAR');
INSERT INTO TEMPLE VALUES (240, 111,  760, '26-02-1942', '24-02-1966', 280,  100,    3,     'SANZ, LAVINIA');
INSERT INTO TEMPLE VALUES (250, 100,  250, '27-10-1946', '01-03-1967', 450,  0,      0,     'ALBA, ADRIANA');
INSERT INTO TEMPLE VALUES (260, 100,  220, '03-12-1943', '12-07-1968', 720,  0,      6,     'LOPEZ, ANTONIO');
INSERT INTO TEMPLE VALUES (270, 112,  800, '21-05-1945', '10-10-1966', 380,  80,     3,     'GARCIA, OCTIAVIO');
INSERT INTO TEMPLE VALUES (280, 130,  410, '11-01-1948', '08-10-1971', 290,  0,      5,     'FLOR, DOROTEA');
INSERT INTO TEMPLE VALUES (285, 122,  620, '25-10-1949', '15-02-1968', 380,  0,      0,     'P0LO, OTILIA');
INSERT INTO TEMPLE VALUES (290, 120,  910, '30-11-1947', '14-02-1968', 270,  0,      3,     'GIL, GLORIA');
INSERT INTO TEMPLE VALUES (310, 130,  480, '21-11-1946', '15-01-1971', 420,  0,      0,     'GARCIA, AUGUSTO');
INSERT INTO TEMPLE VALUES (320, 122,  620, '25-12-1957', '05-02-1978', 405,  0,      2,     'SANZ, CORNELIO');
INSERT INTO TEMPLE VALUES (330, 112,  850, '19-08-1948', '01-03-1972', 280,  90,     0,     'DIEZ, AMELIA');
INSERT INTO TEMPLE VALUES (350, 122,  610, '13-04-1949', '10-09-1984', 450,  0,      1,     'CAMPS, AURELIO');
INSERT INTO TEMPLE VALUES (360, 111,  750, '29-10-1958', '10-10-1968', 250,  100,    2,     'LARA, DORINDA');
INSERT INTO TEMPLE VALUES (370, 121,  360, '22-06-1967', '20-01-1987', 190,  0,      1,     'RUIZ, FABIOLA');
INSERT INTO TEMPLE VALUES (380, 112,  880, '30-03-1968', '01-01-1988', 180,  0,      0,     'MARTIN, MICAELA');
INSERT INTO TEMPLE VALUES (390, 110,  500, '19-02-1966', '08-10-1986', 215,  0,      1,     'MORAN, CARMEN');
INSERT INTO TEMPLE VALUES (400, 111,  780, '18-08-1969', '01-11-1987', 185,  0,      0,     'LARA, LUCRECIA');
INSERT INTO TEMPLE VALUES (410, 122,  660, '14-07-1968', '13-10-1988', 175,  0,      0,     'MU?OZ, AZUCENA');
INSERT INTO TEMPLE VALUES (420, 130,  450, '22-10-1966', '19-11-1988', 400,  0,      0,     'FIERRO, CLAUDIA');
INSERT INTO TEMPLE VALUES (430, 122,  650, '26-02-1967', '19-11-1988', 210,  0,      1,     'MORA, VALERIANA');
INSERT INTO TEMPLE VALUES (440, 111,  760, '26-09-1966', '28-02-1986', 210,  100,    0,     'DURAN, LIVIA');
INSERT INTO TEMPLE VALUES (450, 112,  880, '21-10-1966', '28-02-1986', 210,  100,    0,     'PEREZ, SABINA');
INSERT INTO TEMPLE VALUES (480, 111,  760, '04-04-1965', '28-02-1986', 210,  100,    1,     'PINO, DIANA');
INSERT INTO TEMPLE VALUES (490, 112,  880, '06-06-1964', '01-01-1988', 180,  100,    0,     'TORRES, HORACIO');
INSERT INTO TEMPLE VALUES (500, 111,  750, '08-10-1965', '01-01-1987', 200,  100,    0,     'VAZQUEZ, HONORIA');
INSERT INTO TEMPLE VALUES (506, NULL, 502, '15-02-1980', '12-05-2006', 500,  200,    2,     'Lopez, Antonio');
INSERT INTO TEMPLE VALUES (510, 110,  550, '04-05-1966', '01-11-1986', 200,  0,      1,     'CAMPOS, ROMULO');
INSERT INTO TEMPLE VALUES (550, 111,  780, '10-01-1970', '21-01-1988', 100,  120,    0,     'SANTOS, SANCHO');




-- sp_help: Presenta informaci�n acerca de un objeto de base de datos (cualquier objeto de la vista de compatibilidad
-- sys.sysobjects).

                sp_help VEMPLE200;
				sp_helptext VEMPLE2003;
				sp_helptext VEMPLE2005;

-- sp_depends: Muestra informaci?n acerca de las dependencias de los objetos de la base de datos, tales como las vistas 
-- y procedimientos que dependen de una tabla o de una vista, y las tablas y vistas de las que depende la vista o el 
-- procedimiento. 

               sp_depends VEMPLE200;
               sp_depends VEMPLE2001;
			   go

-- sp_helptext: Muestra definiciones de reglas definidas por el usuario, valores predeterminados, procedimientos 
-- almacenados de Transact-SQL no cifrados, funciones Transact-SQL definidas por el usuario, desencadenadores, columnas 
-- calculadas, restricciones CHECK, vistas u objetos del sistema, como un procedimiento almacenado del sistema.


	            sp_helptext VEMPLE2003;
				go
	            sp_helptext VEMPLE2005;
-- Encriptada
			    CREATE VIEW VEMPLE11 with encryption
                as SELECT * FROM TEMPLE
			    WHERE SALAR > 200;
			
			   
			    sp_helptext VEMPLE11

			
			
			 
			
		


-- sys.columns :Devuelve una fila por cada columna de cada tabla y vista, y una fila por cada 
-- par?metro de un procedimiento almacenado de la base de datos.

            SELECT * FROM sys.columns
            
-- sys.objects :Contiene una fila para cada objeto de ?mbito de esquema definido por el usuario
-- que se cree en la base de datos.

            SELECT * FROM sys.objects
            
-- sys.syscomments : Contiene una entrada por cada vista, regla, valor predeterminado, desencadenador, restricci?n CHECK,
-- restricci?n DEFAULT y procedimiento almacenado de la base de datos. La columna text contiene las instrucciones de 
--definici?n de SQL originales.

            SELECT * FROM sys.syscomments