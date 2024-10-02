""" 
Escribe un script que reciba un enterio (n) maior ou igual a 1 e ofreza o resultado da seguinte suma: 1 + 1/2 + 1/3 + ... + 1/n
"""

__author__ = "Marcos Chouza Cruces"

numero = int(input("Ingrese un número enteiro maior ou igual a 1: "))
suma = 0
x = 1

if numero >= 1:
    while x <= numero:
        suma += 1/x
        x += 1
    print("A suma total é: ", suma)

else:
    print("Erro")