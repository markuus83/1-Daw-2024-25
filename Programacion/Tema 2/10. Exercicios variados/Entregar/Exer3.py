#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
<Pasa a calculadora!> é un xogo para dúas persoas no que se comeza cunha calculadora e cada xogador, de xeito alterno, suma unnúmero novo, dun só díxito, ao valor acumulado ata o momento, comezando en 0. O xogador que, traas sumar o seu número, chegue a un resultado maior ou igual a 31 perde.

Ademais, en cada turno un xogador só pode utilizar os números na mesma fila ou columno que o díxito marcado polo seu opoñente no turno anterior, pero non pode repetir o número. Evidentemente, o número 0 non se pode utilizar nunca.

Por exemplo, imaxina que, durante unha partida, un xogador recibe a calculadora mostrándolee o número 28, e o opoñente acaba de introducir o número 9. A partir da disposición dos números da calculadora, sabemos que nesta quenda unicamente poderá xogar os números 3, 6, 7 e 8.

Implanta este xogo
"""

__author__ = "Marcos Chouza Cruces"


# Definimos un dicionario onde para cada número (chave) temos unha lista de números posibles que poden seguirse
# de acordo coas regras do xogo. Por exemplo, se o xogador escoller o número 1, pode elixir entre os números 2, 3, 4, ou 7.
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

# Lista de xogadores (neste caso, xogador 1 e xogador 2)
xogadores = [1, 2]

# Función para obter os números posibles que pode escoller un xogador
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
    
    # Se o último número non é None e non está en valores_totais, lanzarase un erro
    if ultimo_numero is not None and ultimo_numero not in valores_totais:
        raise ValueError(f"Último número ({ultimo_numero}) non é válido en valores_totais.")
    
    try:
        # Se existe un último número, devolve os números posibles de acordo co dicionario
        # e filtra aqueles que xa foron usados
        if ultimo_numero:
            return [n for n in valores_totais[ultimo_numero] if n not in usados]
        
        # Se non hai último número, devolve todos os números entre 1 e 9 que non foron usados
        else:
            return [n for n in range(1, 10) if n not in usados]
        
    except Exception as e:
        # En caso de erro, se produce un fallo, lanzamos un erro personalizado
        raise ValueError(f"Erro ao obter números posibles: {e}")


# Función que xestiona a elección dun xogador entre os números posibles
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
            # Pedimos ao xogador que escolla un número entre os posibles
            eleccion = int(input(f"Escolle un número de {posibles}: "))
            
            # Se a elección está na lista de números posibles, devolvemola
            if eleccion in posibles:
                return eleccion
            raise ValueError(f"O número {eleccion} non está na lista de números posibles.")
        
        except ValueError as e:
            # Se a entrada non é un número válido ou non está na lista de posibles, avisamos ao xogador
            print(f"Entrada non válida. {e}. Intenta novamente.")
            
        except Exception as e:
            # Se ocorre un erro inesperado, lanzamos unha excepción
            raise ValueError(f"Erro inesperado ao obter elección: {e}")


# Función que xestiona un turno dun xogador no xogo
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
    
    # Obtemos os números posibles para o xogador, baseados no último número xogador e os números xa usados
    posibles = obtener_posibles_numeros(ultimo_numero, valores_totais, usados)
    
    # Se non hai números posibles para escoller, o xogador perde
    if not posibles:
        raise ValueError(f"Xogador {xogador} perdeu porque non pode xogar! Non hai números posibles.")
    
    # O xogador elixe un número válido entre os posibles
    eleccion = obtener_eleccion(posibles)
    
    # Actualizamos a suma e a lista de números usados
    suma += eleccion
    usados.append(eleccion)
    
    # O último número xogador escollido actualízase
    ultimo_numero = eleccion

    # Se a suma chega ou supera 31, o xogador perde
    if suma >= 31:
        raise ValueError(f"Xogador {xogador} perdeu! A suma chegou a {suma}.")
    
    return suma, ultimo_numero


# Variables que controlan o estado do xogo
suma = 0  # Inicializamos a suma a 0
usados = []  # Lista para rastrexar os números xa usados
ultimo_numero = None  # Non hai último número ao inicio

# Intentamos executar o xogo
try:
    # Mentres a suma non chegue a 31, o xogo continúa
    while suma < 31:
        for xogador in xogadores:  # O xogo alterna entre os xogadores 1 e 2
            suma, ultimo_numero = turno_xogador(xogador, suma, valores_totais, usados, ultimo_numero)
            
# Se ocorre un erro durante o xogo, é capturado aquí
except ValueError as erro:
    print(f"Erro: {erro}")
