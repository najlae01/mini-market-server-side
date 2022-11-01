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

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "ligne_liv")
public class LigneLivraison implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "num_ligneLiv")
	private Long numLigneLivraison;
	
	@Column(name = "qte_liv")
	private Integer quantiteLivraison;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "article_id", nullable = false, unique = true)
	@JsonBackReference
	private Article article;
	
	@ManyToOne
	@JoinColumn(name = "liv_id")
	private Livraison livraison;

	public LigneLivraison() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneLivraison(Integer quantiteLivraison, Article article, Livraison livraison) {
		super();
		this.quantiteLivraison = quantiteLivraison;
		this.article = article;
		this.livraison = livraison;
	}

	public Long getNumLigneLivraison() {
		return numLigneLivraison;
	}

	public void setNumLigneLivraison(Long numLigneLivraison) {
		this.numLigneLivraison = numLigneLivraison;
	}

	public Integer getQuantiteLivraison() {
		return quantiteLivraison;
	}

	public void setQuantiteLivraison(Integer quantiteLivraison) {
		this.quantiteLivraison = quantiteLivraison;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Livraison getLivraison() {
		return livraison;
	}

	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}
	
}
