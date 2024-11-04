#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Queremos realizar un programa que calcule o índice dunha chave para un diccionario utilizando o algoritmo de hashing por folding. O programa recibirá en orde os seguintes parámetros: tamaño da táboa, número de división folging e chave.
"""

__author__ = "Marcos Chouza Cruces"

def calculo_ascii(chave: str) -> str:
    if type(chave) != str:
        raise ValueError ("OS valores ingresados non coinciden cos esperados.")
    
    caracter_ascii = ""
    
    for caracter in chave:
        # Obtener el código ASCII del carácter
        ascii_code = ord(caracter)
        # Agregar el código ASCII a la cadena seguido de un espacio
        caracter_ascii += str(ascii_code) + " "
    
    # Eliminar el último espacio extra al final de la cadena
    return caracter_ascii


def calculo_folding(cadea: str, num_division: int) -> str:
    
    nova_cadea = cadea.replace(" ", "")
    
    resultado = ""
    inicio = 0
    
    while inicio < len(cadea):
        parte = nova_cadea[inicio:inicio + num_division]
        resultado += parte + " "  # Agregar la parte a resultado y un espacio
        inicio += num_division
    
    return resultado


def suma_numeros(cadea2: str) -> int:
    
    return




#tamanho_taboa_modulo = int(input("Ingrese o tamaño da táboa: "))
num_division = int(input("Ingrese o número de divisións do folding: "))
chave = str(input("Ingrese a chave a aplicar: "))

cadea = calculo_ascii(chave)

cadea1 = calculo_ascii(chave)
cadea2 = calculo_folding(cadea, num_division)
cadea3 = suma_numeros(cadea2)


print(cadea3)