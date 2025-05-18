/**********************************************/
/********* EJERCICIOS PROGRAMACION  ***********/
/**********************************************/ 

USE ALMACEN_25;

-- 1- Utilizando la base de datos del Almacen, guardar en una variable el producto de mayor precio

	SELECT * FROM PRODUCTOS
	
	DECLARE @idProdutoMayorPrecio int;
	
	SET @idProdutoMayorPrecio =	(	SELECT TOP 1 IDProducto
									FROM PRODUCTOS
									ORDER BY PrecioActual DESC)
									
	PRINT 'O produto con maior prezo é: id-> "'+CONVERT(VARCHAR(30),@idProdutoMayorPrecio)+'".'


-- 2- Comprobar si esta dado de alta el empleado JAVIER CAL y si no insertarlo

	SELECT * FROM EMPLEADOS	WHERE Nombre LIKE 'JAVIER CAL'

	EXEC sp_help EMPLEADOS

	BEGIN TRAN
	
		IF EXISTS (	SELECT IDEmpleado
					FROM EMPLEADOS 
					WHERE Nombre LIKE 'JAVIER CAL')
			BEGIN
				
				PRINT 'O empregado JAVIER CAL xa existe'
			
			END
			
		ELSE
			BEGIN
				INSERT INTO EMPLEADOS(IDEmpleado, Nombre) VALUES(2000, 'JAVIER CAL')
				PRINT 'Novo empregado dado de alta'
			END
	
		--Comprobamos que, efectivamente, insertamos o novo empregado
		SELECT * FROM EMPLEADOS	WHERE Nombre LIKE 'JAVIER CAL'
		
	ROLLBACK


-- 3- Recorrer la tabla productos y mostrar por pantalla los que tienen menos de 20 unidades de stock

	SELECT * FROM PRODUCTOS
	
	BEGIN TRAN
		
		DECLARE @idProducto int = 0;
		DECLARE @total int = (	SELECT COUNT(IDProducto)
								FROM PRODUCTOS
								WHERE Stock >= 20)
		
		PRINT 'Existen '+CONVERT(VARCHAR(30),@total)+' productos con máis de 20 unidades de Stock!'
		
		WHILE(@total > 0)
		
			BEGIN
			
				SELECT TOP(1) @idProducto=IdProducto
				FROM PRODUCTOS 
				WHERE Stock >=20 AND IDProducto > @idProducto 
				ORDER BY IDProducto;
				
				PRINT CHAR(9)+'O producto con id -> '+CONVERT(VARCHAR(30),@idProducto)+' ten máis de 20 unidades de stock.'
				
				SET @total = @total-1
								
			END
	
	ROLLBACK


-- 4- Dada la siguiente tabla de descuentos, devolver en una variable el descuento que se va a aplicar seg?n las unidades del pedido
	--0-4 unidades -> no descuento
	--4-19 unidades -> 0,1
	--20-49 unidades -> 0,3
	--51 o m?s unidades ->0,5


	BEGIN TRAN
	
		DECLARE @descuento VARCHAR(50);
		DECLARE @unidades INT=100;
		
		SET @descuento = CASE
			WHEN @unidades >=0 AND @unidades < 4 
				THEN 'no descuento'
				
			WHEN @unidades >=4 AND @unidades <= 19 
				THEN '0.1'
				
			WHEN @unidades >=20 AND @unidades <= 50 
				THEN '0.3 '
				
			WHEN @unidades >=51
				THEN '0.5'
				
			ELSE 'Erro'
		END
	
		PRINT 'El descuento es del '+@descuento+'%'
		
	ROLLBACK


-- 5- Por cada pedido del almacen mostrar una mensaje con su id, el n?mero de unidades y el porcentaje de descuento de cada uno






