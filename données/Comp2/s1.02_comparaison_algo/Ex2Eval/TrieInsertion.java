import iut.algo.Clavier;

public class TrieInsertion
{
	public static void main ( String[] a)
	{
        
		int[] tab;
		int nbCases;
		int min;
		int max;
		long debut;
		long fin;
		long tempsExec;


		System.out.print("Nombre de case : ");
		nbCases = Clavier.lire_int();

		System.out.print("Valeur min : ");
		min = Clavier.lire_int();

		System.out.print("Valeur max : ");
		max = Clavier.lire_int();

		tab = new int[nbCases];
           
        for ( int cpt = 0; cpt < tab.length; cpt++)
        {
            tab[cpt] = min + (int) ( Math.random() * (( max - min ) +1) );
        }
       
        debut = System.nanoTime();
        TrieInsertion.triInsertion(tab);
        fin = System.nanoTime();

        tempsExec = ( fin - debut ) / 1000000;

        System.out.println ( TrieInsertion.toString(tab));
        System.out.println ( tempsExec + " millisecondes\n\n");

    }

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
}
