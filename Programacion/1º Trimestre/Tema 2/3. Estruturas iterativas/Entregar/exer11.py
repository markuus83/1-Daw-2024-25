""" 
Escribe un script que calcule o mínimo común múltiplo de dous números introducidos polo usuario:

    · Non utilices ningún algoritmo, vai probando números ata que atopes un número que sexa múltiplo dos dous números.
"""

__author__ = "Marcos Chouza Cruces"

#Pedímoslle ao usuario que ingrese os valores
numero1 = int(input("Ingrese o primeiro número: "))
numero2 = int(input("Ingrese o segundo número: "))

#Desartamos os valores non adecuados
if numero1 <= 0 or numero2 <= 0:
    print("Error. Introduza números positivos.")

#Comezamos ca parte principal do exercicio
else:
     
    #Nesta secuencia 'IF: ELSE:' determinamos cal das dúas variables é a maior
    if numero1 > numero2:
        mcm = numero1    
    else:
        mcm= numero2
    
    #Comezamos ca iteración para buscar o Mínimo Común Múltiplo
    while mcm % numero1 != 0 or mcm % numero2 != 0:
        mcm += 1
        
    #Imprimimos a solución
    print(f"O Mínimo Común Mútltiplo de {numero1} e {numero2} é: {mcm}")
    
