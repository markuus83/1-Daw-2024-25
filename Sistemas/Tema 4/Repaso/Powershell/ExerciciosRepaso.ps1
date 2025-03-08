<# Lista os directorios ou arquivos que hai en Windows/System32 e que o seu nome comece por w #>

    ls -Path "C:Windows/System32"

<# Fai a seguinte estructura de directorios e arquivos: 

    C:
        SISTEMAS
        DOS
        MANUAL
            manual.txt
        EXERCICIOS
            folla1.txt
            folla2.txt
#>

    New-Item -Path "C:/SISTEMAS" -ItemType Directory
    New-Item -Path "C:/DOS" -ItemType Directory
    New-Item -Path "C:/MANUAL" -ItemType Directory
    New-Item -Path "C:/EXERCICIOS" -ItemType Directory


    New-Item -Path "C:/Manual/manual.txt"
    New-Item -Path "C:/EXERCICIOS/folla1.txt"
    New-Item -Path "C:/EXERCICIOS/folla2.txt"


<# Copia todos os ficheiros do directorio EXERCICIOS a C cunha soa orde. #>

    New-Item -ItemType Directory -Path "C:/C"
    

    Copy-Item -Path "C:\EXERCICIOS/*" -Destination "C:/C"


<# Crea un subdirectorio en C que se chame PRACTICA 2 e copia o ficheiro LABEL.EXE do subdirectorio SYSTEM32 de WINDOWS  en PRACTICA2 pero co nome ETIQUETA.EXE. Podes utilizar dous comandos #>


    New-Item -Path "C:\PRACTICA\C\PRACTICA 2" -ItemType Directory ; Copy-Item -Path  "C:\Windows\System32\label.exe" -Destination "C:\PRACTICA\C\PRACTICA 2"

    Rename-Item -Path "C:\PRACTICA\C\PRACTICA 2\label.exe" -NewName etiqueta.exe


<# Copia todos os ficheiros do directorio EXERCICIOS a PRACTICA2 cunha soa orde. #>


    Copy-Item "C:\PRACTICA\EXERCICIOS\*" -Destination "C:\PRACTICA\C\PRACTICA 2"



<# Copia todos os ficheiros do directorio PRACTICA2 que teñen extensión txt no directorio DOS pero coa extensión sol.
 Fai cunha soa otrde o listado -> renomeado, a copia podes facela a parte. #>

    Copy-Item -Path "C:\PRACTICA\C\PRACTICA 2\*.txt" -Destination "C:\PRACTICA\DOS"
    
    Rename-Item -Path "C:\PRACTICA\DOS\" -NewName { $_.BaseName + ".sol" }


<# Con ruta absoluta renomea o ficheiro folla1.sol que se atopa en DOS como folla.dat #>

    
    Rename-Item -Path "C:\PRACTICA\DOS\folla1.sol" -NewName "folla.dat"




<# Copia todo o directorio Sistemas noutro directorio chamado CopySist cunha soa orde. #>


    Copy-Item -Path "C:\PRACTICA\" -Recurse -Destination "C:\CopySist" | New-Item -Path "C:\CopySist" -ItemType Directory

<# Ubícate na túa carpeta de usuario con ruta absoluta. #>

    
    <# Solucion 2 #>
    Set-Location -Path "C:\Users\marcos"

    
    <# Solucion 2 #>
    $yo = USERNAME

    Set-Location -Path "C:\Users\$yo"



<# Utilizando ruta relativa borra o directorio CopySist #>

        Set-Location -Path "C:\" ; Remove-Item "CopySist" -Recurse




<# Pon atributo oculto ao arquivo folla.dat que hai no directorio DOS. Tes que facer algo especial para listar dito arquivo oculto?#>


    Set-ItemProperty -Path "C:\PRACTICA\DOS\folla.dat" -Name "Attributes" -Value "Normal"



<# Cambia ao directorio DOS e, utilizando direccionamiento (>), crea un arquivo novo chamado folla.txt #>

    
    <# Solución 1 #>

        Set-Location -Path "C:\PRACTICA\DOS"  
    
        "Miau Miau" > folla.txt


    <#Solución 2 #>

        " Miau Miau " > "C:\PRACTICA\DOS\folla2.txt"




<# Amosa por pantalla o contido de folla.dat e folla.txt (2 comandos). #>


    cat folla.txt

    Get-Content folla.txt

    more folla.txt


<# Engade o contido de folla.txt a folla.dat sen borrar o que hai en folla.dat. #>


    Get-Content -Path "C:\PRACTICA\DOS\folla.txt" >> folla.dat



<# Crea 3 grupos (SI, BBDD e LMSXI). Inclúe ditos comandos e saca unha captura co resultado (comandol usrmgr.msc). Crea despois 2 usuarios en cada grupo, non fai falla que teñan contrasinal. Ningún usuario será administrador. Terás que crear ditos grupos e usuarios, nomeándoos coa inicial do nome e o primeiro apelido, por exemplo: Michael Jordan sería mjordan.O mesmo: inclúe os comandos e amosa capturas cos resultados #>

    New-LocalGroup -Name "SI"
    New-LocalGroup -Name "BBDD"
    New-LocalGroup -Name "LMSXI"

    New-LocalUser -NoPassword -Name "achouza"
    New-LocalUser -NoPassword -Name "bchouza"

    New-LocalUser -NoPassword -Name "cchouza"
    New-LocalUser -NoPassword -Name "dchouza"

    New-LocalUser -NoPassword -Name "echouza"
    New-LocalUser -NoPassword -Name "fchouza"

    Add-LocalGroupMember -Group "SI" -Member "achouza"
    Add-LocalGroupMember -Group "SI" -Member "bchouza"

    Add-LocalGroupMember -Group "BBDD" -Member "cchouza"
    Add-LocalGroupMember -Group "BBDD" -Member "dchouza"

    Add-LocalGroupMember -Group "LMSXI" -Member "echouza"
    Add-LocalGroupMember -Group "LMSXI" -Member "fchouza"