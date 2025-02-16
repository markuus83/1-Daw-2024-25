
												--		TAREFA DE CONSULTAS RESUMO	||	 SQL

USE EMPRESA;

--Proposta 1 ==> Media de unidades vendidas de cada vendedor. O resultado ter� d�as columnas, na primeira o n�mero identificador do empregado (vendedor) e nunha segunda columna a media de unidades vendidas 
--(campo cantidade) nos seus pedidos.

	SELECT num_empregado AS vendedor, AVG(cantidade) AS media_unidades_vendidas
	FROM PEDIDO
	GROUP BY num_empregado;


--Proposta 2 ==> Prezo m�is barato de produto, prezo m�is caro, prezo medio, suma total dos prezos de produto, e n�mero de produtos existentes.

	SELECT	MIN(prezo) AS prezo_min,
			MAX(prezo) AS prezo_max,
			AVG(prezo) AS prezo_medio,
			SUM(prezo) AS prezo_total,
			COUNT(existencias) AS num_existencias
	FROM PRODUTO

--Proposta 3 ==> N�mero de pedidos realizados polo cliente 1103.

	SELECT COUNT(numero) AS pedidos_totales_cliente1103
	FROM PEDIDO
	WHERE num_cliente = 1103;
	

--Proposta 4 ==> N�mero de pedidos realizados por cada cliente. No resultado aparecer� o identificador do cliente e na segunda o n�mero de pedidos que leva feito cada cliente ata o de agora.

	SELECT num_cliente, COUNT(numero) AS numero_pedido
	FROM PEDIDO
	GROUP BY num_cliente;

--Proposta 5 ==> Repite a consulta anterior, pero agora no resultado s� poder�n aprecer os clientes que fixeron m�is de 2 pedidos.

	SELECT num_cliente, COUNT(numero) AS numero_pedido
	FROM PEDIDO
	GROUP BY num_cliente
	HAVING COUNT(numero)>2;

--Proposta 6 ==> Repite a consulta anterior, pero agora no resultado s� poder�n parecer os clientes que fixeron m�is de 2 pedidos e que ademais te�en unha media de unidades mercadas (cantidade) inferior a 10.

	SELECT num_cliente, COUNT(numero) AS numero_pedido
	FROM PEDIDO
	GROUP BY num_cliente
	HAVING COUNT(numero)>2 AND 
		   AVG(cantidade)<10;

--Proposta 7 ==> Cantidade total de sucursais que hai por rexi�n. Aparecer� o nome da rexi�n e na mesma columna separado por un gui�n, a cantidade de sucursais situadas nesa rexi�n.
	
	SELECT rexion + ' - ' + CAST(COUNT(*) AS VARCHAR(5)) AS total_sucursal
	FROM SUCURSAL
	GROUP BY rexion;
	 