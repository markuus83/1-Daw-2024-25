function es_primo(){
	if ($numero -lt 2){
		Write-Host "Non é primo (PRIMEIRA PARTE)"
	} else {
		for($i=2; $i -le [Math]::Sqrt($numero);$i++){
			if ($numero%i -ne 0){
				Write-Host "É primo"
			} else {
				Write-Host "Non é primo (SEGUNDA PARTE)"
			}
		}
	}
}

$numero = Read-Host "Ingrese un número para calacular se é primo ou non: "
es_primo($numero)
