"""
A avaliación deste módulo é a seguinte: 15% de tarefas, 20% exame teórico e 65% exame práctivo. Escribe un script que lle pedirá as súas tres notas sobre 10. Indicaralle por pantalla se obtivo Sobresaliente, Notable, Ben, Suficiente ou insuficiente.

"""

__author__ = "Marcos Chouza Cruces"

def comprobacion_notas(nota_tarefas: float, nota_teorico: float, nota_practico: float) -> bool:
    """
    Comproba se as notas ingresadas cumpren o baremo de calificación

    Args:
        nota_tarefas (float): Nota das tarefas
        nota_teorico (float): Nota do exame teórico
        nota_practico (float): Nota do exame práctico

    Returns:
        bool: Tipo do dato do retunr
    """
    if nota_tarefas < 0 or nota_teorico < 0 or nota_practico < 0:
        return False
    
    elif nota_tarefas > 10 or nota_teorico > 10 or nota_practico > 10:
        return False
    
    else:
        return True
    
    
def porcentaxe_tarefas(nota_tarefas: float) -> float:
    """
    Calcula o porcentaxe da nota das tarefas

    Args:
        nota_tarefas (float): Nota das tarefas

    Returns:
        float: Tipo do dato do retunr
    """
    nota_tarefas *= 0.15
    return nota_tarefas


def porcentaxe_teorico(nota_teorico: float) -> float:
    """
    Calcula a porcentaxe da nota do exame teórico

    Args:
        nota_teorico (float): Nota do exame teórico

    Returns:
        float: Tipo do dato do retunr
    """
    nota_teorico *= 0.2
    return nota_teorico


def porcentaxe_practico(nota_practico: float) -> float:
    """
    Calcula a porcentaxe da nota do exame práctico

    Args:
        nota_practico (float): Nota do exame práctico

    Returns:
        float: Tipo do dato do retunr
    """
    nota_practico *= 0.65
    return nota_practico


def total_redondeado (nota_tarefas: float, nota_teorico: float, nota_practico: float) -> float:
    """
    Calcula a nota total, seguindo os criterios de porcentaxes a redondea a solución final

    Args:
        nota_tarefas (float): Nota das tarefas
        nota_teorico (float): Nota do exame teórico
        nota_practico (float): Nota do exmae práctico

    Returns:
        float: Tipo do dato do retunr
    """
    
    nota_total = porcentaxe_tarefas(nota_tarefas) + porcentaxe_teorico(nota_teorico) + porcentaxe_practico(nota_practico)
    return round(nota_total,2) 

#Pedímoslle ao usuario que ingrese os valores
nota_tarefas = float(input("Ingrese a nota das tarefas: "))
nota_teorico = float(input("Ingrese a nota do exame teórico: "))
nota_practico = float(input("Ingrese a nota do exame práctico: "))

#Comprobamos que as notas ingresadas son correctas, e, de ser así, comezamos a condicional
if comprobacion_notas(nota_tarefas, nota_teorico, nota_practico) is True:
    
    #Conxunto de IFs anidados, que fan chamadas as funcions necesarias para dar unha correcta saída por pantalla   
    if total_redondeado(nota_tarefas, nota_teorico, nota_practico) >= 9:
        print(f"{total_redondeado(nota_tarefas, nota_teorico, nota_practico)} = Sobresaliente")
    
    elif total_redondeado(nota_tarefas, nota_teorico, nota_practico) >= 7 and total_redondeado(nota_tarefas, nota_teorico, nota_practico) < 9:
        print(f"{total_redondeado(nota_tarefas, nota_teorico, nota_practico)} = Notable")

    elif total_redondeado(nota_tarefas, nota_teorico, nota_practico) > 5 and total_redondeado(nota_tarefas, nota_teorico, nota_practico) < 7:
        print(f"{total_redondeado(nota_tarefas, nota_teorico, nota_practico)} = Ben")
    
    elif total_redondeado(nota_tarefas, nota_teorico, nota_practico) == 5:
        print(f"{total_redondeado(nota_tarefas, nota_teorico, nota_practico)} = Suficiente")
    
    else:
        print(f"{total_redondeado(nota_tarefas, nota_teorico, nota_practico)} = Insuficiente")

#Para posibles erros de código
else:
    print("Erro, os valores introducidos teñen que estar entre 0 e 10")