#!/bin/bash
clear

#-e Existe ficheiro ou directorio
#-f Existe ficheiro NON directorio
#-s Ficheiro baleiro
#-d É un directorio
#-r|-w|-x Ten os permisos indicados
#-nt Máis recente
#-ot Máis antigo

read -p "Introduce o nome dun ficheiro: " f
if [ -e "$f" ]; then
    echo "O ficheiro existe"
    if [ -s "$f" ]; then
        echo "Non está baleiro"
    else
        echo "Está baleiro"
    fi
else
    echo "Ese ficheiro non existe (MIAU MIAU MIAU MIAU)"
fi
