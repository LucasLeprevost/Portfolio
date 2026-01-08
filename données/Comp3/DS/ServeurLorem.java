import java.io.*;
import java.net.*;

public class ServeurLorem 
{
	public static void main(String[] args) 
	{
		int port = 9000;
		System.out.println("Serveur en attente de connexions sur le port " + port + "...");

		try (ServerSocket serverSocket = new ServerSocket(port)) 
		{
			while (true) 
			{
				Socket clientSocket = serverSocket.accept(); // Attente d'un client
				System.out.println("Client connecté : ");

				try (
					PrintWriter 	out = new PrintWriter(clientSocket.getOutputStream(), true);
					BufferedReader 	in 	= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
				) 
				{
					// Demande du idUtilisateur
					out.println("idUtilisateur :");
					String idUtilisateur = in.readLine();

					// Demande du mot de passe
					out.println("mot de passe :");
					String mdp = in.readLine();

					// Vérification des identifiants
					if (!utilisateurValide(idUtilisateur, mdp)) 
					{
						out.println("connexion refusée");
						System.out.println("Tentative de connexion échouée pour : " + idUtilisateur);
						clientSocket.close();
						continue;
					}

					out.println("bienvenue sur le serveur de Lucas Leprevost");
					System.out.println("Connexion réussie pour " + idUtilisateur);

					// Écoute des commandes du client
					while (true) 
					{
						String command = in.readLine();
						if (command == null) break;

						switch (command) 
						{
							case "c":
								out.println("nombre à mettre au carré :");
								try {
									
									int number = Integer.parseInt(in.readLine());

									if (number < 1 || number > 9) 
									{
										out.println("Erreur : chiffre entre 1 et 9 requis.");
									} 
									else 
									{
										out.println("Résultat : " + (number * number));
									}
								} catch (NumberFormatException e) {
									out.println("Erreur : entrée invalide.");
								}
								break;


							case "q":
								out.println("ok");
								System.out.println("Client déconnecté.");
								clientSocket.close();
								break;

							default:
								out.println("Commande inconnue.");
						}
					}
				} catch (IOException e) {
					System.out.println("Erreur avec le client : " + e.getMessage());
				}
			}
		} catch (IOException e) {
			System.err.println("Erreur serveur : " + e.getMessage());
		}
	}

	private static boolean utilisateurValide(String idUtilisateur, String mdp) 
	{
		return (idUtilisateur.equals("admin") 	&& mdp.equals("Qsdf_4567")) ||
			   (idUtilisateur.equals("toto") 	&& mdp.equals("Wxcv_5678"));
	}
}
