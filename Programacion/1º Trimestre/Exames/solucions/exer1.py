#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
**Exercicio 1** Un radar de tramo consta de dous radares fixos separados por unha certa distancia. 
Se un vehículo percorre dita distancia nunha velocidade media permitida a maior, este vehículo recibirá unha multa.

Escribe unha función que recibe 3 parámetros:

- Distancia en metros entre dous radares fixos.
- Velocidade máxima permitida en quilómetros/hora.
- Número de segundos que tardou un vehículo en recorrer o tramo entre os dous radares.

A función debe devolver verdadeiro se o vehículo debe recibir unha multa, e falso se non é así.

Comproba o tipo de datos dos parámetros, así como que se os seus valores son válidos. En caso contrario lanza unha excepción `ValueError`.
"""

__author__ = "Manuel Ramón Varela López"


def multar(distancia_radares, valocidade_maxima, segundos):
    """
    Función que comproba se se debe multar a un vehículo ao pasar por un radar de tramo

    Args:
        distancia_radares (float/int): A distancia existente entre os radares
        valocidade_maxima (float/int): A velocidade máxima que se pode cicular
        segundos (float/int): Os segundos que lle levou a un vehículo pasar polo tramo

    Raises:
        ValueError: Se os parámetros non son enteiros maiores que 0

    Returns:
        boolean: Verdadeiro en caso de que haxa que multar ao vehículo, falso en caso contrario
    """
    
    # Comprobamos tipo de datos
    if not (type(distancia_radares) is int or type(distancia_radares) is float):
        raise ValueError
    if not (type(valocidade_maxima) is int or type(valocidade_maxima) is float):
        raise ValueError
    if not (type(segundos) is int or type(segundos) is float):
        raise ValueError
    
    # Comprobamos valores
    if distancia_radares <= 0:
        raise ValueError
    if valocidade_maxima <= 0:
        raise ValueError
    if segundos <= 0:
        raise ValueError
    
    # Pasamos a distancia a kilometros
    distancia_km = distancia_radares * 1000
    # Pasamos o tempo a horas
    tempo_horas = (segundos / 60) / 60

    # Calculamos a velocidade do vehículo
    valocidade_vehiculo = distancia_km / tempo_horas

    # Comparamos as velocidades
    if valocidade_vehiculo >= valocidade_maxima:
        return True
    else:
        return False