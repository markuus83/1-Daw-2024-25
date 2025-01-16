#!/bin/bash

read -p "Ingrese un número: " numero1
read -p "Ingrese outro número: " numero2

if [ "$numero1" -gt "$numero2" ]; then
    for (( i = numero2 + 1; i < numero1; i++ )); do
        echo "$i"
    done    
else
    echo "$numero1 no es mayor que $numero2."
fi