#!/usr/bin/env python
# -*- coding: utf-8 -*-

#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Débese realizar unha aplicación para xestionar a vivendas que ten a disposición unha inmobiliaria. Para cada vivenda débese saber a dirección na que se encontra, se está en venta ou en alugamento e o prezo de venta ou alugamento en cada caso.

A aplicación constará do seguinte menú:

    a) Ingresar datos vivenda
    
    b) Eliminar datos vivenda
    
        · Débese mostrar unha lista de vivendas nun menú e seleccionar a vivenda a eliminar seguindo o índice co seguinte formato: <índice>) <dirección>. <venta|alugamento> - <prezo> €.
    
    
    c) Modificar estado de venta a alugamento, ou viceversa
    
        · Débese mostrar unha lista de vivendas nun menú e seleccionar a vivenda a eliminar seguindo o índice co seguinte formato: <índice>) <dirección>. <venta|alugamento> - <prezo> €.
    
    
    d) Mostrar vivendas en alugamento

        · Débese mostrar unha lista de vivendas nun menú e seleccionar a vivenda a eliminar seguindo o índice co seguinte formato: <índice>) <dirección>. <venta|alugamento> - <prezo> €.
    
    
    e) Ver o prezo de alugamento máis repetido
    
        · En caso de empate de prezos, indica o máis baixo.
        
        · Pista: utiliza diccionarios para realizar dito cálculo.
        
        · Se non hai vivendas de alugamento devolve None.
    
    
    f) Ver o prezo de ventas máis repetido
    
        · En caso de empate de prezos, indica o máis baixo.
        
        · Pista: reutiliza funcións.
        
        · Se non hai vivendas en venda devolve None.
        
        
    g) Sair.
    
