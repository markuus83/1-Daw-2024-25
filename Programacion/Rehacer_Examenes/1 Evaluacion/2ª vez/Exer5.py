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

def ingresar_datos_vivendas(lista_vivendas: list, direccion:str, estado:str, prezo: float) -> list:
    
    if type(lista_vivendas) != list or type(direccion) != str or type(estado) != str or type(prezo) != float:
        raise ValueError('Os parámetros ingresados non coinciden cos valores esperados (INGRESAR DATOS)')
    if estado not in ['venta', 'aluguer']:
        raise ValueError('Ingrese datos válidos para o estado (INGRESAR DATOS)')
    if prezo <= 0:
        raise ValueError('Ingrese datos válidos para o prezo (INGRESAR DATOS)')
    
    diccionario = {
        'direccion' : direccion,
        'estado': estado,
        'prezo': prezo
    }
        
    lista_vivendas.append(diccionario)
        
    return lista_vivendas


def mostrar_datos(lista_vivendas: list) -> print:
    
    if type(lista_vivendas) != list:
        raise ValueError('Os parámetros ingresados non coinciden cos valores esperados (MOSTRAR DATOS)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se pode amosar unha lista baleira (MOSTRAR DATOS)')
    
    print("As vivendas son: ")
    
    for indice, diccionario in enumerate(lista_vivendas):
        print(f"\n{indice}) {diccionario['direccion']}. {diccionario['estado']} - {diccionario['prezo']} €.")
    

def eliminar_datos_vivendas(lista_vivendas: list, indice: int) -> list:
    
    if type(lista_vivendas) != list or type(indice) != int:
        raise ValueError('Os parámetros ingresados non coinciden cos valores esperados (ELIMINAR DATOS)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden eliminar datos dunha lista baleira (ELIMINAR DATOS)')
    if indice < 0 or indice > len(lista_vivendas):
        raise ValueError('Ingrese un valor válido para o índice')
    
    del lista_vivendas[indice]
    
    return lista_vivendas


def modificar_estado_vivenda(lista_vivendas: list, indice: int) -> list:
    
    if type(lista_vivendas) != list or type(indice) != int:
        raise ValueError('Os parámetros ingresados non coinciden cos valores esperados (ELIMINAR DATOS)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden eliminar datos dunha lista baleira (ELIMINAR DATOS)')
    if indice < 0 or indice > len(lista_vivendas):
        raise ValueError('Ingrese un valor válido para o índice')
    
    diccionario = lista_vivendas[indice]
    
    if diccionario['estado'] == 'venta':
        diccionario['estado'] = 'aluguer'
    else:
        diccionario['estado'] = 'venta'
    
    return lista_vivendas


def mostrar_vivendas_alugamento(lista_vivendas: list) -> print:
    
    if type(lista_vivendas) != list:
        raise ValueError('Os parámetros ingresados non coinciden cos valores esperados (MOSTRAR VIVENDAS ALUGAMENTO)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se pode amosar unha lista vacía (MOSTRAR VIVENDAS ALUGAMENTO)')

    for indice, diccionario in enumerate(lista_vivendas):
        if diccionario['estado'] == 'aluguer':
            print(f"\n{indice}) {diccionario['direccion']}. {diccionario['estado']} - {diccionario['prezo']} €.")


def prezo_alugamento_mais_repetido(lista_vivendas: list) -> float:
    
    if type(lista_vivendas) != list:
        raise ValueError('O parámetro "lista_vivendas" non coincide cos valores esperados (ALUGAMENTO MÁIS REPETIDO)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden sacar datos dunha lista baleira (ALUGAMENTO MÁIS REPETIDO)')

    prezos = []
    
    for diccionario in lista_vivendas:
        if diccionario['estado'] == 'aluguer':
            prezos.append(diccionario['prezo'])

    if len(prezos) == 0:
        return None
    
    prezos_repetidos = []
    vistos = []
    
    for numero in prezos:
        if numero not in vistos:
            vistos.append(numero)
        else:
            if numero not in prezos_repetidos:
                prezos_repetidos.append(numero)
                
    if len(prezos_repetidos) == 0:
        return min(prezos)
    
    return min(prezos_repetidos)


def prezo_venta_mais_repetido(lista_vivendas: list) -> float:
    
    if type(lista_vivendas) != list:
        raise ValueError('O parámetro "lista_vivendas" non coincide cos valores esperados (ALUGAMENTO MÁIS REPETIDO)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden sacar datos dunha lista baleira (ALUGAMENTO MÁIS REPETIDO)')

    prezos = []
    
    for diccionario in lista_vivendas:
        if diccionario['estado'] == 'venta':
            prezos.append(diccionario['prezo'])

    if len(prezos) == 0:
        return None
    
    prezos_repetidos = []
    vistos = []
    
    for numero in prezos:
        if numero not in vistos:
            vistos.append(numero)
        else:
            if numero not in prezos_repetidos:
                prezos_repetidos.append(numero)
                
    if len(prezos_repetidos) == 0:
        return min(prezos)
    
    return min(prezos_repetidos)


lista_vivendas = []


while True:
    print("\n ------------------------------ \n")
    print("Escolla a opción do menú a elexir: ")
    print("\t a) Ingresar datos vivendas.")
    print("\t b) ELiminar datos vivendas")
    print("\t c) Modificar estado de venta a alugamento, ou vieversa.")
    print("\t d) Mostrar vivendas en alugamento.")
    print("\t e) Ver o prezo de alugamento máis repetido.")
    print("\t f) Ver o prezo de venta máis repetido.")
    print("\t g) Saír")
    print("\t h) Mostrar datos")
    
    option = input(">")
    
    if option == 'a':
        
        try:
            direccion = input("Ingrese a direccion da vivenda: ")
            estado = input("Ingrese o estado da vivenda ('venta' ou 'aluguer'): ").lower().strip()
            prezo = float(input("Ingrese o prezo da vivenda: "))
            ingresar_datos_vivendas(lista_vivendas,direccion,estado,prezo)
        except ValueError as erro:
            print(f"Erro: {erro}")
        
            
    elif option == 'b':
        try:
            mostrar_datos(lista_vivendas)
            indice = int(input("\nIngrese o índice da vivenda a eliminar: "))
            
            eliminar_datos_vivendas(lista_vivendas, indice)
        except ValueError as erro:
            print(f"Erro: {erro}")
    
    
    elif option == 'c':
        try:
            mostrar_datos(lista_vivendas)
            indice = int(input("\nIngrese o índice da vivenda a modificar: "))
            modificar_estado_vivenda(lista_vivendas, indice)
            
        except ValueError as erro:
            print(f"Erro: {erro}")
            
            
    elif option == 'h':
        try:
            mostrar_datos(lista_vivendas)
        except ValueError as erro:
            print(f"Erro: {erro}")
            
            
    elif option == 'd':
        try:
            mostrar_vivendas_alugamento(lista_vivendas)
        except ValueError as erro:
            print(f"Erro: {erro}")
            
            
    elif option == 'e':
        try:
            prezos_aluguer = prezo_alugamento_mais_repetido(lista_vivendas)
            print(f"Os prezo de aluguer máis repetido é: {prezos_aluguer}")
        except ValueError as erro:
            print(f"Erro: {erro}")
            
            
    elif option == 'f':
        try:
            prezos_venta = prezo_venta_mais_repetido(lista_vivendas)
            print(f"O prezo de venta máis repetido é: {prezos_venta}")
        except ValueError as erro:
            print(f"Erro: {erro}")
    
    elif option == 'g':
        print("Saíndo...")
        break