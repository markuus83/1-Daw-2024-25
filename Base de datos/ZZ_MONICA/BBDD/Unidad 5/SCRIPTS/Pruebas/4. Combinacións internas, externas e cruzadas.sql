
---------------------------------------------------------------- COMBINACIÓNS INTERNAS, EXTERNAS E CRUZADAS ---------------------------------------------------------------- 

USE SOCIEDADE_CULTURAL;

-- Consulta 1 => Amosaremos o nome e apelidos daqueles socios que deben algunha actividade.

SELECT DISTINCT SOCIO.ape1, SOCIO.ape2, SOCIO.nome

FROM SOCIO, SOCIO_REALIZA_ACTI

WHERE SOCIO_REALIZA_ACTI.pagada = 'N' AND
		SOCIO.numero = SOCIO_REALIZA_ACTI.num_socio

ORDER BY SOCIO.ape1,  SOCIO.ape2, SOCIO.nome;



-- Consulta 2 => Nome propio do/a profesor/a que imparte a actividade número 20

SELECT e.nome

FROM EMPREGADO e, ACTIVIDADE a

WHERE a.identificador = 20 AND
		e.numero = a.num_profesorado_imparte


-- Consulta 3 => Nesta consulta obtemos o nome propio dos socios que realizan a actividade de nome 'TENIS PARA PRINCIPIANTES'

SELECT s.nome

FROM ACTIVIDADE a, SOCIO s, SOCIO_REALIZA_ACTI sra

WHERE a.nome = 'TENIS PARA PRINCIPIANTES' 
	  AND s.numero = sra.num_socio
	  AND sra.id_actividade = a.identificador


-- Consulta 4 => Buscamos o nome propio dos empregados que cursan actividades. Como segunda columna aparecerá o nome da actividade cursada por cada un deles.

SELECT e.nome as nomeEmpregado, a.nome as nomeActividade

FROM EMPREGADO e, ACTIVIDADE a, PROFE_CURSA_ACTI p

WHERE e.numero = p.num_profesorado AND
	  p.id_actividade = a.identificador;


-- Consulta 5 => Buscamos o nif, o nome completo e o cargo de todos os empregados, cos identificadores das actividades que cursan. No caso de que un empregado curse máis dunha actividade aparecerá no resultado 
--tantas veces como actividades curse. Aínda que un empregado non curse ningunha actividade tamén debe aparecer. Debe ser indiferente que o empregado sexa profesorado ou administrativo.

SELECT e.nif, e.nome, e.ape1, e.ape2, p.id_actividade

FROM EMPREGADO e LEFT JOIN PROFE_CURSA_ACTI p 
	 ON e.num_casa_enderezo = p.num_profesorado;


---------------------------------------------------------------- CONSULTAS CON DISTINTOS TIPOS DE JOIN---------------------------------------------------------------- 



-- Consulta 6 => mesma consulta do exemplo 5 (Buscamos o nif, o nome completo e o cargo de todos os empregados, cos identificadores das actividades que cursan. No caso de que un empregado curse máis dunha actividade aparecerá no resultado 
--tantas veces como actividades curse. Aínda que un empregado non curse ningunha actividade tamén debe aparecer. Debe ser indiferente que o empregado sexa profesorado ou administrativo.), pero substituíndo o LEFT por RIGHT

SELECT e.nif, e.nome, e.ape1, e.ape2, c.id_actividade

FROM PROFE_CURSA_ACTI c RIGHT JOIN EMPREGADO e 
	ON e.numero = c.num_profesorado


-- Consulta 7 => Buscamos o nif, o nome completo e o cargo de todos os empregados, cos identificadores das actividades que cursan. No caso de que un empregado curse máis dunha actividade aparecerá no resultado tantas veces
-- coma actividades curse. No caso de que un empregado non curse actividades debe aparecer o número 0 na columna da actividade. Debe ser indiferente que o empregado sexa profesorado ou administrativo.


SELECT e.nif, e.nome, e.ape1, e.ape2,
		ISNULL(c.id_actividade, 0) as actividade_cursada

FROM PROFE_CURSA_ACTI c RIGHT JOIN EMPREGADO e
	ON e.numero = c.num_profesorado;


--Consulta 8 => Buscamos o NIF, o nome completo e o cargo de todos os empregados, cos identificadores das actividades que cursan. No caso de que un empregado curse máis dunha actividade aparecerá no resultado
-- tantas veces como actividades curse. No caso de que un empregado non curse actividades debe aparecer a frase 'Sen actividade.' na columna da actividade.


SELECT e.nif, e.nome, e.ape1, e.ape2,
	ISNULL(CAST(c.id_actividade AS VARCHAR(30)), 'Sen actividade.') AS actividade_Cursada

FROM PROFE_CURSA_ACTI c RIGHT JOIN EMPREGADO e
	ON c.num_profesorado = e.numero;


-- Consulta 9 => Producto cartesiano entre os socios e as cotas. É dicir, imos combinar cada fila da táboa SOCIO con cada fila de COTA. 

-- Farémolo de dous xeitos, dun JOIN interno sen condición de combinación, e coa sintaxe CROSS JOIN.


	-- EXEMPLO 1:

	SELECT s.nif, s.nome, s.ape1, s.ape2,
			c.codigo, c.codigo, c.nome

	FROM SOCIO s, COTA c;


	-- EXEMPLO 2 (SOLUCIÓN CORRECTA):


	SELECT s.nif, s.nome, s.ape1, s.ape2,
			c.codigo, c.importe, c.nome

	FROM SOCIO s CROSS JOIN COTA c;




