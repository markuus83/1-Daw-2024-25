""" 
Escribe unha función en Python <eliminar_duplicados(lista: List) -> List> que reciba unha lsita con elementos duplicados e devolva unha nova lista sen duplicados, mantendo a orde orixinal.
"""

def eliminar_duplicados(lista: list) -> list:
    
    nova_lista = []
    
    for numero in lista:
        if numero not in nova_lista:
            nova_lista.append(numero)
    
    return nova_lista

lista = [1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 3, 5, 7, 9]

sen_duplicados = eliminar_duplicados(lista)
print(f"A lista sen duplicados é: {sen_duplicados}")