package villagegaulois;

import personnages.Gaulois;
import produit.Produit;

public class Etal<P extends Produit> implements IEtal{
	private Gaulois vendeur;
	private P[] produits;
	private boolean etalOccupe = false;
	private int prixProduit=0;
	private int nbProduit;

	public boolean isEtalOccupe() {
		return etalOccupe;
	}

	public Gaulois getVendeur() {
		return vendeur;
	}

	
	public void installerVendeur(Gaulois vendeur, P[] produits, int prix) {
	    this.vendeur = vendeur;
	    this.produits = produits;
	    this.nbProduit = produits.length;
	    this.prixProduit = prix;
	    this.etalOccupe = true;
	    }
	@Override
	public int contientProduit(String produit, int quantiteSouhaitee) {
		int quantiteAVendre = 0;
		if (nbProduit != 0 && this.produits[0].getNomP().equals(produit)) {
			if (nbProduit >= quantiteSouhaitee) {
				quantiteAVendre = quantiteSouhaitee;
			} else {
				quantiteAVendre = nbProduit;
			}
		}
		return quantiteAVendre;
	}

	@Override
	public int acheterProduit(int quantiteSouhaitee) {

	    int prixTotal = 0;
	    int quantiteVendue = 0;

	    for (int i = 0; i < nbProduit && quantiteVendue < quantiteSouhaitee; i++) {

	        prixTotal += produits[i].calculerPrix(prixProduit);
	        quantiteVendue++;
	    }

	    nbProduit -= quantiteVendue;

	    return prixTotal;
	}

	@Override
	public String etatEtal() {
		StringBuilder chaine = new StringBuilder(vendeur.getNom());
		if (nbProduit > 0) {
			chaine.append(" vend ");
			chaine.append(nbProduit + " produits :");
			for (int i = 0; i < nbProduit; i++) {
				chaine.append("\n- " + produits[i].decrireProduit());
			}
		} else {
			chaine.append(" n'a plus rien à vendre.");
		}
		chaine.append("\n");
		return chaine.toString();
	}

}