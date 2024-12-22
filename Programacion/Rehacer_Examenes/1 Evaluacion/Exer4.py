#!/usr/bin/env python
# -*- coding: utf-8 -*-

#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Os número de teléfono completos teñen o seguinte foprmato: +prefixo-número-extensión. Por exemplo: +34-913724710-56. Tanto o prefixo, número e extensión poden ter un número variable de cifras que só poden ser numéricas.

Escribe unha función que reciba como parámetro un número de teléfono, e devolva verdadeiro se o parámetro ten formáto válido de teléfono ou falso en caso contrario. 

Comproba que o tipo de datos do parámetro sexa unha cadea. En caso contrario lanza unha excepción ValueError.
"""

__autor__ = "Marcos Chouza Cruces"

def comprobador_telefono(telefono: str) -> bool:

    if type(telefono) != str:
        raise ValueError('Os tipado da variable "telefono" non coincide co valor esperado.')
    
    if len(telefono) == 0:
        return False
    
    if telefono[0] != '+':
        return False

    return


prefixo = '+34'
numero = '12345'
extension = '6789'
telefono = f"{prefixo}-{numero}-{extension}"
print(telefono)