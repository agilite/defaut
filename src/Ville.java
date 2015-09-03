import java.util.HashMap;
import java.util.Map;


public class Ville {
	
	private String nom = "My little town";
	private int habitants = 0;
	private int habitantsDispo = 0;
	private int bois = 200;
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
		if (type==TypeBatiment.CHAMPS) new Champs();
		if (type==TypeBatiment.MAISON) new Maison();
		if (type==TypeBatiment.EGLISE) new Eglise();
		if (type==TypeBatiment.ENTREPOT) new Entrepot();
		if (type==TypeBatiment.MINE) new Mine();
		
		habitantsDispo-=Batiment.getHabNecessaire();
		bois-=Batiment.getRessourceNecessaire();
		or-=Batiment.getOrNecessaire();
		humeur+=Batiment.getHumeur();
		nombreBatiments.put(type, nombreBatiments.get(type)+1);
	}
	
	public String toString() {
		return nom + " (" + habitants + " habitants)" + "\n" +
			   "Ressources :\n\tNourriture = " + nourriture + "/" + stockNourriture + "\n\t" +
								"Or = " + or + "\n\t" + 
								"Bois = " + bois + "\n\t" +
								"Humeur = " + humeur + "\n" +
			   "Bâtiments :\n\tChamp(s) = " + nombreBatiments.get(TypeBatiment.CHAMPS) + "\n\t" +
			   				   "Eglise(s) = " + nombreBatiments.get(TypeBatiment.EGLISE) + "\n\t" +
			   				   "Entrepôt(s) = " + nombreBatiments.get(TypeBatiment.ENTREPOT) + "\n\t" +
			   				   "Maison(s) = " + nombreBatiments.get(TypeBatiment.MAISON) + "\n\t" +
			   				   "Mine(s) = " + nombreBatiments.get(TypeBatiment.MINE);
	}
	
	public static void main(String[] args) {
		Ville toto = new Ville("toto");
		System.out.println(toto);
		toto.addBatiment(TypeBatiment.MAISON);
		System.out.println(toto);
		toto.addBatiment(TypeBatiment.MAISON);
		System.out.println(toto);
		for (int i=0; i<10; i++) toto.addBatiment(TypeBatiment.CHAMPS);
		toto.addBatiment(TypeBatiment.ENTREPOT);
		toto.addBatiment(TypeBatiment.EGLISE);
		toto.addBatiment(TypeBatiment.MINE);
		System.out.println(toto);
	}
	
}
