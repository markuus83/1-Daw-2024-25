			
			-------------------------------------------------------------- 2.Tarefas de consultas simples --------------------------------------------------------------

------------ BD SOCIEDADE_CULTURAL ------------

--Proposta 1 => Nome e apelidos (cada un nunha columna) de todos os empregados.
USE SOCIEDADE_CULTURAL;

	SELECT nome, ape1, ape2
	FROM EMPREGADO;

--Proposta 2 => Número, nome e apelidos (cada un nunha columna) de todos empregados.
USE SOCIEDADE_CULTURAL;

	SELECT numero, nome, ape1, ape2
	FROM EMPREGADO;


--Proposta 3 => Número, nome e apelidos (cada un nunha columna) de todos os empregados por orde alfabética de apelidos e nome.
 USE SOCIEDADE_CULTURAL;

	SELECT numero, nome, ape1, ape2
	FROM EMPREGADO
	ORDER BY ape1, ape2, nome ASC;


--Proposta 4 => Número, nome e apelidos (cada un nunha columna) de todos os empregados por orde alfabética de apelidos e nome. Os nomes das columnas no resultado serán: num_socio, nome_socio, apelido1, apelido2.
USE SOCIEDADE_CULTURAL;

	SELECT numero AS nun_socio, nome AS nome_socio, ape1 AS apelido1, ape2 AS apelido2
	FROM EMPREGADO
	ORDER BY ape1, ape2, nome ASC;


--Proposta 5 => Número, nome completo (os 4 campos nunha única columna, de nome socio, co formato numero - ape1 ape2, nome) e salario de todos os empregados. No resultado deberán aparecer primeiro os que máis cobran.
USE SOCIEDADE_CULTURAL;

	SELECT (CAST(numero AS VARCHAR(7)) + ' - '+ ape1 + ' ' + ape2  + ' ' + nome) AS socio, salario_mes as salario
	FROM EMPREGADO
	ORDER BY salario DESC;

--Proposta 6 => Número, nome completo (os 4 campos nunha única columna, de nome socio, co formato numero - ape1 ape2, nome) e salario de todo o profesorado. No resultado deberán aparecer primeiro os que máis cobran. 
--O campo cargo contén PRF para o profesorado, e ADM se é un ou unha administrativo.
USE SOCIEDADE_CULTURAL;

	SELECT (CAST(numero AS VARCHAR(7)) + ' - '+ ape1 + ' ' + ape2  + ' ' + nome) AS socio, salario_mes as salario
	FROM EMPREGADO
	WHERE cargo = 'PRF'
	ORDER BY salario DESC;

--Proposta 7 => Número identificador do profesorado que imparte clases. Como é lóxico, se un profesor imparte máis dunha actividade, o seu número só pode aparecer unha vez.
USE SOCIEDADE_CULTURAL;

	SELECT DISTINCT num_profesorado_imparte
	FROM ACTIVIDADE;
	
	
--Proposta 8 => Número identificador das actividades ás que asiste profesorado, é dicir, cursadas por profesorado.
USE SOCIEDADE_CULTURAL;

	SELECT DISTINCT id_actividade
	FROM PROFE_CURSA_ACTI;

--Proposta 9 => Nome, importe, e importe rebaixado un 20%, da actividade de nome xadrez.
USE SOCIEDADE_CULTURAL;

	SELECT nome, prezo AS importe, prezo - (prezo * 0.20) AS prezo_rebaixado
	FROM ACTIVIDADE
	WHERE nome = 'XADREZ';

--Proposta 10 => NIF, nome e apelidos dos socios dos que non temos teléfono gardado.
USE SOCIEDADE_CULTURAL;

	SELECT nif, nome, ape1, ape2
	FROM SOCIO 
	WHERE telefono1 = 'NULL' AND
		  telefono2 = 'NULL';

--Proposta 11 => NIF, nome, apelidos e data de nacemento dos socios nados entre 1980 e 1990, ambos incluídos.
USE SOCIEDADE_CULTURAL;

	SELECT nif, nome, ape1, ape2, data_nac
	FROM SOCIO	
	WHERE data_nac BETWEEN '1/1/1980' AND '31/12/1990';


--Proposta 12 => Todos os datos das actividades cuxo nome contén a letra T.
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

--Proposta 14 => Nome e número de prazas das actividades que non teñen nin 15 nin 20 prazas.
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

-- Proposta 15 => Nome de todos os clientes por orde alfabética.
USE EMPRESA;

	SELECT nome
	FROM CLIENTE
	ORDER BY nome ASC;

-- Proposta 16 => Nome das rexións nas que ten sucursais a empresa.
USE EMPRESA;

	SELECT DISTINCT rexion 
	FROM SUCURSAL;
	

--Proposta 17 => Identificador dos produtos que nos pediron nalgún momento. No resultado debe aparecer nunha soa columna o código do fabricante e o identificador do produto separados por un guión.
--A columna do resultado deberá chamarse produtos.
USE EMPRESA;

	SELECT DISTINCT (cod_fabricante + ' - '+ identificador) AS produtos
	FROM PRODUTO;

--Proposta 18 => Información completa das sucursais non dirixidas polo empregado número 108.
USE EMPRESA;

	SELECT *
	FROM SUCURSAL
	WHERE num_empregado_director != 108;


--Proposta 19 => Nome e límite de crédito do cliente número 1107.
USE EMPRESA;

	SELECT nome, limite_de_credito
	FROM CLIENTE
	WHERE numero = 1107;
	


--Proposta 20 => Número e data dos pedidos feitos entre o 1 de agosto e o 31 de decembro de 2014. Só debe aparecer a data de cada pedido, sen a hora, co formato dd-mm-aaaa.
--Deben aparecer primeiro no resultado os pedidos máis recentes. Para resolver esta consulta non se poden utilizar operadores de comparación (>, <, >=, <=, < >, !=).
USE EMPRESA;

	SELECT numero, CONVERT(CHAR(10), data_pedido, 105)
				   AS data_do_pedido
	FROM PEDIDO
	WHERE data_pedido BETWEEN '1/08/2014' AND '31/12/2014'
	ORDER BY data_pedido DESC;


--Proposta 21 => Código e nome dos fabricantes cuxo nome ten por segunda letra O.
USE EMPRESA;

	SELECT codigo, nome
	FROM FABRICANTE
	WHERE nome LIKE '_O%';

--Proposta 22 => Descrición e prezo dos produtos dos que non temos existencias.
USE EMPRESA;

	SELECT descricion, prezo
	FROM PRODUTO
	WHERE existencias = 0;

--Proposta 23 => Número identificador e nome completo dos empregados que non teñen xefe.
USE EMPRESA;

	SELECT numero, nome, ape1, ape2
	FROM EMPREGADO
	WHERE num_empregado_xefe IS NULL;

--Proposta 24. Descrición e unidades existentes, dos produtos con existencias maiores de 10 unidades e menores de 100. Para resolver esta consulta non se poden utilizar operadores de comparación 
--(>, <, >=, <=, < >, !=).
USE EMPRESA;

	SELECT descricion, existencias
	FROM PRODUTO
	WHERE existencias BETWEEN 11 AND 99;