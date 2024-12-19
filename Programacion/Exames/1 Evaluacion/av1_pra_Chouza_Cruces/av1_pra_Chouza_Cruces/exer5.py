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

__autor__ = "Marcos Chouza Cruces"


def mostrar_datos(lista_vivendas: list):
    
    """
    Encárgase de dar unha saída por pantalla amosando unha lista formateada cas diferentes vivendas

    Args:
        lista_vivendas(list): lista onde se almacenan as vivendas.
    
    Raises:
        ValueError: _description_
        ValueError: _description_
    """
    
    if type(lista_vivendas) is not list:
        raise ValueError('O parámetro "lista" non coincide cos valores esperados. (MOSTRAR DATOS)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se pode amosar unha lista vacía. (MOSTRAR DATOS)')
    
    for indice,diccionario in enumerate(lista_vivendas):
        
        if diccionario['venta']:
            print(f"{indice}) {diccionario['direccion']}. venta - {diccionario['prezo']} €")
            
        else:
            print(f"{indice}) {diccionario['direccion']}. alugamento - {diccionario['prezo']} €")



def ingresar_vivenda(lista_vivendas: list, direccion: str, venta: bool, aluger:bool , prezo: float) -> list:
    
    """
    Encárgase de ingresar os datos das diferentes vivendas na lista xeral
    
    Args:
        lista_vivendas(list): lista onde se almacenan as vivendas.
        direccion(str): direccion da vivenda.
        venta(bool): Se a vivenda está en venta.
        aluger(bool): Se a vivenda está en aluger.
        prezo(float): Prezo da vivenda.

    Raises:
        ValueError: O parámetro lista é unha lista.
        ValueError: O parámetro dirección é un string.
        ValueError: O parámetro venta é booleano.
        ValueError: O parámetro aluger é booleano.
        ValueError: O parámetro prezo é float.

    Returns:
        list: devolve unha lista con todas as vivendas
    """
    if type(lista_vivendas) is not list:
        raise ValueError('O parámetro "lista" non coincide cos valores esperados. (INGRESAR VIVENDA)')
    if type(direccion) is not str:
        raise ValueError('O parámetro "dirección" non coincide cos valores esperados. (INGRESAR VIVENDA)')
    if type(venta) is not bool:
        raise ValueError('O parámetro "estado" non coincide cos valores esperados. (INGRESAR VIVENDA)')
    if type(aluger) is not bool:
        raise ValueError('O parámetro "aluger" non coincide cos valores esperados. (INGRESAR VIVENDA)')
    if type(prezo) is not float:
        raise ValueError('O parámetro "prezo" non coincide cos valores esperados. (INGRESAR VIVENDA)')
    
    if venta is True:
        vivenda = {
            "direccion": direccion,
            "venta":  True,
            "prezo": prezo
        }
        
    else:
        vivenda = {
            "direccion": direccion,
            "alugamento": True,
            "prezo": prezo
        }
    
    lista_vivendas.append(vivenda)
    return lista_vivendas


def eliminar_datos_vivenda(lista_vivendas: list, indice: int) -> list:

    """
    
    Encárgase de eliminar os datos das vivendas seleccionadas
    
    Args:
        lista_vivendas(list): lista onde se almacenan as vivendas.
        indice(int): indice da vivenda a eliminar

    Raises:
        ValueError: _description_
        ValueError: _description_
        ValueError: _description_
        ValueError: _description_

    Returns:
        list: devolve unha lista tras eliminar un dato
    """

    if type(lista_vivendas) is not list:
        raise ValueError('O parámetro "lista" non coincide cos valores esperados. (ELIMINAR DATOS)')
    if type(indice) is not int:
        raise ValueError('O parámetro "indice" non coincide cos valores esperados. (ELIMINAR DATOS)')
    if indice < 0 or indice > len(lista_vivendas):
        raise ValueError('O índice non se atopa entre os parámetros. (ELIMINAR DATOS)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden eliminar datos dunha lista vacía. (ELIMINAR DATOS)')

    del lista_vivendas[indice]

    return lista_vivendas


