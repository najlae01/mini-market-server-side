package org.fstt.metier;

import java.util.List;

import org.fstt.dao.LigneCommandeRepository;
import org.fstt.entities.Client;
import org.fstt.entities.LigneCommande;
import org.springframework.beans.factory.annotation.Autowired;

public class LigneCommandeMetierImpl implements LigneCommandeMetier{

	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;
	
	@Override
	public LigneCommande saveLigneCommande(LigneCommande ligneCommande) {
		return ligneCommandeRepository.save(ligneCommande);
	}

	@Override
	public LigneCommande updateLigneCommande(LigneCommande ligneCommande, Integer id) {
		LigneCommande existLigneCommande = ligneCommandeRepository.findById(id).get();
		
		ligneCommande.setArticle(ligneCommande.getArticle());
		
		ligneCommande.setCommande(ligneCommande.getCommande());
		
		ligneCommande.setQuantiteCommande(ligneCommande.getQuantiteCommande());
		
		return ligneCommandeRepository.save(existLigneCommande);
	}

	@Override
	public LigneCommande getLigneCommande(Integer id) {
		return ligneCommandeRepository.findById(id).get();
	}

	@Override
	public void deleteLigneCommande(Integer id) {
		ligneCommandeRepository.deleteById(id);
	}

	@Override
	public List<LigneCommande> listLigneCommande() {
		return ligneCommandeRepository.findAll();
	}

}
