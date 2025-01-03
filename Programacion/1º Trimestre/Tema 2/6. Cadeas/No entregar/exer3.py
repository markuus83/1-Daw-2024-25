#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe un script que elimine todas as consoantes dunha cadea de texto introducida por teclado e devolva unha nova cadea só coas vocais e outros caracteres. Mostra este texto por pantalla.
"""

__author__ = "Marcos Chouza Cruces"

#Inicializamos unha variable con valores que queremos comparar
consoantes = "bcdfghjklmnñpqrstvwxyzçBCDFGHJKLMNÑPQRSTVWXYZÇ"

def eliminar_consoantes(cadea: str) -> str:
    """
    ELiminamos as consoantes presentes na cadea a traballar

    Args:
        cadea (str): Cadea de caracteres proporcionada polo usuario

    Returns:
        str: Nova cadea sen consoantes
    """
    
    nova_cadea = ""
    
    for caracter in cadea:
        
        if caracter not in consoantes:
            nova_cadea += caracter
            
    return nova_cadea
        
#Pedímoslle ao usuario que ingrese os datos precisos
cadea = input("Ingrese unha cadea de texto: ")

#Almacenamos o valor da función nunha nova variable para facilitar a lexibilidade do código
nova_cadea = eliminar_consoantes(cadea)

#Imprimimos por pantalla
print(f"A cadea final sen consoantes é: {nova_cadea}")