package org.fstt.metier;

import java.util.List;

import org.fstt.dao.LigneLivraisonRepository;
import org.fstt.entities.Client;
import org.fstt.entities.LigneLivraison;

public class LigneLivraisonMetierImpl implements LigneLivraisonMetier{

	LigneLivraisonRepository ligneLivraisonRepository;
	
	@Override
	public LigneLivraison saveLigneLivraison(LigneLivraison ligneLivraison) {
		return ligneLivraisonRepository.save(ligneLivraison);
	}

	@Override
	public LigneLivraison updateLigneLivraison(LigneLivraison ligneLivraison, Integer id) {
		LigneLivraison existLigneLivraison = ligneLivraisonRepository.findById(id).get();
		
		ligneLivraison.setArticle(ligneLivraison.getArticle());
		
		ligneLivraison.setLivraison(ligneLivraison.getLivraison());
		
		ligneLivraison.setQuantiteLivraison(ligneLivraison.getQuantiteLivraison());
		
		return ligneLivraisonRepository.save(existLigneLivraison);
	}

	@Override
	public LigneLivraison getLigneLivraison(Integer id) {
		return ligneLivraisonRepository.findById(id).get();
	}

	@Override
	public void deleteLigneLivraison(Integer id) {
		ligneLivraisonRepository.deleteById(id);
	}

	@Override
	public List<LigneLivraison> listLigneLivraison() {
		return ligneLivraisonRepository.findAll();
	}

}
