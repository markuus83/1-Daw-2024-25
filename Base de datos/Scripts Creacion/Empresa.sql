DROP DATABASE IF EXISTS a23marcoscc_BD_EMPRESA;
GO
CREATE DATABASE a23marcoscc_BD_EMPRESA;
GO
USE a23marcoscc_BD_EMPRESA;
GO


CREATE TABLE dbo.EMPREGADO(
	numero int NOT NULL,
	nome varchar(30) NOT NULL,
	ape1 varchar(30) NOT NULL,
	ape2 varchar(30) NULL,
	data_nacemento date ,
	id_sucursal_traballa int NOT NULL,
	titulo varchar(10) NULL,
	data_contrato date NOT NULL,
	num_empregado_xefe int NULL,
	cota_de_vendas numeric(12,2) NULL,
 CONSTRAINT PK_EMPREGADO_numero PRIMARY KEY(numero)
);
GO

INSERT dbo.EMPREGADO (numero, nome, ape1, ape2, data_nacemento, id_sucursal_traballa, titulo, data_contrato, num_empregado_xefe, cota_de_vendas) 
VALUES (101,'DANIEL','GARCÍA','XIL', '01/01/1970', 12, 'RP VENDAS', '20/10/1986', 104, 300000),
	   (102,'SUSANNE','SMITH',NULL, '05/07/1965', 21, 'RP VENDAS', '12/12/1986', 108,35000),
	   (103,'PAULA', 'CRUZ', 'SOUTO', '16/10/1985', 12, 'RP VENDAS', '01/03/2014', 104, 275000),
	   (104,'MARCOS','CHANS', 'PÉREZ', '04/09/1980', 12, 'DIR VENDAS','6/6/2012', 106, 200000),
       (105,'ANTÍA', 'GONZÁLEZ', 'FERREIRA', '05/11/1978', 13, 'RP VENDAS', '19/05/2001', 104, 350000),
	   (106,'MARTÍN', 'DELGADO', 'MONTERO', '27/08/1980', 11, 'VP VENDAS', '10/10/2008', NULL, 275000),
	   (107,'ANA','MARTÍNEZ','IGLESIAS', '21/01/1960', 22, 'RP VENDAS', '26/02/1985', 108, 300000),
       (108,'LARA', 'GARCÍA', 'PAZOS', '07/12/1955', 21, 'DIR VENDAS', '06/05/1973', 106, 350000),
       (109,'MARÍA', 'SEARA', 'JANEIRO', '01/06/1983', 11, 'RP VENDAS', '01/09/2009', 106, 300000),
       (110,'CARLOS','GRIMM', NULL, '30/05/1973', 12, 'RP VENDAS', '01/01/1997', 101, NULL);
       
GO

CREATE TABLE dbo.SUCURSAL(
	identificador int NOT NULL,
	cidade varchar(15) NOT NULL,
	rexion varchar(10) NOT NULL,
	num_empregado_director int NULL,
	obxectivo numeric(12, 2) NULL,
 CONSTRAINT PK_SUCURSAL_identificador PRIMARY KEY (identificador));
GO

INSERT dbo.SUCURSAL (identificador, cidade, rexion, num_empregado_director, obxectivo)
VALUES (11, 'BARCELONA','LESTE', 106, 575000),
	   (12, 'VALENCIA', 'LESTE', 104, 800000),
       (13, 'MURCIA', 'LESTE', 105, 350000),
	   (21, 'A CORUÑA', 'OESTE', 108, 725000),
	   (22, 'VIGO', 'OESTE', 108, 300000);
GO

CREATE TABLE dbo.FABRICANTE(
	codigo char(3) NOT NULL,
	nome varchar(50) NOT NULL,
CONSTRAINT PK_FABRICANTE_codigo PRIMARY KEY (codigo)
);
INSERT INTO dbo.FABRICANTE (codigo, nome)
VALUES  ('LOG', 'LOGITECH'),
		('KIN', 'KINGSTON'),
		('SEA', 'SEAGATE'),
		('TOS', 'TOSHIBA'),
		('ASU', 'ASUS'),
		('SAM', 'SAMSUNG'),
		('WSD', 'WESTERN DIGITAL');
GO

CREATE TABLE dbo.PRODUTO(
	cod_fabricante char(3) NOT NULL,
	identificador char(5) NOT NULL,
	descricion varchar(150) NOT NULL,
	prezo numeric(7,2) NOT NULL,
	existencias smallint NOT NULL,
 CONSTRAINT PK_PRODUTO PRIMARY KEY (cod_fabricante, identificador)
);
GO

