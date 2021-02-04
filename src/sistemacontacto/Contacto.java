/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacontacto;

/**
 *
 * @author Melquis
 */
public class Contacto {
    private int Id;
    private String Nombre;
    private String Apellido;
    private int Telefono;
    private String Direccion;
    private String CreateAt;
    
    
    public Contacto(int Id, String Nombre, String Apellido, int Telefono, String Direccion, String CreateAt){
    
    this.Id= Id;
    this.Nombre= Nombre;
    this.Apellido= Apellido;
    this.Telefono= Telefono;
    this.Direccion= Direccion;
    this.CreateAt= CreateAt;
    }

    public int getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public int getTelefono() {
        return Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getCreateAt() {
        return CreateAt;
    }
}
