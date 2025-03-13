#Crea un directorio en C que se chame PRACTICA2 e copia o ficheiro LABEL.EXE do subdirectorio SYSTEM32 de WINDOWS en PRACTICA2 pero co nome ETIQUETA.EXE. Podes utilizar 2 comandos.

Copy-Item -Path C:\Windows\System32\label.exe -Destination C:\PRACTICA2 

Rename-Item -Path C:\PRACTICA2\ETIQUETA.EXE