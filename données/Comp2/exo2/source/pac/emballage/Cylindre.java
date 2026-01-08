package  pac.emballage;

import static  java.lang.Math.PI;

import pac.inter.IFabrication;
import pac.inter.IPeinture;

public class Cylindre implements IPeinture, IFabrication
{
	private double rayonInterne;
	private double rayonExterne;

	private double hauteurInterne;
	private double hauteurExterne;

	public Cylindre (double rayonInterne, double rayonExterne, double hauteurInterne, double hauteurExterne )
	{
		this.rayonInterne   = rayonInterne;
		this.rayonExterne   = rayonExterne;
		this.hauteurInterne = hauteurInterne;
		this.hauteurExterne = hauteurExterne;
	}
	
	public static double getSurface ( double rayon, double hauteur)
	{
		return 	2 * PI * rayon * rayon   +
				2 * PI * rayon * hauteur;

	}

	public static double getVolume ( double rayon, double hauteur)
	{
		return   Math.PI * rayon * rayon * hauteur;
	}



	public double getSurfaceExterne(){return   	Cylindre.getSurface(this.rayonExterne, this.hauteurExterne);}
	public double getSurfaceInterne(){return   	Cylindre.getSurface(this.rayonInterne, this.hauteurInterne);}
	public double getVolumeExterne(){return   	Cylindre.getVolume(this.rayonExterne, this.hauteurExterne);}
	public double getVolumeInterne(){return 	Cylindre.getVolume(this.rayonInterne, this.hauteurInterne);}

	public double getVolumeExterneMoinsInterne(){return  this.getVolumeExterne() - this.getSurfaceInterne() ;}

	

}
