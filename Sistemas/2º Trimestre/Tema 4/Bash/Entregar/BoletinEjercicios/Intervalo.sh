#!/bin/bash
intervalo(){

    numero=$1

    if [ "$numero" -ge 0 -a "$numero" -le 25 ]
    then
        echo "O número '"$numero"' sí está comprendido entre 0 e 25."
    else
        echo "O número '"$numero"' non está comprendido entre 0 e 25"
    fi

}

read -p "Ingrese un número: " numero

intervalo "$numero"

