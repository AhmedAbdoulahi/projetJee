package ma.fstt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
	private static Connection conn = null  ;
	
	static {
		//les donnes de connexion a la base de donnees
		String url = "jdbc:mysql://localhost:3306/tpjee" ;
		String user = "root" ;
		String mdp = "" ;
		
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			conn = DriverManager.getConnection(url,user,mdp) ;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//retourne la connexion
	public static Connection getConnexion(){
		
		return conn ;
	}
}
