""" 

"""



def palindromo_validador(cadea: str) -> int:
    
    vocales = "aeiouAEIOU"

    contador = 0
    for letra in cadea:
        if letra in vocales:
            contador = contador + 1
 
    return contador



cadea = input("Ingrese unha cadea: ")

palindromo = palindromo_validador(cadea)

if palindromo:
    print("PALÍNDROMO")
else:
    print("NON PALÍNDROMO")