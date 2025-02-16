

-------------------------------- TAREFAS DE CONSULTAS CON COMBINACI�NS INTERNAS, EXTERNAS E CRUZADAS --------------------------------

use EMPRESA;

-- Proposta 1 => Nome de todos os fabricantes dos que se fixeron pedidos. Debes propo�er d�as soluci�ns, unha coa condici�n de combinaci�n no WHERE, e outra coa sintaxe coa condici�n de combinaci�n no FROM.

	-- FORMA 1:

		SELECT DISTINCT  f.nome
		FROM FABRICANTE f, PEDIDO p
		WHERE f.codigo = p.cod_fabricante;

	-- FORMA 2: 

		SELECT DISTINCT	f.nome
		FROM FABRICANTE f INNER JOIN PEDIDO p
			ON f.codigo = p.cod_fabricante;


-- Proposta 2 => Nome de todos os fabricantes, fix�ranse ou non pedidos. Se tiveron pedidos aparecer� o nome e nunha segunda columna, o pedido. Se din fabricante se fixeron m�is dun pedido, aparecer� tantas 
--veces como pedidos se lle fixeron. No caso de non ter pedido, como n�mero de pedido deber� aparecer o valor 99.

	SELECT f.nome, ISNULL(p.numero,'99') AS num_pedido

	FROM FABRICANTE f INNER JOIN PEDIDO p
		ON f.codigo = p.cod_fabricante; 


-- Proposta 3 => Nome de todos os fabricantes, fix�ranse ou non pedidos. Se tiveron pedidos aparecer� o nome e nunha segunda columna o n�mero de pedido. Se dun fabricante se fixeron m�is dun pedido, aparecer� 
--tantas veces como pedidos se lle fixeron. No caso de non ter pedido, como n�mero de pedido deber� aparecer a frase 'Sen pedidos'.

	SELECT f.nome, ISNULL(CAST(p.numero AS VARCHAR(30)), 'Sen pedido.') AS num_pedido
	
	FROM FABRICANTE f INNER JOIN PEDIDO p
		ON f.codigo = p.cod_fabricante; 


-- Proposta 4 =>  C�digo dos produtos (co formado cod_fabricante - id_produto) e descripci�n, dos produtos que non foron pedidos nunca.

	SELECT pr.cod_fabricante + ' - ' + pr.identificador AS id_produto, pr.descricion

	FROM PRODUTO pr LEFT JOIN PEDIDO pe
		ON pr.cod_fabricante = pe.cod_fabricante AND
		pr.identificador = pe.id_produto
		
	WHERE pe.numero IS NULL;


-- Proposta 5 => Produto cartesiano entre a t�boa de sucursais e a de empregados. Nunha primeira columna aparecer� a cidade da sucursal e na segunda o nome completo do empregado (co formato nome ape1 ape2). 
--D�bense propo�er d�as soluci�ns, segundo sintaxe empregada para o producto cartesiano.

	-- FORMA 1:

		SELECT s.cidade, e.nome + ' ' + e.ape1 + ' ' + ISNULL(e.ape2, ' ') AS nome_completo
		FROM SUCURSAL s, EMPREGADO e

	-- FORMA 2:

		SELECT s.cidade, e.nome + ' ' + e.ape1 + ' ' + ISNULL(e.ape2, ' ') AS nome_completo
		FROM SUCURSAL s CROSS JOIN EMPREGADO e;
		

-- Proposta 6 => N�mero e nome completo (co formato nome ape1 ape2) de todos os empregados, as� como a cidade da sucursal que dirixen, se � que dirixen algunha. Na terceira columna, de nome sucursal_que_dirixe,
--nas filas dos empregados que non son directores de sucursais, deber� aparecer a frase 'Non � director.'.

	SELECT e.numero, e.nome + ' ' + e.ape1 + ' ' + ISNULL(e.ape2, ' ') AS nome_completo, ISNULL(s.cidade, 'Non � director.') AS sucursal_que_dirixe

	FROM EMPREGADO e LEFT JOIN SUCURSAL s
		ON	e.numero = s.num_empregado_director;


-- Proposta 7 => N�mero e nome completo dos empregados que te�en xefe, co n�mero e o nome completo do seu xefe nunha segunda columna (Revisa o concepto Autocombinaci�n ou Self Join). Nas columnas aparecer�n o 
--n�mero separado do nmome completo por un gui�n.

	SELECT CAST(e.numero AS VARCHAR(30)) + ' - ' + e.nome + ' ' + e.ape1 + ' ' + ISNULL(e.ape2, ' ') AS empregado_normal,
			CAST(xefe.numero AS VARCHAR(30)) + ' -' + xefe.nome + ' ' + xefe.ape1 + ' ' + ISNULL(xefe.ape2, ' ') AS empregado_xefe

	FROM EMPREGADO e , EMPREGADO xefe
	WHERE e.numero = xefe.num_empregado_xefe


-- Proposta 8 => N�mero e nome completo de todos os empregados, co n�mero e o nome completo do seu xefe nunha segunda columna. Nas columnas aparecer�n o n�mero separado do nome completo por un gui�n. Se alg�n 
--empregado non tivese xefe, na segunda columna debe aparecer a frase 'Xefe por designar.'.

	SELECT CAST(e.numero AS VARCHAR(30)) + ' - ' + e.nome + ' ' + e.ape1 + ' ' + ISNULL(e.ape2, ' ') AS empregado_normal,
			ISNULL(CAST(xefe.numero AS VARCHAR(30)) + ' -' + xefe.nome + ' ' + xefe.ape1 + ' ' + ISNULL(xefe.ape2, ' '), 'Xefe por designar.') AS empregado_xefe

	FROM EMPREGADO e LEFT JOIN EMPREGADO xefe
		ON e.numero = xefe.numero;


-- Proposta 9 => Nome completo de todos os empregado co nome do cliente que te�en asignado. No caso de que non tivesen ning�n cliente aparecer� no nome do lciente a frase 'Sen cliente.'. Do mesmo ceito, --se un cliente non ten empregado asignado, na columna do empregado aparecer� 'Sen vendedor.'. � importante que aparezan todos os empregados, te�an ou non clientes e todos os clientes te�an ou non empregados.
	


-- Proposta 10 => Escolle das t�as soluci�n das consultas propostas nas que empregaches un LEFT JOIN, e modif�caa usando RIGHT JOIN.