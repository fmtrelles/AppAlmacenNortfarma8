/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenClases;
/**
 *
 * @author Fernando Muñoz
 */
public class Resumen_cabecera {

    private int id;
    private String fecha;
    private String observacion;

    public Resumen_cabecera() {
    }

    public Resumen_cabecera(int id, String fecha, String observacion) {
        this.id = id;
        this.fecha = fecha;
        this.observacion = observacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
