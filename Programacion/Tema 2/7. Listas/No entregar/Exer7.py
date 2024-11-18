#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
A busca binaria é un algoritmo eficiente para atopar un elemento nunha lista ordenada. En vez de buscar elemento por elemento de forma secuencial (como fai a busca lineal), a busca binaria reduce a metade o espazo de busca en cada paso. Funciona comparando o elemento obxectivo co elemento central da lista:

    1. Se o elemento central é o obxectivo, xa se atopou e o proceso remata.
    2. Se o obxectivo é menor que o elemento central, a busca continúa na metade esquerda da lista.
    3. Se o obxectivo é maior que o elemento central, a busca continúa na metade dereita da lista.
    
Este proceso repítese de forma de xeito iterativo ata atopar o elemento ou ata que non quede más lista que buscar (nese caso, o obxecti onon está presente).

Escribe unha función en Python <buscar(lista: list, obxectivo)> que implante o algoritmo de busca binaria que devolva o índice do obxectivo on None en caso de non se atopar o valor obxectivo.
"""

__author__ = "Marcos Chouza Cruces"

# Ordenar lista
# Obtener carácter de en medio
# Comprobación de dicho carácter
# Comenzar bucle
    # a) Atopar mitad de nuevo (derecha o izquierda) = (mitad + o - medio/2)
    # b) Comprobación con el carácter
# Fin de bucle yu salida por pantalla


##################### CUANDO EL TAMAÑO DE LA LISTA NO ES PAR, AL CALCULAR LA MITAD EL PROGRAMA SE QUEDA CON LA MITAD BAJA, ES DECIR:
##################### [1, 2, 3, 4] ==> LA MITAD SERÍA: 2

def busqueda_binaria(lista, obxectivo):
    inicio = 0
    fin = len(lista) - 1
    contador = 0  # Inicializamos un contador
    
    # Mientras que el inicio sea menor o igual que el fin, seguimos buscando
    while inicio <= fin:
        contador += 1  # Incrementamos el contador en cada iteración
        medio = (inicio + fin) // 2  # Calculamos el índice del medio
        
        if lista[medio] == obxectivo:  # Si encontramos el objetivo
            return medio, contador  # Retornamos el índice y el contador
        elif lista[medio] < obxectivo:  # Si el objetivo es mayor que el valor en medio, ajustamos el inicio
            inicio = medio + 1
        else:  # Si el objetivo es menor que el valor en medio, ajustamos el fin
            fin = medio - 1
    
    return None, contador
        
lista = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]

obxectivo = int(input("Ingrese un valor a buscar: "))

n, contador = busqueda_binaria(lista, obxectivo)

print(f"O número {n} precisou de {contador} contadores.")

