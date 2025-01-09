#!/usr/bin/env python
# -*- coding: utf-8 -*-

#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Deséxase saber os días que faltan para que remate o ano. Polo tanto, escribe unha función que que reciba como parámetros:

    · O mes en número:
    · o día do mes. Consideramos que o ano non é bisiesto
"""

__autor__ = "Marcos Chouza Cruces"


def dias_restantes(mes: int, dia: int) -> int:
    
    """
    Calcula os días restantes para rematar o ano

    Args:
        mes(int): Mes no que nos atopamos
        dia(int): Día no que nos atopamos

    Raises:
        ValueError: Valores axeitados para o parámetro mes.
        ValueError: Valores axeitados para o parámetro dia.
        ValueError: Valores axeitados para un mes de 28 días.
        ValueError: Valores axeitados para os meses de 31 días.
        ValueError: Valores axeitados para os meses de 30 días.

    Returns:
        int: Devolve os días que faltan para rematar o ano
    """
    
    if type(mes) is not int:
        raise ValueError('O parámetro "mes" non coincide cos valores esperados.')
    if type(dia) is not int:
        raise ValueError('O parámetro "dia" non coincide cos valores esperados.')
    if mes == 2 and dia > 28 or dia < 0:
        raise ValueError('Non existen esas datas.')
    if (mes == 1 or mes == 3 or mes == 5 or mes == 7 or mes == 8 or mes == 10 or mes == 12)and dia > 31 or dia < 0:
        raise ValueError('Non existen esas datas.')
    else:
        if dia > 30 or dia <0:
            raise ValueError('Non existen esas datas.')
    
    dias_totales = 365
    
    suma_dias = 0
    while range(0,dia +1):
        suma_dias += 1
        break
    
    suma_mes = 0
    while range(0,mes +1):
        suma_mes += 1
        break
    if suma_mes == 1:
        dias_mes = 31
    elif suma_mes == 2:
        dia_mes = 31 + 28
    elif suma_mes == 3:
        dia_mes = 31*2 + 28
    elif suma_mes == 4:
        dia_mes = 31*2 + 28 + 30
    elif suma_mes == 5:
        dia_mes = 31*3 + 28 + 30
    elif suma_mes == 6:
        dia_mes = 31*3 + 28 + 30*2
    elif suma_mes == 7:
        dia_mes = 31*4 + 28 + 30*2
    elif suma_mes == 8:
        dia_mes = 31*5 + 28 + 30*2
    elif suma_mes == 9:
        dia_mes = 31*5 + 28 + 30*3
    elif suma_mes == 10:
        dia_mes = 31*6 + 28 + 30*3
    elif suma_mes == 11:
        dia_mes = 31*6 + 28 + 30*4
    elif suma_mes == 12:
        dia_mes = 31*7 + 28 + 30*4
    
    resto = dias_totales - (suma_dias + dias_mes)
    return resto  



mes = int(input("Ingrese o mes do ano: "))
dia = int(input("Ingrese o día do mes: "))

resto = dias_restantes(mes, dia)
print(f"Faltan {resto} días para terminar el año.")