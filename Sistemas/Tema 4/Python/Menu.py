import os

while True:
    print("\nEscolle unha opción do menú: ")
    print("\t1 - Mostra o ID do usuario actual.")
    print("\t2 - Mostra o nome do sistema operativo actual.")
    print("\t3 - Crea un directorio 'directorio_os'. ")
    print("\t4 - Sitúate no directorio 'directorio_os'.")
    print("\t5 - Mostra o directorio de traballo actual.")
    print("\t6 - Existe un directorio?")
    print("\t7 - Lista o contido de 'directorio_os' (rutas absolutas).")
    print("\t8 - Crea un ficheiro de texto 'archivo.txt'")
    print("\t9 - Abre o ficheiro para escritura e engade o teu nome e apelidos")
    print("\t10 - Mostra o contido do ficheiro 'archivo.txt'.")
    print("\t11 - Renomeoa o ficheiro 'archivo.txt' a 'archivo_nuevo.txt'.")
    print("\t12 - Crea dentro de 'directorio_os' la seguinte estructura de directorios directorio_os1/directorio_os2 con una sola instrucción")
    print("\t13 - Borra a estrutura de directorios creada anteriorementeutilizando unha soa instrucción.")
    print("\t14 - Sair.")
    
    
    option = int(input(">"))
    
    if option == 1:
        id = os.getlogin()
        print(f"\nEl ID del usuario actual es: {id}")
        
    elif option == 2:
        sistema = os.name
        print(f"\nEl sistema operativo utilizado es: {sistema}")
        
    elif option == 3:
        
        directorio = './directorio_os'
        
        if not os.path.exists(directorio):
            os.mkdir(directorio)
            print("Directorio creado.")
        else:
            print("El directorio ya existe")
        
    elif option == 4:
        print(f"\n")
        
    elif option == 5:
        print(f"\n")
        
    elif option == 6:
        print(f"\n")
        
    elif option == 7:
        print(f"\n")
        
    elif option == 8:
        print(f"\n")
        
    elif option == 9:
        print(f"\n")
        
    elif option == 10:
        print(f"\n")
        
    elif option == 11:
        print(f"\n")
        
    elif option == 12:
        print(f"\n")
        
    elif option == 13:
        print(f"\n")
        
    elif option == 14:
        print("\nSaíndo...")
        break
    else:
        print("\nErro: Opción inválida")