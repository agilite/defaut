
public abstract class Batiment {

	private int ressourceNecessaire;
	private int orNecessaire;
	private int habNecessaire;
	private int humeur;
	private int recolteOr;
	private int recolteNourri;
	
	
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
	
	public int getRessourceNecessaire(){
		return this.ressourceNecessaire;
	}
	
	public int getOrNecessaire(){
		return this.orNecessaire;
	}
	
	public int getHabNecessaire(){
		return this.habNecessaire;
	}
	
	public int getHumeur(){
		return this.humeur;
	}
	
	public int getRecolteOr(){
		return this.recolteOr;
	}
	
	public int getRecolteNourri(){
		return this.recolteNourri;
	}
}
