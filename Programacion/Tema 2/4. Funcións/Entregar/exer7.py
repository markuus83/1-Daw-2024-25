""" 
Escribe un script que calcule o salario dun traballador. O programa recibirá por parte do usuario as horas traballadas ao día e os € por cada hora de traballo. A continuación preguntaralle ao usuario se a tarifa é en bruto ou en neto. A partir da súa resposta calcula o salario mensual neto.

    · Os días laborables ao mes son 22.
    · Se o usuario indica que o custe da hora é en bruto, indícalle ao usuario que introduza o IRPF en tanto por cen para poder calcularlle o salario neto.
    
Deduce o número necesario de funcións e defíneas
"""

__author__ = "Marcos Chouza Cruces"

def salario_neto(horas_traballadas: int, tarifa_neta: float) -> float:
    """
    Calcula o salario neto a través da tarifa neta

    Args:
        horas_traballadas (int): Número de horas traballadas polo usuario
        tarifa_neta (float): Cantidade de cartos netos a recibir por hora

    Returns:
        float: Tipo de dato do return
    """
    salario_diario = horas_traballadas * tarifa_neta  
    salario_total = 22 * salario_diario
    return salario_total

def salario_bruto(horas_traballadas: int, tarifa_bruta: float, irpf: float) -> float:
    """
    Calcula o salario neto a través da tarifa bruta

    Args:
        horas_traballadas (int): Número de horas traballadas
        tarifa_bruta (float): Cantidade de cartos brutos a recibir por hora
        irpf (float): Desconto do IRPF a acplicar

    Returns:
        float: Tipo de dato do return
    """
    salario_diario = horas_traballadas * tarifa_bruta
    salario_descontado = salario_diario - (salario_diario * (irpf / 100))
    salario_total = 22 * salario_descontado
    return salario_total

horas_traballadas = int(input("Ingrese a cantidade de horas traballadas ao día: "))

print("\nAgora, imos seguir cos cálculos precisos...")
print("\ta) A miña tarifa é neta.")
print("\tb) A miña tarifa é bruta.")

#Establecemos a opción a escoller
opcion = input("> ")

#Fai un chamado a función correspondente e da a saída por pantalla
if opcion == 'a':
    tarifa_neta = float(input("Ingrese a cantidade de cartos a recibir por hora: "))
    print(f"O salario mensual neto é: {salario_neto(horas_traballadas, tarifa_neta):.2f} €")

#Fai un chamado a función correspondente e da a saída por pantalla
elif opcion == 'b':
    tarifa_bruta = float(input("Ingrese a cantidade de cartos a recibir por hora: "))
    irpf = float(input("Ingrese a porcentaxe de desconto IRPF: "))
    print(f"O salario mensual neto é: {salario_bruto(horas_traballadas, tarifa_bruta, irpf):.2f} €")

#para posibles erros de código
else:
    print("Erro: opción non válida.")
