/**********************************************/
/********* EJERCICIOS PROGRAMACION  ***********/
/**********************************************/ 

USE a23marcos_BD_Almacen;

-- 1- Utilizando la base de datos del Almacen, guardar en una variable el producto de mayor precio

	--SELECT * FROM PRODUCTOS
	
	--EXEC sp_help PRODUCTOS
	
	--BEGIN TRAN
	
	--	DECLARE @maximoPrezo MONEY;
		
	--	SELECT @maximoPrezo = MAX(PrecioActual)
	--	FROM PRODUCTOS
		
	--	PRINT @maximoPrezo
		
	--ROLLBACK
	


-- 2- Comprobar si est? dado de alta el empleado JAVIER CAL y si no insertarlo
	
	--Comprobamos datos
	SELECT Nombre FROM EMPLEADOS;
	
	--Detectamos nulos
	EXEC sp_help EMPLEADOS

	--Executamos a operación desexada
	--BEGIN TRAN
	
	--	DECLARE @existeCliente VARCHAR(10);
		
	--	IF EXISTS (	SELECT Nombre
	--				FROM EMPLEADOS
	--				WHERE Nombre = 'JAVIER CAL')
	--		BEGIN
	--			PRINT 'O empregado JAVIER CAL EXISTE NA BBDD'
	--		END
	--	ELSE
	--		BEGIN
	--			INSERT INTO EMPLEADOS(IDEmpleado, Nombre) VALUES(11, 'JAVIER CAL')
	--			PRINT 'Empregado dado de alta correctamente'
	--		END
			
	--	SELECT * FROM EMPLEADOS
	
	--ROLLBACK
	

-- 3- Recorrer la tabla productos y mostrar por pantalla los que tienen menos de 
--20 unidades de stock
	
	--COmprobamos datos
	SELECT * FROM PRODUCTOS	
	
	--Executamos a operación
	BEGIN TRAN
		
	--	DECLARE @nombre VARCHAR(20);
	--	DECLARE @id INT;
	--	DECLARE @contador INT;
	--	SET @contador = (	SELECT COUNT(IDProducto)
	--						FROM PRODUCTOS)
		
	--	WHILE (	@contador > 0)
	--		BEGIN
	--			SELECT TOP 1 @id = IDProducto, @nombre = Descripcion
	--			FROM PRODUCTOS
	--			WHERE Stock < 20
	--			ORDER BY IDProducto
				
	--			PRINT 'O produto '+@nombre+'-'+CONVERT(VARCHAR(5),@id)
	--			SET @contador = @contador -1
	--		END
		
	--ROLLBACK


-- 4- Dada la siguiente tabla de descuentos, devolver en una variable el descuento que se va a aplicar seg?n las unidades del pedido
	--0-4 unidades -> no descuento
	--4-19 unidades -> 0,1
	--20-49 unidades -> 0,3
	--51 o m?s unidades ->0,5

	select * from PEDIDOS
	
	--BEGIN TRAN
		--DECLARE @unidades INT = 4;
		--DECLARE @descuento VARCHAR(20);
		
	--	SET @descuento = CASE
	--		WHEN @unidades > 0 and @unidades < 4 THEN 'No descuento'
	--		WHEN @unidades between 4 and 19 THEN 'No descuento'
	--		WHEN @unidades between 20 and 49 THEN 'No descuento'
	--		WHEN @unidades >= 50 THEN 'No descuento'
	--		ELSE 'Erro'
	--		END
	--	PRINT 'El descuendo es de: '+@descuento+'%'
	--ROLLBACK
	


