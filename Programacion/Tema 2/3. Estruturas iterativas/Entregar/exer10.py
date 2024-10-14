""" 
Escribe un script no que o usuario poida introducir números enteiros por teclado ata que teclee a palabra "fin". Tras finalizar a introducción de números, indícalle cal é o número máis pequeno introducido.
"""

__author__ = "Marcos Chouza Cruces"

#Inicializamos unha varaible con gran valor
num_menor = 99999999999999999
contador = 0

print("No seguinte programa, introduce números para calcular cal vai ser o menor de todos. \nPara saír do programa, escribe 'fin' ")

#Comezamos co bucle iterativo 
while True:
    
    #Pedímoslle ao usuario que ingrese valores
    numero = input("\nIngrese un valor: ")
    
    #Rematamos o pedirlle novos valores cando ingrese 'fin'
    if numero == 'fin':
        if contador == 0:
            print("Erro, non se ingresaron valores")
        break
    
    #Casteamos la variable a un tipo INT
    numero = int(numero)
    contador += 1
    
    #Cambiamos o valor da primeira variable para que vaia adoptando o valor máis pequeno introducido
    if numero < num_menor:
        num_menor = numero

    print(f"El número introducido más pequeño es: {num_menor}")
    