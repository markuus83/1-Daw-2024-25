#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Crea un script que pida as notas dun exame dos alumnos dunha clase para procesalos. Tódalas notas téñense que ir almacenando nunha lista. Mostra un menú que se amose continuamente ata que o usuario seleccione a opción saír. As entradas do menú son:

    a) Engadir nota
    b) ver media
    c) Ver número de aprobados
    d) Ver máxima nota
    e) Eliminar nota -> Primeiro debes de mostrar o menú onde mostres por cada índice da lista a súa nota. O usuario indicará o índice da nota a eliminar.
    f) Saír
    
Para poder realizar cada acción do menú, implanta as seguintes funcións:

    · <engadir_nota(lista: list[float], nota: float)>
    
        - Comproba que a lista sexa unha lista, senón lanza a excepción ValueError.
        - Se a nota é un valor invñalido, lanza a expeción ValueError.
        
    · <mostrar_notas(lista: list[float])>
    
        - Comproba que a lista sexa unha lista, senón lanza a excepción ValueError.
        - Débese mostrar neste formato: indice: nota
        
            #################
            #   0 : nota1   #
            #   1 : nota2   #
            #################
            
    · <media_notas(lista: list[float]) -> float>

        - Comproba que a lista sexa unha lista, senon lanza a excepción ValueError.
        
    · <numero_aprobados(lista list[float]) -> int>
    
        - Comproba que a lista sexa unha lista, senón lanza excepción ValueError.
        
    · <maxima_nota(lista: list[float]) -> float>
    
        -Comproba que a lista sexa unha lista, senón lanza excepción ValueError.

    · <eliminar_nota(lista: list[float], indice: int)>
    
        - Comproba que a lista sexa unha lista, senñon lanza a excepción ValueError.
        
        - Se o índice non é válido lanza a excepción ValueError
    
