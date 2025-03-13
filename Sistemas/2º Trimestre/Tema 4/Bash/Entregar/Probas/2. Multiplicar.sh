clear

multiplicar_numeros(){

    read -p "Ingrese o primeiro número: " num1
    read -p "Ingrese o segundo número: " num2

    let "solucion=$num1*$num2"
	echo $solucion
}

multiplicar_numeros