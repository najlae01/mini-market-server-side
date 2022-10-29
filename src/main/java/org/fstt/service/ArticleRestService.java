package org.fstt.service;

import java.util.List;

import org.fstt.entities.Article;
import org.fstt.metier.ArticleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleRestService {

	@Autowired
	private ArticleMetier articleMetier;
	
	@RequestMapping(value = "/addArticle", method = RequestMethod.POST)
	public Article addArticle(@RequestBody Article article) {
		return articleMetier.saveArticle(article);
	}
	
	@RequestMapping(value = "/updateArticle/{id}", method = RequestMethod.PUT)
	public Article updateArticle(@RequestBody Article article, @PathVariable Integer id) {
		return articleMetier.updateArticle(article, id);
	}
	
	@RequestMapping(value = "/getArticle/{id}", method = RequestMethod.GET)
	public Article getArticle(@PathVariable Integer id) {
		return articleMetier.getArticle(id);
	}
	
	@RequestMapping(value = "/deleteArticle/{id}", method = RequestMethod.DELETE)
	public void deleteArticle(@PathVariable Integer id) {
		articleMetier.deleteArticle(id);
	}
	
	@RequestMapping(value = "/articles", method = RequestMethod.GET)
	public List<Article> listArticle() {
		return articleMetier.listArticle();
	}
}
