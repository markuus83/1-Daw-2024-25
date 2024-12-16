""" 
Escribe un script que en Python que conte o número de vogais nunha cadea de texto introducida por teclado. Por último imprimirá por pantalla o número de vogais. Recorda contar tanto as maiúsculas como as minúsculas.
"""

def contar_num_vogais (cadea: str) -> int:
    vocais = "aeiouAEIOU"

    suma = 0

    for caracter in cadea:
        if caracter in vocais:
            suma += 1
            
    return suma

cadea = input("Ingrese unha cadea: ")

num_vogais = contar_num_vogais(cadea)

print(f"O número de vogais é: {num_vogais}")