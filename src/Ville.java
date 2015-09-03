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
	private int humeurRequise = 0;
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
		switch (type){
		case CHAMPS: new Champs(); break;
		case MAISON: new Maison(); break;
		case EGLISE: new Eglise(); break;
		case ENTREPOT: new Entrepot(); break;
		case MINE: new Mine(); break;
		case SCIERIE: new Scierie(); break;
		}
		if(bois >= Batiment.getRessourceNecessaire() && or >= Batiment.getOrNecessaire() && habitantsDispo >= Batiment.getHabNecessaire()){
			nombreBatiments.put(type, nombreBatiments.get(type)+1);
			if (type==TypeBatiment.MAISON) {
				habitants+=Batiment.getLocataires();
				habitantsDispo+=Batiment.getLocataires();
				humeurRequise+=10;
			}
			if (type==TypeBatiment.EGLISE) {
				humeur+=Batiment.getHumeur();
			}
			if (type==TypeBatiment.ENTREPOT) {
				stockNourriture+=200;
			}
			habitantsDispo-=Batiment.getHabNecessaire();
			bois-=Batiment.getRessourceNecessaire();
			or-=Batiment.getOrNecessaire();
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
	
	public void calculJournee() {
		nourriture+=nombreBatiments.get(TypeBatiment.CHAMPS)*50-nombreBatiments.get(TypeBatiment.MAISON)*50;
		bois+=nombreBatiments.get(TypeBatiment.SCIERIE)*100;
		or+=nombreBatiments.get(TypeBatiment.MINE)*50;
	}
	
	public boolean isOver() { return false; }
	
	public String toString() {
		return nom + " (" + habitantsDispo + " habitants disponibles/" + habitants + " habitants)\n" +
			   "Ressources :\n\tNourriture = " + nourriture + "/" + stockNourriture + "\n\t" +
								"Humeur = " + humeur + "/" + humeurRequise + " requis\n\t" +
								"Or = " + or + "\n\t" + 
								"Bois = " + bois + "\n" +
			   "Bâtiments :\n\tChamp(s) = " + nombreBatiments.get(TypeBatiment.CHAMPS) + "\n\t" +
			   				   "Eglise(s) = " + nombreBatiments.get(TypeBatiment.EGLISE) + "\n\t" +
			   				   "Entrepôt(s) = " + nombreBatiments.get(TypeBatiment.ENTREPOT) + "\n\t" +
			   				   "Maison(s) = " + nombreBatiments.get(TypeBatiment.MAISON) + "\n\t" +
			   				   "Scierie(s) = " + nombreBatiments.get(TypeBatiment.SCIERIE) + "\n\t" +
			   				   "Mine(s) = " + nombreBatiments.get(TypeBatiment.MINE);
	}
	
	
}

