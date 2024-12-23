#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Débese realizar unha aplicación para xestionar as vivendas que te a disposición unha inmobiliaria. Por cada vivenda débese saber a dirección na que se encontra, se está en venta ou en alugamento e o prezo de venta ou alugamento en cada caso.

A aplicación consta do seguinte menú:

    · a) Ingresar datos vivenda
    
    · b) Eliminar datos vivenda
    
        - Débese mostrar unha lista de vivendas nun menú e seleccionar a vivenda a eliminar segundo oíndice co seguinte formato: <índice>) <dirección>. <venta|alugamento> - <prezo> €.
        
        
    · c) Modificar estado de venta a alugamento, ou viceversa:
    
        - Débese mostrar unha lista de vivendas nun menú e seleccionar a vivenda a eliminar segundo oíndice co seguinte formato: <índice>) <dirección>. <venta|alugamento> - <prezo> €.
        
        
    · d) Mostrar vivendas en alugamento:
    
        - Débese mostrar co seguinte formato: <índice>) <dirección>. <venta|alugamento> - <prezo> €.
        
    
    e) Ver o prezo de alugamento máis repetido:
    
        - En caso de empate de prezos, indica o máis baixo.
        
        - Pista: utiliza diccionarios para realizar dito cálculo.
        
        - Se non hai vivendas de alugamento devolve None.
        
    
    f) Ver prezo de venta máis repetido:
    
        - En caso de empate de prezos, indica o máis baixo.
        
        - Pista: reutiliza funcións.
        
        - Se non hai vivendas en venda devolve None
        
    
    g) Saír. 
