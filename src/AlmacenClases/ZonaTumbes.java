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
public class ZonaTumbes {
    String codigo;
    String descripcion;
    String laboratorio;
    int f7, f12,f16,f26,f27,f28,f29,f37,f64,f66, total;

    public ZonaTumbes() {        
    } 

    public ZonaTumbes(String codigo, String descripcion, String laboratorio, int f7, int f12, int f16, int f26, int f27, int f28, int f29, int f37, int f64, int f66, int total) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.laboratorio = laboratorio;
        this.f7 = f7;
        this.f12 = f12;
        this.f16 = f16;
        this.f26 = f26;
        this.f27 = f27;
        this.f28 = f28;
        this.f29 = f29;
        this.f37 = f37;
        this.f64 = f64;
        this.f66 = f66;
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

    public int getF7() {
        return f7;
    }

    public void setF7(int f7) {
        this.f7 = f7;
    }

    public int getF12() {
        return f12;
    }

    public void setF12(int f12) {
        this.f12 = f12;
    }

    public int getF16() {
        return f16;
    }

    public void setF16(int f16) {
        this.f16 = f16;
    }

    public int getF26() {
        return f26;
    }

    public void setF26(int f26) {
        this.f26 = f26;
    }

    public int getF27() {
        return f27;
    }

    public void setF27(int f27) {
        this.f27 = f27;
    }

    public int getF28() {
        return f28;
    }

    public void setF28(int f28) {
        this.f28 = f28;
    }

    public int getF29() {
        return f29;
    }

    public void setF29(int f29) {
        this.f29 = f29;
    }

    public int getF37() {
        return f37;
    }

    public void setF37(int f37) {
        this.f37 = f37;
    }

    public int getF64() {
        return f64;
    }

    public void setF64(int f64) {
        this.f64 = f64;
    }

    public int getF66() {
        return f66;
    }

    public void setF66(int f66) {
        this.f66 = f66;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
