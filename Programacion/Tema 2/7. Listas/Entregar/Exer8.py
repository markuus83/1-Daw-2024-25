#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Crea un script que pida as notas dun exame dos alumnos dunha clase para procesalos. Tódalas notas téñense que ir almacenando nunha lista. Mostra un menú que se amose continuamente ata que o usuario seleccione a opción saír. As entradas do menú son:

    a) Engadir nota
    b) ver media
    c) Ver número de aprobados
    d) Ver máxima nota
    e) Eliminar nota -> Primeiro debes de mostrar o menú onde mostres por cada índice da lista a súa nota. O usuario indicará o índice da nota a eliminar.
    f) Saír
    
Para poder realizar cada acción do menú, implanta as seguintes funcións:

    · <engadir_nota(lista: list[float], nota: float)>
    
        - Comproba que a lista sexa unha lista, senón lanza a excepción ValueError.
        - Se a nota é un valor invñalido, lanza a expeción ValueError.
        
    · <mostrar_notas(lista: list[float])>
    
        - Comproba que a lista sexa unha lista, senón lanza a excepción ValueError.
        - Débese mostrar neste formato: indice: nota
        
            #################
            #   0 : nota1   #
            #   1 : nota2   #
            #################
            
    · <media_notas(lista: list[float]) -> float>

        - Comproba que a lista sexa unha lista, senon lanza a excepción ValueError.
        
    · <numero_aprobados(lista list[float]) -> int>
    
        - Comproba que a lista sexa unha lista, senón lanza excepción ValueError.
        
    · <maxima_nota(lista: list[float]) -> float>
    
        -Comproba que a lista sexa unha lista, senón lanza excepción ValueError.

    · <eliminar_nota(lista: list[float], indice: int)>
    
        - Comproba que a lista sexa unha lista, senñon lanza a excepción ValueError.
        
        - Se o índice non é válido lanza a excepción ValueError
    
IMPORTANTE: Non utilices para realizar estas duncións do sistema max, min, etc. realiza este cálculo iterando sobre a lista.
"""

__author__ = "Marcos Chouza Cruces"

def engadir_nota(lista: list[float], nota: float):
    return lista.append(nota)


def mostrar_notas(lista: list[float]):
    return


def media_notas(lista: list[float]) -> float:
    
    if type(lista) is not list:
        raise ValueError("O parámetro non é unha lista. (MEDIA)")

    suma = 0

    for nota in lista: #Calculamos a suma total de todos os elementos da lista
        suma += nota
    
        media = suma /len(lista)
        
    return media 


def numero_aprobados(lista: list[float]) -> int:
    return


def maxima_nota(lista: list[float]) -> float:
    return


def eliminar_nota(lista: list[float],indice: int):
    return


lista = []

while True: 
    print("\nPrema a opción desexada no menú.")
    print("\t a) Engadir nota: ")
    print("\t b) Ver media: ")
    print("\t c) Ver número de aprobados: ")
    print("\t d) Ver máxima nota: ")
    print("\t e) Eliminar nota: ")
    print("\t f) Saír")
    
    option = input(">")
    
    if option == 'a':
        nota = int(input("Ingrese unha nota: "))
        
        
    elif option == 'b':
        
        media = media_notas(lista)
        
    elif option == 'c':
        
        aprobados = numero_aprobados(lista)
        
    elif option == 'd':
        
        nota_maxima = maxima_nota(lista)
        
    elif option == 'e':
        
        indice = input("Ingrese o índice da nota a eliminar: ")
        eliminar_nota(lista,indice)
        
    else:
        print("Saíndo...")
        break
        