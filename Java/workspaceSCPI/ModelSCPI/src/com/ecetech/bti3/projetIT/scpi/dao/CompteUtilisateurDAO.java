package com.ecetech.bti3.projetIT.scpi.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ecetech.bti3.projetIT.scpi.beans.CompteUtilisateur;
import com.ecetech.bti3.projetIT.scpi.common.ConnectionDB;

public class CompteUtilisateurDAO {

	/**
	 * Recherche d'un compte par le login
	 * @param login
	 * @param mdp
	 * @return
	 * @throws SQLException
	 */
	public static CompteUtilisateur getCompteByLogin (String login, String mdp) throws SQLException {
		CompteUtilisateur cpTmp= new CompteUtilisateur();
		//Requete
		String req = "SELECT * FROM compte_utilisateur WHERE login = '"+login+"' and mdp = '"+mdp+"';";
		ConnectionDB.DBConnexion();
		//Récupération d'un resultat après execution
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));

		//Assignation des valeurs dans l'ordre
		while (ConnectionDB.getRes().next()) {
//			cpTmp.setLogin(ConnectionDB.getRes().getString("login"));
//			cpTmp.setMdp(ConnectionDB.getRes().getString("mdp"));
//			cpTmp.setCreation(ConnectionDB.getRes().getString("dateCreation"));
//			cpTmp.setEtat(ConnectionDB.getRes().getString("etat"));
//			cpTmp.setType(ConnectionDB.getRes().getString("type"));
			cpTmp = new CompteUtilisateur(
					ConnectionDB.getRes().getString("login"),
					ConnectionDB.getRes().getString("mdp"),
					ConnectionDB.getRes().getString("dateCreation"),
					ConnectionDB.getRes().getString("actif"),
					ConnectionDB.getRes().getInt("admin")
					);
			System.out.println(cpTmp.toString());
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
//			accountTmp.setLogin(ConnectionDB.getRes().getString("login"));
//			accountTmp.setMdp(ConnectionDB.getRes().getString("mdp"));
//			accountTmp.setCreation(ConnectionDB.getRes().getString("dateCreation"));
//			accountTmp.setEtat(ConnectionDB.getRes().getString("actif"));
//			accountTmp.setAdmin(ConnectionDB.getRes().getString("type"));
//			accounts.add(accountTmp);
			accounts.add(new CompteUtilisateur(
					ConnectionDB.getRes().getString("login"),
					ConnectionDB.getRes().getString("mdp"),
					ConnectionDB.getRes().getString("dateCreation"),
					ConnectionDB.getRes().getString("actif"),
					ConnectionDB.getRes().getInt("admin")
					));
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
		String actif = user.getActif();
		int admin = 0;
		if(user.isAdmin())
		{
			admin = 1;
		}
		

		String req = "UPDATE compte_utilisateur SET login = '"+log+"', mdp = '"+mdp+"', dateCreation = '"+creation+"', "
				+ "actif = '"+actif+"', admin = '"+admin+"' "
						+ "WHERE login = '"+login+"'";
		result = ConnectionDB.getStm().executeUpdate(req);
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
	 * Ajout d'un compte utilisateur
	 * @param login
	 * @param mdp
	 * @param creation
	 * @param actif
	 * @param admin
	 * @return
	 */
	public static int addAccount(String login, String mdp, String creation, String actif, int admin) 
	{
		int result = -1;
		ConnectionDB.DBConnexion();

		String req = "INSERT INTO compte_utilisateur (login, mdp, dateCreation, actif, admin) "
				+ "VALUES ('"+login+"','"+mdp+"',"+creation+",'"+actif+"','"+admin+"')";
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
