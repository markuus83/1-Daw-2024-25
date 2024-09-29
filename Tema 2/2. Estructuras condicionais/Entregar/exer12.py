""" 
Escribe un script que pida o nome de usuario e contrasinal ao usuario. Indica se o inicio de sesión é correcto. O nome de usuario sería “python” e o contrasinal “pip”.
"""

__author__ = "Marcos Chouza Cruces"

#Establecemos a variables correctas, que usaremos máis adiante no código
usuario_correcto = "python"
contrasinal_correcta = "pip"

#Comezamos co primeiro bucle
while True:
    #Pedímoslle ao usuario que introduza o seu usario
    usuario = input("Introduce o nome do usuario: ")
    
    #Se o usuario proporcionado coincide co correcto, rompemos o blucle e seguimos ca seguinte parte do código
    if usuario == usuario_correcto:
        break
    
    #De ser incorrecto, repetímoslle ao usuario que introduzca o usuario ata que este coincida co obrigatorio
    else:
        print("Erro. Volva a introducir o nome do usuario: \n")
        
#Comezamos co segundo bucle
while True:
    #Pedímoslle ao usuario que introduza o seu contrasinal
    contrasinal = input("Introduce o contrasinal: ")
    
    #Se o contrasinal proporcionado coincide co correcto, rompemos o bucle e seguimos ca seguinte parte do código
    if contrasinal == contrasinal_correcta:
        break
    
    #De ser incorrecto, repetímoslle ao usuario que introduzca a contrasinal ata que esta coincida ca obrigatoria
    else:
        print("Erro. Volva a introducir a contrasinal: \n")
        
#Saída por pantalla final
print("Inicio de sesión correcto...")