
public class Eglise extends Batiment {
	
	public Eglise(){
		super(200,50,10,100,0,0,0);
	}
	
	public String toString(){
		return "type: Champs\n ressources necessaires:\n\t bois: 200, or: 50, habitants: 10 \n\t augmentation humeur: 100";
	}
	
	public void afficher(){
		System.out.println(this.toString());
	}

}
