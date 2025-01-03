#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe unha función en Python <contar_lonxitudes(lista: list) -> list> que reciba unha lista de palabras e devolva unha lista coa lonxitude de cada palabra.
"""

__author__ = "Marcos Chouza Cruces"

def contar_lonxitudes(lista: list) -> list:
    
    nova_lista = [] #Inicializamos unha nova lista baleira  
    
    for elemento in lista: #Recorremos cada elemento da lista el almacenamos a súa lonxitude na nova lista
        nova_lista.append(len(elemento))
    
    return nova_lista #Devolvemos a lista coas lonxitudes dos valores da primeira lista

lista = ["Marcos", "Hola", "alvaro", "Alejandra", "Silva"]
hola = contar_lonxitudes(lista)

print(hola)

