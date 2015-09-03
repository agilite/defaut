
public class Champs extends Batiment {
	
	public Champs(){
		super(25,50,10,0,0,50,0);
	}
	
	public String toString(){
		return "type: Champs\n ressources necessaires:\n\t bois: 25, or: 50, habitants: 10 \n\t production journaliere:\n\t Nourriture: 50";
	}
	
	public void afficher(){
		System.out.println(this.toString());
	}
	
	
}
