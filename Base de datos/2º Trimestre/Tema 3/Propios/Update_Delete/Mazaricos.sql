use a23marcos_Mazaricos;


-- Ejercicios de FK BD Mazaricos


--1.- Modificar la clave de un departamento que tenga empleados.

	
	SELECT * FROM DEPARTAMENTO;
	SELECT * FROM EMPLEADO;
	

	UPDATE DEPARTAMENTO
	SET Cod_Dept = 'SS'
	WHERE Cod_Dept = 'PR';
	
	
	SELECT * FROM DEPARTAMENTO;
			

-- Comprobar la repercusion en empleado y explicar la razon.
	SELECT * FROM EMPLEADO		
	
	---------------------------- SOLUCIÓN ---------------------------- 
	-- Observamos que dous dos empregados cambiaron o seu Cod_Dept en función do asignado previamente


--2.- Borrar una categoria que tenga empleados. Teníamos 

	SELECT * FROM CATEGORIA;
	
	
	DELETE FROM CATEGORIA
	WHERE Nome_Cat = 'Tecnico';
	
	
	SELECT * FROM CATEGORIA

-- Comprobar la repercusion en eMpleado

	SELECT * FROM EMPLEADO;

	---------------------------- SOLUCIÓN ---------------------------- 
	-- Observamos que os empregados que traballan nesa categoría agora teñen valor NULL en diferentes campos -> Horas_Extr

--3.- Modificar un cliente.

	SELECT * FROM CLIENTE;
	
	
	UPDATE CLIENTE
	SET CIF = '11111111B'
	WHERE CIF = 'A11111111';


	SELECT * FROM CLIENTE;
	
	
-- Comprobar la repercusion en aplicacion

	SELECT * FROM APLICACION;
	
	---------------------------- SOLUCIÓN ---------------------------- 
	-- Observamos como cambiou o CIF de distintas aplicacions.


--4.- Borrar un cliente.
	SELECT * FROM CLIENTE;
	SELECT * FROM APLICACION;
	SELECT * FROM TRABALLA;
	
	
	DELETE FROM TRABALLA
	WHERE Cod_Aplic = 'Car1';
	
	DELETE FROM APLICACION
	WHERE CIF = 'A22222222';

	DELETE FROM CLIENTE
	WHERE CIF = 'A22222222';

-- Comprobar la repercusion en aplicacion.


	---------------------------- SOLUCIÓN ---------------------------- 
	-- Como non se especificou borrado en cascada con esta Foreign Key, temos de borrar valor a valor das tablas fillas para que se poda borrar.
	

--5.- Modificar una aplicacion.

	SELECT * FROM APLICACION;
		
	
	UPDATE APLICACION
	SET Cod_Aplic = 'acab'
	WHERE Cod_Aplic = 'Pro2';


--6.- Borrar una aplicacion.

	SELECT * FROM APLICACION;
	SELECT * FROM TRABALLA;
	
	DELETE FROM TRABALLA
	WHERE Cod_Aplic = 'Con1';
	
	DELETE FROM APLICACION
	WHERE Nome_Aplic = 'Xesti?n Empresa Construc.';


--7.- Modificar un trabador.

	SELECT * FROM EMPLEADO;
	
	UPDATE EMPLEADO
	SET Nome_Empreg = 'Nora Barandi'
	WHERE Nome_Empreg = 'Manolo Alvarez';
	
--8.- Borrar un trabajador.
	SELECT * FROM EMPLEADO;


	DELETE FROM EMPLEADO
	WHERE DNI = '11111111Z';