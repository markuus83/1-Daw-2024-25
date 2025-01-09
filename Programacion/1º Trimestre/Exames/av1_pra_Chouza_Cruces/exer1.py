#!/usr/bin/env python
# -*- coding: utf-8 -*-

#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Un radar de tramo consta de dous radares fixos separados por unha certa distancia. Se un vehículo percorre dita distancia nunha velocidade media permitida a maior, este vehículo recibirá unha multa.

Escribe unha función que reciba 3 parámetros:

    · Distancia en metros entre dous radares fixos.
    · Velocidade máxima permitida en quilómetros/hora.
    · Número de segundos que tardou o vehículo en recorrer o tramo entre os dous radares.

A función debe devolver verdadeiro se o vehículo debe recbir unha multa, e falso se non é así.

Comproba o tipo de datos dos parámetros, así como que se os seus valores son válidos. En caso contrario lanza unha excepción ValueError.
"""

__autor__ = "Marcos Chouza Cruces"


def debe_ser_multado(metros: float, velocidade_tramo: int, segundos: float) -> bool:
    
    """
    Calcula a velocidade á que circula o vehículo, e en función diso, devolve se ten que levar multa ou non.

    Args:
        metros(float): Metros entre o primeiro radar e o segundo radar
        velocidade_tramo(int): Velocidade máxima permitida no tramo
        segundos(float): Segundos que tarda o vehículo en recorrer o tramo
    
    Raises:
        ValueError: _description_
        ValueError: _description_
        ValueError: _description_
        ValueError: _description_
        
    Returns:
        bool: Falso se a velocidade do vehículo e menor á velocidade do tramo, True si é verdadeiro
    """
    
    if type(metros) is not float:
        raise ValueError('O parámetro "metros" non coincide cos valores esperados.')
    if type(velocidade_tramo) is not int:
        raise ValueError('O parámetro "velocidade_tramo" non coincide cos valores esperados.')
    if type(segundos) is not float:
        raise ValueError('O parámetro "segundos" non coincide cos valores esperados.')
    if metros <= 0 or velocidade_tramo <= 0 or segundos <= 0:
        raise ValueError('Os datos ingresados son erróneos.')
    
    velocidade_vehiculo = (metros/segundos) * 3.6
    
    if velocidade_vehiculo > velocidade_tramo:
        return True
    


metros = float(100)
velocidade_tramo = int(120)
segundos = float(5)

multa = debe_ser_multado(metros, velocidade_tramo, segundos)


if multa:
    print("Multa")
else:
    print("Safaches")
