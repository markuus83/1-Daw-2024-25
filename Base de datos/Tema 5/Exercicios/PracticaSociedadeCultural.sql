--1. Nome e apelidos (cada un nunha columna) de todos os empregados.

    SELECT nome, apelido1, apelido2
    FROM EMPREGADO;


--2. N�mero, nome e apelidos (cada un nunha columna) de todos empregados.

    SELECT num_socio, nome, apelido1, apelido2
    FROM EMPREGADO;


--3. N�mero, nome e apelidos (cada un nunha columna) de todos os empregados por orde alfab�tica de apelidos e nome.

    SELECT num_socio, nome, apelido1, apelido2
    FROM EMPREGADO
    ORDER BY apelido1, nome;

--4. N�mero, nome e apelidos (cada un nunha columna) de todos os empregados por orde alfab�tica de apelidos e nome. Os nomes das columnas no resultado ser�n: num_socio, nome_socio, apelido1, apelido2.

    SELECT num_socio AS num_socio, nome AS nome_socio, apelido1 AS apelido1, apelido2 AS apelido2
    FROM EMPREGADO
    ORDER BY apelido1, nome;


--5. N�mero, nome completo (os 4 campos nunha �nica columna, de nome socio, co formato numero - ape1 ape2, nome) e salario de todos os empregados. No resultado deber�n aparecer primeiro os que m�is cobran.


    SELECT num_socio, CONCAT(num_socio, ' - ', apelido1, ' ', apelido2, ', ', nome) AS nome_socio, salario_mes
    FROM EMPREGADO
    ORDER BY salario_mes DESC;

--6. N�mero, nome completo (os 4 campos nunha �nica columna, de nome socio, co formato numero - ape1 ape2, nome) e salario de todo o profesorado. No resultado deber�n aparecer primeiro os que m�is cobran. O campo cargo cont�n PRF para o profesorado, e ADM se � un ou unha administrativo.

    SELECT num_socio, CONCAT(num_socio, ' - ', apelido1, ' ', apelido2, ', ', nome) AS nome_socio, salario_mes
    FROM EMPREGADO
    WHERE cargo = 'PRF'
    ORDER BY salario_mes DESC;


--7. N�mero identificador do profesorado que imparte clases. Como � l�xico, se un profesor imparte m�is dunha actividade, o seu n�mero s� pode aparecer unha vez.

    SELECT num_socio
    FROM EMPREGADO
    WHERE cargo = 'PRF'
    GROUP BY num_socio;


--8. N�mero identificador das actividades �s que asiste profesorado, � dicir, cursadas por profesorado. 

    SELECT id_actividade
    FROM EMPREGADO
    WHERE cargo = 'PRF'
    GROUP BY id_actividade;


--9. Nome, importe, e importe rebaixado un 20%, da actividade de nome xadrez.

    SELECT nome, importe, importe*0.8 AS importe_rebaixado
    FROM ACTIVIDADE
    WHERE nome = 'xadrez';


--10. NIF, nome e apelidos dos socios dos que non temos tel�fono gardado.


    SELECT NIF, nome, apelido1, apelido2
    FROM SOCIO
    WHERE telefono IS NULL;

--11. NIF, nome, apelidos e data de nacemento dos socios nados entre 1980 e 1990, ambos inclu�dos.

    SELECT NIF, nome, apelido1, apelido2, data_nacemento
    FROM SOCIO
    WHERE data_nacemento BETWEEN '1980-01-01' AND '1990-12-31';


--12. Todos os datos das actividades cuxo nome cont�n a letra T.

    SELECT *
    FROM ACTIVIDADE
    WHERE nome LIKE '%T%';


--13. Nome e importe das cotas cun custo de 30 ou 100 euros.

    SELECT nome, importe
    FROM COTA
    WHERE importe IN (30, 100);


--14. Nome e n�mero de prazas das actividades que non te�en nin 15 nin 20 prazas.

    SELECT nome, num_plazas
    FROM ACTIVIDADE
    WHERE num_plazas NOT IN (15, 20);