#!/usr/bin/env python
# -*- coding: utf-8 -*-

__author__ = "Marcos Chouza Cruces"


def mostrar_datos_vivendas(lista_vivendas: list):
    if type(lista_vivendas) != list:
        raise ValueError("Tipado inválido")
    if len(lista_vivendas) == 0:
        raise ValueError("Lista vacía")

    for indice,vivenda in enumerate(lista_vivendas):
        print(f"{indice}) {vivenda['Direccion']}. {vivenda['Estado']} - {vivenda['Prezo']}")



def ingresar_datos_vivenda(lista_vivendas: list, direccion: str, estado: str, prezo: float) -> list:
    if type(lista_vivendas) != list or type(direccion) != str or type(estado) != str or type(prezo) != float:
        raise ValueError("Tipado inválido")
    if prezo <0:
        raise ValueError("Prezo inválido")
    if estado not in ['venta','aluguer']:
        raise ValueError("Estado de vivenda inválido (INGRESAR DATOS)")

    diccionario = {
        'Direccion': direccion.lower(),
        'Estado': estado.lower(),
        'Prezo': prezo
    }


    return lista_vivendas.append(diccionario)


def eliminar_datos_vivenda(lista_vivendas: list, indice:int)-> list:
    if type(lista_vivendas) != list or type(indice) != int:
        raise ValueError("Tipado inválido")
    if len(lista_vivendas) == 0:
        raise ValueError("Lista vacía")
    if indice<0 or indice>len(lista_vivendas):
        raise ValueError("Indice inválido")
    
    return lista_vivendas.pop(indice)



def modificar_estado_vivenda(lista_vivendas: list, indice:int) -> list:
    if type(lista_vivendas) != list or type(indice) != int:
        raise ValueError("Tipado inválido")
    if len(lista_vivendas) == 0:
        raise ValueError("Lista vacía")
    if indice<0 or indice>len(lista_vivendas):
        raise ValueError("Indice inválido")
    
    vivenda = lista_vivendas[indice]

    if vivenda['Estado'] == 'venta':
        vivenda['Estado'] = 'aluguer'

    else:
        vivenda['Estado'] = 'venta'

    return lista_vivendas



def mostrar_vivendas_en_aluguer(lista_vivendas: list):
    if type(lista_vivendas) != list:
        raise ValueError("Tipado inválido")
    if len(lista_vivendas) == 0:
        raise ValueError("Lista vacía")

    for indice, vivenda in enumerate(lista_vivendas):
        if vivenda['Estado'] == 'aluguer':
            print(f"{indice}) {vivenda['Direccion']}. {vivenda['Estado']} - {vivenda['Prezo']}")



#Lista onde almacenaremos todos
lista_vivendas = []


while True:
    print("\n---------------\nBenvido a xestión de Vivendas")
    print("\ta) Ingresar datos vivenda: ")
    print("\tb) Eliminar datos vivenda: ")
    print("\tc) Modificar estado de venta a alugamento, e viceversa: ")
    print("\td) Mostrar vivendas en alugamento: ")
    print("\te) Ver o prezo de VENTA máis repetido")
    print("\tf) Ver o prezo de ALUGAMENTO máis repetido")
    print("\tg) Saír")

    option = input("> ").lower().strip()


    # Ingresar datos vivenda

    if option == "a":

        try:

            direccion = input("\nIngrese a dirección: ")
            estado = input("Ingrese o estado (venta - aluguer): ")
            prezo = float(input("Ingrese o prezo: "))

            ingresar_datos_vivenda(lista_vivendas,direccion, estado, prezo)

            print("\n\tVivenda ingresada exitosamente!")

        except ValueError as erro:
            print(f"Erro: {erro}")


    # Eliminar datos vivenda

    # Débese mostrar unha lista de vivendas nun menú e seleciconar a vivenda a eliminar segundo o índice co seguinte formato:
    # índice>) <dirección>. <venta|alugamento> - <prezo> €.
    elif option == "b":

        try:

            mostrar_datos_vivendas(lista_vivendas)
            
            indice = int(input("\nIngrese o índice da vivenda a eliminar: "))

            eliminar_datos_vivenda(lista_vivendas,indice)

            print("\n\tVivenda eliminada exitosamente")

        except ValueError as erro:
            print(f"Erro: {erro}")




    #Modificar estado de venta a alugamento, ou viceversa

    # Débese mostrar unha lista de vivendas nun menú e seleciconar a vivenda a eliminar segundo o índice co seguinte formato:
    # índice>) <dirección>. <venta|alugamento> - <prezo> €.
    elif option == "c":

        try:

            mostrar_datos_vivendas(lista_vivendas)
            
            indice = int(input("\nIngrese o índice da vivenda a modificar: "))

            modificar_estado_vivenda(lista_vivendas, indice)

            print("\n\tVivenda modificada exitosamente")

        except ValueError as erro:
            print(f"Erro: {erro}")



    # Mostrar vivendas en alugamento

    # Débese mostrar co seguinte formato: <índice>) <dirección>. <venta|alugamento> - <prezo> €.

    elif option == "d":

        try:

            mostrar_vivendas_en_aluguer(lista_vivendas)

        except ValueError as erro:
            print(f"Erro: {erro}")



    # Ver o prezo de alugamento máis repetido. 

    # En caso de empate de prezos, indica o máis baixo.
    # Pista: utiliza dicionarios para realizar dito cálculo.
    # Se non hai vivendas de alugamento devolve None

    elif option == "e":

        try:

            print("")

        except ValueError as erro:
            print(f"Erro: {erro}")



    # Ver o prezo de venta máis repetido. 

    # En caso de empate de prezos, indica o máis baixo.
    # Pista: reutiliza funcións.
    # Se non hai vivendas de alugamento devolve None

    elif option == "f":

        try:

            print("")

        except ValueError as erro:
            print(f"Erro: {erro}")


    # Saír

    elif option == "g":

        print("Saíndo...")
        break


    elif option == "h":
        try:

            mostrar_datos_vivendas(lista_vivendas)

        except ValueError as erro:
            print(f"Erro: {erro}")

    else:
        print("Erro: Opción non válida")
