package org.fstt.metier;

import java.util.List;

import org.fstt.entities.LigneCommande;

public interface LigneCommandeMetier {
	public LigneCommande saveLigneCommande(LigneCommande ligneCommande, Long id);
	
	public LigneCommande updateLigneCommande(LigneCommande ligneCommande, Long id);
	
	public LigneCommande getLigneCommande(Long id);
	
	public void deleteLigneCommande(Long id);
	
	public List<LigneCommande> listLigneCommande();
}
