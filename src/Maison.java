
public class Maison extends Batiment {
	
	public Maison(){
		super(25,25,0,0,0,0,0);
		locataires=5;
		consommationNourri=50;
	}
	
	public String toString(){
		return "type: Champs\n ressources necessaires:\n\t bois: 25, or: 25 \n\t production journaliere:\n\t or: 10";
	}
	
	public void afficher(){
		System.out.println(this.toString());
	}
	

}
