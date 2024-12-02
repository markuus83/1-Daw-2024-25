#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
<Pasa a calculadora!> é un xogo para dúas persoas no que se comeza cunha calculadora e cada xogador, de xeito alterno, suma unnúmero novo, dun só díxito, ao valor acumulado ata o momento, comezando en 0. O xogador que, traas sumar o seu número, chegue a un resultado maior ou igual a 31 perde.

Ademais, en cada turno un xogador só pode utilizar os números na mesma fila ou columno que o díxito marcado polo seu opoñente no turno anterior, pero non pode repetir o número. Evidentemente, o número 0 non se pode utilizar nunca.

Por exemplo, imaxina que, durante unha partida, un xogador recibe a calculadora mostrándolee o número 28, e o opoñente acaba de introducir o número 9. A partir da disposición dos números da calculadora, sabemos que nesta quenda unicamente poderá xogar os números 3, 6, 7 e 8.

Implanta este xogo
"""

__author__ = "Marcos Chouza Cruces"


valores_totais = {
    1: [2, 3, 4, 7],
    2: [1, 3, 5, 8],
    3: [1, 2, 6, 8],
    4: [1, 5, 6, 7],
    5: [2, 4, 6, 8],
    6: [3, 4, 5, 9],
    7: [1, 4, 8, 9],
    8: [2, 5, 7, 9],
    9: [3, 6, 7, 8],
}

xogadores = [1, 2]

def obtener_posibles_numeros(ultimo_numero: int or None, valores_totais: dict, usados: list):
    """
    Obter os números posibles baseados no último número xogador e os números xa usados.

    Args:
        ultimo_numero (int or None): Último número xogador escollido.
        valores_totais (dict): Dicionario con listas de números posibles para cada número.
        usados (list): Lista de números xa usados no xogo.

    Returns:
        list: Lista de números posibles para a seguinte elección.

    Raises:
        ValueError: Se o último número non existe en valores_totais.
    """
    # Comprobar si el ultimo_numero es válido
    if ultimo_numero is not None and ultimo_numero not in valores_totais:
        raise ValueError(f"Último número ({ultimo_numero}) non é válido en valores_totais.")

    try:
        
        if ultimo_numero:
            return [n for n in valores_totais[ultimo_numero] if n not in usados]
        
        else:
            return [n for n in range(1, 10) if n not in usados]
        
    except Exception as e:
        raise ValueError(f"Erro ao obter números posibles: {e}")


def obtener_eleccion(posibles: list):
    """
    Obter a elección do xogador entre os números posibles.

    Args:
        posibles (list): Lista de números posibles para a elección.

    Returns:
        int: O número seleccionado polo xogador.

    Raises:
        ValueError: Se o xogador escoller un número non válido ou se a entrada non é un número.
    """
    while True:
        
        try:
            eleccion = int(input(f"Escolle un número de {posibles}: "))
            
            if eleccion in posibles:
                return eleccion
            raise ValueError(f"O número {eleccion} non está na lista de números posibles.")
        
        except ValueError as e:
            print(f"Entrada non válida. {e}. Intenta novamente.")
            
        except Exception as e:
            raise ValueError(f"Erro inesperado ao obter elección: {e}")

def turno_xogador(xogador: int, suma: int, valores_totais: dict, usados: list, ultimo_numero: int or None):
    """
    Xestiona o turno dun xogador no xogo.

    Args:
        xogador (int): O número do xogador (1 ou 2).
        suma (int): A suma actual dos números xogados.
        valores_totais (dict): Dicionario coas opcións de números posibles para cada número.
        usados (list): Lista de números xa usados no xogo.
        ultimo_numero (int or None): O último número xogador escollido.

    Returns:
        tuple: A nova suma e o último número xogador escollido.

    Raises:
        ValueError: Se o xogador non pode xogar ou se a suma chega a 31.
    """
    print(f"\nTurno do Xogador {xogador}. Suma actual: {suma}")
    
    posibles = obtener_posibles_numeros(ultimo_numero, valores_totais, usados)
    
    if not posibles:
        raise ValueError(f"Xogador {xogador} perdeu porque non pode xogar! Non hai números posibles.")
    
    
    
    eleccion = obtener_eleccion(posibles)
    
    suma += eleccion
    usados.append(eleccion)
    ultimo_numero = eleccion

    if suma >= 31:
        raise ValueError(f"Xogador {xogador} perdeu! A suma chegou a {suma}.")
    
    return suma, ultimo_numero


suma = 0
usados = []
ultimo_numero = None

try:
    
    while suma < 31:
        for xogador in xogadores:
            suma, ultimo_numero = turno_xogador(xogador, suma, valores_totais, usados, ultimo_numero)
            
except ValueError as erro:
    print(f"Erro: {erro}")


