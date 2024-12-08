""" 
Escribe unha función en Python <so_pares(lista: list) -> list> que reciba unha lista de números pares e devolva unha nova lsita que ocnteña só os números pares da lista orixinal
"""

__author__ = "Marcos Chouza Cruces"


def so_pares(lista: list) -> list:
    
    nova_lista = []
    
    for elemento in lista:
        if elemento %2 == 0:
            nova_lista.append(elemento)
    
    return nova_lista


lista = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

lista_pares = so_pares(lista)

print(f"A lsita de pares é: {lista_pares}")