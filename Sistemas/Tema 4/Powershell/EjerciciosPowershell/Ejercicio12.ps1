# Pon atributo oculto ao arquivo folla.dat que hai no directorio DOS. Tes que facer algo especial para listar dito arquivo oculto?

Set-ItemProperty -Path C:\DOS\folla.dat -Name Attributes -Value

	SOLUCION: $FILE = get-item C:\DOS\folla.dat
		  $FILE.Attributes = 'Hidden'
		  set-location C:\DOS
		  get-ChildItem -force

#Para listar arquivos ocultos: ls -h
