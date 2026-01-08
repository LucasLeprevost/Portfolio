#!/bin/sh

# Vérifie si un numéro de salle est fourni en argument
if [ -z "$1" ]; then
	echo "Usage: $0 <numéro_salle>"
	exit 1
fi

# Récupère le numéro de la salle
salle=$1

# Affiche le nom de la salle
echo "Recherche des adresses IP des machines de la salle $salle..."


machines="00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30"

# Récupération du préfixe réseau (ex: 172.16.97)
prefixe_ip="172.16.97"

# Boucle sur chaque machine
for m in $machines
do
	# Génère le nom d'hôte
	host="c-di-$salle-$m"

	# Ping pour voir si la machine est en ligne
	if ping -c 1 -w 1 $host >/dev/null 2>&1; then
		# Trouve l'adresse IP de la machine avec getent hosts
		ip=$(getent hosts $host | awk '{print $1}')
		
		if [ -n "$ip" ]; then
			echo " Machine $host → IP : $ip"
		else
			echo " Machine $host → IP (supposée) : $prefixe_ip.$m"
		fi
	else
		echo " Machine $host n'est pas atteignable."
	fi
done
