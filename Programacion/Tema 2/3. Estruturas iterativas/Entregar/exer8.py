""" 
Escribe un script que reciba un enterio (n) maior ou igual a 1 e ofreza o resultado da seguinte suma: 1 + 1/2 + 1/3 + ... + 1/n
"""

__author__ = "Marcos Chouza Cruces"

#Pedimoslle ao usuario que ingrese os valores axeitados
numero = int(input("Ingrese un número enteiro maior ou igual a 1: "))

#Inicializamos as variables
suma = 0
x = 1

#Comezamos coa estrututra condicional
if numero >= 1:
    
    #Establecemos o bucle para facer as operacións necesarias
    while x <= numero:
        suma += 1/x
        x += 1
    print("A suma total é: ", suma)
    
#Para posibles erros de código
else:
    print("Erro")