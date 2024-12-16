""" 
Escribe nun script unha función <agrupar_datos_por_valor(dicionario: Dict[str, List[int]]) -> Dict[int, List[str]]> que reciba un diccionario onde os valores son listas e devolva un novo diccionario que agrupe as claves segundo os valores que teñen en común. Aquí tes un fragmento de código para probar a función.
"""

def agrupar_datos_por_valor(diccionario: dict[str, list[int]]) -> dict[int, list[str]]:
    
    #inicializamos un diccionario vacío
    diccionario_output = {} 
    
    #Iteramos sobre el diccionario (clave y valor [lista] que contiene)
    for clave, lista in diccionario.items(): 
        
        #Iteramos sobre la lista del valor del diccionario
        for numero in lista:
            
            #Si el número no existe dentro del diccionario, lo añadimos como clave, y le agenciamos la clave del antiguo diccionario como valor (dentro de una lista)
            if numero not in diccionario_output:
                
                diccionario_output[numero] = [clave]
                
            #Si ya existe el número dentro  del nuevo diccionario, se añade la siguiente clave a la lista
            else:
                diccionario_output[numero].append(clave)
    
    return diccionario_output

diccionario = {'a': [1, 2], 'b': [2, 3], 'c': [1, 4]}

datos_agrupados = agrupar_datos_por_valor(diccionario)
print(datos_agrupados)


# Saída esperada:
# {1: ['a', 'c'], 2: ['a', 'b'], 3: ['b'], 4: ['c']}