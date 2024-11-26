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

    if type(nome) is not str:
        raise ValueError("O nome non é valido")

    if type(apelidos) is not str:
        raise ValueError("O nome non é valido")

    if type(nota) is not float:
        raise ValueError("O nome non é valido")

    if nota > 10 or nota < 0:
        raise ValueError("A nota non é valida.")

    alumno = {
        "nome": nome.strip(),
        "apelidos": apelidos.strip(),
        "nota": nota
    }

    lista_alumnos.append(alumno)
    


def eliminar_datos_alumno(lista_alumnos: list) -> list[dict]:

    del lista_alumnos[indice]
     

def modificar_nota_alumno(lista_alumnos: list, indice: int, nota: float) -> list[dict]:

    alumno = lista_alumnos[indice]
    alumno['nota'] = nota
    
    

def ver_nomes_alumnos_aprobados(lista_alumnos) -> list[str]:
    
    return   
        
        
        
        
    


def mostrar_nota_media(lista_alumnos) -> float:
    return



def mostrar_lista_alumnos(lista_alumnos: list) -> list:
    
    resultado = ""
    
    for indice, diccionario in enumerate(lista_alumnos):
        resultado += f"{indice}. {diccionario['apelidos']}, {diccionario['nome']} : {diccionario['nota']}\n"
        
    return resultado


lista_alumnos = []


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
    
    if option == 'a':
        
        nome = input("Ingrese o nome do alumno: ")
        apelidos = input("Ingrese os apelidos do alumno: ")
        nota = float(input("Ingrese a nota do alumno: "))
        
        alumno = ingresar_datos_alumno(nome, apelidos, round(nota, 2))


    elif option == 'b':
        
        print(mostrar_lista_alumnos(lista_alumnos))
        
        indice = int(input("Ingrese o índice a eliminar: "))
        eliminar_datos_alumno(lista_alumnos)
        

    elif option == 'c':
        
        print(mostrar_lista_alumnos(lista_alumnos))
        
        indice = int(input("Ingrese o índice do alumno: "))
        nota = float(input("Ingrese a nova nota a ingresar: "))
        
        modificar_nota_alumno(lista_alumnos, indice, nota)
         

    elif option == 'd':

        print(ver_nomes_alumnos_aprobados(lista_alumnos))
        
"""
    elif option == 'e':
        
        
    elif option == 'f':
        
        
    elif option == 'g':
        print("Saíndo...")
        break

    else:
        print("Erro")
"""     
