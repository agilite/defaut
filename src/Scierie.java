
public class Scierie extends Batiment {

	public Scierie(){
		super(50,50,10,0,0,0,100);
	}
	
	public String toString(){
		return "type: Champs\n ressources necessaires:\n\t ressources: 50, or: 50 \n\t production journaliere:\n\t ressource: 100";
	}
	
	public void afficher(){
		System.out.println(this.toString());
	}
	

}
