""" 
Escribe unha función en Python <eliminar_duplicados(lista: List) -> List> que reciba unha lsita con elementos duplicados e devolva unha nova lista sen duplicados, mantendo a orde orixinal.
"""

def eliminar_duplicados(lista: list) -> list:
    
    nova_lista = []
    
    for elemento in lista:
        if elemento not in nova_lista:
            nova_lista.append(elemento)
    
    return nova_lista

lista = [1, 2, 3, 3, 4, 5, 6, 6, 6, 7, 7, 8, 9, 10 , 10]

lista_sen_duplicados = eliminar_duplicados(lista)

print(f"A lista se duplicados é: {lista_sen_duplicados}")