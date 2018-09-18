/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenDatos;

import AlmacenClases.Boticas;
import ComponenteDatos.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SEBASTIAN
 */
public class DBBoticas {
 public static Boticas insertarBoticas(Boticas c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("INSERT INTO boticas(Id_Botica,Descripcion, Id_Zona,Acronimo,Cod_Descargo) VALUES (?,?,?,?,?)");
        ps.setString(1, c.getId_Botica());
        ps.setString(2, c.getDescripcion());
        ps.setInt(3, c.getId_Zona());
        ps.setString(4, c.getAcronimo());
        ps.setString(5, c.getCod_Descargo());
        ps.executeUpdate();
        PreparedStatement ps2 = cnn.prepareStatement("select max(Id_Botica) from boticas");
        ResultSet r = ps2.executeQuery();
        if (r.next()) {
            String lastID = r.getString(1);
            c.setId_Botica(lastID);
        }
        ps2.close();
        cnn.close();
        ps.close();
        return c;
    }

    public static Boticas buscarBotica(String cod) throws SQLException {
        return buscarBotica(cod, null);
    }

     public static Boticas buscarBotica(String idbotica, Boticas c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select * from boticas where Id_Botica=?");
        ps.setString(1, idbotica);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (c == null) {
                c = new Boticas() {};
            }
            c.setId_Botica(idbotica);
            c.setDescripcion(rs.getString("Descripcion"));
            c.setId_Zona(rs.getInt("Id_Zona"));
            c.setAcronimo(rs.getString("Acronimo"));
            c.setCod_Descargo(rs.getString("Cod_Descargo"));
        }
        cnn.close();
        ps.close();
        return c;
    }

    public static Boticas buscarBoticaDescripcion(String Descrip) throws SQLException {
        return buscarBotica(Descrip, null);
    }

     public static Boticas buscarBoticaDescripcion(String Descrip, Boticas c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select * from boticas where Descripcion Like ?");
        ps.setString(1, Descrip);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (c == null) {
                c = new Boticas() {};
            }
            c.setId_Botica(rs.getString("Id_Botica"));
            c.setDescripcion(rs.getString("Descripcion"));
            c.setId_Zona(rs.getInt("Id_Zona"));
            c.setAcronimo(rs.getString("Acronimo"));
            c.setCod_Descargo(rs.getString("Cod_Descargo"));
        }
        cnn.close();
        ps.close();
        return c;
    }

    public static boolean eliminarBotica(String IdBotica) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("delete from boticas WHERE Id_Botica=?");
        ps.setString(1, IdBotica);
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

     public static boolean actualizarBotica(Boticas c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("UPDATE boticas SET Descripcion=?, Id_Zona=?, Acronimo=?, Cod_Descargo=? WHERE Id_Botica='"+c.getId_Botica()+"'");
        
        ps.setString(1, c.getDescripcion());
        ps.setInt(2, c.getId_Zona());
        ps.setString(3, c.getAcronimo());
        ps.setString(4, c.getCod_Descargo());
        
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

     public static ArrayList<Boticas> mostrarBoticas() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Boticas> lista = new ArrayList<Boticas>();
        ps = cnn.prepareStatement("SELECT * FROM boticas");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
           Boticas c = new Boticas() {};
           c.setId_Botica(rs.getString("Id_Botica"));
            c.setDescripcion(rs.getString("Descripcion"));
            c.setId_Zona(rs.getInt("Id_Zona"));
            c.setAcronimo(rs.getString("Acronimo"));
            c.setCod_Descargo(rs.getString("Cod_Descargo"));
            
            lista.add(c);
        }
        cnn.close();
        ps.close();
        return lista;
    }   
}
