package org.fstt.metier;


import java.util.List;

import org.fstt.dao.ArticleRepository;
import org.fstt.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticleMetierImpl implements ArticleMetier{

	@Autowired
	private ArticleRepository articleRepository;
	
	
	
	@Override
	public Article saveArticle(Article article) {
		return articleRepository.save(article);
	}
	
	@Override
	public Article updateArticle(Article article, Long id) {
		Article existArticle = articleRepository.findById(id).get();
		
		existArticle.setNomArticle(article.getNomArticle());
		
		existArticle.setImageArticle(article.getImageArticle());
		
		existArticle.setPrixUnitaire(article.getPrixUnitaire());
		
		existArticle.setQuantite_stock(article.getQuantite_stock());
		
		existArticle.setLigneCmd(article.getLigneCmd());
		
		existArticle.setLigneLiv(article.getLigneLiv());
		
		return articleRepository.save(existArticle);
	}

	@Override
	public Article getArticle(Long id) {
		return articleRepository.findById(id).get();
	}

	@Override
	public void deleteArticle(Long id) {
		articleRepository.deleteById(id);
	}

	@Override
	public List<Article> listArticle() {
		return articleRepository.findAll();
	}
	
}