-- 6- Comprobar si existen productos cuyo stock sea 0 y eliminarlos
 
	
	BEGIN TRAN
		
		--Introducimos os valores para comprobar o funcionamento
		INSERT INTO PRODUCTOS(IDProducto, Descripcion, PrecioActual, Stock)
			VALUES(100, 'Miau1',500, 0);
		
		INSERT INTO PRODUCTOS(IDProducto, Descripcion, PrecioActual, Stock)
			VALUES(110, 'Miau2',510, 0);
		
		INSERT INTO PRODUCTOS(IDProducto, Descripcion, PrecioActual, Stock)
			VALUES(120, 'Miau3',520, 0);
		
		INSERT INTO PRODUCTOS(IDProducto, Descripcion, PrecioActual, Stock)
			VALUES(130, 'Miau4',530, 0);
		
		INSERT INTO PRODUCTOS(IDProducto, Descripcion, PrecioActual, Stock)
			VALUES(140, 'Miau5',540, 0);
		
		
		--Observamos que se introducen correctamente
		SELECT * FROM PRODUCTOS;
		
		
		--Obtemos a cantidade de produtos que non teñen stock
		DECLARE @cantidadeProductosSenStock INT = (	SELECT COUNT(IDProducto)
													FROM PRODUCTOS
													WHERE Stock = 0)
	
		PRINT 'Existen '+CONVERT(VARCHAR(30),@cantidadeProductosSenStock)+' produtos que non teñen stock'
	
		-- ELiminamos
		DELETE FROM PRODUCTOS WHERE Stock = 0
		PRINT 'Produtos eliminados con éxito!'
			
		--Observamos
		SELECT * FROM PRODUCTOS
		
	ROLLBACK
 
 
 -- 9- Recorrer la tabla clientes y mostrar por pantalla el n?mero de pedidos que ha realizado.

	SELECT * FROM CLIENTES;
	SELECT * FROM PEDIDOS;

	BEGIN TRAN
	
		-- Obtenemos el numero de clientes que tenemos
		DECLARE @contadorClientes INT = (	SELECT COUNT(IDCliente)
											FROM CLIENTES)
		
		-- Declaramos las variables necesarias
		DECLARE @idCliente INT = 0;
		DECLARE @idPedido INT = 0;
		DECLARE @contadorPedidos INT;
		
		-- Inicializamos el bucle que irá iterando cliente por cliente
		WHILE(@contadorClientes > 0)
			BEGIN
				
				--Obtenemos el id del cliente
				SET @idCliente = (	SELECT TOP 1 IDCliente
									FROM CLIENTES
									WHERE IDCliente > @idCliente -- Para pasar al siguiente id
									ORDER BY IDCliente)
				
				--Obtenemos el número de pedidos del cliente
				SET @contadorPedidos = (SELECT COUNT(IDPedido)
										FROM PEDIDOS
										WHERE IDCliente = @idCliente)
				
				-- Mostramos el número de pedidos del cliente
				PRINT 'Los pedidos del cliente '+CONVERT(VARCHAR(30),@idCliente)+' son un total de '+CONVERT(VARCHAR(30),@contadorPedidos)+':'
				
				-- Si no tiene pedidos, mostramos el siguiente el mensaje
				IF(@contadorPedidos = 0)
					BEGIN
						PRINT CHAR(9)+'No hay pedidos'
					END
				
				-- Iteramos sobre los pedidos de cada cliente
				WHILE(@contadorPedidos > 0)
					BEGIN
						
						-- Obtenemos los id de cada pedido
						SET @idPedido = (	SELECT TOP 1 IDPedido
											FROM PEDIDOS
											WHERE IDCliente = @idCliente AND IDPedido > @idPedido -- Para pasar al siguiente id
											ORDER BY IDPedido )
											
						-- Mostramos el id por pantalla
						PRINT CHAR(9)+CONVERT(VARCHAR(30),@idPedido)
						
						--Reducimos el contador de pedidos
						SET @contadorPedidos = @contadorPedidos-1
						
					END
				
				
				SET @idPedido = 0 -- Para pasar al siguiente id
				PRINT '' -- Dejamos un salto de línea entre cliente y cliente
				SET @contadorClientes = @contadorClientes-1
			END
		
	ROLLBACK




-- 10- Recorrer la tabla empleados y mostrar por pantalla su nombre y el nombre de los clientes que tienen asignados.