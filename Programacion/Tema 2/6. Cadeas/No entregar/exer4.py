#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe un script en pyhton que conte o número de palabras nunha cadea de texto introducida por teclado e o mostre por pantalla. Considera que as palabras están separadas por un ou máis espazos. Coidado cos dobres, triples ou máis espazos ao comezo e ao final do texto.
"""
##################################################
# Pedir cadena     
# Quitarle los espacios del principio y del final
# Quitarle los espacios de por medio
# Medir longitud de la cadena final
##################################################

__author__ = "Marcos Chouza Cruces"

def eliminar_espazos_incial_final(cadea: str) -> str:
    c = cadea.strip()
    return c

def contar_palabras(c: str) -> str:
    return

cadea = input("Ingrese unha cadea de texto: ")

c = eliminar_espazos_incial_final(cadea)

print(f"A cadea final")