IMPORTANTE: Non utilices para realizar estas duncións do sistema max, min, etc. realiza este cálculo iterando sobre a lista.
"""

__author__ = "Marcos Chouza Cruces"

def engadir_nota(lista: list[float], nota: float) -> list:
    """
    Engadir as notas do alumnado a unha lista

    Args:
        lista (list[float]): lista onde se almacenan as distintas notas do alumnado
        nota (float): nota de cada alumno

    Raises:
        ValueError: O parámetro lista non é unha lista
        ValueError: O parámetro nota non é un número
        ValueError: O valor das notas é menor a 0 ou maior a 10

    Returns:
        list: lista cas notas do alumnado engadidas
    """
    
    #Capturamos posibles erros
    if type(lista) is not list:
        raise ValueError("O parámetro non é unha lista. (ENGADIR_NOTA)")
    
    if type(nota) is not float:
        raise ValueError("A valor da nota non é numérico. (ENGADIR_NOTA)")
    
    if nota < 0 or nota > 10:
        raise ValueError("A nota non entra nos parámetros. (ENGADIR_NOTA)")
    
    #Engadimos o valor da nota na lista
    lista = lista.append(nota)
    
    return lista


def mostrar_notas(lista: list[float]) -> list:
    
    """
    Mostrar as notas do alumnado

    Args:
        lista (list[float]): lista onde se almacenan as distintas notas do alumnado
        
    Raises:
        ValueError: O parámetro lista non é unha lista
        ValueError: O valor das notas da lista non é numérico

    Returns:
        list: índice e notas do alumnado de forma máis visual
    """
    #Capturamos posibles erros
    if type(lista) is not list:
        raise ValueError("O parámetro non é unha lista. (MOSTRAR_NOTAS)")
    
    #Inicializamos unha lista vacía
    notas_formateadas = []
    
    #Comezamos cun bucle onde iremos indexando cada elemento co seu valor 
    for indice, nota in enumerate(lista):
        
        #Capturamos posibles erros
        if type(nota) is not float:
            raise ValueError("O elemento non é numérico.(MOSTRAR_NOTAS)")
        
        #Imos engadindo os valores na nova lista
        notas_formateadas.append(f"Índice: {indice}, Valor: {nota}")
    
    return notas_formateadas  



def media_notas(lista: list[float]) -> float:
    
    """
    Calculamos a media das notas da lista

    Raises:
        ValueError: O parámetro lista non é unha lista
        ValueError: A listá está vacía, polo que non se pode calcular a súa media
        ValueError: As notas da lista non son numéricas

    Returns:
        float: _description_
    """
    #Capturamos posibles excepcións
    if type(lista) is not list:
        raise ValueError("O parámetro non é unha lista. (MEDIA)")

    if len(lista) == 0:
        raise ValueError("Non se pode calcular a media da lista porque está vacía")
    
    #inicializamos unha variable axuda
    suma = 0
    
    #Recorremos cada elemento da lista
    for nota in lista: 
        
        #Capturamos  unha posible excepción
        if type(nota) is not float:
            raise ValueError("O elemento non é numérico.(MEDIA)")
        
        suma += nota
        media = suma /len(lista)
        
    return media 


def numero_aprobados(lista: list[float]) -> int:
    
    """
    Devolvemos o número de aprobados da lista

    Raises:
        ValueError: O parámetro lista non é unha lista
        ValueError: Os valores da lista non son numéricos

    Returns:
        int: Número de aprobados
    """
    #Capturamos unha posible excepción
    if type(lista) is not list:
        raise ValueError("O parámetro non é unha lista. (APROBADOS)")
    
    aprobado = 0
    
    #Recorremos cada elemento da lista
    for nota in lista:
        
        #Capturamos unha posible expcepción
        if type(nota) is not float:
            raise ValueError("O elemento non é numérico.(APROBADOS)")
        
        #Establecemos a condición do aprobado
        if nota >= 5:
            aprobado += 1
            
    return aprobado


def maxima_nota(lista: list[float]) -> float:
    
    """
    Calculamos a nota máxima da lista

    Raises:
        ValueError: O parámetro lista non é unha lista
        ValueError: Os valores da lista non son numéricos

    Returns:
        float: Devolve a nota máxima da lista
    """
     #Capturamos unha posible excepción
    if type(lista) is not list:
        raise ValueError("O parámetro non é unha lista. (NOTA_MAXIMA)")
    
    maxima_nota = 0 
    
    #Recorremos cada elemento da lista
    for nota in lista:
        
        #Capturamos unha posible excepción
        if type(nota) is not float:
            raise ValueError("O elemento non é numérico. (NOTA_MÁXIMA)")
        
        #Almacenamos nunha variable a nota máis grande 
        if nota > maxima_nota:
            maxima_nota = nota

    return maxima_nota


def eliminar_nota(lista: list[float],indice: int) -> list:
    
    """
    Eliminamos unha nota da lista

    Raises:
        ValueError: O parámetro lista non é unha lista
        ValueError: O índice non é un valor numérico

    Returns:
        list: Devolve a lista sen os elementos borrados
    """
    #Capturamos posibles excepcións
    if type(lista) is not list:
        raise ValueError("O parámetro non é unha lista. (ELIMINAR_NOTA)")
    
    if type(indice) is not int:
        raise ValueError("O índice non é un valor numérico (ELIMINAR_NOTA)")
    
    #Eliminamos o elemento dependendo do seu índice
    del lista[indice]
    
    return lista

#Inicializamos unha lista vacía
lista = []

#Comezamos co bucle infinito que se amosará por pantalla ata saír del
while True:
    print("\n______________________\nPrema a opción desexada no menú.")
    print("\t a) Engadir nota: ")
    print("\t b) Ver media: ")
    print("\t c) Ver número de aprobados: ")
    print("\t d) Ver máxima nota: ")
    print("\t e) Eliminar nota: ")
    print("\t f) Saír")
    
    #Establecemos a opción que queremos utilizar
    option = input(">")
    
    #Lanzamos todas as posibles expecións, imprimimos por consola e chamamos aos métodos dependendo da opción marcada
    try:
        if option == 'a':
        
            nota = float(input("Ingrese unha nota: "))
            engadir_nota(lista, nota)
        
        elif option == 'b':
        
            media = media_notas(lista)
            print(f"A media das notas é: {round(media, 2)}")
        
        elif option == 'c':
        
            if len(lista) == 0:
                raise ValueError("Non se poden ver os aprobados porque aínda non temos notas almacenadas.")
            
            aprobados = numero_aprobados(lista)
            print(f"O número de aprobados é: {aprobados}")
        
        
        elif option == 'd':
        
            nota_maxima = maxima_nota(lista)
            print(f"A nota máxima é: {nota_maxima}")
        
        elif option == 'e':
            
            if len(lista) == 0:
                raise ValueError("Non se pode eliminar elementos porque a lista está vacía.")
            
            notas = mostrar_notas(lista)
            
            for nota in notas:
                print(nota)
                
            indice = int(input("Ingrese o índice da nota a eliminar: "))
            eliminar_nota(lista,indice)
        
        elif option == 'f':
            print("Saíndo...")
            break
    
        else:
            raise ValueError("Non ingresou un valor válido.")
        
    except ValueError as erro:
        print(f"Erro: {erro}")