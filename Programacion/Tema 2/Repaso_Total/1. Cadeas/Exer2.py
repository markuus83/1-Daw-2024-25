""" 
Escribe un script que determine se unha cadea tde texto introducida por teclado é un palíndromo. Un palíndromo é unha palabra que se le da mesma maneira de esquerda a dereita que de dereita a esquerda, ignorando espazos e maiúsculas. Se é palíndromo mostrará por pantalla <PALÍNDROMO> e senon o é <NON PALÍNDROMO>
"""


def palindromo_validador(cadea: str) -> int:
    
    cadea = cadea.replace(" ", "").lower()[::-1]
    
    return cadea


cadea = input("Ingrese unha cadea: ")

palindromo = palindromo_validador(cadea)

if palindromo:
    print("PALÍNDROMO")
else:
    print("NON PALÍNDROMO")