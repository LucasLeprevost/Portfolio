package  pac.emballage;

import pac.inter.IPeinture;
import pac.inter.IFabrication;

public class Cube implements IPeinture, IFabrication
{
	private double coteInterne;
	private double coteExterne;


	public Cube (double coteInterne, double coteExterne )
	{
		this.coteInterne   = coteInterne;
		this.coteExterne   = coteExterne;
	}

	public static double getSurface ( double cote )	{return cote * cote * 6;		}
	public static double getVolume 	( double cote)	{return Math.pow ( cote, 3 );	}


	public double getSurfaceExterne(){return   	Cube.getSurface(this.coteExterne);}
	public double getSurfaceInterne(){return   	Cube.getSurface(this.coteInterne);}
	public double getVolumeExterne(){return   	Cube.getVolume(this.coteExterne);}
	public double getVolumeInterne(){return 	Cube.getVolume(this.coteInterne);}

	
	public double getVolumeExterneMoinsInterne(){return   	this.getVolumeExterne() - this.getSurfaceInterne() ;}


}
