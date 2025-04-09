USE ALMACEN;

SELECT * FROM EMPLEADOS;


/***************** VISTAS *****************/


-- Crear una vista de los empleados vendedores.
GO
CREATE VIEW V_VENDEDORES AS
   	SELECT * FROM EMPLEADOS WHERE oficio LIKE 'VENDEDOR';
GO

-- Comprobamos los datos de la vista
 SELECT *  	FROM V_VENDEDORES

-- Que pasa si se inserta en la tabla de empleados un vendedor
 INSERT INTO EMPLEADOS VALUES(1001,'Alvarez Ramon', 'VENDEDOR', 7839, '2021-03-10', 2700, 0.22, 30);
  SELECT *  	FROM V_VENDEDORES;
  -- Se ve en la vista tambi�n

-- Que pasa si se insertan vendedores desde la vista:
INSERT INTO V_VENDEDORES VALUES(1002,'Fern�ndez Rodrigo', 'VENDEDOR', 7839, '2021-04-10', 2500, 0.2, 30);
INSERT INTO V_VENDEDORES VALUES(1003,'Rodr�guez Marta', 'VENDEDOR', 7839, '2021-03-10', 3000, 0.24, 30);
 
 SELECT * FROM V_VENDEDORES;
 SELECT * FROM EMPLEADOS;
 -- Que pasa si se insertan otro tipo de empleado desde la vista:
INSERT INTO V_VENDEDORES VALUES(1004,'Vazquez Sara', 'ANALISTA', 7839, '2020-04-22', 3000, 0.2, 30);
GO
-- Se inserta en la tabla, pero no se ve en la vista, ya que solo muestra vendedores


-- Alterar la vista a�adiendo check options:
CREATE or ALTER VIEW  V_VENDEDORES  as
   	SELECT *
	FROM empleados
	WHERE oficio LIKE 'VENDEDOR' WITH CHECK OPTION;
GO
-- Si la vista fue creada con la cl�usula 'WITH CHECK OPTION'  
-- solo inserta en la tabla subyacente los que cumplen la condicion de la vista.

-- Intentar insertar un vendedor:
INSERT INTO V_VENDEDORES VALUES (1006,'Blanco Francisco', 'VENDEDOR', 7839, '2020-09-22', 2600, 0.15, 30);
-- S� se permite a�adir esta fila 
 
INSERT INTO V_VENDEDORES VALUES(1007,'Bola Ana', 'ANALISTA', 7839, '2015-04-22', 3000, 0.2, 30);
-- NO permite a�adir esta fila porque no pertenecer�a a la vista 
 

-- Eliminar la vista
DROP VIEW IF EXISTS V_VENDEDORES;


-- Crear una vista con nombres de columnas distintos, si no los nombres de las columnas ser�n los dados en la SELECT
-- Creamos la vista de los comerciales cuyo director es 7839
GO
CREATE or ALTER VIEW  V_COMERCIALES (IDComercial, Nombre, Director, FechaAlta, Salario, Comision, IDDpto)
AS
   	SELECT IDEmpleado, Nombre, Director, FechaAlta, Salario, Comision, IDDepartamento
	FROM EMPLEADOS
	WHERE Director = 7839 WITH CHECK OPTION;
GO

INSERT INTO V_COMERCIALES VALUES(1005, 'Mendez Ramon', 7839, '2021-03-30', 2500, 0.2, 30);


 SELECT * FROM V_COMERCIALES;
 SELECT * FROM EMPLEADOS;
 
-- Modificar datos a traves de una vista
 
-- Cambiar el salario al vendedor Juan Calvo a 2400
 SELECT * FROM V_COMERCIALES;
 SELECT * FROM EMPLEADOS;          

UPDATE V_COMERCIALES  
	SET salario ='2400' 
		WHERE Nombre = 'PEREZ JUAN'
-- Cambiar el salario al vendedorLOPEZ PACO a 2200			
-- No Deja por ser   WITH CHECK OPTION;
UPDATE V_COMERCIALES  
	SET salario ='2200' 
		WHERE Nombre = 'LOPEZ PACO'
			
		  
-- Eliminar la vista
DROP VIEW IF EXISTS V_COMERCIALES;


-- Para ver informacion de la vista
EXEC sp_help INFOCOMERCIALES;

-- Para ver la informaci�n informaci�n acerca de las dependencias de las vistas
EXEC sp_depends INFOCOMERCIALES;