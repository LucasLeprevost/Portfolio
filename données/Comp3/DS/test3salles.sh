#!/bin/sh

salles="727 729 731"

echo "Recherche des adresses IP des machines des salles : $salles..."

machines="00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30"

prefixe_ip="172.16.97"

# Boucle sur chaque salle
for salle in $salles
do
	echo "🚪 Salle $salle :"
	
	# Boucle sur chaque machine de la salle
	for m in $machines
	do
		# Génération du nom d'hôte
		host="c-di-$salle-$m"

		# Test de connectivité avec ping
		if ping -c 1 -w 1 $host >/dev/null 2>&1; then
			# Récupération de l'adresse IP avec getent hosts
			ip=$(getent hosts $host | awk '{print $1}')
			
			if [ -n "$ip" ]; then
				echo "Machine $host : IP : $ip"
			else
				echo "Machine $host : IP (supposée) : $prefixe_ip.$m"
			fi
		else
			echo "Machine $host n'est pas atteignable."
		fi
	done
	echo "" # Ajoute une ligne vide pour séparer les salles
done
