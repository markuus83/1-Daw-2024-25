use a23marcoscc_BD_SociedadeCultural;

-- 1. Nombre y apellidos (cada uno en una columna) de todos los empleados.

	SELECT nome, ape1, ISNULL(ape2,'') AS ape2
	FROM EMPREGADO


-- 2. Numero, nombre y apellidos (cada uno en una columna) de todos los empleados.

	SELECT numero, nome, ape1, ISNULL(ape2,'') AS ape2
	FROM EMPREGADO


-- 3. Numero, nombre y apellidos (cada uno en una columna) de todos los empleados por orden alfabetica de apellidos y nombre.

	SELECT numero, nome, ape1, ISNULL(ape2,'') AS ape2
	FROM EMPREGADO
	ORDER BY ape1, ape2, nome


-- 4. Numero, nombre y apellidos (cada uno en una columna) de todos los empleados por orden alfabetica de apellidos y nombre.
--Los nombres de las columnas en el resultado seran: num_socio, nome_socio, apelido1, apelido2.

	SELECT numero AS num_socio, nome AS nome_socio, ape1 AS apelido1, ISNULL(ape2,'') AS apelido2
	FROM EMPREGADO
	ORDER BY ape1, ape2, nome


-- 5. Numero, nombre completo (los 4 campos en una unica columna, de nombre socio, con el formato numero - ape1 ape2, nombre) y salario de todos los empleados.
-- En el resultado deberan aparecer primero los que mas cobran.

	SELECT CONVERT(VARCHAR(10), numero) + '   -   ' + ape1 + '    ' + ISNULL(ape2,'') + ',   ' + nome AS datos_Empregado, salario_mes
	FROM EMPREGADO
	ORDER BY salario_mes DESC


-- 6. Numero, nombre completo (los 4 campos en una unica columna, de nombre socio, con el formato numero - ape1 ape2, nombre) y salario de todo el profesorado. 
--En el resultado deberan aparecer primero los que mas cobran. 
--El campo cargo contiene PRF para el profesorado, y ADM si es un o una administrativa.

	SELECT CONVERT(VARCHAR(10), numero) + '   -   ' + ape1 + '    ' + ISNULL(ape2,'') + ',   ' + nome AS datos_Empregado, 
			salario_mes AS salario, 
			"cargo" = case 
				WHEN cargo LIKE 'PRF' THEN 'Profesorado'
				WHEN cargo LIKE 'ADM' THEN 'Administrativa'
				ELSE 'Erro'
			END
			
	FROM EMPREGADO
	ORDER BY salario_mes DESC


-- 7. Numero identificador del profesorado que imparte clases. Como es logico, si un profesor imparte mas de una actividad, su numero solo puede aparecer una vez.

	SELECT DISTINCT num_profesorado_imparte 
	FROM ACTIVIDADE


-- 8. Numero identificador de las actividades a las que asiste profesorado, es decir, cursadas por profesorado.

	SELECT id_actividade
	FROM PROFE_CURSA_ACTI
	

-- 9. Nombre, importe e importe rebajado un 20%, de la actividad de nombre xadrez.
	
	SELECT * FROM ACTIVIDADE
	
	SELECT nome, prezo, (prezo * 0.8) AS prezo_rebaixado
	FROM ACTIVIDADE
	WHERE nome LIKE 'XADREZ'
	

-- 10. NIF, nombre y apellidos de los socios de los que no tenemos telefono guardado.

	SELECT nif, ape1 + ' ' + ISNULL(ape2,'') + ', ' + nome AS nome_Empregado
	FROM SOCIO
	WHERE telefono1 IS NULL and telefono2 IS NULL 


-- 11. NIF, nombre, apellidos y fecha de nacimiento de los socios nacidos entre 1980 y 1990, ambos incluidos.

	SELECT nif, ape1 + ' ' + ISNULL(ape2,'') + ', ' + nome AS nome_Empregado
	FROM SOCIO
	WHERE data_nac BETWEEN '01-01-1980' AND '31-12-1990'
	
	
-- 12. Todos los datos de las actividades cuyo nombre contiene la letra T.

	SELECT *
	FROM ACTIVIDADE
	WHERE nome LIKE '%T%'

-- 13. Nombre e importe de las cuotas con un costo de 30 o 100 euros.

	SELECT nome, importe
	FROM COTA
	WHERE importe = 30 OR importe = 100


-- 14. Nombre y numero de plazas de las actividades que no tienen ni 15 ni 20 plazas.
	
	SELECT  nome, identificador, num_prazas
	FROM ACTIVIDADE
	WHERE num_prazas != 15 and num_prazas != 20

-- ESPECIAL: Canto pesa esta BBDD?

	EXEC sp_spaceused