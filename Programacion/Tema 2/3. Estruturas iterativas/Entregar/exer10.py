""" 
Escribe un script no que o usuario poida introducir números enteiros por teclado ata que teclee a palabra "fin". Tras finalizar a introducción de números, indícalle cal é o número máis pequeno introducido.
"""

__author__ = "Marcos Chouza Cruces"

#Inicializamos as variables necesarias para o código
contador = 0
#Inicializamos unha variable con valor infinito para que os numeros ingresados, por moi grandes que sexan, sempre sean menores
num_menor = float('inf')

#Comezamos co primeiro bucle iterativo
while True:
    
    #Inicializamos o segundo bucle
    while True:
        numero = input("Introduce un valor: ")
        
        #O programa apra cando ingresamos o valor fin
        if numero == 'fin':
            break
        #Casteamos a int os valores de string ingresados
        numero = int(numero)

        #Almacenamos os valores máis pequenos nunha variable
        if numero < num_menor:
            num_menor = numero
        
        #Aumentamos o valor da variable iterativa, para saber se se ingresaron valores ou non
        contador += 1
    
    if numero == 'fin':
        break


#Damos a saída por pantalla
if contador == 0:
    print("Erro, non se introduciron valores.")
else:
    print(f"O número máis pequeno introducido é: {num_menor}")