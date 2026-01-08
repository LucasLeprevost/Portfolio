public class triUtilTest
{
	public static void main ( String [] a )
	{
		int[] triSelect;
		int[] triB;
		int[] triInsert;
		
		triSelect = new int[0];
		triB      = new int[0];
		triInsert = new int[0];
		
		triSelect = triUtilTest.GenererTab();
		
		System.out.println ( "-----Tri par sélection-----");
		System.out.print ( triUtilTest.toString( triSelect ) + "\n");
		System.out.println ( triUtilTest.toString (triUtilTest.triSelection( triSelect )) + "\n" );
		
		
		triB = triUtilTest.GenererTab();
		
		System.out.println ( "-----Tri à bulle-----");
		System.out.print ( triUtilTest.toString( triB ) + "\n");
		System.out.println ( triUtilTest.toString (triUtilTest.triBulle( triB )) + "\n");
		
		
		triInsert = triUtilTest.GenererTab();
		
		System.out.println ( "-----Tri par insertion-----");
		System.out.print ( triUtilTest.toString( triInsert ) + "\n");
		System.out.println ( triUtilTest.toString (triUtilTest.triInsertion( triInsert )) + "\n");
	}
	
	
	private static int[] GenererTab()
	{
		final int TAILLE = 6;
		
		int[] tab;
		
		
		tab = new int[TAILLE];
		
		for ( int cpt = 0 ; cpt < tab.length; cpt++ )
		{
			tab[cpt] = (int) ( Math.random () * 11 );
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
	
	public static int[] triSelection ( int[] tab )
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
		return tab;
	}
		
		
	public static int[] triBulle( int[] tab )
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
		
		return tab;
	}
	
	public static int[] triInsertion( int[] tab )
	{
		int tmp;
		
		for ( int cpt  = 0; cpt <= tab.length -1 ; cpt ++)
		{
			tmp = tab[cpt]; 
			
			for ( int cpt2 = cpt -1 ; cpt2 < cpt ; cpt2 ++)
			{
				while ( tmp < tab[cpt2] )
				
				{
						tab[cpt2 + 1] = tab[cpt];
						
						cpt2--;
				}
				
				if ( tmp > tab[cpt2] )
				{
					tab[cpt2 + 1] = tmp;
				}
			}
		}
		
	return tab;
	}
	
	private static int[] Copie ( int[] tab , int taille )
	{
		
		int[] tabCopie;
		
		tabCopie = new int [taille] ;
		
		for ( int cpt  = 0 ;cpt < tabCopie.length; cpt++ )
		{
			tabCopie[cpt] = tab[cpt];
		}
		
		return tabCopie;
		
	}
	
}
	
