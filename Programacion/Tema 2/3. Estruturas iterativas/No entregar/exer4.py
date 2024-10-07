""" 
Escribe un script que pida as notas dun exame dos alumnos dunha clase e conte o número de aprobados e suspensos. Pediráselle ao usuario que introduza notas por teclado ata que introduca un número inferior a 0 ou superior a 10. Mostrará primeiro o número de aprobados e despois o de suspensos.
"""

__author__ = "Marcos Chouza Cruces"

while True:
    
    nota = int(input("Introduce a nota do alumno: "))
    
    if nota < 0 or nota > 10:
        break
    
    elif nota < 5:
        print(f"{nota}: Este alumno está suspenso")
        
        
    elif nota >= 5:
        print(f"{nota}: Este alumno está aprobado")
        