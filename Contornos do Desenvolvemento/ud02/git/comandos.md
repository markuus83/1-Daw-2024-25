# Ejercicio 1: REPOSITORIO LOCAL

#### 1.
```Shell
1. Realizar un primer commit en el que añades dos ficheros .txt Uno con tu nombre y otro con el nombre actividades; por ejemplo (sabela.txt y actividades.txt). En el primero introduce una breve descripción de ti y en el segundo añade alguna de tus aficciones (leer, hacer deporte, etc.):

    $ nano marcos.txt
    $ nano actividades.txt
    $ git add .
```

#### 2.
```Shell
2. Realizar otro commit modificando el primer .txt añadiendo una nueva línea, comentando por qué estás en este ciclo:

    $ nano marcos.txt
    $ git add .
    $ git commit -m "Primeiro .txt modificado"
```

#### 3.
```Shell
3. Crear una carpeta con dos ficheros, todo desde linea de comados:

    $ mkdir Ejercicio1
    $ mv marcos.txt /Ejercicio1
    $ mv actividades.tct /Ejercicio1
```

#### 4.
```Shell
4. Realizar otro commit con las siguientes modificaciones:

    $ nano actividades.txt
    $ nano .gitignore 

(dende o nodo raíz do repositorio, dentro desde arquivo escribimos o nome da carpeta da que non queremos facer un seguimento)
```

#### 5.
```Shell
5. Realiza un checkout para volver a las primeras versiones de los ficheros .txt (el primer commit):

    $ git log

(Copiamos o id do commit que remeos restablecer, neste caso: 023960b8ef614ab880838211136995901566ba99)

    $ git checkout 023960b8ef614ab880838211136995901566ba99
    $ git push origin master
```

# Ejercicio 2: TRABAJANDO CON REPOSITORIOS LOCALES

#### 1.
```Shell
1. Crear un repositorio nuevo (todo desde línea de comandos) con el nombre pagina_web y muestra su contenido desde línea de comandos:

    $ mkdir Ejercicio2
    $ mkdir pagina_web
    $ more pagina_web
```

#### 2.
```Shell
2. Comprueba y explica el estado del repositorio: 

    $ git status

· Tenemos diferentes archivos que no se encuentran en el seguimeinto de git, los cuales son: ".gitignore" y "comandos.md"
```

#### 3.
```Shell
3. Crear un fichero index.html con el siguiente contenido:

    $ nano index.html
(Copiamos el contenido otorgado por el profesor)
```

#### 4.
```Shell
4. Realizar un commit con el mensaje "Primera página html":

    $ git add .
    $ git commit -m "Primera página html"
```

#### 5. 
```Shell
5. Muestra y explica el estado del repositorio:

    $ git status

· Que, al igual que antes, tenemos diferentes archivos los cuales se encuentran sin seguimiento, los cuales son: ".gitignore" y "comandos.md"
```

#### 6.
```Shell
6. Cambiar la página web para que muestre en un listado 3 ciudades que te gustaría visitar:

    $ nano index.html
```

#### 7.
```Shell
7. Hacer un commit de los cambios, con el mensaje “Añadidas 3 ciudades que visitar":
    $ git add .
    $ git commit -m "Añadidas 3 ciudades que visitar"
```

#### 8.
```Shell
8. Muestra el historial de commits del repositorio:

    $ git log
```

#### 9.
```Shell
9.Crea una carpeta por cada ciudad que hayas indicado en el listado anterior. Introduce dentro de cada carpeta un fichero index.html con información por cada ciudad:

    $ mkdir oslo
    $ cd oslo
    $ nano oslo.html
    $ cd .. 
    $ mkdir venecia
    $ cd venecia
    $ nano venecia.html
    $ cd ..
    $ mkdir bilbao
    $ cd bilbao
    $ nano bilbao.html
```

#### 10.

```Shell
10. Hacer un commit de los cambios, con el mensaje “Añadida información sobre las ciudades a visitar”:

    $ git add .
    $ git commit -m "Añadida información sobre las ciudades a visitar"
```

#### 11.
```Shell
11. Volver a mostrar el historial de cambios:

    $ git log
```

# Ejercicio 3: FUNDAMENTOS DE GIT 

#### 1.
```Shell
1. Crear un repositorio nuevo con el nombre libro y mostrar su contenido. Comprueba el estado del respositorio:

    $ mkdir libro
    $ more libro
```

