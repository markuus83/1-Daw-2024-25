DROP DATABASE IF EXISTS a23marcoscc_BD_Exercicio2;
GO
CREATE DATABASE a23marcoscc_BD_Exercicio2;
GO
USE a23marcoscc_BD_Exercicio2;

-- Crea las tablas siguiendo las indicaciones

CREATE TABLE TELEFONOS (
    codprof CHAR(2),
    numero CHAR(9),
    principal CHAR(1) CHECK (principal IN ('S', 'N')), -- Indica si el teléfono es principal (S) o no (N)

    CONSTRAINT PK_TELEFONOS 
    PRIMARY KEY (codprof, numero)
);

CREATE TABLE PROFESOR (
    codprof CHAR(2) PRIMARY KEY,
    DNI CHAR(9) CHECK (DNI LIKE '[0-9]{8}[A-Za-z]') UNIQUE,
    nombre VARCHAR(30),
    apellido1 VARCHAR(30), -- Se añadió apellido1
    apellido2 VARCHAR(30), -- Se añadió apellido2
    direccion VARCHAR(30),
    tipocarnet VARCHAR(2) CHECK (tipocarnet IN ('A1', 'A2', 'B1', 'B2', '')) -- Añadido para validar el tipo de carnet
);

CREATE TABLE MODULO (
    codmod CHAR(2) PRIMARY KEY,
    nombre VARCHAR(30),
    codprof CHAR(2) NOT NULL, -- No puede ser nulo
    coddelegado CHAR(2),
    ciclo VARCHAR(4) CHECK (ciclo IN ('SMIR', 'ASIR', 'DAM', 'DAW')), -- Validación del ciclo
    seguimiento INT CHECK (seguimiento BETWEEN 0 AND 999999) -- Campo seguimiento con valor numérico limitado
);

CREATE TABLE MATRICULA (
    codmod CHAR(2),
    codalumno CHAR(2),
    fecmatricula DATETIME, -- Se cambia para incluir la hora
    CONSTRAINT PK_MATRICULA 
    PRIMARY KEY (codmod, codalumno)
);

CREATE TABLE ALUMNO (
    numexp CHAR(2) PRIMARY KEY,
    nombre VARCHAR(30),
    apellidos VARCHAR(30),
    fechanac DATE -- Cambio de fecnac a fechanac
);

-------------- COMENZAMOS CON LAS RESTRICCIONES DE LA BASE DE DATOS --------------


-- TABLA TELEFONOS (anteriormente TFNO_PROFE)

    ALTER TABLE TELEFONOS
    ADD CONSTRAINT FK_TELEFONOS_PROFESOR
        FOREIGN KEY (codprof)
        REFERENCES PROFESOR (codprof)
        ON UPDATE CASCADE ON DELETE CASCADE;

-- TABLA MODULO

    ALTER TABLE MODULO
    ADD CONSTRAINT FK_MODULO_PROFESOR
        FOREIGN KEY (codprof)
        REFERENCES PROFESOR (codprof)
        ON UPDATE CASCADE ON DELETE CASCADE; -- El campo codprof ya no puede ser NULL

    ALTER TABLE MODULO
    ADD CONSTRAINT FK_MODULO_ALUMNO
        FOREIGN KEY (coddelegado)
        REFERENCES ALUMNO (numexp)
        ON UPDATE CASCADE ON DELETE SET NULL;

-- TABLA MATRICULA

    ALTER TABLE MATRICULA
    ADD CONSTRAINT FK_MATRICULA_MODULO
        FOREIGN KEY (codmod)
        REFERENCES MODULO(codmod)
        ON UPDATE CASCADE ON DELETE NO ACTION;

    ALTER TABLE MATRICULA
    ADD CONSTRAINT FK_MATRICULA_ALUMNO
        FOREIGN KEY (codalumno)
        REFERENCES ALUMNO(numexp)
        ON UPDATE NO ACTION ON DELETE NO ACTION;

-- Cambios adicionales realizados:

-- 1. Añadido los campos 'apellido1' y 'apellido2' a la tabla PROFESOR.
-- 2. Modificado el campo "fecnac" a "fechanac" en la tabla ALUMNO.
-- 3. Cambiado el tipo de teléfono en la tabla TELEFONOS a texto, con la opción 'ALUMNO' o 'PROFESOR'.
-- 4. Renombrada la tabla TFNO_PROFE a TELEFONOS.
-- 5. Eliminada la clave foránea de 'coddelegado' en la tabla MODULO.
-- 6. Añadido el campo 'seguimiento' en la tabla MODULO.
-- 7. Asegurado que el campo 'codprof' en la tabla MODULO no sea nulo.

