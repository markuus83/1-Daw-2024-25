#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
<Pasa a calculadora!> é un xogo para dúas persoas no que se comeza cunha calculadora e cada xogador, de xeito alterno, suma unnúmero novo, dun só díxito, ao valor acumulado ata o momento, comezando en 0. O xogador que, traas sumar o seu número, chegue a un resultado maior ou igual a 31 perde.

Ademais, en cada turno un xogador só pode utilizar os números na mesma fila ou columno que o díxito marcado polo seu opoñente no turno anterior, pero non pode repetir o número. Evidentemente, o número 0 non se pode utilizar nunca.

Por exemplo, imaxina que, durante unha partida, un xogador recibe a calculadora mostrándolee o número 28, e o opoñente acaba de introducir o número 9. A partir da disposición dos números da calculadora, sabemos que nesta quenda unicamente poderá xogar os números 3, 6, 7 e 8.

Implanta este xogo
"""

__author__ = "Marcos Chouza Cruces"


f1 = [1, 2, 3]
f2 = [4, 5, 6]
f3 = [7, 8, 9]


valores_totais = [f3, f2, f1]



"""
suma = 0

while True:
    print("\nIngrese que xogador vai xogar:")
    print("a) Xogador 1: ")
    print("b) Xogador 2: ")
    
    option = input(">")
    
    if suma > 31:
        
        if option == 'a':
            
            #Engadir funcion comprobar_numero_posible
            numero_xogador1 = int(input("Ingrese o número posible: "))
            suma += numero_xogador1
            
            
        elif option == 'b':
            
            #Engadir funcion comprobar_numero_posible
            numero_xogador2 = int(input("Ingrese o número posible: "))
            suma += numero_xogador2
            
        else:
            print("Erro")
            
    else:
        print("Perdiches")
    break
"""