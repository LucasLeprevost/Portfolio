import java.util.Scanner;

public class TriUtil
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Saisir le nombre de case du tableau : ");
		int nbCases = sc.nextInt();
		System.out.println("Saisir la valeur minimale du tableau : ");
		int valMin  = sc.nextInt();
		System.out.println("Saisir la valeur maximale du tableau : ");
		int valMax  = sc.nextInt();

		int tab [] = TriUtil.genererTableau(nbCases, valMin, valMax);
		int tabInvers [] = TriUtil.Inverse (nbCases, valMin, valMax);
		int tabQuasiTrie [] = TriUtil.quasiTrier (nbCases, valMin, valMax);
		
		
		

		int tabSel [] = TriUtil.copierTableau(tab);
		int tabBulle [] = TriUtil.copierTableau(tab);
		int tabIns [] = TriUtil.copierTableau(tab);

		long tempsFin, tempsDebut, tempsExecution;

		tempsDebut = System.nanoTime();

		TriUtil.triSelection(tabSel);

		tempsFin = System.nanoTime();
		tempsExecution = (tempsFin - tempsDebut) / 1000;
		System.out.println("Tri par sélection : ");
		System.out.println(TriUtil.toString(tabSel));
		System.out.println();
		System.out.println("Le temps d'execution est egal à : " + tempsExecution + " μs");
		System.out.println();
		



		tempsDebut = System.nanoTime();

		TriUtil.triBulle(tabBulle);

		tempsFin = System.nanoTime();
		tempsExecution = (tempsFin - tempsDebut) / 1000;
		System.out.println("Tri à bulle : ");
		System.out.println(TriUtil.toString(tabBulle));
		System.out.println();
		System.out.println("Le temps d'execution est egal à : " + tempsExecution + " μs");
		System.out.println();
		
		



		tempsDebut = System.nanoTime();

		TriUtil.triInsertion(tabIns);

		tempsFin = System.nanoTime();
		tempsExecution = (tempsFin - tempsDebut) / 1000;
		System.out.println("Tri par insertion : ");
		System.out.println(TriUtil.toString(tabIns));
		System.out.println();
		System.out.println("Le temps d'execution est egal à : " + tempsExecution + " μs");
		System.out.println();
		
		
		
		/*               Tries avec un tableau inversé                     */
		
		
		tabSel = TriUtil.copierTableau(tabInvers);
		tabBulle = TriUtil.copierTableau(tabInvers);
		tabIns = TriUtil.copierTableau(tabInvers);
		
		
		tempsDebut = System.nanoTime();

		TriUtil.triSelection(tabSel);

		tempsFin = System.nanoTime();
		tempsExecution = (tempsFin - tempsDebut) / 1000;
		System.out.println("Tri par sélection avec un tableau inversé : ");
		System.out.println(TriUtil.toString(tabSel));
		System.out.println();
		System.out.println("Le temps d'execution est egal à : " + tempsExecution + " μs");
		System.out.println();
		
		
		
		tempsDebut = System.nanoTime();

		TriUtil.triBulle(tabBulle);

		tempsFin = System.nanoTime();
		tempsExecution = (tempsFin - tempsDebut) / 1000;
		System.out.println("Tri à bulle avec un tableau inversé : ");
		System.out.println(TriUtil.toString(tabBulle));
		System.out.println();
		System.out.println("Le temps d'execution est egal à : " + tempsExecution + " μs");
		System.out.println();
		
		
		
		tempsDebut = System.nanoTime();

		TriUtil.triInsertion(tabIns);

		tempsFin = System.nanoTime();
		tempsExecution = (tempsFin - tempsDebut) / 1000;
		System.out.println("Tri par insertion avec un tableau inversé : ");
		System.out.println(TriUtil.toString(tabIns));
		System.out.println();
		System.out.println("Le temps d'execution est egal à : " + tempsExecution + " μs");
		System.out.println();
		sc.close();
		
		/*               Tries avec un tableau presque trié                   */
		
		tabSel = TriUtil.copierTableau(tabQuasiTrie);
		tabBulle = TriUtil.copierTableau(tabQuasiTrie);
		tabIns = TriUtil.copierTableau(tabQuasiTrie);
		
		
		tempsDebut = System.nanoTime();

		TriUtil.triSelection(tabSel);

		tempsFin = System.nanoTime();
		tempsExecution = (tempsFin - tempsDebut) / 1000;
		System.out.println("Tri par sélection avec un tableau preque trié: ");
		System.out.println(TriUtil.toString(tabSel));
		System.out.println();
		System.out.println("Le temps d'execution est egal à : " + tempsExecution + " μs");
		System.out.println();
		
		
		
		tempsDebut = System.nanoTime();

		TriUtil.triBulle(tabBulle);

		tempsFin = System.nanoTime();
		tempsExecution = (tempsFin - tempsDebut) / 1000;
		System.out.println("Tri à bulle avec un tableau presque trié : ");
		System.out.println(TriUtil.toString(tabBulle));
		System.out.println();
		System.out.println("Le temps d'execution est egal à : " + tempsExecution + " μs");
		System.out.println();
		
		
		
		tempsDebut = System.nanoTime();

		TriUtil.triInsertion(tabIns);

		tempsFin = System.nanoTime();
		tempsExecution = (tempsFin - tempsDebut) / 1000;
		System.out.println("Tri par insertion avec un tableau presque trié : ");
		System.out.println(TriUtil.toString(tabIns));
		System.out.println();
		System.out.println("Le temps d'execution est egal à : " + tempsExecution + " μs");
		System.out.println();
	}
	

