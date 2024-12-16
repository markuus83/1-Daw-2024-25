#!/usr/bin/env python
# -*- coding: utf-8 -*-


def ingresar_datos_alumno(lista_alumnos: list, nome: str, apelidos: str, nota: float) -> list:
    
    if type(lista_alumnos) is not list:
        raise ValueError ('O parámetro lista non oincide cos valores esperados. (INGRESAR DATOS)')
    
    if type(nome) is not str:
        raise ValueError('O parámetro nome non coincide cos valores esperados. (INGRESAR DATOS)')
    
    if type(apelidos) is not str:
        raise ValueError('O parámetro apelidos non coincide cos valores esperados. (INGRESAR DATOS)')
    
    if type (nota) is not float:
        raise ValueError('O parámetro nota non coincide cos valores esperados. (INGRESAR DATOS)')
    
    if nota < 0 or nota > 10:
        raise ValueError('Ingrese unha nota adecuada. (INGRESAR DATOS)')
    
    #Creamos un diccionario onde almacenaremos os alumnos 
    alumno = {
        "nome": nome.strip(),
        "apelidos": apelidos.strip(),
        "nota": nota
    }

    #Engadimos o diccionario á lista, almacenamos o conxunto de alumnos
    lista_alumnos.append(alumno)
    return lista_alumnos
    


def mostrar_alumnos(lista_alumnos: list) -> list:
    
    if type(lista_alumnos) is not list:
        raise ValueError ('O parámetro lista non oincide cos valores esperados. (MOSTRAR NOTA)')
    
    if len(lista_alumnos) == 0:
        raise ValueError ('Non se pode amosar unha lista vacía. (MOSTRAR NOTA)') 
    
    #Mostramos os alumnos segundo o formato que nos piden
    for indice, diccionario in enumerate(lista_alumnos):
        
        print(f"{indice}. {diccionario['apelidos']}, {diccionario['nome']}: {diccionario['nota']}")



def eliminar_datos_alumno(lista_alumnos: list, indice: int):
    
    if type(lista_alumnos) is not list:
        raise ValueError ('O parámetro lista non coincide cos valores esperados. (ELIMINAR NOTA)')
  
    if len(lista_alumnos) == 0:
        raise ValueError ('Non se pode amosar unha lista vacía. (ELIMINAR NOTA)') 
    
    if type(indice) is not int:
        raise ValueError('O parámetro indice non coincide cos valores esperados (ELIMINAR NOTA)')
    
    if indice <0 or indice > len(lista_alumnos):
        raise ValueError('Ingrese un índice válido (ELIMINAR NOTA)')
    
    #Eliminamos un alumno dependendo do seu índice.
    del lista_alumnos[indice]
    
    return lista_alumnos


def modificar_nota_alumno(lista_alumnos: list, indice: int, nota: float):
    
    if type(lista_alumnos) is not list:
        raise ValueError ('O parámetro lista non coincide cos valores esperados. (MODIFICAR NOTA)')
  
    if len(lista_alumnos) == 0:
        raise ValueError ('Non se pode amosar unha lista vacía. (MODIFICAR NOTA)') 
    
    if type(indice) is not int:
        raise ValueError('O parámetro indice non coincide cos valores esperados (MODIFICAR NOTA)')
    
    if indice < 0 or indice > len(lista_alumnos):
        raise ValueError('Ingrese un índice válido (MODIFICAR NOTA)')
    
    if type(nota) is not float:
        raise ValueError('O parámetro nota non coincide cos valores esperados (MODIFICAR NOTA)')
    
    alumno = lista_alumnos[indice]
    
    #Modificamos a nota do alumno
    alumno['nota'] = nota
        
    
    return alumno


def alumnos_aprobados(lista_alumnos: list):
    
    if type(lista_alumnos) is not list:
        raise ValueError ('O parámetro lista non coincide cos valores esperados. (ALUMNOS APROBADOS)')
  
    if len(lista_alumnos) == 0:
        raise ValueError ('Non se pode amosar unha lista vacía. (ALUMNOS APROBADOS)') 
    
    #Recorremos a lista de alumnos
    for indice, diccionario in enumerate(lista_alumnos):
        
        #Amosamos todos os alumnos con notas iguais ou superiores a 5 (aprobados)
        if diccionario['nota'] >= 5:
            print(f"{indice}. {diccionario['apelidos']}, {diccionario['nome']}: {diccionario['nota']}")
    