"""

__author__ = "Marcos Chouza Cruces"


def mostrar_vivendas(lista_vivendas: list) -> print:
    
    if type(lista_vivendas) != list:
        raise ValueError('O parámetro lista_vivendas non cumple co tipado esperado. (MOSTRAR VIVENDAS)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se pode amosar unha lista vacía. (MOSTRAR VIVENDAS)')
    
    for indice, diccionario in enumerate(lista_vivendas):
        print(f"\n{indice}) {diccionario['direccion']}. {diccionario['estado']} - {diccionario['prezo']} €.")



def ingresar_datos_vivenda(lista_vivendas: list, direccion: str, estado: str, prezo: float) -> list:
    
    if type(lista_vivendas) != list or type(direccion) != str or type(estado) != str or type(prezo) != float:
        raise ValueError('Os parámetros non cumplen co tipado esperado (INGRESAR DATOS VIVENDA)')
    if estado not in ['venta', 'aluguer']:
        raise ValueError('Os datos do parámetro "estado" son erróneos. (INGRESAR DATOS VIVENDA)')
    if prezo <= 0:
        raise ValueError('Ingrese un valor axeitado para o parámetro "prezo". (INGRESAR DATOS VIVENDA)')
    
    diccionario = {
        'direccion' : direccion,
        'estado' : estado,
        'prezo' : prezo
    }
    
    lista_vivendas.append(diccionario)
    
    return lista_vivendas



def eliminar_datos_vivenda(lista_vivendas: list, indice: int) -> list:
    
    if type(lista_vivendas) != list or type(indice) != int:
        raise ValueError('Os parámetros non cumplen co tipado esperado (ELIMINAR DATOS VIVENDA)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden elimianr elementos dunha lista baleira. (ELIMINAR DATOS VIVENDA)')
    if indice < 0 or indice > len(lista_vivendas):
        raise ValueError('Ingrese un índice válido. (ELIMINAR DATOS VIVENDA)')
    
    del lista_vivendas[indice]
    
    return lista_vivendas


def modificar_estado_vivenda(lista_vivendas: list, indice: int) -> list:
    
    if type(lista_vivendas) != list or type(indice) != int:
        raise ValueError('Os parámetros non cumplen co tipado esperado (MODIFICAR ESTADO VIVENDA)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden elimianr elementos dunha lista baleira. (MODIFICAR ESTADO VIVENDA)')
    if indice < 0 or indice > len(lista_vivendas):
        raise ValueError('Ingrese un índice válido. (MODIFICAR ESTADO VIVENDA)')
    
    
    diccionario = lista_vivendas[indice]
        
    if diccionario['estado'] == 'venta':
        diccionario['estado'] = 'aluguer'
        
    elif diccionario['estado'] == 'aluguer':
        diccionario['estado'] = 'venta'
        
    return lista_vivendas


def mostrar_vivendas_alugamento(lista_vivendas: list) -> print:
    
    if type(lista_vivendas) != list:
        raise ValueError('Os parámetros non cumplen co tipado esperado (MOSTRAR VIVENDAS ALUGAMENTO)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden elimianr elementos dunha lista baleira. (MOSTRAR VIVENDAS ALUGAMENTO)')
    
    for indice,diccionario in enumerate(lista_vivendas):
        if diccionario['estado'] == 'aluguer':
            print(f"\n{indice}) {diccionario['direccion']}. {diccionario['estado']} - {diccionario['prezo']} €.")


def prezo_alugamento_mais_repetido(lista_vivendas: list) -> float:
    if type(lista_vivendas) != list:
        raise ValueError('O parámetro "lista_vivendas" non coincide cos valores esperados (ALUGAMENTO MÁIS REPETIDO)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden sacar datos dunha lista baleira (ALUGAMENTO MÁIS REPETIDO)')

    prezos = [] #Inicializamos unha lsita vacía onde almacenaremos os prezos dos alugures

    for diccionario in lista_vivendas: #Recorremos a lista de vivendas
        if diccionario['estado'] == 'aluguer': #Establecemos a condición de que só lle afecte as vivendas alugadas
            prezos.append(diccionario['prezo']) #Almacenamos os prezos na lista 'prezos'

    if len(prezos) == 0: #Se a lista está vacía, significa que non existen vivendas en aluguer
        return None #Se a lista está vacía devolvemos None

    prezos_repetidos = [] #Inicializamos unha lista vacía
    vistos = [] #Inicializamos unha lista vacía

    for numero in prezos: #Recorremos os prezos de todos os alquileres
        if numero not in vistos: #Se o número non se atopa na lista 'vistos'
            vistos.append(numero) #Engadimos o número a lista 'vistos'
            
        else: #Se o número xa se atopa en vistos, engadímolo na lista de prezos repetidos
            if numero not in prezos_repetidos:
                prezos_repetidos.append(numero)

    if len(prezos_repetidos) == 0: #Se non existen prezos repetidos, devolvemos o prezo de vivenda máis baixo
        return min(prezos)
    
    return min(prezos_repetidos) #Devolvemos o prezo repetido máis baixo


def prezo_venta_mais_repetido(lista_vivendas: list) -> float:
    if type(lista_vivendas) != list:
        raise ValueError('O parámetro "lista_vivendas" non coincide cos valores esperados (ALUGAMENTO MÁIS REPETIDO)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden sacar datos dunha lista baleira (ALUGAMENTO MÁIS REPETIDO)')

    prezos = [] #Inicializamos unha lsita vacía onde almacenaremos os prezos dos alugures

    for diccionario in lista_vivendas: #Recorremos a lista de vivendas
        if diccionario['estado'] == 'venta': #Establecemos a condición de que só lle afecte as vivendas en venta
            prezos.append(diccionario['prezo']) #Almacenamos os prezos na lista 'prezos'

    if len(prezos) == 0: #Se a lista está vacía, significa que non existen vivendas en aluguer
        return None #Se a lista está vacía devolvemos None

    prezos_repetidos = [] #Inicializamos unha lista vacía
    vistos = [] #Inicializamos unha lista vacía

    for numero in prezos: #Recorremos os prezos de todos os alquileres
        if numero not in vistos: #Se o número non se atopa na lista 'vistos'
            vistos.append(numero) #Engadimos o número a lista 'vistos'
            
        else: #Se o número xa se atopa en vistos, engadímolo na lista de prezos repetidos
            if numero not in prezos_repetidos:
                prezos_repetidos.append(numero)

    if len(prezos_repetidos) == 0: #Se non existen prezos repetidos, devolvemos o prezo de vivenda máis baixo
        return min(prezos)
    
    return min(prezos_repetidos) #Devolvemos o prezo repetido máis baixo


lista_vivendas = []


while True:
    
    print("\n ----------------------- \n")
    print("Escolla a opción desexada do menú:")
    print("\t a) Ingresar datos vivenda: ")
    print("\t b) Eliminar datos vivenda: ")
    print("\t c) Modificar estado de venta a alugamento, ou viceversa: ")
    print("\t d) Mostrar vivendas en alugamento: ")
    print("\t e) Ver o prezo de alugamento máis repetido: ")
    print("\t f) Ver o prezo de venta máis repetido: ")
    print("\t g) Saír: ")
    print("\t h) Ver total de vivendas: ")
    
    option = input(">")
    
    if option == 'a':
        
        try:
            direccion = input("Ingrese a dirección da vivenda: ")
            estado = input("Ingrese o estado da vivenda ('venta' ou 'aluguer'): ")
            prezo = float(input("Ingrese o prezo da vivenda: "))
            
            ingresar_datos_vivenda(lista_vivendas, direccion, estado, prezo)
            
        except ValueError as erro:
            print(f"Erro: {erro}")
            
            
    elif option == 'b':
        
        try:
            
            mostrar_vivendas(lista_vivendas)
            indice = int(input("Ingrese o índice da vivenda a eliminar: "))
            eliminar_datos_vivenda(lista_vivendas, indice)
                
        except ValueError as erro:
            print(f"Erro: {erro}")


    elif option == 'c':
        try:
            mostrar_vivendas(lista_vivendas)
            indice = int(input("Ingrese o índice da vivenda a modificar: "))
            modificar_estado_vivenda(lista_vivendas, indice)
            
        except ValueError as erro:
            print(f"Erro: {erro}")        
            
    
    elif option == 'd':
        try:
            mostrar_vivendas_alugamento(lista_vivendas)
            
        except ValueError as erro:
            print(f"Erro: {erro}")
    
    
    elif option == 'e':
        try:
            
            alugamento_repetido = prezo_alugamento_mais_repetido(lista_vivendas)
            print(f"O prezo de alugamento máis repetido é: {alugamento_repetido}")
            
        except ValueError as erro:
            print(f"Erro: {erro}")   
            
    
    elif option == 'f':
        try:
            venta_repetida = prezo_venta_mais_repetido(lista_vivendas)
            print(f"O prezo de venta máis repetido é: {venta_repetida}")
            
        except ValueError as erro:
            print(f"Erro: {erro}")
    
    elif option == 'g':
        print("Saíndo...")
        break
    
    
    elif option == 'h':
        try:
            mostrar_vivendas(lista_vivendas)
            
        except ValueError as erro:
            print(f"Erro: {erro}")
            
    else:
        print("Erro: Entrada inesperada!!")