			
			-------------------------------------------------------------- 2.Tarefas de consultas simples --------------------------------------------------------------

------------ BD SOCIEDADE_CULTURAL ------------

--Proposta 1 => Nome e apelidos (cada un nunha columna) de todos os empregados.
USE SOCIEDADE_CULTURAL;

	SELECT nome, ape1, ape2
	FROM EMPREGADO;

--Proposta 2 => N�mero, nome e apelidos (cada un nunha columna) de todos empregados.
USE SOCIEDADE_CULTURAL;

	SELECT numero, nome, ape1, ape2
	FROM EMPREGADO;


--Proposta 3 => N�mero, nome e apelidos (cada un nunha columna) de todos os empregados por orde alfab�tica de apelidos e nome.
 USE SOCIEDADE_CULTURAL;

	SELECT numero, nome, ape1, ape2
	FROM EMPREGADO
	ORDER BY ape1, ape2, nome ASC;


--Proposta 4 => N�mero, nome e apelidos (cada un nunha columna) de todos os empregados por orde alfab�tica de apelidos e nome. Os nomes das columnas no resultado ser�n: num_socio, nome_socio, apelido1, apelido2.
USE SOCIEDADE_CULTURAL;

	SELECT numero AS nun_socio, nome AS nome_socio, ape1 AS apelido1, ape2 AS apelido2
	FROM EMPREGADO
	ORDER BY ape1, ape2, nome ASC;


--Proposta 5 => N�mero, nome completo (os 4 campos nunha �nica columna, de nome socio, co formato numero - ape1 ape2, nome) e salario de todos os empregados. No resultado deber�n aparecer primeiro os que m�is cobran.
USE SOCIEDADE_CULTURAL;

	SELECT (CAST(numero AS VARCHAR(7)) + ' - '+ ape1 + ' ' + ape2  + ' ' + nome) AS socio, salario_mes as salario
	FROM EMPREGADO
	ORDER BY salario DESC;

--Proposta 6 => N�mero, nome completo (os 4 campos nunha �nica columna, de nome socio, co formato numero - ape1 ape2, nome) e salario de todo o profesorado. No resultado deber�n aparecer primeiro os que m�is cobran. 
--O campo cargo cont�n PRF para o profesorado, e ADM se � un ou unha administrativo.
USE SOCIEDADE_CULTURAL;

	SELECT (CAST(numero AS VARCHAR(7)) + ' - '+ ape1 + ' ' + ape2  + ' ' + nome) AS socio, salario_mes as salario
	FROM EMPREGADO
	WHERE cargo = 'PRF'
	ORDER BY salario DESC;

--Proposta 7 => N�mero identificador do profesorado que imparte clases. Como � l�xico, se un profesor imparte m�is dunha actividade, o seu n�mero s� pode aparecer unha vez.
USE SOCIEDADE_CULTURAL;

	SELECT DISTINCT num_profesorado_imparte
	FROM ACTIVIDADE;
	
	
--Proposta 8 => N�mero identificador das actividades �s que asiste profesorado, � dicir, cursadas por profesorado.
USE SOCIEDADE_CULTURAL;

	SELECT DISTINCT id_actividade
	FROM PROFE_CURSA_ACTI;

--Proposta 9 => Nome, importe, e importe rebaixado un 20%, da actividade de nome xadrez.
USE SOCIEDADE_CULTURAL;

	SELECT nome, prezo AS importe, prezo - (prezo * 0.20) AS prezo_rebaixado
	FROM ACTIVIDADE
	WHERE nome = 'XADREZ';

--Proposta 10 => NIF, nome e apelidos dos socios dos que non temos tel�fono gardado.
USE SOCIEDADE_CULTURAL;

	SELECT nif, nome, ape1, ape2
	FROM SOCIO 
	WHERE telefono1 = 'NULL' AND
		  telefono2 = 'NULL';

--Proposta 11 => NIF, nome, apelidos e data de nacemento dos socios nados entre 1980 e 1990, ambos inclu�dos.
USE SOCIEDADE_CULTURAL;

	SELECT nif, nome, ape1, ape2, data_nac
	FROM SOCIO	
	WHERE data_nac BETWEEN '1/1/1980' AND '31/12/1990';


