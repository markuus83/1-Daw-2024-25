/****************************************************/
/*************** SUBCONSULTAS ***********************/
/****************************************************/

use a23marcoscc_BD_Almacen;

--1. Listar los nombres y códigos de los DEPARTAMENTOS en los que haya EMPLEADOS.

    SELECT DISTINCT d.IDDepartamento, d.Nombre
    FROM DEPARTAMENTOS d
    WHERE EXISTS (
        SELECT 1 FROM EMPLEADOS e WHERE e.IDDepartamento = d.IDDepartamento
    );


--2. Listar los nombres y códigos de los DEPARTAMENTOS en los que no haya EMPLEADOS.
 
    SELECT d.IDDepartamento, d.Nombre
    FROM DEPARTAMENTOS d
    WHERE NOT EXISTS (
        SELECT 1 FROM EMPLEADOS e WHERE e.IDDepartamento = d.IDDepartamento
    );


--3-. Obtener los datos del pedido más reciente.
    SELECT * FROM PEDIDOS
    WHERE Fecha_pedido = (SELECT MAX(Fecha_pedido) FROM PEDIDOS);


--4. Pare el departamento de COMERCIAL, visualizar para cada Oficio la suma de los salarios de los EMPLEADOS
 
    SELECT e.Oficio, SUM(e.Salario) AS Total_Salarios
    FROM EMPLEADOS e
    JOIN DEPARTAMENTOS d ON e.IDDepartamento = d.IDDepartamento
    WHERE d.Nombre = 'COMERCIAL'
    GROUP BY e.Oficio;


--5. Obtener un listado con el número y nombre de los clientes atendidos por el vendedor con nombre 'CALVO'.
    SELECT c.IDCliente, c.Nombre
    FROM CLIENTES c
    JOIN EMPLEADOS e ON c.IDComercial = e.IDEmpleado
    WHERE e.Nombre = 'CALVO';
    

--6. Obtener un listado con los números de pedido, números de producto y fecha de los pedidos 
--realizados por el cliente con nombre 'EDICIONES SANZ'.
 
    SELECT p.IDPedido, p.IDProducto, p.Fecha_pedido
    FROM PEDIDOS p
    JOIN CLIENTES c ON p.IDCliente = c.IDCliente
    WHERE c.Nombre = 'EDICIONES SANZ';


--7. Visualizar los datos del producto más caro.
    SELECT * FROM PRODUCTOS
    WHERE PrecioActual = (SELECT MAX(PrecioActual) FROM PRODUCTOS);


--8. Obtener los vendedores(comerciales) con dos o más clientes asignados.
    SELECT e.IDEmpleado, e.Nombre
    FROM EMPLEADOS e
    JOIN CLIENTES c ON e.IDEmpleado = c.IDComercial
    GROUP BY e.IDEmpleado, e.Nombre
    HAVING COUNT(c.IDCliente) >= 2;

--9. Seleccionar aquellos EMPLEADOS cuyo salario sea menor a la media de los salarios de su departamento.
    SELECT e.*
    FROM EMPLEADOS e
    WHERE e.Salario < (
        SELECT AVG(e2.Salario)
        FROM EMPLEADOS e2
        WHERE e2.IDDepartamento = e.IDDepartamento
    );


--10. Obtener los nombres y las localidades de los clientes que tengan realizado pedidos.
 
    SELECT DISTINCT c.Nombre, c.Localidad
    FROM CLIENTES c
    JOIN PEDIDOS p ON c.IDCliente = p.IDCliente;


--11. Visualizar los vendedores con clientes que no tengan ningún pedido.
 
    SELECT DISTINCT e.IDEmpleado, e.Nombre
    FROM EMPLEADOS e
    JOIN CLIENTES c ON e.IDEmpleado = c.IDComercial
    WHERE NOT EXISTS (
        SELECT 1 FROM PEDIDOS p WHERE p.IDCliente = c.IDCliente
    );


--12. Conseguir el nombre y Oficios de los EMPLEADOS del departamento 10 cuyo Oficio sea idéntico al de cualquiera de los EMPLEADOS 
-- del departamento de COMERCIAL.

    SELECT e1.Nombre, e1.Oficio
    FROM EMPLEADOS e1
    WHERE e1.IDDepartamento = 10
    AND e1.Oficio IN (
        SELECT DISTINCT e2.Oficio
        FROM EMPLEADOS e2
        JOIN DEPARTAMENTOS d ON e2.IDDepartamento = d.IDDepartamento
        WHERE d.Nombre = 'COMERCIAL'
    );
	

--13. Seleccionar el departamento en el que trabaja el empleado con mayor salario, visualizando el nombre del departamento.

    SELECT d.Nombre
    FROM DEPARTAMENTOS d
    JOIN EMPLEADOS e ON d.IDDepartamento = e.IDDepartamento
    WHERE e.Salario = (SELECT MAX(Salario) FROM EMPLEADOS);


--14. Obtener los datos del producto con más unidades en los pedidos de los clientes.
 





