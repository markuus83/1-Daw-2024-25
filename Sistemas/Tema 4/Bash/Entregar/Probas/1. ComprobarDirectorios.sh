clear
#!/bin/bash
comprobar_directorio(){
	read -p "Ingrese o nome dun directorio: " directorio

	if [ -d "$directorio" ];then
		echo "É un directorio."
	else
		echo "Non é un directorio."
	
	fi
}

comprobar_directorio