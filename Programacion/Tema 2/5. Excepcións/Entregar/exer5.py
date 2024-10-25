#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe unha función <calcular_desconto_irpf(soldo_bruto: float/int, irpf: int) -> float> nun script o solfo bruto e o IRP en tanto por cen. Comproba que estes soud valores sin números, que o soldo é maiot que 0 e que o IRFP é un valor válido. Se algunha destas condición non se cumpre, lanza a excepción ValueError. O propio script deberá recibir estes datos por teclado, e utilizar a función creada para calcular o desconto do IRPF. captura a excepción que lanza a función.
"""

__author__ = "Marcos Chouza Cruces"

def calcular_desconto_irpf(soldo_bruto: float, irpf: int) -> float:
    """
    Capturar as excepcións á hora de aplicar o desconto do irpf ao soldo

    Args:
        soldo_bruto (float): soldo bruto a percibir
        irpf (int): porcentaxe de desconto a aplicar

    Returns:
        float: Valor da variable de retorno
    """
    
    try:
        soldo_bruto = float(soldo_bruto)
        irpf = float(irpf)
        
    except ValueError:
        return None
    
    if soldo_bruto <= 0 or not (0 <= irpf <= 100):
        return None
    
    desconto = soldo_bruto * (irpf / 100)
    return desconto

# Pedímoslle ao usuario que ingrese os datos
soldo_bruto = input("Introduce o soldo bruto: ")
irpf = input("Introduce o IRPF en tanto por cen: ")

# Outorgámoslle a unha variable o valor da función
desconto = calcular_desconto_irpf(soldo_bruto, irpf)

# Comezamos ca estrutura condicional que dará a saída por pantalla
if desconto is None:
    print("Erro: Os datos introducidos non son válidos. Asegúrate de que o soldo é maior que 0 e o IRPF está entre 0 e 100.")
else:
    print(f"O desconto do IRPF sobre o soldo bruto de {soldo_bruto}€ é {desconto}€.")
