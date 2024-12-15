def maxima_nota(lista: list[float]) -> float:
    
    if type(lista) is not list:
        raise ValueError('O parámetro lista non coincide co esperado. (MAXIMA NOTA)')
    
    nota_mais_alta = 0
    
    for numero in lista:
        if numero >= nota_mais_alta:
            nota_mais_alta == numero
    
    return nota_mais_alta

lista = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

nota_maxima = maxima_nota(lista)

print(f"A máxima nota é: {nota_maxima}")