#!/bin/bash

comprobar_directorio(){
    if [ -e "$1" ]
    then
        echo ""
        echo -e "\tO nome existe no sistema."
        if [ -d "$1" ]
        then
            echo ""
            echo -e "\tE ademáis, é un directorio."
        else
            echo ""
            echo "Pero non é un directorio."
        fi
    else
        echo ""
        echo -e "\tO nome non existe no sistema."
    fi
}


limpar_pantalla(){
    clear
}


multiplicar_numeros(){

    multiplicacion=$(($1*$2))

    echo ""
    echo "O resultado da multiplicación é: $multiplicacion"
}


while [ true ]
do

    limpar_pantalla

    echo ""
    echo "Mira o seguinte menú: "
    echo ""
    echo " 1. Opción A"
    echo " 2. Opción B"
    echo " 3. Opción C"
    echo " 4. Fin"

    read -p "Escolla a opción desexada do menú: " option

        case $option in
            1)
                echo ""
                read -p "Introduce o nome do directorio: " comprobarDirectorio
                comprobar_directorio "$comprobarDirectorio"
                ;;

	  #Multiplicar dos números metidos por teclado
            2)
                echo ""
                read -p "Introduce el primer número: " numeroUno
                read -p "Introduce el segundo número: " numeroDos

                multiplicar_numeros "$numeroUno" "$numeroDos"
                ;;          3)
                echo "Opcion C"
                ;;

            4)
                echo ""
                echo "Saindo..."
                break
                ;;

            *)
                echo ""
                echo "Opción non válida. Inténteo de novo"
        esac

    echo ""
    read -p "Presione enter" #Realizamos unha pequena pausa para poder ver a saída do case

done
