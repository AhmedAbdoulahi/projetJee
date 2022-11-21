package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Produit {
	
	private Long id ;
	private String libelle ;
	private double prix ;
	private double qte_stock ;
	
	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Produit(String libelle, double prix, double qte_stock) {
		super();
		this.libelle = libelle;
		this.prix = prix;
	}

	
	public double getQte_stock() {
		return qte_stock;
	}

	public void setQte_stock(double qte_stock) {
		this.qte_stock = qte_stock;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	

}
