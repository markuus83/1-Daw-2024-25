""" 
Escribe un script que en Python que conte o número de vogais nunha cadea de texto introducida por teclado. Por último imprimirá por pantalla o número de vogais. Recorda contar tanto as maiúsculas como as minúsculas.
"""

def contar_num_vogais (cadea: str) -> int:
    
    vocales = "aeiouAEIOU"

    contador = 0
    for letra in cadea:
        if letra in vocales:
            contador = contador + 1
 
    return contador


cadea = input("Ingrese unha cadea: ")

num_vogais = contar_num_vogais(cadea)

print(f"O número de vogais é: {num_vogais}")