""" 
Escribe un script que pida ao usuario un ano e indique se é bisiesto ou non. Coidado que a condición de ser bisiesto non só é ser divisible entre 4. O algoritmo debe estar implantado dentro dunha función denominada:
    · comprobar_bisiesto(ano: int) -> boolean
    
Condición de ser bisiesto:

    · Obrigatorio ten que ser divisible entre 4.
    · Se o é, se é divisible entre 100 ten que ser tamén entre 400.
    
Se é bisiesto mostrarase por pantalla <Bisiesto> e senón <Non bisiesto>. En caso de que se introduza un valor negativo, mostrarase por pantalla <Erro>
"""

def comprobar_bisiesto(ano):
    
    if ano % 4 != 0:
        return False

    elif ano%100 and ano%400:
        return True

# Pedimos o ano
ano = int(input("Indica un ano: "))


# Comprobamos que sexa maior que 0
if ano <= 0:
    print("Erro")
else:
    bisesto = comprobar_bisiesto(ano)
    if bisesto:
        print("Bisesto")
    else:
        print("Non bisesto")