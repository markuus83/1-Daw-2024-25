""" 
Escribe un script que reciba por teclado un número enteiro positivo <N>. O programa mostrará por pantalla neste orde:

    · O número de pares entre 1 e <N< incluídos.
    · O número de impares entre 1 e <N> incluídos.
    · A suma total de todos os números entre 1 e <N> incluídos.
    · A media só dos números pares entre 1 e <N> incluídos.
"""

__author__ = "Marcos Chouza Cruces"

numero = int(input("\tIngrese un valor para \"N\": "))

#Primeiro punto
i1 = 2
num_pares= 0

while 1 <= i1 <= numero:
    i1 += 2
    num_pares += 1


#Segundo punto
i2 = 1
num_impares = 0

while 1 <= i2 <= numero:
    i2 += 2
    num_impares += 1


#Terceiro punto
i3 = 1
num_total = 0

while 1 <= i3 <= numero:
    
    num_total += i3
    i3 += 1


#Cuarto punto
i4 = 1
sum_pares = 0
cont_pares = 0

while i4 <= numero:
    
    if i4%2 == 0:
        sum_pares += i4
        cont_pares += 1
    i4 += 1


if cont_pares > 0:
    media_pares = sum_pares / cont_pares
    
else:
    print("Error")


print(f"\nO número de pares entre 1 e {numero} incluídos é: {num_pares}")
print(f"\nO número de impares entre 1 e {numero} incluídos é: {num_impares}")
print(f"\nA suma total de todos os números entre 1 e {numero} incluídos é: {num_total}")
print(f"\nA media só dos números pares entre 1 e {numero} incluídos é: {media_pares}")