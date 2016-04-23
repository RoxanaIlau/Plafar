package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.domain.Articol;
import model.domain.Categorie;

public class DaoImpl implements Dao {

	private Connection conexiune; // pachetul java.sql
	private Statement statement; // pachetul java.sql
	private PreparedStatement preparedStatement; // pachetul java.sql
	private ResultSet resultSet;

	private void creazaConexiuneaLaDB() {
		try {

			Class driver = Class.forName("com.mysql.jdbc.Driver");

			conexiune = DriverManager.getConnection("jdbc:mysql://127.0.0.1/plafar", "root", "");

			// Connection este o interfata din pachetul java.sql.
			// System.out.println(conexiune.getClass());
			// com.mysql.jdbc.JDBC4Connection

		} catch (ClassNotFoundException e) {
			System.out.println("Nu s-a gasit clasa Driver");
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("Nu s-a putut crea conexiunea la baza de date.");
			e.printStackTrace();
		}

	}

	private void inchideResursele() {

		if (conexiune != null) {
			try {
				conexiune.close();
			} catch (SQLException e) {
				System.out.println("Am incercat sa inchid conexiunea dar nu am reusit.");
				e.printStackTrace();
			}
		}

		if (statement != null) {

			try {
				statement.close();
			} catch (SQLException e) {
				System.out.println("Am incercat sa inchid statementul dar nu am reusit");
				e.printStackTrace();
			}
		}

		if (preparedStatement != null) {

			try {
				preparedStatement.close();
			} catch (SQLException e) {
				System.out.println("Am incercat sa inchid prepared-statementul dar nu am reusit");
				e.printStackTrace();
			}
		}

		if (resultSet != null) {

			try {
				resultSet.close();
			} catch (SQLException e) {
				System.out.println("Am incercat sa inchid ResultSetul dar nu am reusit.");
				e.printStackTrace();
			}

		}

	}

	@Override
	public List<Articol> afiseazaProdusDupaCategorie(String categorie) {

		creazaConexiuneaLaDB();

		try {

			if (categorie == "0") {

				String sql = "SELECT produs.id, produs.den, pret, stoc, categorie.den, cale, descriere "
						+ " FROM produs,categorie WHERE categorie.id = produs.categorie_id";
				statement = conexiune.createStatement();
				resultSet = statement.executeQuery(sql);
			} else {

				String sql = "SELECT produs.id, produs.den, produs.pret, produs.stoc, categorie.den, produs.cale, produs.descriere "
						+ " FROM produs,categorie WHERE categorie.id = produs.categorie_id AND categorie.id = ?;";

				preparedStatement = conexiune.prepareStatement(sql);
				preparedStatement.setString(1, categorie);

				resultSet = preparedStatement.executeQuery();
			}

			List<Articol> produse = new ArrayList<Articol>();

			while (resultSet.next()) {

				int id = resultSet.getInt("produs.id");
				String den = resultSet.getString("produs.den");
				BigDecimal pret = resultSet.getBigDecimal("pret");
				float stoc = resultSet.getFloat("stoc");
				String categ = resultSet.getString("categorie.den");
				String cale = resultSet.getString("cale");
				String descriere = resultSet.getString("descriere");

				produse.add(new Articol(id, den, pret, stoc, categ, cale, descriere));

			}

			return produse;

		} catch (SQLException e) {

			System.out.println("Nu s-a putut crea statementul sau " + "nu s-a executat query-ul.");
			e.printStackTrace();

			return null;

		} finally {

			inchideResursele();
		}

	}

	public List<Articol> cautaProdus(String denumire) {

		creazaConexiuneaLaDB();

		try {
			String newDen = ("%" + denumire + "%");

			String sql = "SELECT produs.id, produs.den, pret, stoc, categorie.den, cale, descriere "
					+ " FROM produs,categorie WHERE categorie.id = produs.categorie_id AND produs.den LIKE ?;";

			preparedStatement = conexiune.prepareStatement(sql);
			preparedStatement.setString(1, newDen);

			resultSet = preparedStatement.executeQuery();

			List<Articol> produse = new ArrayList<Articol>();

			while (resultSet.next()) {

				int id = resultSet.getInt("produs.id");
				String den = resultSet.getString("produs.den");
				BigDecimal pret = resultSet.getBigDecimal("pret");
				float stoc = resultSet.getFloat("stoc");
				String categ = resultSet.getString("categorie.den");
				String cale = resultSet.getString("cale");
				String descriere = resultSet.getString("descriere");

				produse.add(new Articol(id, den, pret, stoc, categ, cale, descriere));

			}

			return produse;

		} catch (SQLException e) {

			System.out.println("Nu s-a putut crea statementul sau " + "nu s-a executat query-ul.");
			e.printStackTrace();

			return null;

		} finally {

			inchideResursele();
		}

	}

