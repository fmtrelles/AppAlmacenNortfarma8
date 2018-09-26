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
public class ZonaMancora {
    String codigo;
    String descriocion;
    String laboratorio;
    int f42, total;

    public ZonaMancora() {
    }

    public ZonaMancora(String codigo, String descriocion, String laboratorio, int f42, int total) {
        this.codigo = codigo;
        this.descriocion = descriocion;
        this.laboratorio = laboratorio;
        this.f42 = f42;
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescriocion() {
        return descriocion;
    }

    public void setDescriocion(String descriocion) {
        this.descriocion = descriocion;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public int getF42() {
        return f42;
    }

    public void setF42(int f42) {
        this.f42 = f42;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
