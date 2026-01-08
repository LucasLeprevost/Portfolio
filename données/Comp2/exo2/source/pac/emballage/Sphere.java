package pac.emballage;

import pac.inter.IFabrication;
import pac.inter.IPeinture;

import static java.lang.Math.PI;

public class Sphere implements IPeinture, IFabrication
{
	private double rayonInterne;
	private double rayonExterne;

	public Sphere (double rayonInterne , double rayonExterne)
	{
		this.rayonInterne = rayonInterne;
		this.rayonExterne = rayonExterne;
	}

	public static double getSurface ( double rayon )
	{
		return 4* PI * (rayon * rayon);
	}

	public static double getVolume ( double rayon)
	{
		return (4.0/3) * PI * (rayon * rayon * rayon);
	}

	public double getSurfaceInterne (){return Sphere.getSurface(this.rayonInterne);}
	public double getSurfaceExterne (){return Sphere.getSurface(this.rayonExterne);}
	public double getVolumeExterne 	(){return Sphere.getVolume(this.rayonExterne);}
	public double getVolumeInterne 	(){return Sphere.getVolume(this.rayonInterne);}

	public double getVolumeExterneMoinsInterne(){return   	this.getVolumeExterne() - this.getSurfaceInterne() ;}

}
