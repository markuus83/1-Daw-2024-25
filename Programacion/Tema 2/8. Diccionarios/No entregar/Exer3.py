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
    
    dic_output = {}
    
    for clave, valor in diccionario.items():
        for numero in valor:
            if not in dic_output:
                
    
    return
    
diccionario = {'a': [1, 2], 'b': [2, 3], 'c': [1, 4]}

for clave, valor in diccionario.items():
    print(f"{clave} : {valor}")


