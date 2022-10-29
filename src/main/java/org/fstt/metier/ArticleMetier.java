package org.fstt.metier;

import java.util.List;

import org.fstt.entities.Article;

public interface ArticleMetier {
	public Article saveArticle(Article article);
	
	public Article updateArticle(Article article, Integer id);
	
	public Article getArticle(Integer id);
	
	public void deleteArticle(Integer id);
	
	public List<Article> listArticle();
}
