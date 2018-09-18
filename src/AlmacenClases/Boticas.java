/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenClases;

/**
 *
 * @author SEBASTIAN
 */
public class Boticas {

    private String Id_Botica;
    private String Descripcion;
    private int Id_Zona;
    private String Acronimo;
    private String Cod_Descargo;

    public String getId_Botica() {
        return Id_Botica;
    }

    public void setId_Botica(String Id_Botica) {
        this.Id_Botica = Id_Botica;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getId_Zona() {
        return Id_Zona;
    }

    public void setId_Zona(int Id_Zona) {
        this.Id_Zona = Id_Zona;
    }

    public String getAcronimo() {
        return Acronimo;
    }

    public void setAcronimo(String Acronimo) {
        this.Acronimo = Acronimo;
    }

    public String getCod_Descargo() {
        return Cod_Descargo;
    }

    public void setCod_Descargo(String Cod_Descargo) {
        this.Cod_Descargo = Cod_Descargo;
    }
    
}
