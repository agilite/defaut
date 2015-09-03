
public abstract class Batiment {

	private static int ressourceNecessaire;
	private static int orNecessaire;
	private static int habNecessaire;
	private static int humeur;
	private static int recolteOr;
	private static int recolteNourri;
	
	
	public Batiment(int res, int or, int hab, int h, int rOr, int rNourri){
		this.ressourceNecessaire=res;
		this.orNecessaire=or;
		this.habNecessaire=hab;
		this.humeur=h;
		this.recolteOr= rOr;
		this.recolteNourri=rNourri;
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
}
