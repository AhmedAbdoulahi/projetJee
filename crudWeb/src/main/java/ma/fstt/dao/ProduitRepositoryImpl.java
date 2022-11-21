package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Produit;
import ma.fstt.service.ProduitRepository;



public class ProduitRepositoryImpl implements ProduitRepository {

	@Override
	public void ajouterProduit(Produit p) {
		// TODO Auto-generated method stub
		try {
			Connection conn = Singleton.getConnexion() ;
			PreparedStatement ps = conn.prepareStatement(" INSERT INTO produit (nom,prix,qte_stock) VALUES(?,?,?) ") ;
			ps.setString(1, p.getLibelle());
			ps.setDouble(2, p.getPrix());
			ps.setDouble(3, p.getQte_stock());
			ps.executeUpdate() ;
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Produit findById(Long id) {
		// TODO Auto-generated method stub
		try {
			Connection conn = Singleton.getConnexion() ;
			PreparedStatement ps = conn.prepareStatement(" SELECT * FROM produit where id=? ") ;
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery() ;
			Produit p = new Produit() ;
			p.setLibelle(rs.getString("libelle"));
			p.setPrix(rs.getDouble("prix"));
			p.setQte_stock(rs.getDouble("adresse"));
			
			ps.close() ;
			rs.close();
			conn.close();
			
			if(p!= null)
			   return p ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Produit> findAll() {
		// TODO Auto-generated method stub
		List list = new ArrayList<Produit>() ;
		try {
			Connection conn =(Connection) Singleton.getConnexion() ;
			
			PreparedStatement ps = conn.prepareStatement(" SELECT * FROM produit ") ;
			ResultSet rs = ps.executeQuery() ;
		
			while(rs.next()) {
				Produit p = new Produit() ;
				p.setLibelle(rs.getString("libelle"));
				p.setPrix(rs.getDouble("prix"));
				p.setQte_stock(rs.getDouble("qte_stock"));
				list.add(p) ;
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void supprimer(Produit p) {
		// TODO Auto-generated method stub
		try {
			Connection conn = Singleton.getConnexion() ;
			PreparedStatement ps = conn.prepareStatement(" Delete from produit where id = ? ") ;
			ps.setLong(1, p.getId());
			ps.executeUpdate() ;
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Produit p) {
		// TODO Auto-generated method stub
		try {
			Connection conn = Singleton.getConnexion() ;
			PreparedStatement ps = conn.prepareStatement(" UPDATE produit SET libelle=?,prix=?,qte_stock=? "
					+ "where id = ? ") ;
			ps.setString(1, p.getLibelle());
			ps.setDouble(2, p.getPrix());
			ps.setDouble(3, p.getQte_stock());
			ps.setLong(4, p.getId());
			ps.executeUpdate() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
