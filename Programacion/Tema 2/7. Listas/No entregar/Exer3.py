#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe unha función en python <eliminar_duplicados(lista: List) -> List> que reciba unha lista con elementos duplicados e devolva unha nova lista sen duplicados, mantendo a orde orixinal.
"""

__author__ = "Marcos Chouza Cruces"

def eliminar_duplicados(lista: list) -> list:
    nova_lista = [] #Creamos unha nova lista
    
    for elemento in lista: #Recorremos cada elemento da nova lista creada
        if elemento not in nova_lista: #De non existir o elemento na nova lista, engadímolo
            nova_lista.append(elemento)
    
    return nova_lista #Devolvemos a nova lista sen duplicados

lista = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0]

n = eliminar_duplicados(lista)

print(n)