""" 
Escribe un script que pida ao usuario un ano e indique se ñe bisiesto ou non. Coidado que a condición de ser bisiesto non só é ser divisible entre 4.

Condición de ser bisiesto:
    · Obrigatorio ten que ser divisible entre 4.
    · Se o é, se é divisible entre 100 ten que ser tamén por 400
    
Se é bisiesto mostrarase por pantalla <Bisiesto> e senón <Non bisiesto>. En caso de se introduza un valor negatico, mostrarase por pantalla <Erro>.
"""

__author__ = "Marcos Chouza Cruces"

#Pedimos ao usuario que introduzca os datos seleccionados
ano = int(input("Indique un ano para calcular se é bisiesto ou non: "))

#Comenzamos con las estructuras condicionales, que nos darán la coprrecta salida por pantalla.
if ano < 0:
    print("Erro")
elif ano% 4 == 0 and ano%100 or ano%400:
    print("Bisiesto")
else:
    print("Non bisiesto")