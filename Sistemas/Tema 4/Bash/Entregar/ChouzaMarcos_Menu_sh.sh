#!/bin/bash

# 1. Comprobar que la variable introducida por teclado es un directorio.
# 2. Multiplicar dos números introducidos por teclado.
# 3. Mostrar los números primos comprendidos entre dos númereos introducidos por teclado.
# 4. Comparar dos cadenas introducidas por teclado.
# 5. Listar el contenido del direcorio home.
# 6. salir

limpiar_pantalla() {
	clear
}

mostrar_menu() {
	echo "Menu de opciones: "
	echo "1. Comprobar directorio: "
	echo "2. Multiplicar dos números por teclado: "
	echo "3. Mostrar números primos comprendidos entre dos números: "
	echo "4. Comparar dos cadenas introducidas por teclado: "
	echo "5. Listar el contenido de /home: "
	echo "6. Salir"
}

comprobar_directorio(){
	read -p "Ingrese o nome dun directorio: " directorio
	if [ -d "$directorio" ];then
		echo "É un directorio."
	else
		echo "Non é un directorio."
	fi
}

multiplicar_numeros(){

    read -p "Ingrese o primeiro número: " num1
    read -p "Ingrese o segundo número: " num2

    let "solucion=$num1*$num2"
	echo $solucion
}

numeros_primos(){
    read -p "Introduce el primer número: " inicio
    read -p "Introduce el segundo número: " fin

    # Asegurar que el rango esté ordenado
    if (( inicio > fin )); then
        temp=$inicio
        inicio=$fin
        fin=$temp
    fi

    echo "Números primos entre $inicio y $fin:"
    for (( num=inicio; num<=fin; num++ )); do
        # Comprobar si el número es primo
        if (( num > 1 )); then
            primo=1 # Suponemos que es primo
            for (( i=2; i*i<=num; i++ )); do
                if (( num % i == 0 )); then
                    primo=0 # No es primo
                    break
                fi
            done
            # Mostrar el número si es primo
            if (( primo == 1 )); then
                echo "$num"
            fi
        fi
    done
}

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

listar_home(){
    home=$(ls /home/)
    echo "$home"
}

while true;
do

limpiar_pantalla
mostrar_menu

read -p "Ingrese a opción desexada do menú: " opcion

case $opcion in
	1)
		comprobar_directorio
		;;
	2)
		multiplicar_numeros
		;;
	3)
		numeros_primos
		;;
	4)
		comparar_cadeas
		;;
	5)
		listar_home
		;;

	6)
		echo "Saliendo del programa..."
		break
		;;
    *)
        echo "Opción no válida. Por favor, elija una opción del menú."
        ;;

	esac

	echo "Presione Enter para continuar..."
    read
done