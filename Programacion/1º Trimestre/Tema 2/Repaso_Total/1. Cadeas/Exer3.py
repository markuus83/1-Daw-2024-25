""" 
Escribe un script que elimine todas as consoantes dunha cadea de texto introducida por teclado e devolva unha nova cadea só cas vocais e outros caracrters. Mostra ese texto por pantalla.
"""

def eliminar_consoantes(texto: str) -> str:

    consonantes = "bcdefghjklmnñpqrstvwxyzBCDFGHJKLMNÑPQRSTVWXYZ"

    cadea_axuda = ''

    for caracter in texto:
        
        if caracter not in consonantes:
            cadea_axuda = cadea_axuda + caracter

    return cadea_axuda


texto = input("Ingrese un texto para eliminar as súas vocais: ")

texto_sen_consoantes = eliminar_consoantes(texto)
print(f"O texto é: {texto_sen_consoantes}")