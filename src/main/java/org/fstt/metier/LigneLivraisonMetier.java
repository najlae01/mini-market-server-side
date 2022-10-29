package org.fstt.metier;

import java.util.List;

import org.fstt.entities.LigneLivraison;

public interface LigneLivraisonMetier {
	public LigneLivraison saveLigneLivraison(LigneLivraison ligneLivraison);
	
	public LigneLivraison updateLigneLivraison(LigneLivraison ligneLivraison, Integer id);
	
	public LigneLivraison getLigneLivraison(Integer id);
	
	public void deleteLigneLivraison(Integer id);
	
	public List<LigneLivraison> listLigneLivraison();
}
