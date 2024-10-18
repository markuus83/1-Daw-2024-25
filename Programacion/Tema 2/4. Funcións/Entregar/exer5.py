""" 
Escribe un script que faga o cambio de divisas tanto de euros a libras e viceversa. Crea un mení para que o usuario escolla o cambio que desexa realizar. Realiza unha función para un dos cambios:

    · libras_to_euros (libras: float) -> float
    · euros_to_libras  (euros: float) -> float
    
Un € é igual a 1,10 libras
"""
__author__ = "Marcos Chouza Cruces"

def libras_to_euros(option) -> float:
    cantidade = float(input("Ingrese a cantidade en euros que quere converter: "))
    conversion = cantidade * 1.1
    print(cantidade, "€ son", conversion, "£")
    return


def euros_to_libras(option) -> float:
    cantidade = float(input("Ingrese a cantidade en libras que quere converter:"))
    conversion = cantidade / 1.1
    print(cantidade, "£ son", conversion, "€")
    return


print("\nPrema a opción desexada no menú")
print("\ta) Converter de Euros (€) a Libras(£) ")
print("\tb) Converter de Libras (£) a Euros(€) ")

#Establecemos a opción que queremos utilizar
option = input(">")

#O primeiro 'IF' consta das operacións de cálculo de conversión de euros a libras, e amosa o resultado por pantalla
if option == 'a':
    libras_to_euros(option)
    
    
#O segundo 'IF' consta das operacións de cálculo de conversión de libras a euros, e amosa o resultado por pantalla.
elif option== 'b':
    euros_to_libras(option)


#O último if encárgase de amosar posibles erros do código
else:
    print("Error")