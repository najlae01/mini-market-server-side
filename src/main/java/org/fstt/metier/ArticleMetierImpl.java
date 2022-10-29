package org.fstt.metier;

import java.util.List;

import org.fstt.dao.ArticleRepository;
import org.fstt.entities.Article;
import org.fstt.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;

public class ArticleMetierImpl implements ArticleMetier{

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public Article saveArticle(Article article) {
		return articleRepository.save(article);
	}
	
	@Override
	public Article updateArticle(Article article, Integer id) {
		Article existArticle = articleRepository.findById(id).get();
		
		article.setNomArticle(article.getNomArticle());
		
		article.setPrixUnitaire(article.getPrixUnitaire());
		
		article.setQuantite_stock(article.getQuantite_stock());
		
		article.setLigneCmd(article.getLigneCmd());
		
		article.setLigneLiv(article.getLigneLiv());
		
		return articleRepository.save(existArticle);
	}

	@Override
	public Article getArticle(Integer id) {
		return articleRepository.findById(id).get();
	}

	@Override
	public void deleteArticle(Integer id) {
		articleRepository.deleteById(id);
	}

	@Override
	public List<Article> listArticle() {
		return articleRepository.findAll();
	}
	
}
