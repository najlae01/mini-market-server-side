package org.fstt.service;

import java.util.List;

import org.fstt.entities.Fournisseur;
import org.fstt.metier.FournisseurMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FournisseurRestService {
	@Autowired
	private FournisseurMetier fournisseurMetier;
	
	@RequestMapping(value = "/add/fournisseur", method = RequestMethod.POST)
	public Fournisseur addFournisseur(@RequestBody Fournisseur fournisseur) {
		return fournisseurMetier.saveFournisseur(fournisseur);
	}
	
	@RequestMapping(value = "/update/fournisseur/{id}", method = RequestMethod.PUT)
	public Fournisseur updateFournisseur(@RequestBody Fournisseur fournisseur, @PathVariable Long id) {
		return fournisseurMetier.updateFournisseur(fournisseur, id);
	}
	
	@RequestMapping(value = "/get/fournisseur/{id}", method = RequestMethod.GET)
	public Fournisseur getFournisseur(@PathVariable Long id) {
		return fournisseurMetier.getFournisseur(id);
	}
	
	@RequestMapping(value = "/get/fournisseur/user/{id}", method = RequestMethod.GET)
	public Fournisseur getFournisseurByUser(@PathVariable Long id) {
		return fournisseurMetier.getFournisseurByUser(id);
	}
	
	@RequestMapping(value = "/delete/fournisseur/{id}", method = RequestMethod.DELETE)
	public void deleteFournisseur(@PathVariable Long id) {
		fournisseurMetier.deleteFournisseur(id);
	}
	
	@RequestMapping(value = "/get/fournisseurs", method = RequestMethod.GET)
	public List<Fournisseur> listFournisseur() {
		return fournisseurMetier.listFournisseur();
	}
}
