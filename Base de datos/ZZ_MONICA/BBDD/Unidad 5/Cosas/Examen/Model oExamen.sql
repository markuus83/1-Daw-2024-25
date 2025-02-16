--1.1
-- Consulta con 4 columnas: el n�mero identificador, el nombre completo (apellido 1, apellido2, nombre), 
-- los d�as que lleva contratado en la empresa y la cuota de ventas, de cada uno de los empleados que est�n 
-- asignados a alg�n cliente. Sialg�n vendedor no tiene cuota asignada deber� aparecer un 0 en su lugar. En 
-- el resultado deben aparecer primero los empleados que lleven menos d�as contratados



--1.2
--Consulta que evuelva la lista de los pedidos



--1.3 BD EMPRESA:
-- Utiliza una consulta ocmpuesta para obtener el c�digo de los productos de los que no se han hecho 
-- pedidos. En el resultado deben aparecer el identificador del fabricante y el del producto en una �nica 
-- columna de nombre PRODUCTOS SIN PEDIDO, por ejemplo aparecer� ASUAK47A. El resultado deber� aparecer 
-- ser� exactamente el que se indica, incluidos los espacios en blanco

USE EMPRESA_MarcosChouza;
SELECT p.cod_fabricante + p.identificador as "PRODUCTOS SIN PEDIDO"
FROM PRODUTO p
EXCEPT
SELECT pe.cod_fabricante + pe.id_produto
FROM PEDIDO pe
ORDER BY "PRODUCTOS SIN PEDIDO";


--1.4
--Consulta que devuelva el nombre de cada uno de los empleados del aBD, su fecha de contrato con forma dd/mm/aaaa y en otra tercera columna el importe medio de los pedidos del empleado (o llamado tambi�n vendedor). 
-- Si existiese alg�n vendedor (empleado) que no ha vendido nada, en la columna del importe deber� aparecer la frase 'ESTE EMPLEADO NO TIENE PEDIDOS'.
-- S�lo se mostrar�n los empleados cuyo pedido m�s caro no supere los 20.000� de importe y que adem�s, hayan sido contratados un d�a 1, 6 � 26 de cualquier mes y de cualquier a�o.
-- En la columna del importe medio se deber� mostrar los importes con 8 d�gitos como m�ximo en la parte entera y 2 decimales.
-- Deber�n aparecer primero en el resultado los empleados con mayor importe medio. En caso de que hubiese varios -- empleados con el mismo importe medio, deber�n aparecer primero los que tienen mayor antig�edad en la empresa. -- Aseg�rate que aparecen bien ordenados.

USE EMPRESA_MarcosChouza;

SELECT * FROM PEDIDO
SELECT	e.nome, CONVERT(CHAR(10), e.data_contrato, 103) ASFechaContrato,
		ISNULL( CONVERT (VARCHAR(30), CONVERT (NUMERIC(10,2), AVG(pe.cantidade * pr.prezo))), 
		'ESTE EMPLEADO NO TIENE PEDIDOS')

		AS MediaPedidos

FROM	(empregado e LEFT JOIN pedido pe ON e.numero = pe.num_empregado)
		LEFT JOIN PRODUTO pr ON pe.cod_fabricante = pr.cod_fabricante AND
		pe.id_produto = pr.identificador

WHERE DAY (e.data_contrato) IN (1, 6, 26)
GROUP BY e.nome, e.numero, e.data_contrato
HAVING ISNULL(MAX(pe.cantidade * pr.prezo),0) <= 20000
ORDER BY AVG(pe.cantidade*pr.prezo) DESC, e.data_contrato;

SELECT * FROM PRODUTO