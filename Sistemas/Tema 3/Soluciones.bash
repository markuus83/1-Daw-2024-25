#5.Crea una variable de entorno local denominada ALUMNO que tenga como contenido tu nombre y apellidos. Después muéstrala por pantalla. (1 punto)

$ alumno="Marcos Chouza Cruces"
$ echo $alumno


#6.Introduce, haciéndolo en una sola línea y sin usar editores, dicha variable en el archivo (examen1/alumno.txt). (1 punto)

$ mkdir examen1

$ echo $alumno > examen1/alumno.txt

#7.Muestra el contenido de alumno txt por pantalla sin usar editores. Usa dos comandos diferentes. (1 punto)

$ cat alumno.txt
$ more alumno.txt

#18.Queremos buscar en todos los directorios el archivo alumno.txt desde la raíz del sistema y que se muestre la ruta completa por pantalla. (1 punto)

$ su 
$ find / -name alumno.txt

#19.Manda la salida del comando anterior a un archivo denominado encontrado.txt. Hazlo segundo plano. (1 punto)

$ echo find / -name alumno.txt > encontrado.txt

#20 Indica el comando para ver si el proceso del anterior punto se está ejecutande, (1 punto)

$ jobs

#21.Crea un usuario denominado u-exame. Solo puedes utilizar useradd, Tienes que crearlo con todas las opciones/parámetros posibles (el directorio personal será /home/u-exame y el shell BASH). (1 punto)

$ useradd -m -s /bin/bash u_exame

#22.Crea un grupo denominado g-exame y haz que el grupo principal de u-exame sea g- exame. Puedes hacerlo en 2 veces, primero la creación y después la asignación. (1 punto)



#23. Establece los permisos para el archivo alumno.txt de forma que el propietario tenga el control total, el grupo lectura y escritura e el resto solo lectura. Hazlo con notación simbólica (caracteres) y con notación octal (números). (1 punto)

$ chmod 766 alumno.txt

#24. Cambia el propietario de alumno.txt para que sea propiedad de u-exame y de su grupo principal. (1 punto)






"""
Localiza un fichero desde la raíz
find / -type f -name “nombrearchivo” 2>/dev/null
-Redirige la salida anterior a otro documento en segundo plano
> archivo.txt &
-Indica el comando para ver si el proceso sigue ejecutándose
jobs
-Crea un usuario con directorio y shell
useradd -m -s /bin/bash u_exame
-Cambia el grupo principal del usuario
usermod -g g-exame u-exame
G grupo secundario g grupo principal
-Cambia los permisos
chmod u=rwx, g=rw, o=r ejemplo.txt
chmod 764 ejemplo.txt
-Cambiar el propietario y el grupo principal
chown propietario:grupo archivo
-Crear variable 
variable=”variable”
-Mostrar la variable 
echo $variable
-Pasar la variable a un archivo
echo $variable > archivo
-Mostrar el contenido de un fichero por pantalla
cat archivo
more archivo
"""