#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Crea un script no que se ingresan as notas de alumnos. Vai gardando todas as notas que están entre 0 e 10 nunha lista. Cando o usuario introduza a palabra "fin", non se pedirán máis notas. Ao finalizar o ingreso de notas mostra por pantalla a media de todas as notas.
"""

__author__ = "Marcos Chouza Cruces"

notas_alumnos = [] #Incializamos unha lista vacia

while True: # Comezamos co bucle infinito
    
    nota = str(input("Ingrese la nota del alumno: ")) #Pedimos ao usuario que ingrese as notas do alumando
    
    if nota == 'fin' or nota == 'FIN': # Rompemos o bucle cando se escriba a palabra fin
        break
    
    try: # Convertemos as distintas en int's
        nota = int(nota)
    except:
        continue
    
    if 0 <= nota and nota <= 10: # Se os datos ingresados están entre 0 e 10 almacenamonos na lista, de non ser así, imprimimos un espazo en blanco
        notas_alumnos.append(nota)
    else:
        print()
    
suma = 0

for nota in notas_alumnos: #Calculamos a suma total de todos os elementos da lista
    suma += nota
    
media = suma /len(notas_alumnos) #Calculamos a media mediante a funcion len() para calcular a cantidade total de elementos que temos

print(round(media, 2)) #Imprimimos e redondeamos a dous decimais.