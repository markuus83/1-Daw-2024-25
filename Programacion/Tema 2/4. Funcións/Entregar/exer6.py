""" 
Escribe un script que pida o nome de usuario e contrasinal ao usuario. Indica se o inicio de sesión é correcto. O nome de usuario correcto sería 'python' e o contrasinal 'pip'. Crea a función:

    · login(usuario: str, contrasinal: str) -> boolean
"""

__author__ = "Marcos Chouza Cruces"


def login (usuario: str, contrasinal: str) -> bool:
    
    """_summary_

    Returns:
        _type_: _description_
    """
    
    if usuario == 'python' and contrasinal == 'pip':
        return True

    else:
        return False


usuario = input("Introduce o nome do usuario: ")
contrasinal = input("Introduce o contrasinal: ")

print(login(usuario, contrasinal))