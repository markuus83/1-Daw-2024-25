#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe unha función en Python <contar_lonxitudes(lista: list) -> list> que reciba unha lista de palabras e devolva unha lista coa lonxitude de cada palabra.
"""

__author__ = "Marcos Chouza Cruces"

def contar_lonxitudes(lista: list) -> list:
    
    nova_lista = []
    
    for elemento in lista:
        nova_lista.append(len(elemento))
    
    return nova_lista

lista = ["Marcos", "hola", "alvaro", "Alejandra", "silva"]
hola = contar_lonxitudes(lista)

print(hola)