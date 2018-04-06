package com.ecetech.bti3.projetIT.scpi.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ecetech.bti3.projetIT.scpi.beans.Adresse;
import com.ecetech.bti3.projetIT.scpi.common.ConnectionDB;

public class AdresseDAO {

	/**
	 * Recuperation d'une adresse par son id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public static Adresse getAdresseById (String id) throws SQLException {
		Adresse adrTmp = new Adresse();
		//Requete
		String req = "SELECT * FROM adresse WHERE identifiant = '"+id+"'";
		ConnectionDB.DBConnexion();
		//Récupération d'un resultat après execution
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));

		//Assignation des valeurs dans l'ordre
		while (ConnectionDB.getRes().next()) {
			adrTmp.setIdentifiant(ConnectionDB.getRes().getString("identifiant"));
			adrTmp.setRue(ConnectionDB.getRes().getString("rue"));
			adrTmp.setCp(ConnectionDB.getRes().getString("cp"));
			adrTmp.setVille(ConnectionDB.getRes().getString("ville"));
			adrTmp.setPays(ConnectionDB.getRes().getString("pays"));
			adrTmp.setAscensseur(ConnectionDB.getRes().getInt("etage"));
			adrTmp.setEtage(ConnectionDB.getRes().getInt("ascenseur"));
		}

		//Fermeture de la connection
		ConnectionDB.DBClose();
		return adrTmp;
	}

	/**
	 * Retourne toute les adresses disponibles
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Adresse> getAdresses() throws SQLException {
		Adresse adrTmp = new Adresse();
		String req = "SELECT * FROM adresse";
		ConnectionDB.DBConnexion();
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));

		ArrayList<Adresse> adresses = new ArrayList<Adresse>();
		while (ConnectionDB.getRes().next()) {
			adrTmp.setIdentifiant(ConnectionDB.getRes().getString("identifiant"));
			adrTmp.setRue(ConnectionDB.getRes().getString("rue"));
			adrTmp.setCp(ConnectionDB.getRes().getString("cp"));
			adrTmp.setVille(ConnectionDB.getRes().getString("ville"));
			adrTmp.setPays(ConnectionDB.getRes().getString("pays"));
			adrTmp.setAscensseur(ConnectionDB.getRes().getInt("etage"));
			adrTmp.setEtage(ConnectionDB.getRes().getInt("ascenseur"));
			adresses.add(adrTmp);
		}
		//Fermeture de la connection
		ConnectionDB.DBClose();
		return adresses;
		
	}

	/**
	 * Delete Adresse par un id
	 * @param id
	 * @return : 1 ou 0  (le nbr d'adresse supprimées) sinon le (-) code d'erreur  
	 */
	public static int deleteAdresseById(String id) {
		int result = -1;
		ConnectionDB.DBConnexion();

		String req = "DELETE FROM adresse WHERE identifiant = '"+id+"' ";
		try {
			result = ConnectionDB.getStm().executeUpdate(req);	
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());

		}
		//System.out.println("["+req+"] Suppression : Valeur de result == "+result);
		ConnectionDB.DBClose();
		return result;
	}

	/**
	 * Mise à jour d'une adresse par l'identifiant
	 * @param adr
	 * @param id
	 * @return
	 */
	public static int updateAdresseById(Adresse adr, String id) 
	{
		int result = -1;
		ConnectionDB.DBConnexion();

		String rue = adr.getRue();
		String cp = adr.getCp();
		String ville = adr.getVille();
		String pays = adr.getPays();
		int ascensseur = adr.getAscensseur();
		int etage = adr.getEtage();


		String req = "UPDATE adresse SET rue = '"+rue+"', cp = '"+cp+"', ville = '"+ville+"', "
				+ "pays = '"+pays+"', ascenseur = '"+ascensseur+"', etage = '"+etage+"' "
				+ "WHERE identifiant ='"+id+"' ";
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
	 * Ajout d'une adresse
	 * @param identifiant
	 * @param rue
	 * @param cp
	 * @param ville
	 * @param pays
	 * @param ascenseur
	 * @param etage
	 * @return
	 */
	public static int addAdresse(String identifiant, String rue, String cp, String ville, String pays, int ascenseur, int etage) 
	{
		int result = -1;
		ConnectionDB.DBConnexion();

		String req = "INSERT INTO adresse (identifiant, rue, cp, ville, pays, ascenseur, etage) "
				+ "VALUES ('"+identifiant+"','"+rue+"',"+cp+",'"+ville+"','"+pays+"','"+ascenseur+"','"+etage+"') ";
		try {
			result = ConnectionDB.getStm().executeUpdate(req);
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());
		}//System.out.println("["+req+"] Valeur de result == "+result);
		//DBAction.DBClose();
		return result;
	}


}
