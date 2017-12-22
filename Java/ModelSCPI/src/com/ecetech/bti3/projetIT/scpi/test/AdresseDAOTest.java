package com.ecetech.bti3.projetIT.scpi.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.ecetech.bti3.projetIT.scpi.dao.AdresseDAO;

public class AdresseDAOTest {

	@Test
	public void test() throws SQLException {
		AdresseDAO adr = new AdresseDAO();
		adr.getAdresseById("premier");
	}

}
