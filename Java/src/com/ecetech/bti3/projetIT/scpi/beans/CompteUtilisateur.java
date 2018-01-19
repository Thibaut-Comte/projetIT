package com.ecetech.bti3.projetIT.scpi.beans;

public class CompteUtilisateur {
	
	private String login;
	private String mdp;
	private String creation;
	private String etat;
	private String type;
	
	public CompteUtilisateur(String login, String mdp, String creation, String etat, String type) {
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

	public String getCreation() {
		return creation;
	}

	public void setCreation(String creation) {
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

	@Override
	public String toString() {
		return "CompteUtilisateur [login=" + login + ", mdp=" + mdp + ", creation=" + creation + ", etat=" + etat
				+ ", type=" + type + "]";
	}
	
	
}
