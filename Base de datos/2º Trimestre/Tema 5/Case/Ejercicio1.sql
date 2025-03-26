
use a23marcoscc_BD_EMPRESA;

-- 1. Descrición e existencias dos produtos. Na terceira columna porá: 
    -- Suficientes se existencias son máis de 20
    -- Insuficientes se existencias son menos ou iguais a 20
	SELECT	descricion, 
			existencias, 
			"tipoExistencias" = CASE
									WHEN existencias > 20 THEN 'Suficientes'
									WHEN existencias <= 20 THEN 'Insuficientes'
									END
	FROM PRODUTO





-- 2. Sacar un listado con el identificador de pedido, descripcion del producto, importe total
-- del pedido y su clasificación según:
--	Si la cantidad de unidades demandada es > 20 then 'Grande'
-- 	Si la cantidad de unidades demandada es < 20 y cantidade > 10 then 'Normal'
-- 	Si la cantidad de unidades demandada es es < 10 y cantidade > 0 yhen 'Pequeño'
-- En otro caso ponga Erro

	SELECT pe.numero, pr.descricion, pr.prezo, "clasificacion" = 
			CASE
				WHEN cantidade > 20 THEN 'Grande'
				WHEN cantidade < 20 and cantidade > 10 THEN 'Normal'
				WHEN cantidade < 10 and cantidade > 0 THEN 'Pequeño'
				ELSE 'Erro'
			END

	FROM PRODUTO pr JOIN pedido pe
	ON pr.identificador = pe.id_produto
	

-- 6. Numero, nombre completo (los 4 campos en una unica columna, de nombre socio, con el formato numero - ape1 ape2, nombre) y salario de todo el profesorado. 
--En el resultado deberan aparecer primero los que mas cobran. 
--El campo cargo contiene PRF para el profesorado, y ADM si es un o una administrativa.

	SELECT CONVERT(VARCHAR(10), numero) + '   -   ' + ape1 + '    ' + ISNULL(ape2,'') + ',   ' + nome AS datos_Empregado, 
			salario_mes AS salario, 
			"cargo" = case 
				WHEN cargo LIKE 'PRF' THEN 'Profesorado'
				WHEN cargo LIKE 'ADM' THEN 'Administrativa'
				ELSE 'Erro'
			END
	FROM EMPREGADO
	ORDER BY salario_mes DESC
