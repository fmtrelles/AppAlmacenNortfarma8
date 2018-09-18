/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenDatos;

import AlmacenClases.Productos;
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
public class DBProductos {
    
    
    public static Productos insertarProductos(Productos p, Connection cnn) throws SQLException {
        //Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL PRODUCTOS_INSERTAR(?,?,?,?,?,?,?)");
        ps.setString(1, p.getId_Producto());
        ps.setString(2, p.getDescripcion());
        ps.setString(3,p.getId_Laboratorio());
        //ps.setInt(4,p.getEmpaque());
        ps.setDouble(4, p.getEmpaqueSubir());
        ps.setString(5,p.getCodigo_Barras());
        ps.setString(6,p.getCodigo_Barras2());
        ps.setInt(7, p.getEstadoProducto());
        ps.executeUpdate();
        //PreparedStatement ps2 = cnn.prepareStatement("select max(pkproducto) from producto");
        //ResultSet r = ps2.executeQuery();
        //if (r.next()) {
        //    String lastID = r.getString(1);
        //   p.setId_Producto(lastID);
        //}
        //ps2.close();
        
        ps.close();
        return p;
    }

    public static Productos buscarProductos(String idprod) throws SQLException {
        return buscarProductos(idprod, null);
    }

    public static Productos buscarProductos(String idprod, Productos p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL PRODUCTOS_BUSCAR_CODIGO(?)");
        ps.setString(1, idprod);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new Productos() {};
            }
            p.setId_Producto(idprod);
            p.setDescripcion(rs.getString("nombre"));
            p.setId_Laboratorio(rs.getString("codlab"));
            p.setEmpaque(rs.getInt("stkfra"));
            p.setCodigo_Barras(rs.getString("codbar"));
            p.setCodigo_Barras2(rs.getString("codbar1"));
        }
        cnn.close();
        ps.close();
        return p;
    }

     public static Productos buscarProductosNombre(String nom) throws SQLException {
        return buscarProductosNombre(nom, null);
    }

    public static Productos buscarProductosNombre(String nom, Productos p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL PRODUCTOS_BUSCAR_DESCRIPCION(?)");
        ps.setString(1, nom);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new Productos() {};
            }
            p.setId_Producto(rs.getString("pkproducto"));
            p.setDescripcion(rs.getString(nom));
            p.setId_Laboratorio(rs.getString("codlab"));
            p.setEmpaque(rs.getInt("stkfra"));
            p.setCodigo_Barras(rs.getString("codbar"));
            p.setCodigo_Barras2(rs.getString("codbar1"));
        }
        cnn.close();
        ps.close();
        return p;
    }


    public static boolean eliminarProductos(int idprod) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("delete from producto WHERE pkproducto=?");
        ps.setInt(1, idprod);
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean eliminarProductosAll() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("TRUNCATE TABLE producto");
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean actualizarProducto(Productos p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("UPDATE productos SET nombre=?, codlab=?, stkfra=?, codbar=? , codbar1=? WHERE pkproducto=" + p.getId_Producto());
        ps.setString(2, p.getDescripcion());
        ps.setString(3,p.getId_Laboratorio());
        ps.setInt(4,p.getEmpaque());
        ps.setString(5,p.getCodigo_Barras());
        ps.setString(6,p.getCodigo_Barras2());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

     public static ArrayList<Productos> mostrarProductos() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Productos> lista = new ArrayList<Productos>();

        ps = cnn.prepareStatement("SELECT * FROM producto");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Productos e = new Productos() {};
            e.setId_Producto(rs.getString("pkproducto"));
            e.setDescripcion(rs.getString("nombre"));
            e.setId_Laboratorio(rs.getString("codlab"));
            e.setEmpaque(rs.getInt("stkfra"));
            e.setCodigo_Barras(rs.getString("codbar"));
            e.setCodigo_Barras2(rs.getString("codbar1"));
            lista.add(e);
        }
        cnn.close();
        ps.close();
        return lista;
    }
}
