 
-------------------------------------------- CONSULTAS CON SUBCONSULTAS --------------------------------------------

use EMPRESA;

-- Exercicio 1 => Nome de todos os fabricantes dos que hai produtos na BD. Non se permite usar combinacións nesta consulta.

	SELECT nome
	FROM FABRICANTE
	WHERE codigo in (SELECT cod_fabricante
						FROM PRODUTO)


-- Exercicio 2 =>  Nome de todos os fabricantes dos que non hai produtos na BD. Non se permite usar combinacións nesta consulta.
	SELECT nome
	FROM FABRICANTE
	WHERE codigo NOT IN (SELECT cod_fabricante
						FROM PRODUTO)


-- Exercicio 3 =>  Número de pedido, cantidade e data de pedido para aqueles pedidos recibidos nos días en que un novo empregado foi contratado. Non se permite usar
--combinacións nesta consulta.

	SELECT numero, cantidade, data_pedido
	FROM PEDIDO
	WHERE data_pedido IN (SELECT data_contrato
						  FROM EMPREGADO)
					


-- Exercicio 4 =>  Cidade e obxectivo das sucursais cuxo obxectivo supera a media das cotas de todos os vendedores da BD. Non se permite usar combinacións nesta consulta.

	SELECT cidade, obxectivo
	FROM SUCURSAL
	WHERE obxectivo > (SELECT AVG(cota_de_vendas)
						FROM EMPREGADO)


-- Exercicio 5 => Número de empregado e cantidade media dos pedidos daqueles empregados cuxa cantidade media de pedido é superior á cantidade media global (de todos os pedidos). -- Non se permiten usar combinacións nesta consulta.	SELECT num_empregado, AVG(cantidade) as cantidade_media	FROM PEDIDO	GROUP BY num_empregado	HAVING AVG(cantidade) > ( SELECT AVG(cantidade)								FROM PEDIDO);


-- Exercicio 6 => Nome dos clientes que aínda non fixeron pedidos. Non se permite usar combinacións nesta consulta.
	SELECT nome
	FROM CLIENTE
	WHERE numero NOT IN (SELECT num_cliente
							FROM PEDIDO);


-- Exercicio 7 => Nome completo dos empregados cuxas cotas son iguais ou superiores ao obxectivo da sucursal da cidade de Vigo. Ten en conta que se a cota dun vendedor (empregado) 
--é nula debemos considerala como un 0, e do mesmo xeito actuaremos co obxectivo da sucursal. Non se permite usar combinacións nesta consulta.

	SELECT nome, ape1, ape2
	FROM EMPREGADO
	WHERE ISNULL(cota_de_vendas, 0) >= (SELECT ISNULL(obxectivo,0)
										FROM SUCURSAL
										WHERE cidade='Vigo');


-- Exercicio 8 => Nome dos produtos para os que existe polo menos un pedido que ten unha cantidade de polo menos 20 unidades. Hai que lembrar que a identificación dun produto faise pola combinación 
--do código do fabricante e o do produto. A solución deberá facerse empregando o predicado EXISTS cunha subconsulta correlacionada. Non se permite usar combinacións.
	SELECT descricion
	FROM PRODUTO
	WHERE EXISTS (SELECT numero
					FROM PEDIDO pe, PRODUTO pr
					WHERE pe.cantidade >= 20 AND
					pr.cod_fabricante = pe.cod_fabricante AND
					pr.identificador = pe.id_produto);



-- Exercicio 9 => Cidades das sucursais onde exista algún empregado cuxa cota de vendas represente máis do 80% do obxectivo da oficina onde traballa. Para resolver esta consulta deberase empregar 
--unha subconsulta correlacionada precedida de ANY.




-- Exercicio 10 => Nome dos clientes cuxos empregados asignados traballan en sucursais da rexión OESTE. Non se poden usar joins, só subconsultas encadeadas. Me cagoentuputa madre
	
	SELECT nome
	FROM CLIENTE
	WHERE num_empregado_asignado IN (SELECT numero
										FROM EMPREGADO
										WHERE id_sucursal_traballa IN (SELECT identificador
																		FROM SUCURSAL
																		WHERE rexion= 'Oeste'))