"""
Crea un script que pida as notas dun exame dos alumnos dunha clase para procesalos. Tódalas notas téñense que ir almacenando nunha lista. Mostra un menú que se mostre continuamente ata que o usuario seleccione a opción saír. As entradas do menú son:

a) Engadir nota
b) Ver media
c) Ver número de aprobados
d) Ver máxima nota
e) Eliminar nota Primeiro debes de mostrar un menú onde mostres para cada índice da lista, a súa nota. O usuario indicará o índice da nota a eliminar.
f) Saír


Para poder realizar cada acción do menú, implanta as seguintes funcións:

    · engadir_nota(lista: list[float], nota: float).

        - Comproba que a lista sexa unha lista, senón lanza excepción ValueError.
        - Se a nota é un valor inválido, lanza a excepción ValueError.


    · mostrar_notas(lista: list[float])

        - Comproba que a lista sexa unha lista, senón lanza excepción ValueError.
        - Débese mostrar neste formato: índice: nota. Exemplo:

        
    · media_notas(lista: list[float]) -> float

        - Comproba que a lista sexa unha lista, senón lanza excepción ValueError.

        
    · numero_aprobados(lista list[float]) -> int

        - Comproba que a lista sexa unha lista, senón lanza excepción ValueError.

    · maxima_nota(lista: list[float]) -> float

        - Comproba que a lista sexa unha lista, senón lanza excepción ValueError.

        
    · eliminar_nota(lista: list[float], indice: int)

        - Comproba que a lista sexa unha lista, senón lanza excepción ValueError.
        - Se o índice non é válido lanza excepción ValueError.
"""