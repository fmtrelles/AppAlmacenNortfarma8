/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenDatos;

import AlmacenClases.Resumen_cabecera;
import AlmacenClases.Resumen_detalle;
import ComponenteDatos.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando Muñoz
 */
public class DBResumenCabecera {

    public static Resumen_cabecera InsertarCabecera(Resumen_cabecera cabecera) {
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL RESUMEN_INSERTAR_CABECERA(?,?,?)");
            st.setInt(1, cabecera.getId());
            st.setString(2, cabecera.getFecha());
            st.setString(3, cabecera.getObservacion());
            st.executeUpdate();
            con.close();
            st.close();
            return cabecera;
        } catch (SQLException ex) {
            System.out.println("Error al guardar cabecera:" + ex);
        }
        return cabecera;
    }

    public static ArrayList<Resumen_cabecera> BuscarCabecerasPorFecha(String fecha) {
        //ArrayList<Resumen_cabecera> lista = new ArrayList<>();
        ArrayList<Resumen_cabecera> lista = new ArrayList<Resumen_cabecera>();
        try {
            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("CALL PROC_BUSCARXFECHA(?)");
            st.setString(1, fecha);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Resumen_cabecera dato = new Resumen_cabecera();
                dato.setFecha(rs.getString(1));
                lista.add(dato);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al buscar cabeceras" + ex);
        }
        return lista;
    }

    public static int idmax() {
        int id = 0;
        try {

            Connection con = BD.getConnection();
            PreparedStatement st = null;
            st = con.prepareStatement("SELECT MAX(idcabecera) as IDSIGUIENTE FROM resumen_cabecera");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            con.close();
            st.close();
            return id;
        } catch (SQLException ex) {
            System.out.println("Error al buscar id Máximo:" + ex);
        }
        return id;
    }
}
