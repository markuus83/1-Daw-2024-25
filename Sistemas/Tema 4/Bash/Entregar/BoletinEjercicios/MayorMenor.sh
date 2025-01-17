#!/bin/bash

mayor_menor(){

    numero1=$1
    numero2=$2

    if [ "$numero1" -gt "$numero2" ]
    then
        for (( i = numero2 + 1; i < numero1; i++ ))
        do
            echo "$i"
        done    

    else
        echo "$numero1 no es mayor que $numero2."
    fi

}

read -p "Ingrese un número: " numero1
read -p "Ingrese outro número: " numero2

mayor_menor "$numero1" "$numero2"