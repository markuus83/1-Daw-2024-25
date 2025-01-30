-- Eliminar la base de datos si existe
DROP DATABASE IF EXISTS a23marcoscc_BDExercicio1;
GO

-- Crear la base de datos
CREATE DATABASE a23marcoscc_BDExercicio1;
GO

-- Usar la base de datos
USE a23marcoscc_BDExercicio1;
GO

-- Crear la tabla EMPLEADO
CREATE TABLE EMPLEADO (
    codemp INT IDENTITY(1, 1) PRIMARY KEY, -- IDENTITY comienza en 1 para evitar conflictos
    nombre VARCHAR(30) NOT NULL,
    apellido1 VARCHAR(30) NOT NULL,
    apellido2 VARCHAR(30) NOT NULL,
    direccion VARCHAR(30),
    provincia VARCHAR(30) DEFAULT('Pontevedra'),
    DNI CHAR(9) NOT NULL,
    coddepto INT, -- Eliminamos IDENTITY porque debe coincidir con la tabla DEPARTAMENTO
    salario SMALLMONEY DEFAULT(800),
    fecalta CHAR(10) CHECK (fecalta LIKE '[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]'),
    dto DECIMAL(4, 2), -- CHECK para asegurar valores válidos
    CONSTRAINT CK_DNI CHECK (DNI LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]'), -- Validación del DNI
);

-- Crear la tabla DEPARTAMENTO
CREATE TABLE DEPARTAMENTO (
    coddepto INT IDENTITY(1, 1) PRIMARY KEY,
    depto VARCHAR(30) NOT NULL,
    codjefe INT, -- Referencia a EMPLEADO (codemp)
    presupuesto SMALLMONEY DEFAULT(0),
    CONSTRAINT FK_DEPARTAMENTO_EMPLEADO FOREIGN KEY (codjefe) REFERENCES EMPLEADO(codemp) 
        ON UPDATE CASCADE ON DELETE SET NULL -- Si se elimina un empleado, el jefe queda como NULL
);

-- Crear la tabla HORAS_EXTRA
CREATE TABLE HORAS_EXTRA (
    codemp INT NOT NULL, -- Eliminamos IDENTITY porque hace referencia a EMPLEADO
    fecha DATE NOT NULL,
    num_horas TINYINT NOT NULL CHECK (num_horas > 0), -- Validación de número de horas
    CONSTRAINT PK_HORAS_EXTRA PRIMARY KEY (codemp, fecha), -- Clave primaria compuesta
    CONSTRAINT FK_HORAS_EXTRA_EMPLEADO FOREIGN KEY (codemp) REFERENCES EMPLEADO(codemp) 
        ON UPDATE CASCADE ON DELETE CASCADE -- Actualización y eliminación en cascada
);

-- Agregar la relación FOREIGN KEY de EMPLEADO -> DEPARTAMENTO
ALTER TABLE EMPLEADO
ADD CONSTRAINT FK_EMPLEADO_DEPARTAMENTO FOREIGN KEY (coddepto) REFERENCES DEPARTAMENTO(coddepto)
    ON UPDATE CASCADE ON DELETE SET NULL; -- Si se elimina un departamento, el empleado queda sin departamento
