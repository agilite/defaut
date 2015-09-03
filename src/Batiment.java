
public abstract class Batiment {

	protected static int locataires;
	private static int ressourceNecessaire;
	private static int orNecessaire;
	private static int habNecessaire;
	private static int humeur;
	private static int recolteOr;
	private static int recolteNourri;
	private static int recolteRessource;
	
	public Batiment(int res, int or, int hab, int h, int rOr, int rNourri, int rRes){
		ressourceNecessaire=res;
		orNecessaire=or;
		habNecessaire=hab;
		humeur=h;
		recolteOr=rOr;
		recolteNourri=rNourri;
	}
	
	
	public String toString;
	public void afficher(){};
	
	public static int getRessourceNecessaire(){
		return ressourceNecessaire;
	}
	
	public static int getOrNecessaire(){
		return orNecessaire;
	}
	
	public static int getHabNecessaire(){
		return habNecessaire;
	}
	
	public static int getHumeur(){
		return humeur;
	}
	
	public static int getRecolteOr(){
		return recolteOr;
	}
	
	public static int getRecolteNourri(){
		return recolteNourri;
	}
	
	public static int getLocataires() {
		return locataires;
	}

	public static int getRecolteBois() {
		return recolteRessource;
	}
}
