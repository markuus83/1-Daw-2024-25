""" 
Escribe un script que calcule o salario dun traballador. O programa recibirá por parte do usuario as horas traballadas ao día e os € por cada hora de traballo. A continuación preguntaralle ao usuario se a tarifa é en bruto ou en neto. A partir da súa resposta calcula o salario mensual neto.

    · Os días laborables ao mes son 22.
    · Se o usuario indica que o custe da hora é en bruto, indícalle ao usuario que introduza o IRPF en tanto por cen para poder calcularlle o salario neto.
    
Deduce o número necesario de funcións e defíneas
"""

__author__ = "Marcos Chouza Cruces"

def salario_neto (tarifa_neta: float) -> float:
    
    salario_diario = horas_traballadas * tarifa_neta  
    salario_total = 22 * salario_diario
    
    return salario_total


def salario_bruto(tarifa_bruta: float) -> float:
    
    salario_diario = horas_traballadas * tarifa_bruta
    salario_descontado = salario_diario - salario_diario * (irpf/100)
    salario_total = 22 * salario_descontado
    
    return salario_total
    
    
    
horas_traballadas = int(input("Ingrese a cantidade de horas traballadas: "))
irpf = float(input("Ingrese a porcentaxe de desconto IRPF: "))


print("\nAgora, imos seguir cos cálculos precisos...")
print("\ta) A miña tarifa é neta: ")
print("\tb) A miña tarifa é bruta: ")

opcion = input("> ")

if opcion == 'a':
    
    tarifa_neta = float(input("Ingrese a cantidade de cartos a recibir por hora: "))
    
    
elif opcion == 'b':
    
    tarifa_bruta = float(input("Ingrese a cantidade de cartos a recibir por hora: "))
    print(f"O salario mensual neto é: {salario_bruto(tarifa_bruta)}")
    
else:
    print("Erro")