package org.fstt.metier;

import java.util.List;

import org.fstt.dao.ClientRepository;
import org.fstt.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientMetierImpl implements ClientMetier{

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client updateClient(Client client, Long id) {
		Client existClient = clientRepository.findById(id).get();
		
		existClient.setNomClient(client.getNomClient());
		
		existClient.setPrenomClient(client.getPrenomClient());
		
		existClient.setCommandes(client.getCommandes());
		
		existClient.setAdresse(client.getAdresse());
		
		existClient.setTelephone(client.getTelephone());
		
		existClient.setVilleClient(client.getVilleClient());
		
		return clientRepository.save(existClient);
	}

	@Override
	public Client getClient(Long id) {
		return clientRepository.findById(id).get();
	}

	@Override
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);
	}

	@Override
	public List<Client> listClient() {
		return clientRepository.findAll();
	}


}
