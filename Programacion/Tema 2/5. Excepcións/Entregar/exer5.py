#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe unha función <calcular_desconto_irpf(soldo_bruto: float/int, irpf: int) -> float> nun script o soldo bruto e o IRP en tanto por cen. Comproba que estes dous valores son números, que o soldo é maior que 0 e que o IRFP é un valor válido. Se algunha destas condición non se cumpre, lanza a excepción ValueError. O propio script deberá recibir estes datos por teclado, e utilizar a función creada para calcular o desconto do IRPF. captura a excepción que lanza a función.
"""

__author__ = "Marcos Chouza Cruces"

def calcular_desconto_irpf(soldo_bruto: float, irpf: int) -> float:
    
    if soldo_bruto <= 0 or not (0 <= irpf <= 100):
        return None
    
    desconto = soldo_bruto * (irpf / 100)
    return desconto

soldo_bruto = input("Ingrese o soldo bruto a percibir: ")
irpf = input("Ingrese a porcentaxe de irpf a descontar")

try:
    soldo_bruto = float(soldo_bruto)
    irpf = float(irpf)
    desconto = calcular_desconto_irpf(soldo_bruto, irpf)
    
except ValueError:
    print("Erro. Os datos introducidos non son valores numéricos.")
    
else:

    if desconto is None:
        print("Erro: O soldo debe ser maior que 0 e o IRPF debe estar entre 0 e 100.")
        
    else:
        print(f"O desconto do IRPF sobre o soldo bruto de {soldo_bruto}€ é {desconto}€.")