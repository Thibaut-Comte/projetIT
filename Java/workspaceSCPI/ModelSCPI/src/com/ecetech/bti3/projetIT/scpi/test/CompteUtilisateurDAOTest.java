package com.ecetech.bti3.projetIT.scpi.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
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
		CompteUtilisateur cpt = compte.getCompteByLogin("login","mdp");
		if (cpt != null) {
			System.out.println("Compte by login : "+ 1);
		}
		else System.out.println("Compte by login : invalide");
	}
	
	@Test
	public void testGetUsersAccounts() throws SQLException {
		ArrayList<CompteUtilisateur> ar = compte.getUsersAccounts();
		if (ar.size() > 0) {
			System.out.println("Get All Clients : "+ar.size());
		} else {
			System.out.println("Get All Clients : invalide ");
		}
	}
	
	@Test
	public void testDeleteCompteByLogin() throws SQLException {
		int i = compte.deleteAccountByLogin("login4");
		if (i == 1) {
			System.out.println("Delete compte by num : "+i);
		} else {
			System.out.println("Delete compte by num : invalide");
		}
	}
	
	@Test
	public void testUpDateCompteByLogin() throws SQLException {
		CompteUtilisateur c = new CompteUtilisateur();
//		c.setLogin("log1");
//		c.setMdp("hash");
//		c.setCreation(null);
//		c.setEtat("a");
		int _admin = 0;
//		if(c.isAdmin())
//		{
//			_admin = 1;
//		}
		c = new CompteUtilisateur("log1","hash",null,"en attente",_admin);
		int i = compte.updateCompteByLogin(c, "log1");
		if (i == 1) {
			System.out.println("Update compte by login : "+i);
		} else {
			System.out.println("Update compte by login : invalide"+i);
		}
	}
	
	@Test
	public void testAddAccount() throws SQLException {
		String login = "login4";
		String mdp = "mdp";
		String creation = "1996-16-03";
		String actif = "en attente";
		int admin = 0;
		int i = CompteUtilisateurDAO.addAccount(login, mdp, creation, actif, admin);
		if (i == 1) {
			System.out.println("Compte ajouté : "+i);
		} else {
			System.out.println("Compte ajouté : invalide");
		}
	}

}
