-- Ejemplos de variables y sentencias de control 2024





/**********************************************/
/************** PROGRAMACION  ****************/
/**********************************************/ 

 
USE ALMACEN_24;

SELECT * FROM CLIENTES;
SELECT * FROM EMPLEADOS;
SELECT * FROM DEPARTAMENTOS;
SELECT * FROM PEDIDOS;
SELECT * FROM PRODUCTOS;

/****** Definicion de Variables ************/

DECLARE @nombre varchar (50);
--  DECLARE declara una variable,  @nombre es el identificador(nombre), y la variable es de tipo varchar. 
SET @nombre ='Juan Calvo';
-- Asigna un valor a una variable
PRINT @nombre

-- Es equivalente a:
SELECT @nombre ='Juan Calvo';
-- El signo = es un operador -- 'Juan Calvo' es un literal
-- PRINT Visualiza por pantalla el valor de una variable
PRINT  @nombre;
GO

DECLARE @nombre VARCHAR(50) = 'Mar?a';
PRINT 'Es el empleado ' + @nombre
GO   

-- Ejemplo con la BD de almacen
-- se puede asignar un valor a la variable en el momento de la creaccion
DECLARE @nombre VARCHAR(50);
SET @nombre = 'Pedro';
SELECT @nombre =nombre FROM EMPLEADOS WHERE idEmpleado = 7901;
-- La consulta debe devolver un ?nico registro, sino a la varible se asigna solo uno
SET @nombre = (SELECT TOP(1) nombre FROM EMPLEADOS WHERE idEmpleado = 7901);
PRINT 'Es el empleado ' + @nombre
GO
    
-- Las variables numericas necesitan conversi?n CAST o CONVERT para hacer PRINT
DECLARE @valor INT = 10;
PRINT @valor
-- Las variables necesitan conversi?n CAST o CONVERT para hacer PRINT con un mensaje de texto
PRINT 'Es el n?mero ' + CAST(@valor as VARCHAR(3));


-- Tambien se pueden declarar varias variables a la vez 
--Se puede asignar un valor en la declaraci?n y tambi?n declarar varias variables en una misma sentencia:
--(inicializacion de la variable)
DECLARE @nombreE VARCHAR(50) = 'Mar?a', 
		@salario smallmoney = 2000, 
		@masantiguo date = (select MAX(FechaAlta) FROM EMPLEADOS),
		@comision decimal(4,2) = 0.2;

DECLARE @intvariable int =2,
	@datevariable date = getdate(),
	@maxsalario smallmoney = (select MAX(Salario) from EMPLEADOS); 

-- Operaciones con variables
SET @comision = @comision + 0.3
PRINT @comision;
SET @comision += 0.3 -- Es lo mismo que la suma
PRINT @comision;

SET @comision = @comision - 0.3 -- Se puede expresar @comision -= 0.3
PRINT @comision;

SET @comision = @comision * 0.3
PRINT @comision;

SET @comision = @comision / 0.3
PRINT @comision;
 

--El siguiente ejemplo muestra como asignar variables utilizando una sentencia SELECT
DECLARE @nombre VARCHAR (50),
		@salario smallmoney,
		@fechaAlta date,
		@comis decimal(4,2);			
SELECT
	@nombre=nombre, 
	@salario=salario,
	@fechaAlta=@fechaAlta,
	@comis=comision
FROM EMPLEADOS
	WHERE IDEmpleado =7844
		    
PRINT 'El empleado ' + @nombre + ' tiene un salario ' +  CAST(@salario as VARCHAR(10))  + ' y una comision de ' +  CAST(@comis as VARCHAR(10))
PRINT @comis

-- Si le asignamos valor con una SELECT y esta tiene mas de una fila, 
-- solo guardara el resultado de la ultima fila.

-- Control de Flujo	 

-- Comprobaciones con if-else
DECLARE @edad INT = 20
IF (@edad >= 18)
     PRINT 'Es mayor de edad'
ELSE
     PRINT 'Es menor de edad'



-- Ejemplo de la estructura condicional IF

DECLARE @edad INT = 2
IF (@edad >= 18)
  BEGIN
     PRINT 'Es mayor de edad'
	 SET @edad += 1;
  END
ELSE
  BEGIN
     PRINT 'Es menor de edad'
	 IF @edad < 12
	   BEGIN
			PRINT 'Est? en educaci?n primaria o infantil'
	   END
  END

PRINT CAST(@edad as VARCHAR(3))
PRINT 'FIN'


-- if exists

 IF EXISTS (SELECT stock FROM Productos WHERE stock <= 20 )
 PRINT 'Hace falta reponer el stock'; 
