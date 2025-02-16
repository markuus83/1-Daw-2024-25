use monica;

create table tabla1
(codigo int,
 nome varchar(30));

 insert into tabla1(codigo,nome)
 values (1,'nome1');

 select *
 from tabla1;

 alter table tabla1
 add observaciones varchar(100);
 
 update tabla1
 set observaciones='esto es una prueba'
 where codigo=1;

 insert into tabla1(codigo,nome)
 values (2,'nome1');

 delete from tabla1;

 insert into tabla1(codigo,nome,observaciones)
 values (1,'nome1','1ª observación'),
 (2,'nome2', 'jkhadjkfha'),
 (3,'nome3', null);

 drop table tabla1;
