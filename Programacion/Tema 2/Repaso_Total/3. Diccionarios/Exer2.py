""" 
Escribe nun script unha función <valor_maximo(dicionario: Dict[str, int]) -> List[str]> que devolva as chaves asociadas ao valor máximo nun diccionario. Devolve unha lista con todas as claves que teñan ese valor. Aquí tes un fragmento d código para probar a función.
"""

__author__ = "Marcos Chouza Cruces"


def valor_maximo(diccionario: dict[str, int]) -> list[str]:
    
    #Inicializamos unha nova lista
    nova_lista = []
    
    #Inicializamos unha variable con valor None
    maximo_valor = None
    
    #Iteramos o diccionario para sacar a súa cl
    for clave, valor in dicionario.items():
        
        if maximo_valor is None or maximo_valor < valor:
            
            maximo_valor == valor
            
            nova_lista = [clave]
            
        elif valor == maximo_valor:
            nova_lista.append(clave)
            

    return nova_lista



dicionario = {'a': 5, 'b': 3, 'c': 5, 'd': 2}

print(valor_maximo(dicionario))