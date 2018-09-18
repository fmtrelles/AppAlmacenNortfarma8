/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenClases;

/**
 *
 * @author jsarango
 */
public class Personal {

    private int Id_Personal;
    private String Apellidos;
    private String Nombres;
    private String DNI;
    private Cargos Cargo_Almacen;
    
    public int getId_Personal() {
        return Id_Personal;
    }

    public void setId_Personal(int Id_Personal) {
        this.Id_Personal = Id_Personal;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Cargos getCargo_Almacen() {
        return Cargo_Almacen;
    }

    public void setCargo_Almacen(Cargos Cargo_Almacen) {
        this.Cargo_Almacen = Cargo_Almacen;
    }
}
