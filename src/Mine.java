
public class Mine extends Batiment {
	
	public Mine(){
		super(100,50,20,0,50,0,0);
	}
	
	public String toString(){
		return "type: Champs\n ressources necessaires:\n\t ressources: 100, or: 50, habitants: 20 \n\t production journaliere:\n\t or: 50";
	}
	
	public void afficher(){
		System.out.println(this.toString());
	}

}
