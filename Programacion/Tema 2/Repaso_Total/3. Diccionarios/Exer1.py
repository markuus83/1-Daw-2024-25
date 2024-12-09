""" 
Escribe nun script unha función <contar_frecuencia(lista: List[str]) -> Dict[str, int]> que conte a frecuencia de cada palabra nunha lista de palabras. A función debe resover un diccionario onde as chaves son as palabras e eos valores son as frecuencias. Aquí tes un fragmento de código para probar dita función.
"""

__author__ = "Marcos Chouza Cruces"

def contar_frecuencia(lista: list[str]) -> dict[str, int]:
    
    diccionario = {}
    
    for elemento in lista:
        
        if elemento in diccionario:
            diccionario[elemento] = diccionario[elemento] + 1

        else:
            diccionario[elemento] = 1
            
    return diccionario


lista_palabras = ['mazá', 'banana', 'mazá', 'laranxa', 'banana', 'mazá']

print(contar_frecuencia(lista_palabras))