""" 
Implantar unha aplicación que calcule o menor de tres números introducidos por teclado polo usuario e o mostre por pantall. Comporba antes de nada que ningún par de números é igual. Se isto é así, indícallo mostrando por pantalla <Erro> e non calcules cal é o menor dos 3. Defune dúas e utiliza estas dúas funcións:

    · comprobar_valores_iguais(numero1: int, numero2: int, numero3: int) -> boolean: indica se algún dos númers é igual
    
    · calcular_menor_numero(numero1: int, numero2: int, numero3: int) -> int: indica cal é o menor dos números
    
Para comprobar o funcionamento das funcións utiliza o seguinte código
"""


def comprobar_valores_iguais(numero1, numero2, numero3):
    
    if numero1 == numero2 or numero1 == numero3 or numero2 == numero3:
        return True

def calcular_menor_numero (numero1, numero2, numero3):
    
    if numero1 < numero2 and numero1 < numero3:
        return numero1
    
    elif numero2 < numero1 and numero2 < numero3:
        return numero2
    
    elif numero3 < numero1 and numero3 < numero2:
        return numero3
    
    else:
        print("Error")
 
# Pedimos o primeiro numero
numero1 = int(input("Ingrese un numero por consola: "))
numero2 = int(input("Ingrese un numero por consola: "))
numero3 = int(input("Ingrese un numero por consola: "))

# Comprobamos se son iguais os numeros
son_iguais = comprobar_valores_iguais(numero1, numero2, numero3)

# Se son iguais non facemos nada
if son_iguais:
    print("Erro")

# Se son distintos, calculamos o menor dos tres numeros
else:
    menor = calcular_menor_numero(numero1, numero2, numero3)
    print(menor)