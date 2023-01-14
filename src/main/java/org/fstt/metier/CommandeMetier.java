package org.fstt.metier;

import java.util.List;

import org.fstt.entities.Commande;
import org.fstt.entities.LigneCommande;

public interface CommandeMetier {
	public Commande saveCommande(Commande commande);
	
	public Commande updateCommande(Commande commande, Long id);
	
	public Commande getCommande(Long id);
	
	public void deleteCommande(Long id);
	
	public List<Commande> listCommande();
	
	public List<Commande> listCommandeByClient(Long clientId);

}
