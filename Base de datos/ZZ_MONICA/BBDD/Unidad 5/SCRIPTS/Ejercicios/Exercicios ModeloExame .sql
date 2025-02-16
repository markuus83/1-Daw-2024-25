
											------------------------ EJERCICIOS MODELO  EXAMEN 2� EVALUACION ------------------------ 

-- EJERCICIO 1 => Consulta con 4 columnas: el n�mero identificador, el nombre completo (apellido 1 apellido2, nombre), los d�as que lleva contratado en la empresa y la cuota de ventas, 
-- de cada uno de los empleados que est�n asignados a alg�n cliente. Si alg�n vendedor no tiene cuota asignada deber� aparecer un 0 en su lugar. En el resultado deben aparecer primero los empleados
-- que lleven menos d�as contratados.

USE EMPRESA_MarcosChouza;

	SELECT numero, 
			ape1 + ' ' + ISNULL(ape2, ' ')+ ' ' + nome AS nome_completo, 
			DATEDIFF(DAY, data_contrato, GETDATE()) AS dias_contratado,
			ISNULL(cota_de_vendas, 0)

	FROM EMPREGADO

	WHERE numero in (SELECT num_empregado_asignado
					FROM CLIENTE)

	ORDER BY dias_contratado;



-- EJERCICIO 2 => Consulta que devuelva la lista de los pedidos que hace m�s de 50 meses y menos de 60 meses que se han realizado. En el resultado deber� aparecer el n�mero del pedido y en una segunda columna la fecha
-- del pedido con formato dd-mm-aaaa (F�jate que se separan con guiones y ll�male FechaPared). Deben aparecer los pedidos m�s recientes primero. Aseg�rate que aparecen bien ordenados.

USE EMPRESA_MarcosChouza;

	SELECT numero, CONVERT(CHAR(10), data_pedido, 105) as Fecha_Pedido
	FROM PEDIDO 
	WHERE DATEDIFF(month, data_pedido, getdate()) BETWEEN 105 AND 115
	ORDER BY data_pedido DESC;


-- EJERCICIO 3 => Utiliza una consulta compuesta para obtener el c�digo de los productos de los que no se han hecho pedidos. En el resultado deben aparecer el identificador del fabricante y el del producto en una
-- �nica columna de nombre PRODUCTOS SIN PEDIDO, por ejemplo, aparecer� ASU4AK47A. El resultado deber� aparecer ordenado alfab�ticamente. 
-- IMPORTANTE: El nombre de la columna debe ser exactamente el que se indica, inclu�dos los espacios en blanco.




-- EJERCICIO 4 => Consulta que devuelva el nombre de cada uno de los empleados de la BD, su fecha de contrato con formato dd/mm/aaaa y en otra tercera columna el importe medio de los pedidos del empleado (o llamado
-- tambi�n vendedor).
-- Si existiese alg�n vendedor (empleado) que no ha vendido nada, en la columna del importe medio deber� aparecer la frase 'ESTE EMPLEADO NO TIENE PEDIDOS'.
-- Solo se mostrar�n los empleados cuyo pedido m�s caro no supere los 20000� de importe y que adem�s, hayan sido contratados un dia 1, 6 � 26 de cualquier mes y de cualquier a�o.
-- En la coluimna del importe se deber�n mostrar los importes con 8 d�gitos como m�ximo en la parte entera y 2 decimales.
-- Deber�n aparecer primero en el resultado los empleados con mayor importe medio. En caso de que hubiese varios empleados con el mismo importe medio, deber�n aparecer primero los que tienen mayor antig�edad
--en la empresa. Aseg�rate que aparecen bien ordenados.

USE EMPRESA_MarcosChouza;

	SELECT 
	FROM 


-- EJERCICIO 5 => Consulta que devuelva el 50% de los socios cuyo nombre de pila tiene por segunda letra una A y que pagan cuotas cuyo importe sea mayor o igual que 29 y menor o igual que 100. La consulta mostrar�
-- en 5 columnas el n�mero de socio, el nombre de pila, el primer apellido, el n�mero de caracteres del primer apellido, el nombre del mes en que naci� y el importe de la cuota que paga. El nombre del mes en que naci�+
-- y el importe de la cuota aparecer�n en una �nica columna separados por un gui�n (-). Esta columna se llamar� Mes-Nac-Cuota (con un gui�n en el medio).
-- El resultado deber� aparecer ordenado por mes de nacimiento, es decir, los de enero aparecer�n antes que los de febrero, los de febrero antes que los de marzo, y as� sucesivamente.
-- IMPORTANTE:
	-- Para resolver la b�squeda de la letra A en la segunda posici�n del nombre, deber�s emplear una funci�n integrada en el gestor. No puedes usar el predicado LIKE.
	-- Para hacer la comprobaci�n del importe de las cuotas que paga cada socio no puedes isar ni la cl�usula In, ni OR ni tampoco los operadores >=, >, <=, !=, =<>.