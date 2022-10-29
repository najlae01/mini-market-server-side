package org.fstt.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cod_art")
	private Integer codeArticle;
	
	@Column(name = "nom_art")
	private String nomArticle;
	
	@Column(name = "pu")
	private Integer prixUnitaire;
	
	@Column(name = "qte_stock")
	private Integer quantite_stock;
	
	@OneToOne(mappedBy = "article", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private LigneCommande ligneCmd; 
	
	@OneToOne(mappedBy = "article", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private LigneLivraison ligneLiv;

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(String nomArticle, Integer prixUnitaire, Integer quantite_stock,
			LigneCommande ligneCmd, LigneLivraison ligneLiv) {
		super();
		this.nomArticle = nomArticle;
		this.prixUnitaire = prixUnitaire;
		this.quantite_stock = quantite_stock;
		this.ligneCmd = ligneCmd;
		this.ligneLiv = ligneLiv;
	}

	public Integer getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(Integer codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public Integer getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Integer prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Integer getQuantite_stock() {
		return quantite_stock;
	}

	public void setQuantite_stock(Integer quantite_stock) {
		this.quantite_stock = quantite_stock;
	}

	public LigneCommande getLigneCmd() {
		return ligneCmd;
	}

	public void setLigneCmd(LigneCommande ligneCmd) {
		this.ligneCmd = ligneCmd;
	}

	public LigneLivraison getLigneLiv() {
		return ligneLiv;
	}

	public void setLigneLiv(LigneLivraison ligneLiv) {
		this.ligneLiv = ligneLiv;
	}

	
	
	

}
