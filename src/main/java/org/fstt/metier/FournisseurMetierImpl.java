package org.fstt.metier;

import java.util.List;

import org.fstt.dao.FournisseurRepository;
import org.fstt.entities.Client;
import org.fstt.entities.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FournisseurMetierImpl implements FournisseurMetier {

	@Autowired
	private FournisseurRepository fournisseurRepository;

	@Override
	public Fournisseur saveFournisseur(Fournisseur fournisseur) {
		return fournisseurRepository.save(fournisseur);
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur fournisseur, Long id) {
		Fournisseur existFournisseur = fournisseurRepository.findById(id).get();

		existFournisseur.setLivraisons(fournisseur.getLivraisons());

		existFournisseur.setNomFournisseur(fournisseur.getNomFournisseur());

		existFournisseur.setSocietes(fournisseur.getSocietes());

		existFournisseur.setTelephoneFournisseur(fournisseur.getTelephoneFournisseur());

		existFournisseur.setVilleFournisseur(fournisseur.getVilleFournisseur());

		return fournisseurRepository.save(existFournisseur);
	}

	@Override
	public Fournisseur getFournisseur(Long id) {
		return fournisseurRepository.findById(id).get();
	}

	@Override
	public void deleteFournisseur(Long id) {
		fournisseurRepository.deleteById(id);
	}

	@Override
	public List<Fournisseur> listFournisseur() {
		return fournisseurRepository.findAll();
	}

	
	@Override
	public Fournisseur getFournisseurByUser(Long id) {
		Fournisseur fournisseur = fournisseurRepository.findByUserIdId(id).get();
		System.out.println(fournisseur);
		return fournisseur;
	}
}
