package produit;

public abstract class Produit implements IProduit {
	private String nomP;
	protected Unite unite;
	
	
	protected Produit(String nomP, Unite unite) {
		this.nomP = nomP;
		this.unite=unite;
	}

	@Override
	public String getNomP() {
		return nomP;
	}
	@Override
	public int calculerPrix(int prix) {
        return prix;
    }
	
	
}
