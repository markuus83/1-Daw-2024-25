CREATE DATABASE  EJEMPLOSALTERDROP;

USE EJEMPLOSALTERDROP;  

/* A. Alterar una tabla para agregar una nueva columna
El ejemplo siguiente agrega una columna que permite valores nulos y
a la que no se han proporcionado valores mediante una definición DEFAULT.
Cada fila tendrá un valor NULL en la nueva columna.
*/
--Si la tabla esta vacia:

CREATE TABLE doc_exa ( column_a INT)
GO
ALTER TABLE doc_exa ADD column_b VARCHAR(20) NULL
GO
SELECT * from doc_exa

DROP TABLE doc_exa;


-- Si la tabla tiene datos previos:

CREATE TABLE doc_exa ( column_a INT)
GO
INSERT INTO doc_exa VALUES(25), (50);
GO
SELECT * from doc_exa;
GO
ALTER TABLE doc_exa ADD column_b VARCHAR(20) NULL
GO
SELECT * from doc_exa

 
/* B. Alterar una tabla para quitar una columna
El ejemplo siguiente modifica una tabla para quitar una columna.
*/
CREATE TABLE doc_exb ( column_a INT, column_b VARCHAR(20) NULL)
GO
ALTER TABLE doc_exb DROP COLUMN column_b
GO
  
/* C. Alterar una tabla para agregar una columna con una restricción
El ejemplo siguiente agrega una nueva columna con una restricción UNIQUE.
*/
CREATE TABLE doc_exc ( column_a INT)
GO
ALTER TABLE doc_exc ADD column_b VARCHAR(20) NULL
   CONSTRAINT exb_unique UNIQUE
GO
  
/* D. Alterar una tabla para agregar una restricción si se comprueba y si no.
El ejemplo siguiente agrega una restricción a una columna existente de la tabla.
La columna tiene un valor que infringe la restricción; por tanto, se utiliza WITH NOCHECK para impedir que la restricción se valide contra las filas existentes y para permitir que se agregue la restricción.
*/
--Añade la restriccion comprobando los valores anteriores:
--Como no la cumple da error

CREATE TABLE doc_exd ( column_a INT);
GO
INSERT INTO doc_exd VALUES (-1);

SELECT * FROM doc_exd;

ALTER TABLE doc_exd
   ADD CONSTRAINT exd_check CHECK (column_a > 1)
GO


GO
--Añadir la restriccion sin comprobar si se cumple en los valores anteriores:

DROP TABLE  doc_exd;

CREATE TABLE doc_exd ( column_a INT);
GO
INSERT INTO doc_exd VALUES (-1);

SELECT * FROM doc_exd;

ALTER TABLE doc_exd WITH NOCHECK
   ADD CONSTRAINT exd_check CHECK (column_a > 1)
GO
 
--No da error.


ALTER TABLE doc_exd
	DROP  exd_check;

DROP TABLE  doc_exd;


/* E. Alterar una tabla para agregar varias columnas con restricciones
El ejemplo siguiente agrega varias columnas con restricciones que se definen
con la nueva columna. La primera columna nueva tiene una propiedad IDENTITY;
cada fila de la tabla tiene nuevos valores incrementales en la columna de identidad.
*/
CREATE TABLE doc_exe ( column_a INT CONSTRAINT column_a_un UNIQUE)
GO
ALTER TABLE doc_exe ADD
   -- Add una PRIMARY KEY identity columna.
   column_b INT IDENTITY
   CONSTRAINT column_b_pk PRIMARY KEY,

     -- Add una columna referenciando (FK) otra columna en la misma tabla.
   column_c INT NULL
   CONSTRAINT column_c_fk
   REFERENCES doc_exe(column_a),

   -- Add una columna con una constraint que  fuerza que    
   -- el telefono sea Nulo o tenga formato de telefono.  
   column_d VARCHAR(16) NULL
   CONSTRAINT column_d_chk
   CHECK
     (column_d IS NULL OR
     column_d LIKE '[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]' OR
     column_d LIKE
     '([0-9][0-9][0-9]) [0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]'),

   -- Add una columna nonnull  con un default.  */
   column_e DECIMAL(3,3)
   CONSTRAINT column_e_default
   DEFAULT .081
GO

DROP TABLE doc_exe;

/* F. Agregar una columna que acepta Null con valores predeterminados
El ejemplo siguiente agrega una columna que acepta Null con una definición
DEFAULT y utiliza WITH VALUES para proporcionar los valores de cada fila
existente en la tabla. Si no se utiliza WITH VALUES, cada fila tiene
el valor NULL en la nueva columna.

*/
-- Sin la opcion values ignora el Default:
CREATE TABLE MyTable (Datos datetime);

INSERT INTO MyTable  values('24/12/2023');

SELECT * FROM MyTable;

ALTER TABLE MyTable
  ADD AddDate smalldatetime NULL
  CONSTRAINT AddDateDflt
  DEFAULT getdate();

-- Con la opcion values rellena con el Default:
CREATE TABLE MyTable (Datos datetime);

INSERT INTO MyTable  values('24/12/2023');

SELECT * FROM MyTable;

ALTER TABLE MyTable
  ADD AddDate smalldatetime NULL
  CONSTRAINT AddDateDflt
  DEFAULT getdate() WITH VALUES;




DROP TABLE MyTable;
  
/* G. Deshabilitar y volver a habilitar una restricción
El ejemplo siguiente deshabilita una restricción que limita los
salarios que se aceptan en los datos.
NOCHECK CONSTRAINT se utiliza con ALTER TABLE para deshabilitar
la restricción y permitir una inserción que normalmente infringe
la restricción. CHECK CONSTRAINT se emplea para habilitar la restricción. */

CREATE TABLE cnst_example (
   id INT NOT NULL,
   name VARCHAR(10) NOT NULL,
   salary MONEY NOT NULL
         CONSTRAINT salary_cap CHECK (salary < 100000)
)
-- Inserts Validos
INSERT INTO cnst_example VALUES (1,'Joe Brown',65000)
INSERT INTO cnst_example VALUES (2,'Mary Smith',75000)
 select * from  cnst_example
-- Este Insert viola la constraint.
INSERT INTO cnst_example VALUES (3,'Pat Jones',105000)
  
-- Desactivamos la constraint y lo intentamos otra vez.
ALTER TABLE cnst_example NOCHECK CONSTRAINT salary_cap
INSERT INTO cnst_example VALUES (3,'Pat Jones',105000)
  
-- Reactivamos la constraint e intentamos otro vez el Insert, fallara.
ALTER TABLE cnst_example CHECK CONSTRAINT salary_cap
INSERT INTO cnst_example VALUES (4,'Eric James',110000)

drop table cnst_example;

drop database EJEMPLOSALTERDROP;
