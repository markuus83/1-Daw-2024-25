#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Desenvolva un script para determinar se unha cadea de caracteres (palabra/frase) é palíndromo, é dicir, se se pode ler igual de esquerda a dereita que de dereita a esquerda. Un exemplo de palíndromo é a palabra “radar”.

Desenvolva a seguinte función recursiva:

    · Función palindromo: cos parámetros de entrada que considere preciso para resolver de forma recursiva se unha palabra/frase é palíndromo. O valor de retorno será True ou False en función do caso. (Exemplo:“radar” é palíndromo, polo tanto, a función devolverá True).

Nese mesmo script proba a función obtendo unha palabra ou frase por teclado e mostra por pantalla Palídromo se é un palñindromo e Non palíndromo en caso contrario.
"""

__author__ = "Marcos Chouza Cruces"

def palindromo(cadea: str) -> bool:
    
    """
    Ver se unha palabra é un palíndromo ou non

    Args:
        cadea(str): cadea a observar
        
    Raises:
        ValueError: Se a cadea está vacía

    Returns:
        bool: Devolve se é palíndromo ou non.
    """
    
    #Facemos minúsculas 
    cadea = cadea.lower()
    cadea = cadea.replace(" ", "")

    #Se a cade aten lonxitude 0 == True
    if len(cadea) == 0 or type(cadea) is None:
        return True
    
    #Se a cadea é dun só valor == True
    elif len(cadea) == 1:
        return True
    
    #Se o primeiro elemento é diferente do último == False
    elif cadea[0] != cadea[-1]:
        return False
    
    #Iteramos de forma recursiva sobre o último elemento
    return palindromo(cadea[1:-1])
    
#Pedimoslle ao usuario que ingrese os datos precisos
cadea = input("Ingrese unha cadea para ver se é un palíndromo: ")

#Mostramos as posibles excepcións e damos a saída por pantalla
cadea_output = palindromo(cadea)
    
if cadea_output:
    print("Palindromo")
        
else:
    print("Non palíndromo")