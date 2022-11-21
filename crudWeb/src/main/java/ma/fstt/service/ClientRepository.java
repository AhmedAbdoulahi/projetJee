package ma.fstt.service;

import java.util.List;

import ma.fstt.entities.Client;

public interface ClientRepository {
	
	void ajouterClient(Client client);
	Client findById(Long id) ;
	List<Client> findAll() ;
	void supprimer(Client client) ;
	void update(Client client) ;
	
}
