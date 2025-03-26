use a23marcos_Libreria;

insert into AMIGO(cod_Amigo, nome, enderezo, telefono, presta, regala)
values
('1111', 'Nome_Amigo 1', 'Enderezo_Amigo 1', '123456789', 0, 1),
('2222', 'Nome_Amigo 2', 'Enderezo_Amigo 2', '123456789', 1, 0),
('3333', 'Nome_Amigo 3', 'Enderezo_Amigo 3', '123456789', 0, 1);
select  * from AMIGO;


insert into AUTOR (cod_autor,nome)
values
('1111', 'Nome_Autor 1'),
('2222', 'Nome_Autor 2'),
('3333', 'Nome_Autor 3');
select * from AUTOR;
select  * from AMIGO;


insert into EDITORIAL (cod_editorial, nome)
values
('1111', 'Nome_Editorial 1'),
('2222', 'Nome_Editorial 2'),
('3333', 'Nome_Editorial 3');
select * from EDITORIAL;
select * from AUTOR;
select  * from AMIGO;


insert into LIBRO(cod_libro, titulo, data_adqu,año_edc,cod_editorial, prezo, fot_ori, mer_reg, esp_can, cod_amigo, cod_libreria)
values
('1111', 'Titulo_Libro 1', NULL, NUll, '1111', NULL, 1, 0, 0, '1111', NULL),
('2222', 'Titulo_Libro 2', NULL, NUll, '2222', NULL, 1, 0, 0, '2222', NULL),
('3333', 'Titulo_Libro 3', NULL, NUll, '3333', NULL, 1, 0, 0, '3333', NULL)
select * from LIBRO;
select * from EDITORIAL;
select * from AUTOR;
select  * from AMIGO;


insert into AUTOR(cod_autor, nome)
values
('1111', 'Nome_Autor 1'),
('2222', 'Nome_Autor 2'),
('3333', 'Nome_Autor 3');
select * from AUTOR;
select * from LIBRO;
select * from EDITORIAL;
select * from AUTOR;
select  * from AMIGO;

insert into LIBRO_AUTOR(cod_autor, cod_libro)
values
('1111', '1111'),
('2222', '2222'),
('3333', '3333');
select * from LIBRO_AUTOR;
select * from AUTOR;
select * from LIBRO;
select * from EDITORIAL;
select * from AUTOR;
select  * from AMIGO;

insert into PRESTAMO(cod_ami_pre, cod_libro, data_devolucion)
values
('1111', '1111', NULL),
('2222', '2222', NULL),
('3333', '3333', NULL);
select * from PRESTAMO;
select * from LIBRO_AUTOR;
select * from AUTOR;
select * from LIBRO;
select * from EDITORIAL;
select * from AUTOR;
select  * from AMIGO;

insert into INDICE(cod_libro, cod_titulo, texto_tit, paxina, cod_L_pai, cod_T_pai)
values
('1111', '1111', 'Titulo_Texto_Indice 1', 10, NULL, NULL),
('2222', '2222', 'Titulo_Texto_Indice 2', 100, NULL, NULL),
('3333', '3333', 'Titulo_Texto_Indice 3', 200, NULL, NULL);

select * from INDICE;
select * from PRESTAMO;
select * from LIBRO_AUTOR;
select * from AUTOR;
select * from LIBRO;
select * from EDITORIAL;
select * from AUTOR;
select  * from AMIGO;