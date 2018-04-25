package com.ecetech.bti3.projetIT.scpi.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ecetech.bti3.projetIT.scpi.beans.Bien;
import com.ecetech.bti3.projetIT.scpi.common.ConnectionDB;

public class BienDAO {	

	/**
	 * Récupération d'un bien par son numéro
	 * @param num
	 * @return
	 * @throws SQLException
	 */
	public static Bien getBienByNum (String num) throws SQLException {
		Bien bienTmp = new Bien();
		//Requete
		String req = "SELECT * FROM bien WHERE numero = '"+num+"'";
		ConnectionDB.DBConnexion();
		//Récupération d'un resultat après execution
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));

		//Assignation des valeurs dans l'ordre
		while (ConnectionDB.getRes().next()) {
			bienTmp.setNumero(ConnectionDB.getRes().getString("numero"));
			bienTmp.setType(ConnectionDB.getRes().getString("type"));
			bienTmp.setSpecificites(ConnectionDB.getRes().getString("specificite"));
			bienTmp.setStatut(ConnectionDB.getRes().getInt("statut"));
			bienTmp.setTaille(ConnectionDB.getRes().getFloat("taille"));
			bienTmp.setIdentifiantAdresse(ConnectionDB.getRes().getString("identifiant_adresse"));

		}

		//Fermeture de la connection
		ConnectionDB.DBClose();
		return bienTmp;
	}

	/**
	 * Récupération de la liste des biens
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Bien> getAllBiens() throws SQLException {
		
		String req = "SELECT * FROM bien";
		ConnectionDB.DBConnexion();
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));
		ArrayList<Bien> biens = new ArrayList<Bien>(ConnectionDB.getRes().getFetchSize());
//		int i = 0;
		while (ConnectionDB.getRes().next()) {	
			Bien bienTmp = new Bien();
			bienTmp.setNumero(ConnectionDB.getRes().getString("numero"));
			bienTmp.setType(ConnectionDB.getRes().getString("type"));
			bienTmp.setSpecificites(ConnectionDB.getRes().getString("specificite"));
			bienTmp.setStatut(ConnectionDB.getRes().getInt("statut"));
			bienTmp.setTaille(ConnectionDB.getRes().getFloat("taille"));
			bienTmp.setIdentifiantAdresse(ConnectionDB.getRes().getString("identifiant_adresse"));
			biens.add(bienTmp);
//			System.out.println("BienTemp"+i);
//			i++;
//			System.out.println(bienTmp.toString());
		}
//		System.out.println("DAO");
//		for(int j=0; j<biens.size(); j++)
//		{
//			System.out.println(biens.get(j).toString());
//		}
		//Fermeture de la connection
		ConnectionDB.DBClose();
		return biens;
	}
	
	/**
	 * Récupération de la liste des biens en vente
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Bien> getAllBiensEnVente() throws SQLException {
		Bien bienTmp = new Bien();
		String req = "SELECT * FROM bien WHERE statut = 1";
		ConnectionDB.DBConnexion();
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));

		ArrayList<Bien> biensVentes = new ArrayList<Bien>();
		while (ConnectionDB.getRes().next()) {
			bienTmp.setNumero(ConnectionDB.getRes().getString("numero"));
			bienTmp.setType(ConnectionDB.getRes().getString("type"));
			bienTmp.setSpecificites(ConnectionDB.getRes().getString("specificite"));
			bienTmp.setStatut(ConnectionDB.getRes().getInt("statut"));
			bienTmp.setTaille(ConnectionDB.getRes().getFloat("taille"));
			bienTmp.setIdentifiantAdresse(ConnectionDB.getRes().getString("identifiant_adresse"));
			biensVentes.add(bienTmp);
		}
		//Fermeture de la connection
		ConnectionDB.DBClose();
		return biensVentes;
	}
	
	/**
	 * Récupération de la liste des biens ordonner par statut
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Bien> getAllBiensClasseParVente() throws SQLException {
		Bien bienTmp = new Bien();
		String req = "SELECT * FROM bien ORDER BY statut";
		ConnectionDB.DBConnexion();
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));

		ArrayList<Bien> biensVentes = new ArrayList<Bien>();
		while (ConnectionDB.getRes().next()) {
			bienTmp.setNumero(ConnectionDB.getRes().getString("numero"));
			bienTmp.setType(ConnectionDB.getRes().getString("type"));
			bienTmp.setSpecificites(ConnectionDB.getRes().getString("specificite"));
			bienTmp.setStatut(ConnectionDB.getRes().getInt("statut"));
			bienTmp.setTaille(ConnectionDB.getRes().getFloat("taille"));
			bienTmp.setIdentifiantAdresse(ConnectionDB.getRes().getString("identifiant_adresse"));
			biensVentes.add(bienTmp);
		}
		//Fermeture de la connection
		ConnectionDB.DBClose();
		return biensVentes;
	}

	/**
	 * Supression d'un bien
	 * @param num
	 * @return
	 */
	public static int deleteBienByNum(String num) {
		int result = -1;
		ConnectionDB.DBConnexion();

		String req = "DELETE FROM bien WHERE numero = '"+num+"'";
		try {
			result = ConnectionDB.getStm().executeUpdate(req);	
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());

		}
		ConnectionDB.DBClose();
		return result;
	}

	/**
	 * Mise à jour d'un bien
	 * @param bien
	 * @param num
	 * @return
	 */
	public static int updateBienByNum(Bien bien, String num) 
	{
		int result = -1;
		ConnectionDB.DBConnexion();


		String numero = bien.getNumero();
		String type = bien.getType();
		String specificites = bien.getSpecificites();
		int statut = bien.getStatut();
		float taille = bien.getTaille();
		String identifiantAdresse = bien.getIdentifiantAdresse();


		String req = "UPDATE bien SET numero = '"+numero+"', type = '"+type+"',specificite = '"+specificites+"', "
				+ "statut = '"+statut+"',taille = '"+taille+"', identifiant_adresse = '"+identifiantAdresse+"' "
				+ "WHERE numero ='"+num+"' ";
		try {
			result = ConnectionDB.getStm().executeUpdate(req);
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
		}
		ConnectionDB.DBClose();
		return result;
	}
	
	/**
	 * Mise à jour du statut d'un bien (vendu
	 * @param bien
	 * @param num
	 * @return
	 */
	public static int bienVendu(Bien bien, String num) 
	{
		int result = -1;
		ConnectionDB.DBConnexion();

		int statut = 0;

		String req = "UPDATE bien SET statut = '"+statut+"' WHERE numero = '"+num+"'";
		try {
			result = ConnectionDB.getStm().executeUpdate(req);
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
		}
		ConnectionDB.DBClose();
		return result;
	}
	
	/**
	 * Mise à jour du statut d'un bien (mise en vente)	
	 * @param bien
	 * @param num
	 * @return
	 */
	public static int bienAVendre(Bien bien, String num) 
	{
		int result = -1;
		ConnectionDB.DBConnexion();

		int statut = 1;

		String req = "UPDATE bien SET statut = '"+statut+"' WHERE numero = '"+num+"'";
		try {
			result = ConnectionDB.getStm().executeUpdate(req);
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
		}
		ConnectionDB.DBClose();
		return result;
	}
	
	/**
	 * Ajout d'un bien
	 * @param numero
	 * @param type
	 * @param specificite
	 * @param statut
	 * @param taille
	 * @param identifiantAdresse
	 * @return
	 */
	public static int addBien(String numero, String type, String specificite, int statut, Float taille, String identifiantAdresse) 
	{
		int result = -1;
		ConnectionDB.DBConnexion();

		String req = "INSERT INTO bien (numero, type, specificite, statut, taille, identifiant_adresse) "
				+ "VALUES ('"+numero+"','"+type+"','"+specificite+"','"+statut+"','"+taille+"','"+identifiantAdresse+"') ";
		try {
			result = ConnectionDB.getStm().executeUpdate(req);
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());
		}//System.out.println("["+req+"] Valeur de result == "+result);
		ConnectionDB.DBClose();
		return result;
	}

}
