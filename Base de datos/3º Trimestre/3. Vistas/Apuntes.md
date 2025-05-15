# APUNTES VISTAS: 

### 1. ¿Que es una vista? 
```Shell
    Una VISTA es una tabla cuyo contenido está definido por una consulta. No obstante, y a menos de que esté indizada, una vista no existe como un conjunto de valores de datos almacenados.
```

```Shell
    Una vez la VISTA se encuentre creada, esta actúa como una tabla para cualquier declaración SELECT
```
```Shell
    A la hora de ejecutar la isntrucción, el gestor da error de compilación si tenemos alguna sentencia a mayores a parte de la creación de dicha vista 
```

### 2. MODIFICAR DATOS EN UNA VISTA
#### a) Inserción
```Shell
    Si tenemos una vista creada, siempre podremos insertar datos.

    En el caso de que la inserción no cumpla con la condición de creación de la vista, dicho ingreso no aparecerá en la vista pero sí que lo hará en la tabla a la cual la vista hace referencia
```
#### b) Eliminar
```Shell
    Si eliminamos los datos de la vista, repercute únicamente en la vista.

    No obstante, si borramos los datos de la tabla a la cual hacen referencia, también desaparecerán de la vista.
```
### 3. MODIFICAR DATOS CON CHECK-OPTION
```Shell
    A la hora de ingresar los datos, si la vista fue creada con la cláusula 'WITH CHECK OPTION', los nuevos ingresos solamente aparecerán en la tabla a la cual hacen referencia si cumplen con las especificaciones de la vista.

    Cuando se quieren eliminar los datos, la clausula 'WITH CHECK OPTION' actúa de la misma manera.
```
### 4. A TENER EN CUENTA
```Shell
    Las especificaciones de una tabla no migran de forma automática a una vista aunque se haga referencia a ella.

    Es decir, todos los campos de la nueva vista serán 'NULL' por defecto, a no ser que se lo especifiquemos explícitamente.
```