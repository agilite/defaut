
public class Champs extends Batiment {
	
	public Champs(String nom){
		super(nom);
	}
	
	public String toString(){
		return "type: champs \nnom : "+this.nom;
	}
	
	public void afficher(){
		System.out.println(this.toString());
	}
}
