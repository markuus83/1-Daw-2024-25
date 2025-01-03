"""Escribe un script que informe se un número introducido por teclado é par ou impar. 
Imprimirá por pantalla Par ou Impar segundo corresponda.
"""
__author__ = "Marcos Chouza Cruces"

num = int(input("Ingrese un número: "))

if num%2 == 0:
    print("Par")
else:
    print("Impar")