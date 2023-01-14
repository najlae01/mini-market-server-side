package org.fstt.metier;

import java.util.List;

import org.fstt.entities.Client;

public interface ClientMetier {
	public Client saveClient(Client client);
	
	public Client updateClient(Client client, Long id);
	
	public Client getClient(Long id);
	
	public Client getClientByUser(Long id);
	
	public void deleteClient(Long id);
	
	public List<Client> listClient();

}
