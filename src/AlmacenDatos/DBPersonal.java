/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenDatos;

import AlmacenClases.Personal;
import ComponenteDatos.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jsarango
 */
public class DBPersonal {

    public static Personal insertarPersonal(Personal c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("INSERT INTO personal(Id_Personal,Nombre, Apellidos,DNI, Cargo_Almacen) VALUES (?,?,?,?,?)");
        ps.setInt(1, c.getId_Personal());
        ps.setString(2, c.getNombres());
        ps.setString(3, c.getApellidos());
        ps.setString(4, c.getDNI());
        ps.setInt(5, c.getCargo_Almacen().getId_Cargo());
        ps.executeUpdate();
        PreparedStatement ps2 = cnn.prepareStatement("select max(Id_Personal) from personal");
        ResultSet r = ps2.executeQuery();
        if (r.next()) {
            int lastID = r.getInt(1);
            c.setId_Personal(lastID);
        }
        ps2.close();
        cnn.close();
        ps.close();
        return c;
    }

    public static Personal buscarPersonal(int cod) throws SQLException {
        return buscarPersonal(cod, null);
    }

    public static Personal buscarPersonal(int idPersonal, Personal c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select * from personal where Id_Personal=?");
        ps.setInt(1, idPersonal);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (c == null) {
                c = new Personal() {
                };
            }
            c.setId_Personal(idPersonal);
            c.setNombres(rs.getString("Nombres"));
            c.setApellidos(rs.getString("Apellidos"));
            c.setDNI(rs.getString("DNI"));
            c.setCargo_Almacen(DBCargos.buscarCargo(rs.getInt("Cargo_Almacen")));

        }
        cnn.close();
        ps.close();
        return c;
    }

    public static Personal buscarPersonalDNI(String dni) throws SQLException {
        return buscarPersonalDNI(dni, null);
    }

    public static Personal buscarPersonalDNI(String dni, Personal c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("SELECT * FROM personal where DNI=?");
        ps.setString(1, dni.trim());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (c == null) {
                c = new Personal();
            }
            c.setId_Personal(rs.getInt("Id_Personal"));
            c.setNombres(rs.getString("Nombre"));
            c.setApellidos(rs.getString("Apellido"));
            c.setDNI(rs.getString("DNI"));
            c.setCargo_Almacen(DBCargos.buscarCargo(rs.getInt("Cargo_Almacen")));

        }
        cnn.close();
        ps.close();
        return c;
    }

    public static boolean eliminarPersonal(String IdBotica) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("delete from personal WHERE DNI=?");
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

    public static boolean actualizarPersonal(Personal c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("UPDATE personal SET Nombre=?, Apellidos=?, DNI=?, Cargo_Almacen=? WHERE Id_Personal=" + c.getId_Personal());

        ps.setString(1, c.getNombres());
        ps.setString(2, c.getApellidos());
        ps.setString(3, c.getDNI());
        ps.setInt(5, c.getCargo_Almacen().getId_Cargo());

        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static List<Personal> mostrarPersonal() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        List<Personal> lista = new ArrayList<Personal>();
        ps = cnn.prepareStatement("SELECT * FROM personal");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Personal c = new Personal();
            c.setId_Personal(rs.getInt("Id_Personal"));
            c.setNombres(rs.getString("Nombre"));
            c.setApellidos(rs.getString("Apellido"));
            c.setDNI(rs.getString("DNI"));
            c.setCargo_Almacen(DBCargos.buscarCargo(rs.getInt("Cargo_Almacen")));

            lista.add(c);
        }
        cnn.close();
        ps.close();
        return lista;
    }
}
