package org.fstt.metier;

import java.util.List;

import org.fstt.dao.FournisseurRepository;
import org.fstt.dao.LivraisonRepository;
import org.fstt.entities.Fournisseur;
import org.fstt.entities.Livraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivraisonMetierImpl implements LivraisonMetier{

	@Autowired
	private LivraisonRepository livraisonRepository;
	
	@Autowired
	private FournisseurRepository fournisseurRepository;
	
	@Override
	public Livraison saveLivraison(Livraison livraison, Long id) {
		Fournisseur fournisseur = fournisseurRepository.findById(id).get();
		fournisseur.addLivraison(livraison);
		return livraisonRepository.save(livraison);
	}

	@Override
	public Livraison updateLivraison(Livraison livraison, Long id) {
		Livraison existLivraison = livraisonRepository.findById(id).get();
		
		existLivraison.setFournisseur(livraison.getFournisseur());
		
		existLivraison.setDateLivraison(livraison.getDateLivraison());
		
		existLivraison.setLignesLiv(livraison.getLignesLiv());
		
		return livraisonRepository.save(existLivraison);
	}

	@Override
	public Livraison getLivraison(Long id) {
		return livraisonRepository.findById(id).get();
	}

	@Override
	public void deleteLivraison(Long id) {
		livraisonRepository.deleteById(id);
	}

	@Override
	public List<Livraison> listLivraison() {
		return livraisonRepository.findAll();
	}

}
