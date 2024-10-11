""" 
Escribe un script que calcule a suma dos N primeiros números. O valor de N e introducido por teclado. 
Mostra o resultado por pantalla
"""

__author__ = "Marcos Chouza Cruces"

suma = 0
numero = int(input("Introduce un número: "))

while 0 <= numero:
    suma = suma + 1
    print(f"A suma total dos números dende o 0 ata {numero} é: {suma}")