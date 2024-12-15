""" 
Escribe unha función en Python <piramide(lonxitude: int)> que imprima unha piramide de números. Esta recibe un enteiro que indica a lonxitude da pirámide.
utiliza a función range().
"""

def piramide(lonxitude: int) -> list:
    
    if lonxitude <=0:
        raise ValueError('A lonxitude da lista non cumple cos parámetros axeitados.')
    
    filas = lonxitude + 1           #Almacenamos o número de filas nunha variable
    
    for i in range(1, filas):       #Calcular o número de filas
        
        for j in range(1, i + 1):   #Calcular o número de ocos na fila
            
            print(j, end =" ")      #Encher as filas con números
            
        print()                     #Salto de línea
        
    
lonxitude = int(input("Ingrese a lonxitude da pirámide: "))

try:
    piramide(lonxitude)
    
except ValueError as erro:
    print(f"Erro: {erro}")