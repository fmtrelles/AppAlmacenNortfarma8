/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteDatos;

import ComponenteClase.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Richard
 */
public abstract class BDEmpleado {

    public static Empleado insertarEmpleado(Empleado e) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("call EMPLEADOS_INSERTAR(?,?,?)");
        ps.setString(1, e.getDni());
        ps.setString(2, e.getNombre());
        ps.setString(3, e.getApellido());
        ps.executeUpdate();
        //PreparedStatement ps2 = cnn.prepareStatement("select max(nroEmpleado) from empleado");
        //ResultSet r = ps2.executeQuery();
        //if (r.next()) {
        //    int lastID = r.getInt(1);
        //    e.setNroEmpleado(lastID);
        //}
        //ps2.close();
        cnn.close();
        ps.close();
        return e;
    }

    public static Empleado buscarEmpleado(int nroemp) throws SQLException {
        return buscarEmpleado(nroemp, null);
    }

    public static Empleado buscarEmpleado(int nroemp, Empleado e) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select * from empleado where dni=?");
        ps.setInt(1, nroemp);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (e == null) {
                e = new Empleado() {};
            }
            e.setDni(rs.getString("dni"));
            e.setNombre(rs.getString("nombre"));
            e.setApellido(rs.getString("apellido"));
        }
        cnn.close();
        ps.close();
        return e;
    }

     

    public static Empleado buscarEmpleadoDNI(String dni) throws SQLException {
        return buscarEmpleadoDNI(dni, null);
    }

    public static Empleado buscarEmpleadoDNI(String dni, Empleado e) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select * from empleado where dni=? and eliminado<>1");
        ps.setString(1, dni);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e = e == null ? new Empleado() {} : e;
            e.setDni(rs.getString("dni"));
            e.setNombre(rs.getString("nombre"));
            e.setApellido(rs.getString("apellido"));
        } else {
            e = null;
        }
        cnn.close();
        ps.close();
        return e;
    }

    public static Empleado buscarEmpleadoApe(String ape) throws SQLException {
        return buscarEmpleadoApe(ape, null);
    }

    public static Empleado buscarEmpleadoApe(String ape, Empleado e) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select * from empleado where apellido=? and eliminado<>1");
        ps.setString(1, ape);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e = e == null ? new Empleado() {} : e;
            e.setDni(rs.getString("dni"));
            e.setNombre(rs.getString("nombre"));
            e.setApellido(rs.getString("apellido"));
        } else {
            e = null;
        }
        cnn.close();
        ps.close();
        return e;
    }

    public static boolean eliminarEmpleado(int nroemp) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("update empleado set eliminado=1 WHERE dni=?");
        ps.setInt(1, nroemp);
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean eliminarEmpleadoDNI(String dni) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("update empleado set eliminado=1 WHERE dni=?");
        ps.setString(1, dni);
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean actualizarEmpleado(Empleado e) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("UPDATE empleado SET dni=?, nombre=?, apellido=? WHERE dni=" + e.getDni());
        ps.setString(1, e.getDni());
        ps.setString(2, e.getNombre());
        ps.setString(3, e.getApellido());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Empleado> mostrarEmpleado() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Empleado> lista = new ArrayList<Empleado>();

        ps = cnn.prepareStatement("SELECT * FROM empleado where eliminado=0");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Empleado e = new Empleado() {};
            e.setDni(rs.getString("dni"));
            e.setNombre(rs.getString("nombre"));
            e.setApellido(rs.getString("apellido"));
            lista.add(e);
        }
        cnn.close();
        ps.close();
        return lista;
    }
}
