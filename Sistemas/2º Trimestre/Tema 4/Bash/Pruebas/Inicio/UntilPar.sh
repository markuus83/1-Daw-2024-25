#!/bin/bash
clear
i=0
until ((i>=25))
do
	if ((i%2==0))
	then
		echo $i
	fi
	((i++))
done
