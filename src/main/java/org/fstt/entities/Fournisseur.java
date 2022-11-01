package org.fstt.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fournisseur")
public class Fournisseur implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cod_four")
	private Long CodeFournisseur;
	
	@Column(name = "nom_four")
	private String nomFournisseur;
	
	@Column(name = "ville_four")
	private String villeFournisseur;
	
	@Column(name = "tel_four")
	private String telephoneFournisseur;
	
	@OneToMany(mappedBy = "fournisseur")
	private Collection<Livraison> livraisons;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User userId;
	
	public void addLivraison(Livraison livraison) {
		this.livraisons.add(livraison);
	}
	
	@OneToMany(mappedBy = "fournisseur")
	private Collection<Societe> societes = new ArrayList<Societe>();
	
	public void addSociete(Societe societe) {
		this.societes.add(societe);
	}

	public Long getCodeFournisseur() {
		return CodeFournisseur;
	}

	public void setCodeFournisseur(Long codeFournisseur) {
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

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
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
