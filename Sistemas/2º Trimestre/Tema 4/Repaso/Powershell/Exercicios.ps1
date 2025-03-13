<# Escribir un xogo de adiviñanza. o programa pedirá ao usuario dous números 
(o número inferior e o número superior). O programa obterá, a continuación, 
un número aleatorio entre eses dous números, e o usuario deberá adiviñalo. 
Cada vez que o ususario introduce un número, o programa lle dice si é maior ou menor. 
Ao final, o programa indica o número de intentos utilizados#>

# `n  para hacer salto de línea

$contador = 1
$numero_aleatorio = Get-Random -Minimum 0 -Maximum 25

while($true){
    
       
    $numero = Read-Host "Ingrese un número: "
    
    if ($numero -eq $numero_aleatorio){
        Write-Host "Adiviñaches o número en $contador intentos!"
        break
    }

    elseif($numero -gt $numero_aleatorio){
        $contador += 1
        Write-Host "O número é menor"
    }

    else{
        $contador += 1
        Write-Host "O número é maior"
    }
}


<# Realizar un programa en Powershell que pida un número e devolva si
é primo ou non. Utiliza funcións na medida do posible#>


function esPrimo($numero) {

    if ($numero -le 1) {
        Write-Host "Non é primo"
        return
    }

    # Solo verificamos hasta la raíz cuadrada del número
    for ($i = 2; $i -lt $numero; $i++) {
        if ($numero % $i -eq 0) {
            Write-Host "Non é primo"
            return
        }
    }

    # Si no encontramos ningún divisor, es primo
    Write-Host "É primo"
}

$numero = Read-Host "Ingrese un número: "
esPrimo($numero)



<# Programa que recolla unha lista de números (ata que o usuario escriba un 0) e logo devolva esa lista ordenada #>

#Declaramos una lista
$lista =  @()

while($true){
    
    $numero = Read-Host "Ingrese un número (0 para terminar): "

    if($numero -ne 0){

        $lista += $numero

    } else{
        $lista_ordenada = $lista | Sort-Object

        Write-Host $lista_ordenada
        break
    }
}