"""

__autor__ = "Marcos Chouza Cruces"


def mostrar_datos(lista_vivendas: list):

    """
    Encárgase de dar unha saída por pantalla onde amosa todas as vivendas da lista

    Args:
        lista_vivendas(list): Lista onde se almacenan as distintas vivendas.

    Raises:
        ValueError: O parámetro 'lista_vivendas' é unha lista.
        ValueError: A lista non está baleira.
    """

    if type(lista_vivendas) is not list:
        raise ValueError('O parámetro "lista_vivendas" non coincide cos valores esperados (MOSTRAR DATOS).')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden amosar datos dunha lista vacía (MOSTRAR DATOS).')

    print("A lista de vivendas son:")
    for indice, diccionario in enumerate(lista_vivendas):
        print(f"\n{indice}) {diccionario['direccion']}. {diccionario['estado']} - {diccionario['prezo']} €.")


def ingresar_datos(lista_vivendas: list, direccion: str, estado: str, prezo: float) -> list:

    """
    Encárgase de almacenar os datos pedidos por teclado ao usuario nun diccionario e engade dito diccionario á lista

    Args:
        lista_vivendas(list): Lista onde se almacenan as distintas vivendas.
        direccion(str): Dirección da vivenda.
        estado(str): Estado da vivenda: 'venta' ou 'alugamento'.
        prezo(float): Prezo da vivenda

    Raises:
        ValueError: O parámetro 'lista_vivendas' é unha lista.
        ValueError: O parámetro 'direccion' é unha cadea de texto.
        ValueError: O parámetro 'estado' é unha cadea de texto.
        ValueError: O parámetro 'prezo' é un número decimal.
        ValueError: Os únicos valores posibles para estado: 'venta' ou 'alugamento'.
        ValueError: Delimita os valores válidos para o prezo.

    Returns:
        list: devovle unha lista cas distintas vivendas.
    """

    if type(lista_vivendas) is not list:
        raise ValueError('O parámetro "lista_vivendas" non coincide cos valores esperados (INGRESAR DATOS).')
    if type(direccion) is not str:
        raise ValueError('O parámetro "direccion" non coincide cos valores esperados (INGRESAR DATOS).')
    if type(estado) is not str:
        raise ValueError('O parámetro "estado" non coincide cos valores esperados (INGRESAR DATOS).')
    if type(prezo) is not float:
        raise ValueError('O parámetro "prezo" non coincide cos valores esperados (INGRESAR DATOS).')
    if estado not in ["venta", "aluguer"]:
        raise ValueError('O estado non coincide co esperado: Introduzca "venta" ou "aluguer" (INGRESAR DATOS).')
    if prezo <= 0:
        raise ValueError('Introduce un prezo válido para a vivenda (INGRESAR DATOS).')
    
    diccionario = {
        'direccion' : direccion,
        'estado' : estado,
        'prezo' : prezo
    }

    return lista_vivendas.append(diccionario)


def eliminar_datos(lista_vivendas: list, indice: int) -> list:

    """
    Encárgase de eliminar os datos da lista dependendo do índice que escolla o usuario.

    Args:
        lista_vivendas(list): Lista onde se almacenan as vivendas.
        indice(int): Índice da vivenda a eliminar.

    Raises:
        ValueError: O parámetro 'lista_vivendas' é unha lista.
        ValueError: A lista non se atopa baleira.
        ValueError: O parámetro 'indice' é un número enteiro.
        ValueError: Delimita os valore válidos que pode tomar o índice.

    Returns:
        list: Devolve a lista de vivendas sen o valor eliminado previamente
    """

    if type(lista_vivendas) is not list:
        raise ValueError('O parámetro "lista_vivendas" non coincide cos valores esperados (ELIMINAR DATOS).')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden amosar datos dunha lista vacía (ELIMINAR DATOS).')
    if type(indice) is not int:
        raise ValueError('O parámetro "indice" non coincide cos valores esperados (ELIMINAR DATOS).')
    if indice < 0 or indice >= len(lista_vivendas):
        raise ValueError('Ingrese un índice válido (ELIMINAR DATOS).')

    del lista_vivendas[indice]

    return lista_vivendas


def modificar_estado(lista_vivendas: list, indice: int) -> list:

    """
    Encárgase de cambiar o estado da vivienda, de 'venta' a 'aluguer' e viceversa.

    Args:
        lista_vivendas(list): Lista onde se almacenan as vivendas.
        indice(int): Índice da vivenda a modificar.

    Raises:
        ValueError: O parámetro 'lista_vivendas' é unha lista.
        ValueError: A lista non se atopa baleira.
        ValueError: O parámetro 'indice' é un número enteiro.
        ValueError: Delimita os valore válidos que pode tomar o índice.

    Returns:
        list: Devolve a lista de vivendas cas modificación realizadas previamente.
    """

    if type(lista_vivendas) is not list:
        raise ValueError('O parámetro "lista_vivendas" non coincide cos valores esperados (MODIFICAR ESTADO).')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden amosar datos dunha lista vacía (MODIFICAR ESTADO).')
    if type(indice) is not int:
        raise ValueError('O parámetro "indice" non coincide cos valores esperados (MODIFICAR ESTADO).')
    if indice < 0 or indice >= len(lista_vivendas):
        raise ValueError('Ingrese un índice válido (MODIFICAR ESTADO).')
    
    diccionario = lista_vivendas[indice]

    if diccionario['estado'] == 'venta':
        diccionario['estado'] = 'aluguer'
    else:
        diccionario['estado'] = 'venta'

    return lista_vivendas


def mostrar_vivendas_alugadas(lista_vivendas: list):

    """
    Encárgase de amosar as vivendas que se atopan en aluguer.

    Args:
        lista_vivendas(list): Lista onde se amlacenan as vivendas.

    Raises:
        ValueError: O parámetro 'lista_vivendas' é unha lista.
        ValueError: A lista non se atopa baleira.
    """

    if type(lista_vivendas) is not list:
        raise ValueError('O parámetro "lista_vivendas" non coincide cos valores esperados (MOSTRAR ALUGUERES).')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden amosar datos dunha lista vacía (MOSTRAR ALUGUERES).')
    
    for indice, diccionario in enumerate(lista_vivendas):
        if diccionario['estado'] == 'aluguer':
            print(f"\n{indice}) {diccionario['direccion']}. {diccionario['estado']} - {diccionario['prezo']} €.")



lista_vivendas = []

while True:
    print("\n ---------------------------------------- \n")
    print("Escolla a opción do menú a escoller.")
    print("\t a) Ingresar datos vivenda: ")
    print("\t b) Eliminar datos vivenda: ")
    print("\t c) Modificar estado de venta a alugamento, ou viceversa: ")
    print("\t d) Mostrar vivendas en alugamento: ")
    print("\t e) Ver o prezo de alugamento máis repetido: ")
    print("\t f) Ver o prezo de venta máis repetido: ")
    print("\t g) Saír: ")
    print("\t h) Mostrar vivendas: ")


    option = input(">")

    #Mostrar vivendas
    if option == 'h':

        try:
            mostrar_datos(lista_vivendas)

        except ValueError as erro:
            print(f"Erro: {erro}")


    #Ingresar datos
    elif option == 'a':

        try:
            direccion = input("Ingrese a direccion da vivenda: ")
            estado = input("Ingrese o estado da vivenda (só se recollerá 'venta' ou 'aluguer'): ").lower().strip()
            prezo = float(input("Ingrese o prezo da vivenda: "))
            ingresar_datos(lista_vivendas, direccion, estado, round(prezo, 2))

        except ValueError as erro:
            print(f"Erro: {erro}")


    #Eliminar datos vivenda
    elif option == 'b':

        try:
            mostrar_datos(lista_vivendas)
            indice = int(input("\nIngrese o índice da vivenda a eliminar: "))
            eliminar_datos(lista_vivendas, indice)

        except ValueError as erro:
            print(f"Erro: {erro}")


    #Modificar estado de venta (venta -> alugamento || alugamento -> venta)
    elif option == 'c':
        try:
            mostrar_datos(lista_vivendas)
            indice = int(input("\nIngrese o índice da vivenda a modificar: "))
            modificar_estado(lista_vivendas, indice)

        except ValueError as erro:
            print(f"Erro: {erro}")


    #Mostrar vivendas en alugamento
    elif option == 'd':
        try:
            mostrar_vivendas_alugadas(lista_vivendas)

        except ValueError as erro:
            print(f"Erro: {erro}")


    #Ver o prezo de alugamento máis repetido
    elif option == 'e':

        try:
            print("opcion e")


        except ValueError as erro:
            print(f"Erro: {erro}")


    #Ver prezo de venta máis repetido
    elif option == 'f':
        try:
            print("opcion f")

        except ValueError as erro:
            print(f"Erro: {erro}")


    #Saír
    elif option == 'g':
        print("Saíndo...")
        break