/*import java.util.Scanner;


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
					   		   "Pour supprimer, appuyez sur s");
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
		}
		sc.close();
	}
}*/
