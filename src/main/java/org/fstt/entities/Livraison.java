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

@Entity
@Table(name = "livraison")
public class Livraison implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "num_liv")
	private Long numeroLivraison;
	
	@Column(name = "date_liv")
	private Date dateLivraison;
	
	@OneToMany(mappedBy = "livraison")
	private Collection<LigneLivraison> lignesLiv = new ArrayList<LigneLivraison>();
	
	public void addLigneLivraison(LigneLivraison ligneLivraison) {
		this.lignesLiv.add(ligneLivraison);
	}
	
	@ManyToOne
	@JoinColumn(name = "frs_id")
	private Fournisseur fournisseur;

	public Long getNumeroLivraison() {
		return numeroLivraison;
	}

	public void setNumeroLivraison(Long numeroLivraison) {
		this.numeroLivraison = numeroLivraison;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public Collection<LigneLivraison> getLignesLiv() {
		return lignesLiv;
	}

	public void setLignesLiv(Collection<LigneLivraison> lignesLiv) {
		this.lignesLiv = lignesLiv;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Livraison( Date dateLivraison, Collection<LigneLivraison> lignesLiv,
			Fournisseur fournisseur) {
		super();
		
		this.dateLivraison = dateLivraison;
		this.lignesLiv = lignesLiv;
		this.fournisseur = fournisseur;
	}

	public Livraison() {
		super();
		// TODO Auto-generated constructor stub
	}

}