INSERT dbo.PRODUTO (cod_fabricante, identificador, descricion, prezo, existencias) 
VALUES	('LOG', '11002', 'mk270 combo teclado con rato óptico',  26 ,  5 ),
		('LOG', '11003', 'rato óptico logitech b100 negro',  9.9 ,  20 ),
		('LOG', '11004', 'HD Webcam C270',  30.90 ,  12 ),
		('LOG', '1100X', 'USB Headset H540',  59.90 ,  37 ),
		('LOG', '1100Y', '3D PRO Joystick',  51.90 ,  30 ),
		('LOG', '1100Z', 'Bluetooth Audio Adapter',  39.99 ,  7 ),
		('KIN', '11003', 'HD SSD 120GB 2.5 SATA3 v300',  54.80 ,  150 ),
		('KIN', '11089', 'DDR3 4GB PC1600 CL11 DIMM. SRX8',  36.80 ,  20 ),
		('KIN', '11672', 'DDR3 SO DIMM 4GB PC1333 CL9 SR',  39.60 ,  0 ),
		('SEA', '11200', 'HDD 1TB 7200rpm 64MB SATA3 6gbps',  52.80 ,  2 ),
		('SEA', '11400', 'HD 2.5 500GB 8MB 5400rpm SATA2',  46.40 ,  15 ),
		('TOS', '173C0', 'Pen Drive Daichi 32 GB 3.0 azul',  16.95 ,  28 ),
		('TOS', '175C0', 'Portátil Satellite Click 2 Pro 13,3'' P30W-B-108 Intel Core i5 4210U',  1099 ,  50 ),
		('TOS', '179C0', 'Disco Duro portátil Toshiba 2 TB USB 3.0',  109.90 ,  90 ),
		('TOS', '278HA', 'Rato Toshiba W30 Óptico sen fíos negro',  19.90,  22 ),
		('TOS', '287PA', 'Disco Duro interno Toshiba MQ Series 1TB 2,5'' SATA', 69.90 ,  24 ),
		('TOS', '287XA', 'Portátil 13,3'' Satellite Z30-A-1DG Intel Core i5 4210U',  999 ,  320 ),
		('ASU', 'AK47A', 'Portátil convertible 2 en 1 ASUS 10,1'' T100TA-DK048H Intel Quad Core Atom Bay Trail-T Z3775',  349 ,  10 ),
		('ASU', 'AK48A', 'Tablet 8'' ME581C-1B007A Wi-Fi 16 GB',  249 ,  11 ),
		('ASU', 'XK48A', 'Tarxeta gráfica SVGA Asus NVIDIA GeForce 210 Silent DI/1GD3/V2(LP)',  34.90 ,  20),
		('SAM', '9A44G', 'Tarxeta de memoria SD PRO Clase 10 UHS-I de 16 GB',  26.50 ,  140),
		('SAM', '9A44L', 'Multifunción Láser Xpress C460W Wi-Fi',  299.99 ,  120 ),
		('SAM', '9A44R', 'Cable USB a micro USB',  11.99 ,  120 ),
		('SAM', '9A45C', 'Funda Book Cover para Samsung Galaxy Tab S 8,4'' marrón',  59.90 ,  30 );
GO

CREATE TABLE dbo.PEDIDO(
	numero int NOT NULL,
	data_pedido datetime NOT NULL,
	num_cliente int NOT NULL,
	num_empregado int NOT NULL,
	cod_fabricante char(3) NOT NULL,
	id_produto char(5) NOT NULL,
	cantidade int NOT NULL
 CONSTRAINT PK_PEDIDO_numero PRIMARY KEY CLUSTERED(numero));
GO
INSERT dbo.PEDIDO (numero, data_pedido, num_cliente, num_empregado, cod_fabricante, id_produto, cantidade) 
VALUES  (10000, '01/01/2014 12:30:00', 1107, 110, 'LOG', '1100Z', 9),
		(10100, '11/01/2014 17:08:00', 1117, 106, 'SAM', '9A44L', 7),
		(10200, '24/02/2014 13:05:00', 1103, 105, 'LOG', '11004', 28),
		(10300, '24/02/2014 19:24:00', 1102, 101, 'LOG', '11004', 34),
		(10400, '02/03/2014 10:16:00', 1111, 103, 'SAM', '9A44G', 6),
		(10500, '15/03/2014 11:00:00', 1114, 102, 'LOG', '1100Z', 6),
		(10600, '29/03/2014 08:45:00', 1103, 105, 'LOG', '11004', 6),
		(10700, '04/04/2014 18:25:00', 1103, 105, 'LOG', '1100Y', 11),
		(10800, '14/04/2014 09:35:00', 1101, 106, 'SEA', '11400', 6),
		(10900, '24/04/2014 08:45:00', 1118, 108, 'LOG', '11002', 10),
		(11000, '04/05/2014 11:20:00', 1106, 102, 'SAM', '9A45C', 24),
		(11100, '04/05/2014 18:25:00', 1108, 109, 'TOS', '179C0', 3),
		(11200, '04/05/2014 20:02:00', 1112, 108, 'TOS', '173C0', 3),
		(11300, '02/06/2014 10:17:00', 1111, 105, 'LOG', '11003', 35),
		(11400, '02/06/2014 11:21:00', 1118, 108, 'KIN', '11003', 1),
		(11500, '02/06/2014 17:06:00', 1114, 108, 'ASU', 'AK47A', 20),
		(11600, '08/06/2014 13:30:00', 1103, 105, 'LOG', '11002', 54),
		(11700, '14/07/2014 08:55:00', 1107, 110, 'SAM', '9A45C', 8),
		(11800, '15/07/2014 15:20:00', 1113, 101, 'SAM', '9A44R', 5),
		(11900, '15/07/2014 18:01:00', 1112, 108, 'SAM', '9A44R', 10),
		(12000, '19/07/2014 10:15:00', 1120, 102, 'TOS', '179C0', 2),
		(12100, '04/08/2014 11:09:00', 1118, 108, 'ASU', 'AK47A', 6),
		(12200, '21/09/2014 16:31:00', 1118, 108, 'ASU', 'AK47A', 4),
		(12300, '12/10/2014 18:45:00', 1108, 101, 'LOG', '1100X', 6),
		(12400, '08/01/2015 09:11:00', 1111, 103, 'LOG', '1100X', 24),
		(12500, '21/01/2015 10:46:00', 1108, 109, 'SEA', '11200', 10),
		(12600, '21/01/2015 12:54:00', 1123, 102, 'SEA', '11400', 10),
		(12700, '01/02/2015 10:11:00', 1106, 102, 'ASU', 'AK47A', 6),
		(12800, '02/02/2015 11:20:00', 1123, 102, 'KIN', '11003', 1);
