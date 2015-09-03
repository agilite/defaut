
public class Eglise extends Batiment {
	
	public Eglise(){
		super(200,50,6,100,0,0,0);
	}
	
	public String toString(){
		return "type: Champs\n ressources necessaires:\n\t ressources: 200, or: 50, habitants: 10 \n\t augmentation humeur: 100";
	}
	
	public void afficher(){
		System.out.println(this.toString());
	}

}
