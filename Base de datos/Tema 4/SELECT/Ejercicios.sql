use a23marcoscc_empleados_2025;

-- Obtener por orden alfabético
select SALAR, NOMEM
from temple
WHERE SALAR >= (SELECT 0.6* MAX(SALAR) 
				FROM TEMPLE)
ORDER BY NOMEM;


--HALLAR LA MEDIA DEL NUMERO DE HIJOS DEL DEPARTAMENTO NUMERO 123

	SELECT AVG(NUMHI) AS Media_Numero_Hijos
	FROM TEMPLE
	WHERE NUMDE = 100;


--Hallar el numero de empleados de la empresa

	SELECT COUNT(NUMEM) AS Numero_empleados
	FROM TEMPLE

	SELECT COUNT(NUMEM) AS Numero_empleados, COUNT(DISTINCT EXTEL) AS Extensiones_Telefono
	FROM TEMPLE
	WHERE NUMDE = 112;


-- Hallar cuantos empleados hay cuya fecha de nacimiento sea ante
	SELECT COUNT(*)
	FROM TEMPLE
	WHERE fecna < '31-12-1929';


--Hallar el numero de empleados del departamento 112, cuantas comisiones distintas hay en él y la suma y media de sus comisiones

	SELECT COUNT(*) AS NumEmpleados, COUNT(DISTINCT COMIS) AS NumComisiones, SUM(COMIS) AS SumaComisiones, AVG(COMIS) AS MediaComisiones
	FROM TEMPLE
	WHERE NUMDE = 112;


--Hallar cuantas comisiones diferentes hay y el valor medio de todas las comisiones

	SELECT COUNT(DISTINCT COMIS) AS NumComis, AVG(COMIS) AS MediaComis
	FROM TEMPLE


--Hallar por departamentos la edad en años cumplidos del empleado mas viejo del departamento que tiene comision ordenado por numero de departamento

	SELECT NUMDE, YEAR(GETDATE())- YEAR(MIN(FECNA)) AS EmpleadoViejo
	FROM TEMPLE
	WHERE COMIS IS NOT NULL
	GROUP BY NUMDE
	ORDER BY 1
