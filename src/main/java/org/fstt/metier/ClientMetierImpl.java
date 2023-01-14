package org.fstt.metier;

import java.util.List;

import org.fstt.dao.ClientRepository;
import org.fstt.dao.UserDetailsRepository;
import org.fstt.entities.Client;
import org.fstt.entities.User;
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
		if(client.getNomClient() != null)
		existClient.setNomClient(client.getNomClient());
		
		if(client.getPrenomClient() != null)
		existClient.setPrenomClient(client.getPrenomClient());
		
		if(client.getCommandes() != null)
		existClient.setCommandes(client.getCommandes());
		
		if(client.getAdresse() != null)
		existClient.setAdresse(client.getAdresse());
		
		if(client.getTelephone() != null)
		existClient.setTelephone(client.getTelephone());
		
		if(client.getVilleClient() != null)
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

	@Override
	public Client getClientByUser(Long id) {
		Client client = clientRepository.findByUserIdId(id).get();
		System.out.println(client);
		return client;
	}


}
