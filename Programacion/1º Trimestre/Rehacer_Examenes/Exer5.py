#!/usr/bin/env python
# -*- coding: utf-8 -*-

#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Débese realizar unha apliación para xestionar vivendas que ten a disposición unha inmobiliaria. Para cada vivenda débese saber a dirección na que se encontra, se esta está en venta ou en alugamento e o prezo de venta ou alugamento en cada caso.

A aplicación constará do seguinte menú:

    a) Ingresar datos vivenda
    
    
    b) Eliminar datos vivenda
    
        Débese mostrar unha lista de vivendas nun menú e seleccionar a vivenda a eliminar segundo o índice co seguinte formato: <índice>) <dirección>. <venta|alugamento> - <prezo> €.
    
    
    c) Modificar estado de venta a alugamento, ou viceversa

        Débese mostrar unha lista de vivendas nun menú e seleccionar a vivenda a eliminar segundo o índice co seguinte formato: <índice>) <dirección>. <venta|alugamento> - <prezo> €.
        
    
    d) Mostrar vivendas en alugamento

        Débese mostrar co seguinte formato: <índice>) <dirección>. <venta|alugamento> - <prezo> €.


    e) Ver o prezo de alugamento máis repetido.

        En caso de empate de prezos, indica o máis baixo.
        Pista: utiliza dicionarios para realizar dito cálculo.
        Se non hai vivendas de alugamento devolve None


    f) Ver o prezo de venta máis repetido.

        En caso de empate de prezos, indica o máis baixo.
        Pista: reutiliza funcións.
        Se non hai vivendas en venda devolve None

    g) Sair.
