""" 
Escribe un script que reciba un enteiro (n) maior ou igual a 1 e ofreza o resultado da seguinte suma: 1 + 1/2 + 1/3 + ... + 1/n
"""

__author__ = "Marcos Chouza Cruces"

#Pedímoslle ao usuario que ingrese un valor
numero = int(input("Introduce un número enteiro maior ou igual a 1: "))

#Inicializamos as variables necesarias
x = 1
suma = 0

#Establecemos unha condicion necesaria para o funcionamento do código
if numero >= 1:
    
    #Comezamos co bucle
    while x <= numero:
        suma += 1/x  
        x += 1 
        
    #Imprimimos a saída
    print(f"A suma total é: {suma}")
    
#Para posibles erros do programa
else: 
    print("Error")