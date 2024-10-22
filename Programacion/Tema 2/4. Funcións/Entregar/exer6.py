#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe un script que pida o nome de usuario e contrasinal ao usuario. Indica se o inicio de sesión é correcto. O nome de usuario correcto sería 'python' e o contrasinal 'pip'. Crea a función:

    · login(usuario: str, contrasinal: str) -> boolean
"""

__author__ = "Marcos Chouza Cruces"


def login (usuario: str, contrasinal: str) -> bool:
    
    """
    Define se o Loggin na aplicación é ou non correcto

    Returns:
        Bool: Tipo de dato no return
    """
    
    if usuario == 'python' and contrasinal == 'pip':
        return True

    else:
        return False

#Pedimoslle ao usuario que ingrese os valores
usuario = input("Introduce o nome do usuario: ")
contrasinal = input("Introduce o contrasinal: ")

#Establecemos a estrutura condicional que chama as funcións necesarias e dará unha saída por pantalla
if login(usuario, contrasinal) == True:
    print("O inicio de sesión é correcto")
    
else:
    print("O inicio de sesión é incorrecto")