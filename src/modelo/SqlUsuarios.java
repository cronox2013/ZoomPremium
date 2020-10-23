package modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlUsuarios extends Conexion {
    
    public boolean registrar(usuarios usr) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO usuario (usuario,password,nombre,correo,id_tipo) VALUES (?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,usr.getUsuario());
            ps.setString(2,usr.getPassword());
            ps.setString(3,usr.getNombre());
            ps.setString(4,usr.getCorreo());
            ps.setInt(5,usr.getId_tipo());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean login(usuarios usr){
    PreparedStatement ps = null;
    ResultSet res = null;
    Connection con = getConexion();
    String sql = "SELECT id,usuario,password FROM usuario Where usuario = ?";
    
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            res = ps.executeQuery();
            
            if(res.next()){
                if(usr.getPassword().equals(res.getString(3))){
                    String sqlUpdate = "UPDATE usuario SET last_session = ?  WHERE id=?";
                    ps = con.prepareStatement(sqlUpdate);
                    ps.setString(1,usr.getLast_session());
                    System.out.println("id ==> "+res.getInt(1));
                    ps.setInt(2,res.getInt(1));
                    ps.execute();
                    
                    
                   return true;         
                }
                else{
                return false;
                }
            }
             return false;
        } catch (SQLException ex) {
           
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
    }
}
