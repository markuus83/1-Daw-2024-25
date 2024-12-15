""" 
Escribe unha función en Python <contar_lonxitudes(lista: List) -> List> que reciba unha lista de palabras de devolva unha lista coa lonxitude de cada palabra.
"""

__author__ = "Marcos Chouza Cruces"

def contar_lonxitudes(lista: list)-> list:
    
    nova_lista=[]
    
    for elemento in lista:
        nova_lista.append(len(elemento))
    
    return nova_lista

lista = ["Marcos", "NoraBarandi" ,"Elena", "Lia"]
lonxitudes = contar_lonxitudes(lista)

print(f"A lonxitude de cada elemento da lista é: {lonxitudes}")