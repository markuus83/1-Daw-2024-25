/**********************************************/
/********* EJERCICIOS PROGRAMACION  ***********/
/**********************************************/ 

-- 1- Utilizando la base de datos del Almacen, guardar en una variable el producto de mayor precio
DECLARE @ProductoMasCaro VARCHAR(30);

SELECT @ProductoMasCaro = Descripcion
FROM PRODUCTOS
WHERE PrecioActual = (SELECT MAX(PrecioActual) FROM PRODUCTOS);

PRINT 'Producto más caro: ' + @ProductoMasCaro;

-- 2- Comprobar si est? dado de alta el empleado JAVIER CAL y si no insertarlo

IF NOT EXISTS (SELECT * FROM EMPLEADOS WHERE Nombre = 'JAVIER CAL')
BEGIN
    INSERT INTO EMPLEADOS (IDEmpleado, Nombre, Oficio, DIRECTOR, FechaAlta, Salario, Comision, IDDepartamento)
    VALUES (8000, 'JAVIER CAL', 'EMPLEADO', NULL, GETDATE(), 1200, NULL, NULL);
    PRINT 'Empleado JAVIER CAL insertado';
END
ELSE
    PRINT 'Empleado JAVIER CAL ya existe';

-- 3- Recorrer la tabla productos y mostrar por pantalla los que tienen menos de 20 unidades de stock
SELECT * 
FROM PRODUCTOS 
WHERE Stock < 20;

-- 4- Dada la siguiente tabla de descuentos, devolver en una variable el descuento que se va a aplicar seg?n las unidades del pedido
	--0-4 unidades -> no descuento
	--4-19 unidades -> 0,1
	--20-49 unidades -> 0,3
	--51 o m?s unidades ->0,5
DECLARE @Unidades INT = 25;
DECLARE @Descuento DECIMAL(3,2);

IF @Unidades < 4
    SET @Descuento = 0;
ELSE IF @Unidades BETWEEN 4 AND 19
    SET @Descuento = 0.1;
ELSE IF @Unidades BETWEEN 20 AND 49
    SET @Descuento = 0.3;
ELSE
    SET @Descuento = 0.5;

PRINT 'Descuento aplicado: ' + CAST(@Descuento AS VARCHAR);

-- 5- Por cada pedido del almacen mostrar una mensaje con su id, el n?mero de unidades y el porcentaje de descuento de cada uno
DECLARE @ID INT, @Unidades INT, @Descuento DECIMAL(3,2);
DECLARE pedidos_cursor CURSOR FOR
SELECT IDPedido, UNIDADES FROM PED

-- 6- Comprobar si existen productos los productos cuyo stock sea 0 y eliminarlos
 DELETE FROM PRODUCTOS
WHERE Stock = 0;


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

SELECT 
    C.IDCliente,
    C.Nombre AS NombreCliente,
    COUNT(P.IDPedido) AS NumeroDePedidos
FROM CLIENTES C
LEFT JOIN PEDIDOS P ON C.IDCliente = P.IDCliente
GROUP BY C.IDCliente, C.Nombre
ORDER BY NumeroDePedidos DESC;


-- 10- Recorrer la tabla empleados y mostrar por pantalla su nombre y el nombre de los clientes que tienen asignados.

SELECT 
    E.Nombre AS NombreEmpleado,
    C.Nombre AS NombreCliente
FROM EMPLEADOS E
LEFT JOIN CLIENTES C ON E.IDEmpleado = C.IDComercial
ORDER BY E.Nombre, C.Nombre;
