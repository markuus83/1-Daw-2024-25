""" 
Escribe un script que elixirá no seu comezo un número ao azar entre 1 e 25. A continuación, o usuario introducierá números por teclado ata que acerte o número seleccionado ao azar. Cada vez que se introduza un número incorrecto, o script proporcionaralle pistas ao usuario: "o número é maior" ou "o número é menor".  Unha vez que o usuario acerte o número, indicaráselle por pantalla se gañou o xogo oun non. Para gañas, o usuario deberá acertar o número en menos de 5 intentos.

"""

__author__ = "Marcos Chouza Cruces"

import random

numero_aleatorio = random.randint(1,25)
