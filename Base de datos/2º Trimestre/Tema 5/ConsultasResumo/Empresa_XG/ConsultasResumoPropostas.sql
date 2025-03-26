use a23marcoscc_BD_EMPRESA_XG;

--Seleccionamos a BD EMPRESA_XG
--USE EMPRESA_XG;

-- Enunciados consultas resumen.
--1. Media de unidades vendidas por vendedor.

   SELECT num_empregado, AVG(cantidade) MediaProductos
   FROM PEDIDO
   group by num_empregado

--2. Prezo máis barato de produto, prezo máis caro,
--prezo medio, suma de todos os prezos 
--e número de produtos distintos existentes.
    
	SELECT MIN(prezo) MinPrezo, MAX(prezo) MaxPrezo, AVG(prezo) MediaPrezo, SUM(prezo) SumaPrezo, COUNT(DISTINCT identificador) NumProdutos
	FROM PRODUTO


--3. Número de pedidos realizados polo cliente 1103.

	SELECT count(numero) numPedidos
	FROM PEDIDO
	WHERE num_cliente = '1103'
	


--4. Número de pedidos realizados por cada cliente.

    SELECT count(numero) as numeropedidos
	FROM PEDIDO
	GROUP BY num_cliente


--5. Número de pedidos realizados por cada cliente
--só para os clientes que fixeran máis de 2 pedidos.

	SELECT count(numero) as numeroPedidos
    FROM PEDIDO
    GROUP BY num_cliente
    HAVING count(numero) > 2


--6. Número de pedidos realizados por cada cliente
--só para os clientes que fixeran máis de 2 pedidos
--e que ademais teñen unha media de unidades 
--mercadas (cantidade) inferior a 10.

    SELECT num_cliente, count(numero) as numeroPedidos
    FROM PEDIDO
    GROUP BY num_cliente
    HAVING count(numero) > 2 AND AVG(cantidade) < 10


--7. Cantidade total de sucursais que hai por rexión. 
--Aparecerá o nome da rexión e na mesma columna 
--separado por un guión, a cantidade de sucursais
--situadas nesa rexión.

   SELECT rexion + ' - ' + CONVERT(VARCHAR(10), COUNT(identificador)) AS CantidadeSucursais
   FROM SUCURSAL
   group by rexion

