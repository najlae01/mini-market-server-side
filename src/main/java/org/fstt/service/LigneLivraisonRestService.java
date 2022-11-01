package org.fstt.service;

import java.util.List;

import org.fstt.entities.LigneLivraison;
import org.fstt.metier.LigneLivraisonMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LigneLivraisonRestService {
	@Autowired
	private LigneLivraisonMetier ligneLivraisonMetier;
	
	@RequestMapping(value = "/add/lignelivraison/{id}", method = RequestMethod.POST)
	public LigneLivraison addLigneLivraison(@RequestBody LigneLivraison ligneLivraison, @PathVariable Long id) {
		return ligneLivraisonMetier.saveLigneLivraison(ligneLivraison, id);
	}
	
	@RequestMapping(value = "/update/lignelivraison/{id}", method = RequestMethod.PUT)
	public LigneLivraison updateLigneLivraison(@RequestBody LigneLivraison ligneLivraison, @PathVariable Long id) {
		return ligneLivraisonMetier.updateLigneLivraison(ligneLivraison, id);
	}
	
	@RequestMapping(value = "/get/lignelivraison/{id}", method = RequestMethod.GET)
	public LigneLivraison getLigneLivraison(@PathVariable Long id) {
		return ligneLivraisonMetier.getLigneLivraison(id);
	}
	
	@RequestMapping(value = "/delete/lignelivraison/{id}", method = RequestMethod.DELETE)
	public void deleteLigneLivraison(@PathVariable Long id) {
		ligneLivraisonMetier.deleteLigneLivraison(id);
	}
	
	@RequestMapping(value = "/get/lignelivraisons", method = RequestMethod.GET)
	public List<LigneLivraison> listLigneLivraison() {
		return ligneLivraisonMetier.listLigneLivraison();
	}
}
