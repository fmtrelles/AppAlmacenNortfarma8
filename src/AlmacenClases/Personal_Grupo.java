/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenClases;

/**
 *
 * @author jsarango
 */
public class Personal_Grupo {
    private int Id_Grupo;
    private String Id_Personal;
    private int Activo;
    private String Fecha; 
    private int Cargo;
    private String NomCargo;
    private String NomGrupo;
    private String Nombres;
    private String Apellidos;
    private String ApellidosNombres;

    public int getId_Grupo() {
        return Id_Grupo;
    }

    public void setId_Grupo(int Id_Grupo) {
        this.Id_Grupo = Id_Grupo;
    }

    public String getId_Personal() {
        return Id_Personal;
    }

    public void setId_Personal(String Id_Personal) {
        this.Id_Personal = Id_Personal;
    }

    public int getActivo() {
        return Activo;
    }

    public void setActivo(int Activo) {
        this.Activo = Activo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getCargo() {
        return Cargo;
    }

    public void setCargo(int Cargo) {
        this.Cargo = Cargo;
    }

    public String getNomCargo() {
        return NomCargo;
    }

    public void setNomCargo(String NomCargo) {
        this.NomCargo = NomCargo;
    }

    public String getNomGrupo() {
        return NomGrupo;
    }

    public void setNomGrupo(String NomGrupo) {
        this.NomGrupo = NomGrupo;
    }

    public String getApellidosNombres() {
        return ApellidosNombres;
    }

    public void setApellidosNombres(String ApellidosNombres) {
        this.ApellidosNombres = ApellidosNombres;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }
}
