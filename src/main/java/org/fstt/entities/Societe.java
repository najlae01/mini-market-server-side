package org.fstt.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "societe")
public class Societe implements Serializable{
	
	@Id
	@Column(name = "nom_ste")
	private String nomSociete;
	
	@Column(name = "tel_ste")
	private String telephoneSociete;
	
	@Column(name = "fax_ste")
	private String faxSociete;
	
	@Column(name = "ville_ste")
	private String villeSociete;
	
	@ManyToOne
	@JoinColumn(name = "frs_id")
	private Fournisseur fournisseur;

	public String getNomSociete() {
		return nomSociete;
	}

	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}

	public String getTelephoneSociete() {
		return telephoneSociete;
	}

	public void setTelephoneSociete(String telephoneSociete) {
		this.telephoneSociete = telephoneSociete;
	}

	public String getFaxSociete() {
		return faxSociete;
	}

	public void setFaxSociete(String faxSociete) {
		this.faxSociete = faxSociete;
	}

	public String getVilleSociete() {
		return villeSociete;
	}

	public void setVilleSociete(String villeSociete) {
		this.villeSociete = villeSociete;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Societe(String nomSociete, String telephoneSociete, String faxSociete, String villeSociete,
			Fournisseur fournisseur) {
		super();
		this.nomSociete = nomSociete;
		this.telephoneSociete = telephoneSociete;
		this.faxSociete = faxSociete;
		this.villeSociete = villeSociete;
		this.fournisseur = fournisseur;
	}

	public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
