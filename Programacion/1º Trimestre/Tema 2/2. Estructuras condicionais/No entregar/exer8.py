""" 
Crea un menú nun script para seleccionar a acción que desexa realizar no usuario. Neste caso temos tres opcións:
    a) Sumar 2 números introducidos por teclado e mostrar o resultado
    b) Restar 2 números introducidos por teclado e mostrar o resultado.
    c) Multiplicar 2 números introducidos por teclado e mostrar o resultado.
"""

__author__ ="Marcos Chouza Cruces"

#Pedimoslle ao usuario que escolla os valores deseados
num1 = int(input("Escolla o primeiro número: "))
num2 = int(input("Escolla o segundo número: "))

#Creamos o menú a escoller
print("\nEscolla unha opción:")
print("\ta) Sumar os 2 números")
print("\tb) Restar os 2 números")
print("\tc) Multiplicar os 2 números")

#Obtemos a opcion escollida polo usuario
opcion = input(">")

#Comezamos coa estutura condicional, que dará a saída por pantalla
if opcion == 'a':
    solucion_a = num1 + num2
    print("A suma de", num1, "e de", num2, "é:", solucion_a)
    
elif opcion == 'b':
    solucion_b = num1 - num2
    print("A resta de", num1, "e de", num2, "é:", solucion_b)

elif opcion == 'c':
    solucion_c = num1 * num2
    print("A multiplicación de", num1, "e de", num2, "é:", solucion_c)
    
else:
    print("Error")