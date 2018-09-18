/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenDatos;

import AlmacenClases.Boticas;
import AlmacenClases.BoticasCombo;
import AlmacenClases.Guias;
import AlmacenClases.Resumen_detalle;
import ComponenteDatos.BD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRadioButton;

/**
 *
 * @author Fernando Muñoz
 */
public class DBResumenDetalle {

    public static void InsertarDetalles(List<Resumen_detalle> lista) {
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            int i=0;
            for (Resumen_detalle detalle : lista) {
                i++;
                    st = con.prepareStatement("CALL RESUMEN_INSERTAR_DETALLE(?,?,?,?,?,?,?,?,?,?)");
                    st.setInt(1, detalle.getId());
                    st.setString(2, detalle.getCodigo_producto());
                    st.setString(3, detalle.getDescripcion_producto());
                    st.setString(4, detalle.getCodigo_laboratorio());
                    st.setString(5, detalle.getEmpaque());
                    st.setString(6, detalle.getCodigo_tipo());
                    st.setString(7, detalle.getId_botica());
                    st.setInt(8, detalle.getCantidad());
                    st.setString(9, detalle.getFecha_guardado());
                    st.setInt(10, detalle.getIdcabecera());
                    st.executeUpdate();
                    System.out.println("Guardando registro: " + i);
            }
            con.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar detalles:" + ex);
        }
    }

    public static ArrayList<Resumen_detalle> BuscarDetalles(String fecha, String botica) {

        ArrayList<Resumen_detalle> lista = new ArrayList<Resumen_detalle>();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_RESUMEN(?,?)");
            st.setString(1, fecha);
            st.setString(2, botica);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Resumen_detalle detalle = new Resumen_detalle();
                detalle.setCodigo_producto(rs.getString(1));
                detalle.setDescripcion_producto(rs.getString(2));
                detalle.setCodigo_laboratorio(rs.getString(3));
                detalle.setEmpaque(rs.getString(4));
                detalle.setCodigo_tipo(rs.getString(5));
                detalle.setId_botica(rs.getString(6));
                detalle.setCantidad(rs.getInt(7));
                detalle.setFecha_guardado(rs.getString(8));
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles con fecha y botica" + ex);
        }
        return lista;
        
    }

    public static ArrayList<Resumen_detalle> BuscarDetallesTotal(String fecha) {

        ArrayList<Resumen_detalle> lista = new ArrayList<Resumen_detalle>();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_RESUMEN_TOTAL(?)");
            st.setString(1, fecha);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Resumen_detalle detalle = new Resumen_detalle();
                detalle.setCodigo_producto(rs.getString(1));
                detalle.setDescripcion_producto(rs.getString(2));
                detalle.setCodigo_laboratorio(rs.getString(3));
                detalle.setEmpaque(rs.getString(4));
                detalle.setCodigo_tipo(rs.getString(5));
                detalle.setId_botica(rs.getString(6));
                detalle.setCantidad(rs.getInt(7));
                detalle.setFecha_guardado(rs.getString(8));
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles con fecha" + ex);
        }
        return lista;
    }

    public static ArrayList<Resumen_detalle> BuscarDetallesTotalBotica(String botica) {

        ArrayList<Resumen_detalle> lista = new ArrayList<Resumen_detalle>();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCARXBOTICA(?)");
            st.setString(1, botica);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Resumen_detalle detalle = new Resumen_detalle();
                detalle.setCodigo_producto(rs.getString(1));
                detalle.setDescripcion_producto(rs.getString(2));
                detalle.setCodigo_laboratorio(rs.getString(3));
                detalle.setEmpaque(rs.getString(4));
                detalle.setCodigo_tipo(rs.getString(5));
                detalle.setId_botica(rs.getString(6));
                detalle.setCantidad(rs.getInt(7));
                detalle.setFecha_guardado(rs.getString(8));
                lista.add(detalle);
                con.close();
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por botica " + ex);
        }
        return lista;
    }

    public static ArrayList<Boticas> llenarcomboboticas() {
        ArrayList<Boticas> listaboticas = new ArrayList<Boticas>();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("select Id_Botica, Descripcion from boticas");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Boticas boticas = new Boticas();
                boticas.setId_Botica(rs.getString(1));
                boticas.setDescripcion(rs.getString(2));
                listaboticas.add(boticas);
            }
            return listaboticas;
        } catch (SQLException ex) {
            System.out.println("Error al obtener boticas para llenar combo" + ex);
        }
        return listaboticas;
    }

    public static ArrayList<Resumen_detalle> BuscarDetallesTotales() {

        ArrayList<Resumen_detalle> lista = new ArrayList<Resumen_detalle>();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCARRESUMENES()");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Resumen_detalle detalle = new Resumen_detalle();
                detalle.setCodigo_producto(rs.getString(1));
                detalle.setDescripcion_producto(rs.getString(2));
                detalle.setCodigo_laboratorio(rs.getString(3));
                detalle.setEmpaque(rs.getString(4));
                detalle.setCodigo_tipo(rs.getString(5));
                detalle.setId_botica(rs.getString(6));
                detalle.setCantidad(rs.getInt(7));
                detalle.setFecha_guardado(rs.getString(8));
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar Resumenes totales: " + ex);
        }
        return lista;
    }

    public static void eliminar(String fecha) {
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_ELIMINARXFECHA (?)");
            st.setString(1, fecha);
            ResultSet rs = st.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Ocurrió un error al eliminar" + ex);
        }
    }

    public static ArrayList<Resumen_detalle> BuscarTotales(String fecha) {

        ArrayList<Resumen_detalle> lista = new ArrayList<Resumen_detalle>();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_TOTALES(?)");
            st.setString(1, fecha);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Resumen_detalle detalle = new Resumen_detalle();
                detalle.setCodigo_producto(rs.getString(1));
                detalle.setDescripcion_producto(rs.getString(2));
                detalle.setCodigo_laboratorio(rs.getString(3));
                detalle.setEmpaque(rs.getString(4));
                detalle.setCodigo_tipo(rs.getString(5));
                detalle.setId_botica(rs.getString(6));
                detalle.setCantidad(rs.getInt(7));
                detalle.setFecha_guardado(rs.getString(8));
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar Resumenes totales por fecha: " + ex);
        }
        return lista;
    }

    public static ArrayList<Resumen_detalle> Filtrar(String filtro) {

        ArrayList<Resumen_detalle> lista = new ArrayList<Resumen_detalle>();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCARCFILTRO(?)");
            st.setString(1, filtro);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Resumen_detalle detalle = new Resumen_detalle();
                detalle.setCodigo_producto(rs.getString(1));
                detalle.setDescripcion_producto(rs.getString(2));
                detalle.setCodigo_laboratorio(rs.getString(3));
                detalle.setEmpaque(rs.getString(4));
                detalle.setCodigo_tipo(rs.getString(5));
                detalle.setId_botica(rs.getString(6));
                detalle.setCantidad(rs.getInt(7));
                detalle.setFecha_guardado(rs.getString(8));
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar FILTRO: " + ex);
        }
        return lista;
    }

    public static ArrayList<Resumen_detalle> FiltrarTotalesFiltro(String filtro, String fecha) {

        ArrayList<Resumen_detalle> lista = new ArrayList<Resumen_detalle>();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCARTOTAL_FILTRO(?,?)");
            st.setString(1, fecha);
            st.setString(2, filtro);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Resumen_detalle detalle = new Resumen_detalle();
                detalle.setCodigo_producto(rs.getString(1));
                detalle.setDescripcion_producto(rs.getString(2));
                detalle.setCodigo_laboratorio(rs.getString(3));
                detalle.setEmpaque(rs.getString(4));
                detalle.setCodigo_tipo(rs.getString(5));
                detalle.setId_botica(rs.getString(6));
                detalle.setCantidad(rs.getInt(7));
                detalle.setFecha_guardado(rs.getString(8));
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar FILTRO: " + ex);
        }
        return lista;
    }

}
