"""
Escribe un script que lea un número por teclado e deduza se está entre 10 e 100 (ambos inclusive). 
Se é así mostra por pantalla <Está no intervalo> e senón <Non está no intervalo>
"""

__author__ = "Marcos Chouza Cruces"

num = int(input("Ingrese un número: "))

if num >= 10 <= 100:
    print("Está no intervalo")
else:
    print("Non está no intervalo.")