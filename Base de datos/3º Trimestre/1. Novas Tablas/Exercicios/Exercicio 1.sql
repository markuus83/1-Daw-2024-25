USE a23marcoscc_BD_SociedadeCultural;
GO

--1.- Crear unha nova táboa COTA_DE_BALDE cos mesmos campos que COTA y a partir de esta, so coas cotas gratis.

	--Os nomes dos campos serán: cod, descrición e importe.
	--Eliminar a táboa nova para manter o deseño orixinal da BD

	SELECT * FROM COTA;

	SELECT *
	INTO COTA_DE_BALDE
	FROM COTA
	WHERE importe = 0;
	
	SELECT * FROM COTA_DE_BALDE;
	
	DROP TABLE COTA_DE_BALDE;

	
	
--2.- Crear una táboa temporal local SOCIO_MOROSO con dos campos: 
--	nif e nome completo dos socios que deben algunha actividade a partir da táboa SOCIO.

	-- O resultado terá este formato:
		-- nif - nome_completo
		-- 22222223B - SIEIRO CAMPOS, MANUEL
		-- 33333334C - DEL CARMEN LOREZ, JORGE
		
	--Usar funciones del sistema.

	--Eliminar a táboa nova para manter o deseño orixinal da BD

	SELECT * FROM SOCIO;
	
	SELECT CONVERT(VARCHAR(30), nif)+' - '+ape1+' '+ISNULL(ape2,' ')+', '+nome AS DatosCompletos
	INTO SOCIO_MOROSO
	FROM SOCIO
	WHERE abonada LIKE 'N';
	
	SELECT * FROM SOCIO_MOROSO;
	
	DROP TABLE SOCIO_MOROSO;


--3.- Engadir dúas novas cotas gratis:unha con código 20 e nome COTA GRATIS e outra con código 30 e nome OUTRA GRATIS.

	--DELETE FROM COTA
	--WHERE nome IN ('COTA GRATIS', 'OUTRA GRATIS', 'NOVA', 'HABITUAL');
	
	SELECT * FROM COTA;
	
		INSERT INTO COTA(codigo, nome, importe) VALUES(13,'HABITUAL', 150)
	
	BEGIN TRAN
	
		INSERT INTO COTA(codigo, nome, importe) VALUES(20,'COTA GRATIS', 100)
		INSERT INTO COTA(codigo, nome, importe) VALUES(30,'OUTRA GRATIS', 100)
	
		SELECT * FROM COTA
		
	ROLLBACK;


--4.- Engadir en COTA unha nova cota de nome NOVA e código 80 co importe da cota de nome HABITUAL

	SELECT * FROM COTA;
	
	BEGIN TRAN
	
		INSERT INTO COTA(codigo, nome, importe) VALUES(80,'NOVA',	(SELECT importe
																	FROM COTA
																	WHERE nome in ('HABITUAL')))
		
	
		SELECT * FROM COTA
		
	ROLLBACK;


--5.- Eliminar as tres cotas de códigos 20, 30 e 80, 90 engadidas nas consultas de exemplo 1 e 2

	--Como a fixen co rollback non queda rexistrado na BBDD, pero o comando escrito ten de funcionar igual
	
	SELECT * FROM COTA;
	
	DELETE FROM COTA
	WHERE codigo IN ('20','30','80','90');

	SELECT * FROM COTA


--6.- Crear unha táboa temporal local SOCIO2 copia de SOCIO. Despois eliminar os socios da táboa SOCIO2 que deben algunha actividade.
--Facelo de tres formas distintas.

	SELECT * FROM SOCIO

	SELECT *
	INTO #SOCIO2
	FROM SOCIO

	SELECT * FROM #SOCIO2
	
	DELETE FROM #SOCIO2
	WHERE abonada IN ('N')
	
	SELECT * FROM #SOCIO2
	
	DROP TABLE #SOCIO2

--7.- Crear unha táboa EMPREGADO2, copia da táboa EMPREGADO coas mesmas filas e columnas.
-- A continuación eliminar todas as filas da táboa nova do xeito máis rápido e eficiente posible.
-- Antes e despois do borrado facer a consulta que nos amosa o número de filas da táboa EMPREGADO2 en cada momento.
-- Ao rematar eliminarase a táboa nova coa cláusula DROP TABLE para non modificar o deseño orixinal da BD.

	SELECT * FROM EMPREGADO
	
	BEGIN TRAN
	
	--XERAMOS A NOBLA TABLA
		SELECT * 
		INTO EMPREGADO2
		FROM EMPREGADO
		
		SELECT * FROM EMPREGADO2
		
		-- CONTAMOS O NÚMERO DE FILAS DA TÁBOA
			SELECT COUNT(*) AS NumeroColumnas
			FROM EMPREGADO2
			
		--ELIMINAMOS TODOS OS DATOS DA TÁBOA
			TRUNCATE TABLE EMPREGADO2
		
		--CONTAMOS O NÚMERO DE FILAS OUTRA VEZ
			SELECT COUNT(*)AS NumeroColumnas
			FROM EMPREGADO2
		
		DROP TABLE EMPREGADO2
		
	ROLLBACK
	
--8.- Incrementar o prezo das actividades en 4 euros. Para deixar os datos orixinais da BD, facer unha segunda modificación de redución do prezo en 4 euros.
--Facer unha consulta antes e despois do incremento do prezo.

	SELECT * FROM ACTIVIDADE
	
	BEGIN TRAN
	
		SELECT * FROM ACTIVIDADE
		
		UPDATE ACTIVIDADE
			SET prezo += 4;
	
		SELECT * FROM ACTIVIDADE
		
	ROLLBACK


--9.- Incrementar en 7 o número de prazas da actividade con número 10, o seu nome pasará a ser CURSO TENIS e aumentara o seu prezo en 5,14%.
--Para deixar os datos orixinais da BD, facer unha segunda modificación e a táboa quedará como estaba antes da modificación. 
--Facer unha consulta antes e despois da modificación para comprobar os cambios.

	SELECT * FROM ACTIVIDADE;

	BEGIN TRAN
	
		UPDATE ACTIVIDADE
			SET	num_prazas += 7,
				nome = 'CURSO TENIS',
				prezo = prezo* 1.0514
			WHERE identificador = '10'
			
		SELECT * FROM ACTIVIDADE
		
	ROLLBACK


--10.- Modificar o prezo das cotas gratis co valor do prezo máis alto das actividades. 
--Para deixar os datos orixinais da BD, facer unha segunda modificación e a táboa quedará como estaba antes da modificación. 
-- Facer unha consulta antes e despois da modificación para comprobar os cambios.

	SELECT * FROM ACTIVIDADE;
	
	BEGIN TRAN
	
		UPDATE ACTIVIDADE
			SET prezo = (SELECT MAX(prezo)
						FROM ACTIVIDADE)
			WHERE prezo = 0
		
		SELECT * FROM ACTIVIDADE
		
	ROLLBACK


--11.- Poñer como pagadas todas as actividades aos socios que teñan abonada a cota anual. 
--Para deixar os datos orixinais da BD, 
--facer unha segunda modificación e a táboa quedará como estaba antes da modificación.
-- Facer unha consulta antes e despois da modificación para comprobar os cambios.

	SELECT * FROM SOCIO_REALIZA_ACTI;

	BEGIN TRAN

		UPDATE SOCIO_REALIZA_ACTI
		SET pagada = 'S'
		WHERE num_socio IN (	SELECT numero 
								FROM SOCIO 
								WHERE abonada = 'S');
	
		SELECT * FROM SOCIO_REALIZA_ACTI;

	ROLLBACK;
