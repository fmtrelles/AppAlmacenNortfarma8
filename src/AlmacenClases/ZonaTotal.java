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
public class ZonaTotal {
    String codigo;
    String descripcion;
    String laboratorio;
    int total;

    public ZonaTotal() {
    }

    public ZonaTotal(String codigo, String descripcion, String laboratorio, int total) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.laboratorio = laboratorio;
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
