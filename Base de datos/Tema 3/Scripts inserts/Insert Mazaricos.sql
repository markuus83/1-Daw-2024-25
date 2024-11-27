USE a23MarcosCC_MazaricosBD;

-- APLICACIONES
INSERT INTO APLICACION (Cod_Aplic, Nome_Aplic, CIF)
VALUES (1,'Fortnite',111111111);

INSERT INTO APLICACION (Cod_Aplic, Nome_Aplic, CIF)
VALUES (2,'Valorant',222222222);

INSERT INTO APLICACION (Cod_Aplic, Nome_Aplic, CIF)
VALUES (3,'Hollow Knigh',333333333);

INSERT INTO APLICACION (Cod_Aplic, Nome_Aplic, CIF)
VALUES (4,'Dead Cells',444444444);

INSERT INTO APLICACION (Cod_Aplic, Nome_Aplic, CIF)
VALUES (5,'Super Mario Galaxy 2',555555555);


-- CATEGORIA
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
INSERT INTO CLIENTE (CIF, Nome_Cli, Enderezo, Telefono)
VALUES (1,'Cliente 1', 'Enderezo 1', '111111111');

INSERT INTO CLIENTE (CIF, Nome_Cli, Telefono)
VALUES (2,'Cliente 2', '222222222');

INSERT INTO CLIENTE (CIF, Nome_Cli, Enderezo)
VALUES (3,'Cliente 3', 'Enderezo 3');

INSERT INTO CLIENTE (CIF, Nome_Cli, Enderezo, Telefono)
VALUES (4,'Cliente 4', 'Enderezo 4', '444444444');

INSERT INTO CLIENTE (CIF, Nome_Cli)
VALUES (5,'Cliente 5');


-- DEPARTAMENTO
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
INSERT INTO EMPREGADO (DNI, NSS, Nome_Empreg, Enderezo, Telefono, Horas_Extr, Cod_Dept, Cod_Cat)
VALUES();

INSERT INTO EMPREGADO (DNI, NSS, Nome_Empreg, Horas_Extr, Cod_Dept, Cod_Cat)
VALUES();

INSERT INTO EMPREGADO (DNI, NSS, Nome_Empreg, Cod_Dept, Cod_Cat)
VALUES();

INSERT INTO EMPREGADO (DNI, NSS, Nome_Empreg, Cod_Dept, Cod_Cat)
VALUES();
