#Copia todos os ficheiros do directorio PRACTICA2 que teñen extensión txt no directorio DOS pero coa extensión sol. Fai cunha soa orde o listado -> renomeado, a copia podes facela aparte.

Get-ChildItem -Path "C:\PRACTICA2" -Filter *.txt | Copy-Item -Destination { $_.FullName -replace '\.txt$', '.sol' } -Force