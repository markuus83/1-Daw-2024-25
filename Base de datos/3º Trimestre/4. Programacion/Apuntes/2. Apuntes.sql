--*******************************
-- DECLARACI?N y USO DE VARIABLES
--*******************************
-- Para utilizar variables con Transact-SQL primero tenemos que declararlas.
-- Las variables se declaran con la instrucci?n DECLARE, su nombre  debe empezar siempre por @
-- y se les asignan valores con una instrucci?n SET o SELECT. 
-- Despu?s de la declaraci?n, todas las variables se inicializan como NULL, a menos que se proporcione un valor como
-- parte de la declaraci?n. El alcance de una variable local es el lote en el que est? declarada.





			Declare @nombre varchar (50) 

	 -- declare declara una variable,  @nombre es el identificador(nombre), y la variable es de tipo varchar. 

			Set @nombre ='www.devjoker.com' /*Es lo mismo que:  */ Select @nombre ='www.devjoker.com'

	-- El signo = es un operador -- 'www.devjoker.com' es un literal

			Print @Nombre

	-- Imprime por pantalla el valor de @nombre.-- No diferencia may?sculas ni min?sculas


--EnTransact SQL podemos asignar valores a una variable de varias formas:

		-- A trav?s de la instrucci?n  SET
		-
		-- Utilizando una sentencia SELECT


--El siguiente ejemplo muestra como asignar una variable utilizando la instrucci?n SET.
-- Con set hay que poner uno para cada variable, con SELECT llega uno para todas.

					declare @a int, @b char(20), @c date
						set @a =5
				    	set @b =(SELECT nomem FROM TEMPLE WHERE NUMEM=110)
						set @c = '25-04-2014'
					print @a
					print @b
					print @c



					declare @a int, @b char(1), @c date
					select @a =5, @b ='c', @c = '25-04-2014'
					print @a
					print @b
					print @c




		DECLARE @nombre VARCHAR (100)		 -- La consulta debe devolver un ?nico registro

		SET @nombre= (SELECT nomem FROM TEMPLE WHERE NUMEM=110)

		PRINT @nombre



--El siguiente ejemplo muestra como asignar variables utilizando una sentencia SELECT


		DECLARE  @nombre VARCHAR (100),
				 @salario decimal ,
				 @comis decimal 
			
		SELECT
				@nombre=nomem, 
				@salario=salar,
				@comis=comis
		FROM temple
			    WHERE NUMEM =120
		    
		PRINT @nombre
		PRINT @salario
		PRINT @comis






-- Con excepcion de las variables tabla, todas contiene un unico valor.
-- Si le asignamos valor con una SELECT y esta tiene mas de una fila, 
-- solo guardara el resultado de la ultima fila.


	DECLARE		 @nombre VARCHAR (100),
				 @salario decimal ,
				 @comis decimal 
			
		SELECT
				@nombre=nomem, 
				@salario=salar,
				@comis=comis
		FROM temple
			   --- WHERE NUMEM =120
		    
		PRINT @nombre
		PRINT @salario
		PRINT @comis

select * from TEMPLE




-- Tambien se puede asignar un valor a la variable en el momento de la creaccion
--(inicializacion de la variable)


		Declare @intvariable int =2,
				@datevariable date = getdate(),
				@maxedaddate date = (select MAX(FECIN) from TEMPLE),
				@counter1 int,
				@counter2 int

		set @counter1= 1
		select @counter2 = 2
	
		
		print	@intvariable 
		print	@datevariable 
		print	@maxedaddate 
		print	@counter1 
		print	@counter2 


	--Operaciones con variables 
	
		
		declare @var int
		
		SET @var = 1
		PRINT @var
		
		SET @var = @var+1
		SET @var +=1
		PRINT @var

		SET @var = @var*2
		SET @var *=2
		PRINT @var
		
		SET @var = @var/4
		SET @var /=4
		PRINT @var

-- Estas mismas instrucciones son validas con SELECT




--*******************************
-- IMPRIMIR MENSAXES*************
--*******************************

