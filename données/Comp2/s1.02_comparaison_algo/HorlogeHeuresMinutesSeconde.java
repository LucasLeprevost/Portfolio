/** SAE 1.02
  * date   : le 22/11/2024
  * auteur : Lucas Leprevost
  */
  
import iut.algo.Clavier;

public class HorlogeHeuresMinutesSeconde
{
	public static void main (String [] args )
	{
		/*--------------*/
		/* Données      */
		/*--------------*/
        final int SECONDE = 86400000;

		int h ;
        int m;
        int s;
        int cpt;

        long debut;
        long fin;
        long tempsExecution;

		/*--------------*/
		/* Instructions */
		/*--------------*/
        
        debut = System.nanoTime();

        m = h = s = 0;

        cpt = 0;
        while ( cpt < SECONDE )
        {       
            if (s  == 60 )
            {
                m++;

                s = 0 ;

                if ( m == 60 ) 
                {   
                    h++;
                    m = 0;

                    if ( h == 24 )
                    {
                            h = 0; // retour a minuit
                            
                    }
                }
            }
            
            s++;
            cpt++;
        }


        fin = System.nanoTime();
        tempsExecution = fin - debut;
		System.out.println("Le temps d'execution est égal à : " + tempsExecution/1000000 + " ms");


    }
}
