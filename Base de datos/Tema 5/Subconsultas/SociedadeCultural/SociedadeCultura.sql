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
	WHERE EXISTS (	SELECT *
					FROM AULA
					WHERE estado ='B')


-- 5. Datos completos das aulas se non existe algunha en bo estado

	SELECT * 
	FROM AULA
	WHERE EXISTS (	SELECT numero
					FROM AULA
					WHERE estado ='B')