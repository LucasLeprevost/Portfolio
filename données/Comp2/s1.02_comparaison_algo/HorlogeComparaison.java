/** SAE 1.02
  * date   : le 22/11/2024
  * auteur : Lucas Leprevost
 */

public class HorlogeComparaison {
    public static void main(String[] args) {
        final int SECONDE_MAX = 86400; // Total secondes dans une journée
        long debut, fin, tempsExecution1, tempsExecution2;

        /*--------------*/
        /* Méthode 1 : Heures, Minutes, Secondes */
        /*--------------*/
        int h, m, s;
        debut = System.nanoTime();

        h = m = s = 0;
        for (int i = 0; i < SECONDE_MAX; i++) {
            s++;
            if (s == 60) {
                s = 0;
                m++;
                if (m == 60) {
                    m = 0;
                    h++;
                    if (h == 24) {
                        h = 0; // Retour à minuit
                    }
                }
            }
        }

        fin = System.nanoTime();
        tempsExecution1 = fin - debut;

        /*--------------*/
        /* Méthode 2 : Total en secondes */
        /*--------------*/
        int tempsEnSecondes = 0;
        debut = System.nanoTime();

        for (int i = 0; i < SECONDE_MAX; i++) {
            tempsEnSecondes++;
        }

        fin = System.nanoTime();
        tempsExecution2 = fin - debut;

        /*--------------*/
        /* Affichage des résultats */
        /*--------------*/
        System.out.println("Temps d'exécution (Heures/Minutes/Secondes) : " + tempsExecution1 / 1_000_000 + " ms");
        System.out.println("Temps d'exécution (Total Secondes) : " + tempsExecution2 / 1_000_000 + " ms");
    }
}
