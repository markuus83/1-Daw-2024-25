#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
O cifrado César é un tipo de cifrado de substitución no que unha letra do texto orixinal é substituída por outra letra que é un número fixo de posicións posteriores no alfabeto.

Por exemplo se o desprazamento é 5, a 'a' cifrarase coa 'f'. Débense ignorar os espazos en branco.

Se nun desprazamento rematan as letras, volverase a comezar polo comezo do alfabeto.

Supoñer que todos os nomes están en minúsculas e están compostos só polas seguintes letras: a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z.

Realiza a implantación deste algoritmo na función <cifra_cesar(texto: str, desprazamento: int): str>. Recorda que os caracteres diferentes as letras se deben manter. Comproba se o tipo de datos introducidos son válidos, e senón é así lanza unha excepción <ValueError>.

O propio script debe utilizar ditas función para cifrar un texto introducido polo usuario para mostrar o texto cifrado por pantalla. O usuario tamén indicará por teclado o desprazamento. Ademais recorda capturar a excepción.
"""

__author__ = ""

texto_cifrado = ""

def cifra_cesar(texto: str, desprazamento: int, texto_cifrado: str) -> str:
    """
    Aplicación do Cifrado César a unha cadea de texto proporcionada polo usuario

    Args:
        texto (str): Cadea de texto proporcionada polo usuario
        desprazamento (int): Número de caracteres a desprazar no cifrado
        texto_cifrado (str): Cadea de texto cifrada para dar a saída por pantalla

    Raises:
        ValueError: Para valores ingresados non correspondentes

    Returns:
        str: Cadea de texto cifrada
    """
    
    if type(texto) is not str or type(desprazamento) is not int:
        raise ValueError("Os valores ingresados non son correspondentes")
    
    cadea_axuda = "abcdefghijklmnopqrstuvwxyz"
    
    for caracter in texto:
        if caracter in cadea_axuda:
            indice_texto = cadea_axuda.index(caracter) #Obtemos o íncide do carácter na cadea_axuda
            indice_cifrado = (indice_texto + desprazamento) % 26 #Calculamos o desprazamento da cadea, e aplicamos módulo 26 (total das caracteres da cadea_axuda) para que reinicie unha vez o desprazamento chegue ao final de dita cadea
            texto_cifrado += cadea_axuda[indice_cifrado] #Engadimos o caracter cifrado a unha nova variable
            
        else:
            texto_cifrado += caracter #Para os caracteres que non pertencen a 'cadea_axuda' se ingresen sen modificacion algunha
            
    return texto_cifrado

#Pedísmolle ao usuario que ingrese os datos correspondentes
texto = str(input("Ingrese un texto para cifralo: ")).lower() #Pasamos a cadea ingresada a minúsculas automáticamente.
desprazamento = int(input("Ingrese a cantidade de caracteres que quere desprazar: "))

#Capturamos posibles excepcións e damos unha saída por pantalla
try:
    texto_cifrado = cifra_cesar(texto, desprazamento, texto_cifrado)
    print(texto_cifrado)    
except ValueError as erro:
    print(f"Erro: {erro}")