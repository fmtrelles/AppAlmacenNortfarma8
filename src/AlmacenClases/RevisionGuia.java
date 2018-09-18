/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenClases;

/**
 *
 * @author jsarango
 */
public class RevisionGuia {
    private int Id_Revision;
    private String Fecha;
    private int Id_grupo;
    private String Id_Botica;
    private String Hora_Inicio;
    private String Hora_Final;
    private String TiempoAbastecedor;

    public int getId_Revision() {
        return Id_Revision;
    }

    public void setId_Revision(int Id_Revision) {
        this.Id_Revision = Id_Revision;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getId_grupo() {
        return Id_grupo;
    }

    public void setId_grupo(int Id_grupo) {
        this.Id_grupo = Id_grupo;
    }

    public String getId_Botica() {
        return Id_Botica;
    }

    public void setId_Botica(String Id_Botica) {
        this.Id_Botica = Id_Botica;
    }

    public String getHora_Inicio() {
        return Hora_Inicio;
    }

    public void setHora_Inicio(String Hora_Inicio) {
        this.Hora_Inicio = Hora_Inicio;
    }

    public String getHora_Final() {
        return Hora_Final;
    }

    public void setHora_Final(String Hora_Final) {
        this.Hora_Final = Hora_Final;
    }

    public String getTiempoAbastecedor() {
        return TiempoAbastecedor;
    }

    public void setTiempoAbastecedor(String TiempoAbastecedor) {
        this.TiempoAbastecedor = TiempoAbastecedor;
    }

    

    
}
