""" 
Escribe un script que permita obter o factorial dun número enteiro positivo introducido por teclado
"""

__author__ = "Marcos Chouza Cruces"

#Pedímoslle ao usuario que ingrese os valores axeitados
numero = int(input("Ingrese un número para calcularlle o seu factorial: "))

#Casos para casos de factoriais especiais
if numero == 0  or numero == 1:
    print(f"O factorial de {numero} é 1")

#Outros casos de factoriais especiais
elif numero < 0:
    print("Error, non existe o factorial dun número negativo")

else:
    #Inicializamos variables
    calculo_factorial = 1  
    original_numero = numero  
    
    #Establecemos o bucle
    while numero > 1:
        calculo_factorial *= numero
        numero -= 1  
    
    #Imprimimos o resultado
    print(f"O factorial de {original_numero} é {calculo_factorial}.")