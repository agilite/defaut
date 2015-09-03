
public class Maison extends Batiment {
	
	public Maison(){
		super(25,100,20,0,0,50);
	}
	
	public String toString(){
		return "type: Champs\n ressources necessaires:\n\t ressources: 25, or: 100, habitants: 20 \n\t production journaliere:\n\t or: 50";
	}
	
	public void afficher(){
		System.out.println(this.toString());
	}
	

}
