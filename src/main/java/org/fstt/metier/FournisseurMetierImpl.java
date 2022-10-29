package org.fstt.metier;

import java.util.List;

import org.fstt.dao.FournisseurRepository;
import org.fstt.entities.Client;
import org.fstt.entities.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;

public class FournisseurMetierImpl implements FournisseurMetier {

	@Autowired
	private FournisseurRepository fournisseurRepository;

	@Override
	public Fournisseur saveFournisseur(Fournisseur fournisseur) {
		return fournisseurRepository.save(fournisseur);
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur fournisseur, Integer id) {
		Fournisseur existFournisseur = fournisseurRepository.findById(id).get();

		fournisseur.setLivraisons(fournisseur.getLivraisons());

		fournisseur.setNomFournisseur(fournisseur.getNomFournisseur());

		fournisseur.setSocietes(fournisseur.getSocietes());

		fournisseur.setTelephoneFournisseur(fournisseur.getTelephoneFournisseur());

		fournisseur.setVilleFournisseur(fournisseur.getVilleFournisseur());

		return fournisseurRepository.save(existFournisseur);
	}

	@Override
	public Fournisseur getFournisseur(Integer id) {
		return fournisseurRepository.findById(id).get();
	}

	@Override
	public void deleteFournisseur(Integer id) {
		fournisseurRepository.deleteById(id);
	}

	@Override
	public List<Fournisseur> listFournisseur() {
		return fournisseurRepository.findAll();
	}

}
