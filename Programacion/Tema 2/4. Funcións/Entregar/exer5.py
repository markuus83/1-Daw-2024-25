#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe un script que faga o cambio de divisas tanto de euros a libras e viceversa. Crea un mení para que o usuario escolla o cambio que desexa realizar. Realiza unha función para un dos cambios:

    · libras_to_euros (libras: float) -> float
    · euros_to_libras  (euros: float) -> float
    
Un € é igual a 1,10 libras
"""

__author__ = "Marcos Chouza Cruces"

cambio = 1.1

def libras_to_euros(cantidade: float) -> float:
    """
    Conversor de libras a Euros

    Args:
        cantidade (float): Cantidade a convertir

    Returns:
        float: Tipo de valor no return
    """
    
    conversion = cantidade * cambio
    return conversion


def euros_to_libras(cantidade: float) -> float:
    """
    Conversor de Euros a Libras

    Args:
        cantidade (float): Cantidade a convertir

    Returns:
        float: Tipo de valor no return
    """
    conversion = cantidade / cambio
    return conversion

#Creamos o menu
print("\nPrema a opción desexada no menú")
print("\ta) Converter de Euros (€) a Libras(£) ")
print("\tb) Converter de Libras (£) a Euros(€) ")

#Establecemos a opción que queremos utilizar
option = input("> ")

#Preguntamos a cantidade a converter e facemos o chamado a funcion necesaria, que dará unha saída por consola
if option == 'a':
    
    cantidade = float(input("Ingrese a cantidade en euros que quere converter: "))
    print(f"{cantidade}€ a libras son: {libras_to_euros(cantidade)}")
    
    
#Preguntamos a cantidade a converter e facemos o chamado a funcion necesaria, que dará unha saída por consola
elif option== 'b':
    
    cantidade = float(input("Ingrese a cantidade en libras que quere converter:"))
    print(f"{cantidade}Libras a euros son: {euros_to_libras(cantidade)}€")


#O último if encárgase de amosar posibles erros do código
else:
    print("Error")