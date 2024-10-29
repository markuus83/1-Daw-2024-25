#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe un script en pyhton que conte o número de palabras nunha cadea de texto introducida por teclado e o mostre por pantalla. Considera que as palabras están separadas por un ou máis espazos. Coidado cos dobres, triples ou máis espazos ao comezo e ao final do texto.
"""
##################################################
# Pedir cadena     
# Quitarle los espacios del principio y del final
# Quitarle los espacios de por medio
# Medir longitud de la cadena final
##################################################

__author__ = "Marcos Chouza Cruces"

def eliminar_espazos_incial_final(cadea: str) -> str:
    """
    Eliminar os espazos ao principio e ao final da cadea ingresada polo usuario.
    
    Args:
        cadea (str): Cadea ingresada polo usuario.

    Returns:
        str: Nova cadea sen espazos ao principio e final.
    """
    
    c = cadea.strip(" ")
    return c

def contar_palabras(c: str) -> str:
    
    """
    Contar as palabras da cadea ingresada polo usuario

    Args:
        c (str): Cadea ingresada polo usuario sen espazos ao principio ou final.
    Returns:
        str: Lonxitude das cadeas finais
    """
    
    nova_cadea = c.split()
    return len(nova_cadea)

#Pedímoslle ao usuario que ingrese unha cadea de texto
cadea = input("Ingrese unha cadea de texto: ")

#Almacenamos as funcions en distintas varaibles para mellorar a lexibilidade do código
c = eliminar_espazos_incial_final(cadea)
numero_palabras = contar_palabras(c)

#Imprimimos por pantalla
print(f"O número de palabras da cadea é: {numero_palabras}")