/*----------------------------------------------------------------------------*/
/*----------------------------Tri par selection-------------------------------*/
/*----------------------------------------------------------------------------*/


	public static void triSelection ( int[] tab )
	{
		int min;
		int indiceMin;
		int ind;
		
		ind = 0;
		while (ind < tab.length)
		{
			min       = tab[ind];
			indiceMin = ind;

			for (int cpt = ind; cpt < tab.length; cpt++)
			{
				if (tab[cpt] < min)
				{
					min       = tab [cpt];
					indiceMin = cpt;
				}

			}

			TriUtil.permuter(tab, indiceMin, ind);
			ind++;
			
		}

	}



/*----------------------------------------------------------------------------*/
/*--------------------------------Tri a bulle---------------------------------*/
/*----------------------------------------------------------------------------*/



	public static void triBulle(int[] tab) 
    {

        while(!estTrie(tab))
        {
            for(int cpt =1; cpt < tab.length; cpt ++)
            {
                if(tab[cpt -1] > tab[cpt] )
                {
                    
                    permuter(tab, cpt -1, cpt);
                }
                
            }
        
        }
        
    }



/*----------------------------------------------------------------------------*/
/*----------------------------Tri par insertion-------------------------------*/
/*----------------------------------------------------------------------------*/



	public static void triInsertion(int[] tab)
	{

		for (int cpt = 1; cpt < tab.length  ; cpt++)
		{
			int value = tab[cpt];
			int j = cpt;
			
			
			while (j > 0 && tab[j - 1] > value)
			{
				tab[j] = tab[j - 1];
				j--;
			}
			
			
			tab[j] = value;

		}

	}



/*----------------------------------------------------------------------------*/
/*---------------------------------Est trie-----------------------------------*/
/*----------------------------------------------------------------------------*/



	public static boolean estTrie(int[] tab)
	{
		
		for(int cpt = 1; cpt < tab.length; cpt ++)
		{
		
			if(tab[cpt -1] > tab[cpt])
			{
			
				return false;
				
			}
			
		}
		
		return true;
	}



/*----------------------------------------------------------------------------*/
/*-----------------------------Generer Tableau--------------------------------*/
/*----------------------------------------------------------------------------*/



	public static int[] genererTableau ( int nbCases, int valMin, int valMax )
	{
		int []  tab ;

		tab = new int[nbCases];

		for (int cpt = 0; cpt < tab.length ; cpt++ )
		{
			if ( valMin > valMax)
			{
				System.err.println("Valeur minimale supérieure à la valeur maximale ");
			}
			else
			{
				tab[cpt] = valMin + (int) (Math.random() * ((valMax-valMin)+1));
			}
		
			
			
		}

		return tab;
	}



