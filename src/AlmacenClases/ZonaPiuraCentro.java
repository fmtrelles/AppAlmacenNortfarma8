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
public class ZonaPiuraCentro {
    String codigo;
    String descripcion;
    String laboratorio;
    int f2,f3,cen,f1,f4,f35,f70, total;

    public ZonaPiuraCentro() {
    }

    public ZonaPiuraCentro(String codigo, String descripcion, String laboratorio, int f2, int f3, int cen, int f1, int f4, int f35, int f70, int total) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.laboratorio = laboratorio;
        this.f2 = f2;
        this.f3 = f3;
        this.cen = cen;
        this.f1 = f1;
        this.f4 = f4;
        this.f35 = f35;
        this.f70 = f70;
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

    public int getF2() {
        return f2;
    }

    public void setF2(int f2) {
        this.f2 = f2;
    }

    public int getF3() {
        return f3;
    }

    public void setF3(int f3) {
        this.f3 = f3;
    }

    public int getCen() {
        return cen;
    }

    public void setCen(int cen) {
        this.cen = cen;
    }

    public int getF1() {
        return f1;
    }

    public void setF1(int f1) {
        this.f1 = f1;
    }

    public int getF4() {
        return f4;
    }

    public void setF4(int f4) {
        this.f4 = f4;
    }

    public int getF35() {
        return f35;
    }

    public void setF35(int f35) {
        this.f35 = f35;
    }

    public int getF70() {
        return f70;
    }

    public void setF70(int f70) {
        this.f70 = f70;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
