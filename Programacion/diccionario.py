diccionario = {
    1: ['hola', 'miau'],
    2: ['adios', 'miau']
}

for clave, lista in diccionario.items():
    for elemento in lista:
        print(f"{clave} - {elemento}")
