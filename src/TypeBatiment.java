
public enum TypeBatiment {
	
	CHAMPS (1), EGLISE (2), ENTREPOT (3), MAISON (4), MINE (5);

	private int type;
	private TypeBatiment(int n) { type = n; }
	
	public int getType() { return type; }

}
