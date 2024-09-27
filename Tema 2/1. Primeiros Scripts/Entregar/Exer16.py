"""
Escribe un script que pida ao usuario o seu nome e apelidos por separado e mostra a seguinte mensaxe por pantalla:
O usuario <apelido1> <apelido2>, <nome> rexistrouse correctamente
"""

__author__ = "Marcos Chouza Cruces"

#Pedimos que ingrese datos por teclado
nome = input("Escriba o seu nome: ")
ape1 = input("Escriba o seu primeiro apelido: ")
ape2 = input("Escriba o seu primeiro apelido: ")

#Imprimimos os datos seguindo a secuencia ordenada
print("O usuario", ape1,  ape2 + ",", nome, "rexistrouse correctamente")

