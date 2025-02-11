use a23marcoscc_BD_Empresa_2025;

--Seleccionamos a BD EMPRESA_XG
--USE EMPRESA_XG;

-- Enunciados consultas resumen.
--1. Media de unidades vendidas por vendedor.

    SELECT e.IDEmpleado, e.Nombre, AVG(p.UNIDADES) AS Media_Unidades_Vendidas
    FROM PEDIDOS p
    JOIN EMPLEADOS e ON p.IDCliente = e.IDEmpleado
-- Si los empleados son los vendedores
    GROUP BY e.IDEmpleado, e.Nombre;


--2. Prezo máis barato de produto, prezo máis caro,
--prezo medio, suma de todos os prezos 
--e número de produtos distintos existentes.
    SELECT
    MIN(PrecioActual) AS Precio_Minimo,
    MAX(PrecioActual) AS Precio_Maximo,
    AVG(PrecioActual) AS Precio_Promedio,
    SUM(PrecioActual) AS Suma_Total_Precios,
    COUNT(DISTINCT IDProducto) AS Numero_Productos
    FROM PRODUCTOS;


--3. Número de pedidos realizados polo cliente 1103.

    SELECT COUNT(*) AS Numero_Pedidos
    FROM PEDIDOS
    WHERE IDCliente = 1103;


--4. Número de pedidos realizados por cada cliente.

    SELECT IDCliente, COUNT(*) AS Numero_Pedidos
    FROM PEDIDOS
    GROUP BY IDCliente;


--5. Número de pedidos realizados por cada cliente
--só para os clientes que fixeran máis de 2 pedidos.

    SELECT IDCliente, COUNT(*) AS Numero_Pedidos
    FROM PEDIDOS
    GROUP BY IDCliente
    HAVING COUNT(*) > 2;


--6. Número de pedidos realizados por cada cliente
--só para os clientes que fixeran máis de 2 pedidos
--e que ademais teñen unha media de unidades 
--mercadas (cantidade) inferior a 10.

    SELECT IDCliente, COUNT(*) AS Numero_Pedidos
    FROM PEDIDOS
    GROUP BY IDCliente
    HAVING COUNT(*) > 2 AND AVG(UNIDADES) < 10;


--7. Cantidade total de sucursais que hai por rexión. 
--Aparecerá o nome da rexión e na mesma columna 
--separado por un guión, a cantidade de sucursais
--situadas nesa rexión.

    SELECT CONCAT(Localidad, ' - ', COUNT(IDDepartamento)) AS Region_Sucursales
    FROM DEPARTAMENTOS
    GROUP BY Localidad;