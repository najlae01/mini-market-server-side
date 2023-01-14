package org.fstt.metier;

import java.util.Date;
import java.util.List;

import org.fstt.dao.ClientRepository;
import org.fstt.dao.CommandeRepository;
import org.fstt.entities.Client;
import org.fstt.entities.Commande;
import org.fstt.entities.LigneCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeMetierImpl implements CommandeMetier{

	@Autowired
	private CommandeRepository commandeRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public Commande saveCommande(Commande commande) {
		//Client client = clientRepository.findById(id).get();
		//commande.setClient(client);
		//System.out.println(client.toString());
		//commande.setLignesCmd(ligneCommandes);
		commande.setDateCommande(new Date());
		return commandeRepository.save(commande);
	}

	@Override
	public Commande updateCommande(Commande commande, Long id) {
		Commande existCommande = commandeRepository.findById(id).get();
		
		existCommande.setClient(commande.getClient());
		
		existCommande.setDateCommande(commande.getDateCommande());
		
		existCommande.setLignesCmd(commande.getLignesCmd());
		
		return commandeRepository.save(existCommande);
	}

	@Override
	public Commande getCommande(Long id) {
		return commandeRepository.findById(id).get();
	}

	@Override
	public void deleteCommande(Long id) {
		commandeRepository.deleteById(id);
	}

	@Override
	public List<Commande> listCommande() {
		return commandeRepository.findAll();
	}
	
	@Override
	public List<Commande> listCommandeByClient(Long clientId) {
		List<Commande> commandes = commandeRepository.findAllByClientCodeClient(clientId);
		System.out.println(commandes);
		return commandes;
	}

}
