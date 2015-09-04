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
					   		   "Pour detruire, appuyez sur d\n" +
					   		   "Pour faire un echange appuyez sur w");
			repUtilisateur= sc.nextLine();
			
			if(repUtilisateur.equals("c")){
				System.out.println("Pour construire une maison, appuyez sur m \t(demande: 25 bois, 25 or) \t\t\t(consommation journalière: 20 nourriture, +5 habitants)\n" +
						   		   "Pour construire une mine, appuyez sur o \t(demande: 100 bois, 50 or, 10 habitants) \t(récolte journalière: 50 or)\n" +
						   		   "Pour construire un entrepot, appuyez sur e \t(demande: 200 bois, 200 or, 5 habitants) \t(augmentation du stock: 200 nourriture)\n" +
						   		   "Pour construire une eglise, appuyez sur g \t(demande: 200 bois, 50 or, 6 habitants)\t(augmentation humeur: 100)\n" +
						   		   "Pour construire un champ, appuyez sur p \t(demande: 25 bois, 50 or, 10 habitants) \t(récolte journalière: 50 nourriture)\n" +
								   "Pour construire une scierie, appuyez sur s \t(demande: 50 bois, 50 or, 10 habitants) \t(récolte journalière: 100 bois)\n" +
								   "Pour construire une taverne, appuyez sur t \t(demande: 100 bois, 100 or, 5 habitants) \t(récolte journalière: 5 alcool)");

				repUtilisateur= sc.nextLine();
				
				switch (repUtilisateur){
				case "m" : jeu.addBatiment(TypeBatiment.MAISON); break;
				case "o" : jeu.addBatiment(TypeBatiment.MINE); break;
				case "e" : jeu.addBatiment(TypeBatiment.ENTREPOT); break;
				case "g" : jeu.addBatiment(TypeBatiment.EGLISE); break;
				case "p" : jeu.addBatiment(TypeBatiment.CHAMPS); break;
				case "s" : jeu.addBatiment(TypeBatiment.SCIERIE); break;
				case "t" : jeu.addBatiment(TypeBatiment.TAVERNE); break;
				}
				System.out.println(jeu);
			}
			
			if(repUtilisateur.equals("j")){
				System.out.println("                     \\       /  \n" +
						"                       .-'-.       \n" +
						"                  --  /     \\  --      \n" +
						" `~~^~^~^~^~^~^~^~^~^-=======-~^~^~^~~^~^~^~^~^~^~^~` \n" +
						" `~^_~^~^~-~^_~^~^_~-=========- -~^~^~^-~^~^_~^~^~^~`\n" +
						" `~^~-~~^~^~-^~^_~^~~ -=====- ~^~^~-~^~_~^~^~~^~-~^~`\n" +
						" `~^~^~-~^~~^~-~^~~-~^~^~-~^~~^-~^~^~^-~^~^~^~^~~^~-` \n\n" +
						"\t\t ET LE VILLAGE S'ENDORT...");
				jeu.calculJournee();
				jeu.revolte();
				System.out.println(jeu);
			}
			
			if(repUtilisateur.equals("d")){
				System.out.println("Pour detruire une maison, appuyez sur m\n" +
						   		   "Pour detruire une mine, appuyez sur o\n" +
						   		   "Pour detruire un entrepot, appuyez sur e\n" +
						   		   "Pour detruire une eglise, appuyez sur g\n" +
						   		   "Pour detruire un champ, appuyez sur p\n" +
								   "Pour detruire une scierie, appuyez sur s\n" +
								   "Pour detruire une taverne, appuyez sur t");
				repUtilisateur= sc.nextLine();
				switch (repUtilisateur){
				case "m" : jeu.deleteBatiment(TypeBatiment.MAISON); break;
				case "o" : jeu.deleteBatiment(TypeBatiment.MINE); break;
				case "e" : jeu.deleteBatiment(TypeBatiment.ENTREPOT); break;
				case "g" : jeu.deleteBatiment(TypeBatiment.EGLISE); break;
				case "p" : jeu.deleteBatiment(TypeBatiment.CHAMPS); break;
				case "s" : jeu.deleteBatiment(TypeBatiment.SCIERIE); break;
				case "t" : jeu.deleteBatiment(TypeBatiment.TAVERNE); break;
				}
				System.out.println(jeu);
			}
			
			if(repUtilisateur.equals("w")){
				System.out.println("Pour echanger des ressources contre de l'or, appuyez sur o\n" +
								   "Pour echanger des ressources contre du bois, appuyez sur b\n" +
								   "Pour echanger des ressources contre de la nourriture, appuyez sur n\n" +
								   "Pour echanger des ressources contre de l'alcool, appuyez sur a");
				
				repUtilisateur= sc.nextLine();
				
				switch(repUtilisateur){
				case "o" :
					System.out.println("Pour echanger 50 bois contre 10 or, appuyez sur 1\n" +
										"Pour echanger 5 alcools contre 100 or, appuyez sur 2\n" +
										"Pour echanger 500 nourritures contre 100 or, appuyez sur 3\n");
					repUtilisateur= sc.nextLine();
					
					switch(repUtilisateur){
					case "1" :
						jeu.marcheAccepte("o",1);
						System.out.println("Il vous reste "+jeu.getOr()+" or et "+jeu.getBois()+" bois"); break;
					case "2" :
						jeu.marcheAccepte("o",2);
						System.out.println("Il vous reste "+jeu.getOr()+" or et "+jeu.getAlcool()+" alcools"); break;	
					case "3" :
						jeu.marcheAccepte("o",3);
						System.out.println("Il vous reste "+jeu.getOr()+" or et "+jeu.getNourriture()+" nourritures"); break;	
					}
					System.out.println(jeu); break;
				case "b" :
					System.out.println("Pour echanger 10 or contre 500 bois, appuyez sur 1\n" +
										"Pour echanger 10 alcools contre 500 bois, appuyez sur 2\n" +
										"Pour echanger 10 nourritures contre 40 bois, appuyez sur 3\n");
					repUtilisateur= sc.nextLine();
					
					switch(repUtilisateur){
					case "1" :
						jeu.marcheAccepte("b",1);
						System.out.println("Il vous reste "+jeu.getBois()+" bois et "+jeu.getOr()+" or"); break;
					case "2" :
						jeu.marcheAccepte("b",2);
						System.out.println("Il vous reste "+jeu.getBois()+" bois et "+jeu.getAlcool()+" alcools"); break;
					case "3" :
						jeu.marcheAccepte("b",3);
						System.out.println("Il vous reste "+jeu.getBois()+" bois et "+jeu.getNourriture()+" nourritures"); break;	
					}
					System.out.println(jeu); break;

				case "n" :
					System.out.println("Pour echanger 50 or contre 100 nourritures, appuyez sur 1\n" +
										"Pour echanger 10 alcools contre 100 nourritures, appuyez sur 2\n" +
										"Pour echanger 100 bois contre 25 nourritures, appuyez sur 3\n");
					repUtilisateur= sc.nextLine();
					
					switch(repUtilisateur){
					case "1" :
						jeu.marcheAccepte("n",1);
						System.out.println("Il vous reste "+jeu.getNourriture()+" nourritures et "+jeu.getOr()+" or"); break;
					case "2" :
						jeu.marcheAccepte("n",2);
						System.out.println("Il vous reste "+jeu.getNourriture()+" nourritures et "+jeu.getAlcool()+" alcools"); break;
					case "3" :
						jeu.marcheAccepte("n",3);
						System.out.println("Il vous reste "+jeu.getNourriture()+" nourritures et "+jeu.getBois()+" bois"); break;
					}
					System.out.println(jeu); break;
					
				case "a" :
					System.out.println("Pour echanger 500 bois contre 10 alcools, appuyez sur 1\n" +
										"Pour echanger 200 or contre 10 alcools, appuyez sur 2\n" +
										"Pour echanger 250 nourritures contre 10 alcools, appuyez sur 3\n");
					repUtilisateur= sc.nextLine();
					
					switch(repUtilisateur){
					case "1" :
						jeu.marcheAccepte("a",1);
						System.out.println("Il vous reste "+jeu.getAlcool()+" alcools et "+jeu.getBois()+" bois"); break;
					case "2" :
						jeu.marcheAccepte("a",2);
						System.out.println("Il vous reste "+jeu.getAlcool()+" alcools et "+jeu.getOr()+" or"); break;	
					case "3" :
						jeu.marcheAccepte("a",3);
						System.out.println("Il vous reste "+jeu.getAlcool()+" alcools et "+jeu.getNourriture()+" nourritures"); break;	
					}
					System.out.println(jeu); break;
				}
			}
		}
		sc.close();
	}
}
