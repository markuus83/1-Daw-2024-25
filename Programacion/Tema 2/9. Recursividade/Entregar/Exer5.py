#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Crea nun script unha función recursica: <anagrama(palabra1: str, palabra2:str) -> bool> que indique se unha das palabras é ou non un anagrama da outra, é dicir, que se pode obter a partir das letras da outra sen máis que reordenalas.

Considerarase que as palabras están escritas en minúsculas, sen til nin outros signos diacríticos e sen espazos en branco ou otros caracteres distintos dos alfabéticos da "A" á "Z".

Se as dúas palabras son iguais tamén se considera que son anagrama.

Nese mesmo script proba función obtendo unha palabra por teclado e mostra por panlla <Anagrama> se é un anagrama e <Non anagrama> en caso contrario.
"""

__author__ = "Marcos Chouza Cruces"

def anagrama(palabra1: str, palabra2: str) -> bool:
    """
    Ver se dúas palabras son anagramas ou non

    Args:
        palabra1(str): Primeira palabra
        palabra2(str): Segunda palabra
        
    Raises:
        ValueError: Se os parámetros non son axeitados
        
    Returns:
        bool: Devolve se as dúas palabras son anagramas ou non
    """
    #Capturamos as posibles excepcións
    if type(palabra1) is not str or type(palabra2) is not str:
        raise ValueError("Os valores dos parámetros non son axeitados")
    
    
    #Eliminamos espazos e convertimos en minúsculas para ambos parámetros
    palabra1 = palabra1.strip()
    palabra1 = palabra1.lower()
    palabra1 = palabra1.replace(" ", "")
    
    palabra2 = palabra2.strip()
    palabra2 = palabra2.lower()
    palabra2 = palabra2.replace(" ", "")
    
    #Se as dúas son iguais == True
    if palabra1 == palabra2:
        return True
    
    # Se as lonxitudes non coinciden ou a primeira letra non está en palabra2 == False
    if len(palabra1) != len(palabra2) or palabra1[0] not in palabra2:
        return False
    
    # Vemos recursivamente a primeira letra de palabra1 elimininándoa e o seu respectivo en palabra2
    return anagrama(palabra1[1:],palabra2.replace(palabra1[0], '', 1))
        
#Pedímoslle ao usuario que ingrese os datos
palabra1 = input("Ingrese a primeira palabra: ")
palabra2 = input("Ingrese a segunda palabra: ")

#Almacenamos o valor da función nunha variable para mellorar a lexibilidade
output = anagrama(palabra1, palabra2)

#Capturamos as posibles excepcións e damos a saída por pantalla
try:
    if output:
        print("Anagrama")
    else:
        print("Non anagrama")
        
except ValueError as erro:
    print(f"Erro: {erro}")