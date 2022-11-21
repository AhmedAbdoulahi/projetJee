package ma.fstt.service;

import java.util.List;

import ma.fstt.entities.Commande;

public interface CommandeRepository {
	void ajouterCommande(Commande commande);
	Commande findById(Long id) ;
	List<Commande> findAll() ;
	void supprimer(Commande commande) ;
	void update(Commande commande) ;
}
