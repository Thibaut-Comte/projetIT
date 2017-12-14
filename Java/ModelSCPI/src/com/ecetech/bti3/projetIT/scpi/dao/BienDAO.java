package com.ecetech.bti3.projetIT.scpi.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ecetech.bti3.projetIT.scpi.beans.Bien;
import com.ecetech.bti3.projetIT.scpi.common.ConnectionDB;

public class BienDAO {	

	/**
	 * R�cup�ration d'un bien par son num�ro
	 * @param num
	 * @return
	 * @throws SQLException
	 */
	public static Bien getBienByNum (String num) throws SQLException {
		Bien bienTmp = new Bien();
		//Requete
		String req = "SELECT * FROM adresse WHERE identifiant = '"+num;
		ConnectionDB.DBConnexion();
		//R�cup�ration d'un resultat apr�s execution
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));

		//Assignation des valeurs dans l'ordre
		while (ConnectionDB.getRes().next()) {
			bienTmp.setNumero(ConnectionDB.getRes().getString(1));
			bienTmp.setType(ConnectionDB.getRes().getString(2));
			bienTmp.setSpecificites(ConnectionDB.getRes().getString(3));
			bienTmp.setStatut(ConnectionDB.getRes().getBoolean(4));
			bienTmp.setTaille(ConnectionDB.getRes().getFloat(5));
			bienTmp.setIdentifiantAdresse(ConnectionDB.getRes().getString(6));

		}

		//Fermeture de la connection
		ConnectionDB.DBClose();
		return bienTmp;
	}

	/**
	 * R�cup�ration de la liste des biens
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Bien> getBien() throws SQLException {
		Bien bienTmp = new Bien();
		String req = "SELECT * FROM bien";
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));

		ArrayList<Bien> biens = new ArrayList<Bien>();
		while (ConnectionDB.getRes().next()) {
			bienTmp.setNumero(ConnectionDB.getRes().getString(1));
			bienTmp.setType(ConnectionDB.getRes().getString(2));
			bienTmp.setSpecificites(ConnectionDB.getRes().getString(3));
			bienTmp.setStatut(ConnectionDB.getRes().getBoolean(4));
			bienTmp.setTaille(ConnectionDB.getRes().getFloat(5));
			bienTmp.setIdentifiantAdresse(ConnectionDB.getRes().getString(6));
			biens.add(bienTmp);
		}
		//Fermeture de la connection
		ConnectionDB.DBClose();
		return biens;
	}

	/**
	 * Supression d'un bien
	 * @param num
	 * @return
	 */
	public static int deleteBienByNum(String num) {
		int result = -1;
		ConnectionDB.DBConnexion();

		String req = "DELETE FROM bien WHERE num = '"+num+"' ";
		try {
			result = ConnectionDB.getStm().executeUpdate(req);
			System.out.println("Requete execut�e");	
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());

		}
		System.out.println("["+req+"] Suppression : Valeur de result == "+result);
		ConnectionDB.DBClose();
		return result;
	}

	/**
	 * Mise � jour d'un bien
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
		boolean statut = bien.getStatut();
		float taille = bien.getTaille();
		String identifiantAdresse = bien.getIdentifiantAdresse();


		String req = "UPDATE bien SET numero = '"+numero+"', type = '"+type+"',specificite = '"+specificites+"', "
				+ "statut = '"+statut+"',taille = '"+taille+"', identifiant_adresse = '"+identifiantAdresse+"' "
				+ "WHERE num ='"+num+"' ";
		try {
			result = ConnectionDB.getStm().executeUpdate(req);
			System.out.println("Requete executee");	
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
	public static int addBien(String numero, String type, String specificite, Boolean statut, Float taille, String identifiantAdresse) 
	{
		int result = -1;
		ConnectionDB.DBConnexion();

		String req = "INSERT INTO eleve (numero, type, specificite, statut, taille, identifiant_adresse) "
				+ "VALUES ('"+numero+"','"+type+"',"+specificite+",'"+statut+"','"+taille+"','"+identifiantAdresse+"') ";
		try {
			result = ConnectionDB.getStm().executeUpdate(req);
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
			System.out.println(ex.getMessage());
		}//System.out.println("["+req+"] Valeur de result == "+result);

		System.out.println(req);	
		//DBAction.DBClose();
		return result;
	}

}
