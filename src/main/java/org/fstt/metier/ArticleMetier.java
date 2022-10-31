package org.fstt.metier;

import java.util.List;

import org.fstt.entities.Article;
import org.springframework.web.multipart.MultipartFile;

public interface ArticleMetier {
	public String saveArticle(String nomArticle, Integer prixUnitaire,
			Integer quantite_stock, MultipartFile file);
	
	public Article updateArticle(Article article, Long id);
	
	public Article getArticle(Long id);
	
	public void deleteArticle(Long id);
	
	public List<Article> listArticle();
}
