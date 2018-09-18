/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteDatos;

import ComponenteClase.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Richard
 */
public abstract class BDUsuario {

    public static void insertarUsuario(Usuario u) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("INSERT INTO USUARIO (id,password,nroEmpleado) VALUES (?,?,?)");
        ps.setString(1, u.getId());
        ps.setString(2, u.getPassword());
        ps.setString(3, u.getEmpleado().getDni());
        ps.executeUpdate();
        cnn.close();
        ps.close();
    }

    public static Usuario buscarUsuario(String idusuario) throws SQLException {
        return buscarUsuario(idusuario, null);
    }

    public static Usuario buscarUsuario(String idusuario, Usuario u) throws SQLException {
        Connection cnn = BD.getConnection();
        System.out.println(cnn);
        if(cnn != null)
        {
           PreparedStatement ps = null;
           System.out.println("Coneccion #1: OK");
            ps = cnn.prepareStatement("select * from usuario where id=?");
            ps.setString(1, idusuario.trim());
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            System.out.println("Coneccion #2: OK");
            if (rs.next()) {
                System.out.println("Coneccion #3: OK");
                if (u == null) {
                    u = new Usuario() {
                    };
                }
                System.out.println("Coneccion FINAL: OK");
                u.setId(idusuario);
                u.setPassword(rs.getString("password"));
                u.setEmpleado(BDEmpleado.buscarEmpleado(rs.getInt("nroEmpleado")));
            }
            cnn.close();
            ps.close();
            return u; 
        }
        return null;
        
    }

    public static boolean eliminarUsuario(String iduser) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("delete from usuario WHERE id=?");
        ps.setString(1, iduser);
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean actualizarUsuario(Usuario u) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("UPDATE usuario SET password=? WHERE nroEmpleado="+u.getEmpleado().getDni());
        ps.setString(1, u.getPassword());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Usuario> mostrarUsuario() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Usuario> lista = new ArrayList<Usuario>();

        ps = cnn.prepareStatement("SELECT * FROM usuario");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Usuario u = new Usuario() {
            };
            u.setId(rs.getString("id"));
            u.setPassword(rs.getString("password"));
            u.setEmpleado(BDEmpleado.buscarEmpleado(rs.getInt("nroEmpleado")));
            lista.add(u);
        }
        cnn.close();
        ps.close();
        return lista;
    }
}
