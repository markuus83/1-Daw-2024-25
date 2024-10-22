""" 
Escribe un script que solicite ao usuario dous números e a continuación mostre o resultado de dividir o primeiro número polo segundo. Asegúrate de manexar as excepcións no caso de que o usuario intente dividir entre cero ou introduza por teclado un valor que non sexa un número. Para realizar isto deberás capturar as excepcións <ZeroDivisionError> e <ValueError>. Para cada unha das mensaxes mostra unha mensaxe de erro diferente:

    · Cando se capture a excepción <ZeroDivisionError> mostra por pantalla: Erro: Non se pode dividir entre cero.
    
    · Cando se capture a excepción <ValueError> mostra por pantalla: Erro: Entrada non válida, por favor introduce números...
"""

__author__ = "Marcos Chouza Cruces"

def division_entre_cero(numero1: int, numero2: int) -> float:
    try:
        total = numero1 / numero2
    except ZeroDivisionError:
        print("Erro: Non se pode dividir entre cero.")
    return total

def 
numero1 = int(input("Ingrese o primeiro número: "))
numero2 = int(input("Ingrese o segundo número: "))