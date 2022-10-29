package org.fstt.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ligne_cmd")
public class LigneCommande implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "num_ligne")
	private Integer numeroLigne;
	
	@Column(name = "qte_cmd")
	private Integer quantiteCommande;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "article_id", nullable = false, unique = true)
	private Article article;
	
	@ManyToOne
	@JoinColumn(name = "cmd_id")
	private Commande commande;

	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneCommande(Integer quantiteCommande, Article article, Commande commande) {
		super();
		this.quantiteCommande = quantiteCommande;
		this.article = article;
		this.commande = commande;
	}

	public Integer getNumeroLigne() {
		return numeroLigne;
	}

	public void setNumeroLigne(Integer numeroLigne) {
		this.numeroLigne = numeroLigne;
	}

	public Integer getQuantiteCommande() {
		return quantiteCommande;
	}

	public void setQuantiteCommande(Integer quantiteCommande) {
		this.quantiteCommande = quantiteCommande;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	

}