--Proposta 12 => Todos os datos das actividades cuxo nome cont�n a letra T.
USE SOCIEDADE_CULTURAL;

	SELECT *
	FROM ACTIVIDADE
	WHERE NOME LIKE '%T%';


--Proposta 13 => Nome e importe das cotas cun custo de 30 ou 100 euros.
USE SOCIEDADE_CULTURAL;

	-- SOLUCION 1

		SELECT nome, importe 
		FROM COTA
		WHERE importe = 30 OR 
			  importe = 100;

	-- SOLUCION 2

		SELECT nome, importe
		FROM COTA
		WHERE importe IN(30,100)

--Proposta 14 => Nome e n�mero de prazas das actividades que non te�en nin 15 nin 20 prazas.
USE SOCIEDADE_CULTURAL;

	-- SOLUCION 1

		SELECT nome, num_prazas
		FROM ACTIVIDADE
		WHERE num_prazas NOT IN(15,20);

	-- SOLUCION 2

		SELECT nome, num_prazas
		FROM ACTIVIDADE
		WHERE num_prazas <> 15 AND
			  num_prazas <> 20;

------------ BD EMPRESA ------------

-- Proposta 15 => Nome de todos os clientes por orde alfab�tica.
USE EMPRESA;

	SELECT nome
	FROM CLIENTE
	ORDER BY nome ASC;

-- Proposta 16 => Nome das rexi�ns nas que ten sucursais a empresa.
USE EMPRESA;

	SELECT DISTINCT rexion 
	FROM SUCURSAL;
	

--Proposta 17 => Identificador dos produtos que nos pediron nalg�n momento. No resultado debe aparecer nunha soa columna o c�digo do fabricante e o identificador do produto separados por un gui�n.
--A columna do resultado deber� chamarse produtos.
USE EMPRESA;

	SELECT DISTINCT (cod_fabricante + ' - '+ identificador) AS produtos
	FROM PRODUTO;

--Proposta 18 => Informaci�n completa das sucursais non dirixidas polo empregado n�mero 108.
USE EMPRESA;

	SELECT *
	FROM SUCURSAL
	WHERE num_empregado_director != 108;


--Proposta 19 => Nome e l�mite de cr�dito do cliente n�mero 1107.
USE EMPRESA;

	SELECT nome, limite_de_credito
	FROM CLIENTE
	WHERE numero = 1107;
	


--Proposta 20 => N�mero e data dos pedidos feitos entre o 1 de agosto e o 31 de decembro de 2014. S� debe aparecer a data de cada pedido, sen a hora, co formato dd-mm-aaaa.
--Deben aparecer primeiro no resultado os pedidos m�is recentes. Para resolver esta consulta non se poden utilizar operadores de comparaci�n (>, <, >=, <=, < >, !=).
USE EMPRESA;

	SELECT numero, CONVERT(CHAR(10), data_pedido, 105)
				   AS data_do_pedido
	FROM PEDIDO
	WHERE data_pedido BETWEEN '1/08/2014' AND '31/12/2014'
	ORDER BY data_pedido DESC;


--Proposta 21 => C�digo e nome dos fabricantes cuxo nome ten por segunda letra O.
USE EMPRESA;

	SELECT codigo, nome
	FROM FABRICANTE
	WHERE nome LIKE '_O%';

--Proposta 22 => Descrici�n e prezo dos produtos dos que non temos existencias.
USE EMPRESA;

	SELECT descricion, prezo
	FROM PRODUTO
	WHERE existencias = 0;

--Proposta 23 => N�mero identificador e nome completo dos empregados que non te�en xefe.
USE EMPRESA;

	SELECT numero, nome, ape1, ape2
	FROM EMPREGADO
	WHERE num_empregado_xefe IS NULL;

--Proposta 24. Descrici�n e unidades existentes, dos produtos con existencias maiores de 10 unidades e menores de 100. Para resolver esta consulta non se poden utilizar operadores de comparaci�n 
--(>, <, >=, <=, < >, !=).
USE EMPRESA;

	SELECT descricion, existencias
	FROM PRODUTO
	WHERE existencias BETWEEN 11 AND 99;