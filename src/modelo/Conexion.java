package modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    String url ="jdbc:mysql://umrxflrnzadq8y1e:H6yn6NaJUy0eE9ai96vl@bodjys3ubtmp19pyapnr-mysql.services.clever-cloud.com:3306/bodjys3ubtmp19pyapnr";
    String username = "umrxflrnzadq8y1e";
    String password = "H6yn6NaJUy0eE9ai96vl";
    Connection conn = null;
    public Connection getConexion() {
	try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado!");
        } catch (SQLException e) {
            System.out.println("ERROOOOOR!");
            e.printStackTrace();
            }
        return conn;
    }
}
