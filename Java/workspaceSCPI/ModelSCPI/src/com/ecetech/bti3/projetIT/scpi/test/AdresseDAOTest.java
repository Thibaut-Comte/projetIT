package com.ecetech.bti3.projetIT.scpi.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.ecetech.bti3.projetIT.scpi.beans.Adresse;
import com.ecetech.bti3.projetIT.scpi.dao.AdresseDAO;

public class AdresseDAOTest {

	private AdresseDAO adr = new AdresseDAO();
	
	@Test
	public void testGetAdresseById() throws SQLException {
		adr.getAdresseById("premier");
	}
	
	@Test
	public void testGetAdresses() throws SQLException {
		adr.getAdresses();
	}
	
	@Test
	public void testDeleteAdressesById() throws SQLException {
		adr.deleteAdresseById("suppression");
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
		adr.updateAdresseById(update, "update");
	}
	
	@Test
	public void testAddAdresse() throws SQLException {
		String id = "ajout";
		String rue = "un autre Endroit";
		String cp = "00002";
		String ville = "Ville au loin au fond";
		String pays = "russie";
		int ascenseur = 0;
		int etage = 2;
		adr.addAdresse(id, rue, cp, ville, pays,  ascenseur, etage);
	}

}
