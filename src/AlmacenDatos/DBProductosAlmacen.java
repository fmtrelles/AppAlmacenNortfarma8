/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenDatos;
import ComponenteDatos.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import AlmacenClases.ProductoAlmacen;
/**
 *
 * @author Programador
 */
public class DBProductosAlmacen {
 public static ProductoAlmacen insertarProductos(ProductoAlmacen p, Connection cnn) throws SQLException {
        //Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL PRODUCTOSALMACEN_INSERTAR(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, p.getCodpro());
        ps.setString(2, p.getDespro());
        ps.setString(3,p.getCodlab());
        ps.setString(4,p.getDeslab());
        ps.setInt(5,p.getStkalm());
        ps.setInt(6,p.getStkalm_m());
        ps.setInt(7,p.getStkmos());
        ps.setInt(8,p.getStkmos_m());
        ps.setInt(9,p.getStktod());
        ps.setInt(10,p.getStktod_m());
        ps.setString(11,p.getCodbar());
        ps.setDouble(12, p.getTempmaxima());
        ps.setDouble(13, p.getTempminima());
       // ps.setInt(14, p.getMasterpack());
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

    public static ProductoAlmacen buscarProductos(String idprod) throws SQLException {
        return buscarProductos(idprod, null);
    }

    public static ProductoAlmacen buscarProductos(String idprod, ProductoAlmacen p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL PRODUCTOS_BUSCAR_CODIGO(?)");
        ps.setString(1, idprod);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new ProductoAlmacen() {};
            }
            p.setCodpro(idprod);
            p.setDespro(rs.getString("despro"));
            p.setCodlab(rs.getString("codlab"));
            p.setDeslab(rs.getString("deslab"));
            p.setCodbar(rs.getString("codbar"));
            p.setStkalm(rs.getInt("stkalm"));
            p.setStkalm_m(rs.getInt("stkalm"));
            p.setStkmos(rs.getInt("stkmos"));
            p.setStkmos_m(rs.getInt("stkmos_m"));
            p.setStktod(rs.getInt("stktod"));
            p.setStktod_m(rs.getInt("stktod_m"));
            p.setTempmaxima(rs.getDouble("tempmax"));
            p.setTempmaxima(rs.getDouble("tempmin"));
          //  p.setMasterpack(rs.getInt("masterpack"));
        }
        cnn.close();
        ps.close();
        return p;
    }

     public static ProductoAlmacen buscarProductosNombre(String nom) throws SQLException {
        return buscarProductosNombre(nom, null);
    }

    public static ProductoAlmacen buscarProductosNombre(String nom, ProductoAlmacen p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL PRODUCTOS_BUSCAR_DESCRIPCION(?)");
        ps.setString(1, nom);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new ProductoAlmacen() {};
            }
            p.setCodpro(rs.getString("codpro"));
            p.setDespro(rs.getString("despro"));
            p.setCodlab(rs.getString("codlab"));
            p.setDeslab(rs.getString("deslab"));
            p.setCodbar(rs.getString("codbar"));
            p.setStkalm(rs.getInt("stkalm"));
            p.setStkalm_m(rs.getInt("stkalm"));
            p.setStkmos(rs.getInt("stkmos"));
            p.setStkmos_m(rs.getInt("stkmos_m"));
            p.setStktod(rs.getInt("stktod"));
            p.setStktod_m(rs.getInt("stktod_m"));
            p.setTempmaxima(rs.getDouble("tempmax"));
            p.setTempmaxima(rs.getDouble("tempmin"));
           // p.setMasterpack(rs.getInt("masterpack"));
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

        ps = cnn.prepareStatement("TRUNCATE TABLE productosalmacen");
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean actualizarProducto(ProductoAlmacen p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        
        //ps = cnn.prepareStatement("UPDATE productos SET nombre=?, codlab=?, stkfra=?, codbar=? , codbar1=? WHERE pkproducto=" + p.getCodpro());
        ps = cnn.prepareStatement("CALL PRODUCTOSALMACEN_ACTUALIZAR(?,?,?,?)");
        ps.setString(1,p.getCodpro());
        ps.setString(2,p.getCodbar());
        ps.setDouble(3,p.getTempminima());
        ps.setDouble(4,p.getTempmaxima());
        //ps.setDouble(4,p.getTempmaxima());
        //ps.setInt(5, p.getMasterpack());

        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

     public static ArrayList<ProductoAlmacen> mostrarProductos() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<ProductoAlmacen> lista = new ArrayList<ProductoAlmacen>();

        ps = cnn.prepareStatement("CALL PRODUCTOSALMACEN_LISTAR()");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ProductoAlmacen e = new ProductoAlmacen() {};
            e.setCodpro(rs.getString("codpro"));
            e.setDespro(rs.getString("despro"));
            e.setCodlab(rs.getString("codlab"));
            e.setDeslab(rs.getString("deslab"));
            e.setCodbar(rs.getString("codbar"));
            e.setStkalm(rs.getInt("stkalm"));
            e.setStkalm_m(rs.getInt("stkalm_m"));
            e.setStkmos(rs.getInt("stkmos"));
            e.setStkmos_m(rs.getInt("stkmos_m"));
            e.setStktod(rs.getInt("stktod"));
            e.setStktod_m(rs.getInt("stktod_m"));
            e.setTempmaxima(rs.getDouble("tempmax"));
            e.setTempminima(rs.getDouble("tempmin"));
//            e.setMasterpack(rs.getInt("masterPack"));
            lista.add(e);
        }
        cnn.close();
        ps.close();
        return lista;
    }   
}
