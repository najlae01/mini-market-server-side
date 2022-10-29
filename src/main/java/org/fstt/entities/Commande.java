package org.fstt.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "commande")
public class Commande implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "num_cmd")
	private Integer numeroCommande;
	
	@Column(name = "date_cmd")
	private Date dateCommande;
	
	@ManyToOne
	@JoinColumn(name = "cli_id")
	private Client client;
	
	@OneToMany(mappedBy = "commande")
	private Collection<LigneCommande> lignesCmd;

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(Date dateCommande, Client client, Collection<LigneCommande> lignesCmd) {
		super();
		this.dateCommande = dateCommande;
		this.client = client;
		this.lignesCmd = lignesCmd;
	}

	public Integer getNumeroCommande() {
		return numeroCommande;
	}

	public void setNumeroCommande(Integer numeroCommande) {
		this.numeroCommande = numeroCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<LigneCommande> getLignesCmd() {
		return lignesCmd;
	}

	public void setLignesCmd(Collection<LigneCommande> lignesCmd) {
		this.lignesCmd = lignesCmd;
	}
	

}
