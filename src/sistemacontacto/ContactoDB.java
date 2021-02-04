
package sistemacontacto;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactoDB {
    
    private String connString =  "jdbc:mysql://localhost:3306/contactos";
    private String User = "root";
    private String passwrd = "";
    
    private Connection conn;
    
    public Connection getConnection(){
        return conn;
    }
    
    public ContactoDB(){
        try {
            this.conn = DriverManager.getConnection(this.connString, this.User, this.passwrd);
        } catch (SQLException ex) {
            Logger.getLogger(ContactoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
