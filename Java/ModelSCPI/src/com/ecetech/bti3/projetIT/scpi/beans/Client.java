package com.ecetech.bti3.projetIT.scpi.beans;

public class Client {
	
	private String numero;
	private String nom;
	private String prenom;
	private String tel;
	private String email;
	private String identifiantAdresse;
	private String login;
	
	public Client(String numero, String nom, String prenom, String tel, String email, String identifiantAdresse,
			String login) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
		this.identifiantAdresse = identifiantAdresse;
		this.login = login;
	}
	
	public Client () {
		this("", "", "", "", "", "", "");
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentifiantAdresse() {
		return identifiantAdresse;
	}

	public void setIdentifiantAdresse(String identifiantAdresse) {
		this.identifiantAdresse = identifiantAdresse;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	

}
