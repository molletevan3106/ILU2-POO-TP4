package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	private int poids;
	private Gaulois chasseur;
	public Sanglier(int poids,Gaulois chasseur) {
		super("sanglier",Unite.KILOGRAMME);
		this.chasseur=chasseur;
		this.poids=poids;
		
	}
	
	@Override
	public String decrireProduit() {
		return "sanglier de "+poids+" "+unite.toString()+" chassé par "+chasseur.getNom()+".";
		
	}
	@Override
	public int calculerPrix(int prix) {
	    return (poids * prix) / 100; 
	}
	

}
