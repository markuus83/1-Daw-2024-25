""" 
Escribe unha función en Python <coller_comúns(lista1: List, lista2: List) -> List> que reciba dúas listas e devolva unha lista cos elementos comúns.
"""
__author__ = "Marcos Chouza Cruces"

def coller_comuns(lista1: list, lista2: list) -> list:
    
    nova_lista = []
    
    for elemento in lista1:
        if elemento in lista2:
            nova_lista.append(elemento)
    
    return nova_lista

lista1 = [1,2,3,4,5,6,7,8,9,10]
lista2 = [2,4,6,8,10]

comuns =coller_comuns(lista1, lista2)

print(f"Os elementos comúns son: {comuns}")