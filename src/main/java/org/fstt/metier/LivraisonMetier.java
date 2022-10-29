package org.fstt.metier;

import java.util.List;

import org.fstt.entities.Livraison;

public interface LivraisonMetier {
	public Livraison saveLivraison(Livraison livraison);
	
	public Livraison updateLivraison(Livraison livraison, Integer id);
	
	public Livraison getLivraison(Integer id);
	
	public void deleteLivraison(Integer id);
	
	public List<Livraison> listLivraison();
}
