package org.fstt.metier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import org.fstt.dao.ArticleRepository;
import org.fstt.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArticleMetierImpl implements ArticleMetier{

	@Autowired
	private ArticleRepository articleRepository;
	
	public static String uploadDirectory = System.getProperty("user.dir")+ "/src/main/resources/static/images/";
	
	@Override
	public String saveArticle(String nomArticle, Integer prixUnitaire,
			Integer quantite_stock, MultipartFile file) {
		Article article = new Article(nomArticle, prixUnitaire, quantite_stock);
		Date date = new Date();
		String filename = date.hashCode() + file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
		Path filenameAndPath = Paths.get(uploadDirectory, filename);
		try {
			Files.write(filenameAndPath, file.getBytes());
		}catch(IOException e) {
			e.printStackTrace();
		}
		article.setImageArticle(filename);
		articleRepository.save(article);
		return article.toString();
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
