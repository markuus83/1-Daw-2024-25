#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe un script en python que conte o número de vogais nunha cadea de texto introducida por teclado. Por último imprimirá por pantalla o número de vogais. Recorda contar tanto as maiúsculas como as minúsculas.
"""
__author__ = "Marcos Chouza Cruces"

vocales = "aeiouAEIOU"

def comprobar_vocais (cadea: str) -> int:
    
    if cadea is not str:
        raise ValueError "Erro. Ingrese unha cadea de texto."
    
    contador = 0
    for vocales in cadea:
        contador += 1
    return

cadea = str(input("Ingrese un texto: "))
