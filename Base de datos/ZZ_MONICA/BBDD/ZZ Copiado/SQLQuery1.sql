--DDL
create table tabla_80
(codigo int,
nome varchar(30));

insert into tabla_80(codigo,nome)
values (1, 'nome1');

--DML
select*
from tabla_80;

--DDL
alter table tabla_80
add observaciones varchar(100);


update tabla_80 
set observaciones='esto es una prueba'
where codigo=1;


insert into tabla_80(codigo,nome)
values (2, 'nome1');


delete from tabla_80

insert into tabla_80 (codigo,nome,observaciones)
values (1, 'nome1','Israel'),
	   (2, 'nome2','Albacete'),
	   (3, 'nome3', null),
	   (4, 'nome4', '------');

--DML
delete from tabla_80 
where codigo=3;

--DDL
drop table tabla_80;

select observaciones
from tabla_80
where codigo=4;

--DDL create/alter/drop/use

--DML select/insert/update/delete

