#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe unha función <calcular_desconto_irpf(soldo_bruto: float/int, irpf: int) -> float> nun script o solfo bruto e o IRP en tanto por cen. Comproba que estes soud valores sin números, que o soldo é maiot que 0 e que o IRFP é un valor válido. Se algunha destas condición non se cumpre, lanza a excepción ValueError. O propio script deberá recibir estes datos por teclado, e utilizar a función creada para calcular o desconto do IRPF. captura a excepción que lanza a función.
"""

__author__ = "Marcos Chouza Cruces"

def calcular_desconto_irpf(soldo_bruto: float, irpf: int) -> float:
    """
    Calcula o desconto do IRPF dado un soldo bruto e unha porcentaxe de IRPF.
    
    Args:
        soldo_bruto (float): Soldo bruto a percibir.
        irpf (int): Porcentaxe de desconto a aplicar.
        
    Returns:
        float: Valor do desconto de IRPF, ou None se os valores non son válidos.
    """
    
    if soldo_bruto <= 0 or not (0 <= irpf <= 100):
        return None
    
    desconto = soldo_bruto * (irpf / 100)
    return desconto

# Pedimos ao usuario que ingrese os datos
soldo_bruto = input("Introduce o soldo bruto: ")
irpf = input("Introduce o IRPF en tanto por cen: ")

# Convertimos a entrada e comprobamos se é un valor numérico válido
try:
    soldo_bruto = float(soldo_bruto)
    irpf = float(irpf)
    desconto = calcular_desconto_irpf(soldo_bruto, irpf)
    
except ValueError:
    print("Erro: Os datos introducidos non son válidos. Asegúrate de introducir valores numéricos.")
    
else:
    # Verificamos se o desconto foi calculado correctamente
    if desconto is None:
        print("Erro: O soldo debe ser maior que 0 e o IRPF debe estar entre 0 e 100.")
    else:
        print(f"O desconto do IRPF sobre o soldo bruto de {soldo_bruto}€ é {desconto}€.")
