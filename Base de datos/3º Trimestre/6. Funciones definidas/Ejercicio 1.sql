/*********************** EJERCICIOS FUNCIONES *********************************/
use a23marcoscc_BD_Almacen_Procedimientos;
/* 1- Crear una función que dada una fecha devuelva el nombre del mes en gallego

SET @mesNome = 
        CASE @mesNum
            WHEN 1 THEN 'xaneiro'
            WHEN 2 THEN 'febreiro'
            WHEN 3 THEN 'marzo'
            WHEN 4 THEN 'abril'
            WHEN 5 THEN 'maio'
            WHEN 6 THEN 'xuño'
            WHEN 7 THEN 'xullo'
            WHEN 8 THEN 'agosto'
            WHEN 9 THEN 'setembro'
            WHEN 10 THEN 'outubro'
            WHEN 11 THEN 'novembro'
            WHEN 12 THEN 'decembro'
        END;

    RETURN @mesNome;

*/

CREATE OR ALTER FUNCTION dbo.nomeMesGalego(@data AS DATE)
RETURNS VARCHAR(15)
	AS
		BEGIN
			DECLARE @mes VARCHAR(15);
			SET @mes = 
			CASE MONTH(@data)
				WHEN 1 THEN 'xaneiro'
				WHEN 2 THEN 'febreiro'
				WHEN 3 THEN 'marzo'
				WHEN 4 THEN 'abril'
				WHEN 5 THEN 'maio'
				WHEN 6 THEN 'xuño'
				WHEN 7 THEN 'xullo'
				WHEN 8 THEN 'agosto'
				WHEN 9 THEN 'setembro'
				WHEN 10 THEN 'outubro'
				WHEN 11 THEN 'novembro'
				WHEN 12 THEN 'decembro'
			END;
			RETURN @mes
		END
GO

SELECT dbo.nomeMesGalego(GETDATE()) AS nomeMesGalego;

/* 2- Crear una funci?n que dada una fecha devuelva el d?a de las semana en gallego */

CREATE OR ALTER FUNCTION dbo.nomeSemanaGalego(@data AS DATE)
RETURNS VARCHAR(15)
	AS
		BEGIN

			DECLARE @mes VARCHAR(15); 
			SET @mes = 
				case DATENAME(WEEKDAY, @data)
				when 'Lunes' THEN 'Luns'
				when 'Martes' THEN 'Martes'
				when 'Miércoles' THEN 'Mércores'
				when 'Jueves' THEN 'Xoves'
				when 'Viernes' THEN 'Venres'
				when 'Sábado' THEN 'Sábado'
				when 'Domingo' THEN 'Domingo'
			END;
			RETURN @mes 
		END
GO

SELECT dbo.nomeSemanaGalego(GETDATE()) AS nomeMesGalego;

/* 3- Crear una funci?n que utilizando las definidas en los ejercicios anteriores devuelva la fecha formateada
-- en el cuerpo de la funci?n se analiza si el dato enviado corresponde a una fecha, 
-- si es as?, se devuelve la fecha con el formato Martes, 11 de Maio de 2021; en caso que el valor enviado no corresponda a una fecha,
-- la funci?n retorna la cadena 'Fecha inv?lida'. */



/* 4- Crear una funci?n que devuelva las notas en texto seg?n la siguiente tabla 
	>= 0 < 5	Suspenso
	>= 5 < 6	Aprobado
	>= 6 < 7	Bien
	>= 7 < 9	Notable
	>= 9 <= 10	Sobresaliente
	Cualquier otro valor mostrar mensaje de Nota no v?lida
*/

CREATE OR ALTER FUNCTION dbo.nomeNotas(@nota AS INT)
RETURNS VARCHAR(15)
	AS
	BEGIN
		DECLARE @notaTexto VARCHAR(15)
		SET @notaTexto = 
				case 
				when @nota >= 0 AND @nota < 5 THEN 'suspenso'
				when @nota >= 5 AND @nota<7 THEN 'Bien'
				when @nota >= 7 AND @nota<9 THEN 'Notable'
				when @nota >= 9 AND @nota<=10 THEN 'Sobresaliente'
				else 'Nota inválida'
			END;
			RETURN @notaTexto;
	END
GO

SELECT dbo.nomeNotas(-1) as nota
SELECT dbo.nomeNotas(3) as nota
SELECT dbo.nomeNotas(6) as nota
SELECT dbo.nomeNotas(8) as nota
SELECT dbo.nomeNotas(10) as nota

