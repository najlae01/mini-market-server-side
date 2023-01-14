package org.fstt.metier;

import java.util.List;

import org.fstt.entities.Fournisseur;

public interface FournisseurMetier {
	public Fournisseur saveFournisseur(Fournisseur fournisseur);
	
	public Fournisseur updateFournisseur(Fournisseur fournisseur, Long id);
	
	public Fournisseur getFournisseur(Long id);
	
	public Fournisseur getFournisseurByUser(Long id);
	
	public void deleteFournisseur(Long id);
	
	public List<Fournisseur> listFournisseur();
}
