clear

numeros_primos(){
        read -p "Introduce el primer número: " inicio
    read -p "Introduce el segundo número: " fin

    # Asegurar que el rango esté ordenado
    if (( inicio > fin )); then
        local temp=$inicio
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

numeros_primos