""" 
Escribe un script en Python que conte o número de palabras nunha cadea de texto introducida por teclado e o mostre por pantalla. Considera que as palabras están separadas por un ou máis espazos. Coidado cos dobres, triples ou máis espazos e cos espazos ao comezo e o final do texto.
"""

def contar_palabras(texto: str) -> int:

    texto = texto.strip()
    return





texto = input("Ingrese un texto para contar o seu número de palabras: ")

num_palabras = contar_palabras(texto)

print(f"o número de palabras do texto é: {num_palabras}")