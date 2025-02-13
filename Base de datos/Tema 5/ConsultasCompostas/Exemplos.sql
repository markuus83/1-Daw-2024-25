use a23marcoscc_BD_EMPRESA_XG;

SELECT e.numero numeroEmpregado, c.numero numeroCliente
FROM EMPREGADO e, CLIENTE c
WHERE e.numero = 105 AND c.numero > 1110


-- Los códigos de los empleados que trabajan en la sucursal 25

	SELECT e.numero
	FROM EMPREGADO e, SUCURSAL s
	WHERE s.identificador = 21

-- Identificador de la sucursal donde trabaja Lara

	select id_sucursal_traballa
	from EMPREGADO
	where nome = 'Lara'


	
	--Solucion 1
	SELECT id_sucursal_traballa, s.cidade
	FROM EMPREGADO e, SUCURSAL s
	WHERE nome = 'Lara' and e.id_sucursal_traballa = s.identificador

	--Solucion 2
	SELECT id_sucursal_traballa, s.cidade
	FROM EMPREGADO e JOIN SUCURSAL s
	ON nome = 'Lara' and e.id_sucursal_traballa = s.identificador