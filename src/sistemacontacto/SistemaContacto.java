/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacontacto;

import java.sql.Connection;


/**
 *
 * @author Melquis
 */
public class SistemaContacto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ContactoDB db = new ContactoDB();
        Connection conn = db.getConnection();
        
        ControlerDB contacto= new ControlerDB(conn);
        
       /* Contacto c1= contacto.getContacto(1);
        System.out.println("Nombre: " + c1.getNombre());
        
        /*contacto.insertar("Dionisio", "Gomez", 87654321, "Everywhere");
        System.out.println("Contacto Creado !");
     
        contacto.eliminar(2);
        System.out.println("Contacto Eliminado !");*/
        
        for(Contacto c: contacto.getListContacto()){
            System.out.println(c.getNombre());
            System.out.println(c.getApellido());
        }
    }
    
}
