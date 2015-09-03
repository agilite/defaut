

public class Maison extends Batiment {
	int nbHab=4;
	
	public Maison(int cout){
		super(cout);
		
	}
	public String toString(){
		return "La maison possède "+nbHab+" habitants et coute "+cout+" ressources";
		
	}
	

	

}