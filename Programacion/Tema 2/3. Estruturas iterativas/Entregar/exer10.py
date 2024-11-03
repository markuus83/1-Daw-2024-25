""" 
Escribe un script no que o usuario poida introducir números enteiros por teclado ata que teclee a palabra <fin>. Tras finalizar a introdución de números, indícalle cal é o número máis pequeno introducido.
"""

__author__ = "Marcos Chouza Cruces"

# Inicializamos as variables necesarias para o código
contador = 0
num_menor = None  #Inicialmente non hai número máis pequeno
primeira_introducion_numero = True

# Comezamos co bucle iterativo
while True:
    
    numero = input("Introduce un valor: ")

    # O programa para cando se introduce a palabra 'fin'
    if numero == 'fin':
        break

    # Verificamos se o valor introducido é un número enteiro válido
    numero = int(numero)

        # Se é a primeira introdución, definimos o número máis pequeno
    if primeira_introducion_numero:
        num_menor = numero
        primeira_introducion_numero = False
        
    else:
            # Actualizamos o número máis pequeno se corresponde
        if numero < num_menor:
            num_menor = numero
        
        # Aumentamos o contador de números introducidos
    contador += 1


# Damos a saída por pantalla
if contador == 0:
    print("Erro: non se introduciron valores numéricos.")
else:
    print(f"O número máis pequeno introducido é: {num_menor}")
