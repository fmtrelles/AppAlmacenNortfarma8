/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenDatos;

import AlmacenClases.Cargos;
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
public class DBCargos {

    public static Cargos insertarCargos(Cargos c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("INSERT INTO cargosalmacen(Descripcion) VALUES (?)");
        //ps.setString(1, c.getId_Cargo());
        ps.setString(1, c.getDescripcion());
        ps.executeUpdate();
        PreparedStatement ps2 = cnn.prepareStatement("select max(Id_Cargo) from cargosalmacen");
        ResultSet r = ps2.executeQuery();
        if (r.next()) {
            int lastID = r.getInt(1);
            c.setId_Cargo(lastID);
        }
        ps2.close();
        cnn.close();
        ps.close();
        return c;
    }

    public static int BuscarNewIdCargo() throws SQLException {
        Connection cnn = BD.getConnection();
        int lastID = 0;
        PreparedStatement ps = cnn.prepareStatement("select max(Id_cargo) from cargosalmacen");
        ResultSet r = ps.executeQuery();
        if (r.next()) {
            lastID = r.getInt(1);
        }

        cnn.close();
        ps.close();
        return lastID + 1;
    }

    public static Cargos buscarCargo(int cod) throws SQLException {
        return buscarCargo(cod, null);
    }

    public static Cargos buscarCargo(int idCargo, Cargos c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select * from cargosalmacen where Id_Cargo=?");
        ps.setInt(1, idCargo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (c == null) {
                c = new Cargos() {
                };
            }
            c.setId_Cargo(idCargo);
            c.setDescripcion(rs.getString("Descripcion"));
        }
        cnn.close();
        ps.close();
        return c;
    }

    public static Cargos buscarCargoDescripcion(String Descrip) throws SQLException {
        return buscarCargoDescripcion(Descrip, null);
    }

    public static Cargos buscarCargoDescripcion(String Descrip, Cargos c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select * from cargosalmacen where Descripcion Like ?");
        ps.setString(1, Descrip);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (c == null) {
                c = new Cargos() {
                };
            }
            c.setId_Cargo(rs.getInt("Id_cargo"));
            c.setDescripcion(rs.getString("Descripcion"));
        }
        cnn.close();
        ps.close();
        return c;
    }

    public static boolean eliminarCargo(int idCargo) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("delete from cargosalmacen WHERE Id_cargo=?");
        ps.setInt(1, idCargo);
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean actualizarCargos(Cargos c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("UPDATE cargosalmacen SET Descripcion=? WHERE Id_cargo=" + c.getId_Cargo());
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

    public static ArrayList<Cargos> mostrarCargos() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Cargos> lista = new ArrayList<Cargos>();

        ps = cnn.prepareStatement("SELECT * FROM cargosalmacen");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Cargos c = new Cargos() {
            };
            c.setId_Cargo(rs.getInt("Id_cargo"));
            c.setDescripcion(rs.getString("Descripcion"));


            lista.add(c);
        }
        cnn.close();
        ps.close();
        return lista;
    }
}
