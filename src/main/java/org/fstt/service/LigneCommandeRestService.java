package org.fstt.service;

import java.util.List;

import org.fstt.entities.LigneCommande;
import org.fstt.metier.LigneCommandeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LigneCommandeRestService {
	@Autowired
	private LigneCommandeMetier ligneCommandeMetier;
	
	@RequestMapping(value = "/addLigneCommande", method = RequestMethod.POST)
	public LigneCommande addLigneCommande(@RequestBody LigneCommande ligneCommande) {
		return ligneCommandeMetier.saveLigneCommande(ligneCommande);
	}
	
	@RequestMapping(value = "/updateLigneCommande/{id}", method = RequestMethod.PUT)
	public LigneCommande updateLigneCommande(@RequestBody LigneCommande ligneCommande, @PathVariable Integer id) {
		return ligneCommandeMetier.updateLigneCommande(ligneCommande, id);
	}
	
	@RequestMapping(value = "/getLigneCommande/{id}", method = RequestMethod.GET)
	public LigneCommande getLigneLigneCommande(@PathVariable Integer id) {
		return ligneCommandeMetier.getLigneCommande(id);
	}
	
	@RequestMapping(value = "/deleteLigneCommande/{id}", method = RequestMethod.DELETE)
	public void deleteLigneCommande(@PathVariable Integer id) {
		ligneCommandeMetier.deleteLigneCommande(id);
	}
	
	@RequestMapping(value = "/ligneCommandes", method = RequestMethod.GET)
	public List<LigneCommande> listLigneCommande() {
		return ligneCommandeMetier.listLigneCommande();
	}
}
