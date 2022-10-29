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
@Table(name = "fournisseur")
public class Fournisseur implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cod_four")
	private Integer CodeFournisseur;
	
	@Column(name = "nom_four")
	private String nomFournisseur;
	
	@Column(name = "ville_four")
	private String villeFournisseur;
	
	@Column(name = "tel_four")
	private String telephoneFournisseur;
	
	@OneToMany(mappedBy = "fournisseur")
	private Collection<Livraison> livraisons;
	
	@OneToMany(mappedBy = "fournisseur")
	private Collection<Societe> societes;

	public Integer getCodeFournisseur() {
		return CodeFournisseur;
	}

	public void setCodeFournisseur(Integer codeFournisseur) {
		CodeFournisseur = codeFournisseur;
	}

	public String getNomFournisseur() {
		return nomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}

	public String getVilleFournisseur() {
		return villeFournisseur;
	}

	public void setVilleFournisseur(String villeFournisseur) {
		this.villeFournisseur = villeFournisseur;
	}

	public String getTelephoneFournisseur() {
		return telephoneFournisseur;
	}

	public void setTelephoneFournisseur(String telephoneFournisseur) {
		this.telephoneFournisseur = telephoneFournisseur;
	}

	public Collection<Livraison> getLivraisons() {
		return livraisons;
	}

	public void setLivraisons(Collection<Livraison> livraisons) {
		this.livraisons = livraisons;
	}

	public Collection<Societe> getSocietes() {
		return societes;
	}

	public void setSocietes(Collection<Societe> societes) {
		this.societes = societes;
	}

	public Fournisseur(String nomFournisseur, String villeFournisseur,
			String telephoneFournisseur, Collection<Livraison> livraisons, Collection<Societe> societes) {
		super();

		this.nomFournisseur = nomFournisseur;
		this.villeFournisseur = villeFournisseur;
		this.telephoneFournisseur = telephoneFournisseur;
		this.livraisons = livraisons;
		this.societes = societes;
	}

	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

}