/*----------------------------------------------------------------------------*/
/*----------------------------Copier un tableau-------------------------------*/
/*----------------------------------------------------------------------------*/



public static int[] copierTableau(int[] tab)
{
	int[] newTab = new int[tab.length];

	for(int cpt = 0; cpt < newTab.length; cpt++)
	{
	
		newTab[cpt] = tab[cpt];
		
	}

	return newTab;
}



/*----------------------------------------------------------------------------*/
/*--------------------------------To string-----------------------------------*/
/*----------------------------------------------------------------------------*/



public static String toString(int[] tab) 
{
	StringBuilder ret = new StringBuilder();
	StringBuilder sep = new StringBuilder("+");
	int taille = tab.length;

	// Générer les séparateurs horizontaux
	for (int i = 0; i < Math.min(taille, 4); i++) 
	{
		sep.append("-------+");
    }
    if (taille > 8) 
	{
        sep.append(" . . . . +");
        for (int i = taille - 4; i < taille; i++) 
		{
            sep.append("-------+");
        }
    } 
	else 
	{
        for (int i = 4; i < taille; i++) 
		{
            sep.append("-------+");
        }
    }

    // Ajout des séparateurs dans la représentation
    ret.append(sep).append("\n|");

    // Ajouter les valeurs du tableau
    for (int i = 0; i < Math.min(taille, 4); i++) 
	{
        ret.append(String.format(" %5d|", tab[i]));
    }
    if (taille > 8) 
	{
        ret.append("         |");
        for (int i = taille - 4; i < taille; i++) 
		{
            ret.append(String.format("  %5d|", tab[i]));
        }
    } 
	else 
	{
        for (int i = 4; i < taille; i++) 
		{
            ret.append(String.format("  %5d|", tab[i]));
        }
    }

    ret.append("\n").append(sep).append("\n");

    // Ajouter les indices
    StringBuilder indices = new StringBuilder();
    for (int i = 0; i < Math.min(taille, 4); i++) 
	{
        indices.append(String.format("%6d ", i));
    }
    if (taille > 8) 
	{
        indices.append("              ");
        for (int i = taille - 4; i < taille; i++) 
		{
            indices.append(String.format("%6d  ", i));
        }
    } 
	else 
	{
        for (int i = 4; i < taille; i++) 
		{
            indices.append(String.format("%6d", i));
        }
    }

    ret.append(indices);
    return ret.toString();
}




/*----------------------------------------------------------------------------*/
/*----------------------------------Permuter----------------------------------*/
/*----------------------------------------------------------------------------*/



	private static void permuter ( int[] tab, int ind1, int ind2 )
	{
		int temp = 0;

		temp      = tab[ind1];
		tab[ind1] = tab[ind2];
		tab[ind2] = temp;
		
	}
	
	
	/*----------------------------------------------------------------------------*/
	/*----------------------------Générer un tableau inverse----------------------*/
	/*----------------------------------------------------------------------------*/
	public static int[] Inverse( int nbCases, int valMin, int valMax )
	{
		int[] tab;
		int cpt;
		tab = new int [nbCases];
		
		tab[0] = valMax;
		for ( cpt = 1 ; cpt < nbCases ; cpt ++ )
		{
			tab[cpt] = valMin + (int) (Math.random() * ((valMax-valMin)+1));
			
			while ( tab[cpt] > tab[cpt -1] )
			{
				tab[cpt] = valMin + (int) (Math.random() * ((valMax-valMin)+1));
			}
		}
		
		return tab;
	}
	public static int[] quasiTrier(int nbCases ,int valMin, int valMax )
	{
		int valAleat;
		int[] tab   ;

		tab = new int[nbCases];

		for (int cpt = 0 ; cpt < nbCases;cpt++)
		{
			valAleat = valMin + (int)(Math.random()  *(valMax-valMin+1 ) ) ;
			while(cpt > 1 && cpt < nbCases /2 && valAleat < tab[cpt-1])
			{
				valAleat = valMin + (int)(Math.random() * (valMax-valMin+1 ) ) ;
			}
			if(cpt >= nbCases/2){valAleat = valMin + (int)(Math.random() * (valMax-valMin+1 ));}
				tab[cpt] = valAleat;
			}
			return tab;
	}
}


