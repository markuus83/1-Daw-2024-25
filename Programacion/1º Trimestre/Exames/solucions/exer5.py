#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Débese realizar unha aplicación para xestionar as vivendas que ten a disposición unha inmobiliaria. Para cada vivenda débese saber a dirección na que se encontra, se esta está en venta ou en alugamento e o prezo de venta ou alugamento en cada caso.

A aplicación constará do seguinte menú:

- `a) Ingresar datos vivenda`

- `b) Eliminar datos vivenda`
    - Débese mostrar unha lista de vivendas nun menú e seleccionar a vivenda a eliminar segundo o índice co seguinte formato: `<índice>) <dirección>. <venta|alugamento> - <prezo> €`.

- `c) Modificar estado de venta a alugamento, ou viceversa`
    - Débese mostrar unha lista de vivendas nun menú e seleccionar a vivenda a eliminar segundo o índice co seguinte formato: `<índice>) <dirección>. <venta|alugamento> - <prezo> €`.

- `d) Mostrar vivendas en alugamento`
    - Débese mostrar co seguinte formato: `<índice>) <dirección>. <venta|alugamento> - <prezo> €`.

- `e) Ver o prezo de alugamento máis repetido`.
    - En caso de empate de prezos, indica o máis baixo. 
    - Pista: utiliza dicionarios para realizar dito cálculo.
    - Se non hai vivendas de alugamento devolve `None`

- `f) Ver o prezo de venta máis repetido`.
    - En caso de empate de prezos, indica o máis baixo. 
    - Pista: reutiliza funcións.
    - Se non hai vivendas en venda devolve `None`

