package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import villagegaulois.IVillage;
public class Scenario {

	public static void main(String[] args) {
		
		IVillage village = new IVillage() {

		    private IEtal[] marche = new IEtal[3];

		    @Override
		    public <P extends Produit> boolean installerVendeur(Etal<P> etal,Gaulois vendeur, P[] produits, int prix) {

		        for (int i = 0; i < marche.length; i++) {
		            if (marche[i] == null) {
		                etal.installerVendeur(vendeur, produits, prix);
		                marche[i] = etal;
		                return true;
		            }
		        }
		        return false;
		    }

		    @Override
		    public void acheterProduit(String produit, int quantiteSouhaitee) {
		        int totalAchete = 0;

		        for (int i = 0; i < marche.length; i++) {
		            if (marche[i] != null) {

		                int dispo = marche[i].contientProduit(produit, quantiteSouhaitee - totalAchete);

		                if (dispo > 0) {
		                    int prix = marche[i].acheterProduit(dispo);

		                    System.out.println("A l'étal n° " + (i + 1)
		                            + ", j'achète " + dispo + " " + produit
		                            + " et je paye " + prix + " sous.");

		                    totalAchete += dispo;
		                }

		                if (totalAchete == quantiteSouhaitee) {
		                    break;
		                }
		            }
		        }

		        System.out.println("Je voulais " + quantiteSouhaitee + " " + produit
		                + ", j'en ai acheté " + totalAchete + ".");
		    }

		    @Override
		    public String toString() {
		        StringBuilder sb = new StringBuilder();

		        for (IEtal etal : marche) {
		            if (etal != null) {
		                sb.append(etal.etatEtal());
		            }
		        }

		        return sb.toString();
		    }
		};
		
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(200, obelix);
		Sanglier sanglier2 = new Sanglier(150, obelix);
		Sanglier sanglier3 = new Sanglier(100, asterix);
		Sanglier sanglier4 = new Sanglier(50, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		village.acheterProduit("sanglier", 3);

		System.out.println(village);
	}

}

