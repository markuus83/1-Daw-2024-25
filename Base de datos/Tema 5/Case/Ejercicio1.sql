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
	