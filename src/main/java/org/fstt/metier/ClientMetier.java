package org.fstt.metier;

import java.util.List;

import org.fstt.entities.Client;

public interface ClientMetier {
	public Client saveClient(Client client);
	
	public Client updateClient(Client client, Integer id);
	
	public Client getClient(Integer id);
	
	public void deleteClient(Integer id);
	
	public List<Client> listClient();

}
