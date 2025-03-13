function EsPrimo {
    param ([int]$Number)
    if ($Number -le 1) {
        return $false
    }
    for ($i = 2; $i -le [math]::Sqrt($Number); $i++) {
        if ($Number % $i -eq 0) {
            return $false
        }
    }
    return $true
}

function Consultar {
    do {
        $num = Read-Host "Introduce un número para comprobar se é primo"
        if (EsPrimo -Number $num) {
            Write-Host "$num é un número primo"
        } else {
            Write-Host "$num non é un número primo"
        }

        $continue = Read-Host "Queres comprobar outro número? (s/n)"
    } while ($continue -eq 's')
}

clear

Consultar