package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Client;
import ma.fstt.service.ClientRepository;

public class ClientRepositoryImpl implements ClientRepository {

	@Override
	public void ajouterClient(Client c) {
		// TODO Auto-generated method stub
		
		try {
			Connection conn = Singleton.getConnexion() ;
			PreparedStatement ps = conn.prepareStatement(" INSERT INTO client (nom,prenom,adresse,tel) VALUES(?,?,?,?) ") ;
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getAdresse());
			ps.setString(3, c.getTel());
			ps.executeUpdate() ;
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Client findById(Long id) {
		// TODO Auto-generated method stub
		try {
			Connection conn = Singleton.getConnexion() ;
			PreparedStatement ps = conn.prepareStatement(" SELECT * FROM client where id=? ") ;
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery() ;
			Client cli = new Client() ;
			cli.setNom(rs.getString("nom"));
			cli.setPrenom(rs.getString("prenom"));
			cli.setAdresse(rs.getString("adresse"));
			cli.setTel(rs.getString("tel"));
			
			ps.close() ;
			rs.close();
			conn.close();
			
			if(cli!= null)
			   return cli ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		List list = new ArrayList<Client>() ;
		try {
			Connection conn =(Connection) Singleton.getConnexion() ;
			
			PreparedStatement ps = conn.prepareStatement(" SELECT * FROM client ") ;
			ResultSet rs = ps.executeQuery() ;
		
			while(rs.next()) {
				Client cli = new Client() ;
				cli.setNom(rs.getString("nom"));
				cli.setPrenom(rs.getString("prenom"));
				cli.setAdresse(rs.getString("adresse"));
				cli.setTel(rs.getString("tel"));
				list.add(cli) ;
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
	public void supprimer(Client client) {
		// TODO Auto-generated method stub
		try {
			Connection conn = Singleton.getConnexion() ;
			PreparedStatement ps = conn.prepareStatement(" Delete from client where id = ? ") ;
			ps.setLong(1, client.getId());
			ps.executeUpdate() ;
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Client client) {
		// TODO Auto-generated method stub
		try {
			Connection conn = Singleton.getConnexion() ;
			PreparedStatement ps = conn.prepareStatement(" UPDATE client SET nom=?,prenom=?,adresse=?,tel=? "
					+ "where id = ? ") ;
			ps.setString(1, client.getNom());
			ps.setString(2, client.getPrenom());
			ps.setString(3, client.getAdresse());
			ps.setString(4, client.getTel());
			ps.setLong(5, client.getId());
			ps.executeUpdate() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