#### 2.
```Shell
2. Crerar un fichero indice.txt con el siguiente contenido:

    $ nano indice.txt
```

#### 3. 
```Shell
3. Realizar un commit con el mensaje “Añadido índice del libro”:

    $ git add .
    $ git commit -m "Añadido índice del libro"

```
#### 4.
```Shell
4. Comprueba y explica el estado del repositorio:

    $ git status

Como de todas las veces que hicimos git add . no lo hicismo desde la misma carpeta, sino que no salimos de /ud02, seguimos teniendo los mismos archivos en no seguimiento.
```

#### 5. 
```Shell
5. Cambiar el índice.txt para que contenga lo siguiente:

    $ nano indice.txt
```

#### 6. 
```Shell
6. Hacer un commit de los cambios con el mensaje “Añadido 4: La bella y la bestia”. Comprueba el estado del repositorio.


    $ git add .
    $ git commit -m "Añadido 4: La bella y la bestia"
    $ git status
```

#### 7. 
```Shell
7. Muestra el historial del repositorio:

    $ git log
```

#### 8. 
```Shell
8. Crea la carpeta capítulos y dentro de ella el fichero capitulo2.txt con el siguiente texto:

    $ mkdir capitulos
    $ cd capitulos
    $ nano capitulo2.txt
```

#### 9. 
```Shell
9. Hacer un commit con el mensaje “Añadido capitulo 2”:

    $ git add .
    $ git commit -m "Añadido capitulo 2"
```

#### 10. 
```Shell
10. Volver a mostrar historial de cambios:

    $ git log
```

#### 11. 
```Shell
11. Crear el fichero capitulo3.txt en la carpeta capitulos con el sigueinte texto:

    $ nano capitulo3.txt
```

#### 12.
```Shell
12. Ver el estado del repositorio de forma abreviada e indicar qué significa cada letra.


    $
```

#### 13.
```Shell
13. Modificar el índice.txt añadiendo “Capitulo 5: Frozen"

    $ cd ..
    $ nano indice.txt
```

#### 14.
```Shell
14. Subir los cambios al repositorio ingorando el capitulo3.txt:

· Nos dirigimos al archivo .gitignore del nodo raíz y escribimos el nombre del archivo que no queremos que tenga seguimiento, en este caso: "capitulo3.txt"

    $ git add .
    $ git commit -m "Ignorado archivo capitulo3.txt"
    $ 
```

#### 15.
```Shell
15. Modificar el fichero para que se ignoren todos aquellos ficheros que comiencen por _ a excepción del fichero _ayuda.txt (ya no se debe ignorar capitulo3.txt):

    · Escribimos "_*" y "!_ayuda.txt"
```

#### 16.
```Shell
16. Crear un fichero _logs.txt con el siguiente contenido:

    $ nano _logs.txt
```

#### 17.
```Shell
17. Crear un fichero _ayuda.txt con el siguiente contenido:

    $ nano _ayuda.txt
```

#### 18.
```Shell
18. Preparar todo con git add *. Explicad qué pasa:

    $ git add *
```

#### 19.
```Shell
19: Hacer un commit de los cambios con el mensaje “Añadido capitulo 2”. Comprobar/explicar qué se sube al repositorio:

    $ git commit -m "Añadido capítulo 2"

    · A diferencia de "git add ." "git add *" no sube los archivos ignorados por el shell, es decir, solamente sube archivos o directorios visibles.
```

#### 20.
```Shell
20. Modificar el fichero capitulo2.txt (elimina lo que había antes):

    · Nos posicionamos en el directorio /capitulos

    $ nano capitulo2.txt
```

#### 21.
```Shell
21. Ver y explicar qué ha cambiado y aún no has preparado:

    $
```

#### 22.
```Shell
22. Hacer un commit con el mensaje “Capitulo 2 modificado”:

    $ git add .
    $ git commit -m “Capitulo 2 modificado"
```

#### 23.
```Shell
23. Vuelve a modificar el capitulo con el siguiente contenido:

    $ nano capitulo2.txt
```

#### 24.
```Shell
24. Prepara tus cambios y comprueba qué ha cambiado con la última instantánea confirmada:

    $ git add .
    $ git status
```

