#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Queremos realizar un programa que calcule o índice dunha chave para un diccionario utilizando o algoritmo de hashing por folding. O programa recibirá en orde os seguintes parámetros: tamaño da táboa, número de división folging e chave.
"""

__author__ = "Marcos Chouza Cruces"

def calculo_ascii(chave: str) -> str:
    
    """
    Calculamos os números ascii de cada caracter da cadea de texto proporcionada polo usuario

    Args:
        chave (str): Cadea de texto proporcionada polo usuario
    Raises:
        ValueError: Cando non coinciden os valores esperados cos outorgados

    Returns:
        str: Conxunto dos caracteres ascii sen espazos
    """
    
    if type(chave) != str:
        raise ValueError ("Os valores ingresados non coinciden cos esperados. (Primeira Funcion)")
    
    caracter_ascii = ""
    
    for caracter in chave:
        # Obtener el código ASCII del carácter
        ascii_code = ord(caracter)
        # Agregar el código ASCII a la cadena seguido de un espacio
        caracter_ascii += str(ascii_code) + " "
    
    return caracter_ascii


def calculo_folding(cadea: str, num_division: int) -> str:
    
    """
    Calculamos a separacion folding dependendo da que ingrese o usuario.

    Args:
    
        cadea(str): Saída da funcion calculo_ascii()
        num_division (int): Numero separacion para a division folding
    
    Raises:
        ValueError: Cando non coinciden os valores esperados cos outorgados

    Returns:
        str: Cadea de texto cos caracteres ascii separados no número de division que pide o usuario
    """
    
    if type(cadea) != str or type(num_division) != int:
        raise ValueError ("Os valores ingresados non coinciden cos esperados. (Segunda Funcion)")
    
    nova_cadea = cadea.replace(" ", "")
    
    resultado = ""
    inicio = 0
    
    while inicio < len(cadea):
        parte = nova_cadea[inicio:inicio + num_division]
        resultado += parte + " "  # Agregar la parte a resultado y un espacio
        inicio += num_division
    
    return resultado


def suma_numeros(cadea2: str) -> int:
    """
    Converte a cadea de texto ascii en subcadeas e suma os numeros entre sí

    Raises:
        ValueError: Cando non coinciden os valores esperados cos outorgados

    Returns:
        int: Suma dos caracteres ascii
    """
    
    if type(cadea2) != str:
        raise ValueError("Os valores ingresados non coinciden cos esperados. (Terceira Funcion)")
    
    suma = sum(int(num) for num in cadea2.split())
    
    return suma



def modulo_taboa(suma: int, tamanho_taboa_modulo: int) -> int:
    
    """
    Aplicamos o módulo do tamaño da táboa

    Raises:
        ValueError: Cando non coinciden os valores esperados cos outorgados

    Returns:
        int: Código final
    """
    
    if type(suma) != int or type(tamanho_taboa_modulo) != int:
        raise ValueError ("Os valores ingresados non coinciden cos esperados. (Cuarta Funcion)")
    
    modulo = suma % tamanho_taboa_modulo
    return modulo

#Pedímoslle ao usuario que ingrese os datos precisos
tamanho_taboa_modulo = int(input("Ingrese o tamaño da táboa: "))
num_division = int(input("Ingrese o número de divisións do folding: "))
chave = str(input("Ingrese a chave a aplicar: "))

#Almacenamos o valor das funcións en variables para mellorar a lexibilidade e capturas posibles excepcións
try:
    cadea = calculo_ascii(chave)
    cadea2 = calculo_folding(cadea, num_division)
    suma = suma_numeros(cadea2)
    Codigo = modulo_taboa(suma, tamanho_taboa_modulo)
    
except ValueError as erro:
    print(f"Erro: {erro}")

print(f"O código do Hashing Folding de {chave} é '{Codigo}'")