def modificar_estado(lista_vivendas: list, indice: int, ) -> list:
    
    """
    
    Encárgase de modificar o estado da vivenda, de pasar de aluger a venta, e viceversa
    
    Args:
        lista_vivendas(list): lista onde se almacenan as vivendas..
        indice(int): indice do valor a modificar.

    Raises:
        ValueError: A lista é unha lista
        ValueError: o índice é un int
        ValueError: O índice está entre os valores axeitados
        ValueError: A lista non está vacía
    """
    
    if type(lista_vivendas) is not list:
        raise ValueError('O parámetro "lista" non coincide cos valores esperados. (MODIFICAR ESTADO)')
    
    if type(indice) is not int:
        raise ValueError('O parámetro "indice" non coincide cos valores esperados. (MODIFICAR ESTADO)')
    
    if indice < 0 or indice > len(lista_vivendas):
        raise ValueError('O índice non se atopa entre os parámetros. (MODIFICAR ESTADO)')
    
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden eliminar datos dunha lista vacía. (MODIFICAR ESTADO)')
    
    vivenda = lista_vivendas[indice]
    
    
    for diccionario in lista_vivendas:
        
        if diccionario['venta']:
            diccionario['venta'] == False and diccionario['aluger'] == True

        else:
            diccionario['aluger'] == False and diccionario['venta'] == True


def mostrar_vivendas_alugamento(lista_vivendas: list):
    
    """
    Encárgase de mostrar as vivendas que se atpan en alugamento
    
    Args:
        lista_vivendas(list): lista onde se almacenan as vivendas.

    Raises:
        ValueError: A lista é unha lista
        ValueError: A lista non está vacía
    """
    
    if type(lista_vivendas) is not list:
        raise ValueError('O parámetro "lista" non coincide cos valores esperados. (MOSTRAR ALUGAMENTO)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden ensinar datos dunha lista vacía. (MOSTRAR ALUGAMENTO)')
    
    for indice, diccionario in enumerate(lista_vivendas):
        print(f"{indice}) {diccionario['direccion']}. {diccionario['alugamento']} - {diccionario['prezo']}")


def prezo_alugamento_mais_repetido(lista_vivendas: list):
    
    """
    
    Encárgase de amosar o prezo de alugamento máis repetido
    
    Args:
        lista_vivendas(list): lista onde se almacenan as vivendas.

    Raises:
        ValueError: A lista é unha lista
        ValueError: A lista non está vacía
        
    """
    
    if type(lista_vivendas) is not list:
        raise ValueError('O parámetro "lista" non coincide cos valores esperados. (ALUGAMENTO REPETIDO)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden ensinar datos dunha lista vacía. (ALUGAMENTO REPETIDO)')
    
    return 


def prezo_venta_mais_repetido(lista_vivendas: list):
    
    """
    
    Encárgase de amosar o prezo de venta máis repetido
    
    Args:
        lista_vivendas(list): lista onde se almacenan as vivendas.

    Raises:
        ValueError: A lista é unha lista
        ValueError: A lista non está vacía
    """
    
    if type(lista_vivendas) is not list:
        raise ValueError('O parámetro "lista" non coincide cos valores esperados. (ALUGAMENTO REPETIDO)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden ensinar datos dunha lista vacía. (ALUGAMENTO REPETIDO)')
    
    return



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
            direccion = input("Ingrese a dirección da vivenda: ")
            venta = bool(input("Ingrese se a vivenda está en venta: (True or False): "))
            aluger = bool(input("Ingrese se a vivenda está en aluger (True or False): "))
            prezo = float(input("Ingrese o prezo da vivenda: "))
            
            ingresar_vivenda(lista_vivendas, direccion, venta ,aluger, prezo)
            
        except ValueError as erro:
            print(f"Erro: {erro}")
            
            
    elif option == 'h':
        mostrar_datos(lista_vivendas)

    elif option == 'b':
        
        try:
            mostrar_datos(lista_vivendas)
            
            indice = int(input("Ingrese o índice a eliminar: "))
            eliminar_datos_vivenda(lista_vivendas, indice)
        except ValueError as erro:
            print(f"Erro: {erro}")
            

    elif option == 'c':
        
        try:
            mostrar_datos(lista_vivendas)
            
            indice = int(input("Ingrese o índice a modificar: "))
            modificar_estado(lista_vivendas, indice)
        except ValueError as erro:
            print(f"Erro: {erro}")

    
    elif option == 'd':
    
        try:
            
            mostrar_vivendas_alugamento(lista_vivendas)
            
        except ValueError as erro:
            print(f"Erro: {erro}")
    
    
    elif option == 'e':
        
        try:
            
            prezo_alugamento_mais_repetido(lista_vivendas)
            
        except ValueError as erro:
            print(f"Erro: {erro}")
                

    elif option == 'f':
        
        try:
            prezo_venta_mais_repetido(lista_vivendas)
        except ValueError as erro:
            print(f"Erro: {erro}")
            
    elif option == 'g':
        print("Saíndo...")
        break
