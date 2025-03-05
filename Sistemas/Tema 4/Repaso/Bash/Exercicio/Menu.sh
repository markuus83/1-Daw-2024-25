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



amosar_primos(){

    echo ""
    echo "Amosar primos"

}



comparar_cadeas(){

    if [[ "$1" != "$2" ]]
    then 
        echo ""
        echo "Son cadeas DISTINTAS"
    else
        echo ""
        echo "Son cadeas IGUAIS"
    fi

}


listar_contido_home(){

    home=$=(ls /home)

    echo "$home"

}



while [ true ]
do

    limpar_pantalla

    echo ""
    echo "Mira o seguinte menú: "
    echo ""
    echo " 1. Comprobar se unha variable é un directorio: "
    echo " 2. Multilicar dous números: "
    echo " 3. Amosar os números primos comprendidos entre dous números: "
    echo " 4. Comparar dúas cadenas introducidas por teclado: "
    echo " 5. Listar o contido do directorio /home: "
    echo " 6. Saír: "
    echo ""
    read -p "Escolla a opción desexada do menú: " option

        case $option in

            #Comprobar se unha variable é un directorio
            1) 
                echo ""
                read -p "Introduce o nome do directorio: " comprobarDirectorio
                comprobar_directorio "$comprobarDirectorio"
                ;;


            #Multiplicar dos números metidos por teclado
            2)
                echo ""
                read -p "Introduce o primeiro número: " numeroUno
                read -p "Introduce o segundo número: " numeroDos

                multiplicar_numeros "$numeroUno" "$numeroDos"
                ;;


            #Mostrar los números primos comprendidos entre dos números introducidos por teclado
            3)
                echo ""
                read -p "Introduce o primeiro número: " numeroPequeno
                read -p "Introduce o segundo número: " numeroGrande

                amosar_primos "$numeroPequeno" "$numeroGrande"

                ;;


            #Comparar dúas cadenas 
            4)
                echo ""
                read -p "Introduce unha cadea de terxto: " primeiraCadea
                read -p "Introduce outra cadea de texto: " segundaCadea

                comparar_cadeas "$primeiraCadea" "$segundaCadea"
                ;;


            #Listar o contido do directorio /home
            5)
                echo ""
                listar_contido_home
                ;;


            #Saír
            6)
                echo ""
                echo "Saindo..."
                break
                ;;

            #Valor por defecto
            *)
                echo ""
                echo "Opción non válida. Inténteo de novo"
        esac

    echo ""
    read -p "Presione enter" #Realizamos unha pequena pausa para poder ver a saída do case

done