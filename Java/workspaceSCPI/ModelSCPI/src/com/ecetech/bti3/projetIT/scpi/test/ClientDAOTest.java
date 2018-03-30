package com.ecetech.bti3.projetIT.scpi.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.bti3.projetIT.scpi.beans.Client;
import com.ecetech.bti3.projetIT.scpi.dao.ClientDAO;


public class ClientDAOTest {
private ClientDAO cli = new ClientDAO();
	
	@Test
	public void testGetClientByNum() throws SQLException {
		Client c = cli.getClientByNum("premier");
		if (c != null) {
			System.out.println("Client by num : "+ 1);
		}
		else System.out.println("Client by num : invalide");
	}
	
	@Test
	public void testGetClients() throws SQLException {
		ArrayList<Client> ar = cli.getClients();
		if (ar.size() > 0) {
			System.out.println("Get All Clients : "+ar.size());
		} else {
			System.out.println("Get All Clients : invalide ");
		}
	}
	
	@Test
	public void testDeleteClientsByNum() throws SQLException {
		int i = cli.deleteClientByNum("ajout2");
		if (i == 1) {
			System.out.println("Delete client by num : "+i);
		} else {
			System.out.println("Delete client by num : invalide");
		}
	}
	
	@Test
	public void testUpdateClientByNum() throws SQLException {
		Client update = new Client();
		update.setNumero("ajout");
		update.setNom("quelquun");
		update.setPrenom("aranga");
		update.setTel("0102030405");
		update.setEmail("quelquchose@truc.chose");
		update.setIdentifiantAdresse("ajout");
		update.setLogin("azefer");
		int i = cli.updateClientByNum(update, "ajout");
		if (i == 1) {
			System.out.println("Update client by num : "+i);
		} else {
			System.out.println("Update client by num : invalide"+i);
		}
	}
	
	@Test
	public void testAddClient() throws SQLException {
		String numero = "ajout2";
		String nom = "unNom";
		String prenom = "unPrenom";
		String tel = "0102030405";
		String email = "truc.chose@gmail.fr";
		String idAdr = "ajout";
		String login = "log5";
		int i = cli.addClient(numero, nom, prenom, tel, email, idAdr, login);
		if (i == 1) {
			System.out.println("Client ajouté : "+i);
		} else {
			System.out.println("Client ajouté : invalide"+i);
		}
	}

}
