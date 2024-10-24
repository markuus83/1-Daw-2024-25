#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Escribe un script que solicite ao usuario dous números e a continuación mostre o resultado de dividir o primeiro número polo segundo. Asegúrate de manexar as excepcións no caso de que o usuario intente dividir entre cero ou introduza por teclado un valor que non sexa un número. Para realizar isto deberás capturar as excepcións <ZeroDivisionError> e <ValueError>. Para cada unha das mensaxes mostra unha mensaxe de erro diferente:

    · Cando se capture a excepción <ZeroDivisionError> mostra por pantalla: Erro: Non se pode dividir entre cero.
    
    · Cando se capture a excepción <ValueError> mostra por pantalla: Erro: Entrada non válida, por favor introduce números...
"""

__author__ = "Marcos Chouza Cruces"

def dividir_numeros():
    try:
        num1 = int(input("Introduce o primeiro número: "))
        num2 = int(input("Introduce o segundo número: "))
        
        resultado = num1 / num2
        resultado = float(resultado)
        
    except ZeroDivisionError:
        print("Erro: Non se pode dividir entre cero.")
        
    except ValueError:
        print("Erro: Entrada non válida, por favor introduce números...")
        
    else:
        print(f"O resultado de dividir {num1} entre {num2} é {resultado:.2f}")

dividir_numeros()
