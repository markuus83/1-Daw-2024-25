""" 
Escribe un script que pide ao usuario por teclado os coeficientes dunha ecuación de segundo grado e calcula a solución. Comproba se hai unha solución, dúas ou ningunha.
Dependendo do caso, mostra as solución que corresponda.
"""

__author__ = "Marcos Chouza Cruces"

a = float(input("Ingrese o valor numérico da primeira variable: "))
b = float(input("Ingrese o valor numérico da segunda variable: "))
c = float(input("Ingrese o valor numérico do número sobrante: "))

# Facemos as operacións necesarias
n = (-b + (b**2 - 4*a*c)**0.5)
m = (-b - (b**2 - 4*a*c)**0.5)
p = 2*a

x = n/p
y = m/p

