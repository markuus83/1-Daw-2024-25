""" 
queixos = ['Cheddar', 'Edam', 'Gouda']
numeros = [17, 123]

#for queixo in queixos:
#    print(queixo)


for i in range(len(numeros)):
    numeros[i] = numeros [i] * 2
    print(numeros)
    
"""


""" 
# enumerate()

lista = ['a' , 'b', 'c', 'd']

for i, v in enumerate(lista):
    print(f"Índice: {i}, Valor: {v}")
"""


"""
lista = ['mazá', 'plátano', 'laranxa', 'pera']

elemento = "laranxa"

if elemento in lista:
    indice = lista.index(elemento)
    print(f"O índice de {elemento} é: {indice}")
else:
    print(f"{elemento} non está na lista")
"""

nova_lista = [expresion for elemento in iterable if condicion]

numeros = [1, 2, 3, 4, 5, 6]
cadrados_pares = [x**2 for x in numeros if x % 2 == 0]
print(cadrados_pares) # Imprime: [4, 16, 36]