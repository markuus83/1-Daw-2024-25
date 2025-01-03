"""
A avaliación deste módulo é a seguinte: 15% de tarefas, 20% exame teórico e 65% exame práctico. Escribe un script que lle pida ao usuario as súas tres notas sobre 10 
e indicaralle por pantalla a súa nota final sobre 10.

"""

__author__ = "Marcos Chouza Cruces"

#Recordatorio para o usuario
print("Recordarlle ao alumnado que a nota sobre cada apartado é únicamente sobre 10")

#Pedimos ao usuario que ingrese os datos necesarios
nota_tarefas = float(input("Ingrese a súa nota nas tarefas: "))
nota_teorico = float(input("Ingrese a súa nota do exame teórico: "))
nota_exame = float(input("Ingrese a súa nota do exame práctico: "))

#Facemos os cálculos oportunos

nota_total = 0.15*nota_tarefas + 0.2*nota_teorico + 0.65*nota_exame

#Amosamos por pantalla
print("A nota final do alumnado para  módulo é: ", nota_total)