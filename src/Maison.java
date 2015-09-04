
public class Maison extends Batiment {
	
	public Maison(){
		super(25,25,0,0,0,0,0,0);
		locataires=5;
	}
	
	public void afficher(){
		System.out.println(this.toString());
	}
	

}
