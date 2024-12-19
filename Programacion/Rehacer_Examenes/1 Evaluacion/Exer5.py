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
    
    if type(lista_vivendas) is not list:
        raise ValueError('O parámetro "lista" non coincide cos valores esperados. (MOSTRAR DATOS)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se pode amosar unha lista vacía. (MOSTRAR DATOS)')
    
    for indice, diccionario in enumerate(lista_vivendas):
        print(f"{indice}) {diccionario['direccion']}. {diccionario['estado']} - {diccionario['prezo']} €.")
    
    

def ingresar_datos_vivenda(lista_vivendas: list, direccion: str, estado: str, prezo: float) -> list:
    
    if type(lista_vivendas) is not list:
        raise ValueError('O parámetro "lista" non coincide cos valores esperados. (INGRESAR DATOS)')
    if type(direccion) is not str:
        raise ValueError('O parámetro "direccion" non coincide cos valores esperados. (INGRESAR DATOS)')
    if type(estado) is not str:
        raise ValueError('O parámetro "estado" non coincide cos valores esperados. (INGRESAR DATOS)')
    if type(prezo) is not float:
        raise ValueError('O parámetro "prezo" non coincide cos valores esperados. (INGRESAR DATOS)')
    
    if estado not in ['venta', 'aluguer']:
        raise ValueError('O parámetro "estado" non coincide cos valores esperados. (INGRESAR DATOS)')
    
    if prezo <=0:
        raise ValueError('Ingrese un valor válido para "prezo".')
    
    
    vivenda={
        'direccion': direccion,
        'estado': estado,
        'prezo': prezo
    }

    lista_vivendas.append(vivenda)
    
    return lista_vivendas

lista_vivendas = []

while True:
    
    print("\n--------------------------\n")
    print("Escolla a opcion desexada do menú:")
    print("\t a) Ingresar datos vivenda: ")
    print("\t b) Eliminar datos vivenda: ")
    print("\t c) Modificar estado de venta a alugamento, ou viceversa: ")
    print("\t d) Mostrar vivendas en alugamento: ")
    print("\t e) Ver o prezo de alugamento mais repetido: ")
    print("\t f) Ver o prezo de venta máis repetido: ")
    print("\t g) Saír: ")
    print("\t h) Mostrar datos: ")
    
    option = input(">")
    
    if option == 'a':
        
        try:
            #Se unha vivenda está en venta non pode estar en alugamento e vicevera
            direccion = input("Ingrese a dirección da vivenda: ")
            estado = input("Ingrese o estado da vivenda ('venta' ou 'aluguer'): ")
            prezo = float(input("Ingrese o prezo da vivenda: "))
            ingresar_datos_vivenda(lista_vivendas, direccion, estado, prezo)
            
        except ValueError as erro:
            print(f"Erro: {erro}")
            
    if option == 'h':
        try:
            mostrar_datos(lista_vivendas)
            
        except ValueError as erro:
            print(f"Erro: {erro}")