GO

CREATE TABLE dbo.CLIENTE(
	numero int NOT NULL,
	nome varchar(50) NOT NULL,
	num_empregado_asignado int NULL,
	limite_de_credito numeric(10, 2) NULL,
CONSTRAINT PK_CLIENTE_numero PRIMARY KEY(numero));
GO
INSERT dbo.CLIENTE (numero, nome, num_empregado_asignado, limite_de_credito) 
VALUES  (1101, 'PC CAIXA, SL', 106,  65000.50),
	    (1102, 'APPS INFOR, SL', 101,  65000.90),
		(1103, 'PC MAX', 105,  50000),
		(1105, 'INFORMÁTICA SANTI', 101,  45000),
		(1106, 'INFOR MAX', 102,  65000),
		(1107, 'O TEU PC', 110,  35000),
		(1108, 'PIP INFORMÁTICA', 109,  55000),
		(1109, 'ELECTRÓNICA RIAL', 103,  25000),
		(1111, 'PC OK', 103,  50000),
		(1112, 'HW & SW OK', 108,  50000),
		(1113, 'SENRA PC', 104,  20000),
		(1114, 'PeM INFORMÁTICA', 102,  20000),
		(1115, 'TODO PC', 101,  20000),
		(1117, 'TODO INFOR', 106,  35000),
		(1118, 'TODO HW', 108,  60000),
		(1119, 'O RATO TOLO REPARACIÓNS', 109,  25000),
		(1120, 'PC POR PEZAS, SL', 102,  50000),
		(1121, 'MERCA PC', 103,  45000),
		(1122, 'INFOR TENDA', 105,  30000),
		(1123, 'MERCADO PC', 102,  40000),
		(1124, 'INFOR REPARACIÓNS', NULL,  40000);
GO

/****** CLAVES FORÁNEAS ******/
ALTER TABLE dbo.EMPREGADO  
ADD  
	 CONSTRAINT FK_EMPREGADO_SUCURSAL_num_sucursal_traballa
	 FOREIGN KEY(id_sucursal_traballa)
	 REFERENCES dbo.SUCURSAL (identificador),
	 CONSTRAINT FK_EMPREGADO_EMPREGADO_num_empregado_xefe 
	 FOREIGN KEY(num_empregado_xefe)
	 REFERENCES dbo.EMPREGADO (numero);
GO

ALTER TABLE dbo.SUCURSAL  
ADD  CONSTRAINT FK_SUCURSAL_EMPREGADO 
	 FOREIGN KEY(num_empregado_director)
	 REFERENCES dbo.EMPREGADO (numero);
GO

ALTER TABLE dbo.PRODUTO
ADD CONSTRAINT FK_PRODUTO_FABRICANTE_cod_fabricante
	FOREIGN KEY (cod_fabricante)
	REFERENCES dbo.FABRICANTE(codigo);

ALTER TABLE dbo.PEDIDO  
ADD  CONSTRAINT FK_PEDIDO_CLIENTE_num_cliente 
	 FOREIGN KEY(num_cliente)
	 REFERENCES dbo.CLIENTE (numero),
	 CONSTRAINT FK_PEDIDO_PRODUTO FOREIGN KEY(cod_fabricante, id_produto)
	 REFERENCES dbo.PRODUTO (cod_fabricante, identificador),
	 CONSTRAINT FK_PEDIDO_EMPREGADO_num_empregado 
	 FOREIGN KEY(num_empregado)
	 REFERENCES dbo.EMPREGADO (numero),
	 CONSTRAINT FK_CLIENTE_VENDEDOR_num_empregado 
	 FOREIGN KEY(num_empregado)
	 REFERENCES dbo.EMPREGADO(numero);
GO

ALTER TABLE dbo.CLIENTE  
ADD  CONSTRAINT FK_CLIENTE_EMPREGADO_num_empregado_asignado
	 FOREIGN KEY(num_empregado_asignado)
	 REFERENCES dbo.EMPREGADO (numero);
GO




