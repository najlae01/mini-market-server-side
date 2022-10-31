package org.fstt.service;

import java.util.List;

import org.fstt.entities.Article;
import org.fstt.metier.ArticleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class ArticleRestService {

	@Autowired
	private ArticleMetier articleMetier;
	
	@RequestMapping(value = "/addArticle", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
	@ResponseBody
	public String addArticle(Article article, @RequestParam("file") MultipartFile file) {
		return articleMetier.saveArticle(article, file);
	}
	
	@RequestMapping(value = "/updateArticle/{id}", method = RequestMethod.PUT)
	public Article updateArticle(@RequestBody Article article, @PathVariable Long id) {
		return articleMetier.updateArticle(article, id);
	}
	
	@RequestMapping(value = "/getArticle/{id}", method = RequestMethod.GET)
	public Article getArticle(@PathVariable Long id) {
		return articleMetier.getArticle(id);
	}
	
	@RequestMapping(value = "/deleteArticle/{id}", method = RequestMethod.DELETE)
	public void deleteArticle(@PathVariable Long id) {
		articleMetier.deleteArticle(id);
	}
	
	@RequestMapping(value = "/articles", method = RequestMethod.GET)
	public List<Article> listArticle() {
		return articleMetier.listArticle();
	}
}
