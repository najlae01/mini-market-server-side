package org.fstt.metier;

import java.util.List;

import org.fstt.entities.LigneLivraison;

public interface LigneLivraisonMetier {
	public LigneLivraison saveLigneLivraison(LigneLivraison ligneLivraison, Long id);
	
	public LigneLivraison updateLigneLivraison(LigneLivraison ligneLivraison, Long id);
	
	public LigneLivraison getLigneLivraison(Long id);
	
	public void deleteLigneLivraison(Long id);
	
	public List<LigneLivraison> listLigneLivraison();
}
