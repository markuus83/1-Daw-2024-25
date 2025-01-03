#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe un script que determine se unha cadea de texto introducida por teclado é un palíndromo. Un palíndromo é unha palabra ou frase que se lee da mesma maneira de esquerda a dereita que de dereita a esquerda, ignorando espazos e maiúsculas. Se é palíndromo mostrará por pantalla <É palíndromo> e se non o é <Non é palíndromo>.
"""

__author__ = "Marcos Chouza Cruces"

def conversion_palindromo(cadea: str) -> str:
    """
    Convertimos en minúsculas, dámoslle a volta e lle quitamos os espazos a cadea proporcionada polo usuario

    Args:
        cadea (str): Cadea de texto proporcionada polo usuario

    Returns:
        str: Cadea en minúscula, dada a volta e sen espazos
    """

    nova_cadea = cadea.lower()
    nova_cadea = nova_cadea.replace(" ", "")
    nova_cadea = nova_cadea[::-1]
    
    return nova_cadea

#Pedímoslle ao usuario que ingrese os datos
cadea = input("Ingrese unha cadea de texto: ")

#Almacenamos o valor da funcion nunha variable para mellorar a lexibilidade
nova_cadea = conversion_palindromo(cadea)

#Copiamos a cadea principal nunha nova cadea en minusculas e sen espazos
cadea2 = cadea.lower().replace(" ", "")

#Comezamos coa condicional e imprimimos por pantalla
if cadea2 == nova_cadea:
    print("É palíndromo")
else:
    print("Non é palíndromo")
