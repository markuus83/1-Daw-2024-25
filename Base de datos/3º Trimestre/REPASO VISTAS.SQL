USE a23marcoscc_BD_Almacen_25;
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
		
			***** IDdepartamento 20 es distinto que departamento con nombre INVESTIGACION *****
		*/
-- Actualizamos el sueldo de los otros investigadores a 2800

		-- Vemos la vista
		SELECT * FROM v_datosEmpleado;

		-- Aplicamos los cambios
		UPDATE v_datosEmpleado
			SET Salario = 2800
			WHERE Oficio LIKE 'INVESTIGA'

		-- Observamos los cambios tanto en vista como en la tabla
		SELECT * FROM v_datosEmpleado;
		
		SELECT * 
		FROM EMPLEADOS
		WHERE Oficio LIKE 'INVESTIGA';
	
	

-- Creamos una nueva Vista que muestra todos los datos de los empleados con los datos de sus departamentos 

		CREATE VIEW v_datosEmpleadosDepartamentos
		AS 
			SELECT	e.IDEmpleado, e.Nombre, e.Oficio, e.DIRECTOR, e.FechaAlta, e.Salario, e.Comision, e.IDDepartamento as IDDep, 
					d.IDDepartamento, d.Localidad, d.Nombre as nombreDepartamento
			FROM EMPLEADOS e JOIN DEPARTAMENTOS d
			ON e.IDDepartamento = d.IDDepartamento

	   SELECT * FROM v_datosEmpleadosDepartamentos;
	   
   
-- Los comerciales no pueden ver los datos de los clientes de los otros Vendedores. 
-- Crear una vista de clientes para el empleado 'CALVO JUAN'
		
		-- Obtenemos el id del empleado con nombre 'CALVO JUAN'
		SELECT * FROM EMPLEADOS WHERE Nombre LIKE 'CALVO JUAN' -- ID -> 7844
	
		-- Creamos la vista con las especificaciones mandadas
		CREATE VIEW v_empleadoCalvoJuan
		AS 
			SELECT	c.*,
					e.IDEmpleado, e.Nombre AS nombreEmpleado, e.Oficio, e.Director, e.FechaAlta, e.Salario, e.Comision, e.IDDepartamento
			FROM CLIENTES c JOIN EMPLEADOS e
			ON c.IDComercial = e.IDEmpleado
			WHERE e.IDEmpleado = 7844
	
		--Observamos la vista
		SELECT * FROM v_empleadoCalvoJuan


-- Insertar en la vista creada para JUAN CALVO un nuevo cliente, Peco Tecnolog?as de Santiago.

		SELECT * FROM CLIENTES
		
		--Ingreamos el cliente en la vista con las especificaciones
		INSERT INTO v_empleadoCalvoJuan(IDCliente, Nombre, Localidad, IDComercial) VALUES(200, 'Peco Tecnologías', 'Santiago',7844)

		--Observamos los cambios
		SELECT * FROM v_empleadoCalvoJuan



-- Crear una vista con la informaci?n de los comerciales cuyo director es el 7839 CON CHECK OPTION

		-- Cremamos la vista
		CREATE VIEW v_informacionComerciales
		 AS 
			SELECT * 
			FROM EMPLEADOS e
			WHERE e.Director = 7839
			WITH CHECK OPTION

		-- Observamos la vista
		SELECT * FROM v_informacionComerciales

-- Actualizar la comision de JUAN CALVO a 0.22.

		UPDATE EMPLEADOS
		SET Comision = 0.22
		WHERE Nombre LIKE 'CALVO JUAN'

		SELECT * FROM EMPLEADOS
		SELECT * FROM v_datosEmpleado
		SELECT * FROM v_datosEmpleadosDepartamentos
		SELECT * FROM v_empleadoCalvoJuan
		SELECT * FROM v_informacionComerciales
		

-- Insertar un pedido de 2 mesas de despacho y 2 sillas bufalo para el nuevo cliente de juan 



		


/*
	ACUERDATE DE BORRAR TODAS LAS VISTAS CREADAS PREVIAMENTE
*/