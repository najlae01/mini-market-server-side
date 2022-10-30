package org.fstt.service;

import java.util.List;

import org.fstt.entities.Fournisseur;
import org.fstt.metier.FournisseurMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FournisseurRestService {
	@Autowired
	private FournisseurMetier fournisseurMetier;
	
	@RequestMapping(value = "/addFournisseur", method = RequestMethod.POST)
	public Fournisseur addFournisseur(@RequestBody Fournisseur fournisseur) {
		return fournisseurMetier.saveFournisseur(fournisseur);
	}
	
	@RequestMapping(value = "/updateFournisseur/{id}", method = RequestMethod.PUT)
	public Fournisseur updateFournisseur(@RequestBody Fournisseur fournisseur, @PathVariable Long id) {
		return fournisseurMetier.updateFournisseur(fournisseur, id);
	}
	
	@RequestMapping(value = "/getFournisseur/{id}", method = RequestMethod.GET)
	public Fournisseur getFournisseur(@PathVariable Long id) {
		return fournisseurMetier.getFournisseur(id);
	}
	
	@RequestMapping(value = "/deleteFournisseur/{id}", method = RequestMethod.DELETE)
	public void deleteFournisseur(@PathVariable Long id) {
		fournisseurMetier.deleteFournisseur(id);
	}
	
	@RequestMapping(value = "/fournisseurs", method = RequestMethod.GET)
	public List<Fournisseur> listFournisseur() {
		return fournisseurMetier.listFournisseur();
	}
}
