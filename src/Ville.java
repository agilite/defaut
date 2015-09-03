import java.util.HashMap;
import java.util.Map;


public class Ville {
	
	private String nom = "My little town";
	private int habitants = 0;
	private int nourriture = 200;
	private int or = 300;
	private int humeur = 0;
	private int stockNourriture = 1000; 
	private Map<TypeBatiment, Integer> nombreBatiments = new HashMap<TypeBatiment, Integer>();
	
	public Ville() {
		nombreBatiments.put(TypeBatiment.CHAMPS, 0);
		nombreBatiments.put(TypeBatiment.EGLISE, 0);
		nombreBatiments.put(TypeBatiment.ENTREPOT, 0);
		nombreBatiments.put(TypeBatiment.MAISON, 0);
		nombreBatiments.put(TypeBatiment.MINE, 0);
		
	}
	public Ville(String nom) {
		this();
		this.nom = nom;
	}
	
	public void addBatiment(TypeBatiment type) {
		nombreBatiments.put(type, nombreBatiments.get(type)+1);
	}
	
	public String toString() {
		return nom + " (" + habitants + " habitants)" + "\n" +
			   "Ressources :\n\tNourriture = " + nourriture + "/" + stockNourriture + "\n\t" +
								"Or = " + or + "\n\t" + 
								"Humeur = " + humeur + "\n" +
			   "Bâtiments :\n\tChamps = " + nombreBatiments.get(TypeBatiment.CHAMPS) + "\n\t" +
			   				   "Eglises = " + nombreBatiments.get(TypeBatiment.EGLISE) + "\n\t" +
			   				   "Entrepôts = " + nombreBatiments.get(TypeBatiment.ENTREPOT) + "\n\t" +
			   				   "Maisons = " + nombreBatiments.get(TypeBatiment.MAISON) + "\n\t" +
			   				   "Mines = " + nombreBatiments.get(TypeBatiment.MINE);
	}
	
	public static void main(String[] args) {
		Ville toto = new Ville("toto");
		System.out.println(toto);
		toto.addBatiment(TypeBatiment.MAISON);
		System.out.println(toto);
		toto.addBatiment(TypeBatiment.MAISON);
		System.out.println(toto);
	}
	
}
