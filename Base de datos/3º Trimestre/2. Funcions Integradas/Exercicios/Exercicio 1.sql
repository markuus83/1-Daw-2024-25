
-- Proposta 1 -> Desexamos coñecer o código ASCII da vogal E. Na consulta deberás devolver nunha columna a vogal en maiúscula,
--e nunha segunda o código ASCII que lle corresponde.

	SELECT 'E' AS VOGAL, ASCII('E') AS CODIGO_ASCII


-- Proposta 2 -> Consulta que devolve o carácter que lle corresponde aos seguintes códigos ASCII: 70, 80, 90

	SELECT '70' AS vogal1, NCHAR('70') AS codAscii
	SELECT '80' AS vogal1, NCHAR('80') AS codAscii
	SELECT '90' AS vogal1, NCHAR('90') AS codAscii


-- Proposta 3 -> Queremos obter unha listaxe que en cada liña teña o seguinte texto:
--O empregado con nome e apelidos X ten que acadar unha cota de vendas anual de Y.
--Sendo X o nome e os apelidos do empregado, e Y a cota de vendas. É importante fixarse no segundo apelido.
--A listaxe terá por título Empregados e cotas.

	USE a23marcoscc_BD_EMPRESA

	SELECT CONCAT(	'O empregado con nome e apelidos: ', nome+' '+ape1+ ' '+ISNULL(ape2,''),
					' ten que acadar unha cota de vendas anual de ',cota_de_vendas ) as 'Empregados e cotas'
	FROM EMPREGADO 


-- Proposta 4 -> Consulta que devolva as datas nas que se contrataron empregados. 
--O formato das diferentes datas será dd-mm-aaaa e o nome da columna Datas de contratación.

	select * 
	from empregado

	SELECT CONVERT(date,data_contrato,103) as dataColumna
	FROM EMPREGADO


-- Proposta 5 -> Queremos obter un nome abreviado das sucursais.
--Ese nome comporase polos tres primeiros caracteres da cidade, 
--os dous últimos da rexión e separado por un guión baixo, o número de caracteres do nome da cidade.


	


-- Proposta 6 -> Queremos obter un nome abreviado dos produtos.
--Ese nome comporase polo segundo carácter do código do fabricante en minúscula, máis o terceiro, 
--cuarto, quinto e sexto da descrición do produto. Nunha primeira columna o código aparecerá en minúsculas,
--e nunha segunda en maiúsculas


	


-- Proposta 7 -> Listaxe cos nomes dos empregados co formato ape1 ape2, nome. 
--Se algún empregado non ten segundo apelido, por exemplo Susanne Smith, no resultado aparecerá Smith,
--Sussane, sen espazos antes da coma.

	



-- Proposta 8 -> Queremos amosar os distintos títulos dos nosos empregados en castelán,
--e para iso deberemos substituír a palabra VENDAS por VENTAS


	


-- Proposta 9 -> Consulta que devolva a seguinte información de tempo en distintas columnas co nome adecuado cada unha:
	--	data e hora actuais sen axuste de zona horaria,
	--	data e hora actuais con axuste de zona horaria,
	--	mes actual en número,
	--	mes actual en número (emprega unha función diferente á da anterior columna),
	--	ano actual,
	--	mes actual en nome,
	--	hora actual,
	--	nanosegundos actuais.





-- Proposta 10 -> Listaxe que devolva o nome de todos os empregados (nome, ape1, ape2), a data de contrato,
--e nunha última columna a data de contrato adiantada un ano. 
--O formato das dúas datas será dd/mm/aaaa (con barras).




-- Proposta 11 -> Listaxe que devolva o número de cada pedido coa data de pedido. 
--Nunha terceira columna deberá aparecer a mesma data de pedido pero retrasada dous meses. 
--O formato das dúas datas será dd-mm-aaaa (con guións).




-- Proposta 12 -> Listaxe que devolva o nome e apelidos (nome, ape1, ape2) de cada empregado, 
--a data de contrato e o número de anos que hai que leva traballando na empresa cada un deles




-- Proposta 13 -> Consulta que devolva a descrición de cada produto co seu prezo nunha segunda columna, e ademais deberán amosarse en columnas diferentes: 
	--	o prezo como un enteiro aproximado por defecto, 
	--	o prezo como un enteiro aproximado por exceso, 
	--	a raíz cadrada do prezo,
	--	o cadrado do prezo, e, 
	--	o cubo do prezo.





-- Proposta 14 -> Repite a consulta anterior pero agora só amosaremos a descrición, 
--o prezo e a raíz cadrada, pero a raíz cadrada deberá amosarse con como moito 4 cifras 
--na parte enteira e 3 na decimal.




-- Proposta 15 -> Consulta que devolva a seguinte información do servidor no que está a nosa instancia de SQL Server:
-- idioma, número máximo de conexións permitidas, nome do servidor e da instancia e versión do xestor.





-- Proposta 16 -> Consulta que amose a descrición do produto e as súas existencias. Nunha terceira columna de nome estado_existencias amosarase o seguinte:
	--	Se o número de existencias é superior a 20 aparecerá a palabra Suficientes.
	--	Se o número de existencias é menor ou igual a 20 aparecerá Insuficientes

-- Esta consulta deberás resolvela de dous xeitos posibles, en dúas consultas diferentes, 
--empregando dúas funcións lóxicas distintas.