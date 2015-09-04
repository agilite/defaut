import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Ville {
	
	private String nom = "My little town";
	private int habitants = 0;
	private int habitantsDispo = 0;
	private int bois = 500;
	private int nourriture = 200;
	private int alcool = 0;
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
		nombreBatiments.put(TypeBatiment.TAVERNE, 0);
		
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
		case TAVERNE: new Taverne(); break;
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
			System.out.println("\n\t CONSTRUCTION IMPOSSIBLE !");
		}
	}
	
	public void deleteBatiment(TypeBatiment type){
		if(nombreBatiments.get(type)>0){
			boolean test=true;
			switch(type){
			case MAISON :
				new Maison();
				if (habitantsDispo<5) {
					System.out.println("\n\t Vous ne pouvez pas détruire de maison, sous peine de manquer de main d'oeuvre !");
					test=false;
				}
				else {
					habitants-=Batiment.getLocataires();
					habitantsDispo-=Batiment.getLocataires();
					humeurRequise-=10;
				}
				break;
			case EGLISE :
				new Eglise();
				humeur-=Batiment.getHumeur(); break;
			case ENTREPOT :
				new Entrepot();
				stockNourriture-=200; break;
			}
			if (test) {
				habitantsDispo+=Batiment.getHabNecessaire();
				nombreBatiments.put(type, nombreBatiments.get(type)-1);
			}
		}
		else{
			System.out.println("\n\t BATIMENT INEXISTANT !");
		}
	}
	
	public void marcheAccepte(String s,int i){
		if(s.equals("o")){
			if(i==1){
				if(bois>=50){
					bois-=50; or+=10;
				}
				else System.out.println("\n\t ECHANGE IMPOSSIBLE !");
			}
			if(i==2){
				if(alcool>=5){
					alcool-=5; or+=100;
				}
				else System.out.println("\n\t ECHANGE IMPOSSIBLE !");
			}
			if(i==3){
				if(nourriture>=500){
					nourriture-=500; or+=100;
				}
				else System.out.println("\n\t ECHANGE IMPOSSIBLE !");
			}
		}
		else if(s.equals("b")){
			if(i==1){
				if(or>=10){
					or-=10; bois+=500;
				}
				else System.out.println("\n\t ECHANGE IMPOSSIBLE !");
			}
			if(i==2){
				if(alcool>=10){
					alcool-=10; bois+=500;
				}
				else System.out.println("\n\t ECHANGE IMPOSSIBLE !");
			}
			if(i==3){
				if(nourriture>=10){
					nourriture-=10; bois+=40;
				}
				else System.out.println("\n\t ECHANGE IMPOSSIBLE !");
			}
		}
		else if(s.equals("n")){
			if(i==1){
				if(or>=50){
					or-=50; nourriture+=100;
				}
				else System.out.println("\n\t ECHANGE IMPOSSIBLE !");
			}
			if(i==2){
				if(alcool>=10){
					alcool-=10; nourriture+=100;
				}
				else System.out.println("\n\t ECHANGE IMPOSSIBLE !");
			}
			if(i==3){
				if(bois>=100){
					bois-=100; nourriture+=25;
				}
				else System.out.println("\n\t ECHANGE IMPOSSIBLE !");
			}
		}
		else if(s.equals("a")){
			if(i==1){
				if(bois>=500){
					bois-=500; alcool+=10;
				}
				else System.out.println("\n\t ECHANGE IMPOSSIBLE !");
			}
			if(i==2){
				if(or>=200){
					or+=200; alcool+=10;
				}
				else System.out.println("\n\t ECHANGE IMPOSSIBLE !");
			}
			if(i==3){
				if(nourriture>=250){
					nourriture-=250; alcool+=10;
				}
				else System.out.println("\n\t ECHANGE IMPOSSIBLE !");
			}
		}
	}
	
	public void calculJournee() {
		Random r = new Random();
		int rand = r.nextInt(100);
		int deltaNourriture=nombreBatiments.get(TypeBatiment.CHAMPS)*50-nombreBatiments.get(TypeBatiment.MAISON)*20;
		if (deltaNourriture>0 && nourriture<stockNourriture && nourriture+deltaNourriture>stockNourriture) nourriture=stockNourriture;
		else if (nourriture+deltaNourriture<=stockNourriture){
			nourriture+=deltaNourriture;
		}
		alcool+=nombreBatiments.get(TypeBatiment.TAVERNE)*5;
		if(alcool >= nombreBatiments.get(TypeBatiment.MAISON)*2){
			alcool-=nombreBatiments.get(TypeBatiment.MAISON)*2;
			humeur+=alcool*2;
		}
		bois+=nombreBatiments.get(TypeBatiment.SCIERIE)*100;
		or+=nombreBatiments.get(TypeBatiment.MINE)*50;
		nbJours+=1;
		switch (rand%99) {
		case 0 :
			if( nombreBatiments.get(TypeBatiment.MAISON)>0 && habitantsDispo>5){
			System.out.println("\n\n\t\t\t *****   ALERTE !!!!  ***** \n\t\t UN INCENDIE A DETRUIT UN BATIMENT DU VILLAGE \n\t\t\t\t (- 1 maison)");
			deleteBatiment(TypeBatiment.MAISON);}
			break;

		case 1:
			if(nombreBatiments.get(TypeBatiment.EGLISE)>0){
				System.out.println("\n\n\t\t\t *****   ALERTE !!!!  ***** \n\t\t UN INCENDIE A DETRUIT UN BATIMENT DU VILLAGE \n\t\t\t\t (- 1 eglise)");
				deleteBatiment(TypeBatiment.EGLISE);
			}
			break;
		case 2:
			if(nombreBatiments.get(TypeBatiment.TAVERNE)>0){
				System.out.println("\n\n\t\t\t *****   ALERTE !!!!  ***** \n\t\t UN INCENDIE A DETRUIT UN BATIMENT DU VILLAGE \n\t\t\t\t (- 1 taverne)");
				deleteBatiment(TypeBatiment.TAVERNE);
			}
			break;
		case 3:
			if(nombreBatiments.get(TypeBatiment.MINE)>0){
				System.out.println("\n\n\t\t\t *****   ALERTE !!!!  ***** \n\t\t VOTRE MINE D'OR A DECOUVERT UN DIAMANT \n\t\t\t\t (+ 100 or)");
				or+=100;
			}
			break;
		case 4:
			if(nombreBatiments.get(TypeBatiment.CHAMPS)>0){
				System.out.println("\n\n\t\t\t *****   ALERTE !!!!  ***** \n\t\t LA RECOLTE DE NOURRITURE A ETE BONNE \n\t\t\t\t (+ 100 de nourriture)");
				nourriture+=100;
			}
			break;
			
		case 5:
		if(nombreBatiments.get(TypeBatiment.SCIERIE)>0){
			System.out.println("\n\n\t\t\t *****   ALERTE !!!!  ***** \n\t\t LES BUCHERONS ONT BIEN TRAVAILLÉ \n\t\t\t\t (+ 100 de bois)");
			bois+=100;
			}
			break;
		}
	}
	
	public boolean isOver() {
		boolean res=false;
		if(humeurRequise-humeur>=100) {
			res=true;
			System.out.println("\n\n\t\t\tVOUS ETES DESAVOUE !!! GAME OVER...");
		}
		if(nourriture<=-100) {
			res=true;
			System.out.println("\n\n\t\t\tC'EST LA FAMINE !!! GAME OVER...");
		}
		return res;
	}
	
	public boolean revolte(){
		boolean res=false;
		if(humeurRequise-humeur>=75){
			res=true;
			if(nombreBatiments.get(TypeBatiment.CHAMPS)!=0){
				deleteBatiment(TypeBatiment.CHAMPS);
				System.out.println("\n\n\t\t\t VOS CITOYENS NE SONT PAS CONTENTS !!!!! ILS ATTAQUENT VOS CHAMPS (Vous avez perdu 1 champ");}
			else{
				System.out.println("\n\n\t\t\t VOS CITOYENS NE SONT PAS CONTENTS !!!!!");
			}
		}
		if(nourriture<=-80){
			res=true;
			if(nombreBatiments.get(TypeBatiment.ENTREPOT)!=0){
				nombreBatiments.put(TypeBatiment.ENTREPOT, nombreBatiments.get(TypeBatiment.ENTREPOT)-1);
				System.out.println("\n\n\t\t\t VOS CITOYENS ONT FAIM !!! ILS ATTAQUENT VOS ENTREPOTS (Vous avez perdu 1 entrepot)");}
			else{
				System.out.println("\n\n\t\t\t VOS CITOYENS ONT FAIM !!!");
			}
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
	
	public int getAlcool(){
		return this.alcool;
	}
	
	public int getNbJours(){
		return this.nbJours;
	}
	
	public String toString() {
		String s="";
		if(nombreBatiments.get(TypeBatiment.CHAMPS)*50-nombreBatiments.get(TypeBatiment.MAISON)*20>=0){
			s="+";
		}
		return "\n\n\n" + nom + " (" + habitantsDispo + " habitants disponibles/" + habitants + " habitants) \t\t(nombre de jours "+this.getNbJours()+")\n" +
			   "Ressources :\n\tHumeur = " + humeur + "/" + humeurRequise + " requis\n\t" +
			   				   "Nourriture = " + nourriture + "/" + stockNourriture + "\t(" + s + (nombreBatiments.get(TypeBatiment.CHAMPS)*50-nombreBatiments.get(TypeBatiment.MAISON)*20) + " nourriture)\n\t" +
			   				   "Alcool = " + alcool + "\t\t(+" + nombreBatiments.get(TypeBatiment.TAVERNE)*5 + " alcool)\n\t" +
							   "Or = " + or + "\t\t(+" + nombreBatiments.get(TypeBatiment.MINE)*50 + " or)\n\t" +
							   "Bois = " + bois + "\t\t(+" + nombreBatiments.get(TypeBatiment.SCIERIE)*100 + " bois)\n" +
			   "Bâtiments :\n\tChamp(s) = " + nombreBatiments.get(TypeBatiment.CHAMPS) + "\n\t" +
			   				   "Eglise(s) = " + nombreBatiments.get(TypeBatiment.EGLISE) + "\n\t" +
			   				   "Entrepôt(s) = " + nombreBatiments.get(TypeBatiment.ENTREPOT) + "\n\t" +
			   				   "Maison(s) = " + nombreBatiments.get(TypeBatiment.MAISON) + "\n\t" +
			   				   "Scierie(s) = " + nombreBatiments.get(TypeBatiment.SCIERIE) + "\n\t" +
			   				   "Mine(s) = " + nombreBatiments.get(TypeBatiment.MINE) + "\n\t" +
							   "Taverne(s) = " + nombreBatiments.get(TypeBatiment.TAVERNE);
	}
	
	
}

