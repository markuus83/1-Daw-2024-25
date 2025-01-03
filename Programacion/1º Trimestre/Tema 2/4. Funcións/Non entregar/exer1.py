""" 
Escribe unha función nun script que informe se un número é par ou impar. Este algoritmo debe ir dentro dunha función definida como:

    · comprobar_par(numero: int) - boolean
    
En dito script, utiliza dita función para comprobar se un número que introduce un usuario é par ou impar. Se é par, imprime Par e senón Impar.

Para comprobar o funcionamiento da función, utiliza o código dado.
"""

__author__ = "Marcos Chouza Cruces"

def comproba_par(numero) -> bool:
   return numero%2 == 0

numero = int(input("Ingrese un numero por consola: "))

e_par = comproba_par(numero)

if e_par:
    print("Par")
else:
    print("Impar")