USE a23marcoscc_BD_EMPRESA;

-- 1. Nome de todos os fabricantes dos que hai produtos na BD (sen combinacións)
	SELECT DISTINCT nome
	FROM FABRICANTE
	WHERE codigo IN	(	SELECT cod_fabricante 
						FROM PRODUTO);


-- 2. Nome de todos os fabricantes dos que non hai produtos na BD (sen combinacións)
	SELECT DISTINCT nome
	FROM FABRICANTE
	WHERE codigo NOT IN (	SELECT cod_fabricante 
							FROM PRODUTO);

	SELECT DISTINCT nome
	FROM FABRICANTE f LEFT JOIN PEDIDO p
	ON f.codigo = p.cod_fabricante 
	WHERE p.cod_fabricante IS NULL
	
-- 3. Pedidos recibidos nos días en que un novo empregado foi contratado
	
	SELECT numero, cantidade, CONVERT(DATE,data_pedido,103) AS dia
	FROM PEDIDO
	WHERE data_pedido IN (	SELECT data_contrato
							FROM EMPREGADO);



-- 4. Sucursais cuxo obxectivo supera a media das cotas de todos os vendedores
	SELECT cidade, obxectivo
	FROM SUCURSAL
	WHERE obxectivo > (	SELECT AVG(cota_de_vendas) 
						FROM EMPREGADO);


-- 5. Empregados cuxa cantidade media de pedido supera a media global
	SELECT num_empregado, AVG(cantidade) AS media_pedidos
	FROM PEDIDO
	GROUP BY num_empregado
	HAVING AVG(cantidade) > (SELECT AVG(cantidade) FROM PEDIDO);


-- 6. Clientes que aínda non fixeron pedidos
	SELECT nome
	FROM CLIENTE
	WHERE numero NOT IN (	SELECT num_cliente 
							FROM PEDIDO);


-- 7. Empregados con cotas iguais ou superiores ao obxectivo da sucursal de Vigo
	SELECT nome, ape1, ape2
	FROM EMPREGADO
	WHERE cota_de_vendas >= (	SELECT obxectivo 
								FROM SUCURSAL 
								WHERE cidade = 'Vigo');


-- 8. Produtos con polo menos un pedido de 20 ou máis unidades (usando EXISTS)
	SELECT DISTINCT P.descricion
	FROM PRODUTO P
	WHERE EXISTS (	SELECT 1 
					FROM PEDIDO PE
					WHERE PE.id_produto = P.identificador
					AND PE.cod_fabricante = P.cod_fabricante
					AND PE.cantidade >= 20
		);


-- 9. Cidades con empregados cuxa cota representa máis do 80% do obxectivo da súa sucursal
	SELECT cidade
	FROM SUCURSAL S
	WHERE EXISTS (	SELECT 1 
					FROM EMPREGADO E
					WHERE E.id_sucursal_traballa = S.identificador
					AND E.cota_de_vendas >= 0.8 * S.obxectivo
	);

-- 10. Clientes cuxos empregados asignados traballan en sucursais da rexión OESTE
	SELECT nome
	FROM CLIENTE
	WHERE num_empregado_asignado IN (	SELECT numero 
										FROM EMPREGADO
										WHERE id_sucursal_traballa IN (	SELECT identificador 
																		FROM SUCURSAL
																		WHERE rexion = 'OESTE'
		)
	);
