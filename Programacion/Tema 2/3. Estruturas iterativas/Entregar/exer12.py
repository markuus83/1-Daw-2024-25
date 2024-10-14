""" 
Escribe un script que elexirá no seu comezo un número ao azar entre 1 e 25. A continuación o usuario introducirá números por teclado ata que acerte o nñumero seleccionado ao azar. Cada vez que se introduza un número incorrecto, o script proporcionaralle pistas ao usuario: "o número é maior" ou "o número é menor". Unha vez que o usuario acerte o númeero, indicaráselle por pantalla se gañou o xogo ou non. Para ganar, o usuario deberá acertar o número en menos de 5 intentos.
"""

__author__ = "Marcos Chouza Cruces"

#Importamos a librería necesaria
import random

#Facemos uso da librería, almcenando o valor nunha variable 
numero_aleatorio = random.randint(1,25)

#Establecemos a variable iterativa
contador = 0

#Comezamos co bucle
while True:
    numero = int(input("Ingrese un número: "))
    
    #Caso gañador
    if numero_aleatorio == numero:
        print(f"O número escollido polo gañador {numero} é igual ao número aleatorio!!: {numero} = {numero_aleatorio}!!")
        break
    
    #Darlle pistas sobre que o número introducido é menor
    if numero > numero_aleatorio:
        print("O número é menor")
        contador += 1
        continue
    
    #Darlle pistas sobre que o número introducido é maior
    if numero < numero_aleatorio:
        print("O número é maior.")
        contador += 1
        continue
    
#Saída por pantalla de estado do xogo
if contador < 5:
    print("\nNoraboa, gañaches o xogo.")
else:
    print("\nSintoo, perdiches o xogo.")
    
    