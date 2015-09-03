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
				System.out.println("Pour construire une maison, appuyez sur m (demande: 25 bois, 25 or)\n" +
						   		   "Pour construire une mine, appuyez sur o (demande: 100 bois, 50 or, 20 habitants)\n" +
						   		   "Pour construire un entrepot, appuyez sur e (demande: 200 bois, 200 or, 5 habitants)\n" +
						   		   "Pour construire une eglise, appuyez sur g (demande: 200 bois, 50 or, 10 habitants)\n" +
						   		   "Pour construire un champ, appuyez sur p (demande: 25 bois, 50 or, 10 habitants)\n" +
								   "Pour construire une scierie, appuyez sur s (demande: 50 bois, 50 or, 10 habitants)");
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
				System.out.println("Pour echanger contre de l'or, appuyez sur r\n" +
								   "Pour echanger contre du bois, appuyez sur o\n" +
								   "Pour echanger contre de la nourriture, appuyez sur n");
				repUtilisateur= sc.nextLine();
				
				if(repUtilisateur.equals("r")){
					System.out.println("Pour echanger 50 bois contre 10 or, appuyez sur 1\n" +
										"Pour echanger 500 bois contre 100 or, appuyez sur 2\n");
					repUtilisateur= sc.nextLine();
					if(repUtilisateur.equals("1")){
						jeu.marcheAccepte("r",1);
						System.out.println("Il vous reste "+jeu.getOr()+" or et "+jeu.getBois()+" bois");
					}
					if(repUtilisateur.equals("2")){
						jeu.marcheAccepte("r",2);
						System.out.println("Il vous reste "+jeu.getOr()+" or et "+jeu.getBois()+" bois");
					}
				}
				if(repUtilisateur.equals("o")){
					System.out.println("Pour echanger 10 or contre 50 bois, appuyez sur 1\n" +
										"Pour echanger 100 or contre 500 bois, appuyez sur 2\n");
					repUtilisateur= sc.nextLine();
					if(repUtilisateur.equals("1")){
						jeu.marcheAccepte("o",1);
						System.out.println("Il vous reste "+jeu.getOr()+" or et "+jeu.getBois()+" bois");
					}
					if(repUtilisateur.equals("2")){
						jeu.marcheAccepte("o",2);
						System.out.println("Il vous reste "+jeu.getOr()+" or et "+jeu.getBois()+" bois");
					}
				}

				if(repUtilisateur.equals("n")){
					System.out.println("Pour echanger 50 or contre 100 nourritures, appuyez sur 1\n" +
										"Pour echanger 50 bois contre 25 nourritures, appuyez sur 2\n");
					repUtilisateur= sc.nextLine();
					if(repUtilisateur.equals("1")){
						jeu.marcheAccepte("n",1);
						System.out.println("Il vous reste "+jeu.getOr()+" or et "+jeu.getNourriture()+" nourritures");
					}
					if(repUtilisateur.equals("2")){
						jeu.marcheAccepte("n",2);
						System.out.println("Il vous reste "+jeu.getBois()+" bois et "+jeu.getNourriture()+" nourritures");
					}
				}
			}
		}
		sc.close();
	}
}
