""" 
Escribe unha función en Python <coller_comúns(lista1: List, lista2: List) -> List> que reciba dúas listas e devolva unha lista cos elementos comúns.
"""

def coller_comuns(lista1: list, lista2: list) -> list:
    
    nova_cadea = []
    
    for elemento in lista1:
        if elemento in lista2:
            nova_cadea.append(elemento)
    
    return nova_cadea

lista1 = [1,2,3,4,5,6,7,8,9,10, 'miau']
lista2 = [1,3,5,7,9, None, 'miau']

lista_comuns = coller_comuns(lista1, lista2)

print(f"Os comúns de ambas lista son: {lista_comuns}")