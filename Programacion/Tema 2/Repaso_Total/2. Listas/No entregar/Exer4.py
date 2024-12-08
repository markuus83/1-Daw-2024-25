""" 
Escribe unha función en Python <contar_lonxitudes(lista: List) -> List> que reciba unha lista de palabras de devolva unha lista coa lonxitude de cada palabra.
"""

def contar_lonxitudes(lista: list) -> list:
    
    nova_lista = []
    
    for elemento in lista:
        nova_lista.append(len(elemento))
        
    return nova_lista

lista = ['hola', 'me', 'llamo', 'marcos']

lista_lonxitude_palabras = contar_lonxitudes(lista)

print(f"A lonxitude de cada palabra da lista {lista} é: {lista_lonxitude_palabras}")