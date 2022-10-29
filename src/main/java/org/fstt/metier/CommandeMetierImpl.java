package org.fstt.metier;

import java.util.List;

import org.fstt.dao.CommandeRepository;
import org.fstt.entities.Client;
import org.fstt.entities.Commande;
import org.springframework.beans.factory.annotation.Autowired;

public class CommandeMetierImpl implements CommandeMetier{

	@Autowired
	private CommandeRepository commandeRepository;
	
	@Override
	public Commande saveCommande(Commande commande) {
		return commandeRepository.save(commande);
	}

	@Override
	public Commande updateCommande(Commande commande, Integer id) {
		Commande existCommande = commandeRepository.findById(id).get();
		
		commande.setClient(commande.getClient());
		
		commande.setDateCommande(commande.getDateCommande());
		
		commande.setLignesCmd(commande.getLignesCmd());
		
		return commandeRepository.save(existCommande);
	}

	@Override
	public Commande getCommande(Integer id) {
		return commandeRepository.findById(id).get();
	}

	@Override
	public void deleteCommande(Integer id) {
		commandeRepository.deleteById(id);
	}

	@Override
	public List<Commande> listCommande() {
		return commandeRepository.findAll();
	}

}
