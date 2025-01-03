#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Deséxase saber os días que faltan para que remate o ano. Polo tanto, escribe unha función que que reciba como parámetros:

- O mes en número (1, 2, 3,... ata 12)
- O día do mes en número (Dependendo do mes poden ser 28, 30 ou 31 días). Consideramos que o ano non é bisesto.

A función debe devolver os días que faltan para rematar o ano.

Comproba o tipo de datos dos parámetros, así como que se os seus valores son válidos. En caso contrario lanza unha excepción `ValueError`.
"""

__author__ = "Manuel Ramón Varela López"


def contador_fin_ano(dia, mes):
    """
    Función que indica para un determinado día cantos días quedan para que remate o ano

    Args:
        dia (int): dia en número
        mes (int): dia en mes

    Raises:
        ValueError: Se non son enteiros días a mes, ou se conxuntamente non son unha data válida

    Returns:
        int: Os días que restan de ano
    """

    dias_por_mes = {
        1 : 31,
        2 : 28,
        3 : 31,
        4 : 30,
        5 : 31,
        6: 30,
        7: 31,
        8: 31,
        9: 30,
        10: 31,
        11: 30,
        12: 31
    }

    # Comprobamos tipo de datos
    if type(dia) is not int:
        raise ValueError
    if type(mes) is not int:
        raise ValueError
    
    # Comprobamos valores
    if dia > 12 or dia < 0:
        raise ValueError
    if dia <= 0 or dia > dias_por_mes[mes]:
        raise ValueError
    
    dias_fin_ano = 0
    # Contamos os dias que faltan deste mes
    dias_fin_ano = dias_por_mes[mes] - dia

    # Contamos o dos restantes meses
    mes = mes + 1
    while mes <= 12:
        dias_fin_ano += dias_por_mes[mes]
        mes += 1

    return dias_fin_ano