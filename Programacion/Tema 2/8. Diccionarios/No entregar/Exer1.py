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
    
    #Recorremos cada elemento da lista
    for elemento in lista:
        
        #Se o elemento non se atopa na lista, outorgámoslle por chave o seu nome e por valor 1
        if elemento not in diccionario:
            diccionario[elemento] = 1
            
        #Se o elemento sí que se atopa previamente na lista, aumentamos en un o seu valor
        else:
            diccionario[elemento] = diccionario[elemento] +1
            
    #Devolvemos o diccionario
    return diccionario


lista = ['hola', 'mazá', 'banana', 'mazá', 'laranxa', 'banana', 'mazá', 'mazá', 'laranxa', 'banana', 'hola', 'hola']

print(contar_frecuencia(lista))

#OUTPUT:

# {'hola': 3, 'mazá': 4, 'banana': 3, 'laranxa': 2}