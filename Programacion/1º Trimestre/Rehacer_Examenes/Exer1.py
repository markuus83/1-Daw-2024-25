#!/usr/bin/env python
# -*- coding: utf-8 -*-

#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Un radar de tramo consta de dous radares fixos separador por unha cerda distancia. Se un vehículo percorre"""

__autor__ = "Marcos Chouza Cruces"


def debe_ser_multado(metros: float, velocidade_tramo: int, segundos: float) -> bool:
    """
    Encárgase de avaliar se nun radar de tramo un vehículo debe ser multado ou non.

    Args:
        metros (float): Metros de separación entre o primeiro punto e o final do tramo.
        velocidade_tramo (int): Velocidade máxima permitida de media no tramo.
        segundos (float): Segundos que tarda o coche en recorrer dito tramo.

    Raises:
        ValueError: Compromar o tipado dos parámetros
        ValueError: Comprobar que os valores introducidos son correctos.

    Returns:
        bool: Devolve 'True' se o vehículo ten que ser multado e 'False' se non debe ser.
    """

    if type(metros) is not float or type(velocidade_tramo) is not int or type(segundos) is not float:
        raise ValueError('Os valores introducidos non coinciden ca tipografía esperada. (PRIMEIRA EXCEPCIÓN)')
    if metros <=0 or velocidade_tramo <=0 or segundos <= 0:
        raise ValueError('OS valores introducidos non coinciden cos valores esperados. (SEGUNDA EXCEPCION)')
    
    velocidade_coche = (metros * 0.001)/(segundos/3600)
    
    if velocidade_coche > velocidade_tramo:
        return True
    else:
        return False

try:
    metros = float(1000)
    velocidade_tramo = 120
    segundos = float(30)

    multa = debe_ser_multado(metros, velocidade_tramo, segundos)

    if multa:
        print("A cagarse")
    else:
        print("Safaches")

except ValueError as erro:
    print(f"Erro: {erro}")
