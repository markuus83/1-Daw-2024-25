

-------------------------------- TAREFAS DE CONSULTAS CON COMBINACIÓNS INTERNAS, EXTERNAS E CRUZADAS --------------------------------

use EMPRESA;

-- Proposta 1 => Nome de todos os fabricantes dos que se fixeron pedidos. Debes propoñer dúas solucións, unha coa condición de combinación no WHERE, e outra coa sintaxe coa condición de combinación no FROM.

	-- FORMA 1:

		SELECT DISTINCT  f.nome
		FROM FABRICANTE f, PEDIDO p
		WHERE f.codigo = p.cod_fabricante;

	-- FORMA 2: 

		SELECT DISTINCT	f.nome
		FROM FABRICANTE f INNER JOIN PEDIDO p
			ON f.codigo = p.cod_fabricante;


-- Proposta 2 => Nome de todos os fabricantes, fixéranse ou non pedidos. Se tiveron pedidos aparecerá o nome e nunha segunda columna, o pedido. Se din fabricante se fixeron máis dun pedido, aparecerá tantas 
--veces como pedidos se lle fixeron. No caso de non ter pedido, como número de pedido deberá aparecer o valor 99.

	SELECT f.nome, ISNULL(p.numero,'99') AS num_pedido

	FROM FABRICANTE f INNER JOIN PEDIDO p
		ON f.codigo = p.cod_fabricante; 


-- Proposta 3 => Nome de todos os fabricantes, fixéranse ou non pedidos. Se tiveron pedidos aparecerá o nome e nunha segunda columna o número de pedido. Se dun fabricante se fixeron máis dun pedido, aparecerá 
--tantas veces como pedidos se lle fixeron. No caso de non ter pedido, como número de pedido deberá aparecer a frase 'Sen pedidos'.

	SELECT f.nome, ISNULL(CAST(p.numero AS VARCHAR(30)), 'Sen pedido.') AS num_pedido
	
	FROM FABRICANTE f INNER JOIN PEDIDO p
		ON f.codigo = p.cod_fabricante; 


-- Proposta 4 =>  Código dos produtos (co formado cod_fabricante - id_produto) e descripción, dos produtos que non foron pedidos nunca.

	SELECT pr.cod_fabricante + ' - ' + pr.identificador AS id_produto, pr.descricion

	FROM PRODUTO pr LEFT JOIN PEDIDO pe
		ON pr.cod_fabricante = pe.cod_fabricante AND
		pr.identificador = pe.id_produto
		
	WHERE pe.numero IS NULL;


-- Proposta 5 => Produto cartesiano entre a táboa de sucursais e a de empregados. Nunha primeira columna aparecerá a cidade da sucursal e na segunda o nome completo do empregado (co formato nome ape1 ape2). 
--Débense propoñer dúas solucións, segundo sintaxe empregada para o producto cartesiano.

	-- FORMA 1:

		SELECT s.cidade, e.nome + ' ' + e.ape1 + ' ' + ISNULL(e.ape2, ' ') AS nome_completo
		FROM SUCURSAL s, EMPREGADO e

	-- FORMA 2:

		SELECT s.cidade, e.nome + ' ' + e.ape1 + ' ' + ISNULL(e.ape2, ' ') AS nome_completo
		FROM SUCURSAL s CROSS JOIN EMPREGADO e;
		

-- Proposta 6 => Número e nome completo (co formato nome ape1 ape2) de todos os empregados, así como a cidade da sucursal que dirixen, se é que dirixen algunha. Na terceira columna, de nome sucursal_que_dirixe,
--nas filas dos empregados que non son directores de sucursais, deberá aparecer a frase 'Non é director.'.

	SELECT e.numero, e.nome + ' ' + e.ape1 + ' ' + ISNULL(e.ape2, ' ') AS nome_completo, ISNULL(s.cidade, 'Non é director.') AS sucursal_que_dirixe

	FROM EMPREGADO e LEFT JOIN SUCURSAL s
		ON	e.numero = s.num_empregado_director;


-- Proposta 7 => Número e nome completo dos empregados que teñen xefe, co número e o nome completo do seu xefe nunha segunda columna (Revisa o concepto Autocombinación ou Self Join). Nas columnas aparecerán o 
--número separado do nmome completo por un guión.

	SELECT CAST(e.numero AS VARCHAR(30)) + ' - ' + e.nome + ' ' + e.ape1 + ' ' + ISNULL(e.ape2, ' ') AS empregado_normal,
			CAST(xefe.numero AS VARCHAR(30)) + ' -' + xefe.nome + ' ' + xefe.ape1 + ' ' + ISNULL(xefe.ape2, ' ') AS empregado_xefe

	FROM EMPREGADO e , EMPREGADO xefe
	WHERE e.numero = xefe.num_empregado_xefe


-- Proposta 8 => Número e nome completo de todos os empregados, co número e o nome completo do seu xefe nunha segunda columna. Nas columnas aparecerán o número separado do nome completo por un guión. Se algún 
--empregado non tivese xefe, na segunda columna debe aparecer a frase 'Xefe por designar.'.

	SELECT CAST(e.numero AS VARCHAR(30)) + ' - ' + e.nome + ' ' + e.ape1 + ' ' + ISNULL(e.ape2, ' ') AS empregado_normal,
			ISNULL(CAST(xefe.numero AS VARCHAR(30)) + ' -' + xefe.nome + ' ' + xefe.ape1 + ' ' + ISNULL(xefe.ape2, ' '), 'Xefe por designar.') AS empregado_xefe

	FROM EMPREGADO e LEFT JOIN EMPREGADO xefe
		ON e.numero = xefe.numero;


-- Proposta 9 => Nome completo de todos os empregado co nome do cliente que teñen asignado. No caso de que non tivesen ningún cliente aparecerá no nome do lciente a frase 'Sen cliente.'. Do mesmo ceito, --se un cliente non ten empregado asignado, na columna do empregado aparecerá 'Sen vendedor.'. É importante que aparezan todos os empregados, teñan ou non clientes e todos os clientes teñan ou non empregados.
	


-- Proposta 10 => Escolle das túas solución das consultas propostas nas que empregaches un LEFT JOIN, e modifícaa usando RIGHT JOIN.