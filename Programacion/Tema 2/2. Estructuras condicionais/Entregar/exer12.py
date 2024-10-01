"""
Escribe un script que pida o nome de usuario e contrasinal ao usuario. Indica se o inicio de sesión é correcto. O nome de usuario sería “python” e o contrasinal “pip”.
"""

__author__ = "Marcos Chouza Cruces"

# Establecemos a variables correctas, que usaremos máis adiante no código
usuario_correcto = "python"
contrasinal_correcta = "pip"

# Pedimos o nome de usuario
usuario = input("Introduce o nome do usuario: ")
contrasinal = input("Introduce o contrasinal: ")

# Comprobamos se o usuario é correcto
if usuario == usuario_correcto and contrasinal == contrasinal_correcta:
    print("Inicio de sesión exitoso. ")
    
else:
    print("Erro")
