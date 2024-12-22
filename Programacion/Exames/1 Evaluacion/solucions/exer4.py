#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Os números de teléfono completos teñen o seguinte formato: `+prefixo-número-extensión`. 
Por exemplo: +34-913724710-56. Tanto o prefixo, número e extensión poden ter un número variable de cifras.

Escribe unha función que reciba como parámetro un número de telefono, e devolva verdadeiro se o parámetro ten formato válido de teléfono ou falso en caso contrario.

"""

__author__ = "Manuel Ramón Varela López"

def son_cifras_numericas(cadea):
    """
    Indica se nunha cadea só hai cifras numéricas

    Args:
        cadea (str): A cadea a comprobar

    Returns:
        boolean: Verdadeiro se son só cifras numéricas, falso en caso contrario
    """
    if type(cadea) is not str:
        return False
    if len(cadea) == 0:
        return False
    for cifra in cadea:
        if cifra > "9" or cifra < "0":
            return False
    return True

def comprobar_numero(numero):
    """
    Comproba se unha cadea e un número co formato +prefixo-número-extensión

    Args:
        numero (str): A cadea a comprobar

    Raises:
        ValueError: Se o parámetro non é unha cadea

    Returns:
        boolean: Verdadeiro se cumpre co formato, falso en caso contrario
    """

    # Comprobamos o tipo de datos
    if type(numero) is not str:
        raise ValueError
    
    # Comprobamos que haxa o índice 0 e sexa un +
    if len(numero) == 0:
        return False
    if numero[0] != "+":
        return False
    
    # Collemos o resto da cadea
    numero = numero[1:]
    if "-" not in numero:
        return False
    i = numero.index("-")

    # Comprobamos o prefixo
    prefixo = numero[:i+1]
    if not son_cifras_numericas(prefixo):
        return False
    
    # Collemos o resto da cadea
    numero = numero[i+1:]
    if "-" not in numero:
        return False
    i = numero.index("-")

    # Comprobamos o numero
    n_telefono = numero[:i+1]
    if not son_cifras_numericas(n_telefono):
        return False
    
    # Collemos o resto da cadea
    extension = numero[i+1:]
    if not son_cifras_numericas(extension):
        return False
    
    return True

    


