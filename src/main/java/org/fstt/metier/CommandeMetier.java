package org.fstt.metier;

import java.util.List;

import org.fstt.entities.Commande;

public interface CommandeMetier {
	public Commande saveCommande(Commande commande, Long id);
	
	public Commande updateCommande(Commande commande, Long id);
	
	public Commande getCommande(Long id);
	
	public void deleteCommande(Long id);
	
	public List<Commande> listCommande();

}
