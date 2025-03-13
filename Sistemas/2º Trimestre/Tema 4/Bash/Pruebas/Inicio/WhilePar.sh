#!/bin/bash
clear
i=1
while ((i <= 25))
do
	if ((i%2==0))
	then
		echo $i
	fi
	((i++))
done
