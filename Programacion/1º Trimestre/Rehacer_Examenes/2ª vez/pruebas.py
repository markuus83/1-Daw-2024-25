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

    return


try:
    venta_repetida = prezo_alugamento_mais_repetido(lista_vivendas)
    print(f"O prezo de venta máis repetido é: {venta_repetida}")
    
except ValueError as erro:
    print(f"Erro: {erro}")
    