--La sentencia PRINT que vimos en los ejemplos nos permite  mostrar un texto en pantalla.

 --Para imprimir mensaxes se hace con PRINT 'mensaje' o  PRINT ('mensaje') Si queremos imprimir unha variable ser?a PRINT @variable ou ben PRINT (@variable)

 --Si la variable que queremos imprimir es de tipo num?rico o moneda tendriamos que poner PRINT CONVERT(varchar(10), @variable) ou  un PRINT CAST(@variable as varchar(10))

--Si queremos concatenar cadeas de texto empregaremos o simbolo +

Exemplo:

	DECLARE @variable1 as char(10)= 'PRUEBA'
	DECLARE @variable2 as int= 25

	--PRINT 'mensaxe 1  ' + @variable1 + 'mensaxe2' 
	--PRINT 'mensaxe 1  ' + @variable2 + 'mensaxe2' --Error


	PRINT 'mensaxe 1  ' + @variable1 + 'mensaxe2'
	PRINT 'mensaxe 1  ' + CONVERT(char(10), @variable2) + 'mensaxe2'	--Probar char y varchar


--	VARIABLES GLOBLES

--Existen en SQL Server unha serie de variables predeclaradas que almacenan distinta informaci?n. Se distinguen de las variables locales por empezar por @@.
--Algunas destas variables globales son:

						--@@CONNECTIONS: N?mero de conexi?ns ou intentos desde a ?ltima vez que se inicio.

						--@@TRANCOUNT: N?mero de transacci?ns activas na conexi?n actual.

						--@@SERVERNAME: Devolve o nome do servidor SQL Server

						--@@IDENTITY: Devolve o ?ltimo valor de identidade inserido.

-- Exemplo:

print @@Connections
print @@Trancount
print @@servername


				    	PRINT 'El ?LTIMO IDE XERADO es:' + CAST(@@IDENTITY AS VARCHAR(20))

--NOTA: los valores que se imprimen son valores alfanum?ricos


				create table a(b int identity,nom char(5))
				drop table a

				insert into a (nom) values ('Ana') 

				select * from a



-- PARAMETROS
-- Son variables locales que se utilizan para traspasar valores a un procedimiento 
-- almacenado en el momento de su ejecucion . Durante la ejecucion todos los 
-- parametros se utilizan como si fueran variables y pueden leerse y escribirse.



-- ****************************************************************************************
-- ******************************Estructuras de control en Transact SQL********************
-- ****************************************************************************************



-- Estructura condicional IF
-- La estructura condicional IF permite evaluar una expresi?n booleana (resultado SI - NO), 
-- y ejecutar las operaciones contenidas en el bloque formado por BEGIN-END.
-- En caso de no poner Begin-End, If solo ejecutar? condicionalmente la instrucion siguiente, pero una sola.
-- Para evitar esto usamos el bloque Begin-End.


				IF
					(<expresion>)
					BEGIN...
				 
					END
				 
				ELSE IF
					(<expresion>)
					BEGIN...
				 
					END
				 
				ELSE
				 
					BEGIN...
				 
					END
 
-- Ejemplo de la estructura condicional IF

				DECLARE @Web varchar(100),
						@diminutivo varchar(3)
						
				SET @diminutivo ='DJK' 
				
				IF @diminutivo ='DJK' 
				
					BEGIN
		 				PRINT 'www.devjoker.com' 
					END
				 
				ELSE
				 
					BEGIN
		 				PRINT'Otra Web (peor!)' 
					END
			
 
--La estructura IF admite el uso de consultas:


				DECLARE @numem int,
						@descripcion varchar(255) 
						
				set @numem =110
				set @descripcion ='Mu?oz, Pepe'
				 
				IF
				 EXISTS
					(SELECT * FROM TEMPLE WHERE NUMEM = @numem)
					
					BEGIN
						UPDATE TEMPLE SET NOMEM = @descripcion 
						WHERE NUMEM = @numem
					END
				 
				ELSE
				 
					BEGIN 
						INSERT INTO TEMPLE (NUMEM, NOMEM)
						VALUES(@numem, @descripcion)
					END
		 
				select * from temple
 
 
 
 
 
 
--Estructura condicional CASE

--La estructura condicional CASE permite evaluar una expresi?n y devolver un valor u otro.
--La sintaxis general de case es:

		CASE <expresion>

			WHEN <valor_expresion> THEN <valor_devuelto>

			WHEN <valor_expresion> THEN <valor_devuelto>

		ELSE <valor_devuelto>    -- Valor por defecto 
		END
 
