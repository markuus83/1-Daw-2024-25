""" 
Escribe nun script unha función <contar_frecuencia(lista: List[str]) -> Dict[str, int]> que conte a frecuencia de cada palabra nunha lista de palabras. A función debe resover un diccionario onde as chaves son as palabras e eos valores son as frecuencias. Aquí tes un fragmento de código para probar dita función.
"""

__author__ = "Marcos Chouza Cruces"

def contar_frecuencia(lista: list[str]) -> dict[str, int]:
    
    #Inicializamos un diccionario baleiro
    diccionario = {}
    
    #Recorremos todos os elementos da lista
    for elemento in lista:
        
        #Se o elemento non se atopa no diccionario, engadímolo ca chave como o elemnto, e con valor numérico
        if elemento not in diccionario:
            diccionario[elemento] = 1
            
        #Se volve a atopar o mesmo elemento no diccionario, aumentamos en un o seu valor.
        else:
            diccionario[elemento] = diccionario[elemento] + 1
    
    return diccionario


lista = ['mazá', 'banana', 'mazá', 'laranxa', 'banana', 'mazá']

frecuencia = contar_frecuencia(lista)
print(f"{frecuencia}")