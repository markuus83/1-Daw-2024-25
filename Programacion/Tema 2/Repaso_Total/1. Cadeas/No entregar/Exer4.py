#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un *script* en Python que conte o número de palabras nunha cadea de texto introducida por teclado e o mostre por pantalla. 
Considera que as palabras están separadas por un ou máis espazos. 
Coidado cos dobres, triples ou máis espazos e cos espazos ao comezo e o final do texto.
"""

__author__ = "Marcos Chouza Cruces"


texto = input("Introduce un texto: ")

# Quitamos se hai varios espazos e sustituimolos por un solo,
letra_anterior = None
novo_texto = ""
for letra in texto:
    
    if letra == " " and letra_anterior != " ":
        novo_texto += letra
    elif letra != " ":
        novo_texto += letra
    letra_anterior = letra

#Quitamos os espazos do principio e do final
novo_texto = novo_texto.strip()

numero_palabras = 0
if len(novo_texto) > 0:
    for letra in novo_texto:
        if letra == " ":
            numero_palabras +=1
    # Sempre vai haber unha palabra mais que espazos
    numero_palabras +=1
else:
    numero_palabras = 0

print(f"O número de palabras é: {numero_palabras}.")