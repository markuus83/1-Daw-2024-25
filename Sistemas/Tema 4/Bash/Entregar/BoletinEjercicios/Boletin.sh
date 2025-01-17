#!/bin/bash
calendario(){
    calendario=$(cal)
    echo "$calendario"
}

numero_palabras_lineas(){
    fichero_ejercicio_2=$1
    if (( -e "$fichero_ejercicio_2"))
    then
        echo "Non existe o ficheiro."
    else
        lineas=$(wc -l "$fichero_ejercicio_2")
        palabras=$(wc -w "$fichero_ejercicio_2")
        echo "O número de palabras é: "$palabras""
        echo "O número de liñas é: "$lineas""
    fi
}

copiar_archivos(){
    archivo=$1
    directorio=$2
    if [ ! -e "$archivo" ]
    then
        echo "El archivo no existe."
    elif [ ! -d "$directorio" ]
    then
        echo "El directorio no existe."
    else
        cp "$archivo" "$directorio"
        echo "El archivo se ha copiado"
    fi

}

renombrar_ficheros() {
    nombre_fichero=$1
    nuevo_nombre=$2
    if [[ -e "$nombre_fichero" ]]
    then
        mv "$nombre_fichero" "$nuevo_nombre"
        echo "El fichero se ha renombrado correctamente."
    else
        echo "El fichero '$nombre_fichero' no existe."
    fi
}

while true
do
    echo "Seleccione una opción:"
    echo "1. Mostrar el calendario"
    echo "2. Mostrar el número de palabras y de líneas de un fichero"
    echo "3. Copiar un archivo a un directorio destino"
    echo "4. Renombrar un fichero existente"
    echo "5. Salir"

    read -p "Ingrese a opción desexada: " option
    case $option in 

        1)
            calendario
            ;;

        2)
            read -p "Ingrese el nombre de un fichero: " fichero_ejercicio_2

            numero_palabras_lineas "$fichero_ejercicio_2"
            ;;

        3)
            read -p "Ingrese un archivo: " archivo
            read -p "Ingrese o directorio a copialo: " directorio

            copiar_archivos "$archivo" "$directorio"
            ;;

        4)

            read -p "Ingrese el nombre del fichero a renombrar: " nombre_fichero
            read -p "Ingrese el nuevo nombre del fichero: " nuevo_nombre

            renombrar_ficheros "$nombre_fichero" "$nuevo_nombre"
            ;;

        5)
            echo "Saíndo..."
            break
            ;;
        *)
            echo "Erro: opcion inválida"
    esac
    
done
