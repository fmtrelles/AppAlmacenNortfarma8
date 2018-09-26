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
public class ZonaPiuraCastilla {
    String codigo;
    String descripcion;
    String laboratorio;
    int f59,asu,f34,f49,f43,f71, total;

    public ZonaPiuraCastilla() {
    }

    public ZonaPiuraCastilla(String codigo, String descripcion, String laboratorio, int f59, int asu, int f34, int f49, int f43, int f71, int total) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.laboratorio = laboratorio;
        this.f59 = f59;
        this.asu = asu;
        this.f34 = f34;
        this.f49 = f49;
        this.f43 = f43;
        this.f71 = f71;
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

    public int getF59() {
        return f59;
    }

    public void setF59(int f59) {
        this.f59 = f59;
    }

    public int getAsu() {
        return asu;
    }

    public void setAsu(int asu) {
        this.asu = asu;
    }

    public int getF34() {
        return f34;
    }

    public void setF34(int f34) {
        this.f34 = f34;
    }

    public int getF49() {
        return f49;
    }

    public void setF49(int f49) {
        this.f49 = f49;
    }

    public int getF43() {
        return f43;
    }

    public void setF43(int f43) {
        this.f43 = f43;
    }

    public int getF71() {
        return f71;
    }

    public void setF71(int f71) {
        this.f71 = f71;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    
}
