#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe unha función en python <eliminar_duplicados(lista: List) -> List> que reciba unha lista con elementos duplicados e devolva unha nova lista sen duplicados, mantendo a orde orixinal.
"""

__author__ = "Marcos Chouza Cruces"

def eliminar_duplicados(lista: list) -> list:
    nova_lista = []
    
    for elemento in lista:
        if elemento not in nova_lista:
            nova_lista.append(elemento)
    
    return nova_lista