/* 5- Crear una funci?n que pas?ndole como par?metro las 8 cifras de un DNI, devuelva la letra que le corresponde seg?n el siguiente algoritmo */
	/*  algoritmo - m?dulo 23  
	Este algoritmo permite devolver la letra do DNI, consiste en dividir el n?mero correspondiente al DNI entre 23 y
	obtener el resto de la divisi?n entera. 
	El resultado ser?  un n?mero comprendido entre 0 y 22. 
	Cada un de estos n?meros se corresponde con una letra teniendo en cuenta la siguiente tabla:
		0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	21	22
		T	R	W	A	G	M	Y	F	P	D	X	B	N	J	Z	S	Q	V	H	L	C	K	E
	No se utilizan as letras: I, ?, O, e U. Se descartan para evitar confusiones.
	PISTA: Podeis utilizar la funci?n integrada substring
*/

/* 6- Para la base de datos almacen, crear una funci?n que devuelva un 1 si existe un departamento que
se le pasa como par?metro y un 0 sino.  */

SELECT Nombre FROM DEPARTAMENTOS

CREATE OR ALTER FUNCTION dbo.existeDepartamento(@departamento AS VARCHAR(15))
RETURNS INT
	AS
		BEGIN
			DECLARE @existe INT;
			IF EXISTS (SELECT 1 FROM DEPARTAMENTOS WHERE Nombre = @departamento)
				BEGIN
					SET @existe = 1;
				END;
			ELSE 
				BEGIN
					SET @existe = 0;
				END;
			RETURN @existe
		END
GO

SELECT 'CONTABILIDAD' as NomeDepartamento, dbo.existeDepartamento('CONTABILIDAD') AS EXISTE;


/* 7- Para la tabla de empleados, crear una funci?n que devuelva la suma total de los salarios del departamento
que se le pasa como par?metro. Utiliza la funci?n definida en el ejercicio anterior. */

SELECT * FROM DEPARTAMENTOS
SELECT * FROM EMPLEADOS;

CREATE OR ALTER FUNCTION dbo.sumaSalarios(@departamento AS VARCHAR(30))
RETURNS varchar(30)
	AS
	BEGIN
		
		DECLARE @resultado varchar(30);

		if dbo.existeDepartamento(@departamento) = 1
		BEGIN
			SET @resultado = (SELECT SUM(E.Salario)
			FROM EMPLEADOS E JOIN DEPARTAMENTOS D 
			ON E.IDDepartamento = D.IDDepartamento
			WHERE D.Nombre = @departamento)
		END
		ELSE
			SET @resultado = 'Non existe';
		RETURN @resultado 
		
	END;
GO

SELECT 'CONTABILIDAD' as NomeDepartamento, dbo.sumaSalarios('CONTABILIDAD') AS sumaSalario;
SELECT 'COMERCIAL' as NomeDepartamento, dbo.sumaSalarios('COMERCIAL') AS sumaSalario;
SELECT 'X' as NomeDepartamento, dbo.sumaSalarios('X') AS sumaSalario;


/* 8 - Crea una funci?n que dado un id de producto, devuelva los datos de pedido de un producto detallando 
su descripci?n, precio, unidades y total */

exec sp_help PRODUCTOS
select * from PRODUCTOS
select * from PEDIDOS

CREATE OR ALTER FUNCTION dbo.datosPedido(@id INT)
RETURNS TABLE
	AS
	RETURN
	(SELECT	pr.Descripcion, pr.PrecioActual, pe.UNIDADES
	FROM PEDIDOS pe JOIN PRODUCTOS pr
	ON pr.IDProducto = pe.IDProducto
	where pr.IDProducto = @id
	);
GO
SELECT '10' as ID_Departamento, dbo.datosPedido(10)


/* 9- Crear una funci?n de login que devuelva 1 si un usuario est? registrado y su contrase?a es correcta 
	y 0 si la contrase?a es incorrecta.
	Crea primero las tablas y a?ade datos de ejemplo
	La tabla usuarios tendr?: login, password y fechaAcceso con lafecha y hora del ?ltimo acceso correcto; */

/* 10- Modifica la funci?n anterior para que devuelva 2 si el usuario no est? registrado  */

/* 11- Crear un procedimiento que dado un usuario actualice la fecha de ?ltimo acceso 
	 con la fecha del momento en la tabla usuarios del ejercicio anterior */

/* 12- Crear un prodedimiento almacenado que llame a la funci?n de login y si el acceso es err?neo
    que almacene los accesos erroneos en la tabla de fallos_acceso: 
	- En la tabla fallos_acceso se registran los intentos de acceso fallidos, tendr? al menos 
         id(C?digo autoincremental), login , password,	fechaIntento

	- El procedimiento tiene que comprobar que en el caso de que el usuario haga m?s de 5 intentos fallidos 
	en los ?ltimos 10 minutos, se le bloquea la cuenta cambiandole la contrase?a por una distinta (inventatela).

 */