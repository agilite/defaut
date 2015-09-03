import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Ville {
	
	private String nom = "My little town";
	private int habitants = 0;
	@SuppressWarnings("unused")
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
		nombreBatiments.put(TypeBatiment.SCIERIE, 0);
		
	}
	public Ville(String nom) {
		this();
		this.nom = nom;
	}
	
	public void addBatiment(TypeBatiment type) {
		if(bois >= Batiment.getRessourceNecessaire() && or >= Batiment.getOrNecessaire() && habitantsDispo >= Batiment.getHabNecessaire()){
			if (type==TypeBatiment.CHAMPS) new Champs();
			if (type==TypeBatiment.MAISON) {
				new Maison();
				habitants+=Batiment.getLocataires();
			}
			if (type==TypeBatiment.EGLISE) {
				new Eglise();
				humeur+=Batiment.getHumeur();
			}
			if (type==TypeBatiment.ENTREPOT) {
				new Entrepot();
				stockNourriture+=200;
			}
			if (type==TypeBatiment.MINE) new Mine();
			if (type==TypeBatiment.SCIERIE) new Scierie();
	
			habitantsDispo-=Batiment.getHabNecessaire();
			bois-=Batiment.getRessourceNecessaire();
			or-=Batiment.getOrNecessaire();
			nombreBatiments.put(type, nombreBatiments.get(type)+1);
		}
		else{
			System.out.println("Construction impossible");
		}
	}
	
	public void deleteBatiment(TypeBatiment type){
		if(type==TypeBatiment.MAISON){
			habitants-=Batiment.getLocataires();
		}
		if(type==TypeBatiment.EGLISE){
			humeur-=Batiment.getHumeur();
		}
		if(type==TypeBatiment.ENTREPOT){
			stockNourriture-=200;
		}
		
		habitantsDispo+=Batiment.getHabNecessaire();
		nombreBatiments.put(type, nombreBatiments.get(type)-1);
	}
	
	public boolean isOver() { return false; }
	
	public String toString() {
		return nom + " (" + habitants + " habitants disponibles)" + "\n" +
			   "Ressources :\n\tNourriture = " + nourriture + "/" + stockNourriture + "\n\t" +
								"Or = " + or + "\n\t" + 
								"Bois = " + bois + "\n\t" +
								"Humeur = " + humeur + "\n" +
			   "Bâtiments :\n\tChamp(s) = " + nombreBatiments.get(TypeBatiment.CHAMPS) + "\n\t" +
			   				   "Eglise(s) = " + nombreBatiments.get(TypeBatiment.EGLISE) + "\n\t" +
			   				   "Entrepôt(s) = " + nombreBatiments.get(TypeBatiment.ENTREPOT) + "\n\t" +
			   				   "Maison(s) = " + nombreBatiments.get(TypeBatiment.MAISON) + "\n\t" +
			   				   "Scierie(s) = " + nombreBatiments.get(TypeBatiment.SCIERIE) + "\n\t" +
			   				   "Mine(s) = " + nombreBatiments.get(TypeBatiment.MINE);
	}
	
	
}

