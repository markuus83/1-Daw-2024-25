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

def lonxitude_cadea(dni: str) -> bool:
    
    if len(dni) == 9:
        return True
    
    else:
        raise ValueError ("O DNI ingresado é inválido.")


def comprobacion_dixitos_numericos (numeros_dni:int) -> bool:
    
    try:
        numeros_dni = int(numeros_dni)
    except ValueError:
        print("Erro. O valor debe ser numérico")
    
    if numeros_dni == 8:
        return True


def comprobacion_letra_dni (letra_dni:str) -> bool:
    
    try:
        letra_dni = str(letra_dni)
    except ValueError:
        print("Erro. O valor debe ser un carácter.")
        
    codigo_ascii = ord(letra_dni)
    if 65 <= codigo_ascii <= 90:
        return True
    

def comprobacion_total_dni(numeros_dni: str, letra_dni: str) -> bool:
    
    letras_totais_dni = "TRWAGMYFPDXBNJZSQVHLCKE"
    
    if comprobacion_dixitos_numericos(len(numeros_dni)):
        indice = int(numeros_dni) % 23
        return letra_dni == letras_totais_dni[indice]
    
    return False


dni = str(input("Ingrese o teu DNI: "))


numeros_dni = dni[:-1]
letra_dni = dni[-1].upper()

try:
    dni1 = lonxitude_cadea(dni)
    dni2 = comprobacion_dixitos_numericos(numeros_dni)
    dni3 = comprobacion_letra_dni(letra_dni)
    dni_comprobado = comprobacion_total_dni(numeros_dni, letra_dni)

except ValueError as error:
    print(error)
    dni_comprobado = False
    
if dni_comprobado is True:
    print("Válido")
else:
    print("Inválido")

