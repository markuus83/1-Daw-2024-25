
		-------------------------------------------------------------- 4. Tarefa de Consultas Combinacions Internas, Externas e Cruzadas --------------------------------------------------------------

USE EMPRESA;

--Proposta 1 => Nome de todos os fabricantes dos que se fixeron pedidos. Debes propo�er d�as soluci�ns, unha coa sintaxe coa condici�n de combinaci�n no WHERE, e outra coa sintaxe coa condici�n 
--de combinaci�n no FROM.
USE EMPRESA;

	-- SOLUCION 1

		SELECT DISTINCT f.nome
		FROM FABRICANTE f, PEDIDO p
		WHERE f.codigo = p.cod_fabricante;

	-- SOLUCION 2

		SELECT DISTINCT f.nome
		FROM FABRICANTE f INNER JOIN PEDIDO p ON 
			 f.codigo = p.cod_fabricante;


--Proposta 2 => Nome de todos os fabricantes, fix�ranse ou non pedidos. Se tiveron pedidos aparecer� o nome e nunha segunda columna o n�mero de pedido. Se dun fabricante se fixeron m�is dun pedido,
--aparecer� tantas veces como pedidos se lle fixeron. No caso de non ter pedido, como n�mero de pedido deber� aparecer o valor 99.
USE EMPRESA;

	SELECT f.nome, ISNULL(p.numero, '99') AS num_pedido
	FROM FABRICANTE f LEFT JOIN PEDIDO p
		ON f.codigo = p.cod_fabricante;

	

--Proposta 3 => Nome de todos os fabricantes, fix�ranse ou non pedidos. Se tiveron pedidos aparecer� o nome e nunha segunda columna o n�mero de pedido. Se dun fabricante se fixeron m�is dun pedido,
--aparecer� tantas veces como pedidos se lle fixeron. No caso de non ter pedido, como n�mero de pedido deber� aparecer a frase 'Sen pedidos.'.
USE EMPRESA;

	SELECT f.nome, ISNULL( CAST(p.numero AS VARCHAR(12) ), 'Sen pedidos.') AS num_pedido
	FROM FABRICANTE f LEFT JOIN PEDIDO p
		ON f.codigo = p.cod_fabricante;


--Proposta 4 => C�digo dos produtos (co formato cod_fabricante-id_produto) e descrici�n, dos produtos que non foron pedidos nunca.
USE EMPRESA;

	SELECT p.cod_fabricante + ' - ' + p.id_produto AS id_produto, pr.descricion 
	FROM PEDIDO p RIGHT JOIN PRODUTO pr
		ON	p.cod_fabricante = pr.cod_fabricante AND
			p.id_produto = pr.identificador;


--Proposta 5 => Produto cartesiano entre a t�boa de sucursais e a de empregados. Nunha primeira columna aparecer� a cidade da sucursal e na segunda o nome completo do empregado (co formato nome ape1 ape2).
--D�bense propo�er d�as soluci�ns, segundo a sintaxe empregada para o produto cartesiano.
USE EMPRESA;

	-- SOLUCION 1

		SELECT s.cidade, e.nome + e.ape1 + ISNULL(e.ape2 , ' ') AS nome_completo
		FROM SUCURSAL s CROSS JOIN EMPREGADO e;

	-- SOLUCION 2
		SELECT s.cidade, e.nome + e.ape1 + ISNULL(e.ape2 , ' ') AS nome_completo
		FROM SUCURSAL s, EMPREGADO e;



--Proposta 6 => N�mero e nome completo (co formato nome ape1 ape2) de todos os empregados, as� como a cidade da sucursal que dirixen, se � que dirixen algunha. Na terceira columna, de nome sucursal_que_dirixe,
-- nas filas dos empregados que non son directores de sucursais, deber� aparecer a frase 'Non � director'.
USE EMPRESA;

	SELECT	e.numero AS numero,
			e.nome + e.ape1 + ISNULL(e.ape2 , ' ') AS nome_completo,
			ISNULL(s.cidade, 'Non � director.') AS sucursal

	FROM	EMPREGADO e LEFT JOIN SUCURSAL s
			ON e.numero = s.num_empregado_director;


--Proposta 7 => N�mero e nome completo dos empregados que te�en xefe, co n�mero e o nome completo do seu xefe nunha segunda columna. (Revisa o concepto Autocombinaci�n ou self join). 
--Nas columnas aparecer�n o n�mero separado do nome completo por un gui�n.
USE EMPRESA;

	SELECT	CAST(e.numero AS VARCHAR(5))+ ' - ' + e.nome + e.ape1 + ISNULL(e.ape2 , ' ') AS nome_empregado,
			CAST(x.num_empregado_xefe AS VARCHAR(5)) + ' - ' + x.nome + x.ape1 + ISNULL(x.ape2 , ' ') AS nome_xefe

	FROM EMPREGADO e, EMPREGADO x

	WHERE e.num_empregado_xefe = x.numero;

	
--Proposta 8 => N�mero e nome completo de todos os empregados, co n�mero e o nome completo do seu xefe nunha segunda columna. Nas columnas aparecer�n o n�mero separado do nome completo por un gui�n.
--Se alg�n empregado non tivese xefe, na segunda columna debe aparecer a frase 'Xefe por designar.'. 
USE EMPRESA;

	SELECT	(CAST(e.numero AS VARCHAR(5))+ ' - ' + e.nome + e.ape1 + ISNULL(e.ape2 , ' ')) AS nome_empregado,
			ISNULL(CAST(x.num_empregado_xefe AS VARCHAR(5)) + ' - ' + x.nome + x.ape1 + ISNULL(x.ape2 , ' '), 'Xefe por designar.') AS nome_xefe

	FROM	EMPREGADO e LEFT JOIN EMPREGADO x
			ON e.num_empregado_xefe = x.numero;



 

	SELECT	ISNULL(e.nome + ' ' + e.ape1 + ' ' + ISNULL(e.ape2, ' '), 'Sen vendedor.') AS nombre_empleado, 
			ISNULL(c.nome, 'Sen cliente.') AS nombre_cliente

	FROM EMPREGADO e FULL JOIN CLIENTE c

	ON e.numero = c.num_empregado_asignado
