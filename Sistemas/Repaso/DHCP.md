# 1. DHCP
```Shell
DHCP (Dynamic Host Configure Protocol) es un software que sirve para la asiganción automática de ip en una subred previamente definida.
```

## 2. DHCP Debian Server 
#### a) Pasos a seguir
```Shell
Primeiro, teremos de instalar o paquete no que se atopa o software que imos utilizar: 

    $ apt-get install isc-dhcp-server
```

```Shell
Facemos unha copia do ficheiro a modificar, para evitar a perda de información sensible, a ruta é: 

    $ /etc/dhcp/dhcpd.conf
```

```Shell
Modificamos o ficheiro, e declaramos o rango de redes e a red no cla queremos repartir IPs:

subnet 192.268.5.0 netmask 255.255.255.0 {
    range 192.168.5.100 192.168.5.110; 
}
```

```Shell
Unha vez feito, iremos ao seguinte arquivo: 

    $ nano /etc/default/isc-dhdcp-server

Ahí dentro, na variable 'INTERFACESv4' escribimos o nome da nosa red -> 'enp0s3'
```

```Shell
Posteriormente, só deberemos de observar o status e arrincar o servizo DHCP:

    $ systemctl status isc-dhcp-server.service

    $ systemctl start isc-dhcp-server.service
```

```Shell
Aínda que pareza unha obviedade, ao ingresar un novo equipo ao servizo, deberemos de poñer en AUTOMÁTICO a asignación de IP.
```

## 3. Reservas de MAC
```Shell
Dentro del servicio DHCP, cando queremos que un equipo da nosa rede teña sempre a mesma IP, deberemos de especificarllo ao noso servidor.

Para poder facelo, deberemos de 'parametrizar' o dirección MAD de dito equipo e asignarlle a IP correspondente desexada.

Para iso, temos de modificar o ficheiro:

    $ /etc/dhcp/dhcpd.conf
```

```Shell
Unha vez metidos dentro do ficheiro, teremos de escribir as seguintes liñas de código: 

    host 'nome do Host' {

        hardware ethernet 'dirección MAC do nodo a engadir'
        fixed-address 'dirección IP dentro do rango da nosa subrede'
    }
```
<<<<<<< HEAD
## 4. SSH
```Shell
            $ scp -P 2345 -p ladmin@127.0.0.1:/home/ladmin/Proba2.txt .

scp → software a utilizar

“-P” (Maiúscula) → Porto da de entrada da máquina real.

“-p” (Minúsxula) → Permisos do equipo copiado.

“ ladmin@127.0.0.1” →Login da máquina virtual.

“/home/ladmin/Proba2.txt” → Dirección do arquivo na máquina virtual.

“.” → Destino na máuina real onde se vai copiar. O punto significa que se vai copiar no directorio no se que se executa o comando.
```
=======
>>>>>>> bfc772d9c2759a831e74e385350e7a2d52e0dd37
