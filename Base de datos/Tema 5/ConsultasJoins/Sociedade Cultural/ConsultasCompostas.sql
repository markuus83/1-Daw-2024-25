--Enunciados de consultas de Join Propostas
--BD EMPRESA_XG

use a23marcoscc_BD_EMPRESA_XG;

--1. Nome de todos os fabricantes dos que se fixeron pedidos.
	SELECT * FROM FABRICANTE;
	SELECT * FROM PEDIDO;

	SELECT DISTINCT f.nome
	FROM  FABRICANTE f JOIN PEDIDO p
	ON f.codigo = p.cod_fabricante;


--2. Nome de todos os fabricantes con ou sen pedidos.
--Se tiveron pedidos aparecerá o número de pedido.
--Se non ten pedidos aparecerá como número de pedido 99.

	SELECT * FROM FABRICANTE;
	SELECT * FROM PEDIDO;

	SELECT f.nome, ISNULL(p.id_produto, 99)
	FROM FABRICANTE f LEFT JOIN PEDIDO p
	ON f.codigo = p.cod_fabricante
	
	
	

--3. Nome de todos os fabricantes con ou sen pedidos.
--Se tiveron pedidos aparecerá o número de pedido.
--Se non ten pedidos aparecerá 'Sen pedidos'.

	--Solucion profe
	SELECT f.nome, ISNULL(CAST(p.numero AS VARCHAR(30)), 'Sen pedido')
	FROM FABRICANTE f LEFT JOIN PEDIDO p
	ON f.codigo = p.cod_fabricante

	--Mi solucion
	SELECT f.nome, CONVERT(VARCHAR(30), ISNULL(p.numero, 'Sen pedido')) 
	FROM FABRICANTE f LEFT JOIN PEDIDO p
	ON f.codigo = p.cod_fabricante

	--Mi solucion correcta
	SELECT f.nome, ISNULL(CONVERT(VARCHAR(30), p.numero),'Sen pedido')
	FROM FABRICANTE f LEFT JOIN PEDIDO p
	ON f.codigo = p.cod_fabricante



--4. Código dos produtos (cod_fabricante-id_produto) en unha columna e
--a descrición,  solo de los  produtos que non foron pedidos

	SELECT pr.cod_fabricante + ' -- ' + pe.id_produto as codProdutos, pr.descricion
	FROM PRODUTO pr LEFT JOIN PEDIDO pe
		ON pr.cod_fabricante = pe.cod_fabricante
		AND pr.identificador = pe.id_produto
	WHERE pe.numero IS NULL;



--5. Produto cartesiano entre a táboa de 
--sucursais e a de empregados, con os nomes completos dos 
--empregados en unha columna. 

	SELECT e.ape1 + ' ' + ape2 + ', ' + e.nome AS nomeCompleto
	FROM SUCURSAL s CROSS JOIN EMPREGADO e



--6. Número e nome completo de todos os empregados, 
--así como a cidade da sucursal que dirixen. 
--Nos empregados que non son directores de sucursais, 
--aparecerá? 'Non é director.'.

	SELECT e.numero, e.ape1 + ' ' + ISNULL(e.ape2,'') + ', ' + e.nome AS nomeCompleto, ISNULL(s.cidade, 'Non é director') as sucursal
	FROM EMPREGADO e LEFT JOIN SUCURSAL s
		ON e.numero = s.num_empregado_director
		


--7. Número e nome completo dos empregados que teñen xefe, 
--co número do seu xefe nunha segunda columna. 

	SELECT CONVERT(VARCHAR(30),numero) + ' -- ' + ape1 + ' ' + ISNULL(ape2,'') + ', ' + nome AS datosEmprefado, num_empregado_xefe
	FROM EMPREGADO
	WHERE num_empregado_xefe is not null



--8, Número e nome completo dos empregados que teñen xefe, 
--co número e nome do seu xefe nunha segunda columna. 

	SELECT	e.numero as numEmpregado, e.ape1 + ' ' + ISNULL(e.ape2,'') + ', ' + e.nome AS nomeCompleto, x.numero as numXefe
	FROM EMPREGADO e JOIN EMPREGADO x 
	ON e.numero = x.num_empregado_xefe


--8a, Número e nome completo de todos os empregados, dos que teñen xefe, 
--co número e nome do seu xefe nunha segunda columna. e si non teñen xefe que poña: 'Xefe por designar.'

	SELECT	 CONVERT(VARCHAR(30),e.numero) + ' -- ' +  e.ape1 + ' ' + ISNULL(e.ape2,'') + ', ' + e.nome AS datosEmpregado, 
			ISNULL(CONVERT(VARCHAR(30),x.numero) + ' -- ' + x.nome, 'Xefe por designar') as nomeXefe

	FROM EMPREGADO e LEFT JOIN EMPREGADO x 
	ON e.numero = x.num_empregado_xefe


--9. Nome completo de todos os empregados co 
--nome dos clientes que teñen asignado, así como os dos clientes
--ainda que non tiveran empregado. 

	SELECT e.ape1 + ' ' + ISNULL(e.ape2,'') + ', ' + e.nome AS nomeCompleto, c.nome as nomeCliente
	FROM EMPREGADO e RIGHT JOIN CLIENTE c
	ON e.numero = c.num_empregado_asignado

	

--10. Escolle unha das túas solucións das consultas propostas 
--nas que empregaches un LEFT JOIN, e modifícaa usando RIGHT JOIN. 

	SELECT e.ape1 + ' ' + ISNULL(e.ape2,'') + ', ' + e.nome AS nomeCompleto, c.nome as nomeCliente
	FROM CLIENTE c LEFT JOIN EMPREGADO e
	ON e.numero = c.num_empregado_asignado

