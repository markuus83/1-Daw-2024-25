#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Realizar unha aplicación co seguinte menú:

    · a) Ingresar datos alumno
    
    · b) Eliminar datos alumno
    
        - Débese mostrar unha lista de alumnos nun menú e seleccionar o alumno a eliminar segundo o índice co seguinte formato: <indice. apelidos_alumno, nome: nota>
        
    · c) Modificar nota alumno
    
        - Débese mostrar unha lista de alumnos nun menú e seleccionar o alumno a modificar a nota o índice co seguinte formato: <indice. apelidos_alumno, nome: nota>
        
    · d) Ver nomes e apelidos de alumnos aprobados:
    
        - Débese mostrar co seguinte formato:
        
        <indice. apelidos_alumno, nome: nota>
        
    · e) Mostrar alumnos alfabéticamente:
    
        - Débese mostrar co seguinte formato: <indice. apelidos_alumno, nome: nota>
        
        - Podes adaptar o algoritmo de ordenación da tarefa anterior
        
    · f) Ver a anota media
    
    · g) Sair
    
Para cada alumno necesitaremos gardar os seguintes datos

    · Nome
    
    · Apelidos
    
    · Nota con decimais
    
Axuda:

    · A información de cada alumno almacenarase nun diccionario.
    
    · Para gardar a información de cada alumno utilizaremos unha lista.
