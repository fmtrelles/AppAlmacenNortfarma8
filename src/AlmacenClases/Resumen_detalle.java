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
public class Resumen_detalle {
    private int id;
    private String codigo_producto;
    private String descripcion_producto;
    private String codigo_laboratorio;
    private String empaque;
    private String codigo_tipo;
    private String id_botica;
    private int cantidad;
    private String fecha_guardado;
    private int idcabecera;
    

    public Resumen_detalle() {
    }

    public Resumen_detalle(int id, String codigo_producto, String descripcion_producto, String codigo_laboratorio, String empaque, String codigo_tipo, String id_botica, int cantidad, String fecha_guardado, int idcabecera) {
        this.id = id;
        this.codigo_producto = codigo_producto;
        this.descripcion_producto = descripcion_producto;
        this.codigo_laboratorio = codigo_laboratorio;
        this.empaque = empaque;
        this.codigo_tipo = codigo_tipo;
        this.id_botica = id_botica;
        this.cantidad = cantidad;
        this.fecha_guardado = fecha_guardado;
        this.idcabecera = idcabecera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getCodigo_laboratorio() {
        return codigo_laboratorio;
    }

    public void setCodigo_laboratorio(String codigo_laboratorio) {
        this.codigo_laboratorio = codigo_laboratorio;
    }

    public String getEmpaque() {
        return empaque;
    }

    public void setEmpaque(String empaque) {
        this.empaque = empaque;
    }

    public String getCodigo_tipo() {
        return codigo_tipo;
    }

    public void setCodigo_tipo(String codigo_tipo) {
        this.codigo_tipo = codigo_tipo;
    }

    public String getId_botica() {
        return id_botica;
    }

    public void setId_botica(String id_botica) {
        this.id_botica = id_botica;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha_guardado() {
        return fecha_guardado;
    }

    public void setFecha_guardado(String fecha_guardado) {
        this.fecha_guardado = fecha_guardado;
    }

    public int getIdcabecera() {
        return idcabecera;
    }

    public void setIdcabecera(int idcabecera) {
        this.idcabecera = idcabecera;
    }  
}
