/****************************************************/
/********** CONSULTAS MULTITABLA ********************/
/****************************************************/

use a23marcoscc_BD_Almacen;

--1. Obtener un listado de clientes, indicando el número de cliente y su nombre, y el número y nombre de sus vendedores.
 
	SELECT c.IDCliente, c.Nombre nomeCliente, e.IDEmpleado, e.Nombre nomeEmpregado
	FROM CLIENTES c JOIN EMPLEADOS e
	ON c.IDComercial = e.IDEmpleado


--2. Listar todos los pedidos realizados con la descripción del producto y el nombre del cliente en lugar de sus números.
 
	SELECT c.Nombre nomeCliente, pr.Descripcion descProduto
	FROM PEDIDOS p JOIN PRODUCTOS pr
	ON p.IDProducto = pr.IDProducto
	JOIN CLIENTES c
	ON p.IDCliente = c.IDCliente
	
--3. Obtener una lista de los pedidos con la descripción del producto y el nombre del cliente de los clientes de MADRID.
 
 
	SELECT c.Nombre nomeCliente, pr.Descripcion descProduto
	FROM PEDIDOS p JOIN PRODUCTOS pr
	ON p.IDProducto = pr.IDProducto
	JOIN CLIENTES c
	ON p.IDCliente = c.IDCliente
	WHERE c.Localidad = 'MADRID'


--4. Visualizar el nombre del departamento, la fecha de alta, el apellido, el oficio y el nombre de localidad de aquellos trabajadores 
-- que están en un departamento ubicado en una localidad que no contenga ninguna C en su nombre.
 
	SELECT d.Nombre, e.FechaAlta, e.Nombre, e.Oficio, d.Localidad
	FROM DEPARTAMENTOS d JOIN EMPLEADOS e 
	ON d.IDDepartamento = e.IDDepartamento
	WHERE d.Localidad NOT LIKE '%C%'



--5. Obtener una lista de los nombres de los clientes con el importe acumulado de sus pedidos.
		
	SELECT C.Nombre AS Nombre_Cliente, SUM(P.Unidades * PR.PrecioActual) AS Importe_Acumulado
	FROM CLIENTES C	JOIN PEDIDOS P 
	ON C.IDCliente = P.IDCliente
	JOIN PRODUCTOS PR 
	ON P.IDProducto = PR.IDProducto
	GROUP BY C.Nombre
	ORDER BY Importe_Acumulado DESC;


--6. Obtener una lista de los pedidos con la descripción del producto y el nombre del cliente clasificados por el número del cliente.

	SELECT c.Nombre nomeCliente, pr.Descripcion descProduto
	FROM PEDIDOS p JOIN PRODUCTOS pr
	ON p.IDProducto = pr.IDProducto
	JOIN CLIENTES c
	ON p.IDCliente = c.IDCliente
	ORDER BY c.IDCliente



--7. Obtener los nombres de los EMPLEADOS y los nombres de sus DEPARTAMENTOS, 
--para aquellos EMPLEADOS que no son del departamento COMERCIALES y que entraron en la empresa después del 1 de enero de 82.


	SELECT e.Nombre nomeEmpregado, d.Nombre nomeDepartamento
	FROM EMPLEADOS e JOIN DEPARTAMENTOS d
	ON e.IDDepartamento = d.IDDepartamento
	WHERE d.Nombre <> 'COMERCIALES' AND e.FechaAlta > '1982-01-01'


--8. Obtener una lista de los nombres de los vendedores con el importe acumulado de sus pedidos.

	SELECT e.Nombre nomeEmpregado, SUM(p.Unidades * pr.PrecioActual) AS Importe_Acumulado
	FROM EMPLEADOS e JOIN CLIENTES c
	ON e.IDEmpleado = c.IDComercial
	JOIN PEDIDOS p
	ON c.IDCliente = p.IDCliente
	JOIN PRODUCTOS pr
	ON p.IDProducto = pr.IDProducto
	GROUP BY e.Nombre
	ORDER BY Importe_Acumulado DESC



--9. Realizar un listado de los EMPLEADOS cuyo oficio es EMPLEADO, que incluirá su id de empleado, el nombre y el salario anual,
-- sabiendo que el salario anual es el salario multiplicado por 14, e incluyendo en este listado el nombre del director del empleado.

	SELECT e.IDEmpleado, e.Nombre nomeEmpregado, e.Salario * 14 AS SalarioAnual, e2.Nombre nomeDirector
	FROM EMPLEADOS e JOIN EMPLEADOS e2
	ON e.Director = e2.IDEmpleado
	WHERE e.Oficio = 'EMPLEADO'



--10. Visualizar los productos con el número total de pedidos, las unidades totales vendidas, y el precio unidad de cada uno de ellos incluyendo los que no tienen pedidos (en este caso se mostrar? un 0 en el total unidades vendidas)


	SELECT pr.IDProducto, pr.Descripcion descProduto, COUNT(p.IDPedido) AS TotalPedidos, SUM(p.Unidades) AS UnidadesTotales, pr.PrecioActual
	FROM PRODUCTOS pr LEFT JOIN PEDIDOS p
	ON pr.IDProducto = p.IDProducto
	GROUP BY pr.IDProducto, pr.Descripcion, pr.PrecioActual
	ORDER BY pr.IDProducto


--11. Obtener el número de pedidos por producto, visualizando el número de producto, su descripción y el número de pedidos correspondiente.

	SELECT pr.IDProducto, pr.Descripcion descProduto, COUNT(p.IDPedido) AS TotalPedidos
	FROM PRODUCTOS pr LEFT JOIN PEDIDOS p
	ON pr.IDProducto = p.IDProducto
	GROUP BY pr.IDProducto, pr.Descripcion
	ORDER BY pr.IDProducto


--12. Visualizar los nombres de los clientes y la cantidad de pedidos realizados, incluyendo los que no hayan realizado ning?n pedido.

	SELECT c.Nombre nomeCliente, COUNT(p.IDPedido) AS TotalPedidos
	FROM CLIENTES c LEFT JOIN PEDIDOS p
	ON c.IDCliente = p.IDCliente
	GROUP BY c.Nombre
	ORDER BY c.Nombre


--13. Realizar un listado de todos los productos con su descripción y el importe total (unidades totales por el precio unidad) de cada uno de ellos. Deben mostrarse todos los productos incluidos los que no tiene pedidos y en este caso en importe total se mostrar? un 0.


	SELECT pr.IDProducto, pr.Descripcion descProduto, SUM(p.Unidades * pr.PrecioActual) AS ImporteTotal
	FROM PRODUCTOS pr LEFT JOIN PEDIDOS p
	ON pr.IDProducto = p.IDProducto
	GROUP BY pr.IDProducto, pr.Descripcion
	ORDER BY pr.IDProducto

--14. Visualizar los apellidos de los EMPLEADOS y el número de clientes que tienen, visualizando todos los EMPLEADOS de la empresa tengan o no clientes asignados


	SELECT e.Nombre nomeEmpregado, COUNT(c.IDCliente) AS TotalClientes
	FROM EMPLEADOS e LEFT JOIN CLIENTES c
	ON e.IDEmpleado = c.IDComercial
	GROUP BY e.Nombre
	ORDER BY e.Nombre