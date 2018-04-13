package com.ecetech.bti3.projetIT.scpi.beans;

public class CompteUtilisateur {
	
	private String login;
	private String mdp;
	private String creation;
	private String actif;
	private int admin;
	
	public CompteUtilisateur(String login, String mdp, String creation, String etat, int admin) {
		super();
		this.login = login;
		this.mdp = mdp;
		this.creation = creation;
		this.actif = etat;
		this.admin = admin;
	}
	
	public CompteUtilisateur () {
		this("", "", null, "", 0);
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

	public String getCreation() {
		return creation;
	}

	public void setCreation(String creation) {
		this.creation = creation;
	}

	public String getActif() {
		return actif;
	}

	public void setActif(String actif) {
		this.actif = actif;
	}

	public Boolean isAdmin() {
		if(this.admin == 1)
		{
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "CompteUtilisateur [login=" + login + ", mdp=" + mdp + ", creation=" + creation + ", actif=" + actif
				+ ", admin=" + admin + "]";
	}
	
	
}
