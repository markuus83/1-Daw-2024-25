#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Os números 17, 341 e 62 teñen en común que a suma dos seus díxitos dan o mesmo valor, 8. Hai moitos outros números así; de todos eles, o 17 é o máis pequeno.

Implanta un programa que recibirá por teclado un número entre 1 e 1000 e a continuación se mostre o número decimal máis pequeno que as súas cifras sumen a mesma cantidade que a suma das cifras do número introducido por teclado.

Por exemplo, se o usuario introduce o número 92, deberase imprimir o número 29.
"""

__author__ = "Marcos Chouza Cruces"

def suma_digitos(numero_entrada: int) -> int:
    
    """
    Calculamos a suma dos díxitos do número introducido por teclado.

    Args:
        numero (int): Número a calcular a suma dos seus díxitos.

    Returns:
        int: Suma total dos díxitos.
    """
    return sum(int(digito) for digito in str(numero_entrada))

def menor_numero_con_misma_suma(suma_objetivo: int) -> int:
    
    """
    Calcula o menor número que teña a mesma suma dos seus díxitos que suma_objetivo.

    Args:
        suma_objetivo (int): Suma dos díxitos do número a devolver.

    Returns:
        int: O menor número con esa suma de díxitos.
    """
    
    #Constrúe o número directamente sen necesidade de ordear
    numero_final = 0
    multiplicador = 1

    #Mentres quede suma pendente, engadimos díxitos ao número
    while suma_objetivo > 0:
        
        digito = min(9, suma_objetivo)  #Escolle o díxito máis grande posible que non exceda a suma
        numero_final += digito * multiplicador
        suma_objetivo -= digito
        multiplicador *= 10  #Avanza ao seguinte díxito

    return numero_final


try:
    
    entrada = input("Introduce un número entre 1 e 1000: ").strip()
    
    if not entrada.isdigit():
        raise ValueError("A entrada debe ser un número enteiro positivo.")
    
    numero_entrada = int(entrada)
    
    if 1 <= numero_entrada <= 1000:
        suma = suma_digitos(numero_entrada)
        resultado = menor_numero_con_misma_suma(suma)
        print(f"O número máis pequeno con suma de díxitos igual a {suma} é: {resultado}.")
        
    else:
        raise ValueError("O número debe estar entre 1 e 1000.")
        
except ValueError as erro:
    print(f"Erro: {erro}")
