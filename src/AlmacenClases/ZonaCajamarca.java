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
public class ZonaCajamarca {
    String codigo;
    String descripcion;
    String laboratorio;
    int f55,f57, total;

    public ZonaCajamarca() {
    }

    public ZonaCajamarca(String codigo, String descripcion, String laboratorio, int f55, int f57, int total) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.laboratorio = laboratorio;
        this.f55 = f55;
        this.f57 = f57;
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

    public int getF55() {
        return f55;
    }

    public void setF55(int f55) {
        this.f55 = f55;
    }

    public int getF57() {
        return f57;
    }

    public void setF57(int f57) {
        this.f57 = f57;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
