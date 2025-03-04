#!/bin/bash

#Realiza un programa en BASH que realice 5 acciones diferentes:

    #1. Comprobar que la variable introducida por teclado es un directorio.

    #2. Multiplicar dos números introducidos por teclado.

    #3. Mostrar los números primos comprendidos entre dos números introducidos por teclado.

    #4. Comparar dos cadenas introducidas por teclado.

    #5. Listar el contenido del directorio home.
    #Salir.

#El programa debe de cumplir con lo siguiente:

    # 3 Limpiar la pantalla antes de hacer nada.

    # · Mostrar el menú con las diferentes opciones.
    
    # · Debe ejecutarse todo el rato hasta que el usuario decida salir del programa.

    # · Tienes que subir un archivo con el código y con el siguiente formato de nombre:

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

}



comparar_cadeas(){


}



listar_contido_home(){

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

            4)
                echo ""
                read -p "Introduce unha cadea de terxto: " primeiraCadea
                read -p "Introduce outra cadea de texto: " segundaCadea

                comparar_cadeas "$primeiraCadea" "$segundaCadea"
                ;;

            5)
                echo ""
                listar_contido_home
                ;;

            6)
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