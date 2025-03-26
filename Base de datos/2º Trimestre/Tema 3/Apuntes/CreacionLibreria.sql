CREATE DATABASE a23marcos_Libreria;

GO

USE a23marcos_Libreria;

CREATE TABLE AMIGO (

	cod_Amigo char(4) primary key,
	nome varchar(30) not null,
	enderezo varchar (30),
    telefono varchar(9) not null,
    presta bit not null,
    regala bit not null,

);


CREATE TABLE LIBRERIA (

    cod_libreria char(4) primary key,
    nome varchar(30) not null,
    enderezo varchar(30),
    telefono varchar(9) not null,
    persoa_cont char(4) not null,

);


CREATE TABLE EDITORIAL (

    cod_editorial char(4) primary key,
    nome varchar(30) not null,


);


CREATE TABLE LIBRO (

    cod_libro char(4) primary key,
    titulo varchar (30) not null,
    data_adqu date,
    año_edc date,
    cod_editorial char(4) not null, -- Foreign Key
    prezo float,
    fot_ori bit not null,
    mer_reg bit not null,
    esp_can bit,
    cod_amigo char(4), -- Foreign Key
    cod_libreria char(4), -- Foreign Key


    constraint FK_CodEditorial_Libro 
    foreign key (cod_editorial)
    references EDITORIAL(cod_editorial)
    on update cascade on delete no action,

    constraint FK_CodAmigo_Libro
    foreign key (cod_amigo)
    references AMIGO(cod_amigo)
    on update cascade on delete no action,

    constraint FK_Codlibreria_Libro
    foreign key (cod_libreria)
    references LIBRERIA(cod_libreria)
    on update cascade on delete no action,
 
);


CREATE TABLE AUTOR (

    cod_autor char(4) primary key,
    nome varchar(30) not null,

);


CREATE TABLE LIBRO_AUTOR (

    cod_autor char(4),
    cod_libro char(4),


    constraint PK_LibroAutor
    primary key (cod_autor, cod_libro),

    constraint FK_CodAutor_LibroAutor
    foreign key (cod_autor)
    references AUTOR(cod_autor)
    on update cascade on delete no action,

    constraint FK_CodLibro_LibroAutor
    foreign key (cod_libro)
    references LIBRO(cod_libro)
    on update cascade on delete cascade
);


CREATE TABLE PRESTAMO (

    cod_ami_pre char(4),
    cod_libro char(4),
    data_devolucion date,


    constraint PK_Prestamo
    primary key (cod_ami_pre, cod_libro),

    constraint FK_CodAmiPre_Prestamo
    foreign key (cod_ami_pre)
    references AMIGO(cod_amigo)
    on update cascade on delete cascade,

    constraint FK_CodLibro_Prestamo
    foreign key (cod_libro)
    references LIBRO(cod_libro)
    on update no action on delete no action,

);



CREATE TABLE INDICE (

    cod_libro char(4),
    cod_titulo char(4),
    texto_tit varchar(30) not null,
    paxina int not null,
    cod_L_pai char(4),
    cod_T_pai char(4),

	constraint PK_Indice
	primary key (cod_libro, cod_titulo),
	
	constraint FK_CodLibro_INDICE
	foreign key (cod_libro)
	references LIBRO(cod_libro)
	on update cascade on delete cascade, 
	
	constraint FK_CodL_Pai_INDICE
	foreign key (cod_L_pai, cod_T_pai)
	references INDICE(cod_libro, cod_titulo)
	on update no action on delete no action,
);
