""" 
Escribe un script que pide ao usuario os coeficientes dunha ecuación de segundo grao e calcula a solución. Comproba se hai unha solución, dúas ou ningunha. Dependendo do caso, mostra as solucións que corresponda. Crea as seguintes funcións:

    · Unha función que calcule o discriminante:
    
        descriminante(a: float, b: float, c: float) -> float
    
    
    · Unha función que calcule o número de solucións: 
    
        numero_solucions(a: float, b: float, c: float) -> int. 
        
    Debe utilizar internamente descriminante().


    · Unha para calcular a solución cando esta é única: 
    
        solucion_unica(a: float, b: float) -> float


    · Unha para calcular as dúas solucións: 
    
        calcula_duas_solucions (a: float, b: float, c: float) -> (float, float).
        
    Esta debe devolver las dos soluciones. Debe utilizar internamente descriminante().
"""

__author__ = "Marcos Chouza Cruces"

def discriminante(a: float, b: float, c: float) -> float:
    return b**2 - 4*a*c

def numero_solucions(a: float, b: float, c: float) -> int:
    d = discriminante(a, b, c)
    if d > 0:
        return 2
    elif d == 0:
        return 1
    else:
        return 0

def solucion_unica(a: float, b: float) -> float:
    return -b / (2*a)

def calcula_duas_solucions(a: float, b: float, c: float) -> (float, float):
    
    d = discriminante(a, b, c)
    
    n = d**0.5  
    x = (-b + n) / (2*a)
    y = (-b - n) / (2*a)
    return x, y

a = float(input("Ingrese o valor de A: "))
b = float(input("Ingrese o valor de B: "))
c = float(input("Ingrese o valor de C: "))

num_sol = numero_solucions(a, b, c)

if num_sol == 2:
    x, y = calcula_duas_solucions(a, b, c)
    print(f"A ecuación ten dúas solucións reais: {x} e {y}")
    
elif num_sol == 1:
    x = solucion_unica(a, b)
    print(f"A ecuación ten unha única solución real: {x}")
    
else:
    print("A ecuación non ten solucións reais.")