	// lista categorii produse
	@Override
	public List<Categorie> afiseazaCategorii() {

		creazaConexiuneaLaDB();
		try {
			String sql = "SELECT id, den " + " FROM categorie ORDER BY id";
			statement = conexiune.createStatement();
			resultSet = statement.executeQuery(sql);

			List<Categorie> categorii = new ArrayList<Categorie>();

			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				String den = resultSet.getString("den");

				categorii.add(new Categorie(id, den));

			}

			return categorii;

		} catch (SQLException e) {
			System.out.println("Nu s-a putut crea statementul sau " + "nu s-a executat query-ul.");
			e.printStackTrace();

			return null;

		} finally {

			inchideResursele();
		}

	}

	/**
	 * Aceasta metoda returneaza produsul cu id-ul 'id' din baza de date.
	 */
	public Articol intoarceProdus(String id) {
		int id2 = Integer.parseInt(id);
		creazaConexiuneaLaDB();

		try {
			String sql = "SELECT produs.id, produs.den, produs.pret, produs.cale, categorie.den, produs.descriere"
					+ " FROM produs, categorie " + " WHERE categorie.id=produs.categorie_id" + " AND produs.id = "
					+ id2;
			statement = conexiune.createStatement();
			resultSet = statement.executeQuery(sql);

			// returneaza un singur produs
			if (resultSet.next()) {

				int id3 = resultSet.getInt("id");
				String den = resultSet.getString("den");
				BigDecimal pret = resultSet.getBigDecimal("pret");
				String categorie = resultSet.getString("categorie.den");
				String cale = resultSet.getString("cale");
				String descriere = resultSet.getString("descriere");

				return new Articol(id3, den, pret, categorie, cale, descriere);
			}
			return null;

		} catch (SQLException e) {

			System.out.println("Nu s-a putut crea statementul sau " + "nu s-a executat query-ul.");
			e.printStackTrace();

			return null;

		} finally {

			inchideResursele();
		}

	}

	public Articol adaugaDescriere(String idOriginal) {

		creazaConexiuneaLaDB();

		try {
			String sql = "SELECT produs.id, produs.den,pret, cale,categorie.den,descriere,recomandare,compozitie,substante,ci,stoc FROM produs, categorie WHERE categorie.id = produs.categorie_id AND produs.id = "
					+ idOriginal;

			statement = conexiune.createStatement();
			resultSet = statement.executeQuery(sql);

			List<Articol> articole = new ArrayList<Articol>();

			// returneaza un singur produs
			if (resultSet.next()) {

				int id = resultSet.getInt("id");
				String den = resultSet.getString("den");
				BigDecimal pret = resultSet.getBigDecimal("pret");
				String categorie = resultSet.getString("categorie.den");
				String cale = resultSet.getString("cale");
				String descriere = resultSet.getString("descriere");
				String recomandare = resultSet.getString("recomandare");
				String compozitie = resultSet.getString("compozitie");
				String ci = resultSet.getString("ci");
				String substante = resultSet.getString("substante");
				Float stoc = resultSet.getFloat("stoc");

				return new Articol(id, den, pret, stoc, categorie, cale, descriere, recomandare, compozitie, substante,
						ci);

			}

			return null;

		} catch (SQLException e) {

			System.out.println("Nu s-a putut crea statementul sau " + "nu s-a executat query-ul.");
			e.printStackTrace();

			return null;

		} finally {

			inchideResursele();
		}

	}

	public boolean validare(String name, String pass) {

		creazaConexiuneaLaDB();

		boolean status = false;

		try {

			String sql = "SELECT * FROM login WHERE user=? AND password=?";

			preparedStatement = conexiune.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, pass);

			resultSet = preparedStatement.executeQuery();

			status = resultSet.next();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conexiune != null) {
				try {
					conexiune.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return status;
	}

}
