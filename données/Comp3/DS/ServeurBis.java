import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import iut.algo.*;


public class ServeurBis 
{
	public static void main(String [] args)
    {
		String m1;
		int port  = 9000;
		
		System.out.println("connexion au serveur ...");

		try{
			// tente une connection à un serveur dont le nom est hostName,
			// sur le port portNumber:
			Socket toServer = new Socket("c-di-724-13", 9000);
			// si on arrive ici, c’est qu’un serveur attendait sur la machine visée,
			// sur ce numéro de port,
			// et que la socket est connectée à ce serveur

			System.out.println("connecté...");
			PrintWriter out = new PrintWriter(toServer.getOutputStream(), true); 
			BufferedReader in = new BufferedReader( new InputStreamReader(toServer.getInputStream()));
			
			out.println("Je suis la bebou");

			m1 = in.readLine();
			System.out.println(m1);

			m1 = Clavier.lireString();

            while (!m1.equals(""))
			{	
				m1 = Clavier.lireString();
				out.println(m1);
			}



			in.close();
			out.close();
			
			toServer.close();

		}
		catch ( Exception e){
			System.out.println("erreur :" + e.getMessage());
		}
    }
}
