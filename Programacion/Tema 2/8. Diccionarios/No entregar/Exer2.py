#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe nun script unha función <valor_maximo(diccionario: dict[str, int]) -> list[str]> que devolva as chaves asociadas ao valor máximo nun diccionario. Devolve unha lista con todas as claves que teñan ese valor.
"""

__author__ = "Marcos Chouza Cruces"

def valor_maximo(diccionario: dict[str, int]) -> list[str]:
    
    #Inicializamos una nueva lsita vacía
    lista = []
    
    #Inicializamos una variable con valo None, donde almacenaremos el valor máximo de las claves del diccionario
    maximo_valor = None
    
    #Recorremos cada clave y su valor del diccionario
    for clave, valor in diccionario.items():
        
        #Se o valor 'maximo_valor' segue sendo None, ou é menor que calqueira outro valor do diccionario
        if maximo_valor is None or maximo_valor < valor:
            
            #Igualamos a variable 'maximo_valor' ao valor máximo do diccionario
            maximo_valor = valor
            
            #Iniciamos na lista a clave de dito valor
            lista = [clave]
        
        # Se existen mais claves con dito valor, almacenámolas na lista
        elif valor == maximo_valor:
            lista.append(clave)
            
    return lista

diccionario = {'a': 5, 'b': 3, 'c': 5, 'd': 2}

print(valor_maximo(diccionario))