use a23marcoscc_BD_Almacen_Procedimientos;

--1. Crea una función que devuelva el siguiente número de departamento que se deberá asignar cuando se registre un nuevo 
--(que funcione como un autoincremento  para el IdDepartamento), es decir, cuando se llama a la función, 
--devolverá el máximo número de departamento existente en la tabla más 1.




--2. Crea una función que devuelva el nombre del jefe de un empleado. La función aceptará como parámetro 
--un número de empleado y buscará el nombre del jefe de ese empleado y devolverá ese valor.





-- 3. Modifica la función anterior para que en caso de que no encuentre un jefe válido devuelva el valor 
--“Jefe no encontrado”.





-- 4. Desarrollar un procedimiento que visualice el apellido, 
--el nombre del jefe y la fecha de alta de todos los empleados ordenados por apellido. 
--Para mostrar el nombre del jefe deberá utilizar la función creada en el ejercicio 3.





--5. Escribir un programa que visualice el apellido y el salario de los cinco empleados 
--que tienen el salario más alto.





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
