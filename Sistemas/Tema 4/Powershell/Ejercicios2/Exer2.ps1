function Adivina {
    $num1 = [int](Read-Host "Introduce o número inferior")
    $num2 = [int](Read-Host "Introduce o número superior")

    if ($num1 -ge $num2) {
        Write-Host "O número inferior debe ser menor que o superior"
        return
    }

    $numR = Get-Random -Minimum $num1 -Maximum ($num2+ 1)
    $intentos = 0
    $guess = -1

    while ($guess -ne $numR) {
        $guess = [int](Read-Host "Adiviña o número")
        $intentos++
        if ($guess -lt $numR) {
            Write-Host "O número é maior"
        } elseif ($guess -gt $numR) {
            Write-Host "O número é menor"
        }
    }

    Write-Host "Parabéns! Adiviñaches o número $numR en $intentos intentos."
}

clear

Adivina