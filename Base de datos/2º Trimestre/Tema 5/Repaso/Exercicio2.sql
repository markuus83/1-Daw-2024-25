USE a23marcoscc_BD_EMPRESA_XG;

-- 1. Media de unidades vendidas por vendedor.

	SELECT num_empregado, AVG(cantidade) AS media_Ventas
	FROM PEDIDO
	GROUP BY num_empregado


-- 2. Precio mas barato de producto, precio mas caro,
-- precio medio, suma de todos los precios
-- y numero de productos distintos existentes.

	SELECT	MIN(prezo) AS prezoMinimo, 
			MAX(prezo) AS prezoMaximo, 
			AVG(prezo) AS mediaPrezio, 
			SUM(prezo) AS sumaPrezo, 
			COUNT(identificador) as numProdutos
	FROM PRODUTO
	


-- 3. Numero de pedidos realizados por el cliente 1103.

	SELECT num_cliente, COUNT(numero) AS numPedidos
	FROM PEDIDO
	WHERE num_cliente = '1103'
	GROUP BY num_cliente


-- 4. Numero de pedidos realizados por cada cliente.

	SELECT num_cliente, COUNT(numero) AS numPedidos
	FROM PEDIDO
	GROUP BY num_cliente


-- 5. Numero de pedidos realizados por cada cliente
-- solo para los clientes que hicieron mas de 2 pedidos.

	SELECT num_cliente, COUNT(numero) AS numPedidos
	FROM PEDIDO
	GROUP BY num_cliente
	HAVING COUNT(numero) > 2


-- 6. Numero de pedidos realizados por cada cliente
-- solo para los clientes que hicieron mas de 2 pedidos
-- y que ademas tienen una media de unidades
-- compradas (cantidad) inferior a 10.

	SELECT num_cliente, COUNT(numero) AS numPedidos, AVG(cantidade) as mediaCantidade
	FROM PEDIDO
	GROUP BY num_cliente
	HAVING COUNT(numero) > 2 AND AVG(cantidade) < 10


-- 7. Cantidad total de sucursales que hay por region.
-- Aparecera el nombre de la region y en la misma columna
-- separado por un guion, la cantidad de sucursales
-- situadas en esa region.

	SELECT rexion + '  -  ' + CONVERT(VARCHAR(5), COUNT(identificador)) AS datosRexion 
	FROM SUCURSAL
	GROUP BY rexion