-- 5- Por cada pedido del almacen mostrar una mensaje con su id, el n?mero de unidades 
--y el porcentaje de descuento de cada uno

	SELECT * FROM PEDIDOS
	
	--BEGIN TRAN
	--	--Almacenamos o identificador
	--	DECLARE @id INT =0;
	--	--Almacenamos as unidades
	--	DECLARE @unidades INT = 0;
	--	--Contador
	--	DECLARE @contadorTotal INT;
	--	--Almacenamos o descuento
	--	DECLARE @descuento VARCHAR(50);
		
	--	--Contamos a cantidade de pedidos e establecemos as veces que percorreremos o bucle
	--	SET @contadorTotal  = (	SELECT COUNT(IDPedido)
	--					FROM PEDIDOS)
		
	--	--PErcorremos o bucle
	--	WHILE(@contadorTotal  > 0)
	--		BEGIN
			
	--			--Ingresamos os datos necesarios
	--			SELECT TOP(1) @id = IDPedido, @unidades = UNIDADES
	--			FROM PEDIDOS
	--			WHERE IDPedido > @id
	--			ORDER BY IDPedido;

	--			--Aplicamos os descontos correspondentes
	--			SET @descuento = CASE
	--				WHEN @unidades > 0 and @unidades < 4 THEN 'No descuento'
	--				WHEN @unidades between 4 and 19 THEN '0.1'
	--				WHEN @unidades between 20 and 49 THEN '0.3'
	--				WHEN @unidades >= 50 THEN '0.5'
	--				ELSE 'Erro'
	--			END
				
	--			PRINT 'El pedido "'  + CAST(@id as VARCHAR(4)) + '" de "'+ CAST(@unidades as VARCHAR(4))+'" unidades se le aplica un descuento de: ' + @descuento +'';

	--			SET @contadorTotal  = @contadorTotal -1
	--		END
	--ROLLBACK
	
	

-- 6- Comprobar si existen productos, los productos cuyo stock sea 0 y eliminarlos

	SELECT * FROM PRODUCTOS
	
	--BEGIN TRAN
	
	--	insert into productos values (3,'c',20,0),(2,'b',20,0), (1,'a',20,0) ;

	--	DECLARE @idproducto INT;
		
	--	WHILE EXISTS (	SELECT IDProducto
	--					FROM PRODUCTOS
	--					WHERE Stock = 0)
	--		BEGIN
					
	--				SET @idproducto = (	SELECT TOP(1) IDProducto 
	--									FROM PRODUCTOS 
	--									WHERE Stock=0)
	--				DELETE FROM PRODUCTOS WHERE IDProducto = @idproducto
	--				PRINT 'Producto: '+CONVERT(VARCHAR(3), @idproducto)+' eliminado'
	--		END
	
	--ROLLBACK

-- 7- Comprobar el n?mero de pedidos en un periodo de fechas entre 2021-04-01 y 2021-04-30
  -- Sacar reportes de ese mes, mostrar la fecha y el n?mero de pedidos en ese d?a ...
 
	

    
-- 8- Mostrar el reporte anterior solo para los d?as que tienen pedidos
 --Con el formato El d?a Martes 20 Abr 2021 se han realizado 1 pedidos




-- 9- Recorrer la tabla clientes y mostrar por pantalla el n?mero de pedidos que ha realizado.

	--SELECT * FROM CLIENTES
	--SELECT * FROM PEDIDOS
	
	--BEGIN TRAN
	
	--	DECLARE @id INT = 0;
	--	DECLARE @unidades INT;
	--	DECLARE @contador INT = 0;

		
	--	WHILE EXISTS (	SELECT 1 
	--					FROM CLIENTES c
	--					WHERE c.IDCliente > @id)

	--		BEGIN
			
	--			SELECT TOP 1 @id = c.IDCliente
	--			FROM CLIENTES c 
	--			WHERE IDCliente > @id
	--			ORDER BY c.IDCliente
				
	--			SELECT @unidades = COUNT(p.UNIDADES)
	--			FROM PEDIDOS p
	--			WHERE p.IDCliente = @id;

				
	--			PRINT 'El cliente "'+CONVERT(VARCHAR(10),@id)+'" ha realizado "'+CONVERT(VARCHAR(10),@unidades)+'" pedidos'
	--			SET @contador = @contador+1
	--		END
	--	PRINT 'Total de clientes procesados: ' + CONVERT(VARCHAR(10), @contador);
	--ROLLBACK
	
-- 10- Recorrer la tabla empleados y mostrar por pantalla su nombre y el nombre de los clientes que tienen asignados.

	


	DECLARE @total INT = 0, 
			@id INT = 0,
			@nombre varchar(50);

	SET @total = (	SELECT count(IDProducto) 
					FROM PRODUCTOS 
					WHERE Stock <=30);

	PRINT 'Hay '+ cast(@total as VARCHAR(3)) + ' productos con stock bajo'

	WHILE (@total > 0)
		BEGIN
			SELECT TOP(1) @id=IdProducto, @nombre= Descripcion 
			FROM PRODUCTOS 
			WHERE Stock <=30 AND IDProducto > @id 
			ORDER BY IDProducto;

			PRINT CAST(@total as VARCHAR(4)) + ' El producto  '+ @nombre  + ' - '+ CAST(@id as VARCHAR(4)) + ' tiene poco stock';

			SET @total = @total - 1
		END
