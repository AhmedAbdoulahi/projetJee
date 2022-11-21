package ma.fstt.service;

import java.util.List;

import ma.fstt.entities.Produit;

public interface ProduitRepository {
	
	void ajouterProduit(Produit produit);
	Produit findById(Long id) ;
	List<Produit> findAll() ;
	void supprimer(Produit produit) ;
	void update(Produit produit) ;
}