- `g) Sair`.
"""

__author__ = "Manuel Ramón Varela López"

def comprobar_prezo(prezo):
    """
    Comproba que o prezo é correcto

    Args:
        prezo (in/float): O prezo a comprobar

    Returns:
        bool: Verdadeiro se é válido, Falso en caso contrario
    """
    if not(type(prezo) is float or type(prezo) is int):
        return False
    if prezo < 0:
        return False
    return True

def crear_vivenda_venta(direccion, prezo):
    """
    Crea unha vivdenda en venda

    Args:
        direccion (str): Dirección da vivenda
        prezo (float/int): Prezo de venda da vivenda

    Raises:
        ValueError: Se os valores e tipos de datos dos parámetros son inválidos

    Returns:
        dict: Dicionario que representa a vivenda en venda
    """
    if not(type(direccion) is str):
        raise ValueError
    if not comprobar_prezo(prezo):
        raise ValueError

    return {
        "direccion": direccion,
        "venta": True,
        "prezo": prezo
    }

def crear_vivenda_aluguer(direccion, prezo):
    """
    Crea unha vivdenda en alugamento

    Args:
        direccion (str): Dirección da vivenda
        prezo (float/int): Prezo de venda da vivenda

    Raises:
        ValueError: Se os valores e tipos de datos dos parámetros son inválidos

    Returns:
        dict: Dicionario que representa a vivenda en alugamento
    """
    if not(type(direccion) is str):
        raise ValueError
    if not comprobar_prezo(prezo):
        raise ValueError

    return {
        "direccion": direccion,
        "venta": False,
        "prezo": prezo
    }

def comprobar_vivenda(vivenda):
    """
    Comproba se un dicionario é unha vivenda

    Args:
        vivenda (dict): Dicionario a comprobar

    Returns:
        bool: Se o dicionario é unha vivenda devolve verdadeiro, falso en caso contrario
    """
    if not(type(vivenda) is dict):
        return False
    if "nome" not in vivenda or "apelidos" not in vivenda or "nota" not in vivenda:
        return False
    if type(vivenda["direccion"]) is not str or type(vivenda["venta"]) is not bool or not comprobar_prezo(vivenda["prezo"]):
        return False
    return True 

def engadir_vivenda(stock, vivenda):
    """
    Engade unha vivenda ao stock

    Args:
        stock (list): A lista coas vivendas
        vivenda (dict): O dicionario que representa unha vivenda

    Raises:
        ValueError: Se os valores e tipos de datos dos parámetros son inválidos
    """
    # Comprobamos o tipo de datos
    if not(type(stock) is list):
        raise ValueError
    if not comprobar_vivenda(vivenda):
        raise ValueError
    
    # Gardamolo na lista
    stock.append(vivenda)

def imprimir_vivendas(stock):
    """
    Imprime unha lista de vivendas por pantalla

    Args:
        stock (list): A lista de vivendas

    Raises:
        ValueError: Se os valores e tipos de datos dos parámetros son inválidos
    """
    # Comprobamos que sexa unha lista
    if not(type(stock) is list):
        raise ValueError

    for valor in stock:
        # Comprobamos que sexa un alumno
        if not comprobar_vivenda(valor):
            raise ValueError

    for indice, valor in enumerate(stock):
        dir = vivenda["direccion"]
        if vivenda["venta"]:
            tipo = "venta"
        else:
            tipo = "alugamento"
        prezo = vivenda["prezo"]
        vivenda_str = f"{indice}) {dir}. {tipo} - {prezo} €"
        print(vivenda_str)


def eliminar_vivenda(stock, indice):
    """
    Elimina unha vivenda da lista

    Args:
        stock (list): A lista de vivendas
        indice (int): O índice da vivenda a eliminar

    ValueError: Se os valores e tipos de datos dos parámetros son inválidos
    """
    # Comprobamos que sexa unha lista
    if not(type(stock) is list):
        raise ValueError
    if not(type(indice) is int):
        raise ValueError
    if indice >= 0  and indice < len(stock):
        stock.pop(indice)
    else:
        raise ValueError

def modificar_tipo_vivenda(stock, indice):
    """
    Modifica o tipo de vivenda da lista

    Args:
        stock (list): A lista de vivendas
        indice (int): O índice da vivenda a modificar o tipo

    ValueError: Se os valores e tipos de datos dos parámetros son inválidos
    """
    # Comprobamos que sexa unha lista
    if not(type(stock) is list):
        raise ValueError
    if not(type(indice) is int):
        raise ValueError  

    if indice >= 0  and indice < len(stock):
        stock[indice]["venta"] = not stock[indice]["venta"]
    else:
        raise ValueError

def get_vivendas_por_tipo(stock, venda = False):
    """
    Devolve as vivendas segundo o seu tipo

    Args:
        stock (list): Unha lista de vivendas
        venda (bool, optional): True para as vivendas en venda e False para as de alugamento. Defaults to False.

    ValueError: Se os valores e tipos de datos dos parámetros son inválidos

    Returns:
        list: lista de vivendas
    """
    if not(type(stock) is list):
        raise ValueError
    
    vivendas_tipo = []
    for vivenda in stock:
        if not comprobar_vivenda(vivenda):
            raise ValueError
        if vivenda["venta"] == venda:
            vivendas_tipo.append(vivenda)
    return vivendas_tipo

def get_prezo_mais_repetido(stock):
    """
    Devolve o prezo do vivendas máis barato. Se hai dous que se repiten o mesmo número de veces, devolvese o menor deles

    Args:
        stock (list): Lista de vivendas

    Raises:
        ValueError: Se os valores e tipos de datos dos parámetros son inválidos

    Returns:
        float: O prezo máis barato
    """
    if not(type(stock) is list):
        raise ValueError
    
    # Collemos as vivendas de alugamentos
    prezos_repeticions = {}
    for vivenda in stock:
        prezo = vivenda["prezo"]
        if prezo in prezos_repeticions:
            prezos_repeticions[prezo] += 1
        else:
            prezos_repeticions[prezo] = 1

    if len(prezos_repeticions) == 0:
        return None
    
    # Collemos o máis repetido
    mais_repetido = None
    veces_mais_repetido = None
    for prezo, repiticions in prezos_repeticions.items():
        # Ainda non asignamos ningun
        if mais_repetido is None and veces_mais_repetido is None:
            mais_repetido = prezo
            veces_mais_repetido = repiticions
        # Atopamos un que se repite o mesmo numero de veces, asi que collemos o de prezo máis baixo
        elif veces_mais_repetido == repiticions:
            if prezo < mais_repetido:
                mais_repetido = prezo
                veces_mais_repetido = repiticions
        # Atopamos un con máis repeticións
        elif veces_mais_repetido < repiticions:
            mais_repetido = prezo
            veces_mais_repetido = repiticions
    
    return mais_repetido
    


### Programa principal
catalogo_vivendas = []

while True:
    print("Elixe unha opción: ")
    print("a) Engadir_vivenda.")
    print("b) Eliminar datos vivenda.")
    print("c) Modificar estado de venta a alugamento, ou viceversa")
    print("d) Mostrar vivendas en alugamento")
    print("e) Ver o prezo de alugamento máis repetido")
    print("f) Ver o prezo de venda máis repetido")
    print("g) Saír")
    opcion = input("> ")

    ## a) Ingresar datos dunha vivenda.
    if opcion == "a":
        try:
            # Collemolos datos
            direccion = input("Introduce a direccion: ")
            venda = None
            while venda is None: 
                aux = input("Introduce v) para unha vivenda en venda e a) para unha vivenda en alugamento")
                if aux == "v":
                    venda = True
                elif aux == "a":
                    venda = False
                else:
                    print("Introduce un valor correcto")
            prezo = float(input("Introduce un prezo: "))

            # Creamos o alumno representado nun dicionario e engadimolo
            if venda:
                vivenda = crear_vivenda_venta(direccion, prezo)
            else:
                vivenda = crear_vivenda_aluguer(direccion, prezo)            
            engadir_vivenda(catalogo_vivendas, vivenda)
        except:
            print("Introduce valores válidos.")

    ## b) Eliminar datos vivenda
    elif opcion == "b":
        try:
            # Imprimimos as vivendas
            imprimir_vivendas(catalogo_vivendas)
            indice = int(input("Índice da vivenda a borrar: "))
            eliminar_vivenda(catalogo_vivendas, indice)
        except:
            print("Introduce un índice válido")

    ## c) Modificar estado de venta a alugamento, ou viceversa
    elif opcion == "c":
        try:
            # Imprimimos as vivendas
            imprimir_vivendas(catalogo_vivendas)
            indice = int(input("Índice do vivenda a modificar: "))
            modificar_tipo_vivenda(catalogo_vivendas, indice)
        except:
            print("Introduce un índice válido")

    ## d) Mostrar vivendas en alugamento
    elif opcion == "d":
        try:
            # Imprimimos o alumnado aprobado
            imprimir_vivendas(get_vivendas_por_tipo(catalogo_vivendas))
        except:
            print("Aconteceu un problema coa lista")

    ## e) Ver o prezo de alugamento máis repetido
    elif opcion == "e":
        try:
            vivendas_aluguer = get_vivendas_por_tipo(catalogo_vivendas)
            prezo_alquiler = get_prezo_mais_repetido(vivendas_aluguer)
            print(prezo_alquiler)
        except:
            print("Aconteceu un problema coa lista")

    # f) Ver o prezo de venta máis repetido
    elif opcion == "f":
        try:
            vivendas_venta = get_vivendas_por_tipo(catalogo_vivendas, venda=True)
            prezo_venta = get_prezo_mais_repetido(vivendas_venta)
            print(prezo_venta)
        except:
            print("Aconteceu un problema coa lista")

    elif opcion == "g":
        break

    else:
        print("Opcion incorrecta")