
												--		TAREFA DE CONSULTAS RESUMO	||	 SQL

USE EMPRESA;

--Proposta 1 ==> Media de unidades vendidas de cada vendedor. O resultado terá dúas columnas, na primeira o número identificador do empregado (vendedor) e nunha segunda columna a media de unidades vendidas 
--(campo cantidade) nos seus pedidos.

	SELECT num_empregado AS vendedor, AVG(cantidade) AS media_unidades_vendidas
	FROM PEDIDO
	GROUP BY num_empregado;


--Proposta 2 ==> Prezo máis barato de produto, prezo máis caro, prezo medio, suma total dos prezos de produto, e número de produtos existentes.

	SELECT	MIN(prezo) AS prezo_min,
			MAX(prezo) AS prezo_max,
			AVG(prezo) AS prezo_medio,
			SUM(prezo) AS prezo_total,
			COUNT(existencias) AS num_existencias
	FROM PRODUTO

--Proposta 3 ==> Número de pedidos realizados polo cliente 1103.

	SELECT COUNT(numero) AS pedidos_totales_cliente1103
	FROM PEDIDO
	WHERE num_cliente = 1103;
	

--Proposta 4 ==> Número de pedidos realizados por cada cliente. No resultado aparecerá o identificador do cliente e na segunda o número de pedidos que leva feito cada cliente ata o de agora.

	SELECT num_cliente, COUNT(numero) AS numero_pedido
	FROM PEDIDO
	GROUP BY num_cliente;

--Proposta 5 ==> Repite a consulta anterior, pero agora no resultado só poderán aprecer os clientes que fixeron máis de 2 pedidos.

	SELECT num_cliente, COUNT(numero) AS numero_pedido
	FROM PEDIDO
	GROUP BY num_cliente
	HAVING COUNT(numero)>2;

--Proposta 6 ==> Repite a consulta anterior, pero agora no resultado só poderán parecer os clientes que fixeron máis de 2 pedidos e que ademais teñen unha media de unidades mercadas (cantidade) inferior a 10.

	SELECT num_cliente, COUNT(numero) AS numero_pedido
	FROM PEDIDO
	GROUP BY num_cliente
	HAVING COUNT(numero)>2 AND 
		   AVG(cantidade)<10;

--Proposta 7 ==> Cantidade total de sucursais que hai por rexión. Aparecerá o nome da rexión e na mesma columna separado por un guión, a cantidade de sucursais situadas nesa rexión.
	
	SELECT rexion + ' - ' + CAST(COUNT(*) AS VARCHAR(5)) AS total_sucursal
	FROM SUCURSAL
	GROUP BY rexion;
	 