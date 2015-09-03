
public class Scierie extends Batiment {

	public Scierie(){
		super(150,150,10,0,0,0,100);
	}
	
	public String toString(){
		return "type: Champs\n ressources necessaires:\n\t bois: 50, or: 50 \n\t production journaliere:\n\t bois: 100";
	}
	
	public void afficher(){
		System.out.println(this.toString());
	}
	

}
