package org.fstt.service;

import java.util.List;

import org.fstt.entities.Article;
import org.fstt.metier.ArticleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ArticleRestService {

	@Autowired
	private ArticleMetier articleMetier;
	
	@RequestMapping(value = "/add/article", method = RequestMethod.POST)
	@ResponseBody
	public Article addArticle(@RequestBody Article article) {
		return articleMetier.saveArticle(article);
	}
	
	@RequestMapping(value = "/update/article/{id}", method = RequestMethod.PUT)
	public Article updateArticle(@RequestBody Article article, @PathVariable Long id) {
		return articleMetier.updateArticle(article, id);
	}
	
	@RequestMapping(value = "/get/article/{id}", method = RequestMethod.GET)
	public Article getArticle(@PathVariable Long id) {
		return articleMetier.getArticle(id);
	}
	
	@RequestMapping(value = "/delete/article/{id}", method = RequestMethod.DELETE)
	public void deleteArticle(@PathVariable Long id) {
		articleMetier.deleteArticle(id);
	}
	
	@RequestMapping(value = "/get/articles", method = RequestMethod.GET)
	public List<Article> listArticle() {
		return articleMetier.listArticle();
	}
}
