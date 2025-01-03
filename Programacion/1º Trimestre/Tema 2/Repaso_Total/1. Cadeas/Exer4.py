#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un *script* en Python que conte o número de palabras nunha cadea de texto introducida por teclado e o mostre por pantalla. 
Considera que as palabras están separadas por un ou máis espazos. 
Coidado cos dobres, triples ou máis espazos e cos espazos ao comezo e o final do texto.
"""

__author__ = "Marcos Chouza Cruces"

def contar_palabras(texto:str) -> int:

    texto = texto.strip(" ")
    nova_cadea = texto.split()

    return len(nova_cadea)

texto = input("Introduce un texto para contar su número de palabras: ")

# Quitamos se hai varios espazos e sustituimolos por un solo,

numero_palabras = contar_palabras(texto)
print(f"O número de palabras é: {numero_palabras}.")