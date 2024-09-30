""" 
Escribe un script que calcule o salario dun traballador. O programa recibirá as horas traballadas ao día e os € por hora dese traballo por parte do usuario. 
A continuación preguntaralle ao usuario se a tarifa é en bruto ou en neto. A partir da súa resposta calcula o salario mensual neto.

    · Os días laborables ao mes son 22
    · Se o usuario indica que o custe da hora é en bruto, indícalle ao usuario que introduza o IRPF para poder calcularlle o salario neto

"""
__author__ = "Marcos Chouza Cruces"

#Importamos unha librería. Non é precisa para o correcto funcionamento do código
import time

#Supoñemos, que o usuario sempre traballa a mesma cantidade de horas ao día

#Pedimoslle ao usuario que introduza os datos precisos
horas_traballadas = int(input("Ingrese a cantidade de horas traballadas: "))
irpf = float(input("Ingrese a porcentaxe de desconto IRPF: "))

#usamos a importación da librería, aínda que non é precisa
time.sleep(1)

#Comezamos coa estrutura condicional, para calcular o seu salario mensual dependendo das diferentes circunstancias
print("\nAgora, imos seguir cos cálculos precisos...")
print("\ta) A miña tarifa é neta: ")
print("\tb) A miña tarifa é bruta: ")

#Establecemos a opción que queremos utilizar
opcion = input(">")

#O primeiro 'IF' serve para dar o salario mensual cando xa está o desconto do IRPF no salario por horas
if opcion == 'a':
    
    tarifa_neta = float(input("Ingrese a cantidade de cartos a recibir por hora: "))
    
    salario_diario = horas_traballadas*tarifa_neta
    salario_total = 22*salario_diario
    print("O salario mensual do usuario é de:", salario_total)


#O segundo 'IF' serve para dar o salario mensual cando NON está descontado o IRPF no salario por horas
elif opcion == 'b':
    
    tarifa_bruta = float(input("Ingrese a cantidade de cartos a recibir por hora: "))
    salario_diario = horas_traballadas*tarifa_bruta
    salario_descontado = salario_diario - salario_diario*(irpf/100)
    salario_total = salario_descontado = 22*salario_descontado
    print("O salario mensual do usuario é:", salario_total)

#O último 'IF' encárgase de amosar posibles erros do código
else:
    print("Erro")