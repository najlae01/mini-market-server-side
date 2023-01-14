package org.fstt.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "article")
public class Article implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cod_art")
	private Long codeArticle;
	
	@Column(name = "nom_art")
	private String nomArticle;
	
	@Column(name = "img_art")
	private String imageArticle;
	
	@Column(name = "pu")
	private Integer prixUnitaire;
	
	@Column(name = "qte_stock")
	private Integer quantite_stock;
	
	@OneToOne(mappedBy = "article",cascade = CascadeType.ALL)
	private LigneCommande ligneCmd; 
	
	@OneToOne(mappedBy = "article", cascade = CascadeType.ALL)
	@JsonManagedReference
	private LigneLivraison ligneLiv;

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Article(String nomArticle,Integer prixUnitaire, Integer quantite_stock) {
		super();
		this.nomArticle = nomArticle;
		this.prixUnitaire = prixUnitaire;
		this.quantite_stock = quantite_stock;
	}

	public Article(String nomArticle, Integer prixUnitaire,
			Integer quantite_stock,
			LigneCommande ligneCmd, 
			LigneLivraison ligneLiv) {
		super();
		this.nomArticle = nomArticle;
		this.prixUnitaire = prixUnitaire;
		this.quantite_stock = quantite_stock;
		this.ligneCmd = ligneCmd;
		this.ligneLiv = ligneLiv;
	}
	

	public Article(String nomArticle, String imageArticle, Integer prixUnitaire, Integer quantite_stock,
			LigneCommande ligneCmd, LigneLivraison ligneLiv) {
		super();
		this.nomArticle = nomArticle;
		this.imageArticle = imageArticle;
		this.prixUnitaire = prixUnitaire;
		this.quantite_stock = quantite_stock;
		this.ligneCmd = ligneCmd;
		this.ligneLiv = ligneLiv;
	}

	public Long getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(Long codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getImageArticle() {
		return imageArticle;
	}
	public void setImageArticle(String imageArticle) {
		this.imageArticle = imageArticle;
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

	@Override
	public String toString() {
		return "Article [codeArticle=" + codeArticle + ", nomArticle=" + nomArticle + ", imageArticle=" + imageArticle
				+ ", prixUnitaire=" + prixUnitaire + ", quantite_stock=" + quantite_stock + ", ligneCmd=" + ligneCmd
				+ ", ligneLiv=" + ligneLiv + "]";
	}	

}
