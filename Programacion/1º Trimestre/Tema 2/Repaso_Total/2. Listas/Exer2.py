""" 
Escribe unha función en Python <so_pares(lista: list) -> list> que reciba unha lista de números pares e devolva unha nova lsita que ocnteña só os números pares da lista orixinal
"""

__author__ = "Marcos Chouza Cruces"

def so_pares(lista: list) -> list:
    
    nova_lista = []
    
    for numero in lista:
        if numero % 2 == 0:
            nova_lista.append(numero)
    
    return  nova_lista

lista = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

pares = so_pares(lista)

print(f"OS números pares son: {pares}")