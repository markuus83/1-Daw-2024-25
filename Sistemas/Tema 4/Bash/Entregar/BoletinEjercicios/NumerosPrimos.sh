#!/bin/bash

primo() {

    num=$1

    if (( num <= 1 )); then
        echo "$num no es primo."
        return
    fi

    for (( i=2; i*i<=num; i++ )); do
        if (( num % i == 0 )); then
            echo "$num no es primo."
            return
        fi
    done

    echo "$num es primo."
}

read -p "Introduce un número para verificar si es primo: " numero
primo "$numero"
