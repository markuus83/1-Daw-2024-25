DROP DATABASE  IF EXISTS a23marcoscc_BDEmpleados2;
						GO
CREATE DATABASE a23marcoscc_BDEmpleados2;
						GO
USE a23marcoscc_BDEmpleados2;

create table tabla_ejemplo
(
        nuevo tinyint
);

ALTER TABLE tabla_ejemplo
        ADD nuevo1 varchar(10);

ALTER TABLE tabla_ejemplo
        ADD nuevo2 tinyint  CHECK (nuevo2>10);

-- Consulta de la tabla creada:
SELECT *
FROM tabla_ejemplo;

-- Borro la columna nuevo2 en tabla_ejemplo:

ALTER TABLE tabla_ejemplo 
        drop column nuevo2;

-- Da error, tengo que borrar la constraint.    

-- Borra la constraint Check, como no le puse nombre, tendr� el que el puso el gestor.

ALTER TABLE tabla_ejemplo
        drop constraint  CK__tabla_eje__nuevo__36B12243;

-- Repito
ALTER TABLE tabla_ejemplo 
        drop column nuevo2;




-- Consulta de la tabla creada:                 
select *
from tabla_ejemplo;

--Compruebo que borro nuevo 2
--La vuelvo a a�adir

ALTER TABLE tabla_ejemplo
        ADD nuevo2 tinyint  CHECK (nuevo2>10);


-- Consulta de la tabla creada:                 
select *
from tabla_ejemplo;



-- A�ade una columna Not Null, mientras no meta valores es valido.

ALTER TABLE tabla_ejemplo
        ADD nuevo3 varchar(10) Not Null;

-- A�adimos datos

insert into tabla_ejemplo
       values(1, 'casa', 23, 'Lois');

insert into tabla_ejemplo
	values(1, 'casa', 10, 'Luis');-- Error 

insert into tabla_ejemplo
	values(1, 11, 'ber');

-- Consulta de la tabla creada:                 
select *
from tabla_ejemplo;

-- Las dos siguientes instruciones hacen lo mismo

insert into tabla_ejemplo
        (nuevo, nuevo3)
values(1, 23);
insert into tabla_ejemplo
values(1, Null, NULL, 'cas');



-- Consulta de la tabla creada: 
select *
from tabla_ejemplo;


-- Al haber valores en la tabla Alter table ADD column... se comporta de distinta manera:

-- No deja a�adir una columna si no permite valores Null o tiene Default

ALTER TABLE tabla_ejemplo
                        ADD nuevo4 varchar(10) Not Null;

-- Le sacamos el Not Null y ya deja


ALTER TABLE tabla_ejemplo
                        ADD nuevo4 varchar(10) ;

-- Consulta de la tabla creada: 
select *
from tabla_ejemplo;

-- Vemos que relleno con Null los valores nuevos de las filas exixtentes.


-- Prueba del with values

-- A�ade la columna y rellena con NULL, las filas ya existentes

-- Vamos a a�adir una nueva columna con Default

ALTER TABLE tabla_ejemplo
                        add  nuevo5 char(2)  default ('N0');

-- Consulta de la tabla creada:                                         
select *
from tabla_ejemplo;
-- Inserto valores

insert into tabla_ejemplo
values(1, 'casa', 23, 'Luna', Null, 'SI');
insert into tabla_ejemplo
values(1, 'casa', 23, 'Luna', Null, Default);

select *
from tabla_ejemplo;

ALTER TABLE tabla_ejemplo
                        add  nuevo8 char(2)  constraint default_no default ('N0') with values;

--with values  hace que rellene las filas anteriores con el default

select *
from tabla_ejemplo;

exec sp_help tabla_ejemplo





-- Si la columna no permite valores Null, toma el valor por defecto aunque no lleve 
--'with values'.


alter table tabla_ejemplo 
						 add nuevo6  char(2) Not Null  DEFAULT ('NO')


select *
from tabla_ejemplo;

-- Inserta la columna y rellena con el valor por defecto las filas ya existentes

ALTER TABLE tabla_ejemplo
                        ADD nuevo7 char(2) not null CONSTRAINT valor_no6  DEFAULT ('NO')
						WITH VALUES


select *
from tabla_ejemplo



-- No puedo borrar una columna que tenga una restriccion

ALTER TABLE tabla_ejemplo 
                        drop column nuevo6;

ALTER TABLE tabla_ejemplo
                        drop  DF__tabla_eje__nuevo__3A81B327;








--Explicar que acciones realiza la siguiente sentencia ALTER    

