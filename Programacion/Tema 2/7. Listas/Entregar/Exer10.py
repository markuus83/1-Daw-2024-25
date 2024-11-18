#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
A ordenación burbulla é un algoritmo de ordenación simple pero ineficiente para listas pequenas. Funciona comparando elementos adxacentes na lista e intercambiándoos se están na orde incorrecta (é dicir, se o primeiro elemento é maior que o segundo). Este proceso repítese varias veces ata que toda a lista está ordenada.

Cada 'burbulla' (elemento grande) 'sube' ata a súa posición correcta, movéndose cara ao final da lista en cada pasada.

Escribe unha función en python <burbulla(lista: List) -> List> que implante o algoritmo de ordenación por burbulla para ordenar unha lsita de números de meno a maior.

    · o algoritmo funciona facendo múltples pasadas pola lista
    
    · O proceso repítese ata que a lista estea completamente ordenada
    
"""

__author__ = "Marcos Chouza Cruces"

def burbulla(lista: list) -> list:
    return lista
    
lista = [57, 31, 22, 43, 41, 5, 3, 10, 63, 1]

n = burbulla(lista)
print(n)