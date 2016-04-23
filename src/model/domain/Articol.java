package model.domain;

import java.math.BigDecimal;
import java.util.List;

public class Articol  {

	private int id;
	private String den;
	private BigDecimal pret;
	private float stoc;
	private String categorie;
	private String cale;
	private String descriere;
	private String recomandare;
	private String compozitie;
	private String substante;
	private String ci;

	public Articol(int id, String den, BigDecimal pret, float stoc, String categorie, String cale) {
		super();
		this.id = id;
		this.den = den;
		this.pret = pret;
		this.stoc = stoc;
		this.categorie = categorie;
		this.cale = cale;

	}

	// cu descriere
	public Articol(int id, String den, BigDecimal pret, float stoc, String categorie, String cale, String descriere) {
		super();
		this.id = id;
		this.den = den;
		this.pret = pret;
		this.stoc = stoc;
		this.categorie = categorie;
		this.cale = cale;
		this.descriere = descriere;
	}

	public Articol(int id, String den, BigDecimal pret, String categorie, String cale, String descriere) {
		super();
		this.id = id;
		this.den = den;
		this.pret = pret;
		this.categorie = categorie;
		this.cale = cale;
		this.descriere = descriere;
	}

	public Articol(int id, String den, BigDecimal pret, float stoc, String categorie, String cale, String descriere,
			String recomandare, String compozitie, String substante, String ci) {
		super();
		this.id = id;
		this.den = den;
		this.pret = pret;
		this.stoc = stoc;
		this.categorie = categorie;
		this.cale = cale;
		this.descriere = descriere;
		this.recomandare = recomandare;
		this.compozitie = compozitie;
		this.substante = substante;
		this.ci = ci;
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

	public BigDecimal getPret() {
		return pret;
	}

	public void setPret(BigDecimal pret) {
		this.pret = pret;
	}

	public float getStoc() {
		return stoc;
	}

	public void setStoc(float stoc) {
		this.stoc = stoc;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getCale() {
		return cale;
	}

	public void setCale(String cale) {
		this.cale = cale;
	}

	public String getDescriere() {
		return descriere;
	}

	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}

	public String getRecomandare() {
		return recomandare;
	}

	public void setRecomandare(String recomandare) {
		this.recomandare = recomandare;
	}

	public String getCompozitie() {
		return compozitie;
	}

	public void setCompozitie(String compozitie) {
		this.compozitie = compozitie;
	}

	public String getSubstante() {
		return substante;
	}

	public void setSubstante(String substante) {
		this.substante = substante;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	@Override
	public String toString() {
		return "Articol [id=" + id + ", den=" + den + ", pret=" + pret + ", stoc=" + stoc + ", categorie=" + categorie
				+ ", cale=" + cale + ", descriere=" + descriere + ", recomandare=" + recomandare + ", compozitie="
				+ compozitie + ", substante=" + substante + ", ci=" + ci + "]";
	}

	
}
