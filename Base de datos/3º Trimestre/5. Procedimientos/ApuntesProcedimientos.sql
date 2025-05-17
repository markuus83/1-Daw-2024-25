USE ALMACEN_PROCEDIMIENTOS_25;

-- 1. Escribir un procedimiento que reciba dos números y visualice su suma.

	BEGIN TRAN
	
		CREATE PROCEDURE pr_sumaNumeros
		@numero1 INT,
		@numero2 INT
		
			AS
				BEGIN
					DECLARE @suma INT;
					SET @suma = @numero1+@numero2;
					
					PRINT 'El resultado de la suma es: '+CONVERT(VARCHAR(30), @suma);
				END;
				
		EXEC pr_sumaNumeros 4,5
		
	ROLLBACK


/* 2. Utilizando el comando IF, crea un procedimiento 'siDivisible' que reciba 2 números y muestre sÍ el primero es divisible por el segundo.

	Por ejemplo, si introducimos los números 4 y 2. El procedimiento deberá mostrar el mensaje: 4 es divisible por 2.

*/

	BEGIN TRAN
	
		CREATE PROCEDURE pr_siDivisible
		@numero1 INT,
		@numero2 INT
		
			AS
				BEGIN
					
					IF(@numero1 = 0 OR @numero2 = 0)
						BEGIN
							PRINT 'No es posible porque uno de los números es 0'
						END
						
					ELSE IF(@numero1 % @numero2 = 0)
						BEGIN
							PRINT CONVERT(VARCHAR(30),@numero1)	+' es divisible entre '+CONVERT(VARCHAR(30),@numero2)
						END
						
					ELSE
						BEGIN
							PRINT 'No da una división exacta'
						END
				END;
				
		EXEC pr_siDivisible 4,2
		EXEC pr_siDivisible 4,5
		EXEC pr_siDivisible 4,0
		
	ROLLBACK





/* 3. Utilizando el comando CASE, crear un procedimiento 'notasPrimaria' que reciba dos parámetros: p_Numero (nota de un alumno) y p_Nombre (nombre del alumno). 
El procedimiento deberá mostrar un mensaje con el siguiente formato y según el siguiente baremo:

	- si la nota está entre 9 y 10, deberá mostrar ‘el alumno [nombre] tiene un Sobresaliente’.

	- si la nota está entre 7 y 8, deberá mostrar ‘el alumno [nombre] tiene un Notable‘.

	- si la nota es un 6, deberá mostrará ‘el alumno [nombre] tiene un Bien‘.

	- si la nota es un 5, deberá mostrar ‘el alumno [nombre] tiene un Suficiente‘.

	- si la nota es menor que 5, deberá mostrar ‘el alumno [nombre] tiene un Insuficiente‘.

*/

	BEGIN TRAN
	
		CREATE PROCEDURE pr_notasPrimaria
		@p_Numero INT,
		@p_Nombre VARCHAR(30)
		AS
			BEGIN
				DECLARE @variable VARCHAR(100);
				
				SET @variable = CASE
					WHEN @p_Numero >= 9 AND  @p_Numero <= 10 THEN 
						CONVERT(VARCHAR(30), @p_Nombre)+' tiene un Sobresaliente'
						
					WHEN @p_Numero >= 7 AND  @p_Numero <= 8 THEN 
						CONVERT(VARCHAR(30), @p_Nombre)+' tiene un Notable'
						
					WHEN @p_Numero > 5 AND  @p_Numero <= 6 THEN 
						CONVERT(VARCHAR(30), @p_Nombre)+' tiene un Bien'
						
					WHEN @p_Numero = 5 THEN 
						CONVERT(VARCHAR(30), @p_Nombre)+' tiene un Suficiente'
						
					WHEN @p_Numero >= 0 and @p_Numero < 5 THEN
						CONVERT(VARCHAR(30), @p_Nombre)+' tiene un Insuficinte'
						
					ELSE 
						'Nota no válida'
					
				END
				PRINT 'El alumno '+@variable
			END
	
		EXECUTE pr_notasPrimaria 10, 'Miau';
		EXECUTE pr_notasPrimaria 9, 'Miau';
		EXECUTE pr_notasPrimaria 8, 'Miau';
		EXECUTE pr_notasPrimaria 7, 'Miau';
		EXECUTE pr_notasPrimaria 6, 'Miau';
		EXECUTE pr_notasPrimaria 5, 'Miau';
		EXECUTE pr_notasPrimaria 0, 'Miau';
		EXECUTE pr_notasPrimaria 100, 'Miau';
		
	ROLLBACK




/* 4. Utilizando un bucle, crea un procedimiento que muestre la suma de los números pares comprendidos entre 100 y 90 (100-98-96-94-92-90). */

	BEGIN TRAN
	
		CREATE PROCEDURE pr_sumaPares
			AS
			
				BEGIN
				
					DECLARE @inicio int = 1;
					DECLARE @fin int = 100;
					DECLARE @suma int = 0;
					DECLARE @contador int = 0;
					
					WHILE (@contador <= 100)
						BEGIN
							IF(@contador%2=0)
								BEGIN
									set @suma = @suma+@contador
								END
							SET @contador = @contador+1
						END
					
					PRINT 'La suma total es: '+CONVERT(VARCHAR(30),@suma)
				END
				
			EXECUTE pr_sumaPares
	
	ROLLBACK



/* 5. Utilizando un bucle WHILE, crea un procedimiento que muestre

la suma de los 100 primeros n‘meros naturales (1-2-............-99-100). */


	BEGIN TRAN
	
		CREATE PROCEDURE pr_sumaPares
			AS
			
				BEGIN
				
					DECLARE @inicio int = 1;
					DECLARE @fin int = 100;
					DECLARE @suma int = 0;
					DECLARE @contador int = 0;
					
					WHILE (@contador <= 100)
						BEGIN
							SET @suma = @suma+@contador
							SET @contador = @contador+1
						END
					PRINT 'La suma total es: '+CONVERT(VARCHAR(30),@suma)
				END
				
			EXECUTE pr_sumaPares
	
	ROLLBACK



/* 7. Crear un procedimiento ‘operacionesAritméticas’, que reciba 2 números enteros o decimalesy que muestre la suma, resta, producto y división de dichos números.*/







/* 8. Crear un procedimiento 'primeros20Impares' que muestre los 20 primeros números impares.*/

/*
	BEGIN TRAN
	
		CREATE PROCEDURE pr_primeiros20Ipares
			AS
				BEGIN
				
					
				END
		
	ROLLBACK

*/

/* 9. Modifica el procedimiento anterior para que muestre los 20 números impares que sigan al número que se indique como parámetro*/








/* 10. Crear un procedimiento 'fechaLarga' que reciba una fecha (dd-mm-aaaa) y muestra la fecha en formato largo. Por ejemplo: 31-10-2014 deberá mostrar: Viernes, 31 de Octubre de 2014 */