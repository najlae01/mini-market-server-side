package org.fstt.service;

import java.util.List;

import org.fstt.entities.Societe;
import org.fstt.metier.SocieteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SocieteRestService {
	@Autowired
	private SocieteMetier societeMetier;
	
	@RequestMapping(value = "/add/societe/{id}", method = RequestMethod.POST)
	public Societe addSociete(@RequestBody Societe societe, @PathVariable Long id) {
		return societeMetier.saveSociete(societe, id);
	}
	
	@RequestMapping(value = "/update/societe/{id}", method = RequestMethod.PUT)
	public Societe updateSociete(@RequestBody Societe societe, @PathVariable String uniqueName) {
		return societeMetier.updateSociete(societe, uniqueName);
	}
	
	@RequestMapping(value = "/get/societe/{id}", method = RequestMethod.GET)
	public Societe getSociete(@PathVariable String uniqueName) {
		return societeMetier.getSociete(uniqueName);
	}
	
	@RequestMapping(value = "/delete/societe/{id}", method = RequestMethod.DELETE)
	public void deleteSociete(@PathVariable String uniqueName) {
		societeMetier.deleteSociete(uniqueName);
	}
	
	@RequestMapping(value = "/get/societes", method = RequestMethod.GET)
	public List<Societe> listSociete() {
		return societeMetier.listSociete();
	}
}
