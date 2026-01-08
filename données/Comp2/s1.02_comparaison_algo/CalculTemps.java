/** SAE 1.02
  * date   : le 22/11/2024
  * auteur : Lucas Leprevost
  */
  
import iut.algo.Clavier;

public class CalculTemps
{
	public static void main (String [] args )
	{
		/*--------------*/
		/* Données      */
		/*--------------*/

		long debut;
		long fin;
		long tempsExecution;
		
		int cpt1;
		int cpt2;
		int cpt3;
		int cpt4;

		/*--------------*/
		/* Instructions */
		/*--------------*/
		
		debut = System.nanoTime();
		
		cpt1 = 0;
		while ( cpt1 < 100 )
		{
			cpt2 = 0;
			while ( cpt2 < 100 )
			{
				cpt3 = 0;
				while ( cpt3 < 100 )
				{
					cpt4 = 0;
					while ( cpt4 < 100 )
					{
						cpt4 ++;
					}
					cpt3 ++;
				}
				cpt2++;
			}
			cpt1++;
		}
		
		fin = System.nanoTime();
		
		tempsExecution = fin - debut;
		System.out.println("le temps d'execution est égal à : " + tempsExecution/1000000 + " ms");
	}
}

