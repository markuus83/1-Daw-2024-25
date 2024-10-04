""" 
Escribe un script que calcule a suma dos N primeiros números. O valor de N e introducido por teclado. 
Mostra o resultado por pantalla
"""

__author__ = "Marcos Chouza Cruces"

numero = int(input("Ingrese un valor numérico enteiro positivo: "))

suma = 0
contador = 1

while contador <= numero:
    suma += contador
    contador += 1
    
print(f"A suma dos {numero} primeiros números naturais é: {suma}")