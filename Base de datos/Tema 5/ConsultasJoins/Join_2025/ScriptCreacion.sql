--Explicacion de los Join:
--Un join es la union de dos tablas por un campo comun.
--Una vez unidas asi las dos tablas podemos extraer la informacion que queramos de esta combinacion.

--BD Ejemplo:Join_2015

CReATE DATABASE a23marcos_BD_join_2025;
GO
USE a23marcos_BD_join_2025;

create table Empleado(
    apellido char(10), 
    iddepartamento char(2),
    primary key (apellido)
);

create table Departamento(
    iddepartamento char(2),
    NombreDepartamento char(10),
    primary key (iddepartamento)
);

insert into Empleado values ('Andrade',31);
insert into Empleado values('Jordan',33);
insert into Empleado values('Steinberg',33);
insert into Empleado values('Robinson',34);
insert into Empleado values('Zolano',34);
insert into Empleado values('Gaspar',36);


insert into Departamento values (31,'Ventas');
insert into Departamento values (33,'Ingenieria');
insert into Departamento values (34, 'Produccion');
insert into Departamento values (35, 'Mercadeo');


select * from Empleado;
select * from Departamento;

-- INNER JOIN: De la combinacion de las dos tablas solo se escogen aquellas 
--que cumplan la condicion del ON

-- Formato:    <table_source> INNER JOIN <table_source> ON <search_condition> 

--1.- Queremos saber a que departamento esta asignado cada empleado:

                  
--   Usando INNER Join     
        
    SELECT *
    FROM   empleado
    INNER JOIN departamento
    ON empleado.IDDepartamento = departamento.IDDepartamento;   
    
    
-- Usando solo from y where

    SELECT *
    FROM   empleado, departamento
    WHERE  empleado.IDDepartamento = departamento.IDDepartamento;    
    
            
          
--  El INNER  join solo nos muestra los conjuntos de datos que existan en las dos tablas.

    
-- Esta consulta toma todos los registros de la tabla Empleado y encuentra todas las combinaciones 
--en la tabla Departamento. La sentencia JOIN compara los valores en la columna IDDepartamento en ambas tablas. 
-- Cuando no existe correspondencia entre algunas combinaciones, �stas no se muestran; es decir que si el n�mero de
-- departamento de un empleado no coincide con los n�meros de departamento de la tabla Departamento, no se mostrar� el
-- empleado con su respectivo departamento en la tabla resultante y si hay algun departamento que no aparezca en 
--ningun empleado, este tampoco aparecera..



    
-- OUTER JOIN: Escoge los que pertenezcan a alguna de las tablas, aunque no tenga correspondiente.


--   a)LEFT OUTER JOIN o LEFT JOIN: Escoge todos los de la tabla de la izquierda.
-- 1.- Queremos saber los datos de todos los departamentos y los empleados que tiene asignados, aunque no tengan empleados.


    SELECT *
    FROM   departamento LEFT OUTER JOIN empleado
        ON empleado.IDDepartamento = departamento.IDDepartamento;
            
                        


---  b)RIGHT OUTER JOIN o RIGHT JOIN: Escoge todos los de la tabla de la derecha.
-- 1.- Queremos saber los datos de todos los empleados y los departamentos a que est�n asignados, aunque no tengan departamento.


    SELECT *
    FROM   
        departamento  RIGHT OUTER JOIN empleado
        ON empleado.IDDepartamento = departamento.IDDepartamento;



---  c) FULL OUTER JOIN: Escoge todos los de la derecha y los de la izquierda.

-- 1.- Queremos saber los datos de todos los departamentos y todos los empleados y su relaci�n.

    SELECT *  
    FROM   empleado
        FULL OUTER JOIN departamento 
        ON empleado.IDDepartamento = departamento.IDDepartamento;



-- La siguiente query obtendra el mismo resultado.
        
    
    SELECT *
    FROM   empleado
        LEFT JOIN departamento
        ON empleado.IDDepartamento = departamento.IDDepartamento
        
    UNION 

    SELECT *
    FROM   empleado
        RIGHT JOIN departamento
        ON empleado.IDDepartamento = departamento.IDDepartamento;

--  * Probar la diferencia con UNION ALL   
        
    
-- Cross Join 
--Presenta el producto cartesiano de las dos tablas:  


    SELECT *
    FROM   empleado CROSS JOIN departamento;


    SELECT *
    FROM   empleado, departamento;