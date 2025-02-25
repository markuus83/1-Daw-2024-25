--Seleccionamos a BBDD
use a23marcoscc_BD_EMPRESA;

--1. Empregando unha consulta composta realizar unha listaxe do código do fabricante e identificador daqueles 
-- produtos con prezo superior a 60€ ou que teñan pedidos de cantidade inferior a 5 unidades.
--O resultado aparecerá ordenado por fabricante e para o mesmo fabricante por produto.

	SELECT cod_fabricante, identificador
	FROM PRODUTO
	WHERE prezo > 60

	UNION

	SELECT cod_fabricante, id_produto
	FROM PEDIDO
	WHERE cantidade < 5

	ORDER BY cod_fabricante, identificador

--2. Empregando unha consulta composta amosar os código dos empregados que non fixeron pedidos.
--Deberán aparecer primeiro os empregados con código maior.

	SELECT numero as numeroEmpregado
	FROM EMPREGADO e

	EXCEPT 

	SELECT num_empregado
	FROM PEDIDO p

	ORDER BY e.numero


--3. Empregando unha consulta composta amosar o código dos clientes que fixeron pedidos e con límite de crédito maior ou igual a 40000. 
--Usa unha diferenza para resolver esta consulta.

	SELECT num_cliente
	FROM PEDIDO

	INTERSECT

	SELECT numero
	FROM CLIENTE
	WHERE limite_de_credito >= 40000

	ORDER BY num_cliente


--4. Empregando unha consulta composta amosar os código dos clientes que fixeron pedidos e con límite de crédito maior ou igual a 40000. 
--Usa unha intersección para resolver esta consulta. Ordena o resultado por código de cliente en orde ascendente.


	


--5. Empregando unha consulta composta amosar o código dos empregados que son directores dalgunha sucursal ou que teñen unha cota de vendas superior a 250000€.
--Debes propoñer dúas solucións:
--na primeira só pode aparecer unha vez cada empregado no resultado, e,
--na segunda se un empregado é director dunha sucursal e ademais ten unha cota superior a 250000€, aparecerá no resultado máis dunha vez.
 
	-- SOLUCION 1
		SELECT num_empregado_director
		FROM SUCURSAL

		UNION all

		SELECT numero
		FROM EMPREGADO
		WHERE cota_de_vendas > 250000


	-- SOLUCION 2