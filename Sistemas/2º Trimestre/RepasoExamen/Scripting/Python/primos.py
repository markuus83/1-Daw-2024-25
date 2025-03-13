# Amosar todos os números comprendidos entre dous números introducidos por teclado
def es_primo(num) -> bool:
    
    if num < 2:
        return False
    
    for i in range(2, num + 1):
        if num%i == 0:
            return False
    return True

numero1 = int(input("Ingrese o primerio número: "))
numero2 = int(input("Ingese o segundo número: "))

if numero1 == numero2:
    print("Intervalo vacío.")

elif numero1 > numero2:
    print("O segundo número non pode ser maior.")

else:
    for num in range(numero1, numero2 + 1):
        if es_primo(num):
            print(num)