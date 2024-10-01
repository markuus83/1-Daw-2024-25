""" 
Escribe un script que permita obter o factorial dun número enteiro positivo introducido por teclado
"""

__author__ = "Marcos Chouza Cruces"

numero = int(input("Ingrese un número para calcularlle o seu factorial: "))

if numero < 0  or numero == 1:
    print(f"O factorial de {numero} é 0")
    
else:
    calculo_factorial = 1  
    original_numero = numero  
    
    while numero > 1:
        calculo_factorial *= numero
        numero -= 1  
    
    print(f"O factorial de {original_numero} é {calculo_factorial}.")