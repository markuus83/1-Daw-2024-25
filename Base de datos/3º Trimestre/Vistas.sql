DROP DATABASE IF EXISTS a23marcoscc_ALMACEN_25;
GO
CREATE DATABASE a23marcoscc_ALMACEN_25;
GO

USE a23marcoscc_ALMACEN_25;

CREATE TABLE DEPARTAMENTOS
( IDDepartamento TINYINT,
  Nombre 		 VARCHAR(30),
  Localidad 	 VARCHAR(10),
 PRIMARY KEY (IDDepartamento));
 
CREATE TABLE EMPLEADOS
( IDEmpleado	 INT,
  Nombre 		 VARCHAR(30),
  Oficio 		 VARCHAR(10),
  DIRECTOR 		 INT,
  FechaAlta 	 DATE,
  Salario 		 SmallMoney,
  Comision 		 DECIMAL(4,2),
  IDDepartamento TINYINT,  
  PRIMARY KEY (IDEmpleado),
  CONSTRAINT IDDirector FOREIGN KEY (DIRECTOR) REFERENCES EMPLEADOS(IDEmpleado),
  FOREIGN KEY (IDDepartamento) REFERENCES DEPARTAMENTOS(IDDepartamento)  ON DELETE SET NULL
);
 
CREATE TABLE CLIENTES
(IDCliente		INT,
 Nombre 		VARCHAR(25),
 Localidad      VARCHAR(14),
 IDComercial    INT,
 Debe			Money,
 Haber			Money,
 Credito    	SmallMoney,
 PRIMARY KEY (IDCliente),
 FOREIGN KEY (IDComercial) REFERENCES EMPLEADOS(IDEmpleado) ON DELETE SET NULL
);
 
CREATE TABLE PRODUCTOS
(IDProducto  		INT,
 Descripcion  		VARCHAR(30),
 PrecioActual 		MONEY,
 Stock				INT,
 PRIMARY KEY (IDProducto) 
);
 
CREATE TABLE PEDIDOS
(IDPedido      	INT IDENTITY(1000,1),
 IDProducto		INT,
 IDCliente 		INT,
 UNIDADES 	    INT,
 Fecha_pedido   DATE,
 PRIMARY KEY (IDPedido),
 FOREIGN KEY (IDProducto) REFERENCES PRODUCTOS(IDProducto) ON DELETE CASCADE,
 FOREIGN KEY (IDCliente) REFERENCES CLIENTES(IDCliente) ON DELETE CASCADE 
);
 
-- DEPARTAMENTOS
INSERT INTO DEPARTAMENTOS VALUES(10, 'CONTABILIDAD', 'BARCELONA');
INSERT INTO DEPARTAMENTOS VALUES(20, 'INVESTIGACION', 'VALENCIA');
INSERT INTO DEPARTAMENTOS VALUES(30, 'COMERCIAL',     'MADRID'); 
INSERT INTO DEPARTAMENTOS VALUES(40, 'PRODUCCION',    'SEVILLA');
INSERT INTO DEPARTAMENTOS VALUES(50, 'MONTAJE',    'SEVILLA');

-- EMPLEADOS
INSERT INTO EMPLEADOS VALUES (7839,'REY FRANCISCO', 'PRESIDENTE', NULL, '1981-11-17',6000,   NULL, NULL);
INSERT INTO EMPLEADOS VALUES (7698,'GARRIDO MARIA', 'DIRECTOR',  7839, '1984-05-01',3850.12,NULL, 30);
INSERT INTO EMPLEADOS VALUES (7782,'MARTINEZ ANA',  'DIRECTOR',  7839, '1985-06-09',2450,   NULL, 10);
INSERT INTO EMPLEADOS VALUES (7499,'ALONSO JOS?',   'VENDEDOR',  7698, '1982-02-23',1400,   0.04,30);
INSERT INTO EMPLEADOS VALUES (7521,'LOPEZ PACO',    'EMPLEADO',  7782, '1981-05-08',1350.50,NULL,10);      
INSERT INTO EMPLEADOS VALUES (7654,'PAZ MARTIN',    'VENDEDOR',  7698, '1984-09-28',1500,   0.16, 30);
INSERT INTO EMPLEADOS VALUES (7844,'CALVO JUAN',    'VENDEDOR',  7698, '1985-09-08',1800,   0,    30);
INSERT INTO EMPLEADOS VALUES (7876,'GIL ROCIO',     'ANALISTA',  7782, '1987-05-06',3350,   NULL, 20);
INSERT INTO EMPLEADOS VALUES (7900,'JIMENEZ MARIO', 'EMPLEADO',  7782, '1983-03-24',1400,   NULL, 20);	
INSERT INTO EMPLEADOS VALUES (7901,'PEREZ JUAN', 'DIRECTOR',  7839, '1978-11-23', 3850.12, NULL, 30);

