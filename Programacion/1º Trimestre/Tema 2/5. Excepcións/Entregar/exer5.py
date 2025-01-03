#!/usr/bin/env python
# -*- coding: utf-8 -*-

#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe unha función <calcular_desconto_irpf(soldo_bruto: float/int, irpf: int) -> float> nun script o soldo bruto e o IRP en tanto por cen. Comproba que estes dous valores son números, que o soldo é maior que 0 e que o IRFP é un valor válido. Se algunha destas condición non se cumpre, lanza a excepción ValueError. O propio script deberá recibir estes datos por teclado, e utilizar a función creada para calcular o desconto do IRPF. captura a excepción que lanza a función.
"""

__author__ = "Marcos Chouza Cruces"

def calcular_desconto_irpf(soldo_bruto: float, irpf: float) -> float:
    """
    Calcular o desconto do IRPF baseado no soldo bruto e na porcentaxe de IRPF.

    Args:
        soldo_bruto (float): Soldo bruto ao que se aplicará o desconto.
        irpf (float): Porcentaxe do IRPF a aplicar.

    Returns:
        float: Cantidade de desconto do IRPF.

    Raises:
        ValueError: Se os valores non son numéricos, se o soldo bruto é menor ou igual a 0,
                     ou se o IRPF non está entre 0 e 100.
    """
    
    if not (type(soldo_bruto) is int or type(soldo_bruto) is float):
        raise ValueError("Erro: O soldo bruto debe ser un valor numérico.")
    
    if not (type(irpf) is int or type(irpf) is float):
        raise ValueError("Erro: O IRPF debe ser un valor numérico.")

    if soldo_bruto <= 0:
        raise ValueError("Erro: O soldo bruto debe ser maior que 0.")
    
    if not (0 <= irpf <= 100):
        raise ValueError("Erro: O IRPF debe estar entre 0 e 100.")
    
    desconto = soldo_bruto * (irpf / 100)
    return desconto


# Solicitud de datos por teclado
soldo_bruto = float(input("Ingrese o soldo bruto a percibir: "))
irpf = float(input("Ingrese a porcentaxe de IRPF a descontar: "))

try:
    # Llamada a la función para calcular el descuento de IRPF
    desconto = calcular_desconto_irpf(soldo_bruto, irpf)
    
except ValueError as erro:
    # Muestra el mensaje detallado de la excepción
    print(f"Erro: {erro}.")
    
else:
    print(f"O desconto do IRPF sobre o soldo bruto de {soldo_bruto}€ é {desconto}€.")