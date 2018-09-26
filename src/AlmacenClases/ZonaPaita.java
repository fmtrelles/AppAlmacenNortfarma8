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
public class ZonaPaita {
    String codigo;
    String descripcion;
    String laboratorio;
    int f46,f60,total;

    public ZonaPaita() {
    }

    public ZonaPaita(String codigo, String descripcion, String laboratorio, int f46, int f60, int total) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.laboratorio = laboratorio;
        this.f46 = f46;
        this.f60 = f60;
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

    public int getF46() {
        return f46;
    }

    public void setF46(int f46) {
        this.f46 = f46;
    }

    public int getF60() {
        return f60;
    }

    public void setF60(int f60) {
        this.f60 = f60;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
          
}
