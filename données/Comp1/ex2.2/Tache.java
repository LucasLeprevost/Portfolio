import java.util.List;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.GregorianCalendar;

//Classe qui permet de créer une tache 
public class Tache
{
	private String               nomTache    ;
	private int                  dureeTache  ;
	
	private List<Tache>          lstTachesPrc;
	private List<Tache>          lstTachesSvt;
	
	private int                  dateAuPlusTot;
	private int                  dateAuPlusTard;
	
	//Constructeur qui initialise le nom et la duree avec des paramètres
	public Tache ( String nom, int dureeTache )
	{
		this.nomTache       = nom;
		this.dureeTache     = dureeTache;
		
		this.lstTachesPrc   = new ArrayList<Tache>();
		this.lstTachesSvt   = new ArrayList<Tache>();
	}
	
	//Guetteurs
	public String getNom           ()          { return this.nomTache                           ; }
	public int    getDuree         ()          { return this.dureeTache                         ; }
	public int    getDateAuPlusTot ()          { return this.dateAuPlusTot                      ; }
	public int    getDateAuPlusTard()          { return this.dateAuPlusTard                     ; }
	public int    getMarge         ()          { return this.dateAuPlusTard - this.dateAuPlusTot; }
	public int    getNbTachesPrc   ()          { return this.lstTachesPrc.size()                ; }
	public int    getNbTachesSvt   ()          { return this.lstTachesSvt.size()                ; }
	public Tache  getTachesPrc     ( int ind )
	{
		if   ( ind >= 0 && ind < this.lstTachesPrc.size() ) { return this.lstTachesPrc.get( ind ); }
		else                                                { return null                        ; }
	}
	public Tache  getTachesSvt     ( int ind )
	{
		if   ( ind >= 0 && ind < this.lstTachesSvt.size() ) { return this.lstTachesSvt.get( ind ); }
		else                                                { return null                        ; }
	}
	
	//Permet de set à la main si nécessaire
	public void setDateAuPlusTot ( int date ) { this.dateAuPlusTot  = date; }
	public void setDateAuPlusTard( int date ) { this.dateAuPlusTard = date; }
	
	//Calcul la date au plus tôt de la tache
	public void dateAuPlusTot()
	{
		if ( this.lstTachesPrc.size() != 0 )
		{
			int maxDate = this.lstTachesPrc.get(0).getDateAuPlusTot();
			this.dateAuPlusTot = maxDate + this.lstTachesPrc.get(0).getDuree();
			
			for ( int cpt = 1; cpt < this.lstTachesPrc.size(); cpt++ )
			{
				if ( this.lstTachesPrc.get( cpt ).getDateAuPlusTot() > maxDate )
				{
					Tache t = this.lstTachesPrc.get( cpt );
					maxDate = t.getDateAuPlusTot();
					
					this.dateAuPlusTot = maxDate + t.getDuree();
				}
			}
			
		}
		else
		{
			this.dateAuPlusTot = 0;
		}
	}
	
	//Calcul la date au plus tard de la tache
	public void dateAuPlusTard()
	{
		if ( this.lstTachesSvt.size() != 0 )
		{
			int minDate = this.lstTachesSvt.get(0).getDateAuPlusTard();
			this.dateAuPlusTard = minDate - this.getDuree();
			
			for ( int cpt = 1; cpt < this.lstTachesSvt.size(); cpt++ )
			{
				if ( this.lstTachesSvt.get( cpt ).getDateAuPlusTard() < minDate )
				{
					Tache t = this.lstTachesSvt.get( cpt );
					minDate = t.getDateAuPlusTard();
					
					this.dateAuPlusTard = minDate - this.getDuree();
				}
			}
			
		}
		else
		{
			this.dateAuPlusTard = this.dateAuPlusTot;
		}
	}
	
	//Ajoute une tache précedente à la liste de tache précédente
	public void ajouterTachePrc( Tache t )
	{
		if ( t != null )
		{
			this.lstTachesPrc.add( t );
		}
	}
	
	//Ajoute une tache suivante à la liste de tache suivante
	public void ajouterTacheSvt( Tache t )
	{
		if ( t != null )
		{
			this.lstTachesSvt.add( t );
		}
	}
	
	//Retourne la date au plus tôt de la tache au format JJ/MM à partir d'un int
	public String getDateReelle( int date )
	{
		GregorianCalendar calendar = new GregorianCalendar();
		
		calendar.add(GregorianCalendar.DAY_OF_MONTH, date);
		
		int jour = calendar.get(GregorianCalendar.DAY_OF_MONTH);
		int mois = calendar.get(GregorianCalendar.MONTH) + 1; 
		
		return String.format("%02d/%02d", jour, mois);
	}
	
	public String toString()
	{
		String sRet = "";
		
		//Met le pluriel si la durée de la tache est de 2j ou +
		String jourDuree = " jour";
		if   ( this.dureeTache > 1 ) { jourDuree += "s" ; }
		
		sRet += nomTache + " : " + String.valueOf( dureeTache ) + jourDuree + "\n  ";
		
		sRet += "Date au plus tôt  : " + this.getDateReelle(dateAuPlusTot)  + "\n  ";
		sRet += "Date au plus tard : " + this.getDateReelle(dateAuPlusTard) + "\n  ";
		
		//Met le pluriel si la marge est de 2j ou +
		String margeDuree = " jour";
		if   ( this.getMarge() > 1 ) { margeDuree += "s" ; }
		
		sRet += "marge             : " + this.getMarge() + margeDuree + "\n  ";
		
		if ( this.lstTachesPrc.size() == 0 )
		{
			sRet += "Cette tache ne possède aucune tache précédente.";
		}
		else
		{
			sRet += "Liste des taches précédentes : \n     ";
			
			for ( int cpt = 0; cpt < this.lstTachesPrc.size(); cpt++ )
			{
				Tache tPrc = this.lstTachesPrc.get( cpt );
				sRet += tPrc.getNom();
				
				if ( cpt < this.lstTachesPrc.size() - 1 ) { sRet += ", "; }
			}
		}
		
		sRet += "\n  ";
		
		if ( this.lstTachesSvt.size() == 0 )
		{
			sRet += "Cette tache ne possède aucune tache suivante.";
		}
		else
		{
			sRet += "Liste des taches suivantes : \n     ";
			
			for ( int cpt = 0; cpt < this.lstTachesSvt.size(); cpt++ )
			{
				Tache tSvt = this.lstTachesSvt.get( cpt );
				sRet += tSvt.getNom();
				
				if ( cpt < this.lstTachesSvt.size() - 1 ) { sRet += ", "; }
			}
		}
		
		sRet += "\n";
		
		return sRet;
	}
}
