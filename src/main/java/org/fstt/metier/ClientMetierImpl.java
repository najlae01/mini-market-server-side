package org.fstt.metier;

import java.util.List;

import org.fstt.dao.ClientRepository;
import org.fstt.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientMetierImpl implements ClientMetier{

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client updateClient(Client client, Integer id) {
		Client existClient = clientRepository.findById(id).get();
		
		client.setNomClient(client.getNomClient());
		
		client.setPrenomClient(client.getPrenomClient());
		
		client.setCommandes(client.getCommandes());
		
		client.setAdresse(client.getAdresse());
		
		client.setTelephone(client.getTelephone());
		
		client.setVilleClient(client.getVilleClient());
		
		return clientRepository.save(existClient);
	}

	@Override
	public Client getClient(Integer id) {
		return clientRepository.findById(id).get();
	}

	@Override
	public void deleteClient(Integer id) {
		clientRepository.deleteById(id);
	}

	@Override
	public List<Client> listClient() {
		return clientRepository.findAll();
	}

}
