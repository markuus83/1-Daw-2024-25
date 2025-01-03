#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe un script en python que conte o número de vogais nunha cadea de texto introducida por teclado. Por último imprimirá por pantalla o número de vogais. Recorda contar tanto as maiúsculas como as minúsculas.
"""
__author__ = "Marcos Chouza Cruces"

#Inicializamos unha variable cos caracteres que queremos buscar na cadea de texto
vocales = "aáàäâãeéèëêiíìïîoóòöôõuúùüûAÁÀÄÂÃEÉÈËÊIÍÌÏÎOÓÒÖÔÕUÚÙÜÛ"

def comprobar_vocais (cadea: str) -> int:
    """
    Comprobación do número total de vocais existentes na cadea a definir

    Args:
        cadea (str): Cadea a comparar

    Returns:
        int: Numero de vogais na cadea
    """
    contador = 0
    
    for caracter in cadea:
        if caracter in vocales:
            contador += 1
            
    return contador

#Pedímoslle ao usuario que ingrese un texto
cadea = input("Ingrese un texto: ")

#Almacenamos o valor da función nunha variable para unha maior lexibilidade do código
num_vocais = comprobar_vocais(cadea)

#Saída por pantalla
print(f"O número de vocais da cadea é de {num_vocais}.")