/**********************************************/
/********* EJERCICIOS PROGRAMACION  ***********/
/**********************************************/ 

use a23marcoscc_ALMACEN_25

-- 1- Utilizando la base de datos del Almacen, guardar en una variable el producto de mayor precio

	DECLARE @ProductoMasCaro1 NVARCHAR(100);

	SELECT TOP 1 @ProductoMasCaro1 = Descripcion
	FROM productos
	ORDER BY PrecioActual DESC;

	PRINT 'Producto más caro: ' + @ProductoMasCaro1;


-- 2- Comprobar si est? dado de alta el empleado JAVIER CAL y si no insertarlo

	DECLARE @idEmpleado INT, @name VARCHAR (50)
		SET @idEmpleado = 1150
		SET @name = 'Cal, Javier'

	IF EXISTS (SELECT * FROM EMPLEADOS WHERE IDEmpleado = @idEmpleado)
		BEGIN
			PRINT 'SOLUCION: Empleado '+ @name +'ya existe correctamente'
		END
	ELSE
		BEGIN
			INSERT INTO EMPLEADOS (IDEmpleado, Nombre)
				VALUES (@idEmpleado, @name)
			PRINT 'SOLUCION: Empleado dado de alta correctamente'
		END

-- 3- Recorrer la tabla productos y mostrar por pantalla los que tienen menos de 20 unidades de stock

	SELECT * FROM productos WHERE stock <= 20;

	DECLARE @total INT = 0, @id INT = 0, @nombre varchar(50);
	SET @total = (SELECT count(IDProducto) FROM PRODUCTOS WHERE Stock <=30);
	PRINT 'Hay '+ cast(@total as VARCHAR(3)) + ' productos con stock bajo'

	WHILE (@total > 0)
		BEGIN
		SELECT TOP(1) @id=IdProducto, @nombre= Descripcion 
			FROM PRODUCTOS 
			WHERE Stock <=30 AND IDProducto > @id ORDER BY IDProducto;
		PRINT CAST(@total as VARCHAR(4)) + ' El producto  '+ @nombre  + ' - '+ CAST(@id as VARCHAR(4)) + ' tiene poco stock';
		SET @total = @total - 1
		END


-- 4- Dada la siguiente tabla de descuentos, devolver en una variable el descuento que se va a aplicar seg?n las unidades del pedido
	--0-4 unidades -> no descuento
	--4-19 unidades -> 0,1
	--20-49 unidades -> 0,3
	--51 o m?s unidades ->0,5

	-- PRIMERA SOLUCIÓN

	DECLARE @Unidades INT = 25;
	DECLARE @Descuento DECIMAL(3,1);

	IF @Unidades < 4
		SET @Descuento = 0;
	ELSE IF @Unidades BETWEEN 4 AND 19
		SET @Descuento = 0.1;
	ELSE IF @Unidades BETWEEN 20 AND 49
		SET @Descuento = 0.3;
	ELSE
		SET @Descuento = 0.5;

	PRINT 'DESCUENTO APLICADO: ' + CAST(@Descuento AS VARCHAR)+'%';
	
	--SEGUNDA SOLUCIÓN
	DECLARE @unidades2 int=29;
	DECLARE @descuento2 varchar(50);
	SET @descuento2 = CASE 
			WHEN @unidades2 between 0 and 9 THEN
				'0'
			WHEN @unidades2 between 10 and 19 THEN 
				'0.1'
			WHEN @unidades2 between 20 and 49 THEN
				'0.3'
			WHEN @unidades2 >50 THEN 
				'0.5'
			ELSE 
				'0'
			END
	PRINT 'EL DESCUENTO ES DE: ' + @descuento2 + '%';
	GO


-- 5- Por cada pedido del almacen mostrar una mensaje con su id, el n?mero de unidades y el porcentaje de descuento de cada uno

	--ESTA ESTÁ MAL
	DECLARE @ID5 INT, @Unidades5 INT, @Descuento5 DECIMAL(3,2);
	DECLARE pedidos_cursor CURSOR FOR
	SELECT IDPedido, UNIDADES FROM PEDIDOS
	
	

-- 6- Comprobar si existen productos los productos cuyo stock sea 0 y eliminarlos

INSERT INTO PRODUCTOS values(90, 'Miau', 550.00, 0);
INSERT INTO PRODUCTOS values(100, 'Miau', 550.00, 0);
INSERT INTO PRODUCTOS values(110, 'Miau', 550.00, 0);

	SELECT * FROM PRODUCTOS

	BEGIN TRAN
		DELETE FROM PRODUCTOS
		WHERE Stock = 0;

		SELECT * FROM PRODUCTOS
	ROLLBACK

