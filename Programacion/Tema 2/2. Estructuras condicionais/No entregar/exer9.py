""" 
Escribe un script que calcule o importe a pagar por un vehículo ao circular por unha autoestrada. Seleccionado o vehículo mediante un menú. 
Se é necesario pedídelle ao usuario os quilómetros recorridos pola autoesterada e o se peso.

    a) MNoto: importe fixo de 1€
    b) Turismo: 0,25€ por km recorrido
    c) Camión: 0,25€ por km más 0,25€ por tonelada de peso (primeiro pídeselle a distancia e despois o peso)
"""
__author__ = "Marcos Chouza Cruces"

#Creamos o menú que imops utilizar
print("\nEscolla unha opción:")
print("\ta) Vou en moto")
print("\tb) Vou en coche")
print("\tc) Vou en camión")

#Establecemos a opción que queremos utilizar
opcion = input(">")

#Comezamos co bloque de secuencias, que van dar a saída por pantalla
if opcion == 'a':
    print("O importe é de 1€")
    
elif opcion == 'b':
    quilometros_coche = float(input("Ingrese os quilometros recorridos: "))
    print("O custo é de", 0.25*quilometros_coche, "€")
    
elif opcion =='c':
    quilometros_camion = float(input("Ingrese os quilometros recorridos: "))
    tonelada_camion = float(input("Ingrese as toneladas do camion: "))
    
    custo_total_camion = quilometros_camion*0.25 + 0.15*tonelada_camion
    print("O custo é de", custo_total_camion, "€")