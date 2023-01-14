package org.fstt.metier;

import java.util.List;

import org.fstt.dao.ArticleRepository;
import org.fstt.dao.CommandeRepository;
import org.fstt.dao.LigneCommandeRepository;
import org.fstt.entities.Article;
import org.fstt.entities.Commande;
import org.fstt.entities.LigneCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LigneCommandeMetierImpl implements LigneCommandeMetier{

	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private CommandeRepository commandeRepository;
	
	@Override
	public LigneCommande saveLigneCommande(LigneCommande ligneCommande, Long id) {
		//Commande commande = commandeRepository.findById(id).get();
		//commande.addLigneCommande(ligneCommande);
		Article article = articleRepository.findById(id).get();
		ligneCommande.setArticle(article);
		/*Commande commande = ligneCommande.getCommande();
		Commande existsCommande = commandeRepository.findById(commande.getNumeroCommande()).get();
		ligneCommande.setCommande(existsCommande);*/
		return ligneCommandeRepository.save(ligneCommande);
	}

	@Override
	public LigneCommande updateLigneCommande(LigneCommande ligneCommande, Long id) {
		LigneCommande existLigneCommande = ligneCommandeRepository.findById(id).get();
		
		if(ligneCommande.getQuantiteCommande()!= null)
			existLigneCommande.setQuantiteCommande(ligneCommande.getQuantiteCommande());
		
		return ligneCommandeRepository.save(existLigneCommande);
	}

	@Override
	public LigneCommande getLigneCommande(Long id) {
		return ligneCommandeRepository.findById(id).get();
	}

	@Override
	public void deleteLigneCommande(Long id) {
		ligneCommandeRepository.deleteById(id);
	}

	@Override
	public List<LigneCommande> listLigneCommande() {
		return ligneCommandeRepository.findAll();
	}

}
