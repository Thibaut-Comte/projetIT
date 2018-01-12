package com.ecetech.bti3.projetIT.scpi.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.ecetech.bti3.projetIT.scpi.beans.Bien;
import com.ecetech.bti3.projetIT.scpi.dao.BienDAO;

public class BienDAOTest {
	
	private BienDAO bien = new BienDAO(); 

	@Test
	public void testGetBienByNum() throws SQLException {
		bien.getBienByNum("un");
	}
	
	@Test
	public void testGetAllBiens() throws SQLException {
		bien.getAllBiens();
	}
	
	@Test
	public void testGetAllBiensEnVente() throws SQLException {
		bien.getAllBiensEnVente();
	}
	
	@Test
	public void testDeleteBienByNum() throws SQLException {
		bien.deleteBienByNum("deux");
	}
	
	@Test
	public void testUpdateBienByNum() throws SQLException {
		Bien b = new Bien();
		b.setNumero("trois");
		b.setType("appartemant");
		b.setSpecificites("possède un balcon");
		b.setStatut(1);
		b.setTaille(503.0f);
		b.setIdentifiantAdresse("premier");
		bien.updateBienByNum(b, "trois");
	}
	
	@Test
	public void testBienVendu() throws SQLException {
		Bien b = new Bien();
		bien.bienVendu(b, "quatre");
	}
	
	@Test
	public void testBienAVendre() throws SQLException {
		Bien b = new Bien();
		bien.bienAVendre(b, "cinq");
	}
	
	@Test
	public void testAddBien() throws SQLException {
		String numero = "six";
		String type = "Maison";
		String specificite = "aucune";
		int statut = 0;
		float taille = 52f;
		String identifiantAdresse = "premier";
		bien.addBien(numero, type, specificite, statut, taille, identifiantAdresse);
	}

}
