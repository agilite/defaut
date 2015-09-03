
public class Mine extends Batiment {
	
	public Mine(String nom){
		super(nom);
	}
	
	public String toString(){
		return "type: mine \nnom : "+this.nom;
	}
	
	public void afficher(){
		System.out.println(this.toString());
	}

}
