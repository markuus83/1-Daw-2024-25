#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe nun script unha función <contar_frecuencia(lista: List[str]) -> Dict[str, int]> que conte a frecuencia de cada palabra nunha lista de palabras. A función debe devolver un diccionario onde as chaves son as palabras e os valores son as frecuencias. Aquí tes un fragmento de código para probar dita función.

    lista_palabras = ['mazá', 'banana', 'mazá', 'laranxa', 'banana', 'mazá']

    print(contar_frecuencia(lista_palabras))
"""

__author__ = "Marcos Chouza Cruces"

def contar_frecuencia(lista: list[str]) -> dict[str, int]:

    #Inicializamos un diccionario vacío
    diccionario = {}
    
    #Recorremos os elementos da lista
    for elemento in lista:
        
        #para cada elemento do diccionario, aumentamos en un o seu valor
        if elemento in diccionario:
            diccionario[elemento] = diccionario[elemento] + 1
        
        #Se non se atopa nigún elemento da lista no diccionario, engádese con chave 1
        #Ao engadirse un novo elemento, dito elemento aumenta automáticamente a súa chave
        else:
            diccionario[elemento] = 1

    return diccionario


lista = ['mazá', 'banana', 'mazá', 'laranxa', 'banana', 'mazá', 'mazá', 'laranxa']

print(contar_frecuencia(lista))