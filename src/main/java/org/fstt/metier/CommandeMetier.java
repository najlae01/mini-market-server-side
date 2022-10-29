package org.fstt.metier;

import java.util.List;

import org.fstt.entities.Commande;

public interface CommandeMetier {
	public Commande saveCommande(Commande commande, Integer id);
	
	public Commande updateCommande(Commande commande, Integer id);
	
	public Commande getCommande(Integer id);
	
	public void deleteCommande(Integer id);
	
	public List<Commande> listCommande();

}