-- CLIENTES
INSERT INTO CLIENTES VALUES (101, 'DISTRIBUCIONES GOMEZ', 'MADRID', 7499, 0,0,5000);
INSERT INTO CLIENTES VALUES (102, 'LOGITRONICA S.L', 'BARCELONA', 7654,0,0,5000);
INSERT INTO CLIENTES VALUES (103, 'INDUSTRIAS LACTEAS S.A.', 'LAS ROZAS', 7844,0,0, 10000);
INSERT INTO CLIENTES VALUES (104, 'TALLERES ESTESO S.A.', 'SEVILLA', 7654, 0, 0, 5000);
INSERT INTO CLIENTES VALUES (105, 'EDICIONES SANZ', 'BARCELONA', 7499, 0,0,5000);
INSERT INTO CLIENTES VALUES (106, 'SIGNOLOGIC S.A.', 'MADRID', 7654,0,0,5000);
INSERT INTO CLIENTES VALUES (107, 'MARTIN Y ASOCIADOS S.L.', 'ARAVACA' , 7844,0,0, 10000);
INSERT INTO CLIENTES VALUES (108, 'MANUFACTURAS ALI S.A.', 'SEVILLA', 7654, 0, 0, 5000);
INSERT INTO CLIENTES VALUES (109, 'EDICIONES PEREZ', NULL, 7499, 0,0,4000);
INSERT INTO CLIENTES VALUES (110, 'TALLERES ARAUJO', NULL, 7499, 0,0,2000);

-- PRODUCTOS
INSERT INTO PRODUCTOS VALUES (10,'MESA DESPACHO MOD. GAVIOTA', 550, 50);
INSERT INTO PRODUCTOS VALUES (20, 'SILLA DIRECTOR MOD. BUFALO', 670, 25);
INSERT INTO PRODUCTOS VALUES (30, 'ARMARIO NOGAL DOS PUERTAS', 460, 20);
INSERT INTO PRODUCTOS VALUES (40, 'MESA MODELO UNI?N',340, 15);
INSERT INTO PRODUCTOS VALUES (50, 'ARCHIVADOR CEREZO',1050, 20);
INSERT INTO PRODUCTOS VALUES (60, 'CAJA SEGURIDAD MOD B222', 280, 15);
INSERT INTO PRODUCTOS VALUES (70, 'DESTRUCTORA DE PAPEL A3',450, 25);
INSERT INTO PRODUCTOS VALUES (80, 'MODULO ORDENADOR MOD. ERGOS', 550, 25);

--PEDIDOS
INSERT INTO PEDIDOS VALUES( 20, 103, 3, '2017-10-06');
INSERT INTO PEDIDOS VALUES( 50, 106, 2, '2017-10-06');
INSERT INTO PEDIDOS VALUES( 10, 101, 4, '2016-10-07');
INSERT INTO PEDIDOS VALUES( 20, 105, 4, '2015-10-16');
INSERT INTO PEDIDOS VALUES( 40, 106, 8, '2016-10-20');
INSERT INTO PEDIDOS VALUES( 30, 105, 2, '2017-10-20');
INSERT INTO PEDIDOS VALUES( 70, 103, 3, '2016-11-03');
INSERT INTO PEDIDOS VALUES( 50, 101, 2, '2016-11-06');
INSERT INTO PEDIDOS VALUES( 10, 106, 6, '2017-11-16');
INSERT INTO PEDIDOS VALUES( 20, 105, 2, '2016-11-26');
INSERT INTO PEDIDOS VALUES( 40, 102, 3, '2016-12-08');
INSERT INTO PEDIDOS VALUES( 30, 106, 2, '2017-12-15');
INSERT INTO PEDIDOS VALUES( 10, 105, 3, '2017-12-06');
INSERT INTO PEDIDOS VALUES( 30, 106, 2, '2017-12-06');
INSERT INTO PEDIDOS VALUES( 20, 101, 4, '2017-01-07');
INSERT INTO PEDIDOS VALUES( 70, 105, 4, '2018-01-16');
INSERT INTO PEDIDOS VALUES( 20, 105, 6, '2018-01-20');
;



SELECT * FROM DEPARTAMENTOS;
SELECT * FROM EMPLEADOS;
SELECT * FROM CLIENTES;
SELECT * FROM PRODUCTOS;
SELECT * FROM PEDIDOS;
GO 

SELECT * FROM DEPARTAMENTOS;
SELECT * FROM EMPLEADOS;
SELECT * FROM CLIENTES;
SELECT * FROM PRODUCTOS;
SELECT * FROM PEDIDOS;
 

--- EJERCICIOS VISTAS ---
 

