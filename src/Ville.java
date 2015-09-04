import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import sun.misc.Cleaner;


public class Ville {
	
	private String nom = "My little town";
	private int habitants = 0;
	private int habitantsDispo = 0;
	private int bois = 500;
	private int nourriture = 200;
	private int or = 600;
	private int humeur = 0;
	private int humeurRequise = 0;
	private int stockNourriture = 1000; 
	private Map<TypeBatiment, Integer> nombreBatiments = new HashMap<TypeBatiment, Integer>();
	private int nbJours=0;
	
	public Ville() {
		nombreBatiments.put(TypeBatiment.CHAMPS, 0);
		nombreBatiments.put(TypeBatiment.EGLISE, 0);
		nombreBatiments.put(TypeBatiment.ENTREPOT, 0);
		nombreBatiments.put(TypeBatiment.MAISON, 0);
		nombreBatiments.put(TypeBatiment.MINE, 0);
		nombreBatiments.put(TypeBatiment.SCIERIE, 0);
		
	}
	public Ville(String nom) {
		this();
		this.nom = nom;
	}
	
	public void addBatiment(TypeBatiment type) {
		switch (type){
		case CHAMPS: new Champs(); break;
		case MAISON: new Maison(); break;
		case EGLISE: new Eglise(); break;
		case ENTREPOT: new Entrepot(); break;
		case MINE: new Mine(); break;
		case SCIERIE: new Scierie(); break;
		}
		if(bois >= Batiment.getRessourceNecessaire() && or >= Batiment.getOrNecessaire() && habitantsDispo >= Batiment.getHabNecessaire()){
			nombreBatiments.put(type, nombreBatiments.get(type)+1);
			switch(type){
			case MAISON : 
				habitants+=Batiment.getLocataires();
				habitantsDispo+=Batiment.getLocataires();
				humeurRequise+=10; break;
			case EGLISE : 
				humeur+=Batiment.getHumeur(); break;
			case ENTREPOT : 
				stockNourriture+=200; break;
			}
			habitantsDispo-=Batiment.getHabNecessaire();
			bois-=Batiment.getRessourceNecessaire();
			or-=Batiment.getOrNecessaire();
		}
		else{
			System.out.println("Construction impossible");
		}
	}
	
	public void deleteBatiment(TypeBatiment type){
		if(nombreBatiments.get(type)>=1){
			switch(type){
			case MAISON : 
				habitants-=Batiment.getLocataires(); break;
			case EGLISE : 
				humeur-=Batiment.getHumeur(); break;
			case ENTREPOT : 
				stockNourriture-=200; break;
			}
			
			habitantsDispo+=Batiment.getHabNecessaire();
			nombreBatiments.put(type, nombreBatiments.get(type)-1);
		}
		else{
			System.out.println("Aucun bâtiment n'a encore ete cree");
		}
	}
	
	public void marcheAccepte(String s,int i){
		if(s.equals("b")){
			if(i==1){
				if(or>=10){
					or-=10;
					bois+=50;
				}
				else{
					System.out.println("\t *********ECHANGE IMPOSSIBLE !************");
				}
			}
			if(i==2){
				if(or>=100){
					or-=100;
					bois+=500;
				}
				else{
					System.out.println("\t ECHANGE IMPOSSIBLE !");
				}
			}
		}
		if(s.equals("o")){
			if(i==1){
				if(bois>=50){
					bois-=50;
					or+=10;
				}
				else{
					System.out.println("Echange impossible");
				}
			}
			if(i==2){
				if(bois>=500){
					bois-=500;
					or+=100;
				}
				else{
					System.out.println("Echange impossible");
				}
			}
		}
		
		if(s.equals("n")){
			if(i==1){
				if(or>=50){
					or-=50;
					nourriture+=100;
				}
				else{
					System.out.println("Echange impossible");
				}
			}
			if(i==2){
				if(bois>=50){
					bois-=50;
					nourriture+=25;
				}
				else{
					System.out.println("Echange impossible");
				}
			}
		}
	}
	
	public void calculJournee() {
		int deltaNourriture=nombreBatiments.get(TypeBatiment.CHAMPS)*50-nombreBatiments.get(TypeBatiment.MAISON)*20;
		if (deltaNourriture>0 && nourriture<stockNourriture && nourriture+deltaNourriture>stockNourriture) nourriture=stockNourriture;
		else if (nourriture+deltaNourriture<=stockNourriture) nourriture+=deltaNourriture;
		bois+=nombreBatiments.get(TypeBatiment.SCIERIE)*100;
		or+=nombreBatiments.get(TypeBatiment.MINE)*50;
		nbJours+=1;
	}
	
	public boolean isOver() {
		boolean res=false;
		if(humeurRequise-humeur>=100) {
			res=true;
			System.out.println("\n\n\t\t\tVOUS EST DESAVOUE !!! GAME OVER...");
		}
		if(nourriture<=-100) {
			res=true;
			System.out.println("\n\n\t\t\tC'EST LA FAMINE !!! GAME OVER...");
		}
		return res;
	}
	
	
	public int getOr(){
		return this.or;
	}
	
	public int getBois(){
		return this.bois;
	}
	
	public int getNourriture(){
		return this.nourriture;
	}
	
	public int getNbJours(){
		return this.nbJours;
	}
	
	public String toString() {
		return nom + " (" + habitantsDispo + " habitants disponibles/" + habitants + " habitants) \t\t(nombre de jours "+this.getNbJours()+")\n" +
			   "Ressources :\n\tHumeur = " + humeur + "/" + humeurRequise + " requis\n\t" +
			   				   "Nourriture = " + nourriture + "/" + stockNourriture + "\n\t" + "\t(+" + nombreBatiments.get(TypeBatiment.CHAMPS)*50 + ", -" + nombreBatiments.get(TypeBatiment.MAISON)*20 + " nourriture)\n\t" +
							   "Or = " + or + "\t(+" + nombreBatiments.get(TypeBatiment.MINE)*50 + " or)\n\t" +
							   "Bois = " + bois + "\t(+" + nombreBatiments.get(TypeBatiment.SCIERIE)*100 + " bois)\n\t" +
			   "Bâtiments :\n\tChamp(s) = " + nombreBatiments.get(TypeBatiment.CHAMPS) + "\n\t" +
			   				   "Eglise(s) = " + nombreBatiments.get(TypeBatiment.EGLISE) + "\n\t" +
			   				   "Entrepôt(s) = " + nombreBatiments.get(TypeBatiment.ENTREPOT) + "\n\t" +
			   				   "Maison(s) = " + nombreBatiments.get(TypeBatiment.MAISON) + "\n\t" +
			   				   "Scierie(s) = " + nombreBatiments.get(TypeBatiment.SCIERIE) + "\n\t" +
			   				   "Mine(s) = " + nombreBatiments.get(TypeBatiment.MINE);
	}
	
	
}

