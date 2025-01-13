#!/bin/bash
clear
for ((i=0;i<=25;i++))
do
	if ((i%2==0))
	then
		echo $i
	fi
	((i++))
done
