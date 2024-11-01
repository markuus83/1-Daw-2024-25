def descifra_cesar(texto: str, desprazamento: int) -> str:
    # Verificar que `texto` é unha cadea e `desprazamento` é un enteiro
    if type(texto) != str or type(desprazamento) != int:
        raise ValueError("O tipo de datos introducidos é incorrecto: 'texto' debe ser unha cadea de caracteres e 'desprazamento' un número enteiro.")
    
    # Configuración do alfabeto
    alfabeto = "abcdefghijklmnopqrstuvwxyz"
    texto_descifrado = ""
    
    # Aplicar o descifrado César
    for caracter in texto:
        if caracter in alfabeto:  # Só descifrar letras
            indice_actual = alfabeto.index(caracter)
            indice_descifrado = (indice_actual - desprazamento) % 26  # Ciclo polo alfabeto
            texto_descifrado += alfabeto[indice_descifrado]
        else:
            texto_descifrado += caracter  # Manter caracteres que non son letras

    return texto_descifrado

# Bloque principal
try:
    # Solicitar entrada ao usuario
    texto_usuario = input("Introduce o texto a descifrar: ").lower()
    desprazamento_usuario = int(input("Introduce o desprazamento: "))
    
    # Descifrar o texto e mostrar o resultado
    texto_descifrado = descifra_cesar(texto_usuario, desprazamento_usuario)
    print(f"Texto descifrado: {texto_descifrado}")
except ValueError as e:
    print(f"Erro: {e}")
