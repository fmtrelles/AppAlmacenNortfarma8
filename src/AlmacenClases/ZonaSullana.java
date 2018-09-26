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
public class ZonaSullana {
    
    String codigo;
    String descripcion;
    String laboratorio;
    int s1,f5,f11,f68,f73, total;

    public ZonaSullana() {
    }

    public ZonaSullana(String codigo, String descripcion, String laboratorio, int s1, int f5, int f11, int f68, int f73, int total) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.laboratorio = laboratorio;
        this.s1 = s1;
        this.f5 = f5;
        this.f11 = f11;
        this.f68 = f68;
        this.f73 = f73;
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

    public int getS1() {
        return s1;
    }

    public void setS1(int s1) {
        this.s1 = s1;
    }

    public int getF5() {
        return f5;
    }

    public void setF5(int f5) {
        this.f5 = f5;
    }

    public int getF11() {
        return f11;
    }

    public void setF11(int f11) {
        this.f11 = f11;
    }

    public int getF68() {
        return f68;
    }

    public void setF68(int f68) {
        this.f68 = f68;
    }

    public int getF73() {
        return f73;
    }

    public void setF73(int f73) {
        this.f73 = f73;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
       
    
}
