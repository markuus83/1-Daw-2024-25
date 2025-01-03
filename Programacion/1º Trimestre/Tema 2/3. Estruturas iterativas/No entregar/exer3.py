""" 
Escribe un script que calcule e visaulice, unha por cada liña comezando por 0, as potencias de 2 entre 0 e 10, ambas incluídas.
"""

__author__ = "Marcos Chouza Cruces"

potencia = 0

while 0 <= 2**potencia <= 10:
    print(2**potencia)
    potencia = potencia + 1