#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe unha función en python <so_pares(lista. List) -> List> que reciba unha lista de números e devolva unha nova lista que conteña só os números pares da lista orixinal
"""

__author__ = "Marcos Chouza Cruces"

# Versión Propia
def so_pares(lista: list) -> list:
    return [x for x in lista if x % 2 == 0] #Mutamos a lista para que nos devolva únicamente os valores pares da propia

lista = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]

n = so_pares(lista)

print(n)