#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Un número de DNI ten o seguinte formato <00000000A>

Escribe un script que lle pida ao usuario o seu DNI e comprobe que sexa correcto. Para iso sigue os seguintes pasos:

    · Comproba a lonxitude da cadea.
    
    · Comproba que os 8 primeiros díxitos son números e o último é unha letra maiúscula. PISTA: utiliza a táboa do código ASCII.
    
    · Comproba que a letra introducida é o código de control do DNI.
    
Por último imprime <Válido> ou <Inválido> segundo corresponda.
"""

#Las excepciones están mal vistas, no son value error, simplemente no dan la salida k yo


__author__ = "Marcos Chouza Cruces"

def lonxitude_cadea(dni: str) -> bool:
    """
    Calcular a lonxitude do DNI para ver se ten 9 caracteres

    Args:
        dni (str): DNI proporcionado polo usuario.

    Raises:
        ValueError: Erro se a lonmxitude do dni é distinta de 9

    Returns:
        bool: Tipo do dato do return
    """
    if len(dni) != 9:
        raise("A lonxitude do dni debe ser de 9 caracteres.")
    
    return True


def comprobacion_dixitos_numericos(dni: str) -> bool:
    """
    Comprobar se os 8 primeiros díxitos do DNI son números.
    
    Args:
        dni (str): DNI proporcionado polo usuario.

    Raises:
        ValueError: Erro se os primeiros 8 díxitos non son números.

    Returns:
        bool: Tipo do dato do return.
    """
    if not dni[:8].isdigit(): #Funcion atopada en Stackoverflow, consiste para veriricar se os caracteres dunha cadea son numéricos ou non.
        return True


def comprobacion_letra_dni(dni: str) -> bool:
    """
    Comprar se o último caracter do dni é unha letra maiúscula.

    Args:
        dni (str): DNI proporcionado polo usuario.
        
    Raises:
        ValueError: Erro se a última letra non é unha letra maiúscula

    Returns:
        bool: Tipo do dato do return.
    """

    if not ('A' <= dni[8] <= 'Z'):
        raise TypeError("O último carácter debe ser unha letra maiúscula.")
    
    return True


def comprobacion_total_dni(dni:str) -> bool:
    """
    Comprobación total do DNI, para ver se coinciden os números coa letra proporcionada.

    Args:
        dni (str): DNI proporcionado polo usuario.

    Raises:
        ValueError: Erro se a letra do DNI non coincide cos números ingresados.

    Returns:
        bool: Tipo do dato do return.
    """
    
    letras_dni = "TRWAGMYFPDXBNJZSQVHLCKE"
    numero = int(dni[:8])
    letra_correcta = letras_dni[numero % 23]
    
    if dni[8] != letra_correcta:
        raise ValueError("A letra do DNI non coincide co código de control.")
    return True


def validar_dni(dni:str) -> bool:
    """
    Validación xeral do dni, para ver se as funcións antertiores son correctas.

    Args:
        dni (str): DNI proporcionado polo usuario.

    Returns:
        bool: Tipo do dato do return
    """
    try:
        lonxitude_cadea(dni)
        comprobacion_dixitos_numericos(dni)
        comprobacion_letra_dni(dni)
        comprobacion_total_dni(dni)
        return True
    
    except ValueError as erro:
        print(f"Erro: {erro}")

#Pedímoslle ao usuario que ingrese un dni
dni = input("Ingrese un dni: ")

#Almacenamos o valor da funcion nunha variable para mellorar a lexibilidade do código
dni_validado = validar_dni(dni)

#Imprimimos por pantalla
if dni_validado:
    print("Válido")
else:
    print("Inválido")