-- 7- Comprobar el n?mero de pedidos en un periodo de fechas entre 2021-04-01 y 2021-04-30
  -- Sacar reportes de ese mes, mostrar la fecha y el n?mero de pedidos en ese d?a ...
 
	SELECT 
		Fecha_pedido, 
		COUNT(*) AS NumeroDePedidos
	FROM PEDIDOS
	WHERE Fecha_pedido BETWEEN '2021-04-01' AND '2021-04-30'
	GROUP BY Fecha_pedido
	ORDER BY Fecha_pedido;

    
-- 8- Mostrar el reporte anterior solo para los d?as que tienen pedidos
 --Con el formato El d?a Martes 20 Abr 2021 se han realizado 1 pedidos

	 SET LANGUAGE Spanish;

	 SELECT 
		'El día ' + DATENAME(WEEKDAY, Fecha_pedido) + ' ' + 
		FORMAT(Fecha_pedido, 'dd MMM yyyy', 'es-es') + 
		' se han realizado ' + 
		CAST(COUNT(*) AS VARCHAR) + 
		' pedidos' AS Reporte
	FROM PEDIDOS
	WHERE Fecha_pedido BETWEEN '2021-04-01' AND '2021-04-30'
	GROUP BY Fecha_pedido
	HAVING COUNT(*) > 0
	ORDER BY Fecha_pedido;


-- 9- Recorrer la tabla clientes y mostrar por pantalla el n?mero de pedidos que ha realizado.

	DECLARE @contadorCliente INT;
	SET @contadorCliente = (SELECT COUNT(*) FROM CLIENTES)
	DECLARE @idcliente INT = 0;
	DECLARE @contadorPedido INT;
	DECLARE @idpedido INT = 0;

	WHILE (@contadorCliente > 0)
		BEGIN
			SET @idcliente = (	SELECT TOP(1) IDCliente 
								FROM CLIENTES 
								WHERE IDCliente > @idcliente 
								ORDER BY IDCliente)

			SET @contadorPedido = (	SELECT COUNT(*) 
								FROM PEDIDOS 
								WHERE IDCliente = @idcliente)

			PRINT '· Los pedidos del cliente "' + CAST(@idcliente AS VARCHAR(5)) + '" son un total de ' + CAST(@contadorPedido AS VARCHAR(5))+':'
			IF @contadorPedido = 0
				PRINT '    No hay pedidos'
			ELSE
				WHILE (@contadorPedido > 0)
					BEGIN
						SET @idpedido = (	SELECT TOP(1) IDPedido 
											FROM PEDIDOS p 
											WHERE	p.IDCliente = @idcliente	
													AND IDPedido > @idpedido 
											ORDER BY IDPedido)

						PRINT '   '+CAST(@idpedido AS VARCHAR(5))
						SET @contadorPedido = @contadorPedido -1 
					END
					SET @idpedido = 0
			PRINT '  '
			SET @contadorCliente -= 1
		END


-- 10- Recorrer la tabla empleados y mostrar por pantalla su nombre y el nombre de los clientes que tienen asignados.

	SELECT 
		E.Nombre AS NombreEmpleado,
		C.Nombre AS NombreCliente
	FROM EMPLEADOS E
	LEFT JOIN CLIENTES C ON E.IDEmpleado = C.IDComercial
	ORDER BY E.Nombre, C.Nombre;


	SELECT IDEmpleado, Nombre FROM EMPLEADOS;
	DECLARE @nombreEmp VARCHAR(30), @idEmp INT =0, @numEmp SMALLINT = (SELECT COUNT(*) FROM EMPLEADOS);
	DECLARE @nombreCli VARCHAR(25), @numCli TINYINT=0, @idCli INT =0;
	WHILE (@numEmp > 0)
		BEGIN
			SELECT TOP(1) @nombreEmp = Nombre, @idEmp=IDEmpleado 
				FROM EMPLEADOS 
				WHERE  IDEmpleado > @idEmp 
				ORDER BY IDEmpleado;

			SET @numCli = (SELECT COUNT(*) FROM CLIENTES WHERE IDComercial = @idEmp);
			SET @idCli = 0;
			WHILE(@numCli > 0)
				BEGIN
					SELECT TOP(1) @nombreCli =Nombre, @idCli=IDCliente 
						FROM CLIENTES 
						WHERE IDCliente > @idcli AND IDComercial = @idEmp
						ORDER BY IDCliente ;
                        
					PRINT 'El cliente '+ cast(@idcli as varchar(5)) +' - '+ @nombreCli +' es del empleado '+@nombreEmp;
					SET @numCli -= 1;
				END	
			SET @numEmp -= 1;
		END
	PRINT 'FIN'
GO