ELSE  
   print 'Stock en regla';
  


-- CASE
DECLARE @mensaje VARCHAR(50), 
	    @edad INT = 20;
SET @mensaje = CASE
				 WHEN @edad<12 THEN 
					'Est? en educaci?n primaria o infantil'
				 WHEN @edad<18 THEN 
					'Es menor de edad'
				 ELSE
					'Es mayor de edad'
			   END  
 

-- Hacer mensaje calificaciones
DECLARE @p_numero INT = 6;
DECLARE @variable VARCHAR(50) = 
		case  
			 when @p_numero between  9 and 10 then
			' tiene un sobresaliente' 
		 when @p_numero between 7 and  8 then
			 ' tiene un notable'
		 when @p_numero=6 then
			 ' tiene un bien'
		 when @p_numero=5 then
			 ' tiene un suficiente'
		else
			  ' tiene un insuficiente'
	end  
PRINT @variable;

--La estructura IF admite el uso de consultas:
-- Comprobar si est? dado de alta el empleado y si no insertarlo
DECLARE @idEmpleado int,
		@name varchar(255) 		
SET @idEmpleado =1100
SET @name ='Perez, Pepe'
				 
IF EXISTS (SELECT * FROM EMPLEADOS WHERE IDEmpleado = @idEmpleado)
	BEGIN
		UPDATE EMPLEADOS SET nombre = @name 
			WHERE IDEmpleado = @idEmpleado
	END		 
ELSE		 
	BEGIN 
		INSERT INTO EMPLEADOS (IDEmpleado, Nombre)
			VALUES(@idEmpleado, @name)
	END
		 
SELECT * FROM EMPLEADOS
 
-- BUCLE WHILE

DECLARE @edad INT = 10;
WHILE (@edad >=0)
	BEGIN
		PRINT 'Tiene ' + CAST(@edad as VARCHAR(3));
		SET @edad = @edad - 1;
	END
PRINT 'FINAL ';
GO

-- BREAK - salta al final del bucle y continua con las instrucciones siguientes
DECLARE @edad INT = 10;
WHILE (@edad >=0)
	BEGIN
		PRINT 'Tiene ' + CAST(@edad as VARCHAR(3));
		SET @edad = @edad - 1;
		if(@edad<2)
			BREAK
		PRINT 'sigue'
	END
PRINT 'FINAL ';
GO

-- CONTINUE -- salta al principio del bucle y vuelve a hacer la comprobaci?n
DECLARE @edad INT = 10;
WHILE (@edad >= 0)
	BEGIN
		PRINT 'Tiene ' + CAST(@edad as VARCHAR(3));
		SET @edad = @edad - 1;
		if(@edad<2)
			CONTINUE -- Salta a la comprobacion del while
		PRINT 'sigue'
	END
PRINT 'FINAL ';
GO

DECLARE @num_value INT = 0;
WHILE @num_value <= 10
BEGIN
   IF @num_value = 6
	   BEGIN
		  PRINT 'Salta';  -- Ya no sigue en el bucle
		  BREAK;
	   END
   ELSE
      BEGIN
		  SET @num_value = @num_value + 1;
		  PRINT 'continua';
		  CONTINUE;
		  PRINT 'Dentro del bucle'; -- No se ejecuta nunca
	  END
END;

PRINT 'Bucle finalizado. Se repiti? '+ cast(@num_value as VARCHAR(10)) + ' veces';
GO

-- WHILE EXISTS
-- UPDATE EMPLEADOS que tiene la Comision = NULL y actualizarla a 0.2
DECLARE @id INT;
 WHILE EXISTS (SELECT IDEmpleado FROM EMPLEADOS WHERE comision IS NULL)
	BEGIN
		SET @id = (SELECT TOP(1)IDEmpleado FROM EMPLEADOS WHERE comision IS NULL);
		PRINT 'Sin comision el empleado '  + CAST(@id as VARCHAR(4));
		UPDATE EMPLEADOS SET comision =0.2 WHERE idEmpleado = @id ;
	END
PRINT 'FIN ';
 
-- WHILE con fechas

DECLARE @date_start DATE;
DECLARE @date_end DATE;
DECLARE @loop_date DATE;
 
SET @date_start = '2021/01/11';
SET @date_end   = '2021/03/12';
 
SET @loop_date = @date_start;
 
WHILE @loop_date <= @date_end
BEGIN
   PRINT @loop_date;
   SET @loop_date = DATEADD(DAY, 1, @loop_date);
END;


 