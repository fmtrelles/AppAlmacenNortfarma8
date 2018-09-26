/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenDatos;

import AlmacenClases.*;
import ComponenteDatos.BD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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

    public static ArrayList<Zonas> llenarcombozonas() {
        ArrayList<Zonas> listazonas = new ArrayList<Zonas>();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("SELECT Id_Zona, Descripcion from zonas order by Descripcion");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Zonas zonas = new Zonas();
                zonas.setId_Zona(rs.getInt(1));
                zonas.setDescripcion(rs.getString(2));
                listazonas.add(zonas);
            }
            return listazonas;
        } catch (SQLException ex) {
            System.out.println("Error al obtener zonas para llenar combo" + ex);
        }
        return listazonas;
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
    
    public static ArrayList<ZonaTalara> BuscarDetallesZonaTalara(String fecha, int zona, int idsubzona) {

        ArrayList<ZonaTalara> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS(?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();       
            while (rs.next()) {
                ZonaTalara detalle = new ZonaTalara();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));
                detalle.setF25(rs.getInt(4));
                detalle.setF31(rs.getInt(5));
                detalle.setTotal(rs.getInt(6));                
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaChiclayo> BuscarDetallesZonaChiclayo(String fecha, int zona, int idsubzona) {

        ArrayList<ZonaChiclayo> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS(?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaChiclayo detalle = new ZonaChiclayo();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF8(rs.getInt(4));
                detalle.setF9(rs.getInt(5));
                detalle.setF10(rs.getInt(6));
                detalle.setF13(rs.getInt(7));
                detalle.setF15(rs.getInt(8));
                detalle.setF18(rs.getInt(9));
                detalle.setF19(rs.getInt(10));
                detalle.setF30(rs.getInt(11));
                detalle.setF36(rs.getInt(12));
                detalle.setF51(rs.getInt(13));
                detalle.setF61(rs.getInt(14));
                detalle.setF67(rs.getInt(15));
                detalle.setTotal(rs.getInt(16));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaSullana> BuscarDetallesZonaSullana(String fecha, int zona, int idsubzona) {

        ArrayList<ZonaSullana> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS(?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3,idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaSullana detalle = new ZonaSullana();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setS1(rs.getInt(4));
                detalle.setF5(rs.getInt(5));
                detalle.setF11(rs.getInt(6));
                detalle.setF68(rs.getInt(7));
                detalle.setF73(rs.getInt(8));
                detalle.setTotal(rs.getInt(9));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaTumbes> BuscarDetallesZonaTumbes(String fecha, int zona, int idsubzona) {

        ArrayList<ZonaTumbes> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS(?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaTumbes detalle = new ZonaTumbes();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF7(rs.getInt(4));
                detalle.setF12(rs.getInt(5));
                detalle.setF16(rs.getInt(6));
                detalle.setF26(rs.getInt(7));
                detalle.setF27(rs.getInt(8));
                detalle.setF28(rs.getInt(9));
                detalle.setF29(rs.getInt(10));
                detalle.setF37(rs.getInt(11));
                detalle.setF64(rs.getInt(12));
                detalle.setF66(rs.getInt(13));
                detalle.setTotal(rs.getInt(14));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaTrujillo> BuscarDetallesZonaTrujillo(String fecha, int zona, int idsubzona) {

        ArrayList<ZonaTrujillo> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS(?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaTrujillo detalle = new ZonaTrujillo();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF17(rs.getInt(4));
                detalle.setF21(rs.getInt(5));
                detalle.setF22(rs.getInt(6));
                detalle.setF23(rs.getInt(7));
                detalle.setF38(rs.getInt(8));
                detalle.setF48(rs.getInt(9));
                detalle.setF52(rs.getInt(10));
                detalle.setF53(rs.getInt(11));
                detalle.setF56(rs.getInt(12));
                detalle.setTotal(rs.getInt(13));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaLaUnion> BuscarDetallesZonaUnion(String fecha, int zona, int idsubzona) {

        ArrayList<ZonaLaUnion> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS(?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaLaUnion detalle = new ZonaLaUnion();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF39(rs.getInt(4));
                detalle.setTotal(rs.getInt(5));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaSechura> BuscarDetallesZonaSechura(String fecha, int zona, int idsubzona) {

        ArrayList<ZonaSechura> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS(?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaSechura detalle = new ZonaSechura();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF41(rs.getInt(4));
                detalle.setTotal(rs.getInt(5));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaCatacaos> BuscarDetallesZonaCatacaos(String fecha, int zona, int idsubzona) {

        ArrayList<ZonaCatacaos> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS(?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaCatacaos detalle = new ZonaCatacaos();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF45(rs.getInt(4));
                detalle.setTotal(rs.getInt(5));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaPaita> BuscarDetallesZonaPaita(String fecha, int zona, int idsubzona) {

        ArrayList<ZonaPaita> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS(?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaPaita detalle = new ZonaPaita();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF46(rs.getInt(4));
                detalle.setF60(rs.getInt(5));
                detalle.setTotal(rs.getInt(6));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaChulucanas> BuscarDetallesZonaChulucanas(String fecha, int zona, int idsubzona) {

        ArrayList<ZonaChulucanas> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS(?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaChulucanas detalle = new ZonaChulucanas();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF47(rs.getInt(4));
                detalle.setTotal(rs.getInt(5));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaChimbote> BuscarDetallesZonaChimbote(String fecha, int zona, int idsubzona) {

        ArrayList<ZonaChimbote> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS(?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaChimbote detalle = new ZonaChimbote();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF54(rs.getInt(4));
                detalle.setTotal(rs.getInt(5));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaMancora> BuscarDetallesZonaMancora(String fecha, int zona, int idsubzona) {

        ArrayList<ZonaMancora> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS(?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaMancora detalle = new ZonaMancora();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescriocion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF42(rs.getInt(4));
                detalle.setTotal(rs.getInt(5));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaCajamarca> BuscarDetallesZonaCajamarca(String fecha, int zona, int idsubzona) {

        ArrayList<ZonaCajamarca> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS(?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaCajamarca detalle = new ZonaCajamarca();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF55(rs.getInt(4));
                detalle.setF57(rs.getInt(5));
                detalle.setTotal(rs.getInt(6));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaPiuraCentro> BuscarDetallesZonaPiuraCentro(String fecha, int zona, int idsubzona) {

        ArrayList<ZonaPiuraCentro> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS(?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaPiuraCentro detalle = new ZonaPiuraCentro();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF1(rs.getInt(4));
                detalle.setF2(rs.getInt(5));
                detalle.setF3(rs.getInt(6));
                detalle.setF4(rs.getInt(7));
                detalle.setF35(rs.getInt(8));
                detalle.setF70(rs.getInt(9));
                detalle.setCen(rs.getInt(10));
                detalle.setTotal(rs.getInt(11));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaPiuraCastilla> BuscarDetallesZonaPiuraCastilla(String fecha, int zona, int idsubzona) {

        ArrayList<ZonaPiuraCastilla> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS(?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaPiuraCastilla detalle = new ZonaPiuraCastilla();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF34(rs.getInt(4));
                detalle.setF43(rs.getInt(5));
                detalle.setF49(rs.getInt(6));
                detalle.setF59(rs.getInt(7));
                detalle.setF71(rs.getInt(8));
                detalle.setAsu(rs.getInt(9));
                detalle.setTotal(rs.getInt(10));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaPiuraMercado> BuscarDetallesZonaPiuraMercado(String fecha, int zona, int idsubzona) {

        ArrayList<ZonaPiuraMercado> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS(?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaPiuraMercado detalle = new ZonaPiuraMercado();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF20(rs.getInt(4));
                detalle.setF24(rs.getInt(5));
                detalle.setF32(rs.getInt(6));
                detalle.setF33(rs.getInt(7));
                detalle.setF62(rs.getInt(8));
                detalle.setTotal(rs.getInt(9));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaPiuraUrba> BuscarDetallesZonaPiuraUrba(String fecha, int zona, int idsubzona) {

        ArrayList<ZonaPiuraUrba> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS(?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaPiuraUrba detalle = new ZonaPiuraUrba();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF6(rs.getInt(4));
                detalle.setF14(rs.getInt(5));
                detalle.setF40(rs.getInt(6));
                detalle.setF44(rs.getInt(7));
                detalle.setF63(rs.getInt(8));
                detalle.setF69(rs.getInt(9));
                detalle.setTotal(rs.getInt(10));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    //FILTROS *******************************************************************************************************************
    public static ArrayList<ZonaTalara> BuscarDetallesZonaTalaraFiltro(String fecha, int zona, int idsubzona, String laboratorio) {

        ArrayList<ZonaTalara> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS_FILTRO(?,?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            st.setString(4, laboratorio);
            ResultSet rs = st.executeQuery();       
            while (rs.next()) {
                ZonaTalara detalle = new ZonaTalara();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));
                detalle.setF25(rs.getInt(4));
                detalle.setF31(rs.getInt(5));
                detalle.setTotal(rs.getInt(6));                
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaChiclayo> BuscarDetallesZonaChiclayoFiltro(String fecha, int zona, int idsubzona, String laboratorio) {

        ArrayList<ZonaChiclayo> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS_FILTRO(?,?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            st.setString(4, laboratorio);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaChiclayo detalle = new ZonaChiclayo();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF8(rs.getInt(4));
                detalle.setF9(rs.getInt(5));
                detalle.setF10(rs.getInt(6));
                detalle.setF13(rs.getInt(7));
                detalle.setF15(rs.getInt(8));
                detalle.setF18(rs.getInt(9));
                detalle.setF19(rs.getInt(10));
                detalle.setF30(rs.getInt(11));
                detalle.setF36(rs.getInt(12));
                detalle.setF51(rs.getInt(13));
                detalle.setF61(rs.getInt(14));
                detalle.setF67(rs.getInt(15));
                detalle.setTotal(rs.getInt(16));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaSullana> BuscarDetallesZonaSullanaFiltro(String fecha, int zona, int idsubzona, String laboratorio) {

        ArrayList<ZonaSullana> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS_FILTRO(?,?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3,idsubzona);
            st.setString(4, laboratorio);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaSullana detalle = new ZonaSullana();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setS1(rs.getInt(4));
                detalle.setF5(rs.getInt(5));
                detalle.setF11(rs.getInt(6));
                detalle.setF68(rs.getInt(7));
                detalle.setF73(rs.getInt(8));
                detalle.setTotal(rs.getInt(9));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaTumbes> BuscarDetallesZonaTumbesFiltro(String fecha, int zona, int idsubzona, String laboratorio) {

        ArrayList<ZonaTumbes> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS_FILTRO(?,?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            st.setString(4, laboratorio);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaTumbes detalle = new ZonaTumbes();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF7(rs.getInt(4));
                detalle.setF12(rs.getInt(5));
                detalle.setF16(rs.getInt(6));
                detalle.setF26(rs.getInt(7));
                detalle.setF27(rs.getInt(8));
                detalle.setF28(rs.getInt(9));
                detalle.setF29(rs.getInt(10));
                detalle.setF37(rs.getInt(11));
                detalle.setF64(rs.getInt(12));
                detalle.setF66(rs.getInt(13));
                detalle.setTotal(rs.getInt(14));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaTrujillo> BuscarDetallesZonaTrujilloFiltro(String fecha, int zona, int idsubzona, String laboratorio) {

        ArrayList<ZonaTrujillo> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS_FILTRO(?,?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            st.setString(4, laboratorio);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaTrujillo detalle = new ZonaTrujillo();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF17(rs.getInt(4));
                detalle.setF21(rs.getInt(5));
                detalle.setF22(rs.getInt(6));
                detalle.setF23(rs.getInt(7));
                detalle.setF38(rs.getInt(8));
                detalle.setF48(rs.getInt(9));
                detalle.setF52(rs.getInt(10));
                detalle.setF53(rs.getInt(11));
                detalle.setF56(rs.getInt(12));
                detalle.setTotal(rs.getInt(13));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaLaUnion> BuscarDetallesZonaUnionFiltro(String fecha, int zona, int idsubzona, String laboratorio) {

        ArrayList<ZonaLaUnion> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS_FILTRO(?,?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            st.setString(4, laboratorio);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaLaUnion detalle = new ZonaLaUnion();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF39(rs.getInt(4));
                detalle.setTotal(rs.getInt(5));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaSechura> BuscarDetallesZonaSechuraFiltro(String fecha, int zona, int idsubzona, String laboratorio) {

        ArrayList<ZonaSechura> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS_FILTRO(?,?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            st.setString(4, laboratorio);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaSechura detalle = new ZonaSechura();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF41(rs.getInt(4));
                detalle.setTotal(rs.getInt(5));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaCatacaos> BuscarDetallesZonaCatacaosFiltro(String fecha, int zona, int idsubzona, String laboratorio) {

        ArrayList<ZonaCatacaos> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS_FILTRO(?,?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            st.setString(4, laboratorio);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaCatacaos detalle = new ZonaCatacaos();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF45(rs.getInt(4));
                detalle.setTotal(rs.getInt(5));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaPaita> BuscarDetallesZonaPaitaFiltro(String fecha, int zona, int idsubzona, String laboratorio) {

        ArrayList<ZonaPaita> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS_FILTRO(?,?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            st.setString(4, laboratorio);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaPaita detalle = new ZonaPaita();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF46(rs.getInt(4));
                detalle.setF60(rs.getInt(5));
                detalle.setTotal(rs.getInt(6));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaChulucanas> BuscarDetallesZonaChulucanasFiltro(String fecha, int zona, int idsubzona, String laboratorio) {

        ArrayList<ZonaChulucanas> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS_FILTRO(?,?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            st.setString(4, laboratorio);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaChulucanas detalle = new ZonaChulucanas();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF47(rs.getInt(4));
                detalle.setTotal(rs.getInt(5));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaChimbote> BuscarDetallesZonaChimboteFiltro(String fecha, int zona, int idsubzona, String laboratorio) {

        ArrayList<ZonaChimbote> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS_FILTRO(?,?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            st.setString(4, laboratorio);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaChimbote detalle = new ZonaChimbote();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF54(rs.getInt(4));
                detalle.setTotal(rs.getInt(5));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaMancora> BuscarDetallesZonaMancoraFiltro(String fecha, int zona, int idsubzona, String laboratorio) {

        ArrayList<ZonaMancora> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS_FILTRO(?,?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            st.setString(4, laboratorio);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaMancora detalle = new ZonaMancora();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescriocion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF42(rs.getInt(4));
                detalle.setTotal(rs.getInt(5));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaCajamarca> BuscarDetallesZonaCajamarcaFiltro(String fecha, int zona, int idsubzona, String laboratorio) {

        ArrayList<ZonaCajamarca> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS_FILTRO(?,?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaCajamarca detalle = new ZonaCajamarca();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF55(rs.getInt(4));
                detalle.setF57(rs.getInt(5));
                detalle.setTotal(rs.getInt(6));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaPiuraCentro> BuscarDetallesZonaPiuraCentroFiltro(String fecha, int zona, int idsubzona, String laboratorio) {

        ArrayList<ZonaPiuraCentro> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS_FILTRO(?,?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            st.setString(4, laboratorio);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaPiuraCentro detalle = new ZonaPiuraCentro();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF1(rs.getInt(4));
                detalle.setF2(rs.getInt(5));
                detalle.setF3(rs.getInt(6));
                detalle.setF4(rs.getInt(7));
                detalle.setF35(rs.getInt(8));
                detalle.setF70(rs.getInt(9));
                detalle.setCen(rs.getInt(10));
                detalle.setTotal(rs.getInt(11));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaPiuraCastilla> BuscarDetallesZonaPiuraCastillaFiltro(String fecha, int zona, int idsubzona, String laboratorio) {

        ArrayList<ZonaPiuraCastilla> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS_FILTRO(?,?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaPiuraCastilla detalle = new ZonaPiuraCastilla();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF34(rs.getInt(4));
                detalle.setF43(rs.getInt(5));
                detalle.setF49(rs.getInt(6));
                detalle.setF59(rs.getInt(7));
                detalle.setF71(rs.getInt(8));
                detalle.setAsu(rs.getInt(9));
                detalle.setTotal(rs.getInt(10));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaPiuraMercado> BuscarDetallesZonaPiuraMercadoFiltro(String fecha, int zona, int idsubzona, String laboratorio) {

        ArrayList<ZonaPiuraMercado> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS_FILTRO(?,?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaPiuraMercado detalle = new ZonaPiuraMercado();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF20(rs.getInt(4));
                detalle.setF24(rs.getInt(5));
                detalle.setF32(rs.getInt(6));
                detalle.setF33(rs.getInt(7));
                detalle.setF62(rs.getInt(8));
                detalle.setTotal(rs.getInt(9));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
    
    public static ArrayList<ZonaPiuraUrba> BuscarDetallesZonaPiuraUrbaFiltro(String fecha, int zona, int idsubzona, String laboratorio) {

        ArrayList<ZonaPiuraUrba> lista = new ArrayList();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCAR_ZONAS_FILTRO(?,?,?,?)");
            st.setString(1, fecha);
            st.setInt(2, zona);
            st.setInt(3, idsubzona);
            ResultSet rs = st.executeQuery();   
            while (rs.next()) {
                ZonaPiuraUrba detalle = new ZonaPiuraUrba();
                detalle.setCodigo(rs.getString(1));
                detalle.setDescripcion(rs.getString(2));
                detalle.setLaboratorio(rs.getString(3));                
                detalle.setF6(rs.getInt(4));
                detalle.setF14(rs.getInt(5));
                detalle.setF40(rs.getInt(6));
                detalle.setF44(rs.getInt(7));
                detalle.setF63(rs.getInt(8));
                detalle.setF69(rs.getInt(9));
                detalle.setTotal(rs.getInt(10));               
                lista.add(detalle);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al Buscar detalles por Zona " + ex);
        }
        return lista;
    }
}
