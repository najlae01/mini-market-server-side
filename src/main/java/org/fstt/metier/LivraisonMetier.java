package org.fstt.metier;

import java.util.List;

import org.fstt.entities.Livraison;

public interface LivraisonMetier {
	public Livraison saveLivraison(Livraison livraison, Long id);
	
	public Livraison updateLivraison(Livraison livraison, Long id);
	
	public Livraison getLivraison(Long id);
	
	public void deleteLivraison(Long id);
	
	public List<Livraison> listLivraison();
}
