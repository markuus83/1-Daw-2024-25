lista_vivendas = [
    {
        'direccion': 'Direccion 1',
        'estado':'venta', 
        'prezo': 10
    },
    {
        'direccion': 'Direccion 2',
        'estado': 'aluguer', 
        'prezo': 100
    },
    {
        'direccion': 'Direccion 3',
        'estado': 'aluguer', 
        'prezo': 200
    },
    {
        'direccion': 'Direccion 4',
        'estado': 'aluguer', 
        'prezo': 400
    },
    {
        'direccion': 'Direccion 5',
        'estado': 'aluguer', 
        'prezo': 300
    },
    {
        'direccion': 'Direccion 6',
        'estado': 'aluguer', 
        'prezo': 500
    }
]


def prezo_alugamento_mais_repetido(lista_vivendas: list) -> float:
    if type(lista_vivendas) != list:
        raise ValueError('O parámetro "lista_vivendas" non coincide cos valores esperados (ALUGAMENTO MÁIS REPETIDO)')
    if len(lista_vivendas) == 0:
        raise ValueError('Non se poden sacar datos dunha lista baleira (ALUGAMENTO MÁIS REPETIDO)')

    prezos = []
    
    for diccionario in lista_vivendas:
        if diccionario['estado'] == 'aluguer':
            prezos.append(diccionario['prezo'])

    if len(prezos) == 0:
        return None
    
    prezos_repetidos = []
    vistos = []
    
    for numero in prezos:
        if numero not in vistos:
            vistos.append(numero)
        else:
            if numero not in prezos_repetidos:
                prezos_repetidos.append(numero)
                
    if len(prezos_repetidos) == 0:
        return min(prezos)
    
    return min(prezos_repetidos)


try:
    venta_repetida = prezo_alugamento_mais_repetido(lista_vivendas)
    print(f"O prezo de venta máis repetido é: {venta_repetida}")
    
except ValueError as erro:
    print(f"Erro: {erro}")
    