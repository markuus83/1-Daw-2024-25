use a23marcos_mazaricos;

-- 1. Modificar la clave de un departamento que tenga empleados.
select * from DEPARTAMENTO
select * from EMPLEADO

	UPDATE DEPARTAMENTO
	SET Cod_Dept = 'SS'
	WHERE Cod_Dept = 'PR'


-- Comprobar la repercusión en empleado y explicar la razon.

	-- Ao modificar o Cod_Dept dun departamento que ten empregados, automáticamente, na táboa de empregados modificase o Cod_Dept no que traballa.


-- 2. Borrar una categoría que tenga empleados.
select * from CATEGORIA;
select * from EMPLEADO;

	delete from EMPLEADO
	where Cod_Cat = 'AN'
	
	delete from CATEGORIA
	where Cod_Cat = 'AN'

-- Comprobar la repercusión en empleado
	--Por restricción de Foreign Key no nos deja, por lo que primeros eliminamod dichos empleados, y después la categoría.



-- 3. Modificar un cliente.
select * from CLIENTE

	update cliente
	set CIF =  'Z00000000'
	WHERE CIF = 'A11111111'

-- Comprobar la repercusión en aplicación
	select * from APLICACION
	-- Los clientes tienen su CIF cambiado por el seleccionado

-- 4. Borrar un cliente.
select * from CLIENTE;

--Primero tenemos que ingresar los valores predeterminados a coger, puesto que es 'Delete Set Default'
insert into CLIENTE(Cif, Nome, Apellidos) values ('XXXXXXXXX','No tiene','No tiene');


delete from CLIENTE
where CIF = 'A22222222';

	-- Comprobar la repercusión en aplicación
SELECT * FROM APLICACION;


-- 5. Modificar una aplicación.
select * from APLICACION;
select * from TRABALLA

	delete from TRABALLA
	where Cod_Aplic = 'Car1'

	update APLICACION
	set Cod_Aplic = '00AA'
	where Cod_Aplic = 'Car1'

select * from APLICACION;
select * from TRABALLA


--Volvemos ingresar os datos de traballa
    INSERT INTO TRABALLA VALUES ('Cart','Req1','11111111Z');
    INSERT INTO TRABALLA VALUES ('Cart','Req2','11111111Z');
    INSERT INTO TRABALLA VALUES ('Cart','Req1','22222222B');
    INSERT INTO TRABALLA VALUES ('Cart','Req1','33333333C');


-- 6. Borrar una aplicación.
select * from APLICACION

delete from APLICACION
where Cod_Aplic = '00AA';

select * from APLICACION


-- 7. Modificar un trabajador.
select * from EMPLEADO;

	UPDATE EMPLEADO
	set DNI = '123456789'
	where DNI = '12345678Z'

select * from EMPLEADO;


-- 8. Borrar un trabajador.

select * from EMPLEADO;

	delete from EMPLEADO
	where DNI = '123456789'

select * from EMPLEADO;