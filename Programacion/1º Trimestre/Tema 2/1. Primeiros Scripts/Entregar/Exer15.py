__author__ = "Marcos Chouza Cruces"

print("Imos solucionar unha ecuación de segundo grado")

# Pedimos ao usuario que introduza os datos
a = float(input("Ingrese o valor numérico da primeira variable: "))
b = float(input("Ingrese o valor numérico da segunda variable: "))
c = float(input("Ingrese o valor numérico do número sobrante: "))

# Facemos as operacións necesarias
n = (-b + (b**2 - 4*a*c)**0.5)
m = (-b - (b**2 - 4*a*c)**0.5)
p = 2*a

x = n/p
y = m/p

# Imprimimos por pantalla
print("\n")
print("A primeira solución é", x,"\n")
print("A segunda solución é", y)
