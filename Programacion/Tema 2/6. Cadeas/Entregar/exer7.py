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

############### ESTÁ MAL FEITO ###############

__author__ = "Marcos Chouza Cruces"

def lonxitude_cadea(dni: str) -> bool:
    
    if len(dni) == 9:
        return True
    
    else:
        raise ValueError ("O DNI ingresado é inválido.")


def comprobacion_dixitos_numericos (numeros_dni:str) -> bool:
    
    if numeros_dni == 8:
        return True


def comprobacion_letra_dni (letra_dni:str) -> bool:
    
    codigo_ascii = ord(letra_dni)
    if 65 <= codigo_ascii <= 90:
        return True
    

def comprobacion_total_dni(dni: str) -> bool:
    
    letras_posibles_dni = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"
    
    # Verificar o formato do DNI
    if not lonxitude_cadea(dni):
        return False
    
    # Separar números e letra
    numeros_dni = dni[:-1]
    letra_dni = dni[-1].upper()  # Convertimos a letra a maiúscula por consistencia
    
    # Comprobar que os números e a letra son válidos
    if not comprobacion_dixitos_numericos(numeros_dni) or not comprobacion_letra_dni(letra_dni):
        return False

    # Convertir os números a un enteiro e calcular a letra de control
    numero = int(numeros_dni)
    letra_correcta = letras_posibles_dni[numero % 23]
    
    # Comprobar se a letra coincide coa esperada
    if letra_dni == letra_correcta:
        return True


dni = str(input("Ingrese o teu DNI: "))

numeros_dni = dni[:-1]
letra_dni = dni[-1]

dni_comprobado = comprobacion_total_dni(dni)

if dni_comprobado is True:
    print("Válido")
else:
    print("Inválido")