#### 25.
```Shell
25. Elimina del repositorio el fichero _ayuda.txt:

    $ rm _ayuda.txt
```

#### 26.
```Shell
26. Cambia el nombre del fichero indice.txt por indice_libros.txt y sube los cambios:

    $ mv indice.txt indice_libros.txt
```

#### 27.
```Shell
27. Cambia el mensaje del último commit:

    $ git commit --amend -m "Mensaje del commit cambiado"

```


# Ejercicio 4: RAMAS GIT

#### 1.
```Shell
1. Crea una nueva rama bibliografia y muestra las ramas del repositorio:

    $ git branch bibliografia
    $ git branch
```

#### 2.
```Shell
2. Cambia a la rama bibliografía y crea el fichero bibliografia.txt y añade la siguiente referencia:

    $ git checkout bibliografia
    $ echo >> "bibliografia.txt" caperucita roja,  Trina Schart Hyman, Charles Perrault
```

#### 3.
```Shell
3. Comitea los cambios con el mensaje “Añadida primera referencia bibliográfica:

    $ git add .
    $ git commit -m "Añadida primera referencia bibliográfica"

```

#### 4.
```Shell
4. Fusiona la rama bibliografía con la rama master y eliminar la rama bibliografía:

    $ git checkout master
    $ git merge bibliografia
    $ git branch -D bibliografia

```

#### 5.
```Shell
5. Crea la rama harrypotter. En esta rama modifica elfichero bibliografia.txt para que contenga las siguiente referencias:

    $ git branch harrypotter
    $ git checkout harrypotter
    $ nano bibliografia.txt

```

#### 6.
```Shell
6. Commitea los cambios con el mensaje "Añadida bibliografia de harry potter"

    $ git add .
    $ git commit -m "Añadida bibliografia de harry potter"
```

#### 7.
```Shell
7. En la rama master modifica el fichero bibliografía.txt y añade la siguiente línea:

    $ git checkout master
    $ nano bibliografia.txt

```

#### 8.
```Shell
8. Fusiona la rama harrypotter con la rama master. Resuelve el conflicto y comitea los cambios

    $ git checkout master
    $ nano bibliografia.txt

```


# Ejercicio 5: REPOSITORIOS REMOTOS GIT

#### 1.
```Shell
1. Crea un repositorio en GitHub con el nombre libro-git. Añadelo como url remota en nuestro repositorio local de libro creado en el ejercicio anterior:

    $ git clone git@github.com:markuus83/Libro-git.git

```

#### 2.
```Shell
2. Añade todo lo que tenemos del repositorio libro al repositorio remoto y comprueba que los cambios están subidos correctamente: 

    · Copiamos los contenidos mediante la interfaz gráfica
    $ git add .
    $ git commit -m "Creado repositorio"
    $ git push origin main

```

#### 3.
```Shell
3. Colabora en el repositorio remoto de otro compañero. Clona su repositorio. Añade el fichero autores.txt que contenga tu nombre y tu correo electrónico. Haz un commit y sube los cambios al repositorio remoto de tu compañero:

    $ git clone https://github.com/Chris-VD/libro-git.git
```

#### 4.
```Shell
4. Cuando un compañero/a haya realizado el paso anterior en tu repositorio remoto, sincroniza tu repositorio en local. El resultado debe ser que en local debes tener ese fichero autores.txt:

    $ git clone
```

#### 5.
```Shell
5. Modifica ese fichero, cambiando el nombre de tu compañero/a por el tuyo y añadiendo la fecha y la hora donde lo realizas. Sube los cambios al repositorio remoto:

    $ nano autores.txt 
    $ git add autores.txt
    $ git commit -m "Nome Marcos"
    $ git push origin master
```

# Ejercicio 5: REPOSITORIOS REMOTOS GIT

#### 1.
```Shell
1. Crea una nueva rama llamada autoria y cambiate a ella.

    $ git branch autoria

    $ git checkout autoria
```

#### 2.
```Shell
2. Añadir el nombre del usuario y su correo al fichero autores.txt

    $ nano autores.txt
```

#### 3.
```Shell
3. Hacer un commit con el mensaje

    $ git add autores.txt
    $ git commit -m "Rama Remota"
```

#### 4.
```Shell
4. Subir los cambios de la rama autoria al repositorio remoto en GitHub.

    $ git push origin autoria
```