__alumno__ = "Marcos Chouza Cruces"

import os
import shutil

from os import system 

#Definimos unha función lambda para limpiar a terminal unha vez executamos o script
clear = lambda: os.system('clear')

clear()

while True:
    print("\nEscolle unha opción do menú: ")
    print("\t1 - Mostra o ID do usuario actual.")
    print("\t2 - Mostra o nome do sistema operativo actual.")
    print("\t3 - Crea un directorio 'directorio_os'.")
    print("\t4 - Sitúate no directorio 'directorio_os'.")
    print("\t5 - Mostra o directorio de traballo actual.")
    print("\t6 - Existe un directorio?")
    print("\t7 - Lista o contido de 'directorio_os' (rutas absolutas).")
    print("\t8 - Crea un ficheiro de texto 'archivo.txt'.")
    print("\t9 - Abre o ficheiro para escritura e engade o teu nome e apelidos.")
    print("\t10 - Mostra o contido do ficheiro 'archivo.txt'.")
    print("\t11 - Renomea o ficheiro 'archivo.txt' a 'archivo_nuevo.txt'.")
    print("\t12 - Crea dentro de 'directorio_os' a estrutura directorio_os1/directorio_os2 con unha soa instrucción.")
    print("\t13 - Borra a estrutura de directorios creada anteriormente utilizando unha soa instrucción.")
    print("\t14 - Sair.")
    
    option = int(input("> "))
    
    # Muestra el ID del usuario actual
    if option == 1:
        
        id = os.getlogin()
        print(f"\nEl ID del usuario actual es: {id}")
        
    # Muestra el nombre del sistema operativo actual
    elif option == 2:
        
        sistema = os.name
        print(f"\nEl sistema operativo utilizado es: {sistema}")
        
        
    # Crea un directorio "directorio_os" como subdirectorio del directorio del script
    elif option == 3:
        
        # Obtiene la ruta absoluta del directorio donde se encuentra el script
        directorio_script = os.path.dirname(os.path.abspath(__file__))
        
        # Define la ruta del subdirectorio a crear
        subdirectorio = os.path.join(directorio_script, "directorio_os")
        
        # Crea el subdirectorio si no existe
        if not os.path.exists(subdirectorio):
            os.mkdir(subdirectorio)
            print("Subdirectorio creado")
        else:
            print("El subdirectorio ya existe")


    # Sitúate en el directorio "directorio_os"
    elif option == 4:
        
        # Obtiene la ruta absoluta del directorio donde se encuentra el script
        directorio_script = os.path.dirname(os.path.abspath(__file__))
        
        # Define la ruta del subdirectorio "directorio_os"
        subdirectorio = os.path.join(directorio_script, "directorio_os")
        
        # Intenta cambiar al subdirectorio, si no existe, no lo crea
        if os.path.exists(subdirectorio):
            os.chdir(subdirectorio)
            print(f"Cambiado de directorio")
        else:
            print("No se pudo encontrar el directorio")

        
    # Muestra el directorio de trabajo actual
    elif option == 5:
        print(f"\nO directorio de traballo actual é: {os.getcwd()}")
        
        
    # Comprueba si un directorio existe o no
    elif option == 6:
        
        # Obtiene la ruta absoluta del directorio donde se encuentra el script
        directorio_script = os.path.dirname(os.path.abspath(__file__))
        
        # Solicita el nombre del directorio o fichero
        ruta = input("Introduce o nome do directorio ou ficheiro: ")
        
        # Crea la ruta completa combinando el directorio del script con el nombre del archivo/directorio
        ruta_completa = os.path.join(directorio_script, ruta)
        
        # Comprueba si la ruta existe
        if os.path.exists(ruta_completa):
            if os.path.isdir(ruta_completa):
                print("Existe, é un directorio.")
            elif os.path.isfile(ruta_completa):
                print("Existe, é un ficheiro.")
        else:
            print("Non existe.")


    # Lista el contenido de "directorio_os" utilizando rutas absolutas
    elif option == 7:
        
        directorio = '/home/sanclemente.local/a23marcoscc/Escritorio/1-Daw-2024-25/Sistemas/Tema 4/Python/directorio_os'

        if os.path.exists(directorio):  # Verifica si el directorio existe
            contido = os.listdir(directorio)  # Lista el contenido del directorio
            if contido:  # Si el directorio no está vacío
                print("Contido de 'directorio_os':")
                
                for elemento in contido:
                    # Muestra la ruta absoluta de cada elemento
                    print(os.path.abspath(os.path.join(directorio, elemento)))
            else:  # Si el directorio está vacío
                print("O directorio está baleiro.")
        else:  # Si el directorio no existe
            print("O directorio 'directorio_os' non existe.")

        
    # Crea un fichero de texto "archivo.txt"
    elif option == 8:
        
        ruta = '/home/sanclemente.local/a23marcoscc/Escritorio/1-Daw-2024-25/Sistemas/Tema 4/Python/directorio_os/arquivo.txt'

        # Obtener el directorio de la ruta
        directorio = os.path.dirname(ruta)

        # Crear el directorio si no existe
        if not os.path.exists(directorio):
            os.makedirs(directorio)

        # Ahora crear el archivo 'arquivo.txt'
        with open(ruta, 'w') as archivo:
            archivo.write("")

        print("Archivo creado ")

        
    # Abre al fichero para escritura y añade tu nombre y apellidos
    elif option == 9:
        
        ruta_archivo = '/home/sanclemente.local/a23marcoscc/Escritorio/1-Daw-2024-25/Sistemas/Tema 4/Python/directorio_os/arquivo.txt'
    
        # Crear el directorio si no existe
        directorio = os.path.dirname(ruta_archivo)
        if not os.path.exists(directorio):
            os.makedirs(directorio)

        # Pedir al usuario que ingrese su nombre y apellidos
        nombre = input("Introduce tu nombre: ")
        apellidos = input("Introduce tus apellidos: ")

        # Abrir el archivo en modo 'w' (escritura) para sobrescribirlo con los nuevos datos
        with open(ruta_archivo, 'w') as archivo:
            archivo.write(f"{nombre} {apellidos}\n")
        
        print("Añadidos nombre y apellidos")


    # Muestra el contenido del fichero "archivo.txt"
    elif option == 10:
        
        ruta_archivo = '/home/sanclemente.local/a23marcoscc/Escritorio/1-Daw-2024-25/Sistemas/Tema 4/Python/directorio_os/arquivo.txt'
    
        # Verificamos si el archivo existe
        if os.path.exists(ruta_archivo):
            # Abrir el archivo en modo lectura
            with open(ruta_archivo, 'r') as archivo:
                contenido = archivo.read()
                print("\nContenido del archivo 'arquivo.txt':")
                print(contenido)
        else:
            print("No existe")
        
        
    # Renombra el fichero "archivo.txt" a "archivo_nuevo.txt"
    elif option == 11:
        
        # Ruta completa al archivo "arquivo.txt"
        ruta_archivo = '/home/sanclemente.local/a23marcoscc/Escritorio/1-Daw-2024-25/Sistemas/Tema 4/Python/directorio_os/arquivo.txt'
        ruta_nueva = '/home/sanclemente.local/a23marcoscc/Escritorio/1-Daw-2024-25/Sistemas/Tema 4/Python/directorio_os/archivo_nuevo.txt'

        if os.path.exists(ruta_archivo):
            os.rename(ruta_archivo, ruta_nueva)
            print("Archivo renombrado a 'archivo_nuevo.txt'.")
        else:
            print("El archivo 'arquivo.txt' no existe.")


    # Crear la estructura de directorios 'directorio_os1/directorio_os2'
    elif option == 12:
        
        # Ruta base para la creación de directorios
        directorio_base = '/home/sanclemente.local/a23marcoscc/Escritorio/1-Daw-2024-25/Sistemas/Tema 4/Python/directorio_os/directorio_os1/directorio_os2'

        # Crear los directorios (si no existen)
        os.makedirs(directorio_base, exist_ok=True)
        print(f"Estructura creada: {directorio_base}")


    # Eliminar la estructura de directorios 'directorio_os1'
    elif option == 13:
        
        shutil.rmtree('/home/sanclemente.local/a23marcoscc/Escritorio/1-Daw-2024-25/Sistemas/Tema 4/Python/directorio_os/directorio_os1')
        print("Estructura de directorios eliminada.")


    # Salir
    elif option == 14:
        
        print("\nSaliendo...")
        break

    # Opción inválida
    else:
        print("\nError: Opción inválida.")
