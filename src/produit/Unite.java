package produit;

public enum Unite {
	GRAMME("g"),KILOGRAMME("kg"),LITRE("l"),CENTILITRE("cl"),MILLILITRE("ml"),PIECE("piece");

	private String string;

	private Unite(String string) {
		this.string=string;
	}
	
	public String toString() {
		return string;
	}

}

	
