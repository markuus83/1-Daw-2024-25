use a23marcoscc_BD_Almacen_Procedimientos;

--1. Crea una función que devuelva el siguiente número de departamento que se deberá asignar cuando se registre un nuevo 
--(que funcione como un autoincremento  para el IdDepartamento), es decir, cuando se llama a la función, 
--devolverá el máximo número de departamento existente en la tabla más 1.

	-- Observamos os diferentes ids
	SELECT IDDepartamento FROM DEPARTAMENTOS

	-- Comezamos a función
	CREATE OR ALTER FUNCTION dbo.siguienteNumDepartamento()
	RETURNS INT

		BEGIN

			DECLARE @v_maximo INT;

				SELECT @v_maximo = MAX(IDDepartamento )
				FROM DEPARTAMENTOS
			RETURN @v_maximo+10
		END;

	GO

	PRINT 'El siguiente id que se tendrá que usar será: '+CONVERT(VARCHAR(10),dbo.siguienteNumDepartamento())


--2. Crea una función que devuelva el nombre del jefe de un empleado. La función aceptará como parámetro 
--un número de empleado y buscará el nombre del jefe de ese empleado y devolverá ese valor.


	SELECT * FROM EMPLEADOS;

	CREATE OR ALTER FUNCTION dbo.nombreXefe(@id AS INT)
	RETURNS VARCHAR(30) AS
		BEGIN

			DECLARE @nomeXefe AS VARCHAR(30);

			SELECT @nomeXefe = x.Nombre
			FROM EMPLEADOS e JOIN EMPLEADOS x
			ON e.DIRECTOR = x.IDEmpleado
			WHERE @id = e.IDEmpleado

			return @nomeXefe
		END
	GO

	PRINT 'O nome do director do empregado con id -> "7521" é: '+convert(varchar(30),dbo.nombreXefe(7521));


-- 3. Modifica la función anterior para que en caso de que no encuentre un jefe válido devuelva el valor 
--“Jefe no encontrado”.


	CREATE OR ALTER FUNCTION dbo.nombreXefeModificado(@id AS INT)
	RETURNS VARCHAR(30) AS
		BEGIN

			DECLARE @nomeXefe AS VARCHAR(30);
			DECLARE @resposta AS VARCHAR(30);

				IF EXISTS (
					SELECT x.Nombre
					FROM EMPLEADOS e JOIN EMPLEADOS x
					ON e.DIRECTOR = x.IDEmpleado
					WHERE @id = e.IDEmpleado)

					BEGIN
						SELECT @nomeXefe = x.Nombre
						FROM EMPLEADOS e JOIN EMPLEADOS x
						ON e.DIRECTOR = x.IDEmpleado
						WHERE @id = e.IDEmpleado
					END
					
				ELSE
					BEGIN
						set @nomeXefe = 'Jefe no encontrado'
					END

			return @nomeXefe
		END
	GO

	SELECT * FROM EMPLEADOS;
	
	PRINT 'O nome do director do empregado con id->"7521" é: '+convert(varchar(30),dbo.nombreXefeModificado(7521))
	PRINT 'O nome do director do empregado con id->"1" é: '+convert(varchar(30),dbo.nombreXefeModificado(1))
	PRINT 'O nome do director do empregado con id->"7839" é: '+convert(varchar(30),dbo.nombreXefeModificado(7839))


-- 4. Desarrollar un procedimiento que visualice el apellido, 
--el nombre del jefe y la fecha de alta de todos los empleados ordenados por apellido. 
--Para mostrar el nombre del jefe deberá utilizar la función creada en el ejercicio 3.


	CREATE OR ALTER PROCEDURE pr_verJefe
	AS
		SELECT Nombre,dbo.nombreXefeModificado(idempleado) as nombreXefe, CAST(fechaalta as date) as fecha
		FROM EMPLEADOS
		

	EXEC pr_verJefe
--5. Escribir un programa que visualice el apellido y el salario de los cinco empleados 
--que tienen el salario más alto.


	CREATE OR ALTER FUNCTION dbo.mostrarDatos()
	RETURNS 


--6. Crea un procedimiento que acepte un número de departamento y devuelva
--mediante dos parámetros de tipo OUT PUT su nombre y localidad.





--7. Crea un procedimiento que acepte un número de departamento como argumento y 
--visualice todos los datos de los empleados que trabajan en ese departamento.





--8. Codifica un procedimiento que muestre el nombre de cada departamento y el número de empleados que tiene.





--9. Escribir un procedimiento que reciba una cadena y visualice el apellido 
--y el número de empleado de todos los empleados cuyo apellido contenga la cadena especificada. 
--Al finalizar mostrará el número de empleados incluidos en el listado.





--11. Crea un procedimiento que reciba como parámetro una localidad y cree 
--automáticamente 1 departamento en esa localidad con los siguientes valores:
	--a. número de departamento: será el valor devuelto por la función creada en el ejercicio 1
	--b. nombre: el nombre del departamento tendrá el formato departamento X, 
				--siendo X el valor asignado como número de departamento.
	--c. Localidad: se asignará el valor pasado como parámetro.












