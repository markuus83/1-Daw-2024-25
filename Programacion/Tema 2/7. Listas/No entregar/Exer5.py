#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe unha función en Python <coller_comúns(lista1: List, lista2: List) -> List> que reciba dúas listas e devolva unha lista cos elementos comúns.
"""

__author__ = "Marcos Chouza Cruces"

def coller_comúns(lista1: list, lista2: list) -> list:
    
    nova_lista = [] #Inicializamos unha nova lista
    
    for elemento in lista1: #Recorremos os elementos da primeira lista
        if elemento in lista1 and elemento in lista2: #Establecemos que se hay un elemento na primeira lista e que dito elemento tamén está na segunda lista se almacene na nova lista
            nova_lista.append(elemento) 
    
    return nova_lista #Devolvemos unha nova lista cos valores que se repiten na primeira e segunda lista

lista1 = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, " "]
lista2 = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, " " , 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

n = coller_comúns(lista1, lista2)
print(n)

