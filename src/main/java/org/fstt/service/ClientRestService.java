package org.fstt.service;

import java.util.List;

import org.fstt.entities.Client;
import org.fstt.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ClientRestService {
	
	@Autowired
	private ClientMetier clientMetier;
	
	@RequestMapping(value = "/add/client", method = RequestMethod.POST)
	public Client addClient(@RequestBody Client client) {
		return clientMetier.saveClient(client);
	}
	
	@RequestMapping(value = "/update/client/{id}", method = RequestMethod.PUT)
	public Client updateClient(@RequestBody Client client, @PathVariable Long id) {
		return clientMetier.updateClient(client, id);
	}
	
	@RequestMapping(value = "/get/client/{id}", method = RequestMethod.GET)
	public Client getClient(@PathVariable Long id) {
		return clientMetier.getClient(id);
	}
	
	@RequestMapping(value = "/get/client/user/{id}", method = RequestMethod.GET)
	public Client getClientByUser(@PathVariable Long id) {
		return clientMetier.getClientByUser(id);
	}
	
	@RequestMapping(value = "/delete/client/{id}", method = RequestMethod.DELETE)
	public void deleteClient(@PathVariable Long id) {
		clientMetier.deleteClient(id);
	}
	
	@RequestMapping(value = "/get/clients", method = RequestMethod.GET)
	public List<Client> listClient() {
		return clientMetier.listClient();
	}
}
