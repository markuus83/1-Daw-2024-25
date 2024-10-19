""" 
A avaliación deste módulo é a seguinte: 15% de tarefas, 20% exame teórico e 65% exame práctivo. Escribe un script que lle pedirá as súas tres notas sobre 10. Indicaralle por pantalla se obtivo Sobresaliente, Notable, Ben, Suficiente ou insuficiente.
"""

__author__ = "Marcos Chouza Cruces"

def comprobacion_notas(nota_tarefas: float, nota_teorico: float, nota_practico: float) -> bool:
    if nota_tarefas < 0 or nota_teorico < 0 or nota_practico < 0:
        return False
    
    elif nota_tarefas > 10 or nota_teorico > 10 or nota_practico > 10:
        return False
    
    else:
        return True
    
def tarefas(nota_tarefas: float) -> float:
    
    nota_tarefas *= 0.15
    return nota_tarefas


def teorico(nota_teorico: float) -> float:
    nota_teorico *= 0.2
    return nota_teorico


def practico(nota_practico: float) -> float:
    nota_practico *= 0.65
    return nota_practico


nota_tarefas = float(input("Ingrese a nota das tarefas: "))
nota_teorico = float(input("Ingrese a nota do exame teórico: "))
nota_practico = float(input("Ingrese a nota do exame práctico: "))


nota_total = tarefas(nota_tarefas) + teorico(nota_teorico) + practico(nota_practico)


if comprobacion_notas(nota_tarefas, nota_teorico, nota_practico) == True:
    if nota_total >= 9:
        print(f"{round(nota_total,2)}: Sobresaliente")
    
    elif nota_total >= 7 and nota_total < 9:
        print(f"{round(nota_total,2)}: Notable")

    elif nota_total > 5 and nota_total < 7:
        print(f"{round(nota_total,2)}: Ben")
    
    elif nota_total == 5:
        print(f"{round(nota_total,2)}: Suficiente")
    
    else:
        print(f"{round(nota_total,2)}: Insuficiente")

else:
    print("Erro")
    
  
