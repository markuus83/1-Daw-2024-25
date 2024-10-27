# EJERCICIO 4 # # EJERCICIO 4 # # EJERCICIO 4 # # EJERCICIO 4 # # EJERCICIO 4 # # EJERCICIO 4 # # EJERCICIO 4 # # EJERCICIO 4 # 


def raiz_cadrada(numero: float) -> float:
    """
    Calcula a raíz cadrada dun número.
    
    Args:
        numero (float): Número do cal se quere calcular a raíz cadrada.
        
    Returns:
        float: Valor do return
    """
    if numero < 0:
        return None
    
    return numero ** 0.5

# Pedimos ao usuario que ingrese os datos
entrada = input("Introduce un número para calcular a súa raíz cadrada: ")

# Convertimos a entrada e comprobamos se é un valor numérico válido
try:
    numero = float(entrada)
    resultado = raiz_cadrada(numero)
    
except ValueError:
    print("Erro: Debes introducir un valor numérico válido.")
    
else:
    # Verificamos se o número é positivo
    if resultado is None:
        print("Erro: Debes introducir un número positivo.")
    else:
        print(f"A raíz cadrada de {numero} é {resultado}.")



# EJERCICIO 5 # # EJERCICIO 5 # # EJERCICIO 5 # # EJERCICIO 5 # # EJERCICIO 5 # # EJERCICIO 5 # # EJERCICIO 5 # # EJERCICIO 5 # 


def calcular_desconto_irpf(soldo_bruto: float, irpf: int) -> float:
    """
    Calcula o desconto do IRPF dado un soldo bruto e unha porcentaxe de IRPF.
    
    Args:
        soldo_bruto (float): Soldo bruto a percibir.
        irpf (int): Porcentaxe de desconto a aplicar.
        
    Returns:
        float: Valor do desconto de IRPF, ou None se os valores non son válidos.
    """
    
    if soldo_bruto <= 0 or not (0 <= irpf <= 100):
        return None
    
    desconto = soldo_bruto * (irpf / 100)
    return desconto

# Pedimos ao usuario que ingrese os datos
soldo_bruto = input("Introduce o soldo bruto: ")
irpf = input("Introduce o IRPF en tanto por cen: ")

# Convertimos a entrada e comprobamos se é un valor numérico válido
try:
    soldo_bruto = float(soldo_bruto)
    irpf = float(irpf)
    desconto = calcular_desconto_irpf(soldo_bruto, irpf)
    
except ValueError:
    print("Erro: Os datos introducidos non son válidos. Asegúrate de introducir valores numéricos.")
    
else:
    # Verificamos se o desconto foi calculado correctamente
    if desconto is None:
        print("Erro: O soldo debe ser maior que 0 e o IRPF debe estar entre 0 e 100.")
    else:
        print(f"O desconto do IRPF sobre o soldo bruto de {soldo_bruto}€ é {desconto}€.")
