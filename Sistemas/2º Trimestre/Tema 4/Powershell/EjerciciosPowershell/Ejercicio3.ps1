#Fai a seguinte estrutura de directorios e arquivos:
#C:
#SISTEMAS
#DOS
#MANUAL
    #manual.txt
#EXERCICIOS
    #folla1.txt
    #folla2.txt


mkdir C:\SISTEMAS | mkdir C:\DOS | mkdir C:\MANUAL| mkdir C:\EXERCICIOS

New-Item -Path C:\EXERCICIOS\manual.txt -ItemType File | New-Item -Path C:\EXERCICIOS\folla1.txt -ItemType File | New-Item -Path C:\EXERCICIOS\folla2.txt -ItemType File 