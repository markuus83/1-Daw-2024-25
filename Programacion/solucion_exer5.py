def cifra_cesar(texto: str, desprazamento: int) -> str:
    # Verificar que `texto` é unha cadea e `desprazamento` é un enteiro
    if type(texto) != str or type(desprazamento) != int:
        raise ValueError("O tipo de datos introducidos é incorrecto: 'texto' debe ser unha cadea de caracteres e 'desprazamento' un número enteiro.")
    
    # Configuración do alfabeto
    alfabeto = "abcdefghijklmnopqrstuvwxyz"
    texto_cifrado = ""
    
    # Aplicar o cifrado César
    for caracter in texto:
        if caracter in alfabeto:  # Só cifrar letras
            indice_actual = alfabeto.index(caracter)
            indice_cifrado = (indice_actual + desprazamento) % 26  # Ciclo polo alfabeto
            texto_cifrado += alfabeto[indice_cifrado]
        else:
            texto_cifrado += caracter  # Manter caracteres que non son letras

    return texto_cifrado

# Bloque principal
try:
    # Solicitar entrada ao usuario
    texto_usuario = input("Introduce o texto a cifrar: ").lower()
    desprazamento_usuario = int(input("Introduce o desprazamento: "))
    
    # Cifrar o texto e mostrar o resultado
    texto_cifrado = cifra_cesar(texto_usuario, desprazamento_usuario)
    print(f"Texto cifrado: {texto_cifrado}")
except ValueError as e:
    print(f"Erro: {e}")
