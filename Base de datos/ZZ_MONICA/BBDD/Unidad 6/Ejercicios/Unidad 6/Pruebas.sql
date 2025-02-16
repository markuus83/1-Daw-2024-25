-- Consulta 1 => Crearase unha táboa permanente de nome COTA_DE_BALDE cos mesmos campos qe COTA pero só coas 
-- filas das cotas gratis. Os campos da nova táboa terán por nomes cod, descricion e importe. Ao rematar 
-- eliminarase a táboa nova coa cláusula DROP TABLE para non modificar o diseño orixinal da BD.
USE SOCIEDADE_CULTURAL_MarcosChouza;

	-- Consultamos o contido da táboa COTA
	
		SELECT * FROM COTA;
		
	-- Creamos a táboa nova COTA_DE_BALDE
	
		SELECT	codigo as cod,
				nome as descricion,
				importe INTO COTA_DE_VALDE
		FROM COTA
		WHERE importe = 0;
		
	-- Consultamos o contido da táboa COTA_DE_VALDE
		SELECT * FROM COTA_DE_VALDE
		
	-- Eliminamos a táboa nova para manter o deseñp prixinal da BD
		DROP TABLE COTA_DE_VALDE



-- Consulta 2 => Crearase unha táboa temporal local de nome SOCIO_MOROSO co nif e nome completo dos 
-- socios que deben algunha actividade. Ao rematar eliminiarase a táboa nova coa cláusula DROP TABLE 
-- para non modificar o deseño orixinal da BD.
USE SOCIEDADE_CULTURAL_MarcosChouza;

	SELECT DISTINCT nif,
					RTRIM(ape1 + ', ' + ISNULL(ape2, ' ')) + ', ' + nome AS nome_completo
					INTO #SOCIO_MOROSO

	FROM SOCIO s INNER JOIN SOCIO_REALIZA_ACTI sra
		ON s.numero = sra.num_socio
	WHERE sra.pagada = 'N';

	--  Consultamos o contido da táboa COTA_DE_VALDE
	SELECT * FROM #SOCIO_MOROSO
	
	DROP TABLE #SOCIO_MOROSO


-- Consulta 3 => Engadiranse dúas novas cotas de balde, unha código 20 e nome COTA GRATIS, e a outra
-- con código 30 e nome OUTRA GRATIS. Antes e despois, do INSERT faremos a consulta que nos amosa a 
--- información da táboa en cada momento.
USE SOCIEDADE_CULTURAL_MarcosChouza;

	SELECT codigo, nome, importe
	FROM COTA
	GO
	INSERT INTO COTA(codigo, nome, importe)
	VALUES	(20, 'COTA GRATIS', 0),
			(30, 'OUTRA GRATIS', 0);

	SELECT codigo, nome, importe
	FROM COTA


-- Consulta 4 => Engadiranse na táboa COTA unha noa de nome NOVA e código 80 co mesmo importe que a cota de nome 
-- HABITUAL. Antes e despois do INSERT faremos a consulta que nos amosa a información da táboa en cada momento.
USE	SOCIEDADE_CULTURAL_MarcosChouza;

	SELECT codigo, nome, importe
	FROM COTA;
	GO 

	INSERT INTO COTA (codigo, nome, importe)
	SELECT 80, 'NOVA', importe
	FROM COTA
	WHERE nome = 'HABITUAL';

	SELECT codigo, nome, importe
	FROM COTA;


-- Consulta 5 => Eliminaremos as tres cotas de códigos 20, 30 e 80 engadidas nas consultas de exemplo 3 e 4. 
-- Antes do DELETE faremos a consulta que nos amosa a información da táboa en cada momento.
USE	SOCIEDADE_CULTURAL_MarcosChouza;

	SELECT codigo, nome, importe
	FROM COTA;
	GO

	DELETE FROM COTA
	WHERE codigo IN (20, 30, 80);

	SELECT codigo, nome, importe
	FROM COTA;


-- Consulta 6 => Para facer esta consulta primeiro crearemos unha táboa temporal local SOCIO2 copia da táboa 
-- empregando a sentenza SELECT...INTO. Despois teranse que eliminar os socios da táboa SOCIO2 que deben
-- algunha actividade.

-- A eliminación farase de dous xeitos, nunha primeira solución empregando unha consulta subordinada e,
-- unha segunda cunha combincación externa.

USE SOCIEDADE_CULTURAL_MarcosChouza;

	-- SOLUCION 1

		SELECT * INTO #SOCIO2
		FROM SOCIO;

		SELECT * FROM #SOCIO2;

		DELETE FROM #SOCIO2
		WHERE numero IN (	SELECT num_socio
							FROM SOCIO_REALIZA_ACTI
							WHERE pagada = 'N');

		SELECT * FROM #SOCIO2;

	--DEBEMOS PRIMEIRO ELIMINAR A TABOA TEMPORAL #SOCIO2

		DROP TABLE #SOCIO2

	
	-- SOLUCION 2

		SELECT * INTO #SOCIO2
		FROM SOCIO;

		SELECT * FROM #SOCIO2;

		DELETE FROM #SOCIO2
		FROM #SOCIO2 s2, SOCIO_REALIZA_ACTI sr
		WHERE	sr.pagada = 'N' AND
				s2.numero = sr.num_socio;

		SELECT * FROM #SOCIO2

		

-- Consulta 7 => Para facer esta consulta primeiro crearase unha táboa EMPREGADO2, copia da táboa EMPREGADO coas 
-- mesmas filas e columnas, A continuaciçon eliminaremos toas as filas da táboa nova do xeito máis rápido e 
-- eficiente posible. Antes e despois do borrado faremos a consulta que nos amosa o número de da táboa EMPREGADO2 
-- en cada momento. Ao rematar eliminarase a táboa nova coa cláusula DROP TABLE paranon modificar o deseño 
-- orixinal da BD.














-- OTRO EJEMPLO DEL CUAL NO ME ACUERDO DEL NOMBRE.
CREATE DATABASE pruebas;
use pruebas;

CREATE TABLE pr1
(numero int identity (1,1) not null,
nombre varchar(100) not null,
observ varchar(150)null,
pagado char(1) not null CONSTRAINT df_pr1_pagado default 'N');

INSERT INTO pr1(nombre, observ, pagado)
VALUES ('nombre1',null,'S');

INSERT INTO pr1(nombre, pagado)
VALUES ('nombre1','S');

INSERT INTO pr1(nombre)
VALUES ('nombre3');

SELECT * FROM pr1;


