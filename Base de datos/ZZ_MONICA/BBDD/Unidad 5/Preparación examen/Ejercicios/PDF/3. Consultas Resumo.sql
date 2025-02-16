
			-------------------------------------------------------------- 3. Tarefas de Consultas Resumo --------------------------------------------------------------

USE EMPRESA;

--Proposta 1 => Media de unidades vendidas de cada vendedor. O resultado terá dúas columnas, na primeira o número identificador do empregado (vendedor) e nunha segunda columna a media de unidades vendidas 
--(campo cantidade) nos seus pedidos.
USE EMPRESA;

	SELECT num_empregado as identificador, AVG(cantidade) AS media_unidades
	FROM PEDIDO
	GROUP BY num_empregado


--Proposta 2 => Prezo máis barato de produto, prezo máis caro, prezo medio, suma total dos prezos de produto, e número de produtos distintos existentes.
USE EMPRESA;

	SELECT	MIN(prezo) AS prezo_minimo,
			MAX(prezo) AS prezo_maximo,
			AVG(prezo) AS prezo_medio,
			SUM(prezo) AS suma_total,
			COUNT(identificador) AS productos_existentes 

	FROM PRODUTO;	


--Proposta 3 => Número de pedidos realizados polo cliente 1103.
USE EMPRESA;

	SELECT COUNT(numero) AS num_pedidos
	FROM PEDIDO
	WHERE num_cliente = '1103';


--Proposta 4 => Número de pedidos realizados por cada cliente. No resultado aparecerá o identificador do cliente e na segunda columna o número de pedidos que leva feitos cada cliente ata o de agora.
USE EMPRESA;

	SELECT num_cliente, COUNT(numero) AS numeroPedidos
	FROM PEDIDO
	GROUP BY num_cliente;


--Proposta 5 => Repite a consulta anterior, pero agora no resultado só poderán aparecer os clientes que fixeron máis de 2 pedidos.
USE EMPRESA;

	SELECT num_cliente, COUNT(numero) AS numeroPedidos
	FROM PEDIDO
	GROUP BY num_cliente
	HAVING COUNT(numero) > 2
	
	

--Proposta 6 => Repite a consulta anterior, pero agora no resultado só poderán aparecer os clientes que fixeron máis de 2 pedidos e que ademais teñen unha media de unidades mercadas (cantidade) inferior a 10.
USE EMPRESA;

	SELECT num_cliente, COUNT(numero) AS numeroPedidos
	FROM PEDIDO
	GROUP BY num_cliente
	HAVING	COUNT(numero) > 2;


	SELECT num_cliente, COUNT(numero) AS numeroPedidos
	FROM PEDIDO
	GROUP BY num_cliente
	HAVING	COUNT (numero) > 2 AND
			AVG (cantidade) < 10;


--Proposta 7 => Cantidade total de sucursais que hai por rexión. Aparecerá o nome da rexión e na mesma columna separado por un guión, a cantidade de sucursais situadas nesa rexión.
USE EMPRESA;

	SELECT rexion + '  -  ' + CAST( COUNT(identificador) AS VARCHAR (5)) AS total_sucursais
	FROM SUCURSAL
	GROUP BY rexion;