package org.fstt.metier;

import java.util.List;

import org.fstt.dao.FournisseurRepository;
import org.fstt.dao.SocieteRepository;
import org.fstt.entities.Fournisseur;
import org.fstt.entities.Societe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocieteMetierImpl implements SocieteMetier{

	@Autowired
	private SocieteRepository societeRepository;
	
	@Autowired
	private FournisseurRepository fournisseurRepository;
	
	@Override
	public Societe saveSociete(Societe societe, Long id) {
		Fournisseur fournisseur = fournisseurRepository.findById(id).get();
		fournisseur.addSociete(societe);
		return societeRepository.save(societe);
	}

	@Override
	public Societe updateSociete(Societe societe, String uniqueName) {
		Societe existSociete = societeRepository.findById(uniqueName).get();
		
		existSociete.setFaxSociete(societe.getFaxSociete());
		
		existSociete.setFournisseur(societe.getFournisseur());
		
		existSociete.setTelephoneSociete(societe.getTelephoneSociete());
		
		existSociete.setVilleSociete(societe.getVilleSociete());
		
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
