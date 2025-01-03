#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe un script que pide ao usuario os coeficientes dunha ecuación de segundo grao e calcula a solución. Comproba se hai unha solución, dúas ou ningunha. Dependendo do caso, mostra as solucións que corresponda. Crea as seguintes funcións:

    · Unha función que calcule o discriminante:
        descriminante(a: float, b: float, c: float) -> float
    
    · Unha función que calcule o número de solucións: 
        numero_solucions(a: float, b: float, c: float) -> int. 
        
    Debe utilizar internamente descriminante().

    · Unha para calcular a solución cando esta é única: 
        solucion_unica(a: float, b: float) -> float


    · Unha para calcular as dúas solucións: 
        calcula_duas_solucions (a: float, b: float, c: float) -> (float, float).
        
    Esta debe devolver las dos soluciones. Debe utilizar internamente descriminante().
"""

__author__ = "Marcos Chouza Cruces"


def discriminante(a: float, b: float, c: float) -> float:
    """
    Devolve o discriminante da ecuación.

    Args:
        a (float): Primer coeficiente
        b (float): Segundo coeficiente
        c (float): Tercer coeficiente

    Returns:
        float: Valor do discriminante
    """
    return b**2 - 4*a*c

def numero_solucions(a: float, b: float, c: float) -> int:
    """
    Devolve o número de posibles solucións de ecuación, chamando previamente a funcion discriminante()

    Args:
        a (float): Primer coeficiente
        b (float): Segundo coeficiente
        c (float): Tercer coeficiente

    Returns:
        int: Cantidade de solucións
    """
    d = discriminante(a, b, c)
    if d > 0:
        return 2
    elif d == 0:
        return 1
    else:
        return 0

def solucion_unica(a: float, b: float) -> float:
    """
    Devolve o valor da ecuación cando ten unha única solución.

    Args:
        a (float): Primer coeficiente
        b (float): Segundo coeficiente

    Returns:
        float: Valor do produto final.
    """
    return -b / (2*a)

def calcula_duas_solucions(a: float, b: float, c: float) -> (float, float):
    """
    Devolve o valor cando a ecuación ten dúas posibles solucións.

    Args:
        a (float): Primer coeficiente
        b (float): Segundo coeficiente
        c (float): Tercer coeficiente

    Returns:
        float: Valor da primeira solución
        float: Valor da segunda solución
    """
    
    d = discriminante(a, b, c)
    
    n = d**0.5  
    x = (-b + n) / (2*a)
    y = (-b - n) / (2*a)
    return x, y

#Pedimoslle ao usuario que ingrese os datos
a = float(input("Ingrese o valor de A: "))
b = float(input("Ingrese o valor de B: "))
c = float(input("Ingrese o valor de C: "))

#Calculamos o número de posibles solucións 
num_sol = numero_solucions(a, b, c)

#Facemos o chamado as funcions dependendo do número de solucións e damos a saída por pantalla
if num_sol == 2:
    x, y = calcula_duas_solucions(a, b, c)
    print(f"A ecuación ten dúas solucións reais: {x} e {y}.")
    
elif num_sol == 1:
    x = solucion_unica(a, b)
    print(f"A ecuación ten unha única solución real: {x}.")
    
else:
    print("A ecuación non ten solucións reais.")
