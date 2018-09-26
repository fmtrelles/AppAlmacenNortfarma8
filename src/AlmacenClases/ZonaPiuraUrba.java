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
public class ZonaPiuraUrba {
    String codigo;
    String descripcion;
    String laboratorio;
    int f44,f40,f69,f6,f72,f14,f63,total;

    public ZonaPiuraUrba() {
    }

    public ZonaPiuraUrba(String codigo, String descripcion, String laboratorio, int f44, int f40, int f69, int f6, int f72, int f14, int f63, int total) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.laboratorio = laboratorio;
        this.f44 = f44;
        this.f40 = f40;
        this.f69 = f69;
        this.f6 = f6;
        this.f72 = f72;
        this.f14 = f14;
        this.f63 = f63;
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

    public int getF44() {
        return f44;
    }

    public void setF44(int f44) {
        this.f44 = f44;
    }

    public int getF40() {
        return f40;
    }

    public void setF40(int f40) {
        this.f40 = f40;
    }

    public int getF69() {
        return f69;
    }

    public void setF69(int f69) {
        this.f69 = f69;
    }

    public int getF6() {
        return f6;
    }

    public void setF6(int f6) {
        this.f6 = f6;
    }

    public int getF72() {
        return f72;
    }

    public void setF72(int f72) {
        this.f72 = f72;
    }

    public int getF14() {
        return f14;
    }

    public void setF14(int f14) {
        this.f14 = f14;
    }

    public int getF63() {
        return f63;
    }

    public void setF63(int f63) {
        this.f63 = f63;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
