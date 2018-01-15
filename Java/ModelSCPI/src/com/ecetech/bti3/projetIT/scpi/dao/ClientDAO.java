package com.ecetech.bti3.projetIT.scpi.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ecetech.bti3.projetIT.scpi.beans.Client;
import com.ecetech.bti3.projetIT.scpi.common.ConnectionDB;

public class ClientDAO {
		
	/**
	 * Récupération d'un client par son numéro
	 * @param num
	 * @return
	 * @throws SQLException
	 */
	public static Client getClientByNum (String num) throws SQLException {
		Client clientTmp = new Client();
		//Requete
		String req = "SELECT * FROM client WHERE numero = '"+num;
		ConnectionDB.DBConnexion();
		//Récupération d'un resultat après execution
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));

		//Assignation des valeurs dans l'ordre
		while (ConnectionDB.getRes().next()) {
			clientTmp.setNumero(ConnectionDB.getRes().getString(1));
			clientTmp.setNom(ConnectionDB.getRes().getString(2));
			clientTmp.setPrenom(ConnectionDB.getRes().getString(3));
			clientTmp.setTel(ConnectionDB.getRes().getString(4));
			clientTmp.setEmail(ConnectionDB.getRes().getString(5));
			clientTmp.setIdentifiantAdresse(ConnectionDB.getRes().getString(6));
			clientTmp.setLogin(ConnectionDB.getRes().getString(6));

		}

		//Fermeture de la connection
		ConnectionDB.DBClose();
		return clientTmp;
	}

	/**
	 * Récupération de la liste des Clients
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Client> getClient() throws SQLException {
		Client clientTmp = new Client();
		String req = "SELECT * FROM client";
		ConnectionDB.setRes(ConnectionDB.getStm().executeQuery(req));

		ArrayList<Client> clients = new ArrayList<Client>();
		while (ConnectionDB.getRes().next()) {
			clientTmp.setNumero(ConnectionDB.getRes().getString(1));
			clientTmp.setNom(ConnectionDB.getRes().getString(2));
			clientTmp.setPrenom(ConnectionDB.getRes().getString(3));
			clientTmp.setTel(ConnectionDB.getRes().getString(4));
			clientTmp.setEmail(ConnectionDB.getRes().getString(5));
			clientTmp.setIdentifiantAdresse(ConnectionDB.getRes().getString(6));
			clientTmp.setLogin(ConnectionDB.getRes().getString(6));
		}
		//Fermeture de la connection
		ConnectionDB.DBClose();
		return clients;
	}

	/**
	 * Supression d'un Client
	 * @param num
	 * @return
	 */
	public static int deleteClientByNum(String num) {
		int result = -1;
		ConnectionDB.DBConnexion();

		String req = "DELETE FROM client WHERE num = '"+num+"' ";
		try {
			result = ConnectionDB.getStm().executeUpdate(req);
			System.out.println("Requete executée");	
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
	 * Mise à jour d'un Client
	 * @param client
	 * @param num
	 * @return
	 */
	public static int updateClientByNum(Client client, String num) 
	{
		int result = -1;
		ConnectionDB.DBConnexion();

		String numero = client.getNumero();
		String nom = client.getNom();
		String prenom = client.getPrenom(); 
		String tel = client.getTel(); 
		String email = client.getEmail();
		String identifiantAdresse = client.getIdentifiantAdresse();
		
		
		


		String req = "UPDATE client SET numero = '"+numero+"', nom = '"+nom+"',prenom = '"+prenom+"', "
				+ "tel = '"+tel+"',email= '"+email+"', identifiant_adresse = '"+identifiantAdresse+"' "
				+ "WHERE numero ='"+num+"' ";
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
	 * Ajout d'un client
	 * @param numero
	 * @param nom
	 * @param prenom
	 * @param tel
	 * @param email
	 * @param identifiantAdresse
	 * @return
	 */
	public static int addClient(String numero, String nom, String prenom, String tel, String email, String identifiantAdresse) 
	{
		int result = -1;
		ConnectionDB.DBConnexion();

		String req = "INSERT INTO client (numero, nom, prenom, tel, email, identifiant_adresse) "
				+ "VALUES ('"+numero+"','"+nom+"',"+prenom+",'"+tel+"','"+email+"','"+identifiantAdresse+"') ";
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
