

package AlmacenDatos;

import AlmacenClases.Guias_Detalles;
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


public class DBGuias_Detalle {

    public static Guias_Detalles insertarGuiasDetalle(Guias_Detalles gd) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL GUIAS_DETALLE_INSERTAR_VALIDA(?,?,?,?)");
        ps.setString(1, gd.getTypmov());
        ps.setString(2, gd.getDocnum());
        ps.setString(3, gd.getCodpro());
        ps.setString(4, gd.getStkprf());
        //ps.registerOutParameter(5, Types.INTEGER);
        
        ps.executeUpdate();
        cnn.close();
        ps.close();
        return gd;
    }
    
    public static ArrayList<Guias_Detalles> mostrarGuiasDetalle(String Tipo, String Numero) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Guias_Detalles> lista = new ArrayList<Guias_Detalles>();
        ps = cnn.prepareStatement("CALL GUIAS_DETALLE_X_TIPO_NUMERO(?,?)");
        ps.setString(1, Tipo);
        ps.setString(2, Numero);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Guias_Detalles c = new Guias_Detalles();
            c.setTypmov(rs.getString("typmov"));
            c.setDocnum(rs.getString("docnum"));
            c.setCodpro(rs.getString("fkcodpro"));
            //c.setProducto(r);
            c.setProducto(rs.getString("nombre"));
            c.setId_Laboratorio(rs.getString("codlab"));
            c.setEmpaque(rs.getInt("stkfra"));
            c.setCodbar(rs.getString("codbar"));
            c.setStkprf(rs.getString("stkprf"));
            c.setStksed(rs.getInt("stksed"));
            c.setEstado(0);
            lista.add(c);
            
            //System.out.println(c.getProducto().getDescripcion());
        }
        cnn.close();
        ps.close();
        return lista;
    }
    
    public static boolean eliminarGuiasDetalleUltimosDias() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        
        ps = cnn.prepareStatement("CALL GUIAS_DETALLE_ELIMINAR");
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static Guias_Detalles insertarGuiasDetalleSinCnn(Guias_Detalles gd, Connection cnn) throws SQLException {
        //Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL GUIAS_DETALLE_INSERTAR_VALIDA(?,?,?,?)");
        ps.setString(1, gd.getTypmov());
        ps.setString(2, gd.getDocnum());
        ps.setString(3, gd.getCodpro());
        ps.setString(4, gd.getStkprf());
        //ps.registerOutParameter(5, Types.INTEGER);
        
        ps.executeUpdate();
        //cnn.close();
        ps.close();
        return gd;
    }
}