-- Crear una vista que nos de todos los datos de los empleados del departamento de Investigacion y
-- los datos del departamento
  
	GO
		CREATE OR ALTER VIEW V_DatosEmpleados AS
			SELECT e.*, d.IDDepartamento as idDepto, d.Nombre as Departamento, d.Localidad 
			FROM EMPLEADOS e JOIN DEPARTAMENTOS d 
			ON e.IDDepartamento = d.IDDepartamento
			WHERE D.Nombre = 'Investigacion'
	 GO

	SELECT * FROM V_DatosEmpleados

-- Insertamos a traves de la vista creada un nuevo Investigador Luc?a Gonz?lez con un sueldo de 2600 en el departamento 20

	INSERT INTO V_DatosEmpleados (IDEmpleado , Nombre, Oficio, Director, FechaAlta, Salario, Comision, IDDepartamento) VALUES(1001 ,'Lucía González', 2600, 20);

	SELECT * FROM V_DatosEmpleados

	
-- Insertamos en la vista creada un nuevo Empleado Pepe D?az con un sueldo de 1000 en el departamento 10
  
	INSERT INTO V_DatosEmpleados (IDEmpleado , Nombre, Salario, IDDepartamento) VALUES(1002 ,'Pepe Díaz', 1000, 10);

	SELECT * FROM V_DatosEmpleados


-- Actualizamos el sueldo de los otros investigadores a 2800

	UPDATE V_DatosEmpleados
		set Salario = 2800
		WHERE Nombre NOT LIKE 'Lucía González';

	SELECT * FROM V_DatosEmpleados

	DROP VIEW V_DatosEmpleados;


-- Creamos una nueva Vista que muestra todos los datos de los empleados con los datos de sus departamentos 

	GO
		CREATE OR ALTER VIEW V_DatosCompletos AS
		SELECT e.*, d.IDDepartamento as idDepto, d.Nombre as Departamento, d.Localidad 
			FROM EMPLEADOS e JOIN DEPARTAMENTOS d 
			ON e.IDDepartamento = d.IDDepartamento
	GO

   SELECT * FROM V_DatosCompletos

   DROP VIEW V_DatosCompletos;


-- Los comerciales no pueden ver los datos de los clientes de los otros Vendedores. 
-- Crear una vista de clientes para el empleado 'CALVO JUAN'

	SELECT * FROM CLIENTES;
	SELECT * FROM EMPLEADOS;

	GO
		CREATE OR ALTER VIEW V_DatosVendedores as
			SELECT e.*, c.IDCliente, c.Nombre as NombreCliente, c.Localidad, c.IDComercial, c.Debe, c.Haber, c.Credito
			FROM CLIENTES c JOIN EMPLEADOS e
			ON e.IDEmpleado = c.IDComercial
			WHERE	e.Nombre = 'CALVO JUAN' OR 
					-- e.Nombre = UPPER('Calvo Juan') OR   -> No es necesario porque tiene un case insensitive
					e.IDEmpleado = '7844'
	GO

	sp_help CalvoJuan_Clientes

	SELECT * FROM V_DatosVendedores


-- Insertar en la vista creada para JUAN CALVO un nuevo cliente, Peco Tecnolog?as de Santiago.

	SELECT * FROM V_DatosVendedores

		INSERT INTO V_DatosVendedores(IDCliente, NombreCliente, Localidad, IDComercial) VALUES(111, 'Peco Tecnologías', 'Santiago', 7844);

	SELECT * FROM V_DatosVendedores

	DROP VIEW V_DatosVendedores;

-- Crear una vista para los pedidos de los clientes de JUAN CALVO a�adiendo los datos del cliente

SELECT * FROM CLIENTES
SELECT * FROM PEDIDOS

	GO
		CREATE OR ALTER VIEW V_DatosVendedores as
			SELECT c.*, p.IDPedido, p.IDProducto, p.IDCliente as NumCliente, p.Unidades, p.Fecha_pedido
			FROM PEDIDOS p JOIN CLIENTES c
			ON p.IDCliente = c.IDCliente
			WHERE c.IDComercial = '7844'
	GO

	SELECT * FROM V_DatosVendedores
	DROP VIEW V_DatosVendedores;

-- Crear una vista con la informaci?n de los comerciales cuyo director es el 7839 CON CHECK OPTION

	GO
		CREATE OR ALTER VIEW V_DatosComerciales AS
			SELECT * 
			FROM EMPLEADOS e
			WHERE Director = '7839' WITH CHECK OPTION
	GO

	SELECT * FROM V_DatosComerciales

-- Actualizar la comision de JUAN CALVOa 0.22.

	UPDATE V_DatosComerciales
		SET Comision = 0.22
		WHERE Nombre = 'Juan Calvo'

-- Insertar un pedido de 2 mesas de despacho y 2 sillas bufalo para el nuevo cliente de juan