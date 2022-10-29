package org.fstt.metier;

import java.util.List;

import org.fstt.dao.SocieteRepository;
import org.fstt.entities.Client;
import org.fstt.entities.Societe;
import org.springframework.beans.factory.annotation.Autowired;

public class SocieteMetierImpl implements SocieteMetier{

	@Autowired
	private SocieteRepository societeRepository;
	
	@Override
	public Societe saveSociete(Societe societe) {
		return societeRepository.save(societe);
	}

	@Override
	public Societe updateSociete(Societe societe, String uniqueName) {
		Societe existSociete = societeRepository.findById(uniqueName).get();
		
		societe.setFaxSociete(societe.getFaxSociete());
		
		societe.setFournisseur(societe.getFournisseur());
		
		societe.setTelephoneSociete(societe.getTelephoneSociete());
		
		societe.setVilleSociete(societe.getVilleSociete());
		
		return societeRepository.save(existSociete);
	}

	@Override
	public Societe getSociete(String uniqueName) {
		return societeRepository.findById(uniqueName).get();
	}

	@Override
	public void deleteSociete(String uniqueName) {
		societeRepository.deleteById(uniqueName);
	}

	@Override
	public List<Societe> listSociete() {
		return societeRepository.findAll();
	}

}
