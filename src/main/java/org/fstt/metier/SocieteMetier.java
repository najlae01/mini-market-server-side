package org.fstt.metier;

import java.util.List;

import org.fstt.entities.Societe;

public interface SocieteMetier {
	public Societe saveSociete(Societe societe, Long id);
	
	public Societe updateSociete(Societe societe, String uniqueName);
	
	public Societe getSociete(String uniqueName);
	
	public void deleteSociete(String uniqueName);
	
	public List<Societe> listSociete();
}
