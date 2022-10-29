package org.fstt.metier;

import java.util.List;

import org.fstt.dao.LigneLivraisonRepository;
import org.fstt.entities.Client;
import org.fstt.entities.LigneLivraison;
import org.springframework.stereotype.Service;

@Service
public class LigneLivraisonMetierImpl implements LigneLivraisonMetier{

	LigneLivraisonRepository ligneLivraisonRepository;
	
	@Override
	public LigneLivraison saveLigneLivraison(LigneLivraison ligneLivraison) {
		return ligneLivraisonRepository.save(ligneLivraison);
	}

	@Override
	public LigneLivraison updateLigneLivraison(LigneLivraison ligneLivraison, Integer id) {
		LigneLivraison existLigneLivraison = ligneLivraisonRepository.findById(id).get();
		
		existLigneLivraison.setArticle(ligneLivraison.getArticle());
		
		existLigneLivraison.setLivraison(ligneLivraison.getLivraison());
		
		existLigneLivraison.setQuantiteLivraison(ligneLivraison.getQuantiteLivraison());
		
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
