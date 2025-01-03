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

__author__ = "Marcos Chouza Cruces"

def validar_dni(dni:str) -> bool:
    """
    Validador de DNI. Comprobamos a lonxitude, se os 8 primeiros caracteres son numéricos, se o último caracter é unha letra maiúscula e se os caracteres coinciden ca letra final

    Args:
        dni (str): DNI ingresado polo usuario

    Returns:
        bool: True or False dependendo de se o DNI é válido ou non
    """
    
    letras = "TRWAGMYFPDXBNJZSQVHLCKE"
    
    dni = dni.strip().upper() #Eliminamos espacios en blanco y convertimos las letras en mayúsculas
    
    if len(dni) != 9:
        return False
    
    if not dni[:8].isdigit():
        return False

    if not dni[8].isalpha():
        return False
    
    numero = int(dni[:8])
    letra_calculada = letras[numero % 23]
    
    return dni[8] == letra_calculada

#Pedímoslle ao usuario que ingrese un dni
dni = input("Ingrese un dni: ")

#Almacenamos o valor da funcion nunha variable para mellorar a lexibilidade do código
dni_validado = validar_dni(dni)

#Imprimimos por pantalla
if dni_validado:
    print("Válido")
else:
    print("Inválido")