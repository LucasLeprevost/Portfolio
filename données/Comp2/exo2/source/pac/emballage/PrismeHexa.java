package  pac.emballage;

import pac.inter.IPeinture;
import pac.inter.IFabrication;




public class PrismeHexa implements IPeinture ,IFabrication
{
	private double coteInterne;
	private double coteExterne;

	private double hauteurInterne;
	private double hauteurExterne;

	public PrismeHexa (double coteInterne, double coteExterne, double hauteurInterne, double hauteurExterne )
	{
		this.coteInterne    = coteInterne;
		this.coteExterne    = coteExterne;

		this.hauteurInterne = hauteurInterne;
		this.hauteurExterne = hauteurExterne;
	}

	public static double getSurface ( double cote , double hauteur )
	{
		
		return	cote * hauteur  +
				cote * cote * ( 3* Math.sqrt(3)/2 ) * 2;
	}

	public static double getVolume ( double cote, double hauteur)
	{
		return  cote * cote * ( 3* Math.sqrt(3)/2 ) * hauteur;

	}


	public double getSurfaceExterne	()	{return   	Cylindre.getSurface	(this.coteExterne, this.hauteurExterne);}
	public double getSurfaceInterne	()	{return   	Cylindre.getSurface	(this.coteInterne, this.hauteurInterne);}
	public double getVolumeExterne	()	{return   	Cylindre.getVolume	(this.coteExterne, this.hauteurExterne);}
	public double getVolumeInterne	()	{return 	Cylindre.getVolume	(this.coteInterne, this.hauteurInterne);}

	public double getVolumeExterneMoinsInterne(){return   	this.getVolumeExterne() - this.getSurfaceInterne() ;}


}