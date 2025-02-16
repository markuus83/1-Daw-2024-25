USE SOCIEDADE_CULTURAL_MarcosChouza;

--DESPUES DE CADA ANOTACIÓN HAY QUE ABRIR UNA NUEVA QUERY

select * into actividade2;

from ACTIVIDADE;

select * from ACTIVIDADE;
select * from ACTIVIDADE;


-- ABRIMOS UN NUEVO QUEY (SESION) // CREAMOS UNA NUEVA TABLA TEMPORAL SOLAMENTE EN NUESTRA SESIÓN (SCRIPT)

select * into #actividade3;
from ACTIVIDADE;
select * from #actividade3;

-- AHORA CON DOS ALMOHADILLAS.

select * into ##actividade5
from ACTIVIDADE;


--------- EXERCICIOS --------- 

--Consulta de exemplo 1: Crearase unha táboa permanente co nome COTA_DE_BALDE cos mesmos campos que COTa pero só cos filas das cotas gratis.
-- Os campos da nova táboa terán por nomes cod, descricion e importe. Ao rematar eliminarase a táboa nova coa cláusula DROP TABLE 
-- para non modificar o deseño orixinal da BD.

select DISTINCT s.nif, s.nombe, s.ape1, isnull(s.ape2,'') as ape2
	into #SOCIO_MOROSO
from SOCIO s inner join SOCIO_REALIZA_ACTI sra
	on s.numero=sra.num_socio
where sra.pagada='N';


select * from #SOCIO_MOROSO;


-- CONSULTA DE EXEMPLO 3: Engadiranse dúas novas cotas de balse, unha con código 20 e nome COTA GRATIS, e a outra con código 30 e nome OUTRA GRATIS.
-- Antes e despois do INSERT faremos a consulta que nos amosa a información da táboa en cada momento.

select * from cota;

insert into cota (codigo, nome, importe)
values (20, 'COTA GRATIS', 0),
		(30, 'OUTRA GRATIS',0);

insert into cota (codigo, nome, importe)
values (50, 'COTA GRATIS', 0);

--CONSULTA DE EXEMPLO 4: Engadiranse na táboa COTA unha nova de nome NOVA e código 80 co mesmo importe que a cota de nome HABITUAL.
-- Antes e despois no INSERT faremos a consulta que nos amosa a información da táboa en cada momento.

insert into cota (codigo, nome, importe)
select 80, 'NOVA', importe
from cota
where nome = 'HABITUAL';
select codigo, nome, importe
from COTA;

--CONSULTA DE EXEMPLO 5: Eliminaremos as tres cotas de códigos 20, 30 e 80 engadidas nas consultas de exemplo 3 e 4. Antes e despois
-- do DELETE faremos a consulta que nos amosa a información da táboa en cada momento.

SELECT codigo, nome, importe
from COTA;
go
DELETE FROM COTA
where codigo in (20,30,80);
select codigo, nome, importe
from COTA;

--CONSULTA DE EXEMPLO 6: Para facer esta consulta primeiro crearemos unha táboa temporal local SOCIO2 copia a táboa SOCIO empregando a 
-- sentenza SELECT...INTO. Despois teranse que eliminar os socios da táboa SOCIO2 que deben algunha actividade.

-- A eliminación farame de dous xeitos, nunha primeira solución empregando unha consulta subordinada e, nunha segunda cunha combinación interna.

--SOLUCION1
SELECT * INTO #SOCIO2
FROM SOCIO;

DELETE FROM #SOCIO2
WHERE numero IN (SELECT num_socio
				 FROM SOCIO_REALIZA_ACTI
				 WHERE pagada = 'N');
SELECT * FROM #SOCIO2;

--SOLUCION2 --> Eliminamos e voltamos a crear #SOCIO2 para comprobar a segunda solucion



-- COPIADO DE LA PIZARRA SI ENTERARME DE LO K ESTOY ESCUCHANDO PORQUE ESTOY EN UN VACIO EXISTENCIAL DE COJONES
create table t1
(id int identity (10,15),
saludo varchar(10) not null);

select * from t1;

insert into t1(saludo)
values('hola'),
		('bo dia');

drop table t1, #SOCIO2;

-- CONSULTA DE EXEMPLO 7: 

select * into EMPREGADO2 from empregado;

truncate table empregado2;

select *from;




--Consulta de exemplo 8: Nesta consulta incrementarase o prezo das actividades en 4 euros. Para deixar os datos orixinais da BD, faremos unha segunda modificación e redución do prezo en 4 euros.
-- Faremos unha consulta antes e despois do incremento do prezo.

select * from actividade;

update actividade
set prezo = prezo+4;

select * from actividade;

--CONSULTA DE EXEMPLO 9: Nesta consulta incrementarase en 7 o número de prazas da actividade con número 10, o seu nome pasarña a ser CURSO TENIS
-- e aumentarase o seu prezo en 5'14%. Para deixar os datos orixinais da BD, faremos unha segunda modificación e a táboa
-- quedará como estaba antes da modificación. Faremos unha consulta antes e despois da modificación para comprobar os cambios.

select *
from actividade
where identificador = 10;

update actividade

set num_prazas = num_prazas-7, 
	nome= 'TENIS PARA PRINCIPIANTES',
	prezo= prezo/1.0514

where identificador = 10;

select * from actividade where identificador = 10;



--SIGUIENTE CONSULTA DE PRUEBA:

select * from cota;

update cota
set prezo = (select max(prezo) from actividade)
where importe = 0


-- CONSULTA 11: Poránselle como pagadas todas as actividades aos socios que teñan abonada a cota anual. Para deixar os datos orixinais
-- da BD, faremos unha segunda modificación e a táboa quedará como estaba antes da modificación. Faremos unha consulta antes e despois da
-- modificación para comprobar os cambios.

SELECT s.numero, s.abonada, sr.id_actividade, sr.pagada
FROM SOCIO s INNER JOIN SOCIO_REALIZA_ACTI sr
	ON s.num_casa_enderezo=sr.num_socio
WHERE s.abonada ='S';

update SOCIO_REALIZA_ACTI
set pagada='S'
FROM SOCIO s INNER JOIN SOCIO_REALIZA_ACTI sr
	ON s.numero = sr.num_socio
WHERE s.abonada='S';


SELECT s.numero, s.abonada, sr.pagada
FROM SOCIO s INNER JOIN SOCIO_REALIZA_ACTI sr
	ON s.numero = sr.num_socio
WHERE s.abonada='S';

UPDATE SOCIO_REALIZA_ACTI
SET pagada='N'
WHERE num_socio = 1002 AND
	id_actividade = 40;