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
public class ZonaTalara {
    String codigo;
    String descripcion;
    String laboratorio;
    int f25;
    int f31;
    int total;

    public ZonaTalara() {
    }

    public ZonaTalara(String codigo, String descripcion, String laboratorio, int f25, int f31, int total) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.laboratorio = laboratorio;
        this.f25 = f25;
        this.f31 = f31;
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

    public int getF25() {
        return f25;
    }

    public void setF25(int f25) {
        this.f25 = f25;
    }

    public int getF31() {
        return f31;
    }

    public void setF31(int f31) {
        this.f31 = f31;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
