import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		String repUtilisateur;
		
		System.out.println("Bienvenue dans Town of Glory \nNom de la ville:");
		repUtilisateur= sc.nextLine();
		
		
		Ville jeu = new Ville(repUtilisateur);
		System.out.println(jeu);
		System.out.println("\nPour construire appuyer sur c \nPour passez la journée appuyez sur j \nPour supprimer appuyez sur s");
		repUtilisateur= sc.nextLine();
		if(repUtilisateur.equals("c")){
			System.out.println("Pour construire une maison appuyez sur m \nPour construire une mine appuyez sur o \nPour construire un entrepot appuyez sur e \nPour construire une eglise appuyez sur g \nPour construire un champs appuyez sur p");
			repUtilisateur= sc.nextLine();
			if(repUtilisateur.equals("m")){
				jeu.addBatiment(TypeBatiment.MAISON);
				System.out.println(jeu);
			}
			if(repUtilisateur.equals("o")){
				jeu.addBatiment(TypeBatiment.MINE);
				System.out.println(jeu);
			}
			if(repUtilisateur.equals("e")){
				jeu.addBatiment(TypeBatiment.ENTREPOT);
				System.out.println(jeu);
			}
			if(repUtilisateur.equals("g")){
				jeu.addBatiment(TypeBatiment.EGLISE);
				System.out.println(jeu);
			}
			if(repUtilisateur.equals("p")){
				jeu.addBatiment(TypeBatiment.CHAMPS);
				System.out.println(jeu);
			}
		}
	}
}
