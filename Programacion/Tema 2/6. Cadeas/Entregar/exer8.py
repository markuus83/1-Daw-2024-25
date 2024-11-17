#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Queremos realizar un programa que calcule o índice dunha chave para un diccionario utilizando o algoritmo de hashing por folding. O programa recibirá en orde os seguintes parámetros: tamaño da táboa, número de división folging e chave.

"""

__author__ = "Marcos Chouza Cruces"


def calcular_indice_hash(tam_tabla: int, num_divisiones: int, chave: str) -> int:

    """
    Calculo do indice por folding dunha chave outorgada polo usuario

    Args:
        tam_tabla (int): Tamaño da táboa
        num_divisiones(int): Numero de divisións a seguir
        chave(str): Chave a cal lle imos aplicar o Folding
    Returns:
        int: Devolve o índice da chave
    """
    suma = 0
    tam_chave = len(chave)
    
    for i in range(0, tam_chave, num_divisiones):
        #Obtemos unha parte da cadea de tamaño 'num_divisiones'
        parte = chave[i:i+num_divisiones]
        
        #Convertimos a parte a un número sumando os códigos ASCII dos caracteres
        valor_parte = sum(ord(caracter) for caracter in parte)
        
        suma += valor_parte

    #Obtemos o índice aplicando o módulo co tamaño da táboa
    indice = suma % tam_tabla
    
    return indice

#Pedimos ao usuario que ingrese os datos precisos
tam_tabla = int(input("Ingrese o tamaño da táboa: "))
num_divisiones = int(input("Ingrese o número de divisións do folding: "))
chave = input("Ingrese a chave seleccionada (cadea de texto): ")

#Almacenamos o valor da función nunha variable para mellorar a lexibilidade do código
indice = calcular_indice_hash(tam_tabla, num_divisiones, chave)

#Damos a saída por consola
print(f"O índice para a chave '{chave}' é: {indice}")
