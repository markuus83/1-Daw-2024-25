"""
Escribe un script que pida ao usuario 3 números e móstralle por pantalla a media dos 3 números.
"""
__author__ = "Marcos Chouza Cruces"

#Pedimos ao usuario que ingrese os datos necesarios
num1 = int(input("Ingrese o primeiro número: "))
num2 = int(input("Ingrese o segundo número: "))
num3 = int(input("Ingrese o terceiro número: "))

#Facemos os cálculos necesarios
media = (num1 + num2 + num3)/3

#Imprimimos por pantalla
print("A media dos tres anteriores números é:", media)