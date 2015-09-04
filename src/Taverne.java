
public class Taverne extends Batiment {
	
	public Taverne(){
		super(100,100,5,0,0,0,0,0);
	}
	
	public String toString(){
		return "type: Champs\n ressources necessaires:\n\t bois: 25, or: 50, habitants: 10 \n\t production journaliere:\n\t Nourriture: 50";
	}
	
	public void afficher(){
		System.out.println(this.toString());
	}

}
