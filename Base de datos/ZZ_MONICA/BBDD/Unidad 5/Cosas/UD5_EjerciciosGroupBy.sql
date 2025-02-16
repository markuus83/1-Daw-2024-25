USE EMPLEADOS_MarcosChouza;

--1 => Media de ventas de todas las oficinas.

SELECT AVG(ventas) as media_ventas_ofi
FROM oficina;


--2 => Gasto total realzado por el cliente ACME MFG.

SELECT  SUM(p.importe) AS importe_total

FROM CLIENTE c INNER JOIN pedido p
	on c.num_clie=p.clie

WHERE C.EMPRESA = 'ACME MFG.'


--3 Gasto total realizado por cada cliente. En el resultado aparecer� el nombre de la
--empresa cliente y en una segnda columna el importe del gasto en pedidos que lleva 
--realizado el cliente hasta ahora. En el resultado deber�n aparecer primero los 
--clientes con mayor gasto.

SELECT c.empresa, SUM(p.importe) AS  importe_total

FROM cliente c LEFT JOIN pedido p
	ON c.num_clie=p.clie

GROUP BY c.num_clie, c.empresa


--4 => Realiza de nuevo la consulta anterior, pero ahora s�lo deber�n aparecer los clientes que hayan
-- realizado m�s de 10000 euros de gasto total.

SELECT c.empresa, SUM(p.importe) AS  importe_total

FROM cliente c INNER JOIN pedido p
	ON c.num_clie=p.clie

GROUP BY c.num_clie, c.empresa

HAVING SUM(p.importe) > 10000

ORDER BY importe_total DESC;

--5 => Realiza de nuevo la consulta anterior, pero ahora s�lo deber�n aparecer los clientes que hayan
--realizado m�s de 10000 euros de gasto total y adem�s hayan hecho m�s de 2 pedidos

SELECT c.empresa, SUM(p.importe) AS  importe_total

FROM cliente c INNER JOIN pedido p
	ON c.num_clie=p.clie

GROUP BY c.num_clie, c.empresa

HAVING SUM(p.importe) > 10000 AND
		COUNT(p.num_pedido)>2

ORDER BY importe_total DESC;

--6 => Nombre de aquellos clientes cuyo l�mite de cr�dito supera el l�mite de cr�dito medio.




-- Nombre de aquellos clientes cuyo l�mite de cr�dito supera 5.

SELECT c.empresa
FROM cliente c
WHERE c.limite_credito> (SELECT AVG(LIMITE_CREDITO)
						 FROM CLIENTE cl)


-- 7 => C�digo y descripci�n del producto o productos con el precio menor.

SELECT pr.id_fab, pr.id_producto, pr.DESCRIPCION
FROM PRODUCTO pr
WHERE precio = (select min(precio)
				from producto);


-- 8 => N�mero total de pedidos que se han realizado del producto con descripci�n ARTICULO TIPO 2.

SELECT count(p.num_pedido) AS total

FROM producto pr INNER JOIN pedido p
	on pr.ID_FAB= p.FAB AND
	pr.ID_PRODUCTO = p.PRODUCTO

WHERE pr.DESCRIPCION = 'ARTICULO TIPO 2'

-- 9 => N�mero total de pedidos que se han realizado del producto con descripci�n ART�CULO TIPO 2 cuyo importe supera los 800 Euros.

--10 => N