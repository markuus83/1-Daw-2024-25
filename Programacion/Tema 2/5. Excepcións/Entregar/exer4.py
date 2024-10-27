#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe unha función <raiz_cadrada(numero: float/int) -> float> nun script que calcule a raíz carada dun número. Se o parámetro non é un número ou é negativo, lanza unha excepción chamada <ValueError>. O propio script debe recibir un número por parte do usuario e calcula a raíz cadrada dese número utilizando a función creaca anteriormente. Captura a excepción que lanza función.
"""
__author__ = "Marcos Chouza Cruces"

def raiz_cadrada(numero: float) -> float:
    """
    Calcular a raíz cadrada dun número

    Args:
        numero (float): Número a calcularlle a raíz cadrada

    Returns:
        float: _description_
    """
    if numero < 0:
        return None
    
    return numero**0.5

ingresar = input("Ingrese un número enteiro positivo: ")

try:
    numero = float(ingresar)
    resultado = raiz_cadrada(numero)
    
except ValueError:
    print("Erro. O valor ingresado non é un número.")

else:
    if resultado is None:
        print("Erro. O valor ingresado é negativo.")
    else: 
        print(f"A raíz cadrada de {numero} é {resultado}.")