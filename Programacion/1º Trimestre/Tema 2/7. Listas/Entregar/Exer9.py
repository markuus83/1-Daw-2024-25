#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Vaise realiza un sorteo no que pode haber un número diferente de gañadores a partir dunhas rifas numeradas entre <1> e <9999>. Escribe un script que reciba por teclado o número de premios dispoñibles e imprima os números premiados co formato de 4 díxitos.
"""

__author__ = "Marcos Chouza Cruces"


#Importamos as librerias necesarias para o correcto funcionamento do código
import random 

def calcular_numero_premios(num_premios: int) -> list:
    
    """
    Calculamos o número das rifas que resultan premiadas

    Args:
        num_premios(int): Numero de rifas premiadas
    
    Raises:
        ValueError: Error de valor

    Returns:
        list: Devolve unha lista co número das rifas premiadas
    """
    
    #Capturamos un erro para cando o número de premios é maior ao número de rifas dispoñibles
    if num_premios > 9999:
        raise ValueError("A cantidade de premios é maior a cantidade total de rifas.")
    
    #Inicializamos unha lista vacía
    numeros_ganadores = []
    
    #Xerar e almacenar os números premiados
    while len(numeros_ganadores) < num_premios:
        
        numero_aleatorio = random.randint(1, 9999)
        
        if numero_aleatorio not in numeros_ganadores:
            numeros_ganadores.append(numero_aleatorio)
    
    return numeros_ganadores

#Lanzamos as excepcións dependendo do seu valor
try:
    
    #Pedímoslle ao usuario que ingrese os valores
    num_premios = int(input("Ingrese o número de premios dispoñibles: "))

    #Capturamos unha erro para cando o número de premios é menor a 0
    if num_premios < 0:
        raise ValueError("O numero de premios debe ser maior que 0")
    
    else:
        #Almacenamos o valor da función nunha variable para mellorar a lexibilidade do código
        numeros_ganadores = calcular_numero_premios(num_premios)

        #Damos a saída por consola 
        for numero in numeros_ganadores:
            print(f"{numero:04d}")
                
#Imprimimos posibles erros
except ValueError as erro:
    print(f"Erro: {erro}")
        