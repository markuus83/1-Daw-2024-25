def engadir_nota(lista:list[float], nota: float) -> list:
        
    if type(lista) is not list:
        raise ValueError('O parámetro lista non coincide co esperado. (ENGADIR NOTA)')
    
    if type(nota) is not float:
        raise ValueError('O parámetro nota non coincide co esperado. (ENGADIR NOTA)')
    
    if nota > 10 or nota < 0:
        raise ValueError ('O valor das notas non coincide co esperado (ENGADER NOTA)')
    
    lista = lista.append(nota)
    
    return lista



def media_notas(lista: list[float]) -> float:
    
    if type(lista) is not list:
        raise ValueError('O parámetro lista non coincide co esperado. (MEDIA NOTA)')
    
    if len(lista) == 0:
        raise ValueError('Non se pode calcular a media dunha lista vacía.')
    

    suma = 0
    
    for numero in lista:
        suma += numero
        
    media = suma/len(lista)
    
    return media 



def numero_aprobados(lista: list[float]) -> int:
    
    if type(lista) is not list:
        raise ValueError('O parámetro lista non coincide co esperado. (NUMERO APROBADOS)')
    
    if len(lista) == 0:
        raise ValueError('Non se pode calcular a máxima nota dunha lista vacía (NUMERO APROBADOS)')
    
    aprobados = 0
    
    for numero in lista:
        if numero >= 5:
            aprobados += 1
            
    return aprobados



def maxima_nota(lista: list[float]) -> float:
    
    if type(lista) is not list:
        raise ValueError("O parámetro non é unha lista. (NOTA_MAXIMA)")
    
    if len(lista) == 0:
        raise ValueError('Non se pode calcular a máxima nota dunha lista vacía (MAXIMA NOTA)')
    
    maxima_nota = 0 
    
    #Recorremos cada elemento da lista
    for nota in lista:
        
        #Capturamos unha posible excepción
        if type(nota) is not float:
            raise ValueError("O elemento non é numérico. (NOTA_MÁXIMA)")
        
        #Almacenamos nunha variable a nota máis grande 
        if nota > maxima_nota:
            maxima_nota = nota

    return maxima_nota



def mostrar_notas(lista: list[float]) -> float:
    
    if type(lista) is not list:
        raise ValueError('O parámetro lista non coincide co esperado. (MOSTRAR NOTA)')
    
    if len(lista) == 0:
        raise ValueError('Nonse pode calcular a máxima nota dunha lista vacía (MOSTRAR NOTA)')
    
    for indice, numero in enumerate(lista):
        print(f"{indice} : {numero}")



def eliminar_nota(lista: list[float], indice: int):
    
    if type(lista) is not list:
        raise ValueError('O parámetro lista non coincide co esperado. (ELIMINAR NOTA)')
    
    if type(indice) is not int:
        raise ValueError('O parámetro indice non coincide co esperado. (ELIMINAR NOTA)')
    
    if len(lista) == 0:
        raise ValueError ('Non se poden eliminar elementos dunha lista vacía. (ELIMINAR NOTA)')
        
    del lista[indice]
    
    return lista



#Inicializamos a lista onde almacenaremos as notas dos alumnos
lista = []


while True:
    print("\n--------------------------\nPrema a opción desexada no menú.")
    print("\t a) Engadir nota: ")
    print("\t b) Ver media: ")
    print("\t c) Ver número de aprobados: ")
    print("\t d) Ver máxima nota: ")
    print("\t e) Eliminar nota: ")
    print("\t f) Saír")
    
    option = input(">")
    
    if option == 'a':
        try:
            nota = float(input("Ingrese unha nota: "))
            engadir_nota(lista, nota)
        except ValueError as erro:
            print(f"Erro: {erro}")
    
    elif option == 'b':
        try:
            media = media_notas(lista)
            print(f"A media das notas son: {media}")
        except ValueError as erro:
            print(f"Erro: {erro}")
    
    elif option == 'c':
        try:
            aprobados = numero_aprobados(lista)
            print(f"O número de aprobados é de: {aprobados}")
        except ValueError as erro:
            print(f"Erro: {erro}")
    
    elif option == 'd':
        try:
            nota_maxima = maxima_nota(lista)
            print(f"A nota máis alta é: {nota_maxima}")
        except ValueError as erro:
            print(f"Erro: {erro}")
    
    elif option == 'e':
        try:
            mostrar_notas(lista)
            indice = int(input("Ingrese o índice da nota a eliminar: "))
            eliminar_nota(lista, indice)
        except ValueError as erro:
            print(f"Erro: {erro}")
        except IndexError:
            print("Erro: O índice proporcionado non existe na lista.")
    
    elif option == 'f':
        print("Saíndo...")
        break
    
    else:
        print("Opción non válida, intente de novo.")
