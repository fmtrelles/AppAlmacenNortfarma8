/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenClases;

/**
 *
 * @author jsarango
 */
public class RevisionGuia_detalle {
    
    private int Id_Revsion;
    private int Grupo;
    private String Id_Personal;

    public int getId_Revsion() {
        return Id_Revsion;
    }

    public void setId_Revsion(int Id_Revsion) {
        this.Id_Revsion = Id_Revsion;
    }

    public int getGrupo() {
        return Grupo;
    }

    public void setGrupo(int Grupo) {
        this.Grupo = Grupo;
    }

    public String getId_Personal() {
        return Id_Personal;
    }

    public void setId_Personal(String Id_Personal) {
        this.Id_Personal = Id_Personal;
    }
    
}
