package ma.fstt.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;
import ma.fstt.service.CommandeRepository;

public class CommandeRepositoryImpl implements CommandeRepository {

	@Override
	public void ajouterCommande(Commande c) {
		// TODO Auto-generated method stub
		try {
			Connection conn = Singleton.getConnexion() ;
			PreparedStatement ps = conn.prepareStatement(" INSERT INTO commande (date_cmd,client) VALUES(?,?) ") ;
			ps.setDate(1, (Date) c.getDate_cmd());
			ps.setLong(2, c.getCli());
			ps.executeUpdate() ;
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Commande findById(Long id) {
		// TODO Auto-generated method stub
		try {
			Connection conn = Singleton.getConnexion() ;
			PreparedStatement ps = conn.prepareStatement(" SELECT * FROM commande where id=? ") ;
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery() ;
			Commande c = new Commande() ;
			c.setDate_cmd(rs.getDate(1));
			c.setCli( rs.getInt(2));
			ps.close() ;
			rs.close();
			conn.close();
			
			if(c!= null)
			   return c ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Commande> findAll() {
		// TODO Auto-generated method stub
		List list = new ArrayList<Commande>() ;
		try {
			Connection conn =(Connection) Singleton.getConnexion() ;
			
			PreparedStatement ps = conn.prepareStatement(" SELECT * FROM commande ") ;
			ResultSet rs = ps.executeQuery() ;
		
			while(rs.next()) {
				Commande c = new Commande() ;
				c.setDate_cmd(rs.getDate(1));
				c.setCli(rs.getInt(2));
				
				list.add(c) ;
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
	public void supprimer(Commande c) {
		// TODO Auto-generated method stub
		try {
			Connection conn = Singleton.getConnexion() ;
			PreparedStatement ps = conn.prepareStatement(" Delete from commande where id = ? ") ;
			ps.setLong(1, c.getId());
			ps.executeUpdate() ;
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Commande c) {
		// TODO Auto-generated method stub
		try {
			Connection conn = Singleton.getConnexion() ;
			PreparedStatement ps = conn.prepareStatement(" UPDATE commande SET date_cmd=?,id_cli=? "
					+ "where id = ? ") ;
			ps.setDate(1, (Date) c.getDate_cmd());
			ps.setLong(2, c.getCli());
			ps.setLong(3, c.getId());
			ps.executeUpdate() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
