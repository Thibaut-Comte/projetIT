package com.ecetech.bti3.projetIT.scpi.beans;

public class Bien {
	
	private String numero;
	private String type;
	private String specificites;
	private boolean statut;
	private float taille;
	private String identifiantAdresse;
	
	public Bien(String numero, String type, String specificites, boolean statut, float taille,
			String identifiantAdresse) {
		super();
		this.numero = numero;
		this.type = type;
		this.specificites = specificites;
		this.statut = statut;
		this.taille = taille;
		this.identifiantAdresse = identifiantAdresse;
	}
	
	public Bien () {
		this("", "", "", false, 0, "");
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpecificites() {
		return specificites;
	}

	public void setSpecificites(String specificites) {
		this.specificites = specificites;
	}

	public boolean getStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public float getTaille() {
		return taille;
	}

	public void setTaille(float taille) {
		this.taille = taille;
	}

	public String getIdentifiantAdresse() {
		return identifiantAdresse;
	}

	public void setIdentifiantAdresse(String identifiantAdresse) {
		this.identifiantAdresse = identifiantAdresse;
	}
	
	

}
