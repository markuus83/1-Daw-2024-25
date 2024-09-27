"""
Implantar unha aplicación que calcule o menor de tres números introducidos por teclado polo usuario e o mostre por pantalla. Comproba antes de nada que ningún par de números é igual. Se isto é así, indícallo mostra por pantalla <Erro> e non calcules cal é o menor dos 3
"""
__author__ = "Marcos Chouza Cruces"

num1 = int(input("Introduce o primeiro número: "))
num2 = int(input("Introduce o segundo número: "))
num3 = int(input("Introduce o terceiro número: "))

while num1 != num2 and num3:
    if num1 < num2 and num1 < num3:
        print("O número máis pequeno é o primeiro, ", num1)
    elif num2 < num1 and num2 < num3:
        print("O número máis pequeno é o segundo, ", num2)
    elif num3 < num1 and num3 <num2:
        print("O número máis pequeno é o terceiro, ", num3)
    break

if num1 == num2 == num3:
    print("Erro, os tres números son iguais")