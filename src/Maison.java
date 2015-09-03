
public class Maison extends Batiment {
	
	public Maison(String nom){
		super(nom);
	}
	
	public String toString(){
		return "type: maison \nnom : "+this.nom;
	}
	
	public void afficher(){
		System.out.println(this.toString());
	}
	

}
