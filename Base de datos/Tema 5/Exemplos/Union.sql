--Consultas Ejemplo de las Consultas compuestas

	--Seleccionamos a BD SOCIEDADE_CULTURAL
	USE a23marcoscc_BD_SociedadeCultural;


--1.- Esta consulta de exemplo amosa o nome completo dos socios morosos,
--que son aqueles que deben ou a cota anual ou algunha actividade. 
--O resultado aparecer� ordenado por orde alfab�tica de apelidos e nome:

SELECT * FROM SOCIO;
SELECT * FROM SOCIO_REALIZA_ACTI;
	
	SELECT ape1, ape2, nome
	FROM SOCIO
	WHERE abonada ='N'

	UNION

	SELECT s.ape1, s.ape2, s.nome
	FROM SOCIO s, SOCIO_REALIZA_ACTI r
	WHERE r.pagada ='N' AND
	      s.numero = r.num_socio 
    ORDER BY ape1, ape2, nome;
	

--2.-Nome completo dos socios morosos.

	--Engadimos ALL
	SELECT ape1, ape2, nome
	FROM SOCIO
	WHERE abonada ='N'

	UNION ALL

	SELECT s.ape1, s.ape2, s.nome
	FROM SOCIO s, SOCIO_REALIZA_ACTI r
	WHERE r.pagada ='N' AND
	      s.numero = r.num_socio 
    ORDER BY ape1, ape2, nome;

--Vemos como agora aparece d�as veces Sieiro Campos Manuel. 
--Se executamos as consultas de xeito independente entender�molo. 
--Este socio debe a cota anual pero tam�n debe unha actividade, 
--polo tanto aparece no resultado das d�as consultas que unimos. 
--Se non utilizamos ALL as filas repetidas desc�rtanse, 
--pero ao po�elo am�sanse no resultado.

	

--3.-Nome completo dos socios morosos porque deben a cota 
--anual e tam�n algunha actividade.
	
	
	SELECT ape1, ape2, nome
	FROM SOCIO
	WHERE abonada ='N'

	INTERSECT

	SELECT s.ape1, s.ape2, s.nome
	FROM SOCIO s, SOCIO_REALIZA_ACTI r
	WHERE r.pagada ='N' AND
	      s.numero = r.num_socio 
    ORDER BY ape1, ape2, nome;

--Como era de esperar no resultado aparece s� Sieiro Campos Manuel,
--porque cos datos actuais � o �nico que ademais de deber a cota anual 
--tam�n debe algunha actividade.





--4.- Nome, data de inicio e prezo das actividades 
--non gratu�tas do mes de febreiro de calquera ano. 
--Para obter o mes dunha data utilizamos a funci�n 
--integrada no xestor month. O resultado deber� aparecer
--ordenado por data de inicio, de m�is antiga a m�is recente.


		SELECT nome, data_ini, prezo
		FROM ACTIVIDADE
		WHERE prezo>0

		INTERSECT

		SELECT nome, data_ini, prezo
		FROM ACTIVIDADE
		WHERE month(data_ini)=2
		ORDER by data_ini;

--No resultado aparecen as actividades que cumpren as condici�ns
--das d�as consultas. Evidentemente esta consulta poder�a terse resolto
--cun �nico SELECT coas d�as condici�n nun �nico WHERE, separadas por AND,
--pero o que se pretende con este exemplo � s� ilustrar o uso da intersecci�n.

	
--5.- Nome completo dos socios morosos porque deben a cota 
--anual pero non deben actividades.

	SELECT ape1, ape2, nome
	FROM SOCIO
	WHERE abonada ='N'

	EXCEPT

	SELECT s.ape1, s.ape2, s.nome
	FROM SOCIO s, SOCIO_REALIZA_ACTI r
	WHERE r.pagada ='N' AND
	      s.numero = r.num_socio 
    ORDER BY ape1, ape2, nome;


--6.- Nome, data de inicio e prezo das actividades 
--non gratu�tas que non empezan no mes de febreiro.
-- Repite a do exemplo 4

	SELECT nome, data_ini, prezo
	FROM ACTIVIDADE
	WHERE prezo>0

	EXCEPT

	SELECT nome, data_ini, prezo
	FROM ACTIVIDADE
	WHERE month(data_ini)=2
	ORDER by data_ini;



	

	