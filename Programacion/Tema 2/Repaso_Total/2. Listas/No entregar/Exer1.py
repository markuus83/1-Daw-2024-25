""" 
Crea un script no que se ingresen as notas de alumnos. Vai gardando todas as notas que están entre 0 e 10 nunha lista. Cando o usuario introduza a palabra 'fin', non se pedirán máis notas. Ao finalizar o ingreso de notas mostra por pantalla a media de todas as notas.
"""
__author__ = "Marcos Chouza Cruces"

lista=[]

def almacenar_notas (nota: float, lista: list[float]) -> list:

    if type(nota) is not float:
        raise ValueError('O parámetro nota non cumple co valor esperado')
    
    if nota < 0 or nota > 10:
        raise ValueError('o parámetro nota non entra no rango esperado.')

    lista.append(nota)

    return lista


while True:

    nota = input("Ingrese unha nota: ")

    if nota == 'fin':
        break

    else:
        nota = float(nota)
        almacenar_notas(nota,lista)

print(lista)