
		-------------------------------------------------------------- 4. Tarefa de Consultas Combinacions Internas, Externas e Cruzadas --------------------------------------------------------------

USE EMPRESA;

--Proposta 1 => Nome de todos os fabricantes dos que se fixeron pedidos. Debes propoñer dúas solucións, unha coa sintaxe coa condición de combinación no WHERE, e outra coa sintaxe coa condición 
--de combinación no FROM.
USE EMPRESA;

	-- SOLUCION 1

		SELECT DISTINCT f.nome
		FROM FABRICANTE f, PEDIDO p
		WHERE f.codigo = p.cod_fabricante;

	-- SOLUCION 2

		SELECT DISTINCT f.nome
		FROM FABRICANTE f INNER JOIN PEDIDO p ON 
			 f.codigo = p.cod_fabricante;


--Proposta 2 => Nome de todos os fabricantes, fixéranse ou non pedidos. Se tiveron pedidos aparecerá o nome e nunha segunda columna o número de pedido. Se dun fabricante se fixeron máis dun pedido,
--aparecerá tantas veces como pedidos se lle fixeron. No caso de non ter pedido, como número de pedido deberá aparecer o valor 99.
USE EMPRESA;

	SELECT f.nome, ISNULL(p.numero, '99') AS num_pedido
	FROM FABRICANTE f LEFT JOIN PEDIDO p
		ON f.codigo = p.cod_fabricante;

	

--Proposta 3 => Nome de todos os fabricantes, fixéranse ou non pedidos. Se tiveron pedidos aparecerá o nome e nunha segunda columna o número de pedido. Se dun fabricante se fixeron máis dun pedido,
--aparecerá tantas veces como pedidos se lle fixeron. No caso de non ter pedido, como número de pedido deberá aparecer a frase 'Sen pedidos.'.
USE EMPRESA;

	SELECT f.nome, ISNULL( CAST(p.numero AS VARCHAR(12) ), 'Sen pedidos.') AS num_pedido
	FROM FABRICANTE f LEFT JOIN PEDIDO p
		ON f.codigo = p.cod_fabricante;


--Proposta 4 => Código dos produtos (co formato cod_fabricante-id_produto) e descrición, dos produtos que non foron pedidos nunca.
USE EMPRESA;

	SELECT p.cod_fabricante + ' - ' + p.id_produto AS id_produto, pr.descricion 
	FROM PEDIDO p RIGHT JOIN PRODUTO pr
		ON	p.cod_fabricante = pr.cod_fabricante AND
			p.id_produto = pr.identificador;


--Proposta 5 => Produto cartesiano entre a táboa de sucursais e a de empregados. Nunha primeira columna aparecerá a cidade da sucursal e na segunda o nome completo do empregado (co formato nome ape1 ape2).
--Débense propoñer dúas solucións, segundo a sintaxe empregada para o produto cartesiano.
USE EMPRESA;

	-- SOLUCION 1

		SELECT s.cidade, e.nome + e.ape1 + ISNULL(e.ape2 , ' ') AS nome_completo
		FROM SUCURSAL s CROSS JOIN EMPREGADO e;

	-- SOLUCION 2
		SELECT s.cidade, e.nome + e.ape1 + ISNULL(e.ape2 , ' ') AS nome_completo
		FROM SUCURSAL s, EMPREGADO e;



--Proposta 6 => Número e nome completo (co formato nome ape1 ape2) de todos os empregados, así como a cidade da sucursal que dirixen, se é que dirixen algunha. Na terceira columna, de nome sucursal_que_dirixe,
-- nas filas dos empregados que non son directores de sucursais, deberá aparecer a frase 'Non é director'.
USE EMPRESA;

	SELECT	e.numero AS numero,
			e.nome + e.ape1 + ISNULL(e.ape2 , ' ') AS nome_completo,
			ISNULL(s.cidade, 'Non é director.') AS sucursal

	FROM	EMPREGADO e LEFT JOIN SUCURSAL s
			ON e.numero = s.num_empregado_director;


--Proposta 7 => Número e nome completo dos empregados que teñen xefe, co número e o nome completo do seu xefe nunha segunda columna. (Revisa o concepto Autocombinación ou self join). 
--Nas columnas aparecerán o número separado do nome completo por un guión.
USE EMPRESA;

	SELECT	CAST(e.numero AS VARCHAR(5))+ ' - ' + e.nome + e.ape1 + ISNULL(e.ape2 , ' ') AS nome_empregado,
			CAST(x.num_empregado_xefe AS VARCHAR(5)) + ' - ' + x.nome + x.ape1 + ISNULL(x.ape2 , ' ') AS nome_xefe

	FROM EMPREGADO e, EMPREGADO x

	WHERE e.num_empregado_xefe = x.numero;

	
--Proposta 8 => Número e nome completo de todos os empregados, co número e o nome completo do seu xefe nunha segunda columna. Nas columnas aparecerán o número separado do nome completo por un guión.
--Se algún empregado non tivese xefe, na segunda columna debe aparecer a frase 'Xefe por designar.'. 
USE EMPRESA;

	SELECT	(CAST(e.numero AS VARCHAR(5))+ ' - ' + e.nome + e.ape1 + ISNULL(e.ape2 , ' ')) AS nome_empregado,
			ISNULL(CAST(x.num_empregado_xefe AS VARCHAR(5)) + ' - ' + x.nome + x.ape1 + ISNULL(x.ape2 , ' '), 'Xefe por designar.') AS nome_xefe

	FROM	EMPREGADO e LEFT JOIN EMPREGADO x
			ON e.num_empregado_xefe = x.numero;



 

	SELECT	ISNULL(e.nome + ' ' + e.ape1 + ' ' + ISNULL(e.ape2, ' '), 'Sen vendedor.') AS nombre_empleado, 
			ISNULL(c.nome, 'Sen cliente.') AS nombre_cliente

	FROM EMPREGADO e FULL JOIN CLIENTE c

	ON e.numero = c.num_empregado_asignado
