"""
Escribe un script que pida ao usuario dous números por teclado. Se a suma é maior que 10 mostrase por pantalla <A suma é amior que 10> 
e en caso contrario <A suma non é maior que 10>
"""

__author__ = "Marcos Chouza Cruces"

#Pedímoslle ao usuario que ingrese os datos axeitados
num1 = int(input("Ingrese o primeiro número enteiro: "))
num2 = int(input("Ingrese o segundo número enteiro: "))

#Realizamos as operacións necesarias
suma_num = num1 + num2

#Comezamos ca estructura condicional que da a saída por pantalla
if suma_num > 10:
    print("A suma é maior que 10")
else:
    print("A suma non é maior que 10")