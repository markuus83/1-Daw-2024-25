function OrdenarNumeros {
    $numeros = @()

    while ($true) {
        $input = Read-Host "Introduce un número (escribe 0 para rematar)"
        if ([int]$input -eq 0) {
            break
        }
        $numeros += [int]$input
    }

    if ($numeros.Count -eq 0) {
        Write-Host "Non introduciches ningún número."
        return
    }

    $numerosOrdenados = $numeros | Sort-Object
    Write-Host "Lista ordenada: $($numerosOrdenados -join ', ')"
}

clear

OrdenarNumeros
