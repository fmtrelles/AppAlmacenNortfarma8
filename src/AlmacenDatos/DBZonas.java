/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenDatos;

import AlmacenClases.Zonas;
import ComponenteDatos.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jsarango
 */
public class DBZonas {
    public static Zonas insertarZonas(Zonas c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("INSERT INTO zonas(Descripcion) VALUES (?)");
        //ps.setString(1, c.getId_Cargo());
        ps.setString(1, c.getDescripcion());
        ps.executeUpdate();
        PreparedStatement ps2 = cnn.prepareStatement("select max(Id_Zonas) from zonas");
        ResultSet r = ps2.executeQuery();
        if (r.next()) {
            int lastID = r.getInt(1);
            c.setId_Zona(lastID);
        }
        ps2.close();
        cnn.close();
        ps.close();
        return c;
    }

    public static Zonas buscarZonas(int cod) throws SQLException {
        return buscarZonas(cod, null);
    }

     public static Zonas buscarZonas(int idZona, Zonas c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select * from zonas where Id_Zona=?");
        ps.setInt(1, idZona);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (c == null) {
                c = new Zonas() {};
            }
            c.setId_Zona(idZona);
            c.setDescripcion(rs.getString("Descripcion"));
        }
        cnn.close();
        ps.close();
        return c;
    }

    public static Zonas buscarZonasDescripcion(String Descrip) throws SQLException {
        return buscarZonasDescripcion(Descrip, null);
    }

     public static Zonas buscarZonasDescripcion(String Descrip, Zonas c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select * from zonas where Descripcion Like ?");
        ps.setString(1, Descrip);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (c == null) {
                c = new Zonas() {};
            }
            c.setId_Zona(rs.getInt("Id_Zona"));
            c.setDescripcion(rs.getString("Descripcion"));
        }
        cnn.close();
        ps.close();
        return c;
    }

    public static boolean eliminarZonas(int idZona) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("delete from zonas WHERE id_Zona=?");
        ps.setInt(1, idZona);
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

     public static boolean actualizarGrupos(Zonas c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("UPDATE zonas SET Descripcion=? WHERE Id_Zona=" + c.getId_Zona());
        ps.setString(1, c.getDescripcion());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

     public static ArrayList<Zonas> mostrarGZonas() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Zonas> lista = new ArrayList<Zonas>();

        ps = cnn.prepareStatement("SELECT * FROM zonas");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
           Zonas c = new Zonas() {};
           c.setId_Zona(rs.getInt("Id_Zona"));
            c.setDescripcion(rs.getString("Descripcion"));
            
            
            lista.add(c);
        }
        cnn.close();
        ps.close();
        return lista;
    } 
}
