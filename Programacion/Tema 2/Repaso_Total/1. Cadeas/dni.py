""" 
Un número de DNI ten o seguinte formato <00000000A>

Escribe un script que lle pida ao usuario o seu DNI e comprobe que sexa correcto. Para iso sigue os seguintes pasos:

    · Comproba a lonxitude da cadea.
    
    · Comproba que os 8 primeiros díxitos son números e o último é unha letra maiúscula. PISTA: utiliza a táboa do código ASCII.
    
    · Comproba que a letra introducida é o código de control do DNI.
    
Por último imprime <Válido> ou <Inválido> segundo corresponda.
"""



def validador_dni(dni: str) -> bool:
    
    letras_axuda = "TRWAGMYFPDXBNJZSQVHLCKE"
    
    dni = dni.upper().replace(" ", "")
    
    if len(dni) != 9:
        return False
    
    if not (dni[:8]).isdigit():
        return False
    
    if not(dni[8]).isalpha():
        return False
    
    numeros_dni = int(dni[:8])
    letra_calculada = letras_axuda[numeros_dni% 23]
    
    
    return dni[8] == letra_calculada
    
    

dni = input("Ingrese o seu dni: ")

dni_validado = validador_dni(dni)

if dni_validado:
    print("VÁLIDO")
    
else:
    print("INVÁLIDO")

