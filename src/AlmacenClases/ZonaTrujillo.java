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
public class ZonaTrujillo {
    String codigo;
    String descripcion;
    String laboratorio;
    int f17,f21,f22,f23,f38,f48,f52,f53,f56, total;

    public ZonaTrujillo() {
    }

    public ZonaTrujillo(String codigo, String descripcion, String laboratorio, int f17, int f21, int f22, int f23, int f38, int f48, int f52, int f53, int f56, int total) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.laboratorio = laboratorio;
        this.f17 = f17;
        this.f21 = f21;
        this.f22 = f22;
        this.f23 = f23;
        this.f38 = f38;
        this.f48 = f48;
        this.f52 = f52;
        this.f53 = f53;
        this.f56 = f56;
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

    public int getF17() {
        return f17;
    }

    public void setF17(int f17) {
        this.f17 = f17;
    }

    public int getF21() {
        return f21;
    }

    public void setF21(int f21) {
        this.f21 = f21;
    }

    public int getF22() {
        return f22;
    }

    public void setF22(int f22) {
        this.f22 = f22;
    }

    public int getF23() {
        return f23;
    }

    public void setF23(int f23) {
        this.f23 = f23;
    }

    public int getF38() {
        return f38;
    }

    public void setF38(int f38) {
        this.f38 = f38;
    }

    public int getF48() {
        return f48;
    }

    public void setF48(int f48) {
        this.f48 = f48;
    }

    public int getF52() {
        return f52;
    }

    public void setF52(int f52) {
        this.f52 = f52;
    }

    public int getF53() {
        return f53;
    }

    public void setF53(int f53) {
        this.f53 = f53;
    }

    public int getF56() {
        return f56;
    }

    public void setF56(int f56) {
        this.f56 = f56;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