--Ejemplo de CASE:


		DECLARE @Web varchar(100),
				@diminutivo varchar(3)
				
		SET @diminutivo ='POP'
		
		SET @Web = (
			CASE @diminutivo
				WHEN 'DJK' THEN 'www.devjoker.com' 
				WHEN 'ALM' THEN 'www.aleamedia.com' 
			ELSE'www.devjoker.com' 
		END)
		
		PRINT @Web
		
		
-- Otra sintaxis de CASE nos permite evaluar diferentes expresiones:


		CASE
		 
			 WHEN <expresion> = <valor_expresion> THEN <valor_devuelto>
			 WHEN <expresion> = <valor_expresion> THEN <valor_devuelto>
		ELSE
			<valor_devuelto>	-- Valor por defecto
		END
 
--El mismo ejemplo aplicando esta sintaxis:
		DECLARE @Web varchar(100),
				@diminutivo varchar(3)
				
		SET @diminutivo ='ALM'
		
		SET @Web = (
			CASE
		 		 WHEN @diminutivo ='DJK' THEN 'www.devjoker.com' 
				 WHEN @diminutivo ='ALM' THEN'www.aleamedia.com' 
			ELSE 'www.devjoker.com' 
			END)
		PRINT @Web







-- Otro aspecto muy interesante de CASE es que permite el uso de consultas.
 
		DECLARE @Web varchar(100),
				@diminutivo varchar(3)
				
		SET @diminutivo ='djk'
		SET @Web = (
			CASE
		 			WHEN @diminutivo ='DJK' THEN(SELECT Nomem FROM TEMPLE where numem=110)
					WHEN @diminutivo ='ALM' THEN(SELECT Nomem FROM TEMPLE WHERE numem=120)
					ELSE 'www.devjoker.com' 
			END)
		PRINT @Web
		
		Ejemplo de Taxis e Garaxes

Select matricula, modalidad= 
case tipo 
    when 'R' then 'Revision'
    when 'A' then 'Averia'
end 
from INCIDENTE

		
		
		
		
		
		
--Bucle WHILE
--El bucle WHILE se repite mientras expresi?n se eval?e como verdadera.Es el ?nico tipo de bucle del que 
--dispone Transact SQL

	 WHILE <expresion>
		BEGIN
			...
		END
 
-- Un ejemplo del bucle WHILE.

	DECLARE @contador int
	SET @contador = 0
	WHILE(@contador < 10)
		BEGIN
	            SET @contador = @contador + 1   -- Tambien vale	SET @contador += 1
   	            PRINT 'Iteracion del bucle '+cast(@contador AS varchar)
	    END
 
 
 -- Podemos pasar a la siguiente iteraci?n del bucle utilizando CONTINUE.
 -- Continue devuelve el control al bucle

-- % Modulo o Mod, divide dos numeros y devuelve el resto de la division entera

			DECLARE @contador int
			SET @contador = 0
			WHILE(@contador < 100)
				BEGIN
		 			    SET @contador = @contador + 1
						IF(@contador % 2 = 0) CONTINUE
						PRINT 'Iteracion del bucle '+ cast(@contador AS varchar)
				END
		 
-- El bucle se dejar? de repetir con la instrucci?n BREAK 

		DECLARE @contador int
		 
		SET @contador = 0
		WHILE(1 = 1)
			BEGIN
		 
				SET @contador = @contador + 1
				IF(@contador % 50 = 0)
					BREAK
		        PRINT 'Iteracion del bucle '+ cast(@contador AS varchar)
		END
 
--Tambi?n podemos utilizar el bucle WHILE conjuntamente con consultas.


    DECLARE @coRecibo int
        
        WHILE
        
        EXISTS (SELECT * FROM RECIBOS WHERE PENDIENTE ='S')-- Ojo, la subconsulta se ejecuta
                                                            -- una vez por cada iteraci?n
                                                            -- del bucle! 
        BEGIN 
            SET @coRecibo =  (SELECT TOP 1 CO_RECIBO
                                FROM RECIBOS
                                WHERE PENDIENTE ='S')
            UPDATE RECIBOS
            SET PENDIENTE ='N' 
            WHERE CO_RECIBO = @coRecibo
    END