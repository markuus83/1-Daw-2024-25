#!/usr/bin/env python
# -*- coding: utf-8 -*-

#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe unha función <raiz_cadrada(numero: float/int) -> float> nun script que calcule a raíz cadrada dun número. Se o parámetro non é un número ou é negativo, lanza unha excepción chamada <ValueError>. O propio script debe recibir un número por parte do usuario e calcula a raíz cadrada dese número utilizando a función creada anteriormente. Captura a excepción que lanza a función.
"""
__author__ = "Marcos Chouza Cruces"

def raiz_cadrada(numero) -> float:
    """
    Calcular a raíz cadrada dun número.

    Args:
        numero (float): Número a calcularlle a raíz cadrada.

    Returns:
        float: Raíz cadrada do número.

    Raises:
        ValueError: Se o número é negativo ou non numérico.
    """
    
    # Comprobar se o número é do tipo correcto (int ou float)
    if not (type(numero) is int or type(numero) is float):
        raise ValueError("Erro. O valor ingresado non é numérico.")
    
    # Intento de conversión a float
    try:
        numero = float(numero)  
    except ValueError:
        raise ValueError("Erro. O valor ingresado non é numérico.")
    
    # Comprobar se o número é negativo
    if numero < 0:
        raise ValueError("Erro. O valor ingresado é negativo.")
    
    return numero ** 0.5


# Solicitud de datos por teclado
ingresar = input("Ingrese un número positivo: ")

try:
    # Llamada a la función para calcular la raíz cuadrada
    resultado = raiz_cadrada(ingresar)
    
except ValueError as erro:
    print(f"Erro: {erro}")
    
else:
    print(f"A raíz cadrada de {ingresar} é {resultado}.")
