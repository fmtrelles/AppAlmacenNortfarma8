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
public class ZonaPiuraMercado {
    String codigo;
    String descripcion;
    String laboratorio;
    int f20,f24,f62,f33,f32, total;

    public ZonaPiuraMercado() {
    }

    public ZonaPiuraMercado(String codigo, String descripcion, String laboratorio, int f20, int f24, int f62, int f33, int f32, int total) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.laboratorio = laboratorio;
        this.f20 = f20;
        this.f24 = f24;
        this.f62 = f62;
        this.f33 = f33;
        this.f32 = f32;
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

    public int getF20() {
        return f20;
    }

    public void setF20(int f20) {
        this.f20 = f20;
    }

    public int getF24() {
        return f24;
    }

    public void setF24(int f24) {
        this.f24 = f24;
    }

    public int getF62() {
        return f62;
    }

    public void setF62(int f62) {
        this.f62 = f62;
    }

    public int getF33() {
        return f33;
    }

    public void setF33(int f33) {
        this.f33 = f33;
    }

    public int getF32() {
        return f32;
    }

    public void setF32(int f32) {
        this.f32 = f32;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    
}
