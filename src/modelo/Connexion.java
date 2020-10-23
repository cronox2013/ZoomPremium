package modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connexion {
    public static void connection() {
		String url ="jdbc:mysql://localhost:3306/andydb";
		String username = "root";
		String password = "mozartag";

		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Conectado!");
			
			
			
		} catch (SQLException e) {
			System.out.println("ERROOOOOR!");
			e.printStackTrace();
		}
	}
}
