#!bin/bash

while [ true ]
do

    echo " 1. Opción A"
    echo " 2. Opción B"
    echo " 3. Opción C"
    echo " 4. Fin"

	read -p "Escolla a opción desexada do menú: " option

	case $option in
        	1)
			echo "Opcion A"
        		;;

	        2)
        		echo "Opcion B"
			;;

        	3)
		        echo "Opcion C"
			;;

	        4)
	        	echo "Saindo..."
	        	break
		        ;;

        *)
        echo "Opción non válida. Inténteo de novo"
    esac

	read -p "Presione enter"
done


