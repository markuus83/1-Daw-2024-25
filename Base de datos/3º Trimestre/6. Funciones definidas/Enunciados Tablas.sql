--1.-
-- Crear una funcion sobre la BD Sociedad Cultural que busque un empleado por su numero.
-- Si es Administrativo que nos de: numero, nif, nss, nome, ape1, ape2, tel_fixo, tel_mobil,
-- salario_mes, cargo y  si es Administrativo que nos diga su numero de horas extra o si es
-- profesor que nos diga su especialidad.


--2.-
-- Crear una funcion que dado un Id de Producto nos de todos los pedidos que hay realizados
-- con el siguiente formato:
-- Hacerlo con una funcion que recoja datos de tabla:
-- Esto sería del articulo de IdProducto = 10

		SELECT Idpedido, Unidades FROM dbo.prueba(10);  

				Idpedido	Unidades
				  1002		  4
				  1008		  6
				  1012		  3


--3.-
-- Esta función devuelve el numero y el nombre de pila o el nombre completo de los socios de -- la BD, según sea el valor del parámetro de entrada (dePila/completo).



--4.-
-- Crear una función que calcule las unidades vendidas de todos los productos
-- durante todos los meses de un año que se da como parametro.
