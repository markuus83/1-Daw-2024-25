"""
Escribe un script que pida ao usuario o número de quilómetros recorridos na súa última viaxe en coche, o consumo do coche en litros cada 100 quilómetros e o prezo en 
euros dun litro de combustible. Calcula o custo da viaxe e móstrallo ao usuario por pantalla
"""

__author__ = "Marcos Chouza Cruces"

#Pedimos ao usuario que introduza os datos por pantalla e os convertemos diretamente no valor axeitado en cada caso
km = float(input("Introduce os quilometros recorridos na súa última viaxe en coche: "))
l = float(input("Introduce o consumo do coche en Litros a cada 100 quilometros: "))
euros = float(input("Introduce o en euros a canto custa un litro de combustible: "))

#Realizamos as operaciones necesarias para o correcto funcionamento do código

custo_euros_litro = l * euros
custoViaxe = custo_euros_litro * km

#Amosamos por pantalla
print("O custo total da viaxe é de", custoViaxe, "€")