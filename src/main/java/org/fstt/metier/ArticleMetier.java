package org.fstt.metier;

import java.util.List;

import org.fstt.entities.Article;
import org.springframework.web.multipart.MultipartFile;

public interface ArticleMetier {
	public String saveArticle(Article article);
	
	public Article updateArticle(Article article, Long id);
	
	public Article getArticle(Long id);
	
	public void deleteArticle(Long id);
	
	public List<Article> listArticle();
}
