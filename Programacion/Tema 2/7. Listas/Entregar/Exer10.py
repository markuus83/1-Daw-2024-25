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
    """
    Ordenamos a lista mediante o método Burbulla

    Args:
        lista (list): Lista a ordear

    Returns:
        list: Lista ordeada 
    """
    
    #Calculamos a lonxitude da lista
    lonxitude = len(lista)
    
    #Recorremos a lista indefinidas veces sempre e cando sexa necesario
    for burbulla in range(lonxitude - 1):
        
        # Igualamos unha variable a 'True' para ver se a lista xa se atopa ordenada previamente
        ordenado = True
        
        for indice in range(lonxitude - 1 - burbulla):
            
            # Establecemos a condición necesaria 
            if lista[indice] > lista[indice + 1]:
                ordenado = False

                #Sobreescribimos os valores para intercambiar os índices
                variable_auxiliar = lista[indice]
                lista[indice] = lista[indice + 1]
                lista[indice + 1] = variable_auxiliar

        #Rompemos o bubcle cando a lista xa se atope ordenada
        if ordenado:
            break
    
    return lista

# Ingresamos unha lista fixa con valores desordenados
lista = [1, 3, 5, 10, 22, 31, 41, 43, 57, 63]

# Almacenamos o valor da función nunha variable para mellorar a lexibilidade do código
lista_ordenada = burbulla(lista)

# Imprimimos a lista ordenada por consola.
print(f"A lista ordenada polo método BubbleSort é: {lista_ordenada}")
