#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe nun script unha función <agrupar_datos_por_valor(diccionario: dict[str, list[int]]) -> dict[int, List[str]]> que reciba un diccionario onse os valores son listas e devolva un novo diccionario que agrupe as claves segundo os valoes que teñen en común. Aquí tes un fragmento de cósigo para probar a función.

    dicionario = {'a': [1, 2], 'b': [2, 3], 'c': [1, 4]}
    print(agrupar_datos_por_valor(dicionario))
    
    # Saída esperada:
    # {1: ['a', 'c'], 2: ['a', 'b'], 3: ['b'], 4: ['c']}
"""

__author__ = "Marcos Chouza Cruces"

def agrupar_datos_por_valor(diccionario: dict[str, list[int]]) -> dict[int, list[str]]:
    
    #Inicializamos un diccionario vacío onde gardaremos os novos datos
    dict_output = {}
    
    #Recorremos o diccionario sacando as chaves e os seus valores (neste caso unha lista)
    for clave, lista in diccionario.items():
        
        #Recorremos os números do valor da lista
        for numero in lista:
            
            #Se o número non existe no novo diccionario, engadímolo e coma calve, e a clave do anterior diccionario coma o seu valor
            if numero not in dict_output:
                dict_output[numero] = [clave]
                
            else:
                #Almacenamos os valores das claves do primeiro dicionario como valores nunhca lista que será o valor da clave
                dict_output[numero].append(clave)
    
    return dict_output
    
diccionario = {'a': [1, 2], 'b': [2, 3], 'c': [1, 4]}

dict_output = agrupar_datos_por_valor(diccionario)
print(dict_output)



