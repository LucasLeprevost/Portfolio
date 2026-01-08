package pac;

import pac.inter.IFabrication;

public class AtelierFabrication 
{
    
	private 	double masseVolumique; 		
    private 	double VolumeMatiere; 
	private 	int nbEmballageProduit;


	public AtelierFabrication ( double masseVolumique )
	{
		this.masseVolumique = masseVolumique;
		this.VolumeMatiere   = 0.0;
		this.nbEmballageProduit= 0;
	}

	
	public void reInitCompteur()
	{
		this.VolumeMatiere  = 0.0;
		this.nbEmballageProduit= 0;
	}

	public void fabriquer ( IFabrication emb )
	{
		this.VolumeMatiere += emb.getVolumeExterne() - emb.getVolumeInterne();
		this.nbEmballageProduit ++;	
	}

	public String toString()
	{
		double conso = (this.VolumeMatiere * this.masseVolumique) ;	// Convertir cm² en m²
					
		String unite = "unité" +  (this.nbEmballageProduit > 1 ? "s" : "" );
	
		
		return	
			String.format("%30s", "Nombre d'emballage produit : " ) 		+ String.format("%10d",	(this.nbEmballageProduit))  		+	String.format("%-7s"," " +  unite)   + '\n' + 
			String.format("%30s", "Volume matière : ") 					+ String.format("%10.3f",	(this.VolumeMatiere )) 			+  	String.format("%-7s", " cm²") +  "\n" + 
			String.format("%30s", "Volume de peinture utilisé : " ) 		+ String.format("%10.3f",	(conso)) 				+ 	String.format("%-7s", " g");





	}
}






