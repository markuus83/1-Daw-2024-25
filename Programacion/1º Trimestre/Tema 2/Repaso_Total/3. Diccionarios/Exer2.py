""" 
Escribe nun script unha función <valor_maximo(dicionario: Dict[str, int]) -> List[str]> que devolva as chaves asociadas ao valor máximo nun diccionario. Devolve unha lista con todas as claves que teñan ese valor. Aquí tes un fragmento d código para probar a función.
"""

__author__ = "Marcos Chouza Cruces"


def valor_maximo(diccionario: dict[str, int]) -> list[str]:

    lista = []
    maximo_valor = None
    
    for clave, valor in diccionario.items():

        if maximo_valor is None or maximo_valor<valor:
            lista = [clave]
            
        elif maximo_valor == valor:
            lista.append(clave)

    return lista


diccionario = {'a': 5, 'b': 3, 'c': 5, 'd': 2}

maximo_valor = valor_maximo(diccionario)
print(maximo_valor)
