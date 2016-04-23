package model.domain;

public class Categorie {
	
	private int id;
	private String den;
	
	public Categorie(int id, String den) {
		super();
		this.id = id;
		this.den = den;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDen() {
		return den;
	}

	public void setDen(String den) {
		this.den = den;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", den=" + den + "]";
	}
	
	

}
