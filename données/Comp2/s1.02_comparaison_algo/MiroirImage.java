public class MiroirImage 
{
    public static void main(String[] args) 
    {
        // Vérification des arguments
        if (args.length != 2) 
        {
            System.out.println("Usage: java MiroirImage fichier source fichier destination");
            return;
        }

        String fichierSource = args[0];
        String fichierDestination = args[1];

        try 
        {
            // Étape 1 : Conversion de l'image en tableau 2D
            char[][] imageTab = ImageUtil.Image2Tab(fichierSource);

            // Étape 2 : Appliquer la symétrie verticale
            char[][] miroirTab = creerMiroir(imageTab);

            // Étape 3 : Générer l'image miroir
            ImageUtil.tabToImage(miroirTab, fichierDestination);

            System.out.println("L'image miroir a été générée avec succès : " + fichierDestination);
        } 
        catch (Exception e) 
        {
            System.err.println("Erreur lors du traitement : " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Applique une symétrie verticale à un tableau 2D.
     *
     * @param tab Le tableau 2D d'origine.
     * @return Un tableau 2D avec une symétrie verticale.
     */
    private static char[][] creerMiroir(char[][] tab) 
    {
        int hauteur = tab.length;
        int largeur = tab[0].length;
        char[][] miroir = new char[hauteur][largeur];

        for (int i = 0; i < hauteur; i++) 
        {
            for (int j = 0; j < largeur; j++) 
            {
                // Inverser les colonnes
                miroir[i][j] = tab[i][largeur - j - 1];
            }
        }

        return miroir;
    }
}