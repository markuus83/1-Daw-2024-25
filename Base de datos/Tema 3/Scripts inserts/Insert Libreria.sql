insert into Autor (Cod_Autor, Nome)values ( 1, 'Victor Martinez')
insert into Autor (Cod_Autor, Nome)values ( 2, 'Luis Perez')
insert into Autor (Cod_Autor, Nome)values ( 3, 'Juan Fernandez')


select * from amigo
-- Dejo con Fecha de Inicio en NULL.

insert into Amigo(Cod_Ami, Nome, Telefono, Presta, Regala, Enderezo) values (1, 'Pepe', '981111111', 0,1, 'Vigo') --Regalador
insert into Amigo(Cod_Ami, Nome, Telefono, Presta, Regala, Enderezo)values (2, 'Luis', '981222222', 1,0, 'Lugo') --Prestador
insert into Amigo(Cod_Ami, Nome, Telefono, Presta, Regala, Enderezo) values (3, 'Jose', '981333333', 1,1, 'Vigo') --Regalador y Prestador
insert into Amigo(Cod_Ami, Nome, Telefono, Presta, Regala, Enderezo) values (4, 'Ana', '981444444', 0,0, 'Vigo') --No deber?a entrar. 
--Es erroneo, ya que la extension tiene completitude total.

select * from Editorial;

insert into Editorial(Cod_edi, Nome) values (1, 'Anaya')
insert into Editorial(Cod_edi, Nome) values (2, 'Anagrama')
insert into Editorial(Cod_edi, Nome) values (3, 'Norte')



select * from libreria;

insert into libreria(Nome, Enderezo, Telefono, Persoa_Cont)values('Follas','Santiago','981-111111','Juan')
insert into libreria(Nome, Enderezo, Telefono, Persoa_Cont)values('Abraxas','Santiago','981-222222','Luis')
insert into libreria(Nome, Enderezo, Telefono, Persoa_Cont)values('Gonzalez','Santiago','981-444444','Ana')
insert into libreria(Nome, Enderezo, Telefono, Persoa_Cont)values('Couceiro','Santiago','981-333333','Rosa')


--A�ado la libreria por defecto que me mandan que sea de codigo 99 y el campo es identity.
--****************************************************************************************
SET IDENTITY_INSERT librerias on

insert into libreria(Cod_Libreria, Nome, Enderezo, Telefono, Persoa_Cont) values(99, 'Follas','Santiago','981-111111','Juan')

select * from Libreria

SET IDENTITY_INSERT librerias off

--Prueba insert en identity despues de apagar el Identity Insert

insert into libreria(Nome, Enderezo, Telefono, Persoa_Cont) values('Comercial','Vigo','986-444444','Ana')

select * from Libreria
--***************************************************************************************************


select * from Libro

insert into libro(Cod_Libro,Titulo, Data_Adq, Ano_Edi, Cod_edi, Prezo,
Fot_Ori, Mer_Reg, Esp_Can, Cod_Ami,	Cod_Libreria) values
--Cod_Libro,Titulo,    Data_Adq,   Ano_Edc,Cod_edi,Prezo,Fot_Ori,Mer_Reg,Esp_Can,Cod_Ami,Cod_Lib
       (1,  'La rosa', '24/4/2013','1994',     1,   100,     1,     1,      1,    Null,    Null)


insert into libro(Cod_Libro,Titulo, Data_Adq, Ano_Edi, Cod_edi, Prezo,
Fot_Ori, Mer_Reg, Esp_Can, Cod_Ami,	Cod_Libreria) values
--Cod_Libro,Titulo,    Data_Adq,   Ano_Edc,Cod_edi,Prezo,Fot_Ori,Mer_Reg,Esp_Can,Cod_Ami,Cod_Lib
     (2,    'Juntos', '24/4/2012',  '1996',    2,   100,    0,      1,     Null,    Null,  '1')  

