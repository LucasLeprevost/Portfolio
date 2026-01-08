import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class MPM
{
	private List<Tache> lstTache;

	public MPM()
	{
		this.lstTache = new ArrayList<Tache>();
	}
	
	public Tache getTache   ( int ind ) { return this.lstTache.get ( ind ); }
	public int   getNbTaches(         ) { return this.lstTache.size()     ; }


	// Lit la liste des taches à partir d'un fichier
	public void initMPM(String data)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(data)))
		{
			String lig;
			while ((lig = br.readLine()) != null)
			{
				String[] parts = lig.split("\\|"); // Sépare les parties de la ligne par le caractère '|'
				
				String nom = parts[0];                   // Nom de la tache
				
				int duree = Integer.parseInt(parts[1]);  // Durée de la tache, convertie en entier
				
				Tache tache = new Tache( nom, duree );
				
				if ( parts.length == 3 )                                 // Si la ligne contient des tâches précédentes
				{
					String tachePrc = parts[2];                          // Tâches précédentes sous forme de chaîne de caractères
					String[] partsTachesPrc = tachePrc.split(","); // Sépare les noms des tâches précédentes par la virgule
					
					for (String nomTachePrc : partsTachesPrc)
					{
						for ( Tache t : this.lstTache )
						{
							if ( nomTachePrc.equals( t.getNom() ) )      // Si le nom de la tâche correspond à une tâche précdente existante
							{
								tache.ajouterTachePrc( t );              // Ajoute la tâche précédente à la liste de tâches précédentes de la tâche actuelle
								t.ajouterTacheSvt( tache );              // Ajoute la tâche actuelle à la liste de tâches suivantes de la tâche précédente
							}
						}
					}
				}
				
				this.lstTache.add( tache ); // Ajoute la tâche à la liste des tâches du MPM
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}


		for (int cpt = 0; cpt < this.getNbTaches(); cpt++)
		{
			this.getTache(cpt).dateAuPlusTot(); // Calcule la date au plus tôt pour chaque tâche
		}

		for (int cpt = this.getNbTaches() - 1; cpt >= 0; cpt--)
		{
			this.getTache(cpt).dateAuPlusTard(); // Calcule la date au plus tard pour chaque tâche, en partant de la fin
		}

	}


	public String toString()
	{
		String res = "";
		
		if ( this.lstTache.size() != 0 )
		{
			for ( Tache tache : this.lstTache )
			{
				res += tache.toString() + "\n";
			}
		}
		
		return res;
	}
	
	public static void main(String[] args)
	{
		MPM mpm = new MPM();
		
		mpm.initMPM("edt.data");
		
		
		System.out.println(mpm);
	}
}
