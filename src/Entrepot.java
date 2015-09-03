
public class Entrepot extends Batiment{

	public Entrepot(String nom){
		super(nom);
	}
	
	public String toString(){
		return "type: entrepot \nnom : "+this.nom;
	}
	
	public void afficher(){
		System.out.println(this.toString());
	}
}