insert into libro(Cod_Libro,Titulo, Data_Adq, Ano_Edi, Cod_edi, Prezo,
Fot_Ori, Mer_Reg, Esp_Can, Cod_Ami,	Cod_Libreria) values
--Cod_Libro,Titulo,    Data_Adq,   Ano_Edc,Cod_edi,Prezo,Fot_Ori,Mer_Reg,Esp_Can,Cod_Ami,Cod_Lib,
    (3,     'Separados','28/6/2010','1993',   2,    Null,    0,     0,      Null, '1',      '1')




insert into libro(Cod_Libro,Titulo, Data_Adq, Ano_Edi, Cod_edi, Prezo,
Fot_Ori, Mer_Reg, Esp_Can, Cod_Ami,	Cod_Libreria) values
--Cod_Libro,Titulo,    Data_Adq,   Ano_Edc,Cod_edi,Prezo,Fot_Ori,Mer_Reg,Esp_Can,Cod_Ami,Cod_Lib
      (4,   'Alien', '28/6/2003',   '1993',    2,   Null,   1,      0,      1,     '1',    Null)


insert into libro(Cod_Libro,Titulo, Data_Adq, Ano_Edi, Cod_edi, Prezo,
Fot_Ori, Mer_Reg, Esp_Can, Cod_Ami,	Cod_Libreria) values
--Cod_Libro,Titulo,    Data_Adq, Ano_Edc,Cod_edi,Prezo,Fot_Ori,Mer_Reg,Esp_Can,Cod_Ami,Cod_Lib
     (5,    'Alien',  '28/6/2003', '1993',    2,   200,   1,      1,      1,     Null,    Null)


select * from Libros -- Para comprobar que pusimos todos los datos congruentes


select * from prestamo;
 
insert into prestamo(Cod_Ami_Pre,Cod_Libro,Data_Dev) values('1','1', '28/6/2010','28/8/2010')
insert into prestamo(Cod_Ami_Pre,Cod_Libro,Data_Dev) values('1','2', '28/9/2010','28/10/2010')
insert into prestamo(Cod_Ami_Pre,Cod_Libro,Data_Dev) values('3','1', '28/6/2012','28/8/2012')
insert into prestamo(Cod_Ami_Pre,Cod_Libro,Data_Dev) values('3','1', '28/8/2012', Null)
insert into prestamo(Cod_Ami_Pre,Cod_Libro,Data_Dev) values('3','1', '28/8/2011','28/4/2014')
insert into prestamo(Cod_Ami_Pre,Cod_Libro,Data_Dev) values('3','3', '28/8/2011','28/4/2014')




select * from LIBRO_AUTOR
insert into LIBRO_AUTOR(Cod_Autor, Cod_Libro) values('1', '1')
insert into LIBRO_AUTOR(Cod_Autor, Cod_Libro) values('3', '1')
insert into LIBRO_AUTOR(Cod_Autor, Cod_Libro) values('1', '2')
insert into LIBRO_AUTOR(Cod_Autor, Cod_Libro) values('3', '2')


select * from indice

insert into indice(Cod_Libro,Cod_Tit,Texto_Tit,Paxina,Cod_L_Pai, Cod_T_Pai)values(1,1,'Cap.1',1,Null,Null)
insert into indice(Cod_Libro,Cod_Tit,Texto_Tit,Paxina,Cod_L_Pai, Cod_T_Pai) values(1,2,'Cap.11',2,1,1)
insert into indice(Cod_Libro,Cod_Tit,Texto_Tit,Paxina,Cod_L_Pai, Cod_T_Pai) values(1,3,'Cap.12',5,1,1)
insert into indice(Cod_Libro,Cod_Tit,Texto_Tit,Paxina,Cod_L_Pai, Cod_T_Pai) values(1,4,'Cap.121',6,1,3)
insert into indice(Cod_Libro,Cod_Tit,Texto_Tit,Paxina,Cod_L_Pai, Cod_T_Pai) values(1,5,'Cap.2',7,Null,Null)
insert into indice(Cod_Libro,Cod_Tit,Texto_Tit,Paxina,Cod_L_Pai, Cod_T_Pai)values(2,1,'Cap.1',8,Null,Null)