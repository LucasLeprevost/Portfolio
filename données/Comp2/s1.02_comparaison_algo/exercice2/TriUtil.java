public class TriUtil
{
	public static void main ( String [] a )
	{
		
		int[] triSelect;
		int[] triB;
		int[] triInsert;
		int[] tab;
		int taille;
		
		long debut;
		long fin;
		long tempsExecution;
		
		taille = 100;
		
		tab = TriUtil.genererTableau( taille , -100 , 100);
		
		
		
		triSelect = TriUtil.copierTableau( tab );
		
		debut = System.nanoTime ();
		System.out.println ( "-----Tri par sélection-----");
		fin = System.nanoTime();
		
		tempsExecution = fin - debut;
		TriUtil.triSelection( triSelect );
		System.out.println( TriUtil.toString( triSelect ) );
		System.out.print( tempsExecution + " ns \n");
		
		
		
		triB = TriUtil.copierTableau( tab );
		System.out.println ( "-----Tri à bulle-----");
		
		debut = System.nanoTime();
		TriUtil.triBulle ( triB );
		fin = System.nanoTime();
		tempsExecution = fin - debut;
		
		System.out.println ( TriUtil.toString ( triB ) );
		System.out.print( tempsExecution + " ns \n");
		
		triInsert = TriUtil.copierTableau( tab );
		
		System.out.println ( "-----Tri par insertion-----");
		
		debut = System.nanoTime ();
		TriUtil.triInsertion( triInsert );
		fin = System.nanoTime();
		tempsExecution = fin - debut;
		
		System.out.println ( TriUtil.toString ( triInsert ) );
		System.out.print( tempsExecution + " ns \n");
	}
	
	
	public static int[] genererTableau ( int nbCases, int valMin, int valMax )
	{
		
		int[] tab;
		
		
		tab = new int[nbCases];
		
		for ( int cpt = 0 ; cpt < tab.length; cpt++ )
		{
			tab[cpt] = valMin + (int) ( Math.random () * valMax - valMin ) + 1 ;
		}
		
		return tab;
	}
	
	
	public static String toString ( int[] tab )
	{
		String sRet = "";
		for ( int cpt = 0; cpt < tab.length; cpt++ )
		{
			sRet += String.format("%3d",tab[cpt] )+ " ";
			
			if ( ( cpt + 1 )  % 25 == 0 ) { sRet += "\n"; }
		}
		
		return sRet;
	}
	
	public static void triSelection ( int[] tab )
	{
		int[] tabMax;
		int temp;
		int max;
		int indMax;
		int taille;
		
		taille = tab.length -1 ;
		
		while ( taille > 0 )
		{
			max = tab[0];
			indMax = 0;
			
			for ( int cpt = 0 ; cpt <= taille; cpt++ )
			{
				if ( max < tab[cpt] ) 
				{
					indMax = cpt;
					max    = tab[cpt];
					
				}
			}
			
			temp         = tab[taille];
			tab[taille]  = tab[indMax];
			tab[indMax]  = temp;
			
			taille --;
		}
	}
		
		
	public static void triBulle( int[] tab )
	{
		int taille;
		int temp;
		
		for ( taille = tab.length -1 ;taille != 1; taille -- )
		{
			
			for ( int cpt = 1; cpt <= taille ; cpt ++ )
			{
				if ( tab[cpt] < tab[cpt-1] )
				{
					temp        = tab[cpt-1];
					tab[cpt-1]  = tab[cpt];
					tab[cpt] = temp;
				}
				
			}
			
		}
		
	}
	
	public static void triInsertion( int[] tab )
	{
		int tmp;
		
		while ( !TriUtil.estTrie(tab) )
		{
			
			for ( int cpt  = 1; cpt <= tab.length -1 ; cpt ++)
			{
				tmp = tab[cpt]; 
				
				for ( int cpt2 = cpt -1 ; cpt2 < cpt ; cpt2 ++)
				{
					while ( tmp < tab[cpt2] )
					
					{
							tab[cpt2 + 1] = tab[cpt];
							
							cpt2--;
					}
					
					if ( tmp >= tab[cpt2] )
					{
						tab[cpt2 + 1] = tmp;
					}
				}
			}
		}
	}
	
	public static boolean estTrie ( int[] tab )
	{
		
		for ( int cpt  = 1 ; cpt < tab.length -1 ; cpt ++ )
		{
			if ( tab[cpt-1] > tab[cpt] )
			{
				return false;
			}
			
		}
		return true;
	}
	
	public static int[] copierTableau ( int[] tab )
	{
		
		int[] tabCopie;
		
		tabCopie = new int [tab.length] ;
		
		for ( int cpt  = 0 ;cpt < tabCopie.length; cpt++ )
		{
			tabCopie[cpt] = tab[cpt];
		}
		
		return tab;
		
	}
	
	public static int[] Inversé ( 
}

