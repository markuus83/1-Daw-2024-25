#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Vaise realiza un sorteo no que pode haber un número diferente de gañadores a partir dunhas rifas numeradas entre <1> e <9999>. Escribe un script que reciba por teclado o número de premios dispoñibles e imprima os números premiados co formato de 4 díxitos.
"""

__author__ = "Marcos Chouza Cruces"

import random

def calcular_numero_premios(num_premios: int) -> list:
    
    numeros_ganadores = []
    
    
    while len(numeros_ganadores) < num_premios:
        numero_aleatorio = random.randint(1, 9999)
        if numero_aleatorio not in numeros_ganadores:
            numeros_ganadores.append(numero_aleatorio)
    
    return numeros_ganadores

num_premios = int(input("Ingrese o número de premios dispoñibles: "))

numeros_ganadores = calcular_numero_premios(num_premios)
try:
    if num_premios < 9999:
        for numero in numeros_ganadores:
            print(f"{numero:04d}")
except ValueError:
    print("A cantidade de premios é maior que o número de rifas.")
        