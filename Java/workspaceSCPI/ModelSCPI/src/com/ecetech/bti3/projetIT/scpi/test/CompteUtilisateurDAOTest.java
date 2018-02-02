package com.ecetech.bti3.projetIT.scpi.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Date;

import javax.swing.event.SwingPropertyChangeSupport;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.junit.Test;

import com.ecetech.bti3.projetIT.scpi.beans.CompteUtilisateur;
import com.ecetech.bti3.projetIT.scpi.dao.CompteUtilisateurDAO;

public class CompteUtilisateurDAOTest {
	
	private CompteUtilisateurDAO compte = new CompteUtilisateurDAO();

	@Test
	public void testGetCompteByLogin() throws SQLException {
		compte.getCompteByLogin("login");
	}
	
	@Test
	public void testGetUsersAccounts() throws SQLException {
		compte.getUsersAccounts();
	}
	
	@Test
	public void testDeleteCompteByLogin() throws SQLException {
		compte.deleteAccountByLogin("login");
	}
	
	@Test
	public void testUpDateCompteByLogin() throws SQLException {
		CompteUtilisateur c = new CompteUtilisateur();
		c.setLogin("log5");
		c.setMdp("hash");
		c.setCreation(null);
		c.setEtat("a");
		c.setType("client");
		System.out.println(c.toString());
		compte.updateCompteByLogin(c, "login2");
	}
	
	@Test
	public void testAddAccount() throws SQLException {
		String login = "login4";
		String mdp = "mdp";
		String creation = "1996-16-03";
		String etat = "";
		String type = "";
		CompteUtilisateurDAO.addAccount(login, mdp, creation, etat, type);
	}

}
