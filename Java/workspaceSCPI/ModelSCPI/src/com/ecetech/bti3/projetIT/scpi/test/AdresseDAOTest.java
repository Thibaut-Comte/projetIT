package com.ecetech.bti3.projetIT.scpi.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.bti3.projetIT.scpi.beans.Adresse;
import com.ecetech.bti3.projetIT.scpi.dao.AdresseDAO;

public class AdresseDAOTest {

	private AdresseDAO adr = new AdresseDAO();
	
	@Test
	public void testGetAdresseById() throws SQLException {
		Adresse a = adr.getAdresseById("premier");
		if (a != null) {
			System.out.println("Adresse by id : "+ 1);
		}
		else System.out.println("Adresse by id : invalide");
	}
	
	@Test
	public void testGetAdresses() throws SQLException {
		ArrayList<Adresse> ar = adr.getAdresses();
		if (ar.size() > 0) {
			System.out.println("Get All Adresses : "+ar.size());
		} else {
			System.out.println("Get All Adresses : invalide ");
		}
	}
	
	@Test
	public void testDeleteAdressesById() throws SQLException {
		int i = adr.deleteAdresseById("autre");
		if (i == 1) {
			System.out.println("Delete adr by num : "+i);
		} else {
			System.out.println("Delete adr by num : invalide");
		}
	}
	
	@Test
	public void testUpdateAdresseById() throws SQLException {
		Adresse update = new Adresse();
		update.setRue("un Endroit");
		update.setCp("00001");
		update.setVille("Ville au loin");
		update.setPays("allemagne");
		update.setAscensseur(0);
		update.setEtage(0);
		int i = adr.updateAdresseById(update, "update");
		if (i == 1) {
			System.out.println("Update adr by num : "+i);
		} else {
			System.out.println("Update adr by num : invalide"+i);
		}
	}
	
	@Test
	public void testAddAdresse() throws SQLException {
		String id = "autre";
		String rue = "un autre Endroit";
		String cp = "00002";
		String ville = "Ville au loin au fond";
		String pays = "russie";
		int ascenseur = 0;
		int etage = 2;
		int i = adr.addAdresse(id, rue, cp, ville, pays,  ascenseur, etage);
		if (i == 1) {
			System.out.println("Adresse ajouté : "+i);
		} else {
			System.out.println("Adresse ajouté : invalide");
		}
	}

}
