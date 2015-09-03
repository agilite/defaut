
public class Entrepot extends Batiment{

	public Entrepot(){
		super(200,200,5,0,0,0);
	}
	
	public String toString(){
		return "type: Champs\n ressources necessaires:\n\t ressources: 200, or: 200, habitants: 5 \n\t augmentation du stock ressource: 200";
	}
	
	public void afficher(){
		System.out.println(this.toString());
	}
}
