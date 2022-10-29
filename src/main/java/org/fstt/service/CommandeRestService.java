package org.fstt.service;

import java.util.List;

import org.fstt.entities.Commande;
import org.fstt.metier.CommandeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandeRestService {
	@Autowired
	private CommandeMetier commandeMetier;
	
	@RequestMapping(value = "/addCommande/{id}", method = RequestMethod.POST)
	public Commande addCommande(@RequestBody Commande commande, @PathVariable Integer id) {
		return commandeMetier.saveCommande(commande, id);
	}
	
	@RequestMapping(value = "/updateCommande/{id}", method = RequestMethod.PUT)
	public Commande updateCommande(@RequestBody Commande commande, @PathVariable Integer id) {
		return commandeMetier.updateCommande(commande, id);
	}
	
	@RequestMapping(value = "/getCommande/{id}", method = RequestMethod.GET)
	public Commande getCommande(@PathVariable Integer id) {
		return commandeMetier.getCommande(id);
	}
	
	@RequestMapping(value = "/deleteCommande/{id}", method = RequestMethod.DELETE)
	public void deleteCommande(@PathVariable Integer id) {
		commandeMetier.deleteCommande(id);
	}
	
	@RequestMapping(value = "/commandes", method = RequestMethod.GET)
	public List<Commande> listCommande() {
		return commandeMetier.listCommande();
	}
}
