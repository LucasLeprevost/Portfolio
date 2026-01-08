package pac;
/*
import pac.emballage.Cylindre;
import pac.emballage.Cube;
import pac.emballage.PrismeHexa;
*/
import pac.inter.IPeinture;


public class AtelierPeinture
{
	private double pouvoirCouvrant;   // m²/litre
	private double surfacePeinte;     // cm²
	private int    nbEmballagePeint;  // en unité

	public AtelierPeinture ( double pouvoirCouvrant )
	{
		this.pouvoirCouvrant = pouvoirCouvrant;
		this.surfacePeinte   = 0.0;
		this.nbEmballagePeint= 0;
	}

	
	public void reInitCompteur()
	{
		this.surfacePeinte   = 0.0;
		this.nbEmballagePeint= 0;
	}

	public void peindre ( IPeinture emb )
	{
		this.surfacePeinte += emb.getSurfaceExterne();

		this.nbEmballagePeint ++;	
	
	} 
/*
	public void peindre ( Cylindre emb )
	{

		this.surfacePeinte += emb.getSurfaceExterne();

		this.nbEmballagePeint ++;

	}

	public void peindre ( Cube emb )
	{
		this.surfacePeinte += emb.getSurfaceExterne();

		this.nbEmballagePeint ++;
	}

	public void peindre ( PrismeHexa emb )
	{
		this.surfacePeinte += emb.getSurfaceExterne();

		this.nbEmballagePeint ++;
	}
*/
	public String toString()
	{
		double surfaceM2 = this.surfacePeinte / 10000;  	// Convertir cm² en m²
					
		double volumePeinture = surfaceM2 / this.pouvoirCouvrant; 	// Calcul du volume en litres

		
		String unite = "unité" +  (this.nbEmballagePeint > 1 ? "s" : "" );
		
return	
		String.format("%30s", "Nombre d'emballage peint : " ) 		+ String.format("%10d",	(this.nbEmballagePeint))  		+	String.format("%-7s"," " +  unite) + "\n" + 
		String.format("%30s", "Surface peinte : ") 					+ String.format("%10.3f",	(this.surfacePeinte )) 			+  	String.format("%-7s", " cm²") +  "\n" + 
		String.format("%30s", "Volume de peinture utilisé : " ) 		+ String.format("%10.8f",	(volumePeinture)) 				+ 	" L";
	}


}
