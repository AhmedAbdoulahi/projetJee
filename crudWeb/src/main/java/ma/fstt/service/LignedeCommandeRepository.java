package ma.fstt.service;

import java.util.List;

import ma.fstt.entities.LignedeCommande ;

public interface LignedeCommandeRepository {
	void ajouterLignedeCommande(LignedeCommande lcmd);
	LignedeCommande findById(Long id) ;
	List<LignedeCommande> findAll() ;
	void supprimer(LignedeCommande lcmd) ;
	void update(LignedeCommande lcmd) ;
}
