#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Realiza a implantación da función <descifra_cesar(texto: str, desprazamento: int): str> nun script que descifre unha cadea cifrada con cifrado César. Lanza tamén excepción <ValueError> se os argumentos da función son do tipo de datos inválidos.

O propio script debe utilizar dita función para descifrar un texto introducido polo usuario para mostrar o texto descifrado por pantalla. O usuario tamén indicará por teclado o desprazamento.
"""

__author__ = "Marcos Chouza Cruces"

def descifrar_cesar(texto: str, desprazamento: int) -> str:
    """
    Descifrar un texto mediante o descifrado cesar

    Args:
        texto (str): Texto cifrado ingresado polo usuario
        desprazamento (int): cantidade de caracteres a desplazar 

    Raises:
        ValueError: Para valores ingresados non correspondentes

    Returns:
        str: Cadea de texto descifrada
    """
    
    if type(texto) != str or type(desprazamento) != int:
        raise ValueError("Os valores ingresados non son correspondentes")
    
    cadea_axuda = "abcdefghijklmnopqrstuvwxyz"
    texto_descrifrado = ""
    
    for caracter in texto:
        
        if caracter in cadea_axuda:
            indice_texto = cadea_axuda.index(caracter) #Obtemos o íncide do carácter na cadea_axuda
            indice_cifrado = (indice_texto - desprazamento) % 26 #Calculamos o desprazamento inverso da cadea, e aplicamos módulo 26 (total das caracteres da cadea_axuda) para que reinicie unha vez o desprazamento chegue ao inicio de dita cadea
            texto_descrifrado += cadea_axuda[indice_cifrado] #Engadimos o caracter cifrado a unha nova variable
        else:
            texto_descrifrado += caracter #Para que os caracteres que non pertencen a 'cadea_axuda' se ingresen sen modificacion algunha
            
    return texto_descrifrado

#Pedísmolle ao usuario que ingrese os valores correspondentes
texto = str(input("Ingrese un texto cifrado: ")).lower()
desprazamento = int(input("Ingrese o desprazamento dos caracteres: "))

#Capturamos posibles excepcións e damos unha saída por pantalla
try:
    texto_descifrado = descifrar_cesar(texto, desprazamento)
    print(texto_descifrado)
except ValueError as erro:
    print(f"Erro_ {erro}")