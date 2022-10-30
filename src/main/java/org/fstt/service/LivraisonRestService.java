package org.fstt.service;

import java.util.List;

import org.fstt.entities.Livraison;
import org.fstt.metier.LivraisonMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivraisonRestService {
	@Autowired
	private LivraisonMetier livraisonMetier;
	
	@RequestMapping(value = "/addLivraison/{id}", method = RequestMethod.POST)
	public Livraison addLivraison(@RequestBody Livraison livraison,@PathVariable Integer id) {
		return livraisonMetier.saveLivraison(livraison, id);
	}
	
	@RequestMapping(value = "/updateLivraison/{id}", method = RequestMethod.PUT)
	public Livraison updateLivraison(@RequestBody Livraison livraison, @PathVariable Long id) {
		return livraisonMetier.updateLivraison(livraison, id);
	}
	
	@RequestMapping(value = "/getLivraison/{id}", method = RequestMethod.GET)
	public Livraison getLivraison(@PathVariable Long id) {
		return livraisonMetier.getLivraison(id);
	}
	
	@RequestMapping(value = "/deleteLivraison/{id}", method = RequestMethod.DELETE)
	public void deleteLivraison(@PathVariable Long id) {
		livraisonMetier.deleteLivraison(id);
	}
	
	@RequestMapping(value = "/livraisons", method = RequestMethod.GET)
	public List<Livraison> listLivraison() {
		return livraisonMetier.listLivraison();
	}
}
