-- 0. Seleccionamos a BD
USE SOCIEDADE_CULTURAL;
GO

-- 1. Crear a táboa COTA_DE_BALDE e eliminar despois
SELECT cod, descrición, importe
INTO COTA_DE_BALDE
FROM COTA
WHERE importe = 0;

DROP TABLE COTA_DE_BALDE;

-- 2. Crear a táboa temporal SOCIO_MOROSO e eliminar despois
SELECT nif, nome + ' ' + apelidos AS nome_completo
INTO #SOCIO_MOROSO
FROM SOCIO
WHERE nif IN (SELECT nif FROM INSCRICION WHERE estado = 'DEBE');

DROP TABLE #SOCIO_MOROSO;

-- 3. Engadir dúas cotas gratis
INSERT INTO COTA (cod, descrición, importe)
VALUES (20, 'COTA GRATIS', 0),
       (30, 'OUTRA GRATIS', 0);

-- 4. Engadir unha nova cota co importe da cota HABITUAL
INSERT INTO COTA (cod, descrición, importe)
SELECT 80, 'NOVA', importe FROM COTA WHERE descrición = 'HABITUAL';

-- 5. Eliminar as cotas engadidas
DELETE FROM COTA WHERE cod IN (20, 30, 80, 90);

-- 6. Crear a táboa temporal SOCIO2 e eliminar socios morosos de 3 formas distintas
SELECT * INTO #SOCIO2 FROM SOCIO;

-- Forma 1: Usando DELETE con subconsulta
DELETE FROM #SOCIO2 WHERE nif IN (SELECT nif FROM INSCRICION WHERE estado = 'DEBE');

-- Forma 2: Usando JOIN
DELETE S FROM #SOCIO2 S
JOIN INSCRICION I ON S.nif = I.nif
WHERE I.estado = 'DEBE';

-- Forma 3: Usando EXISTS
DELETE FROM #SOCIO2
WHERE EXISTS (SELECT 1 FROM INSCRICION I WHERE I.nif = #SOCIO2.nif AND I.estado = 'DEBE');

DROP TABLE #SOCIO2;

-- 7. Crear EMPREGADO2, eliminar todas as filas rapidamente e comprobar antes/despois
SELECT * INTO EMPREGADO2 FROM EMPREGADO;

SELECT COUNT(*) AS num_filas_antes FROM EMPREGADO2;

TRUNCATE TABLE EMPREGADO2;

SELECT COUNT(*) AS num_filas_despues FROM EMPREGADO2;

DROP TABLE EMPREGADO2;

-- 8. Incrementar e despois reducir o prezo das actividades en 4€
SELECT * FROM ACTIVIDADE;

UPDATE ACTIVIDADE SET prezo = prezo + 4;

SELECT * FROM ACTIVIDADE;

UPDATE ACTIVIDADE SET prezo = prezo - 4;

SELECT * FROM ACTIVIDADE;

-- 9. Modificar a actividade 10, restaurar os valores e comprobar antes/despois
SELECT * FROM ACTIVIDADE WHERE num = 10;

UPDATE ACTIVIDADE
SET prazas = prazas + 7,
    nome = 'CURSO TENIS',
    prezo = prezo * 1.0514
WHERE num = 10;

SELECT * FROM ACTIVIDADE WHERE num = 10;

UPDATE ACTIVIDADE
SET prazas = prazas - 7,
    nome = 'ACTIVIDADE ANTERIOR',
    prezo = prezo / 1.0514
WHERE num = 10;

SELECT * FROM ACTIVIDADE WHERE num = 10;

-- 10. Modificar o prezo das cotas gratis co maior prezo de actividades e restaurar
SELECT * FROM COTA;

UPDATE COTA
SET importe = (SELECT MAX(prezo) FROM ACTIVIDADE)
WHERE importe = 0;

SELECT * FROM COTA;

UPDATE COTA
SET importe = 0
WHERE importe = (SELECT MAX(prezo) FROM ACTIVIDADE);

SELECT * FROM COTA;

-- 11. Poñer todas as actividades como pagadas para socios con cota anual e restaurar
SELECT * FROM INSCRICION;

UPDATE INSCRICION
SET estado = 'PAGADA'
WHERE nif IN (SELECT nif FROM COTA_SOCIO WHERE cod_cota = (SELECT cod FROM COTA WHERE descrición = 'ANUAL'));

SELECT * FROM INSCRICION;

UPDATE INSCRICION
SET estado = 'DEBE'
WHERE nif IN (SELECT nif FROM COTA_SOCIO WHERE cod_cota = (SELECT cod FROM COTA WHERE descrición = 'ANUAL'));

SELECT * FROM INSCRICION;
