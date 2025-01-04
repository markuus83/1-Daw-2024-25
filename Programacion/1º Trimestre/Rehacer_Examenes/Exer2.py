#!/usr/bin/env python
# -*- coding: utf-8 -*-

#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Deséxase saber os días que flatan para que remate o ano. Polo tanto, escribe unha función que reciba como parámetros:
    · O mes en número (1,2,3 ... ata 12)
    · O día do mes en número (Dependendo do mes poden ser 28, 30 ou 31 días). Consideramos que o ano non é bisiesto.

A función debe devolver os días que faltan para rematar o ano.
"""

__autor__ = "Marcos Chouza Cruces"

def dias_ano_restante(dia, mes):

    # Comprobamos tipo de datos
    if type(mes) and type(dia) != int:
        raise ValueError('Os valores introducidos non coinciden co tipado esperado.')
    if mes < 1 or mes > 12:
        raise ValueError('O valor do parámetro "mes" é incorrecto (debe estar entre 1 e 12).')
    if dia < 1 or dia > dias_por_mes[mes]:
        raise ValueError(f'O día ({dia}) non é válido para o mes ({mes}).')

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
    
    dias_fin_ano = 0
    # Contamos os dias que faltan deste mes
    dias_fin_ano = dias_por_mes[mes] - dia

    # Contamos o dos restantes meses
    mes = mes + 1
    while mes <= 12:
        dias_fin_ano += dias_por_mes[mes]
        mes += 1

    return dias_fin_ano


mes = int(input("Ingrese o mes do ano desexado: "))
dia = int(input("Ingrese o día do mes desexado: "))

dias_restantes = dias_ano_restante(mes, dia)

try:
    print(f"O días que faltan para rematar o ano son: {dias_restantes}")

except ValueError as erro:
    print(f"Erro: {erro}")
