package org.fstt.service;

import java.util.List;

import org.fstt.entities.Client;
import org.fstt.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientRestService {
	
	@Autowired
	private ClientMetier clientMetier;
	
	@RequestMapping(value = "/addClient", method = RequestMethod.POST)
	public Client addClient(@RequestBody Client client) {
		return clientMetier.saveClient(client);
	}
	
	@RequestMapping(value = "/updateClient/{id}", method = RequestMethod.PUT)
	public Client updateClient(@RequestBody Client client, @PathVariable Integer id) {
		return clientMetier.updateClient(client, id);
	}
	
	@RequestMapping(value = "/getClient/{id}", method = RequestMethod.GET)
	public Client getClient(@PathVariable Integer id) {
		return clientMetier.getClient(id);
	}
	
	@RequestMapping(value = "/deleteClient/{id}", method = RequestMethod.DELETE)
	public void deleteClient(@PathVariable Integer id) {
		clientMetier.deleteClient(id);
	}
	
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public List<Client> listClient() {
		return clientMetier.listClient();
	}
}