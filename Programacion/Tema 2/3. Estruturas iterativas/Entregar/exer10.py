""" 
Escribe un script no que o usuario poida introducir números enteiros por teclado ata que teclee a palabra fin"fin". Tras finalizar a introdución de números, indícalle cal é o número máis pequeno introducido.
"""

__author__ = "Marcos Chouza Cruces"

while True:
    
    linea = input("> ")
    
    if linea[0] == '#' :
        continue
    
    if linea == 'fin':
        break
    print(linea)
    
print('¡Terminado!')