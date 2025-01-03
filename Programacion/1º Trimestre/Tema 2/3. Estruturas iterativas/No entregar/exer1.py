""" 
Escribe un script que calcule a suma dos N primeiros números. O valor de N e introducido por teclado. 
Mostra o resultado por pantalla
"""

__author__ = "Marcos Chouza Cruces"

suma = 0
contador = 0
numero = int(input("Introduce un número: "))

while contador <= numero:
    suma += contador
    contador += 1
    
print(f"A suma total dos números dende o 0 ata {numero} é: {suma}")