def mostrar_alumnos_alfabeticamente(lista_alumnos: list):

    if type(lista_alumnos) is not list:
        raise ValueError("A lista non é unha lista válida. (ALFABETICAMENTE)")
    
    if len(lista_alumnos) == 0:
        raise ValueError("Non existen alumnos. (ALFABETICAMENTE)")

    # Copia da lista orixinal para non modificala directamente
    lista_ordenada = lista_alumnos[:]
    
    # Implementación do Bubble Sort
    longitud = len(lista_ordenada)
    
    for i in range(longitud - 1):
        for j in range(longitud - 1 - i):
            if lista_ordenada[j]['apelidos'].lower() > lista_ordenada[j + 1]['apelidos'].lower():
                lista_ordenada[j], lista_ordenada[j + 1] = lista_ordenada[j + 1], lista_ordenada[j]

    # Mostramos a lista ordenada
    for indice, alumno in enumerate(lista_ordenada):
        print(f"{indice}. {alumno['apelidos']}, {alumno['nome']}: {alumno['nota']}")

    return lista_ordenada


def nota_media(lista_alumnos: list) -> float:
    
    if type(lista_alumnos) is not list:
        raise ValueError ('O parámetro lista non coincide cos valores esperados. (NOTA MEDIA)')
  
    if len(lista_alumnos) == 0:
        raise ValueError ('Non se pode amosar unha lista vacía. (NOTA MEDIA)')
    
    #Inicializamos a variable suma
    suma = 0
    
    #Sumamos todas as notas e as almacenamos na variable suma
    for diccionario in lista_alumnos:
        suma += diccionario['nota']
    
    #Calculamos a media
    media = suma / len(lista_alumnos)
    
    return media

lista_alumnos = []


while True:
    print("\n--------------------------\n")
    print("Escolla a opcion desexada do menú:")
    print("\t a) Ingresar datos alumno")
    print("\t b) Eliminar datos alumno")
    print("\t c) Modificar nota alumno")
    print("\t d) Ver nomes e apelidos de alumnos aprobados")
    print("\t e) Mostrar alumnos alfabéticamente")
    print("\t f) Ver nota media")
    print("\t g) Saír: ")
    
    option = input(">")
    
    if option == 'a':
        
        try:
            nome = input("Ingrese o nome do alumno: ")
            apelidos = input("Ingrese os apelidos do alumno: ")
            nota = float(input("Ingrese a nota do alumno: "))
            ingresar_datos_alumno(lista_alumnos, nome, apelidos, round(nota, 2))
        except ValueError as erro:
            print(f"Erro: {erro}")
          
    elif option == 'b':
        
        try:
            mostrar_alumnos(lista_alumnos)
            indice = int(input("Ingrese o índice do alumno a eliminar: "))
            eliminar_datos_alumno(lista_alumnos, indice)
        except ValueError as erro:
            print(f"Erro: {erro}")
            
    elif option == 'c':
        
        try:
            mostrar_alumnos(lista_alumnos)
            indice = int(input("Ingrese o índice do alumno a modificar: "))
            nota = float(input("Ingrese a nova nota do alumno: "))
            modificar_nota_alumno(lista_alumnos, indice, nota)
        except ValueError as erro:
            print(f"Erro: {erro}")

    elif option == 'd':
    
        try:
            alumnos_aprobados(lista_alumnos)
        except ValueError as erro:
            print(f"Erro: {erro}")
    
    elif option == 'e':
        
        try:
            mostrar_alumnos_alfabeticamente(lista_alumnos)
        except ValueError as erro:
            print(f"Erro: {erro}")
        
    elif option == 'f':
        
        try:
            nota_media(lista_alumnos)
            media = nota_media(lista_alumnos)
            print(f"A nota media dos alumnos é: {round(media,2)}")
        except ValueError as erro:
            print(f"Erro: {erro}")
            
    elif option == 'g':
        print("Saíndo...")
        break
