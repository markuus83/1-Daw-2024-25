USE EMPLEADOS_MarcosChouza;

--1 => Media de ventas de todas las oficinas.

SELECT AVG(ventas) as media_ventas_ofi
FROM oficina;


--2 => Gasto total realzado por el cliente ACME MFG.

SELECT  SUM(p.importe) AS importe_total

FROM CLIENTE c INNER JOIN pedido p
	on c.num_clie=p.clie

WHERE C.EMPRESA = 'ACME MFG.'


--3 Gasto total realizado por cada cliente. En el resultado aparecerá el nombre de la
--empresa cliente y en una segnda columna el importe del gasto en pedidos que lleva 
--realizado el cliente hasta ahora. En el resultado deberán aparecer primero los 
--clientes con mayor gasto.

SELECT c.empresa, SUM(p.importe) AS  importe_total

FROM cliente c LEFT JOIN pedido p
	ON c.num_clie=p.clie

GROUP BY c.num_clie, c.empresa


--4 => Realiza de nuevo la consulta anterior, pero ahora sólo deberán aparecer los clientes que hayan
-- realizado más de 10000 euros de gasto total.

SELECT c.empresa, SUM(p.importe) AS  importe_total

FROM cliente c INNER JOIN pedido p
	ON c.num_clie=p.clie

GROUP BY c.num_clie, c.empresa

HAVING SUM(p.importe) > 10000

ORDER BY importe_total DESC;

--5 => Realiza de nuevo la consulta anterior, pero ahora sólo deberán aparecer los clientes que hayan
--realizado más de 10000 euros de gasto total y además hayan hecho más de 2 pedidos

SELECT c.empresa, SUM(p.importe) AS  importe_total

FROM cliente c INNER JOIN pedido p
	ON c.num_clie=p.clie

GROUP BY c.num_clie, c.empresa

HAVING SUM(p.importe) > 10000 AND
		COUNT(p.num_pedido)>2

ORDER BY importe_total DESC;

--6 => Nombre de aquellos clientes cuyo límite de crédito supera el límite de crédito medio.




-- Nombre de aquellos clientes cuyo límite de crédito supera 5.

SELECT c.empresa
FROM cliente c
WHERE c.limite_credito> (SELECT AVG(LIMITE_CREDITO)
						 FROM CLIENTE cl)


-- 7 => Código y descripción del producto o productos con el precio menor.

SELECT pr.id_fab, pr.id_producto, pr.DESCRIPCION
FROM PRODUCTO pr
WHERE precio = (select min(precio)
				from producto);


-- 8 => Número total de pedidos que se han realizado del producto con descripción ARTICULO TIPO 2.

SELECT count(p.num_pedido) AS total

FROM producto pr INNER JOIN pedido p
	on pr.ID_FAB= p.FAB AND
	pr.ID_PRODUCTO = p.PRODUCTO

WHERE pr.DESCRIPCION = 'ARTICULO TIPO 2'

-- 9 => Número total de pedidos que se han realizado del producto con descripción ARTÍCULO TIPO 2 cuyo importe supera los 800 Euros.

--10 => N