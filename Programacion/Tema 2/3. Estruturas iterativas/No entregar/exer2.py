""" 
Escribe un script que imprima os números pares (un en cada liña) ata un número introducido polo usuario, este número incluído.
"""

__author__ ="Marcos Chouza Cruces"

numero = int(input("Ingrese un numero enteiro positivo: "))

contador = 0

while contador <= numero:
    print(contador)
    contador += 2
    