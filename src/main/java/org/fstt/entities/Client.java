package org.fstt.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cod_cli")
	private Integer codeClient;
	
	@Column(name = "nom_cli")
	private String nomClient;
	
	@Column(name = "pre_cli")
	private String prenomClient;
	
	@Column(name = "adr_cli")
	private String adresse;
	
	@Column(name = "tel_cli")
	private String telephone;
	
	@Column(name = "ville_cli")
	private String villeClient;
	
	@OneToMany(mappedBy = "client")
	private Collection<Commande> commandes;

	public Integer getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(Integer codeClient) {
		this.codeClient = codeClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getVilleClient() {
		return villeClient;
	}

	public void setVilleClient(String villeClient) {
		this.villeClient = villeClient;
	}

	public Collection<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}

	public Client(String nomClient, String prenomClient, String adresse, String telephone,
			String villeClient, Collection<Commande> commandes) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adresse = adresse;
		this.telephone = telephone;
		this.villeClient = villeClient;
		this.commandes = commandes;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

}
