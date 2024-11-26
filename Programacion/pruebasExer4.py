lista = [{'nome': 'Marcos', 'apelidos': 'Ola', 'nota': 9}, {'nome': 'Pepe', 'apelidos': 'Viruela', 'nota': 8.75}, {'nome': 'Oscar', 'apelidos': 'Carballo', 'nota': 10}]


def mostrar_lista_alumnos(lista: list) -> list:
    
    resultado = ""
    
    for indice, diccionario in enumerate(lista):
        resultado += f"{indice + 1}. {diccionario['apelidos']}, {diccionario['nome']}: {diccionario['nota']}\n"
        
    return resultado


print(mostrar_lista_alumnos(lista))
