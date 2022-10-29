package org.fstt.metier;

import java.util.List;

import org.fstt.dao.LivraisonRepository;
import org.fstt.entities.Client;
import org.fstt.entities.Livraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivraisonMetierImpl implements LivraisonMetier{

	@Autowired
	private LivraisonRepository livraisonRepository;
	
	@Override
	public Livraison saveLivraison(Livraison livraison) {
		return livraisonRepository.save(livraison);
	}

	@Override
	public Livraison updateLivraison(Livraison livraison, Integer id) {
		Livraison existLivraison = livraisonRepository.findById(id).get();
		
		existLivraison.setFournisseur(livraison.getFournisseur());
		
		existLivraison.setDateLivraison(livraison.getDateLivraison());
		
		existLivraison.setLignesLiv(livraison.getLignesLiv());
		
		return livraisonRepository.save(existLivraison);
	}

	@Override
	public Livraison getLivraison(Integer id) {
		return livraisonRepository.findById(id).get();
	}

	@Override
	public void deleteLivraison(Integer id) {
		livraisonRepository.deleteById(id);
	}

	@Override
	public List<Livraison> listLivraison() {
		return livraisonRepository.findAll();
	}

}
