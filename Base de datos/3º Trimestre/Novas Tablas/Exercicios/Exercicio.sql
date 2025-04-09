DROP DATABASE IF EXISTS a23marcoscc_BD_SociedadeCultural;
GO
CREATE a23marcoscc_BD_SociedadeCultural;
GO
USE a23marcoscc_BD_SociedadeCultural;
GO

--1.- Crear unha nova táboa COTA_DE_BALDE cos mesmos campos que COTA y a partir de esta, so coas cotas gratis.

	--Os nomes dos campos serán: cod, descrición e importe.
	--Eliminar a táboa nova para manter o deseño orixinal da BD

	SELECT * FROM COTA

	SELECT codigo, nome, importe
	INTO COTA_DE_BALDE
	FROM COTA
	WHERE importe = 0;
	
	SELECT * FROM COTA_DE_BALDE;
	
	DROP TABLE COTA_DE_BALDE;
	
	
--2.- Crear una táboa temporal local SOCIO_MOROSO con dos campos: 
--	nif e nome completo dos socios que deben algunha actividade a partir da táboa SOCIO.

	-- O resultado terá este formato:
		-- nifnome_completo
		-- 22222223BSIEIRO CAMPOS, MANUEL
		-- 33333334CDEL CARMEN LOREZ, JORGE
		
	--Usar funciones del sistema.

	--Eliminar a táboa nova para manter o deseño orixinal da BD

	SELECT * FROM SOCIO;
	
	SELECT CONVERT(VARCHAR(30), nif)+' - ' + ape1+' '+ISNULL(ape2,'')+', '+nome as Datos
	INTO #SOCIO_MOROSO
	FROM SOCIO
	WHERE abonada LIKE 'S';

	SELECT * FROM #SOCIO_MOROSO
	
	DROP TABLE #SOCIO_MOROSO


--3.- Engadir dúas novas cotas gratis:unha con código 20 e nome COTA GRATIS e outra con código 30 e nome OUTRA GRATIS.

	SELECT * FROM COTA

	INSERT INTO COTA VALUES (20, 'COTA GRATIS', 0);
	INSERT INTO COTA VALUES (30, 'OUTRA GRATIS', 0);



--4.- Engadir en COTA unha nova cota de nome NOVA e código 80 co importe da cota de nome HABITUAL

	-- SOLUCION 1:
	
		INSERT INTO COTA (codigo, nome, importe) SELECT 80, 'NOVA', importe FROM COTA WHERE nome = 'HABITUAL'
	
		
	-- SOLUCION 2:
		
		INSERT INTO COTA (codigo,nome,importe) VALUES (90, 'OTRA', (SELECT importe FROM COTA WHERE nome='HABITUAL'));

	
	SELECT * FROM COTA


--5.- Eliminar as tres cotas de códigos 20, 30 e 80, 90 engadidas nas consultas de exemplo 1 e 2




--6.- Crear unha táboa temporal local SOCIO2 copia de SOCIO. Despois eliminar os socios da táboa SOCIO2 que deben algunha actividade.
--Facelo de tres formas distintas.




--7.- Crear unha táboa EMPREGADO2, copia da táboa EMPREGADO coas mesmas filas e columnas.
-- A continuación eliminar todas as filas da táboa nova do xeito máis rápido e eficiente posible.
-- Antes e despois do borrado facer a consulta que nos amosa o número de filas da táboa EMPREGADO2 en cada momento.
-- Ao rematar eliminarase a táboa nova coa cláusula DROP TABLE para non modificar o deseño orixinal da BD.




--8.- Incrementar o prezo das actividades en 4 euros. Para deixar os datos orixinais da BD, facer unha segunda modificación de redución do prezo en 4 euros.
--Facer unha consulta antes e despois do incremento do prezo.




--9.- Incrementar en 7 o número de prazas da actividade con número 10, o seu nome pasará a ser CURSO TENIS e aumentara o seu prezo en 5,14%.
--Para deixar os datos orixinais da BD, facer unha segunda modificación e a táboa quedará como estaba antes da modificación. 
--Facer unha consulta antes e despois da modificación para comprobar os cambios.




--10.- Modificar o prezo das cotas gratis co valor do prezo máis alto das actividades. 
--Para deixar os datos orixinais da BD, facer unha segunda modificación e a táboa quedará como estaba antes da modificación. 
-- Facer unha consulta antes e despois da modificación para comprobar os cambios.




--11.- Poñer como pagadas todas as actividades aos socios que teñan abonada a cota anual. 
--Para deixar os datos orixinais da BD, facer unha segunda modificación e a táboa quedará como estaba antes da modificación.
-- Facer unha consulta antes e despois da modificación para comprobar os cambios.