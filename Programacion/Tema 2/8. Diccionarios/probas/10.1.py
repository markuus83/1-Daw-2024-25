"""

en2gal = {'one': 'un', 'two' : 'dous', 'three' : 'tres'}

en2gal['four'] = 'catro'



print(en2gal['three']) IMPRIME O VALOR DA CHAVE = TRES

print(en2gal['five']) #COMO NON EXISTE ESA CHAVE NO DICCIONARIO, IMPRIME KeyError

__________________________________________________________

valor = en2gal.get('four', 'K tonto no se encuentra en el diccionario')

print(valor)

__________________________________________________________

### VER SI UN VALOR SE ENCUENTRA EN EL DICCIONARIO

Almacenamos el valor en una variable con salida booleana.

x = 'one' in en2gal
print(x)

__________________________________________________________

### IMPRIMIR LOS VALORES DE UN DICCIONARIO

Convertimos los valores del diccionario en elementos de una lista

value = list(en2gal.values())
print(value)

__________________________________________________________

### IMPRIMIR LAS CLAVES DE UN DICCIONARIO

Convertimos las claves del diccionario en elementos de una lsita

claves = list(en2gal.keys())
print(claves)

__________________________________________________________
### ACTUALIZA LOS VALORES DE UN DICCIONARIO CON LOS VALORES DE OTRO, SI HAY UN VALOR REPETIDO LO SOBREESCRIBE

dicionario1 = {'a': 1, 'b': 2}
dicionario2 = {'b': 3, 'c': 4}

dicionario1.update(dicionario2)

print(dicionario1)  # Saida: {'a': 1, 'b': 3, 'c': 4}

__________________________________________________________

### ELIMINAMOS UN ELEMENTO DEL DICCIONARIO ESPECIFICANDO SU LLAVE.

diccionario = {'a': 1, 'b' : 2, 'c': 3}

valor_eliminado = diccionario.pop('b')

print(f"Valor eliminado: {valor_eliminado}")
print(f"Diccionario actualizado: {diccionario}")



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    RECORRER DICCIONARIOS
                    
### RECORREMOS OS VALORES DA LISTA E IMPRIMIMOS TANTO A CHAVE COMO O SEU VALOR

contadores = {'chuck' : 1 , 'annie' : 42, 'jan': 100}

for clave in contadores:
    print(clave, contadores[clave])

__________________________________________________________

### FACEMOS O MESMO PERO CUNHA SINTAXE MÁIS SENCILLA E UTILIZANDO UNHA FUNCION DO SISTEMA

dicionario = {'a': 1, 'b': 2, 'c': 3}

for clave, valor in dicionario.items():
    print(f"{clave} : {valor}")
    
__________________________________________________________


### AKÍ UNICAMENTE ITERAMOS SOBRE OS VALORES, SEN FACERLLE CASO AS CLAVES DO DICCIONARIO

dicionario = {'a': 1, 'b': 2, 'c': 3}

for valor in dicionario.values():
    print(valor)



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                        DICT COMPREHENSION  
                        
### PERMITE CREAR DICCIONARIOS DUNHA FORMA MOITO MÁIS EFICIENTE

cadrados = {numero: numero**2 for numero in range(1,10)}
print(cadrados)


~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                        REPRESENTACIÓN DE ENTIDADES
                        
persoa = {
    "nome": "Ana",
    "idade": 30,
    "cidade": "Santiago"
}

estudante = {
    "nome": "Xoán",
    "idade": 22,
    "curso": "Enxeñaría Informática",
    "enderezo": {
        "rúa": "Rúa das Camelias",
        "cidade": "A Coruña",
        "código_postal": "15001"
    }
}


# Acceder ao nome do estudante
print(estudante["nome"])  # Saída: Xoán

# Acceder á cidade do enderezo
print(estudante["enderezo"]["cidade"])  # Saída: A Coruña

# Acceder ao código postal do enderezo
print(estudante["enderezo"]["código_postal"])  # Saída: 15001


"""


