package com.ecetech.bti3.projetIT.scpi.beans;

import java.sql.Date;

public class CompteUtilisateur {
	
	private String login;
	private String mdp;
	private Date creation;
	private String etat;
	private String type;
	
	public CompteUtilisateur(String login, String mdp, Date creation, String etat, String type) {
		super();
		this.login = login;
		this.mdp = mdp;
		this.creation = creation;
		this.etat = etat;
		this.type = type;
	}
	
	public CompteUtilisateur () {
		this("", "", null, "", "");
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
