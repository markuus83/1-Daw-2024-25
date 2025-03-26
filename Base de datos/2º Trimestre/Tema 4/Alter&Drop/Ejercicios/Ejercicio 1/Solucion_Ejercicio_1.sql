-- Sentencias DDL para implementar el siguiente modelo lógico:

--- - Empleado (codemp, nombre, apellido1, apellido2, direccion, provincia, dni, coddepto, salario, fecalta, dto) 
--	- Departamento (coddepto, depto, codjefe, presupuesto) 
--	- Horas_extra (codemp, fecha, num_horas)
use master;

drop database if exists at0401;
go
create database at0401;
go
use at0401;

create table EMPLEADO(
    codemp			     smallint identity primary key,
    nombre				 varchar(50) not null,
    apellido1			 varchar(100) not null,
    apellido2			 varchar(100) not null,
    direccion			 varchar(100),
    provincia			 varchar(20) default 'Pontevedra',
    dni					 char(9) check (dni like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]' )                                 constraint dniunico1_un unique,
    coddepto			 smallint,
    salario              decimal(8,2) default 800,
    fecalta              char(10) check (fecalta  like '[0-9][0-9]/[0-9][0-9]/[0-9][0-9]'),
    dto                  decimal(4,2)
);

insert into empleado values('Pepe','Lopez','Perez','C/Buena nº 27','Lugo','37919229x', 23, default,'23/12/67', 23);
select * from empleado;




--drop table DEPARTAMENTO;

create table DEPARTAMENTO(
    coddepto			 smallint identity primary key,
    depto				 varchar(30) constraint depunico_un unique not null,
    codjefe				 smallint,
    presupuesto decimal(8,2) default 0
	constraint FK_depto_emp foreign key (codjefe) references EMPLEADO(codemp),

);

--Añado la FK despues de crear la tabla.
--alter table EMPLEADO add constraint FK_EMP_DEPTO foreign key(coddepto) 
--references DEPARTAMENTO(coddepto) on update cascade on delete no action;


-- Da error de FK pues el departamento 23 no existe.
-- Lo añado:

SET IDENTITY_INSERT Departamento  on;

insert into DEPARTAMENTO (coddepto, depto, codjefe,presupuesto) values (23, 'casa', 1, default);

SELECT * FROM DEPARTAMENTO

SET IDENTITY_INSERT Departamento  off;

insert into DEPARTAMENTO ( depto, codjefe, presupuesto) values ( 'Marketing', 1, default);

-- Añado ahora la FK y no da error:

		alter table EMPLEADO add constraint FK_EMP_DEPTO foreign key(coddepto) 
		references DEPARTAMENTO(coddepto) on update cascade on delete no action;

create table HORAS_EXTRA(
    codemp          smallint references EMPLEADO(codemp) on update cascade on delete no action,
    fecha           date,
    num_horas       decimal(3,1),
    constraint PK_horas_extra primary key (codemp,fecha)
);

--3.- Realizar los cambios en la BD

-- Añade un campo a la tabla empleado para guardar el importe que cobra el empleado por sus horas extras.

		alter table empleado add importe decimal(4,2);

-- Todos los empleados del mismo departamento cobran lo mismo, as� que mejor elimina el campo
-- que acabas de crear y a��delo a la tabla departamento.

		alter table empleado drop column importe;
		alter table departamento add importe decimal(4,2);


-- Se han dado cuenta que guardar la fecha de alta del empleado como texto es una tonter�a,
-- as� que la cambiaremos para que sea una fecha. 
-- Adem�s, debe tomar por defecto el valor devuelto por la funci�n GETDATE().
-- Sin cambiar la estructura de la tabla.

select * from EMPLEADO

alter table empleado alter column  fecalta date

-- no lo hace pues tiene un check

alter table empleado drop CK__EMPLEADO__fecalt__3B75D760

--Repito el cambio. 

alter table empleado alter column  fecalta date

-- Añado la constraint

alter table empleado add constraint fecha_actual_df  default GETDATE() for fecalta;




-- Modifica el campo dni del empleado para que tenga que ser indicado obligatoriamente.

alter table empleado alter column  dni char(9)  not null ;



alter table empleado drop constraint  dniunico1_un;
alter table empleado alter column  dni char(9) not null;
alter table empleado add constraint dniunico_un unique(dni);

select * from INFORMATION_SCHEMA.KEY_COLUMN_USAGE ;


-- Cambia el nombre del campo Empleado.dto por Empleado.descuento 
-- y del campo Departamento.depto por Departamento.departamento

EXEC sp_rename 'dbo.Empleado.dto', 'descuento';
EXEC sp_rename 'dbo.Departamento.depto', 'departamento';
