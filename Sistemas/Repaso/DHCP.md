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
