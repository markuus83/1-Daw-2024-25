#Crea 3 grupos (SI, BBDD e LMSXI). Inclúe ditos comandos e saca unha captura co resultado (comandol usrmgr.msc). Crea despois 2 usuarios en cada grupo, non fai falla que teñan contrasinal. Ningún usuario será administrador. Terás que crear ditos grupos e usuarios, nomeándoos coa inicial do nome e o primeiro apelido, por exemplo: Michael Jordan sería mjordan.O mesmo: inclúe os comandos e amosa capturas cos resultados

New-LocalGroup -Name "SI" -Description "Grupo para SI"
New-LocalGroup -Name "BBDD" -Description "Grupo para BBDD"
New-LocalGroup -Name "LMSXI" -Description "Grupo para LMSXI"

# Usuarios para o grupo SI
New-LocalUser -Name "mjordan" -FullName "Michael Jordan" -PasswordNeverExpires $true -UserMayNotChangePassword $true
New-LocalUser -Name "llebron" -FullName "LeBron James" -PasswordNeverExpires $true -UserMayNotChangePassword $true
Add-LocalGroupMember -Group "SI" -Member "mjordan", "llebron"

# Usuarios para o grupo BBDD
New-LocalUser -Name "smiller" -FullName "Marcos Chouza" -PasswordNeverExpires $true -UserMayNotChangePassword $true
New-LocalUser -Name "dsmith" -FullName "Pepito Pepe" -PasswordNeverExpires $true -UserMayNotChangePassword $true
Add-LocalGroupMember -Group "BBDD" -Member "mchouza", "ppepe"

# Usuarios para o grupo LMSXI
New-LocalUser -Name "tparker" -FullName "Peter Parker" -PasswordNeverExpires $true -UserMayNotChangePassword $true
New-LocalUser -Name "kgarnett" -FullName "Christian Varela" -PasswordNeverExpires $true -UserMayNotChangePassword $true
Add-LocalGroupMember -Group "LMSXI" -Member "pparker", "Cvarela"

Get-LocalGroup

Get-LocalGroupMember -Group "SI"
Get-LocalGroupMember -Group "BBDD"
Get-LocalGroupMember -Group "LMSXI"
