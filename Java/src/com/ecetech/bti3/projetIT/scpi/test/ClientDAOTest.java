package com.ecetech.bti3.projetIT.scpi.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.ecetech.bti3.projetIT.scpi.beans.Client;
import com.ecetech.bti3.projetIT.scpi.dao.ClientDAO;

public class ClientDAOTest {

private ClientDAO cli = new ClientDAO();
	
	@Test
	public void testGetClientByNum() throws SQLException {
		cli.getClientByNum("premier");
	}
	
	@Test
	public void testGetClients() throws SQLException {
		cli.getClient();
	}
	
	@Test
	public void testDeleteClientsByNum() throws SQLException {
		cli.deleteClientByNum("suppression");
	}
	
	@Test
	public void testUpdateClientByNum() throws SQLException {
		Client update = new Client();
		update.setNumero("ajout");
		update.setNom("quelquun");
		update.setPrenom("aranga");
		update.setTel("0102030405");
		update.setEmail("quelquchose@truc.chose");
		update.setIdentifiantAdresse("1562");
		update.setLogin("azefer");
		cli.updateClientByNum(update, "ajout");
	}
	
	@Test
	public void testAddClient() throws SQLException {
		String num = "ajout2";
		String nom = "unNom";
		String prenom = "unPrenom";
		String tel = "0102030405";
		String email = "truc.chose@gmail.fr";
		String login = "azedefert";
		cli.addClient(num, nom, prenom, tel, email, login);
	}

}
