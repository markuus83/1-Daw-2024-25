/****************************************************/
/********** CONSULTAS MULTITABLA ********************/
/****************************************************/

use a23marcoscc_BD_Almacen_25;

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





--7. Obtener los nombres de los EMPLEADOS y los nombres de sus DEPARTAMENTOS, 
--para aquellos EMPLEADOS que no son del departamento COMERCIALES y que entraron en la empresa después del 1 de enero de 82.





--8. Obtener una lista de los apellidos de los vendedores con el importe acumulado de sus pedidos.





--9. Realizar un listado de los EMPLEADOS cuyo oficio es EMPLEADO, que incluirá su id de empleado, el nombre y el salario anual,
-- sabiendo que el salario anual es el salario multiplicado por 14, e incluyendo en este listado el nombre del director del empleado.





--10. Visualizar los productos con el número total de pedidos, las unidades totales vendidas, y el precio unidad de cada uno de ellos incluyendo los que no tienen pedidos (en este caso se mostrar? un 0 en el total unidades vendidas)





--11. Obtener el número de pedidos por producto, visualizando el número de producto, su descripción y el número de pedidos correspondiente.




--12. Visualizar los nombres de los clientes y la cantidad de pedidos realizados, incluyendo los que no hayan realizado ning?n pedido.




--13. Realizar un listado de todos los productos con su descripción y el importe total (unidades totales por el precio unidad) de cada uno de ellos. Deben mostrarse todos los productos incluidos los que no tiene pedidos y en este caso en importe total se mostrar? un 0.




--14. Visualizar los apellidos de los EMPLEADOS y el número de clientes que tienen, visualizando todos los EMPLEADOS de la empresa tengan o no clientes asignados


 