CREATE TABLE doc_exe
(
        column_a INT CONSTRAINT column_a_un UNIQUE
)

ALTER TABLE doc_exe ADD 
                                
                        column_b INT IDENTITY
                        CONSTRAINT column_b_pk PRIMARY KEY, 
                          
                        column_c INT NULL  
                        CONSTRAINT column_c_fk 
                        REFERENCES doc_exe(column_a),
                          
                        column_d VARCHAR(16) NULL 
                        CONSTRAINT column_d_chk
                        CHECK 
                        (column_d IS NULL OR 
                        column_d LIKE '[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]' OR
                        column_d LIKE
                        '([0-9][0-9][0-9]) [0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]'),
                          
                        column_e DECIMAL(3,3)
                        CONSTRAINT column_e_default
                        DEFAULT .081


/* solucion*/

CREATE TABLE doc_exe
(
        column_a INT CONSTRAINT column_a_un UNIQUE
)

ALTER TABLE doc_exe ADD
                         
                          
                        /* Add a PRIMARY KEY identity column. */ 
                        column_b INT IDENTITY
                        CONSTRAINT column_b_pk PRIMARY KEY, 
                          
                        /* Add a column referencing another column in the same table. */ 
                        column_c INT NULL  
                        CONSTRAINT column_c_fk 
                        REFERENCES doc_exe(column_a),
                          
                        /* Add a column with a constraint to enforce that   */ 
                        /* nonnull data is in a valid phone number format.  */
                        column_d VARCHAR(16) NULL 
                        CONSTRAINT column_d_chk
                        CHECK 
                        (column_d IS NULL OR 
                        column_d LIKE '[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]' OR
                        column_d LIKE
                        '([0-9][0-9][0-9]) [0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]'),
                          
                        /* Add a nonnull column with a default.  */ 
                        column_e DECIMAL(3,3)
                        CONSTRAINT column_e_default
                        DEFAULT .081


EXEC sp_help doc_exe


DROP TABLE doc_exe




/*Deshabilitar y volver a habilitar una restricci?n
El ejemplo siguiente deshabilita una restricci�n que limita los salarios que se aceptan en los datos. 
WITH NOCHECK CONSTRAINT se utiliza con ALTER TABLE para deshabilitar la restricci?n y permitir una inserci?n 
que normalmente infringir?a la restricci?n. 
WITH CHECK CONSTRAINT se emplea para volver a habilitar la restricci?n.
Esta opci?n solo se puede utilizar con las restricciones FOREIGN KEY y CHECK
*/

CREATE TABLE cnst_example
(
        id INT NOT NULL,
        name VARCHAR(10) NOT NULL,
        salary MONEY NOT NULL
                CONSTRAINT salary_cap CHECK (salary < 100000)
)

-- Valid inserts:

INSERT INTO cnst_example
VALUES
        (1, 'Joe Brown', 65000)
INSERT INTO cnst_example
VALUES
        (2, 'Mary Smith', 75000)

select *
from cnst_example

-- This insert violates the constraint:

INSERT INTO cnst_example
VALUES
        (3, 'Pat Jones', 105000)

-- Disable the constraint and try again:

ALTER TABLE cnst_example NOCHECK CONSTRAINT salary_cap
INSERT INTO cnst_example
VALUES
        (3, 'Pat Jones', 105000)

-- Reenable the constraint and try another insert, will fail:

ALTER TABLE cnst_example CHECK CONSTRAINT salary_cap
INSERT INTO cnst_example
VALUES
        (4, 'Eric James', 110000)

/* Otra forma   */



CREATE TABLE cnst_example0
(
        id INT NOT NULL,
        name VARCHAR(10) NOT NULL,
        salary MONEY NOT NULL
)



INSERT INTO cnst_example0
VALUES
        (1, 'Joe Brown', 65000)
INSERT INTO cnst_example0
VALUES
        (2, 'Mary Smith', 75000)


ALTER TABLE  cnst_example0 add  CONSTRAINT salary_cap0  CHECK  (salary < 100000)


select *
from cnst_example0


INSERT INTO cnst_example0
VALUES
        (3, 'Pat Jones', 105000)

alter table cnst_example0 NOCHECK CONSTRAINT ALL

INSERT INTO cnst_example0
VALUES
        (3, 'Pat Jones', 105000)

INSERT INTO cnst_example0
VALUES
        (3, 'Pat Jones', 105000)

alter table cnst_example0  CHECK CONSTRAINT ALL

INSERT INTO cnst_example0
VALUES
        (3, 'Pat Jones', 105000)