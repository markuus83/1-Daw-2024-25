""" 
Escribe un script que permita obter o factorial dun número enteiro positivo introducido por teclado
"""

__author__ = "Marcos Chouza Cruces"

#Pedímoslle ao usuario que ingrese os valores
numero = int(input("Introduce un número para calcularlle o seu factorial: "))

#Para establecer os factoriais de '0' e '1' (casos especiais)
if numero == 0 or numero == 1:
    print(f"O factorial de {numero} é: 1")

#Para os valores negativos
elif numero < 0:
    print("Non existen factoriais de negativos.")
    
#Para o resto de números  
elif numero > 1:
    
    #Inicializamos as variables precisas
    contador = numero
    factorial = 1
    
    #Comezamos co bucle
    while contador > 1:
        
        factorial *= contador
        contador -= 1
        
    #Imprimimos a saída
    print(f"O factorial de {numero} é: {factorial}")
    
#Para posibles erros do código
else:
    print("Error")