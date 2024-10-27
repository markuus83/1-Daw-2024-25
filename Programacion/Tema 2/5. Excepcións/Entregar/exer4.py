#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe unha función <raiz_cadrada(numero: float/int) -> float> nun script que calcule a raíz carada dun número. Se o parámetro non é un número ou é negativo, lanza unha excepción chamada <ValueError>. O propio script debe recibir un número por parte do usuario e calcula a raíz cadrada dese número utilizando a función creaca anteriormente. Captura a excepción que lanza función.
"""
__author__ = "Marcos Chouza Cruces"

def raiz_cadrada(numero: float) -> float:
    """
    Calcula a raíz cadrada dun número.
    
    Args:
        numero (float): Número do cal se quere calcular a raíz cadrada.
        
    Returns:
        float: Valor do return
    """
    if numero < 0:
        return None
    
    return numero ** 0.5

# Pedimos ao usuario que ingrese os datos
entrada = input("Introduce un número para calcular a súa raíz cadrada: ")

# Convertimos a entrada e comprobamos se é un valor numérico válido
try:
    numero = float(entrada)
    resultado = raiz_cadrada(numero)
    
except ValueError:
    print("Erro: Debes introducir un valor numérico válido.")
    
else:
    # Verificamos se o número é positivo
    if resultado is None:
        print("Erro: Debes introducir un número positivo.")
    else:
        print(f"A raíz cadrada de {numero} é {resultado}.")
