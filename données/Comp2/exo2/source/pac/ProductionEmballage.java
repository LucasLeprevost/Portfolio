package pac;

import java.util.List;
import java.util.ArrayList;

import pac.emballage.Cylindre;
import pac.emballage.Cube;
import pac.emballage.PrismeHexa;
import pac.emballage.Sphere;

import pac.inter.IFabrication;
import pac.inter.IPeinture;


public class ProductionEmballage
{
	public static void main (String[] a)
	{
		List<Object> lstForme = new ArrayList<Object>();
		
		AtelierFabrication 	atF = new AtelierFabrication(0.9) ;
		AtelierPeinture 	atP = new AtelierPeinture 	( 20 );

		
		// Commade a produire
		lstForme.add(new Cube		(18.8, 20.0));
		lstForme.add(new Cube		(18.8, 20.0));
		lstForme.add(new Cylindre 	( 14.8, 15.0, 25.8, 26.0 ));
		lstForme.add(new PrismeHexa ( 14.8, 15.0, 25.8, 26.0 ));
		lstForme.add(new Sphere 	( 4.0, 5.0));


		//Frabication de la command
		System.out.println("\n" );
		System.out.println ( "-----------------------------Atelier de Fabrication----------------------------" );
		System.out.println ( "-------------------------------------------------------------------------------" );



		for ( Object o : lstForme)
		{
			atF.fabriquer((IFabrication)o);
			System.out.println(atF + "\n" + "-------------------------------------------------------------------------------" );
		}

		System.out.println("\n");

		System.out.println ( "------------------------------Atelier de Peinture-----------------------------" );
		System.out.println ( "-------------------------------------------------------------------------------" );


		for ( Object o : lstForme)
		{
			atP.peindre((IPeinture)o);
			System.out.println(atP + "\n" + "-------------------------------------------------------------------------------");
		}


/*
		AtelierPeinture 	at = new AtelierPeinture ( 20 );
		AtelierFabrication 	af = new AtelierFabrication(0.9);
		
		at.peindre ( new Cube ( 18.8, 20.0 ) );
		af.fabriquer(new Cube(18.8, 20.0));

		System.out.println ( "-------------------------------------------------------------------------------" );
		System.out.println ( at   );
		System.out.println ( "-------------------------------------------------------------------------------" );

		System.out.println ( "-------------------------------------------------------------------------------" );
		System.out.println ( af  );
		System.out.println ( "-------------------------------------------------------------------------------" );

		at.peindre ( new Cube ( 18.8, 20.0 ) );

		System.out.println ( at );
		System.out.println ( "-------------------------------------------------------------------------------" );
		

		System.out.println ( af );
		System.out.println ( "-------------------------------------------------------------------------------" );
		

		at.peindre ( new Cylindre ( 14.8, 15.0, 25.8, 26.0 ) );
		af.fabriquer ( new Cylindre ( 14.8, 15.0, 25.8, 26.0 ) );


		System.out.println ( at );
		System.out.println ( "-------------------------------------------------------------------------------" );

		System.out.println ( af );
		System.out.println ( "-------------------------------------------------------------------------------" );
		

		at.peindre ( new PrismeHexa ( 14.8, 15.0, 25.8, 26.0 ) );
		af.fabriquer ( new PrismeHexa ( 14.8, 15.0, 25.8, 26.0 ) );


		System.out.println ( at );
		System.out.println ( "-------------------------------------------------------------------------------" );

		System.out.println ( af );
		System.out.println ( "-------------------------------------------------------------------------------" );
		

		at.peindre ( new Sphere ( 14.8, 15) );
		af.fabriquer ( new Sphere ( 14.8, 15) );


		System.out.println ( at );
		System.out.println ( "-------------------------------------------------------------------------------" );


		System.out.println ( af );
		System.out.println ( "-------------------------------------------------------------------------------" );
		

		*/
	}
}





