/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacontacto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Melquis
 */
public class ControlerDB {
    
    private Connection conn;
    
    public ControlerDB(Connection conn){
        
      this.conn= conn;
    }
    
    public Contacto getContacto(int _Id){
        Contacto c= null;
        try {
        PreparedStatement stmt;
        stmt = this.conn.prepareStatement("SELECT * FROM contacto WHERE Id= ?");
        stmt.setInt(1, _Id);
        ResultSet rs= stmt.executeQuery();
            
        while(rs.next()){
                
            int Id = rs.getInt("Id");
            String Nombre = rs.getString("Nombre");
            String Apellido = rs.getString("Apellido");
            int Telefono = rs.getInt("Telefono");
            String Direccion = rs.getString("Direccion");
            String CreateAt = rs.getString("CreateAt");
                
            c= new Contacto(Id, Nombre, Apellido, Telefono, Direccion, CreateAt);
        }
        }catch (SQLException ex) {
            Logger.getLogger(ControlerDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return c;
    }
    
        public List<Contacto> getListContacto(){
            
        List<Contacto> buffer = new ArrayList();
            
        try {
        PreparedStatement stmt;
        stmt = this.conn.prepareStatement("SELECT * FROM contacto");
        ResultSet rs= stmt.executeQuery();
            
        while(rs.next()){
                
            int Id = rs.getInt("Id");
            String Nombre = rs.getString("Nombre");
            String Apellido = rs.getString("Apellido");
            int Telefono = rs.getInt("Telefono");
            String Direccion = rs.getString("Direccion");
            String CreateAt = rs.getString("CreateAt");
                
            Contacto contacto= new Contacto(Id, Nombre, Apellido, Telefono, Direccion, CreateAt);
            
            buffer.add(contacto);
        }
        }catch (SQLException ex) {
            Logger.getLogger(ControlerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return buffer;
        }
    
        public void insertar(String Nombre, String Apellido, int Telefono, String Direccion) {
        String q = "INSERT INTO CONTACTO(Nombre, Apellido, Telefono, Direccion) VALUES(?, ?, ?, ?)";
       
        try {
        PreparedStatement stmt;
        stmt = conn.prepareStatement(q);
        stmt.setString(1, Nombre);
        stmt.setString(2, Apellido);
        stmt.setInt(3, Telefono);
        stmt.setString(4, Direccion);
        stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ControlerDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        
        public void eliminar(int _id){
            
        String q = "DELETE FROM contacto WHERE Id= ?";
        try {
            PreparedStatement stmt;
            stmt= conn.prepareStatement(q);
            stmt.setInt(1, _id);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ControlerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
