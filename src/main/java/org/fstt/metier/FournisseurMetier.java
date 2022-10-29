package org.fstt.metier;

import java.util.List;

import org.fstt.entities.Fournisseur;

public interface FournisseurMetier {
	public Fournisseur saveFournisseur(Fournisseur fournisseur);
	
	public Fournisseur updateFournisseur(Fournisseur fournisseur, Integer id);
	
	public Fournisseur getFournisseur(Integer id);
	
	public void deleteFournisseur(Integer id);
	
	public List<Fournisseur> listFournisseur();
}
