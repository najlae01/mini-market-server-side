package org.fstt.entities;

import java.io.Serializable;
import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "commande")
public class Commande implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "num_cmd")
	private Long numeroCommande;
	
	@Column(name = "date_cmd")
	private Date dateCommande;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "cli_id")
	private Client client;
	
	@OneToMany(mappedBy = "commande")
	private Collection<LigneCommande> lignesCmd = new ArrayList<LigneCommande>();
	
	public void addLigneCommande(LigneCommande ligneCommande) {
		this.lignesCmd.add(ligneCommande);
	}

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(Collection<LigneCommande> lignesCmd, Client client) {
		super();
		this.client = client;
		this.lignesCmd = lignesCmd;
	}

	public Long getNumeroCommande() {
		return numeroCommande;
	}

	public void setNumeroCommande(Long numeroCommande) {
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
		this.client.addCommande(this);
	}

	public Collection<LigneCommande> getLignesCmd() {
		return lignesCmd;
	}

	public void setLignesCmd(Collection<LigneCommande> lignesCmd) {
		this.lignesCmd = lignesCmd;
	}

	@Override
	public String toString() {
		return "Commande [numeroCommande=" + numeroCommande + ", dateCommande=" + dateCommande + ", client=" + client.getCodeClient()
				+ ", lignesCmd=" + lignesCmd + "]";
	}
	

}
