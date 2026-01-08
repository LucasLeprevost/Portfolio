public class Symetrie 
{
	public static void main(String[] args) 
	{

		long debut1 = System.nanoTime();
		long debut2 = System.nanoTime();

		char[][] tabOrigine = {
			{ 'A', 'E', 'I', 'M', 'Q' },
			{ 'B', 'F', 'J', 'N', 'R' },
			{ 'C', 'G', 'K', 'O', 'S' },
			{ 'D', 'H', 'L', 'P', 'T' }
		};

		System.out.println("Tableau original :");
		afficherTableau(tabOrigine);

		System.out.println("\nSymétrie verticale avec symetrie1 ( modifie l'original ) :");
		char[][] tabDest = symetrie1(tabOrigine);
		afficherTableau(tabDest);

		long fin1 = System.nanoTime();
		System.out.println("Temps d'exécution : " + (fin1-debut1) / 1000000 + "ms");

		tabOrigine = new char[][] 
		{
			{ 'A', 'E', 'I', 'M', 'Q' },
			{ 'B', 'F', 'J', 'N', 'R' },
			{ 'C', 'G', 'K', 'O', 'S' },
			{ 'D', 'H', 'L', 'P', 'T' }
		};

		// Tester la méthode symetrie2
		System.out.println("\nSymétrie verticale avec symetrie2 (nouveau tableau) :");
		char[][] resultat2 = symetrie2(tabOrigine);
		afficherTableau(resultat2);

		long fin2 = System.nanoTime();
		System.out.println("Temps d'exécution : " + (fin2-debut1) / 1000000 + "ms");
	}

	public static char[][] symetrie1(char[][] tab) 
	{
		int lig = tab.length;
		int col = tab[0].length;

		// Parcourir chaque ligne
		for (int i = 0; i < lig; i++) 
		{
			// Permuter les éléments de chaque ligne
			for (int j = 0; j < col / 2; j++) 
			{
				char temp = tab[i][j];
				tab[i][j] = tab[i][col - 1 - j];
				tab[i][col - 1 - j] = temp;
			}
		}

		return tab;
	}

	public static char[][] symetrie2(char[][] tab) 
	{
		int lig = tab.length;
		int col = tab[0].length;

		// Créer un nouveau tableau de destination
		char[][] nouveauTab = new char[lig][col];

		// Copier les éléments avec symétrie dans le nouveau tableau
		for (int i = 0; i < lig; i++) 
		{
			for (int j = 0; j < col; j++) 
			{
				nouveauTab[i][j] = tab[i][col - 1 - j];
			}
		}

		return nouveauTab;
	}

	public static void afficherTableau(char[][] tab) 
	{
		for (char[] row : tab) 
		{
			for (char c : row) 
			{
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
}