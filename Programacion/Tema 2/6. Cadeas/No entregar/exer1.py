#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe un script en python que conte o número de vogais nunha cadea de texto introducida por teclado. Por último imprimirá por pantalla o número de vogais. Recorda contar tanto as maiúsculas como as minúsculas.
"""
__author__ = "Marcos Chouza Cruces"

vocales = "aeiouAEIOU"

def contar_vocales(cadea):
    if type(cadea) is not str:
        raise ValueError("Erro. Ingrese unha cadea de caracteres.")
    
    contador = 0
    for letra in cadea:
        if letra in vocales:
            contador += 1
            
    return contador

# Pedimos ao usuario que ingrese os datos
cadea = input("Ingrese unha cadea: ")

try:
    solucion = contar_vocales(cadea)
    print(f"O número de vocales é: {solucion}")
    
except ValueError as e:
    print(e)
