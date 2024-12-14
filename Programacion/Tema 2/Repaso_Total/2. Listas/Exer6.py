""" 
Escribe unha función en Python <piramide(lonxitude: int)> que imprima unha piramide de números. Esta recibe un enteiro que indica a lonxitude da pirámide.
utiliza a función range().
"""

def piramide(lonxitude: int):

    #Capturamos posibles erros
    if lonxitude <= 0:
        raise ValueError('Ingrese un número superior a 0.')

    #O primeiro bucle controla o número de filas necesarias
    for i in range (1, lonxitude + 1):

        #O segundo bucle imprime os números de cada fila
        for j in range(1, i +1):
            
            print(j, end=" ") #Imprime o número na mesma fila
        print()

lonxitude = int(input("Ingrese a lonxitude da pirámide: "))

try:

    piramide(lonxitude)

except ValueError as erro:
    print(f"Erro: {erro}")