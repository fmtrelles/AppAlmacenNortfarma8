/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenDatos;
import AlmacenClases.Guias;
import ComponenteDatos.BD;
import ComponenteOtros.LeerTxt;
import java.io.FileNotFoundException;
import java.io.IOException;
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
public class DBGuias {
    
    public static Guias insertarGuias(Guias g) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL GUIAS_INSERTAR(?,?,?,?,?,?)");
        
        ps.setString(1, g.getCodalm());
        ps.setString(2, g.getTypmov());
        ps.setString(3, g.getCodprv());
        ps.setString(4, g.getDocnum());
        ps.setString(5, g.getDocdat());
        ps.setString(6, g.getDatreg());
        ps.executeUpdate();
        
        cnn.close();
        ps.close();
        return g;
    }
    
    public static Guias buscarGuias(String Tipo) throws SQLException {
        return buscarGuias(Tipo, null);
    }

     public static Guias buscarGuias(String Tipo, Guias c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL GUIAS_BUSCAR_X_TIPOMOV(?)");
        ps.setString(1, Tipo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            
            c.setCodalm("CodAlm");
            c.setTypmov(Tipo);
            c.setCodprv("codprv");
            c.setDocnum("Docnum");
            c.setDatreg("Datreg");
            c.setId_Revision(Integer.getInteger("Id_Revision"));
            c.setDocdat("Docdat");
        }
        cnn.close();
        ps.close();
        return c;
    }
     
     public static ArrayList<Guias> mostrarGuias(String Tipo) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Guias> lista = new ArrayList<Guias>();
        ps = cnn.prepareStatement("CALL GUIAS_BUSCAR_X_TIPOMOV(?)");
        ps.setString(1, Tipo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Guias c = new Guias();
            c.setCodalm(rs.getString("CodAlm"));
            c.setTypmov(rs.getString("Typmov"));
            c.setCodprv(rs.getString("codprv"));
            c.setDocnum(rs.getString("Docnum"));
            c.setDatreg(rs.getString("Datreg"));
            c.setId_Revision(rs.getInt("Id_Revision"));
            c.setDocdat(rs.getString("Docdat"));
            lista.add(c);
        }
        cnn.close();
        ps.close();
        return lista;
    }
     
     public static ArrayList<Guias> ListarGuias(String Tipo, String Numero) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Guias> lista = new ArrayList<Guias>();
        ps = cnn.prepareStatement("CALL GUIAS_BUSCAR_X_TIPOMOV_NUMERO(?,?)");
        ps.setString(1, Tipo);
        ps.setString(2, Numero);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Guias c = new Guias();
            c.setCodalm(rs.getString("CodAlm"));
            c.setTypmov(rs.getString("Typmov"));
            c.setCodprv(rs.getString("codprv"));
            c.setDocnum(rs.getString("Docnum"));
            c.setDatreg(rs.getString("Datreg"));
            c.setId_Revision(rs.getInt("Id_Revision"));
            c.setDocdat(rs.getString("Docdat"));
            lista.add(c);
        }
        cnn.close();
        ps.close();
        return lista;
    }
     
     public static boolean eliminarGuiasUltimosDias() throws SQLException, FileNotFoundException, IOException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        String NroDias=LeerTxt.LeerTexto("configalma.txt", 6, "");
        ps = cnn.prepareStatement("call GUIAS_ELIMINAR_N_DIAS(?)");
        ps.setString(1, NroDias);
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
     
     public static Guias insertarGuiasSinCnn(Guias g, Connection cnn) throws SQLException {
        //Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL GUIAS_INSERTAR(?,?,?,?,?,?)");
        
        ps.setString(1, g.getCodalm());
        ps.setString(2, g.getTypmov());
        ps.setString(3, g.getCodprv());
        ps.setString(4, g.getDocnum());
        ps.setString(5, g.getDocdat());
        ps.setString(6, g.getDatreg());
        ps.executeUpdate();
        
        //cnn.close();
        ps.close();
        return g;
    }
}
