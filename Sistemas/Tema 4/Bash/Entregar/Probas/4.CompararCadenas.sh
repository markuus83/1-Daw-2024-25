#!/bin/bash
clear

comparar_cadeas(){
    read -p "Ingrese unha cadea de texto: " cadea1
    read -p "Ingrese outra cadea de texto: " cadea2

    if [ $cadea1 == $cadea2 ]
    then
        echo "Son cadeas idénticas."
    else
        echo "Son cadeas distintas."
    fi

}

comparar_cadeas