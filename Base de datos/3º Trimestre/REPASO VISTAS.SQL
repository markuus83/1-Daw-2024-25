USE ALMACEN_25C;
--- EJERCICIOS VISTAS ---
 

-- Crear una vista que nos de todos los datos de los empleados del departamento de Investigacion y
-- los datos del departamento
  
		--Vemos los datos de las tablas que queremos usar
		SELECT * FROM EMPLEADOS;
		SELECT * FROM DEPARTAMENTOS;

		--Creamos la vista
		CREATE VIEW v_datosEmpleado
		AS SELECT e.IDEmpleado, e.Nombre, e.Oficio, e.DIRECTOR, e.FechaAlta, e.Salario, e.Comision, e.IDDepartamento as IDDep, 
				d.IDDepartamento, d.Localidad, d.Nombre as nombreDepartamento
		FROM EMPLEADOS e JOIN DEPARTAMENTOS d
		ON e.IDDepartamento = d.IDDepartamento
		WHERE d.Nombre LIKE 'INVESTIGACION'

		--Vemos los datos de la vista
		SELECT * FROM v_datosEmpleado
  
  
-- Insertamos a traves de la vista creada un nuevo Investigador Lucía González con un sueldo de 2600 en el departamento 20
		
		--Vemos los datos de la vista antes de ingresar los nuevos datos
		SELECT * FROM v_datosEmpleado
		
		--Vemos los datos de las tablas que queremos usar
		SELECT * FROM EMPLEADOS;
		SELECT * FROM DEPARTAMENTOS;
		
		--Vemos las especificaciones de las tablas (emigrarán a la vista)
		EXEC sp_help EMPLEADOS
		EXEC sp_help DEPARTAMENTOS
		
		--Ingresamos datos en la vista
		INSERT INTO v_datosEmpleado(IDEmpleado, Nombre, Oficio, Salario, IDDep) VALUES(7950, 'LUCIA GONZALEZ', 'INVESTIGA', 2600, 20)
		
		-- Vemos la vista con los nuevos datos
		SELECT * FROM v_datosEmpleado;

-- Insertamos en la vista creada un nuevo Empleado Pepe D?az con un sueldo de 1000 en el departamento 10

		INSERT INTO v_datosEmpleado(IDEmpleado, Nombre, Oficio, Salario, IDDep) VALUES(7951, 'PEPE DÍAZ', 'EMPLEADO', 1000, 10)

	
		-- Vemos la vista con los nuevos datos
		SELECT * FROM v_datosEmpleado;
		
		/*
		Vemos como, al no cumplir con las especificaciones de la vista, me permite ingresar el nuevo empleado, pero no se ingresa en la vista, sino en la tabla que referencia
		
			EXPLICACIÓN:
		
			IDdepartamento 20 es distinto que departamento con nombre INVESTIGACION
		*/
-- Actualizamos el sueldo de los otros investigadores a 2800




-- Insertamos en la vista creada un nuevo Empleado, Pepe D?az, con un sueldo de 1000 en el departamento 10





-- Creamos una nueva Vista que muestra todos los datos de los empleados con los datos de sus departamentos 



   
-- Los comerciales no pueden ver los datos de los clientes de los otros Vendedores. 
-- Crear una vista de clientes para el empleado 'CALVO JUAN'




-- Insertar en la vista creada para JUAN CALVO un nuevo cliente, Peco Tecnolog?as de Santiago.




-- Crear una vista para los pedidos de los clientes de JUAN CALVO a�adiendo los datos del cliente





-- Crear una vista con la informaci?n de los comerciales cuyo director es el 7839 CON CHECK OPTION




-- Actualizar la comision de JUAN CALVOa 0.22.




-- Insertar un pedido de 2 mesas de despacho y 2 sillas bufalo para el nuevo cliente de juan 






/*
ACUERDATE DE BORRAR TODAS LAS VISTAS CREADAS PREVIAMENTE
*/