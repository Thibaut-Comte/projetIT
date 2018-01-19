package com.ecetech.bti3.projetIT.scpi.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ecetech.bti3.projetIT.scpi.beans.CompteUtilisateur;
import com.ecetech.bti3.projetIT.scpi.common.ConnectionDB;

public class CompteUtilisateurDAO {

	/**
	 * Recherche d'un compte par le login
	 * @param login
	 * @return
	 * @throws SQLException
	 */
	public static CompteUtilisateur getCompteByLogin (String login) throws SQLException {
		CompteUtilisateur cpTmp= new CompteUtilisateur();
		//Requete
		String req = "SELECT * FROM compte_utilisateur WHERE login = '"+login+"';";
		ConnectionDB.DBConnexion();
		//Récupération d'un resultat après execution
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));

		//Assignation des valeurs dans l'ordre
		while (ConnectionDB.getRes().next()) {
			cpTmp.setLogin(ConnectionDB.getRes().getString(1));
			cpTmp.setMdp(ConnectionDB.getRes().getString(2));
			cpTmp.setCreation(ConnectionDB.getRes().getString(3));
			cpTmp.setEtat(ConnectionDB.getRes().getString(4));
			cpTmp.setType(ConnectionDB.getRes().getString(5));
		}

		//Fermeture de la connection
		ConnectionDB.DBClose();
		return cpTmp;
	}

	/**
	 * Retourne la liste des comptes utilisateurs
	 */
	public static ArrayList<CompteUtilisateur> getUsersAccounts() throws SQLException {
		CompteUtilisateur accountTmp = new CompteUtilisateur();
		String req = "SELECT * FROM compte_utilisateur";
		ConnectionDB.DBConnexion();
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));

		ArrayList<CompteUtilisateur> accounts = new ArrayList<CompteUtilisateur>();
		while (ConnectionDB.getRes().next()) {
			accountTmp.setLogin(ConnectionDB.getRes().getString(1));
			accountTmp.setMdp(ConnectionDB.getRes().getString(2));
			accountTmp.setCreation(ConnectionDB.getRes().getString(3));
			accountTmp.setEtat(ConnectionDB.getRes().getString(4));
			accountTmp.setType(ConnectionDB.getRes().getString(5));
			accounts.add(accountTmp);
		}
		//Fermeture de la connection
		ConnectionDB.DBClose();
		return accounts;
	}
	
	/**
	 * Suppression d'un compte utilisateur par le login
	 * @param login
	 * @return
	 */
	public static int deleteAccountByLogin(String login) {
		int result = -1;
		ConnectionDB.DBConnexion();

		String req = "DELETE FROM compte_utilisateur WHERE login = '"+login+"' ";
		try {
			result = ConnectionDB.getStm().executeUpdate(req);
			System.out.println("Compte supprimé");	
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
	 * Mis à jour d'un compte utilisateur
	 * @param user
	 * @param login
	 * @return
	 * @throws SQLException 
	 */
	public static int updateCompteByLogin(CompteUtilisateur user, String login) throws SQLException 
	{
		int result = -1;
		ConnectionDB.DBConnexion();

		String log = user.getLogin();
		String mdp = user.getMdp();
		String creation = user.getCreation();
		String etat = user.getEtat();
		String type = user.getType();

		String req = "UPDATE compte_utilisateur SET login = '"+log+"', mdp = '"+mdp+"', dateCreation = '"+creation+"', "
				+ "etat = '"+etat+"', type = '"+type+"' "
						+ "WHERE login = '"+login+"'";
		System.out.println(req);
		result = ConnectionDB.getStm().executeUpdate(req);
		try {
			result = ConnectionDB.getStm().executeUpdate(req);
			System.out.println("Compte mis à jour");	
		} catch (SQLException ex)
		{
			result = - ex.getErrorCode();
		}
		ConnectionDB.DBClose();
		return result;
	}
	
	/**
	 * Ajout d'un compte utilisateur
	 * @param login
	 * @param mdp
	 * @param creation
	 * @param etat
	 * @param type
	 * @return
	 */
	public static int addAccount(String login, String mdp, String creation, String etat, String type) 
	{
		int result = -1;
		ConnectionDB.DBConnexion();

		String req = "INSERT INTO compte_utilisateur (login, mdp, dateCreation, etat, type) "
				+ "VALUES ('"+login+"','"+mdp+"',"+creation+",'"+etat+"','"+type+"')";
		try {
			result = ConnectionDB.getStm().executeUpdate(req);
			System.out.println("Compte créé");
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
