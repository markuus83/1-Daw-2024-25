USE a23MarcosCC_MazaricosBD;


-- APLICACIONES
SELECT * FROM APLICACION;
------------------------

INSERT INTO APLICACION (Cod_Aplic, Nome_Aplic, CIF)
VALUES (1,'Fortnite',11);

INSERT INTO APLICACION (Cod_Aplic, Nome_Aplic, CIF)
VALUES (2,'Valorant',22);

INSERT INTO APLICACION (Cod_Aplic, Nome_Aplic, CIF)
VALUES (3,'Hollow Knigh',33);

INSERT INTO APLICACION (Cod_Aplic, Nome_Aplic, CIF)
VALUES (4,'Dead Cells',44);

INSERT INTO APLICACION (Cod_Aplic, Nome_Aplic, CIF)
VALUES (5,'Super Mario Galaxy 2',55);


-- CATEGORIA
SELECT * FROM CATEGORIA;
------------------------

INSERT INTO CATEGORIA (Cod_Cat, Nome_Cat, Soldo, Desconto, Prezo_H_Extr)
VALUES (1,'Categoría 1', 1000, 0.20, 100);

INSERT INTO CATEGORIA (Cod_Cat, Nome_Cat, Soldo, Desconto, Prezo_H_Extr)
VALUES (2,'Categoría 2', 2000, 0.21, 200);

INSERT INTO CATEGORIA (Cod_Cat, Nome_Cat, Soldo, Desconto, Prezo_H_Extr)
VALUES (3,'Categoría 3', 3000, 0.22, 300);

INSERT INTO CATEGORIA (Cod_Cat, Nome_Cat, Soldo, Desconto, Prezo_H_Extr)
VALUES (4,'Categoría 4', 4000, 0.23, 400);

INSERT INTO CATEGORIA (Cod_Cat, Nome_Cat, Soldo, Desconto, Prezo_H_Extr)
VALUES (5,'Categoría 5', 5000, 0.24, 500);


-- CLIENTE
SELECT * FROM CLIENTE;
------------------------

INSERT INTO CLIENTE (CIF, Nome_Cli, Enderezo, Telefono)
VALUES (11,'Cliente 1', 'Enderezo 1', '111111111');

INSERT INTO CLIENTE (CIF, Nome_Cli, Telefono)
VALUES (22,'Cliente 2', '222222222');

INSERT INTO CLIENTE (CIF, Nome_Cli, Enderezo)
VALUES (33,'Cliente 3', 'Enderezo 3');

INSERT INTO CLIENTE (CIF, Nome_Cli, Enderezo, Telefono)
VALUES (44,'Cliente 4', 'Enderezo 4', '444444444');

INSERT INTO CLIENTE (CIF, Nome_Cli)
VALUES (55,'Cliente 5');


-- DEPARTAMENTO 
SELECT * FROM DEPARTAMENTO;
------------------------

INSERT INTO DEPARTAMENTO (Cod_Dept, Nome_Dept)
VALUES (1, 'Departamento 1')

INSERT INTO DEPARTAMENTO (Cod_Dept, Nome_Dept)
VALUES (2, 'Departamento 2')

INSERT INTO DEPARTAMENTO (Cod_Dept, Nome_Dept)
VALUES (3, 'Departamento 3')

INSERT INTO DEPARTAMENTO (Cod_Dept, Nome_Dept)
VALUES (4, 'Departamento 4')

INSERT INTO DEPARTAMENTO (Cod_Dept, Nome_Dept)
VALUES (5, 'Departamento 5')


-- EMPREGADO
SELECT * FROM EMPREGADO;
------------------------

INSERT INTO EMPREGADO (DNI, NSS, Nome_Empreg, Enderezo, Telefono, Horas_Extr, Cod_Dept, Cod_Cat)
VALUES('111111111', '11111111111', 'Nome 1', 'Enderezo 1', '111111111' , 300, 1, 1);

INSERT INTO EMPREGADO (DNI, NSS, Nome_Empreg, Horas_Extr, Cod_Dept, Cod_Cat)
VALUES('222222222', '22222222222','Nome 2', 200, 2, 2);

INSERT INTO EMPREGADO (DNI, NSS, Nome_Empreg, Cod_Dept, Cod_Cat)
VALUES('333333333', '33333333333', 'Nome 3', 3, 3);


-- PROXECTO
SELECT * FROM PROXECTO;
------------------------

INSERT INTO PROXECTO(Cod_Proxec, Cod_Aplic, Nome_Proxect, Horas_estimadas, Horas_Reais)
VALUES (1, 1, 'Proxecto 1', 100, 110);

INSERT INTO PROXECTO(Cod_Proxec, Cod_Aplic, Nome_Proxect, Horas_estimadas)
VALUES (2, 2, 'Proxecto 2', 200);

INSERT INTO PROXECTO(Cod_Proxec, Cod_Aplic, Nome_Proxect, Horas_estimadas)
VALUES (3, 3, 'Proxecto 3', 330);


-- TRABALLA
SELECT * FROM TRABALLA;
------------------------

INSERT INTO TRABALLA(Cod_Aplic,Cod_Proxec,DNI)
VALUES(1, 1, 111111111);

INSERT INTO TRABALLA(Cod_Aplic,Cod_Proxec,DNI)
VALUES(2, 2, 222222222);

INSERT INTO TRABALLA(Cod_Aplic,Cod_Proxec,DNI)
VALUES(3, 3, 333333333);


-- COMPROBACIÓN DE LOS DATOS DE FORMA GENERAL --


SELECT * FROM APLICACION;
SELECT * FROM CATEGORIA;
SELECT * FROM CLIENTE;
SELECT * FROM DEPARTAMENTO;
SELECT * FROM EMPREGADO;
SELECT * FROM PROXECTO;
SELECT * FROM TRABALLA;



select * from INFORMATION_SCHEMA.TABLES;

select * from INFORMATION_SCHEMA.TABLE_CONSTRAINTS;