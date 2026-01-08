/** SAE 1.02
  * date   : le 22/11/2024
  * auteur : Lucas Leprevost
  */
  
import iut.algo.Clavier;

public class HorlogeSeconde
{
    public static void main(String[] args) 
    {
        final int SECONDES_PAR_JOUR = 86400; // 24 heures * 3600 secondes
        final int ITERATIONS = 1000; // Nombre de jours à simuler
        int totalSecondes = 0;

        long debut = System.nanoTime();

        for (int i = 0; i < SECONDES_PAR_JOUR * ITERATIONS; i++) 
        {
            totalSecondes++;
            if (totalSecondes == SECONDES_PAR_JOUR) 
            {
                totalSecondes = 0; // Retour à minuit
            }
        }

        long fin = System.nanoTime();
        System.out.println("Durée avec stockage en secondes : " + (fin - debut) / 1000000 + "ms");
    }
}
