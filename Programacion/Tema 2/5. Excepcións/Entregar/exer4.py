#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe unha función <raiz_cadrada(numero: float/int) -> float> nun script que calcule a raíz carada dun número. Se o parámetro non é un número ou é negativo, lanza unha excepción chamada <ValueError>. O propio script debe recibir un número por parte do usuario e calcula a raíz cadrada dese número utilizando a función creaca anteriormente. Captura a excepción que lanza función.
"""

__author__ = "Marcos Chouza Cruces"

def raiz_cadrada(numero):

    """
    Calcular as excepcións dos datos ingresados por teclado

    Returns:
        numero: Numero a convertir
    """
    try:
        numero = float(numero)
    except ValueError:
        return None
    
    if numero < 0:
        return None
    
    return numero**0.5

# Pedímoslle ao usuario que ingrese os datos
entrada = input("Introduce un número para calcular a súa raíz cadrada: ")
resultado = raiz_cadrada(entrada)

# Comezamos cas estruturas condicionais que darán a saída por pantalla
if resultado is None:
    print("Erro: Debes introducir un número positivo.")
else:
    print(f"A raíz cadrada de {entrada} é {resultado}.")
