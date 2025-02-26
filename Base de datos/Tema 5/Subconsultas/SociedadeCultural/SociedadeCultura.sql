use a23marcoscc_BD_SociedadeCultural;

-- 1. Nomes completos dos empregados cuxo salario supere
-- en máis do 50 ao do empregado con NIF '22222222B'

	SELECT ape1, ISNULL(ape2, '') as ape2, nome, salario_mes
	FROM EMPREGADO
	WHERE salario_mes >	(	SELECT 1.5 * salario_mes
							FROM EMPREGADO
							WHERE nif = '22222222B')

--2. Código das cotas que están asignadas a un socio polo 
-- menos e cuxo prezo está entre 50 e 100

	SELECT DISTINCT cod_cota
	FROM socio
	WHERE cod_cota IN (	SELECT codigo
						FROM COTA
						WHERE importe BETWEEN 50 AND 100)

 
 -- 3. NIF e nome completo dos empregados que non asisten a actividades

	SELECT nif AS NIF, ape1 + ' ' + ISNULL(ape2,'') + ', ' + nome AS nomeCompleto
	FROM EMPREGADO
	WHERE numero NOT IN (	SELECT num_profesorado_imparte
							FROM ACTIVIDADE
						)

	SELECT e.nif AS NIF, e.ape1 + ' ' + ISNULL(e.ape2,'') + ', ' + e.nome AS nomeCompleto
	FROM EMPREGADO e JOIN ACTIVIDADE a
	ON e.numero = a.num_profesorado_imparte


-- 4. Datos completos das aulas se existe algunha en bo estado

	SELECT * 
	FROM AULA
	WHERE NOT EXISTS (	SELECT numero
						FROM AULA
						WHERE estado ='B')


-- 5. Datos completos das aulas se non existe algunha en bo estado

	SELECT * 
	FROM AULA
	WHERE EXISTS (	SELECT numero
						FROM AULA
						WHERE estado NOT LIKE 'B')


-- 6. Nome e data de inicio das actividades con prezo menor que a cota máis cara existente

	SELECT nome, CONVERT(DATE, data_ini, 103) AS dataInicio
	FROM ACTIVIDADE
	where prezo < SOME (	SELECT MAX(importe)
							FROM COTA)

--7. -Nome e data de inicio das actividades con prezo 
	--maior que a cota m�is cara existente.

	SELECT nome, CONVERT(DATE, data_ini, 103) AS dataInicio
	FROM ACTIVIDADE
	where prezo > SOME	(	SELECT MAX(importe)
							FROM COTA)
	

--8. NIF e nome completo dos socios que realizan actividades
	--impartidas por profesores que cursan algunha actividade.
	
	SELECT nif, ape1 + ' ' + ISNULL(ape2,'') + ', ' + nome AS nomeCompleto
	FROM SOCIO
	WHERE numero IN (	SELECT num_socio
					FROM SOCIO_REALIZA_ACTI
					WHERE id_actividade IN (	SELECT identificador
												FROM ACTIVIDADE
												WHERE num_profesorado_imparte IN (	SELECT num_profesorado
																					FROM PROFE_CURSA_ACTI
																					)))

	
--9. NIF dos empregados cuxos salarios son maiores
	--que a suma dos prezos das actividades	que imparten.	
	

	SELECT nif
	FROM EMPREGADO e
	WHERE salario_mes > (	SELECT SUM(prezo)
							FROM ACTIVIDADE a
							WHERE a.num_profesorado_imparte = e.numero)

	
--10. NIF e gasto en actividades realizadas dos socios
	--que levan gastado máis do valor da cota máxima.

	SELECT s.nif,s.numero, SUM(a.prezo) as gastoTotal
	FROM SOCIO s, SOCIO_REALIZA_ACTI sr, ACTIVIDADE a
	WHERE s.numero = sr.num_socio AND sr.id_actividade = a.identificador
	GROUP BY s.nif, s.numero

	HAVING SUM(a.prezo) > (	SELECT MAX(c.importe)
							FROM COTA c)

							