#!/usr/bin/env python
# -*- coding: utf-8 -*-

#!/usr/bin/env python
# -*- coding: utf-8 -*-

""" 
Os números de teléfono completos teñen o seguinte formato: +prefixo-número-extensión. Por exemplo: +34-913724710-56. Tanto o prefixo, número e extensión poden ter un número variable de cifras que só poden ser numéricas.

Escribe unha función que reciba como parámetro un número de telefono, e devolva verdadeiro se o parámetro ten formato válido de teléfono ou falso en caso contrario.

Comproba que o tipo de datos do parámetro sexa unha cadea. En caso contrario lanza unha excepción ValueError.
"""

__autor__ = "Marcos Chouza Cruces"


def validar_telefono(telefono:str) -> bool:
    
    """
    Funcion encargada de validar o telefonos completos

    Args:
        telefono(str): Numero de telefono a validar
        
    Raises:
        ValueError: Se o parámetro teléfono non cumple co Type dado
        ValueError: Se a lonxitude do parámetro é baleira

    Returns:
        bool: False se o teléfono non cumple co tipado 
    """
    
    if type(telefono) is not str:
        raise ValueError('O parámetro "telefono" non coincide cos valores esperados.')
    if len(telefono) == 0:
        raise ValueError('Numero vacío.')
    
    telefono = telefono.replace(" ","").strip()
    
    if telefono[0] != "+":
        return False
    
    if not telefono["+":"-"].isdigit():
        return False
    
    if not telefono["-"::"-"].isdigit():
        return False
    
    if not telefono["-":-1].isdigit():
        return False
    

prefijo = "+34"
numero = "12345"
extension = "678"

telefono = prefijo + "-" + numero + "-" + extension

print(validar_telefono(telefono))