package org.fstt.metier;

import java.util.List;

import org.fstt.dao.LigneLivraisonRepository;
import org.fstt.dao.LivraisonRepository;
import org.fstt.entities.LigneLivraison;
import org.fstt.entities.Livraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LigneLivraisonMetierImpl implements LigneLivraisonMetier{

	@Autowired
	private LigneLivraisonRepository ligneLivraisonRepository;
	
	@Autowired
	private LivraisonRepository livraisonRepository;
	
	@Override
	public LigneLivraison saveLigneLivraison(LigneLivraison ligneLivraison, Long id) {
		Livraison livraison = livraisonRepository.findById(id).get();
		livraison.addLigneLivraison(ligneLivraison);
		return ligneLivraisonRepository.save(ligneLivraison);
	}

	@Override
	public LigneLivraison updateLigneLivraison(LigneLivraison ligneLivraison, Long id) {
		LigneLivraison existLigneLivraison = ligneLivraisonRepository.findById(id).get();
		
		existLigneLivraison.setArticle(ligneLivraison.getArticle());
		
		existLigneLivraison.setLivraison(ligneLivraison.getLivraison());
		
		existLigneLivraison.setQuantiteLivraison(ligneLivraison.getQuantiteLivraison());
		
		return ligneLivraisonRepository.save(existLigneLivraison);
	}

	@Override
	public LigneLivraison getLigneLivraison(Long id) {
		return ligneLivraisonRepository.findById(id).get();
	}

	@Override
	public void deleteLigneLivraison(Long id) {
		ligneLivraisonRepository.deleteById(id);
	}

	@Override
	public List<LigneLivraison> listLigneLivraison() {
		return ligneLivraisonRepository.findAll();
	}

}
