""" 
Escribe un script que pide ao usuario por teclado os coeficientes dunha ecuación de segundo grado e calcula a solución. Comproba se hai unha solución, dúas ou ningunha.
Dependendo do caso, mostra as solución que corresponda.
"""

__author__ = "Marcos Chouza Cruces"

#Pedimoslle ao usuario que ingrese os valores axeitados
a = float(input("Ingrese o valor numérico da primeira variable: "))
b = float(input("Ingrese o valor numérico da segunda variable: "))
c = float(input("Ingrese o valor numérico do número sobrante: "))

#Calculamos o discriminante
discriminante = b**2 - 4*a*c

#O primeiro 'IF' encárgase de amosar cando a ecuación ten dúas solucións reais
if discriminante > 0:
    n = (-b + (discriminante)**0.5)
    m = (-b - (discriminante)**0.5)
    p = 2*a
    
    x = n/p
    y = m/p
    
    print("A ecuación ten dúas solucións reais:", x, "e", y)
    
# O segundo 'IF' encárgase de amosar cando a ecuación ten unha soa solución real
elif discriminante == 0:
    x = -b/(2*a)
    print("A ecuación ten unha única solución real:", x)
    
#O último 'IF' encárgase de amosar cando a ecuación non ten solución real
else:
    print("A ecuación non ten solucións reais.")