package com.ecetech.bti3.projetIT.scpi.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.ecetech.bti3.projetIT.scpi.beans.Bien;
import com.ecetech.bti3.projetIT.scpi.dao.BienDAO;

public class BienDAOTest {
	
	private BienDAO bien = new BienDAO(); 

	@Test
	public void testGetBienByNum() throws SQLException {
		Bien b = bien.getBienByNum("un");
		if (b != null) {
			System.out.println("TestGetBienByNum : "+ 1);
		}
		else System.out.println("TestGetBienByNum : invalide");
	}
	
	@Test
	public void testGetAllBiens() throws SQLException {
		ArrayList<Bien> ar = bien.getAllBiens();
		if (ar.size() > 0) {
			System.out.println("Get All Biens : "+ar.size());
		} else {
			System.out.println("GetAllBiens : invalide ");
		}
	}
	
	@Test
	public void testGetAllBiensEnVente() throws SQLException {
		ArrayList<Bien> ar = bien.getAllBiensEnVente();
		if (ar.size() > 0) {
			System.out.println("Get All Biens en ventes : "+ar.size());
		} else {
			System.out.println("GetAllBiensEnVentes : invalide");
		}
	}
	
	@Test
	public void testGetAllBiensClasser() throws SQLException {
		ArrayList<Bien> ar = bien.getAllBiensClasseParVente();
		if (ar.size() > 0) {
			System.out.println("Get All Biens classer : "+ar.size());
		} else {
			System.out.println("GetAllBiensClasser : invalide");
		}
	}
	
	@Test
	public void testDeleteBienByNum() throws SQLException {
		int i = bien.deleteBienByNum("six");
		if (i == 1) {
			System.out.println("Delete bien by num : "+i);
		} else {
			System.out.println("Delete bien by num : invalide");
		}
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
		int i = bien.updateBienByNum(b, "trois");
		if (i == 1) {
			System.out.println("Update by num : "+i);
		} else {
			System.out.println("Update by num : invalide");
		}
	}
	
	@Test
	public void testBienVendu() throws SQLException {
		Bien b = new Bien();
		int i = bien.bienVendu(b, "quatre");
		if (i > 0) {
			System.out.println("Bien vendu : "+i);
		} else {
			System.out.println("Bien vendu : invalide");
		}
	}
	
	@Test
	public void testBienAVendre() throws SQLException {
		Bien b = new Bien();
		int i = bien.bienAVendre(b, "cinq");
		if (i > 0) {
			System.out.println("Bien à vendre : "+i);
		} else {
			System.out.println("Bien à vendre : invalide"+i);
		}
	}
	
	@Test
	public void testAddBien() throws SQLException {
		String numero = "six";
		String type = "Maison";
		String specificite = "aucune";
		int statut = 0;
		float taille = 52f;
		String identifiantAdresse = "premier";
		int i = bien.addBien(numero, type, specificite, statut, taille, identifiantAdresse);
		if (i == 1) {
			System.out.println("Bien ajouté : "+i);
		} else {
			System.out.println("Bien ajouté : invalide");
		}
	}

}
