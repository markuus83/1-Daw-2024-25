#!/bin/bash
nome="Marcos"
edad=20

#Con el comando let nos deja sumar valores en una variable.
#Si queremos sumar una variable debemos poner obligatoriamente el carácter $

let suma=10+$edad


echo $nome
echo $edad

echo "La edad de "$nome" dentro de 10 años será: "$suma
