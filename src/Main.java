import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		String repUtilisateur;
		
		System.out.println("Bienvenue dans Town of Glory \nNom de la ville:");
		repUtilisateur=sc.nextLine();
		
		Ville jeu = new Ville(repUtilisateur);
		System.out.println(jeu);
		
		while(!jeu.isOver()) {
			System.out.println("\nPour construire, appuyez sur c\n" +
					   		   "Pour passer la journée, appuyez sur j\n" +
					   		   "Pour supprimer, appuyez sur s\n" +
					   		   "Pour faire un echange appuyez sur w");
			repUtilisateur= sc.nextLine();
			if(repUtilisateur.equals("c")){
				System.out.println("Pour construire une maison, appuyez sur m\n" +
						   		   "Pour construire une mine, appuyez sur o\n" +
						   		   "Pour construire un entrepot, appuyez sur e\n" +
						   		   "Pour construire une eglise, appuyez sur g\n" +
						   		   "Pour construire un champ, appuyez sur p\n" +
								   "Pour construire une scierie, appuyez sur s");
				repUtilisateur= sc.nextLine();
				if(repUtilisateur.equals("m")){
					jeu.addBatiment(TypeBatiment.MAISON);
				}
				if(repUtilisateur.equals("o")){
					jeu.addBatiment(TypeBatiment.MINE);
				}
				if(repUtilisateur.equals("e")){
					jeu.addBatiment(TypeBatiment.ENTREPOT);
				}
				if(repUtilisateur.equals("g")){
					jeu.addBatiment(TypeBatiment.EGLISE);
				}
				if(repUtilisateur.equals("p")){
					jeu.addBatiment(TypeBatiment.CHAMPS);
				}
				if(repUtilisateur.equals("s")){
					jeu.addBatiment(TypeBatiment.SCIERIE);
				}
				System.out.println(jeu);
			}
			if(repUtilisateur.equals("j")){
				
			}
			if(repUtilisateur.equals("s")){
				System.out.println("Pour detruire une maison, appuyez sur m\n" +
						   		   "Pour detruire une mine, appuyez sur o\n" +
						   		   "Pour detruire un entrepot, appuyez sur e\n" +
						   		   "Pour detruire une eglise, appuyez sur g\n" +
						   		   "Pour detruire un champ, appuyez sur p\n" +
								   "Pour detruire une scierie, appuyez sur s");
				repUtilisateur= sc.nextLine();
				if(repUtilisateur.equals("m")){
					jeu.deleteBatiment(TypeBatiment.MAISON);
				}
				if(repUtilisateur.equals("o")){
					jeu.deleteBatiment(TypeBatiment.MINE);
				}
				if(repUtilisateur.equals("e")){
					jeu.deleteBatiment(TypeBatiment.ENTREPOT);
				}
				if(repUtilisateur.equals("g")){
					jeu.deleteBatiment(TypeBatiment.EGLISE);
				}
				if(repUtilisateur.equals("p")){
					jeu.deleteBatiment(TypeBatiment.CHAMPS);
				}
				if(repUtilisateur.equals("s")){
					jeu.deleteBatiment(TypeBatiment.SCIERIE);
				}
				System.out.println(jeu);
			}
			if(repUtilisateur.equals("j")){
				
			}
			if(repUtilisateur.equals("w")){
				System.out.println("Pour echanger des ressources, appuyez sur r\n" +
								   "Pour echanger de l'or, appuyez sur o\n");
				repUtilisateur= sc.nextLine();
				
				if(repUtilisateur.equals("r")){
					System.out.println("Pour echanger 50 ressources contre 10 or, appuyez sur 1\n" +
										"Pour echanger 500 ressources contre 100 or, appuyez sur 2\n");
					repUtilisateur= sc.nextLine();
					if(repUtilisateur.equals("1")){
						jeu.marcheAccepte("r",1);
						System.out.println("Il vous reste "+jeu.getOr()+" or et "+jeu.getBois()+" ressources");
					}
					if(repUtilisateur.equals("2")){
						jeu.marcheAccepte("r",2);
						System.out.println("Il vous reste "+jeu.getOr()+" or et "+jeu.getBois()+" ressources");
					}
				}
				if(repUtilisateur.equals("o")){
					System.out.println("Pour echanger 10 or contre 50 ressources, appuyez sur 1\n" +
										"Pour echanger 100 or contre 500 ressources, appuyez sur 2\n");
					repUtilisateur= sc.nextLine();
					if(repUtilisateur.equals("1")){
						jeu.marcheAccepte("o",1);
						System.out.println("Il vous reste "+jeu.getOr()+" or et "+jeu.getBois()+" ressources");
					}
					if(repUtilisateur.equals("2")){
						jeu.marcheAccepte("o",2);
						System.out.println("Il vous reste "+jeu.getOr()+" or et "+jeu.getBois()+" ressources");
					}
				}
			}
		}
		sc.close();
	}
}
