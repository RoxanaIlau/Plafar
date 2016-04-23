package dao;

import java.util.List;

import model.domain.Articol;
import model.domain.Categorie;

public interface Dao {

	public List<Categorie> afiseazaCategorii();

	public List<Articol> afiseazaProdusDupaCategorie(String categorie);

	public List<Articol> cautaProdus(String denumire);
	
	public Articol intoarceProdus(String id);
	
	public Articol adaugaDescriere(String idOriginal);
	
	public boolean validare(String name, String pass);

}
