en2gal = {'one': 'un', 'two' : 'dous', 'three' : 'tres'}

en2gal['four'] = 'catro'

"""
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
"""