"""

__author__ = "Marcos Chouza Cruces"

def ingresar_datos_alumno(nome: str, apelidos: str, nota: float) -> list[dict]:
    
    """
    Ingresamos os datos do alumno.

    Args:
        nome (str): Nome do alumno
        apelidos (str): Apelido/s do alumno
        nota (float): Nota do alumno

    Raises:
        ValueError: Nome válido
        ValueError: Apelido/s válido
        ValueError: Nota válida
        ValueError: Nota comprendida entr 0 e 10

    Returns:
        list: lista de alumnos actualizada co novo alumno
    """
    
    if type(nome) is not str:
        raise ValueError("O nome non é valido. (INGRESAR_DATOS)")

    if type(apelidos) is not str:
        raise ValueError("O nome non é valido. (INGRESAR_DATOS)")

    if type(nota) is not float:
        raise ValueError("O nome non é valido. (INGRESAR_DATOS)")

    if nota > 10 or nota < 0:
        raise ValueError("A nota non é valida. (INGRESAR_DATOS)")

    #Ingresamos os datos do alumno nun diccionario
    alumno = {
        "nome": nome.strip(),
        "apelidos": apelidos.strip(),
        "nota": nota
    }

    #Ingresamos dito diccionario como un elemento da lista
    lista_alumnos.append(alumno)



def eliminar_datos_alumno(lista_alumnos: list, indice: int) -> list[dict]:

    """
    Eliminar os datos dun alumno

    Args:
        lista_alumnos (list): Lista que conten os datos dos alumnos.
        indice (int): Indice da lista a modificar

    Raises:
        ValueError: O parámetro lista é unha lista
        ValueError: O parámetro índice é un int
        ValueError: O índice presenta un valor válido
        ValueError: A lista está vacía
    """

    #Capturamos todas as posibles excepcións
    if type(lista_alumnos) is not list:
        raise ValueError("A lista non é unha lista. (ELIMINAR_DATOS)")
    
    if type(indice) is not int:
        raise ValueError("O índice non é válido. (ELIMINAR_DATOS)")
    
    if indice < 0 or indice > len(lista_alumnos):
        raise ValueError("O índice non se atopa entre os parámetros. (ELIMINAR_DATOS)")
    
    if len(lista_alumnos) == 0:
        raise ValueError("Non existen alumnos. (ELIMINAR_DATOS)")
    
    #Borramos o alumno mediante o seu índice na lista
    del lista_alumnos[indice]
     
     

def modificar_nota_alumno(lista_alumnos: list, indice: int, nota: float) -> list[dict]:
    
    """
    Modificamos a nota do alumno
    
    Args:
        lista_alumnos (list): Lista que conten os datos dos alumnos.
        indice (int): Indice da lista a modificar.
        nota (float): Nota do alumno a modificar
    

    Raises:
        ValueError: O parámetro lista_alumnos non é unha lista
        ValueError: O parámetro índice non é int
        ValueError: O parámetro nota non é float
        ValueError: O índice presenta un valor válido
        ValueError: A lista está vacía
    """
    
    #Capturamos todas as posibles excepcións
    if type(lista_alumnos) is not list:
        raise ValueError("A lista non é unha lista. (MODIFICAR_NOTA)")
    
    if type(indice) is not int:
        raise ValueError("O índice non é válido. (MODIFICAR_NOTA)")
    
    if type(nota) is not float:
        raise ValueError("A nota non é válida. (MODIFICAR_NOTA)")
    
    if indice < 0 or indice > len(lista_alumnos):
        raise ValueError("O índice non se atopa entre os parámetros. (MODIFICAR_NOTA)")
    
    if len(lista_alumnos) == 0:
        raise ValueError("Non existen alumnos. (MODIFICAR_NOTA)")
    
    
    #Modificamos a nota do alumno
    alumno = lista_alumnos[indice]
    alumno['nota'] = nota
    
    

def ver_nomes_alumnos_aprobados(lista_alumnos: list) -> str:
    
    """
    Ver o nome e apelidos dos alumnos aprobados

    Args:
        lista_alumnos (list): Lista de alumnos
    
    Raises:
        ValueError: O parámetro lista_alumnos é unha lista
        ValueError: A lista non está vacía

    Returns:
        Str: Devolve unha cadea de texto co nome dos alumnos aprobados 
    """
    
    #Capturamos todas as posibles excepcións
    if type(lista_alumnos) is not list:
        raise ValueError("A lista non é unha lista. (APROBADOS)")
    
    if len(lista_alumnos) == 0:
        raise ValueError("Non existen alumnos. (APROBADOS)")
    
    #Inicializamos unha cadea valeira onde almacenaremos o resultado
    resultado = ""
    
    #Recorremos a lista indo índice por índice
    for indice, diccionario in enumerate(lista_alumnos):
        
        #Establecemos a condición para actuar
        if diccionario['nota'] >= 5.00:
            resultado += f"{indice}. {diccionario['apelidos']}, {diccionario['nome']} : {diccionario['nota']}\n"
    
    #Devolvemos o resultado
    return resultado
        


def mostrar_nota_media(lista_alumnos: list) -> float:

    """
    Calcula a nota media dos alumnos

    Args:
        lista_alumnos (list): Lista de alumnos
    
    Raises:
        ValueError: O parámetro lista_alumnos é unha lista
        ValueError: A lista non está vacía

    Returns:
        float: Devolve a media dos alumnos
    """
    
    #Capturamos todas as posibles excepcións
    if type(lista_alumnos) is not list:
        raise ValueError("A lista non é unha lista. (MEDIA)")
    
    if len(lista_alumnos) == 0:
        raise ValueError("Non existen alumnos. (MEDIA)")
    
    #Incializamos unha variable vacía onde almacenaremos os valores da suma
    suma = 0
    
    #Recorremos cada elemento da lista
    for diccionario in lista_alumnos:
        
        #Engadimos cada valor numérico da nota na variable suma e imos sumándoa unha por unha
        suma += diccionario['nota']
        
        #Calculamos a media
        media = suma /len(lista_alumnos)
    
    #Devolvemos a media
    return media



def mostrar_lista_alumnos(lista_alumnos: list) -> str:

    """
    Devolve todos os alumnos

    Raises:
        ValueError: O parámetro lista_alumnos é unha lista
        ValueError: A lista non está vacía


    Returns:
        str: Devolve unha cadea de texto onde están almacenados todos os alumnos
    """

    #Capturamos todas as posibles excepcións
    if type(lista_alumnos) is not list:
        raise ValueError("A lista non é unha lista. (MOSTRAR_ALUMNOS)")
    
    if len(lista_alumnos) == 0:
        raise ValueError("Non existen alumnos. (MOSTRAR_ALUMNOS)")
    
    #Inicicalizamos unha variable cadea vacía onde almacenaremos os valores
    resultado = ""
    
    #Recorremos a lista indo índice por índice
    for indice, diccionario in enumerate(lista_alumnos):
        resultado += f"{indice}. {diccionario['apelidos']}, {diccionario['nome']} : {diccionario['nota']}\n"
        
    #Devolvemos o resultado
    return resultado



def mostrar_alumnos_alfabeticamente(lista_alumnos: list) -> list:
    
    """
    Mostra os alumnos ordeados alfabéticamente pola letra do seu nome

    Raises:
        ValueError: O parámetro lista_alumnos é unha lista
        ValueError: A lista non está vacía


    Returns:
        list: devolve todos os alumnos de forma ordenada nunha lista
    """
    
    #Capturamos todas as posibles excepcións
    if type(lista_alumnos) is not list:
        raise ValueError("A lista non é unha lista. (ALFABETICAMENTE)")
    
    if len(lista_alumnos) == 0:
        raise ValueError("Non existen alumnos. (ALFABETICAMENTE)")
    
    #Incializamos unha lista valeira
    lista_ordenada = []
    
    #Calculamos a lonxitude da lista
    lonxitude = len(lista_alumnos)
    
    #Facemos un BubbleSort para ordenar alfabéticamente segundo o nome de cada alumno
    while True:
        
        ordenado = True
        
        for indice in range(lonxitude - 1):
            
            if lista_alumnos[indice]['nome'] > lista_alumnos[indice + 1]['nome']:
                ordenado = False

                variable_auxiliar = lista_alumnos[indice]
                lista_alumnos[indice] = lista_alumnos[indice + 1]
                lista_alumnos[indice + 1] = variable_auxiliar

        if ordenado:
            break

    return lista_ordenada


#Inicializamos unha lista vacía onde almacenaremos os diccionarios onde se atopará a información de cada alumno
lista_alumnos = []


#Comezamos co bucle infinito que dará a saída por pantalla
while True:
    
    print("\n______________________\nPrema a opción desexada no menú.")
    print("\t a) Ingresar datos do alumno: ")
    print("\t b) Eliminar datos do alumno: ")
    print("\t c) Modificar nota do alumno: ")
    print("\t d) Ver nomes e apelidos dos alumnos aprobados: ")
    print("\t e) Mostrar os alumnos alfabéticamente: ")
    print("\t f) Ver a nota media")
    print("\t g) Saír")

    #Establecemos a opción que queremos utilizar
    option = input(">")
    
    #Capturamos as posibles excepcións e damos a saída por pantalla
    try:
        
        if option == 'a': #INGRESAR DATOS ALUMNOS
        
            nome = input("Ingrese o nome do alumno: ")
            apelidos = input("Ingrese os apelidos do alumno: ")
            nota = float(input("Ingrese a nota do alumno: "))
        
            ingresar_datos_alumno(nome, apelidos, round(nota, 2))
        

        elif option == 'b': #ELIMINAR DATOS ALUMNO
        
            print(mostrar_lista_alumnos(lista_alumnos))
        
            indice = int(input("Ingrese o índice a eliminar: "))
            eliminar_datos_alumno(lista_alumnos, indice)
        

        elif option == 'c': # MODIFICAR NOTA ALUMNO
        
            print(mostrar_lista_alumnos(lista_alumnos))
        
            indice = int(input("Ingrese o índice do alumno: "))
            nota = float(input("Ingrese a nova nota a ingresar: "))
        
            modificar_nota_alumno(lista_alumnos, indice, nota)
         

        elif option == 'd': #VER NOMES E APELIDOS DE ALUMNOS APROBADOS

            print(ver_nomes_alumnos_aprobados(lista_alumnos))
        

        elif option == 'e': #MOSTRAR ALUMNOS ALFABÉTICAMENTE
   
            lista_ordenada = mostrar_alumnos_alfabeticamente(lista_alumnos)
        
            for indice, alumno in enumerate(lista_ordenada):
                print(f"{indice}. {alumno['apelidos']}, {alumno['nome']}: {alumno['nota']}")


        elif option == 'f': #VER NOTA MEDIA

            print(f"A media das notas é: {round(mostrar_nota_media(lista_alumnos)),2}")
        
        
        elif option == 'g': #SAÍR
            print("Saíndo...")
            break

        else:
            print("Non se ingresou un valor válido")
        
    except ValueError as erro:
        print(f"Erro: {erro}")