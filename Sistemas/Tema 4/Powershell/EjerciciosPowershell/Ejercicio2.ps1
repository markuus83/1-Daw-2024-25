#Lista os directorios ou arquivos que hai en Windows/System32 e que o seu nome comece por w.

Get-ChildItem -Path "C:\Windows\System32" -File -Recurse -Include w*