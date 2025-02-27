/****************************************************/
/******* FUNCIONES AGREGADO Y AGRUPACION ************/
/****************************************************/
use a23marcoscc_BD_Almacen;

-- 1. Visualizar todos los Oficios y el número de EMPLEADOS de la empresa que los desempeñan

	SELECT Oficio, COUNT(IDEmpleado) numEmpregados
	FROM EMPLEADOS
	GROUP BY Oficio
 

-- 2. Visualizar todos los Oficios y el número de EMPLEADOS de la empresa que lo desempeñan,
-- siempre que sean más de uno
 
	SELECT Oficio, COUNT(IDEmpleado) AS numEmpregados
	FROM EMPLEADOS
	GROUP BY Oficio
	HAVING COUNT(IDEmpleado) > 1
	

-- 3. Hallar el gasto salarial (salario + comision) anual de la empresa, suponiendo 14 pagas
 
	SELECT oficio, SUM(Salario + ISNULL(comision, 0)) as importeAnual
	FROM EMPLEADOS
	GROUP BY Oficio
	ORDER BY importeAnual
 

-- 4. Obtener el número de EMPLEADOS que hay por cada Oficio en cada departamento de la empresa
 
	SELECT e.Oficio, COUNT(e.IDEmpleado) AS numEmpleados, d.Nombre AS nomeDepartamento
	FROM EMPLEADOS e JOIN DEPARTAMENTOS d
	ON e.IDDepartamento = d.IDDepartamento
	GROUP BY e.Oficio, d.Nombre


-- 5. Calcular el número de Oficios distintos que hay en el departamento 30 de la tabla de EMPLEADOS
 
	SELECT DISTINCT COUNT(Oficio) AS numOficiosDistintos
	FROM EMPLEADOS
	WHERE IDDepartamento = 30;


-- 6. Obtener los salarios medios por departamento
 
	SELECT ISNULL(CONVERT(VARCHAR(30),IDDepartamento),'Departamento sen nome') AS idDepartamento, AVG(salario) AS mediaSalario
	FROM EMPLEADOS
	GROUP BY IDDepartamento
 
 
-- 7. Obtener para cada departamento, cuantos DIRECTORES hay.
 
	SELECT ISNULL(CONVERT(VARCHAR(30),IDDepartamento),'Departamento sen nome') AS idDepartamento, COUNT(Director) as numDirectores
	FROM EMPLEADOS
	GROUP BY IDDepartamento
 

-- 8. Obtener, para cada departamento, cuantos DIRECTORES hay en ese departamento y cual es su salario medio.
 
	SELECT ISNULL(CONVERT(VARCHAR(30),IDDepartamento),'Departamento sen nome') AS idDepartamento, COUNT(Director) as numDirectores, AVG(Salario) as mediaSalario
	FROM EMPLEADOS
	GROUP BY IDDepartamento, Salario
 
 
-- 9. Obtener el total de euros que hay invertidos entre todos los productos disponibles
 
	SELECT SUM(PrecioActual * Stock) AS Total_Invertido
	FROM PRODUCTOS;
	


--10. Visualizar las unidades totales vendidas de cada producto a cada cliente, 
--mostrando el número de producto, el número de cliente y la suma de las unidades
 
	SELECT IDProducto, IDCliente, SUM(Unidades) AS Total_Unidades_Vendidas
	FROM PEDIDOS
	GROUP BY IDProducto, IDCliente;

 

--11. Obtener las fechas de pedido de los productos, del pedido más antiguo y el más reciente de cada producto, 
--mostrando también el número de producto correspondiente
 
	SELECT IDProducto, MIN(Fecha_pedido) AS Pedido_Mas_Antiguo, MAX(Fecha_pedido) AS Pedido_Mas_Reciente
	FROM PEDIDOS
	GROUP BY IDProducto;

 

--12. Obtener los números de cliente de los dos clientes con mayor número de pedidos, 
--indicando también cuantos pedidos han hecho.
 
	SELECT TOP 2 IDCliente, COUNT(IDPedido) as numPedidos
	FROM PEDIDOS
	GROUP BY IDCliente
	ORDER BY numPedidos DESC
 

--13. Obtener las localidades en las que haya más de un cliente, visulizando cuantos clientes hay.
 
	SELECT Localidad, COUNT(IDCliente) as numClientes
	FROM CLIENTES
	GROUP BY Localidad
	HAVING COUNT(IDCliente) > 1


--14. Listar los números de cliente que tengan más de dos pedidos, ordenado por cantidad de pedidos
 
	SELECT IDCliente, COUNT(IDPedido) as numPedidos
	FROM PEDIDOS
	GROUP BY IDCliente
	HAVING COUNT(IDPedido) > 2
	ORDER BY numPedidos DESC



--15. Obtener los datos de los 4 productos de los que más unidades se han vendido, 
--visualizando el número de producto y las unidades vendidas
 
	SELECT TOP 4 IDProducto, SUM(Unidades) as unidadesVendidas
	FROM PEDIDOS
	GROUP BY IDProducto
	ORDER BY unidadesVendidas DESC
 

--16. Obtener el total de unidades por producto que hay entre todos los pedidos, 
-- visualizando el número de producto, la descripción y la suma de todas las unidades.
 
	SELECT P.IDProducto, PR.Descripcion, SUM(P.Unidades) AS Total_Unidades
	FROM PEDIDOS P
	JOIN PRODUCTOS PR ON P.IDProducto = PR.IDProducto
	GROUP BY P.IDProducto, PR.Descripcion;

 

--17. Obtener los salarios medios por departamento, ordenados descendentemente por dicho importe, 
-- cuando dichos salarios medios sean inferiores a 3000 euros
 
	SELECT ISNULL(CONVERT(VARCHAR(30),IDDepartamento),'Departamento sen nome') AS idDepartamento, AVG(salario) AS mediaSalario
	FROM EMPLEADOS
	GROUP BY IDDepartamento
	HAVING AVG(salario) < 3000
	ORDER BY mediaSalario DESC


--18. Obtener los salarios medios por DEPARTAMENTOS de los vendedores y cuántos hay en cada departamento, 
--siempre que ese salario medio sea mayor de 1.200
 
	SELECT ISNULL(CONVERT(VARCHAR(30),IDDepartamento),'Departamento sen nome') AS idDepartamento, AVG(salario) AS mediaSalario, COUNT(IDEmpleado) as numVendedores
	FROM EMPLEADOS
	WHERE Oficio = 'VENDEDOR'
	GROUP BY IDDepartamento
	HAVING AVG(salario) > 1200
	ORDER BY mediaSalario DESC


--19. Obtener el número de departamento con mayor salario medio de sus EMPLEADOS, 
--visualizando también el valor del salario medio correspondiente.
 
	SELECT TOP 1 IDDepartamento, AVG(Salario) AS Salario_Medio
	FROM EMPLEADOS
	GROUP BY IDDepartamento
	ORDER BY Salario_Medio DESC;

 

--20. Obtener aquellos IDs de productos de los que se ha realizado más de un pedido 
--con la fecha de pedido anterior a 1 de enero del 2017.
 
	SELECT IDProducto, COUNT(IDPedido) as numPedidos
	FROM PEDIDOS
	WHERE Fecha_pedido < '2017-01-01'
	GROUP BY IDProducto
	HAVING COUNT(IDPedido) > 1
	ORDER BY numPedidos DESC