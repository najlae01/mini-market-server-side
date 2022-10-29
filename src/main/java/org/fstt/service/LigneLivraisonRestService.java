package org.fstt.service;

import java.util.List;

import org.fstt.entities.LigneLivraison;
import org.fstt.metier.LigneLivraisonMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LigneLivraisonRestService {
	@Autowired
	private LigneLivraisonMetier ligneLivraisonMetier;
	
	@RequestMapping(value = "/addLigneLivraison", method = RequestMethod.POST)
	public LigneLivraison addLigneLivraison(@RequestBody LigneLivraison ligneLivraison) {
		return ligneLivraisonMetier.saveLigneLivraison(ligneLivraison);
	}
	
	@RequestMapping(value = "/updateLigneLivraison/{id}", method = RequestMethod.PUT)
	public LigneLivraison updateLigneLivraison(@RequestBody LigneLivraison ligneLivraison, @PathVariable Integer id) {
		return ligneLivraisonMetier.updateLigneLivraison(ligneLivraison, id);
	}
	
	@RequestMapping(value = "/getLigneLivraison/{id}", method = RequestMethod.GET)
	public LigneLivraison getLigneLivraison(@PathVariable Integer id) {
		return ligneLivraisonMetier.getLigneLivraison(id);
	}
	
	@RequestMapping(value = "/deleteLigneLivraison/{id}", method = RequestMethod.DELETE)
	public void deleteLigneLivraison(@PathVariable Integer id) {
		ligneLivraisonMetier.deleteLigneLivraison(id);
	}
	
	@RequestMapping(value = "/LigneLivraisons", method = RequestMethod.GET)
	public List<LigneLivraison> listLigneLivraison() {
		return ligneLivraisonMetier.listLigneLivraison();
	}
}
