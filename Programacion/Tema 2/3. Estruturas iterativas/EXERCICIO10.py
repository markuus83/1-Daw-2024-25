__author__ = "Marcos Chouza Cruces"

print("No seguinte programa, introduce números para calcular cal vai ser o menor de todos. \nPara saír do programa, escribe 'fin' ")

# Inicializamos variables
num_menor = None  # Ningún número ingresado aún
contador = 0

# Comezamos co bucle iterativo
while True:
    
    # Pedímoslle ao usuario que ingrese valores
    numero = input("\nIngrese un valor: ")
    
    # Rematamos o pedirlle novos valores cando ingrese 'fin'
    if numero == 'fin':
        if contador == 0:
            print("Erro, non se ingresaron valores")
        else:
            print(f"O número máis pequeno introducido foi: {num_menor}")
        break
    
    # Verificamos se a entrada é un número enteiro
    es_numero = True  # Supoñemos que é un número ata que se demostre o contrario
    i = 0  # Contador para percorrer a cadea

    # Comprobamos se o primeiro carácter é '-' para números negativos
    if numero[i] == '-':
        i += 1  # Comezamos a comprobar desde o segundo carácter

    # Comprobamos carácter por carácter
    while True:
        # Se chegamos ao final da cadea, saímos do bucle
        if numero[i:i+1] == '':  # Comprobamos se o carácter actual é vacío (equivalente a len() == 0)
            break
        # Comprobamos se o carácter está entre '0' e '9'
        if numero[i:i+1] < '0' or numero[i:i+1] > '9':
            es_numero = False
            break
        i += 1  # Incrementamos o contador

    if es_numero:
        numero = int(numero)
        
        # Se é o primeiro número introducido, o inicializamos como num_menor
        if num_menor is None or numero < num_menor:
            num_menor = numero
        
        contador += 1  # Incrementamos o contador
    else:
        print("Por favor, introduce un número válido ou 'fin' para saír.")

# A saída do programa xa se maneja ao final do bucle
