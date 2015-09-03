
public class Eglise extends Batiment {
	
	public Eglise(String nom){
		super(nom);
	}
	
	public String toString(){
		return "type: eglise \nnom : "+this.nom;
	}
	
	public void afficher(){
		System.out.println(this.toString());
	}

}
