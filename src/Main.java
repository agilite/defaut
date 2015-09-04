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
					   		   "Pour supprimer, appuyez sur d\n" +
					   		   "Pour faire un echange appuyez sur w");
			repUtilisateur= sc.nextLine();
			if(repUtilisateur.equals("c")){
				System.out.println("Pour construire une maison, appuyez sur m \t(demande: 25 bois, 25 or) \t\t\t(consommation journalière: 20 nourriture, +5 habitants)\n" +
						   		   "Pour construire une mine, appuyez sur o \t(demande: 100 bois, 50 or, 20 habitants) \t(récolte journalière: 50 or)\n" +
						   		   "Pour construire un entrepot, appuyez sur e \t(demande: 200 bois, 200 or, 5 habitants) \t(augmentation du stock: 200 nourriture)\n" +
						   		   "Pour construire une eglise, appuyez sur g \t(demande: 200 bois, 50 or, 10 habitants)\t(augmentation humeur: 100)\n" +
						   		   "Pour construire un champ, appuyez sur p \t(demande: 25 bois, 50 or, 10 habitants) \t(récolte journalière: 50 nourriture)\n" +
								   "Pour construire une scierie, appuyez sur s \t(demande: 50 bois, 50 or, 10 habitants) \t(récolte journalière: 100 bois)");

				repUtilisateur= sc.nextLine();
				
				switch (repUtilisateur){
				case "m" : jeu.addBatiment(TypeBatiment.MAISON); break;
				case "o" : jeu.addBatiment(TypeBatiment.MINE); break;
				case "e" : jeu.addBatiment(TypeBatiment.ENTREPOT); break;
				case "g" : jeu.addBatiment(TypeBatiment.EGLISE); break;
				case "p" : jeu.addBatiment(TypeBatiment.CHAMPS); break;
				case "s" : jeu.addBatiment(TypeBatiment.SCIERIE); break;
				}
				System.out.println(jeu);
			}
			if(repUtilisateur.equals("j")){
				jeu.calculJournee();
				System.out.println(jeu);
			}
			if(repUtilisateur.equals("d")){
				System.out.println("Pour detruire une maison, appuyez sur m\n" +
						   		   "Pour detruire une mine, appuyez sur o\n" +
						   		   "Pour detruire un entrepot, appuyez sur e\n" +
						   		   "Pour detruire une eglise, appuyez sur g\n" +
						   		   "Pour detruire un champ, appuyez sur p\n" +
								   "Pour detruire une scierie, appuyez sur s");
				repUtilisateur= sc.nextLine();
				switch (repUtilisateur){
				case "m" : jeu.deleteBatiment(TypeBatiment.MAISON); break;
				case "o" : jeu.deleteBatiment(TypeBatiment.MINE); break;
				case "e" : jeu.deleteBatiment(TypeBatiment.ENTREPOT); break;
				case "g" : jeu.deleteBatiment(TypeBatiment.EGLISE); break;
				case "p" : jeu.deleteBatiment(TypeBatiment.CHAMPS); break;
				case "s" : jeu.deleteBatiment(TypeBatiment.SCIERIE); break;
				}
				System.out.println(jeu);
			}
			if(repUtilisateur.equals("w")){
				System.out.println("Pour echanger contre de l'or, appuyez sur o\n" +
								   "Pour echanger contre du bois, appuyez sur b\n" +
								   "Pour echanger contre de la nourriture, appuyez sur n");
				repUtilisateur= sc.nextLine();
				
				if(repUtilisateur.equals("o")){
					System.out.println("Pour echanger 50 bois contre 10 or, appuyez sur 1\n" +
										"Pour echanger 500 bois contre 100 or, appuyez sur 2\n");
					repUtilisateur= sc.nextLine();
					switch(repUtilisateur){
					case "1" :
						jeu.marcheAccepte("o",1);
						System.out.println("Il vous reste "+jeu.getOr()+" or et "+jeu.getBois()+" bois"); break;
					case "2" :
						jeu.marcheAccepte("o",2);
						System.out.println("Il vous reste "+jeu.getOr()+" or et "+jeu.getBois()+" bois"); break;	
					}
					System.out.println(jeu);
				}
				if(repUtilisateur.equals("b")){
					System.out.println("Pour echanger 10 or contre 50 bois, appuyez sur 1\n" +
										"Pour echanger 100 or contre 500 bois, appuyez sur 2\n");
					repUtilisateur= sc.nextLine();
					switch(repUtilisateur){
					case "1" :
						jeu.marcheAccepte("b",1);
						System.out.println("Il vous reste "+jeu.getOr()+" or et "+jeu.getBois()+" bois"); break;
					case "2" :
						jeu.marcheAccepte("b",2);
						System.out.println("Il vous reste "+jeu.getOr()+" or et "+jeu.getBois()+" bois"); break;
					}
					System.out.println(jeu);
				}

				if(repUtilisateur.equals("n")){
					System.out.println("Pour echanger 50 or contre 100 nourritures, appuyez sur 1\n" +
										"Pour echanger 50 bois contre 25 nourritures, appuyez sur 2\n");
					repUtilisateur= sc.nextLine();
					switch(repUtilisateur){
					case "1" :
						jeu.marcheAccepte("n",1);
						System.out.println("Il vous reste "+jeu.getOr()+" or et "+jeu.getNourriture()+" nourritures"); break;
					case "2" :
						jeu.marcheAccepte("n",2);
						System.out.println("Il vous reste "+jeu.getBois()+" bois et "+jeu.getNourriture()+" nourritures"); break;
					}
					System.out.println(jeu);
				}
			}
		}
		sc.close();
	}
}
