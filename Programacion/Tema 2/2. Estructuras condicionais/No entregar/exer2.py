"""
Escribe un script que a partir dun número introducido por teclado, indique se é un número positivo, 
negativo ou é igual a cero. Se ñe positivo mostra por pantalla <Positivo>, se é negatico <Negativo> e 
se é 0 <Cero>
"""

__author__ = "Marcos Chouza Cruces"

#Pedimoslle ao usuario que introduza os valores
num = int(input("Ingrese un número para saber o seu signo: "))

#Comezamos ca estructura condicional que da a saída por pantalla
if num < 0:
    print("O número proporcionado é negativo")
    
elif num == 0:
    print("O número proporcionado é cero")
    
elif num > 0:
    print("O número proporcionado é positivo")