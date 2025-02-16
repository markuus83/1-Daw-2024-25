				
				-------------------------- CONSULTAS_TIPO_EXAMEN -------------------------- 

-- EJERCICIO 1 => Consulta que devuelve en una primera columna la descripci�n y el precio de
-- todos los productos, separados por una barra invertida (por ejemplo ARTICULO TIPO2 \ 76), y en
-- una segunda columna el gasto total en pedidos de ese producto. Entre la descripci�n y la barra
-- invertida s�lo puede existir un espacio en blanco y entre la barra invertida y el precio otro espacio
-- en blanco.

-- En el resultado s�lo podr�n aparecer aquellos productos cuyo gasto medio es menor de 3000�.
-- La primera columna se llamar� Producto y la segunda Gasto total.
-- Si de alg�n producto no se han realizado pedidos en la columna del Gasto total deber� aparecer la
-- frase PRODUCTO QUE TODAVIA NO SE HA VENDIDO.

-- La columna del gasto total deber� mostrar los importes con 6 d�gitos como m�ximo en la parte
-- entera y 2 decimales.

-- Deber�n aparecer primero en el resultado los productos con mayor gasto total.use EMPLEADOS_MarcosChouza;	SELECT pr.DESCRIPCION + ' \ ' + CAST(pr.PRECIO AS VARCHAR(30)) AS producto, 			ISNULL (CONVERT (VARCHAR(37), CONVERT (NUMERIC (8,2), SUM (pe.importe))), 'PRODUCTO QUE NO SE HA VENDIDO')																				AS gasto_total	FROM PRODUCTO pr LEFT JOIN PEDIDO pe		ON pr.ID_FAB = pe.fab AND
		pr.ID_PRODUCTO = pe.PRODUCTOGROUP BY pr.ID_FAB, pr.ID_PRODUCTO, pr.DESCRIPCION, pr.PRECIO
HAVING AVG (pe.importe) < 3000
ORDER BY SUM (pe.importe) DESC;
--EJERCICIO 2 => Consulta que devuelva la lista de los pedidos que hace m�s de 24 a�os y menos
--de 28 a�os que se han realizado.--En el resultado deber� aparecer el n�mero del pedido, en una segunda columna la fecha del
--pedido con formato dd-mm-aaaa (F�jate que se separan con guiones y ll�male FechaPed) y en una
--tercera columna de nombre Unidades aparecer� lo siguiente en funci�n del n�mero de unidades
--solicitadas en el pedido:--	- Si la cantidad de unidades del pedido es menor que 7 aparecer� el texto POCAS.
--	- Si la cantidad de unidades del pedido es mayor o igual que 7 y menor que 30 aparecer� el
--	texto NORMAL.
--	- Si la cantidad de unidades del pedido es mayor o igual que 30 aparecer� el texto MUCHAS.
--Deben aparecer los pedidos m�s recientes primero. Aseg�rate que aparecen bien ordenados.USE EMPLEADOS_MarcosChouza;	SELECT 	FROM -- EJERCICIO 3 => USE EMPLEADOS_MarcosChouza;-- EJERCICIO 4 => -- EJERCICIO 5 => 