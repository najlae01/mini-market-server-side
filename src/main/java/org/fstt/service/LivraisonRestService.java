package org.fstt.service;

import java.util.List;

import org.fstt.entities.Livraison;
import org.fstt.metier.LivraisonMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LivraisonRestService {
	@Autowired
	private LivraisonMetier livraisonMetier;
	
	@RequestMapping(value = "/add/livraison/{id}", method = RequestMethod.POST)
	public Livraison addLivraison(@RequestBody Livraison livraison,@PathVariable Long id) {
		return livraisonMetier.saveLivraison(livraison, id);
	}
	
	@RequestMapping(value = "/update/livraison/{id}", method = RequestMethod.PUT)
	public Livraison updateLivraison(@RequestBody Livraison livraison, @PathVariable Long id) {
		return livraisonMetier.updateLivraison(livraison, id);
	}
	
	@RequestMapping(value = "/get/livraison/{id}", method = RequestMethod.GET)
	public Livraison getLivraison(@PathVariable Long id) {
		return livraisonMetier.getLivraison(id);
	}
	
	@RequestMapping(value = "/delete/livraison/{id}", method = RequestMethod.DELETE)
	public void deleteLivraison(@PathVariable Long id) {
		livraisonMetier.deleteLivraison(id);
	}
	
	@RequestMapping(value = "/get/livraisons", method = RequestMethod.GET)
	public List<Livraison> listLivraison() {
		return livraisonMetier.listLivraison();
	}
}
