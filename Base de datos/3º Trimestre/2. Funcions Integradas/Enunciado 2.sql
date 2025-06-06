-- Enunciado Distribuidora
-- Tenemos una empresa distribuidora de material y productos de Oficina repartida en varias localidades.
-- Dada la siguiente base de datos realiza las consultas y modificaciones que se proponen

DROP DATABASE IF EXISTS DISTRIBUIDORA;
GO
CREATE DATABASE DISTRIBUIDORA;
GO
USE DISTRIBUIDORA;
 

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
INSERT INTO EMPLEADOS VALUES (7499,'ALONSO JOS�',   'VENDEDOR',  7698, '1982-02-23',1400,   0.04,30);
INSERT INTO EMPLEADOS VALUES (7521,'LOPEZ PACO',    'EMPLEADO',  7782, '1981-05-08',1350.50,NULL,10);      
INSERT INTO EMPLEADOS VALUES (7654,'PAZ MARTIN',    'VENDEDOR',  7698, '1984-09-28',1500,   0.16, 30);
INSERT INTO EMPLEADOS VALUES (7844,'CALVO JUAN',    'VENDEDOR',  7698, '1985-09-08',1800,   0,    30);
INSERT INTO EMPLEADOS VALUES (7876,'GIL ROCIO',     'ANALISTA',  7782, '1987-05-06',3350,   NULL, 20);
INSERT INTO EMPLEADOS VALUES (7900,'JIMENEZ MARIO', 'EMPLEADO',  7782, '1983-03-24',1400,   NULL, 20);	



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
INSERT INTO PRODUCTOS VALUES(10,'MESA DESPACHO MOD. GAVIOTA', 550, 50);
INSERT INTO PRODUCTOS VALUES (20, 'SILLA DIRECTOR MOD. BUFALO', 670, 25);
INSERT INTO PRODUCTOS VALUES (30, 'ARMARIO NOGAL DOS PUERTAS', 460, 20);
INSERT INTO PRODUCTOS VALUES (40, 'MESA MODELO UNI�N',340, 15);
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
SELECT * FROM CLIENTES
SELECT * FROM PRODUCTOS;
SELECT * FROM PEDIDOS;
 

-- A�ade una columna email en la tabla empleados y clientes su valor tiene que ser �nico.
--Di que ocurre.

-- Crea una tabla contactos con el nombre de clientes, su tel�fono y su email
 
-- A�ade a esa tabla los nombres y los tel�fonos de los comerciales
 
-- Que pedidos realiz� el cliente DISTRIBUCIONES GOMEZ, si devuelve vac�o explica porqu�.
-- Como compruebas si el campo nombre es sensible a Acentos e indica con qu� sentencia cambiar�as 
  

-- Muestra el id del cliente y la fecha de los �ltimos 3 pedidos
 
  
-- Muestra cu�l es el producto de mayor precio
 

-- Muestra cu�l es el producto de menor precio


-- Calcula la cantidad total que suman todos los productos que hay en el stock
  

-- Calcula el n�mero total de clientes que aparecen en la tabla cliente.
 

-- Devuelve el identificador, nombre y primer apellido de aquellos clientes 
-- cuya localidad es null. El listado deber� estar ordenado por comercial
 


--  Obtener los datos del pedido m�s reciente.


-- Listar todos los empleados y a qu� departamento pertenece
 
-- Obtener un listado de clientes, indicando el n�mero de cliente y su nombre, y el n�mero y nombre de sus comerciales asignados.
 


-- Obtener una lista de los nombres de los clientes con el importe acumulado de sus pedidos.
 


-- Crear una tabla empleados_sin_comision con la columnas id y nombre de la tabla empleados y nombre de la tabla departamentos, 
-- e insertar todos los empleados que tengan comisi�n igual a cero.
 


/** delete & update **/

-- Elimina el departamento de MONTAJE


-- Elimina el cliente con el nombre INDUSTRIAS LACTEAS ...


-- Actualiza el email de dos empleados: PAZ MARTIN -> paz@distribuidora.com y REY FRANCISCO -> reyf@distribuidora.com


-- A�adir 0.2 de comisi�n a los empleados tengan una comisi�n menor de 0.5
 
 

-- Rebajar un 10 % el precio de todos los productos de los que no se ha vendido nada.
 

-- A�adir 50 euros al salario de los empleados de la empresa que pertenezcan a departamentos de MADRID y BARCELONA
 


-- Incrementar en un 10% el salario del empleado que tiene al cliente que ha hecho la compra de mayor n�mero de unidades
  
 
-- Se quiere borrar al empleado MARTINEZ ANA. Para poder hacerlo sin errores, previamente,  en una sentencia anterior  hay que
-- actualizar los empleados de los que sea jefa MARTINEZ  cambiandoles el director al jefe REY F. - id=7839
 