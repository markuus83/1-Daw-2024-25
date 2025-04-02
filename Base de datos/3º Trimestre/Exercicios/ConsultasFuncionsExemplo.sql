-- Consulta de exemplo 1 :
--Amosar nunha soa columna de nome datos_empregados,
--o número identificador e o nome completo de cada empregado co formato:
	-- número identificador - apelido1 apelido2, nome
	USE a23marcoscc_BD_EMPRESA;

	SELECT CAST(numero AS VARCHAR(30))+' - '+ape1+ISNULL(ape2,'')+', '+nome AS datos_empregado
	FROM EMPREGADO


-- Consulta de exemplo 2: 
--Amosar nunha soa columna o nome de todas as actividades e o día que comezan co formato:
--nome_actividade comeza o data_inicio_da_actividade

	USE a23marcoscc_BD_SociedadeCultural;


	SELECT nome as nome_actividade, CONVERT(date,data_ini,105) as data_inicio_da_actividade
	FROM ACTIVIDADE


--	Consulta de exemplo 3: 
--Amosar o uso das funcións ascii e char para a letra A. 
--A consulta non se fai sobre ningunha táboa, neste caso, 
--empregamos a instrución SELECT só para amosar o resultado, como se fose un print.

	SELECT 'A' VOGAL, ASCII('A') AS CODIGO_ASCII


-- Consulta de exemplo 4:
-- Obter a listaxe abreviada das catro primeiras letras dos nomes das actividades.

	SELECT LEFT(nome,4) as CatroLetras
	from ACTIVIDADE


-- Consulta de exemplo 5:
-- Obter o nome e número de caracteres dos nomes dos empregados.
	
	SELECT LEN(REPLACE(nome,' ','')) as CantidadeLetras
	FROM ACTIVIDADE


-- Consulta de exemplo 6:
--Obter os nomes dos empregados tal como están gardados na BD, 
--e nunha segunda columna os nomes dos empregados en minúsculas.

	SELECT nome AS NomeNormal, LOWER(nome) as NomeMinuscula
	FROM EMPREGADO


-- Consulta de exemplo 7:
-- Nomes completos dos socios en minúsculas.
--Primeiro pasando a minúsculas cada campo, 
--e na segunda columna pasando a minúsculas despois de facer a 
--concatenación dos campos.

	SELECT	LOWER(nome) nomeMinuscula,
			LOWER(ape1) apelido1Minuscula,
			LOWER(ISNULL(ape2,'')) apelido2Minuscula,
			LOWER(CAST(numero AS VARCHAR(30))+' - '+ape1+ISNULL(ape2,'')+', '+nome ) AS nomeCompletoMinuscula
	FROM EMPREGADO


-- Consulta de exemplo 8:
-- Amosar unha cadea con espazos á esquerda na primeira columna,
--e a mesma cadea sen espazos á esquerda.

	SELECT nome as nomeNormal, LTRIM(nome) as nomeSenEspazosEsquerda
	FROM EMPREGADO


-- Consulta de exemplo 9:
-- Amosar o carácter unicode do código 248.

	SELECT '248' AS numero, NCHAR(248) AS caracter


-- Consulta de exemplo 10: 
-- Obter o nome das actividades e nunha segunda columna 
--o nome das actividades sen acento gráfico no a.

	SELECT nome, REPLACE(nome, 'á', 'a') as nomeModificado
	FROM ACTIVIDADE


-- Consulta de exemplo 11:
--Nesta consulta obtemos o nome das actividades e nunha segunda columna 
--o nome das actividades sen acento gráfico en ningunha vogal.

	 SELECT nome, TRANSLATE(nome, 'áéíóú', 'aeiou') as nomeModificado
	FROM ACTIVIDADE

-- Consulta de exemplo 12:
-- Obter a listaxe abreviada das catro últimas letras dos nomes das actividades.

	SELECT RIGHT(nome,4) as CatroLetras
	FROM ACTIVIDADE


-- Consulta de exemplo 13:
-- Amosar unha cadea con espazos á dereita na primeira columna, 
--e a mesma cadea sen espazos á dereita. Para poder verificalo engadimos
--un punto ao final da cadea

	SELECT nome as nomeNormal, RTRIM(nome) + '.' as nomeSenEspazosEsquerda
	FROM EMPREGADO


-- Consulta de exemplo 14:
-- Obter os segundo, terceito, cuarto e quinto caracteres do nome das cotas.

	SELECT	SUBSTRING(nome,2,1) as segundo,
			SUBSTRING(nome,3,1) as terceiro,
			SUBSTRING(nome,4,1) as cuarto,
			SUBSTRING(nome,5,1) as quinto
	FROM COTA


--Consulta de exemplo 15:
-- Amosar o código unicode do símbolo ø

	SELECT 'ø' as CODIGO, UNICODE('ø') AS CodAscii


-- Consulta de exemplo 16:
-- Observacións das actividades tal como están gardadas e 
--nunha segunda columna as mesams observacións en maiúsculas

	SELECT ISNULL(observacions,'') AS normal, ISNULL(UPPER(observacions),'') as Maiúscula
	FROM ACTIVIDADE


-- Consulta de exemplo 17:
-- Amosar a data do sistema empregando as distintas funcións.

	SELECT SYSDATETIME() AS Miau
	SELECT SYSDATETIME() AS Miau
	SELECT sysutcdatetime() AS Miau
	SELECT getdate() AS Miau
	SELECT getutcdate() AS Miau
