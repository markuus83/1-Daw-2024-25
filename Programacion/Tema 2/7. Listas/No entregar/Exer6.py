#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe unha función en Python <piramide(lonxitude: int)> que imprima unha pirámide de números. Esta recibe un enteiro que indica a lonxitude da pirámide.

Por exemplo se introducimos a lonxitude 5, imprimirase:

    1
    1 2
    1 2 3 
    1 2 3 4
    1 2 3 4 5

Utiliza a funcion range()
"""

__author__ = "Marcos Chouza Cruces"


def piramide(lonxitude):
    # Bucle exterior para cada fila
    for i in range(1, lonxitude + 1):
        # Bucle interior para imprimir los números en cada fila
        fila = ""
        for j in range(1, i + 1):
            fila += str(j) + " "
        fila = fila[:-1] # Quitamos o ultimo espazo en branco
        print(fila)  # Para pasar a la siguiente línea después de 
    

lonxitude = int(input("Ingrese a lonxitude da pirámide: "))

n = piramide(lonxitude)
print(n)