package org.fstt.service;

import java.util.List;

import org.fstt.entities.Commande;
import org.fstt.entities.LigneCommande;
import org.fstt.metier.CommandeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CommandeRestService {
	@Autowired
	private CommandeMetier commandeMetier;
	
	@RequestMapping(value = "/add/commande", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Commande addCommande(@RequestBody Commande commande) {
		return commandeMetier.saveCommande(commande);
	}
	
	@RequestMapping(value = "/update/commande/{id}", method = RequestMethod.PUT)
	public Commande updateCommande(@RequestBody Commande commande, @PathVariable Long id) {
		return commandeMetier.updateCommande(commande, id);
	}
	
	@RequestMapping(value = "/get/commande/{id}", method = RequestMethod.GET)
	public Commande getCommande(@PathVariable Long id) {
		return commandeMetier.getCommande(id);
	}
	
	@RequestMapping(value = "/delete/commande/{id}", method = RequestMethod.DELETE)
	public void deleteCommande(@PathVariable Long id) {
		commandeMetier.deleteCommande(id);
	}
	
	@RequestMapping(value = "/get/commandes", method = RequestMethod.GET)
	public List<Commande> listCommande() {
		return commandeMetier.listCommande();
	}
	@RequestMapping(value = "/get/commandes/{id}", method = RequestMethod.GET)
	public List<Commande> listCommandeByClient(@PathVariable Long id) {
		return commandeMetier.listCommandeByClient(id);
	}
	
}
