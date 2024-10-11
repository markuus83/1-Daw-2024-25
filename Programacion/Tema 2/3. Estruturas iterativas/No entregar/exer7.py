""" 
Escribe un script que pida que se introduzan números por teclado ata que o total da suma de tódolos números introducisod sexa 100 ou máis. Ao rematar indica por pantalla a cantidade de números introducidos.
"""

__author__ = "Marcos Chouza Cruces"

suma = 0
contador = 0

while True: 
    
    numero = int(input("Introduce un número por pantalla: "))
    suma = suma + numero
    contador += 1
    
    if suma >= 100:
        break
    
print(f"A cantidade de números introducidos é {contador}")