package org.fstt.metier;

import java.util.List;

import org.fstt.entities.LigneCommande;

public interface LigneCommandeMetier {
	public LigneCommande saveLigneCommande(LigneCommande ligneCommande);
	
	public LigneCommande updateLigneCommande(LigneCommande ligneCommande, Integer id);
	
	public LigneCommande getLigneCommande(Integer id);
	
	public void deleteLigneCommande(Integer id);
	
	public List<LigneCommande> listLigneCommande();
}
