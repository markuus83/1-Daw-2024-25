""" 
Escribe nun script unha función <valor_maximo(dicionario: Dict[str, int]) -> List[str]> que devolva as chaves asociadas ao valor máximo nun diccionario. Devolve unha lista con todas as claves que teñan ese valor. Aquí tes un fragmento d código para probar a función.
"""

__author__ = "Marcos Chouza Cruces"


def valor_maximo(dicionario: dict[str, int]) -> list[str]:
    # Inicializar variables para o valor máximo e as claves asociadas
    max_valor = None
    claves_max = []

    # Iterar a través do diccionario
    for chave, valor in dicionario.items():
        if valor > max_valor:
            # Actualizar o valor máximo e reiniciar a lista de claves
            max_valor = valor
            claves_max = [chave]
        elif valor == max_valor:
            # Engadir a clave á lista se coincide co valor máximo
            claves_max.append(chave)

    return claves_max



dicionario = {'a': 5, 'b': 3, 'c': 5, 'd': 2}

print(valor_maximo(dicionario))
