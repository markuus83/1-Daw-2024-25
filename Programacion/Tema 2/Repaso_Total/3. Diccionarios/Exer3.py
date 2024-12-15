""" 
Escribe nun script unha función <agrupar_datos_por_valor(dicionario: Dict[str, List[int]]) -> Dict[int, List[str]]> que reciba un diccionario onde os valores son listas e devolva un novo diccionario que agrupe as claves segundo os valores que teñen en común. Aquí tes un fragmento de código para probar a función.
"""

def agrupar_datos_por_valor(dicionario: dict[str, list[int]]) -> dict[int, list[str]]:
    
    return

dicionario = {'a': [1, 2], 'b': [2, 3], 'c': [1, 4]}
print(agrupar_datos_por_valor(dicionario))
# Saída esperada:
# {1: ['a', 'c'], 2: ['a', 'b'], 3: ['b'], 4: ['c']}