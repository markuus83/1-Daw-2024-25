use a23marcoscc_BD_SociedadeCultural;

-- 1. Nome de todas as actividades

	SELECT nome
	FROM ACTIVIDADE
	GROUP BY nome

-- 2. Nome e prezo de todas as actividades 

	SELECT nome, prezo 
	FROM ACTIVIDADE
	
-- 3. Todos os campos de tods as cotas

	SELECT codigo, nome, importe
	FROM COTA

-- 4. Nome, prezo e número de prazas das actividades con prezo menor a 100

	SELECT nome, prezo, num_prazas
	FROM ACTIVIDADE
	WHERE prezo > 100

-- 5. Nome, prezo e número de prazas das actividades con prezo menor a 100 e número de prazas maior a prezo menor.

	SELECT nome, prezo, num_prazas
    FROM ACTIVIDADE
    WHERE prezo < 100 AND num_prazas > prezo
    ORDER BY prezo DESC

-- 6. Nome, prezo e número de prazas das actividades con prezo menor a 100, ordenadas de maior a menor numero de prazas

	SELECT nome, prezo, num_prazas
    FROM ACTIVIDADE
    WHERE prezo < 100
    ORDER BY num_prazas DESC, nome ASC

-- 7. Tipo de socios
	SELECT DISTINCT tipo
	FROM SOCIO

-- 8. Nome, primeiro apelido, segundo apelido e salario neto de cada un dos empregados. Os empregadoos teñen un 21% de retención

	SELECT nome + ' ' + ape1 + ' ' + ape2 as NomeCompleto, salario_mes - (salario_mes * 0.21) as SalarioNeto
	FROM EMPREGADO

-- 9. Nome e importe das cotas que cumpran que o dobre do seu importe é maior a 90.

	SELECT nome, importe
	FROM COTA
	WHERE importe * 2 > 90

-- 10. Nome completo dos empregados

	SELECT nome + ' ' + ape1 + ' ' + ape2 as NomeCompleto
	FROM EMPREGADO


-- 11. Identificador e nome completo dos empregados

	SELECT numero id, nome + ' ' + ape1 + ' ' + ape2 as NomeCompleto
	FROM EMPREGADO


-- 12.

	--SOLUCION 1
	SELECT nome + ' comeza o: ' + cast(data_ini AS VARCHAR(30))
	FROM ACTIVIDADE
	GROUP BY nome, data_ini

	--SOLUCION 2
	SELECT nome + ' comeza o: ' + CONVERT(VARCHAR(30),data_ini)
	FROM ACTIVIDADE
	GROUP BY nome, data_ini


-- 13. Nombre y precio de la cuota que no sean gratis

	SELECT nome, importe
    FROM COTA
	where importe != 0
    ORDER BY importe DESC

	

-- 14.

	SELECT ape1 + ' ' + ape2 +', ' + nome as NomeCompleto
	FROM SOCIO
	WHERE profesion is null
	order by ape1, ape2, nome


-- 15. 

	SELECT ape1 ,ape2 ,nome
	FROM SOCIO
	WHERE profesion is not null
	order by ape1, ape2, nome


-- 16. Nome e importe das cotas que teñan un importe entre 50 e 200

	SELECT nome, importe
	FROM COTA
	WHERE importe BETWEEN 50 AND 200;


-- 17.  Nome e importe das cotas que teñan un importe menor a 50 ou maior a 200

	SELECT nome, importe
	FROM COTA
	WHERE importe<50 or importe > 200


-- 18. nif, nome completo e nome da rua dos socios que vivan en rúas que comezan por SAN

	SELECT nif, ape1 + ' ' + ape2 +', ' + nome as NomeCompleto, nome_via_enderezo as Nome_Rua
	FROM SOCIO
	WHERE nome_via_enderezo LIKE 'SAN %'


-- 19. Nome, superficie e estado das aulas que teñan 8 caracteres e rematen en R

	SELECT descricion, superficie, estado
	FROM AULA
	WHERE descricion like CHAR(8) and descricion like '%R'

	--Corrección 
	SELECT descricion, superficie, estado
	FROM AULA
	WHERE LEN(descricion)= 8 and descricion like '%R'


-- 20. Nif, nome completo e nome da rua dos socios que comezan por C, D, E, F ou G

	SELECT nif, ape1 + ' ' + ape2 +', ' + nome as NomeCompleto
	FROM SOCIO
	WHERE ape1 like 'C%' or ape1 like 'D%' or ape1 like 'E%' or ape1 like 'F%' or ape1 like 'G%'
	--WHERE ape1 like'[C-G]%'


-- 21. Nif, nome completo e nome da rua dos socios que non comezan por C, D, E, F ou G

	SELECT nif, ape1 + ' ' + ape2 +', ' + nome as NomeCompleto
	FROM SOCIO
	WHERE ape1 not like 'C%' or ape1 not like 'D%' or ape1 not like 'E%' or ape1 not like 'F%' or ape1 not like 'G%'
	--WHERE ape1 not like'[C-G]%'



-- 22.

	SELECT nome, convert(date,data_ini), observacions
	FROM ACTIVIDADE
	WHERE observacions like '%\_%' ESCAPE '\'
	--WHERE observacions like '%*_%' ESCAPE '*'

-- 23.

	SELECT nome, prezo
	FROM ACTIVIDADE
	WHERE prezo = 50 or prezo = 80


-- 24.

	


-- 25.

	SELECT descricion, superficie, estado
	FROM AULA
	WHERE estado != 'B' and estado != 'R'

-- 26.


	SELECT identificador, nome, num_prazas
	FROM ACTIVIDADE
	WHERE num_profesorado_imparte = 100 or num_aula = 2


-- 27.

	SELECT nome, convert(char(10),data_ini, 103) as DataInicio, convert(char(10),data_fin, 103) as DataFin, num_prazas, prezo
	FROM ACTIVIDADE
	where num_prazas > 10 and observacions is null
	

-- 28.

