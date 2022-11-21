package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Client;
import ma.fstt.entities.LignedeCommande;
import ma.fstt.service.LignedeCommandeRepository;

public class LcmdRepositoryImpl implements LignedeCommandeRepository {

	@Override
	public void ajouterLignedeCommande(LignedeCommande l) {
		// TODO Auto-generated method stub
		try {
			Connection conn = Singleton.getConnexion() ;
			PreparedStatement ps = conn.prepareStatement(" INSERT INTO lcmd (id_produit,id_cmd,qte_cmd) VALUES(?,?,?) ") ;
			ps.setLong(1, l.getIdproduit());
			ps.setLong(2, l.getIdcmd());
			ps.setDouble(3, l.getQte_cmd());
			ps.executeUpdate() ;
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public LignedeCommande findById(Long id) {
		// TODO Auto-generated method stub
		try {
			Connection conn = Singleton.getConnexion() ;
			PreparedStatement ps = conn.prepareStatement(" SELECT * FROM lcmd where id=? ") ;
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery() ;
			LignedeCommande l = new LignedeCommande() ;
			l.setIdproduit(rs.getLong(1));
			l.setIdcmd(rs.getLong(2));
			l.setQte_cmd(rs.getDouble(3));
			
			ps.close() ;
			rs.close();
			conn.close();
			
			if(l!= null)
			   return l ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<LignedeCommande> findAll() {
		// TODO Auto-generated method stub
		List list = new ArrayList<LignedeCommande>() ;
		try {
			Connection conn =(Connection) Singleton.getConnexion() ;
			
			PreparedStatement ps = conn.prepareStatement(" SELECT * FROM lcmd ") ;
			ResultSet rs = ps.executeQuery() ;
		
			while(rs.next()) {
				LignedeCommande l = new LignedeCommande() ;
				l.setIdproduit(rs.getLong(1));
				l.setIdcmd(rs.getLong(2));
				l.setQte_cmd(rs.getDouble(3));
				list.add(l) ;
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
	public void supprimer(LignedeCommande l) {
		// TODO Auto-generated method stub
		try {
			Connection conn = Singleton.getConnexion() ;
			PreparedStatement ps = conn.prepareStatement(" Delete from lcmd where id = ? ") ;
			ps.setLong(1, l.getNum_ligne());
			ps.executeUpdate() ;
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(LignedeCommande l) {
		// TODO Auto-generated method stub
		try {
			Connection conn = Singleton.getConnexion() ;
			PreparedStatement ps = conn.prepareStatement(" UPDATE lcmd SET idproduit=?,idcmd=?,qte_cmd=?,tel=? "
					+ "where id = ? ") ;
			ps.setLong(1, l.getIdproduit());
			ps.setLong(2, l.getIdcmd());
			ps.setDouble(3, l.getQte_cmd());
			ps.setLong(4, l.getNum_ligne());
			ps.executeUpdate() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
