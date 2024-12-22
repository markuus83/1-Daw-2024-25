#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
A rima consonante é a que se produce entre dúos palabras cando as súas últimas letras coinciden a partir da vogal acentuada.

Escribe unha función que reciba dúas palabras e comprobe que existe rima consonante entre as dúas palabras. 
Supoñamos que a vogal acentuada nas dúas palabras é a última vogal.

A función devolverá verdadeiro se as palabras teñen un mínimo 5 letras e existe rima consonante entre elas, e falso en caso contrario.

Comproba o tipo de datos dos parámetros, así como que se os seus valores son válidos. En caso contrario lanza unha excepción `ValueError`. 
Recorda que unha palabra tan só pode estas formada por letras e non conter espazos.

"""

__author__ = "Manuel Ramón Varela López"


def comprobar_palabra(palabra):
    """
    Comproba que unha cadea de texto é unha única palabra

    Args:
        palabra (str): A cadea que desexamos comprobar

    Returns:
        boolean: Verdadeiro se é unha palabra, falso en caso contrario
    """
    if type(palabra) is not str:
        return False
    if " " in palabra:
        return False
    palabra = palabra.lower()
    for letra in palabra:
        if ord(letra) > 122 or ord(letra) < 97:
            return False
    return True 

def e_rima_consonante(palabra1, palabra2):
    """
    Indica se duas palabras teñen rima consonante

    Args:
        palabra1 (str): A primeira palabra
        palabra2 (str): A segunda palabra

    Raises:
        ValueError: Se os parámetros non son str ou non son unha única palabra

    Returns:
        boolean: Verdadeiro en caso de que teñan rima consonate, falso en caso contrario
    """

    # Comprobamos tipos
    if type(palabra1) is not str:
        raise ValueError
    if type(palabra2) is not str:
        raise ValueError
    
    # Comprobamos valores
    if not comprobar_palabra(palabra1):
        raise ValueError
    if not comprobar_palabra(palabra2):
        raise ValueError
    
    if len(palabra1) < 5 or len(palabra2) < 5:
        return False

    # Collemos as palabras ao revés
    palabra1_reverse = palabra1[::-1].lower()
    palabra2_reverse = palabra2[::-1].lower()

    # Collemos o indice da primeira vogal
    indice_vogal = None
    i = 0
    while i < len(palabra1_reverse):
        if palabra1_reverse[i] in ["a", "e", "i", "o", "u"]:
            indice_vogal = i
            break
    
    # Se non hai vogales, pois non riman
    if indice_vogal is None:
        return False
    
    # Comprobamos se coinciden as primeiras letras
    if palabra1_reverse[:indice_vogal+1] == palabra2_reverse[:indice_vogal+1]:
        return True
    else:
        return False
    