"""

__author__ = "Marcos Chouza Cruces"

def mostrar_datos(lista_vivendas: list) -> print:
    
    """
    Encárgase de amosar os datos de todas as vivendas almacenadas

    Args:
        lista_vivendas(list): Lista que almacena o conxunto de vivendas
    
    Raises:
        ValueError: Erro se o parámetro 'lista_vivendas' non é unha lista
        ValueError: Erro se o parámetro 'lista_vivendas' está vacía
    """
    #Capturamos posibles excepcións
    if type(lista_vivendas) != list:
        raise ValueError('Os parámetros introducidos non coinciden cos valores esperados (MOSTRAR DATOS)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden amosar datos dunha lista vacía (MOSTRAR DATOS)')
    
    #Amosamos por pantalla o conxunto de vivendas seguindo o formato seleccionado
    print(f"\nAs vivendas son:")
    for indice, diccionario in enumerate(lista_vivendas):
        print(f"\n{indice}) {diccionario['direccion']}. {diccionario['estado']} - {diccionario['prezo']} €.")


def ingresar_datos(lista_vivendas: list, direccion: str, estado: str, prezo: float) -> list:
    
    """
    Encárgase de ingresar os datos necesarios de cada vivenda

    Args:
        lista_vivendas(list): Lista que almacena o conxunto de vivendas
        direccion(str): Direccion da vivenda
        estado(str): Estado da vivenda
        prezo(float): Prezo da vivenda
        
    Raises:
        ValueError: Erro se os parámetros 'lista_vivendas', 'direccion', 'estado' ou 'prezo' non coinciden cos valores esperados.
        ValueError: Erro se o parámetro 'estado' non presenta datos correctos
        ValueError: Erro se o parámetro 'prezo' non presenta datos correctos

    Returns:
        list: Devolve a lista de vivendas actualizada cas novas vivendas
    """
    
    #Capturamos todas as posibles excepcións
    if type(lista_vivendas) != list or type(direccion) != str or type(estado) != str or type(prezo) != float:
        raise ValueError('Os parámetros introducidos non coinciden cos valores esperados (INGRESAR DATOS)')
    if estado not in ['venta', 'aluguer']:
        raise ValueError('Os valores do parámetro "estado" non son válidos (INGRESAR DATOS)')
    if prezo <= 0:
        raise ValueError('Os valores do parámetro "prezo" non son válidos (INGRESAR DATOS)')
    
    #Almacenamos os datos nun diccionario
    dicionario = {
        'direccion': direccion,
        'estado': estado,
        'prezo' : prezo
    }
    
    #Engadimos os datos á lista
    lista_vivendas.append(dicionario)
    
    return lista_vivendas

def eliminar_datos(lista_vivendas: list, indice: int) -> list:
    
    """
    Encárgase de eliminar a vivenda seleccionada
    
    Args:
        lista_vivendas(list): Lista que almacena o conxunto de vivendas
        indice(int): Indice da vivenda a eliminar

    Raises:
        ValueError: Erro se os parámetros 'lista_vivendas' ou 'indice' non coinciden cos valores esperados.
        ValueError: Erro se o parámetro 'lista_vivendas' está vacío
        ValueError: Erro se o parámetro 'indice' non presenta datos correctos

    Returns:
        list: Devolve a lista de vivenda actualizada sen a vivienda previamente seleccionada
    """
    
    #Capturamos todas as posibles excepcións
    if type(lista_vivendas) != list or type(indice) != int:
        raise ValueError('Os parámetros introducidos non coinciden cos valores esperados (ELIMINAR DATOS)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden eliminar datos dunha lista vacía (ELIMINAR DATOS)')
    if indice <0 or indice > len(lista_vivendas):
        raise ValueError('Os valores do parámetro "indice" non son válidos (ELIMINAR DATOS)')
    
    #Eliminamos a vivenda seleccionada
    del lista_vivendas[indice]
    
    return lista_vivendas

def modificar_vivenda(lista_vivendas: list, indice:int) -> list:
    
    """
    Encárgase de modificar a vivenda seleccionada
    
    Args:
        lista_vivendas(list): Lista que almacena o conxunto de vivendas
        indice(int): Indice da vivenda a eliminar

    Raises:
        ValueError: Erro se os parámetros 'lista_vivendas' ou 'indice' non coinciden cos valores esperados.
        ValueError: Erro se o parámetro 'lista_vivendas' está vacío
        ValueError: Erro se o parámetro 'indice' non presenta datos correctos

    Returns:
        list: Devolve a lista de vivenda actualizada ca vivenda modificada previamente seleccionada
    """
    
    #Capturamos todas as posibles excepcións
    if type(lista_vivendas) != list or type(indice) != int:
        raise ValueError('Os parámetros introducidos non coinciden cos valores esperados (MODIFICAR DATOS)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden eliminar datos dunha lista vacía (MODIFICAR DATOS)')
    if indice <0 or indice > len(lista_vivendas):
        raise ValueError('Os valores do parámetro "indice" non son válidos (MODIFICAR DATOS)')

    #Modificamos os datos precisos dependendo do seu estado    
    diccionario = lista_vivendas[indice]
    
    if diccionario['estado'] == 'venta':
        diccionario['estado'] = 'aluguer'
    else:
        diccionario['estado'] = 'venta'
    
    return lista_vivendas

def mostrar_vivendas_alugamento(lista_vivendas:list) -> print:
    
    """
    Encárgase de amosar os datos de todas as vivendas alugadas

    Args:
        lista_vivendas(list): Lista que almacena o conxunto de vivendas
    
    Raises:
        ValueError: Erro se o parámetro 'lista_vivendas' non é unha lista
        ValueError: Erro se o parámetro 'lista_vivendas' está vacía
    """
    
    #Capturamos todas as posibles excepcións
    if type(lista_vivendas) != list:
        raise ValueError('Os parámetros introducidos non coinciden cos valores esperados (MOSTRAR DATOS)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden amosar datos dunha lista vacía (MOSTRAR DATOS)')
    
    #Amosamos as todas as vivendas en aluguer seguindo o formato seleccionado 
    for indice,diccionario in enumerate(lista_vivendas):
        if diccionario['estado'] == 'aluguer':
            print(f"\n{indice}) {diccionario['direccion']}. {diccionario['estado']} - {diccionario['prezo']} €.")


def prezo_alugamento_mais_repetido(lista_vivendas:list) -> float:
    
    """
    Encárgase de devolver o prezo de alugamento máis repetido, en caso de non haber repetidos, devolve o prezo máis baixo.
    Ademais, en caso de non haber vivendas en alugamento, devolve None

    Args:
        lista_vivendas(list): Lista que almacena o conxunto de vivendas
        
    Raises:
        ValueError: Erro se o parámetro 'lista_vivendas' non é unha lista
        ValueError: Erro se o parámetro 'lista_vivendas' está vacía

    Returns:
        float: Prezo de alugamento máis repetido
    """
    
    #Capturamos todas as posibles excepcións
    if type(lista_vivendas) != list:
        raise ValueError('O parámetro "lista_vivendas" non coincide cos valores esperados (ALUGAMENTO MÁIS REPETIDO)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden sacar datos dunha lista baleira (ALUGAMENTO MÁIS REPETIDO)')

    #Inicializamos unha lista onde almacenaremos os prezos das vivendas en aluguer
    prezos = []
    
    for diccionario in lista_vivendas:
        if diccionario['estado'] == 'aluguer':
            prezos.append(diccionario['prezo'])

    #Devolvemos non se non existen vivendas en aluguer
    if len(prezos) == 0:
        return None
    
    #Inicializamos duas listas, onde almacenaremos os prezos repetidos
    prezos_repetidos = []
    vistos = []
    
    for numero in prezos:
        if numero not in vistos:
            vistos.append(numero)
        else:
            prezos_repetidos.append(numero)
    
    #Se non existen prezos repetidos, devolvemos o prezo de aluguer máis baixo 
    if len(prezos_repetidos) == 0:
        return min(prezos)
    
    #Devolvemos o prezo repetido máis baixo
    return min(prezos_repetidos)

def prezo_venta_mais_repetido(lista_vivendas:list) -> float:
    
    """
    Encárgase de devolver o prezo de venta máis repetido, en caso de non haber repetidos, devolve o prezo máis baixo.
    Ademais, en caso de non haber vivendas en alugamento, devolve None

    Args:
        lista_vivendas(list): Lista que almacena o conxunto de vivendas
        
    Raises:
        ValueError: Erro se o parámetro 'lista_vivendas' non é unha lista
        ValueError: Erro se o parámetro 'lista_vivendas' está vacía

    Returns:
        float: Prezo de venta máis repetido
    """
    
    #Capturamos todas as posibles excepcións
    if type(lista_vivendas) != list:
        raise ValueError('O parámetro "lista_vivendas" non coincide cos valores esperados (ALUGAMENTO MÁIS REPETIDO)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden sacar datos dunha lista baleira (ALUGAMENTO MÁIS REPETIDO)')

    #Inicializamos unha lista onde almacenaremos os prezos das vivendas en venta
    prezos = []
    
    for diccionario in lista_vivendas:
        if diccionario['estado'] == 'venta':
            prezos.append(diccionario['prezo'])

    #Devolvemos non se non existen vivendas en venta
    if len(prezos) == 0:
        return None
    
    #Inicializamos duas listas, onde almacenaremos os prezos repetidos
    prezos_repetidos = []
    vistos = []
    
    for numero in prezos:
        if numero not in vistos:
            vistos.append(numero)
        else:
            prezos_repetidos.append(numero)
    
    #Se non existen prezos repetidos, devolvemos o prezo de venta máis baixo 
    if len(prezos_repetidos) == 0:
        return min(prezos)
    
    #Devolvemos o prezo repetido máis baixo
    return min(prezos_repetidos)


#Inicializamos unha lista vacía onde iremos almacenando todas as vivendas cos seus datos
lista_vivendas = []

#Amosamos o menu cas opcións a escoller
while True:
    print("\n ---------------------------------- \n")
    print("Escolla a opción do menu a desexar:")
    print("\t a) Ingresar datos vivenda: ")
    print("\t b) Eliminar datos vivenda: ")
    print("\t c) Modificar estado de venta a alugamento, ou viceversa: ")
    print("\t d) Mostrar vivendas en alugamento: ")
    print("\t e) Ver o prezo de alugamento máis repetido: ")
    print("\t f) Ver o prezo de venta máis repetido: ")
    print("\t g) Sair: ")
    print("\t h) Mostrar datos: ")
    
    #Pedísmoslle ao usuario que escolla a opción desexada
    option = input(">").lower()
    
    #Opción a
    if option == 'a':
        try:
            direccion = input("Ingrese a direccion da vivenda: ")
            estado = input("Ingrese o estado da vivenda ('venta' ou 'aluguer'): ").lower().strip()
            prezo = float(input("Ingrese o prezo da vienda: "))
            ingresar_datos(lista_vivendas, direccion, estado, prezo)
            
        except ValueError as erro:
            print(f"Erro: {erro}")
            
    #Opción b
    if option == 'b':
        try:
            mostrar_datos(lista_vivendas)
            indice= int(input("\nIngrese o índice da vivenda a eliminar: "))
            eliminar_datos(lista_vivendas, indice)
        except ValueError as erro:
            print(f"Erro: {erro}")
            
    #Opción c      
    if option == 'c':
        try:
            mostrar_datos(lista_vivendas)
            indice= int(input("\nIngrese o índice da vivenda a modificar: "))
            modificar_vivenda(lista_vivendas, indice)
        except ValueError as erro:
            print(f"Erro: {erro}")
            
    #Opción d        
    if option == 'd':
        try:
            print(f"\nAs vivendas en alugamento son:")
            mostrar_vivendas_alugamento(lista_vivendas)
        except ValueError as erro:
            print(f"Erro: {erro}")
            
    #Opción e        
    if option == 'e':
        try:
            alugamento_repetido = prezo_alugamento_mais_repetido(lista_vivendas)
            print(f"\nO prezo de alugamento máis repetido é {alugamento_repetido}")
        except ValueError as erro:
            print(f"Erro: {erro}")
            
    #Opción f        
    if option == 'f':
        try:
            venta_repetida = prezo_alugamento_mais_repetido(lista_vivendas)
            print(f"\nO prezo de venta máis repetido é {venta_repetida}")
        except ValueError as erro:
            print(f"Erro: {erro}")
            
    #Opción g        
    if option == 'g':
        try:
            print(f"Saíndo...")
            break
        except ValueError as erro:
            print(f"Erro: {erro}")
            
            
    #Opción h
    if option == 'h':
        try:
            mostrar_datos(lista_vivendas)
        except ValueError as erro:
            print(f"Erro: {erro}")