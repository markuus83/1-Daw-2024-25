""" 
Escribe un script que faga o cambio de divisas tanto de euros a libras e viceversa. Crea un menú para que o usuario escolla o cambio que desexa realizar e 
a continuación introducirá o valor da moeda correspondente para realizar o cambio de divisas. 1 € son 1,10 libras.
"""

__author__ = "Marcos Chouza Cruces"

#Pedimoslle ao usuario que prema a opcion desexada
print("\nPrema a opción desexada no menú")
print("\ta) Converter de Euros (€) a Libras(£) ")
print("\tb) Converter de Libras (£) a Euros(€) ")

#Establecemos a opción que queremos utilizar
option = input(">")

#O primeiro 'IF' consta das operacións de cálculo de conversión de euros a libras, e amosa o resultado por pantalla
if option == 'a':
    cantidade = float(input("Ingrese a cantidade en euros que quere converter: "))
    conversion = cantidade * 1.1
    print(cantidade, "€ son", conversion, "£")
    
    
#O segundo 'IF' consta das operacións de cálculo de conversión de libras a euros, e amosa o resultado por pantalla.




elif option== 'b':
    cantidade = float(input("Ingrese a cantidade en libras que quere converter:"))
    conversion = cantidade / 1.1
    print(cantidade, "£ son", conversion, "€")

    

#O último if encárgase de amosar posibles erros do código
else:
    print("Error")