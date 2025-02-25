--Seleccionamos a BD SOCIEDADE_CULTURAL
	USE SOCIEDADE_CULTURAL;


--1.- Prezo medio das actividades
	SELECT avg(prezo) as prezo_medio
	FROM ACTIVIDADE;


--2.-Prezo medio, m�nimo, m�ximo y total das actividades
	SELECT avg(prezo) as prezo_medio, 
	       min(prezo) as prezo_minimo,
		   max(prezo) as prezo_maximo,
		   sum(prezo) as prezo_total
	FROM ACTIVIDADE;


	
--3.- N�mero total de actividades
	--Soluci�n1
	SELECT count(identificador) as numero_de_actividades
	FROM ACTIVIDADE;
	--Soluci�n2
	SELECT count(*) as numero_de_actividades
	FROM ACTIVIDADE;


--4.- N�mero de aulas nos distintos estados.
--Debe aparecer nunha columna o estado
--e noutra o n�mero de aulas nese estado.

	SELECT estado, COUNT(*) as cantidade_aulas
	FROM AULA
	GROUP BY estado;


--5.- Salario medio do profesorado e o 
--dos administrativos. 
--Solución1
	SELECT avg(salario_mes) as salario_medio
	FROM EMPREGADO
	GROUP BY cargo;
	--Solución2
	SELECT cargo, avg(salario_mes) as salario_medio
	FROM EMPREGADO
	GROUP BY cargo;


--6.- Identificador das actividades 
--realizadas por máis dun socio.
	SELECT id_actividade
	FROM SOCIO_REALIZA_ACTI	
	GROUP BY id_actividade
	HAVING count(*)>1;

