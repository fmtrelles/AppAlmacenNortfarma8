/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenDatos;

import AlmacenClases.Guias;
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
public class DBGuias_Detalle_His {

    public static int insertarGuias_Detalle_His(Guias_Detalles c) throws SQLException {
        int TotalRegistros = 0;
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL GUIAS_DETALLE_HIS_INSERTAR(?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, c.getTypmov());
        ps.setString(2, c.getDocnum());
        ps.setString(3, c.getCodpro());
        ps.setString(4, c.getProducto());
        ps.setString(5, c.getId_Laboratorio());
        ps.setInt(6, c.getEmpaque());
        ps.setString(7, c.getCodbar());
        ps.setString(8, c.getStkprf());
        ps.setString(9, c.getLeido());
        ps.setInt(10, c.getEstado());
        ps.setInt(11, c.getId_Revision());
        ps.executeUpdate();
        //PreparedStatement ps2 = cnn.prepareStatement("select count(typmov) from his_guias_detalle");
        //ResultSet r = ps2.executeQuery();
        //if (r.next()) {
        //    TotalRegistros = r.getInt(1);

        //} else {
        //    TotalRegistros = 0;
        //}
        //ps2.close();
        cnn.close();
        ps.close();
        return TotalRegistros;
    }

    public static Guias insertarGuias_His(Guias g) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL GUIAS_HIS_INSERTAR(?,?,?,?,?,?,?)");
        ps.setString(1, g.getCodalm());
        ps.setString(2, g.getTypmov());
        ps.setString(3, g.getCodprv());
        ps.setString(4, g.getDocnum());
        ps.setString(5, g.getDocdat());
        ps.setString(6, g.getDatreg());
        ps.setInt(7, g.getId_Revision());
        ps.executeUpdate();
        //PreparedStatement ps2 = cnn.prepareStatement("select count(codalm) from his_guias where typmov=? and docnum=?");
        //ps2.setString(1, g.getTypmov());
        //ps2.setString(2, g.getDocnum());
        //ResultSet r = ps2.executeQuery();
        //if (r.next()) {
        //    int lastID = r.getInt(1);

        //}
        //ps2.close();
        cnn.close();
        ps.close();
        return g;
    }

    public static ArrayList<Guias_Detalles> mostrarGuiasDetalle_His(String Tipo, String Numero) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Guias_Detalles> lista = new ArrayList<Guias_Detalles>();
        ps = cnn.prepareStatement("CALL GUIAS_DETALLE_HIS_X_TIPO_NUMERO(?,?)");
        ps.setString(1, Tipo);
        ps.setString(2, Numero);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Guias_Detalles c = new Guias_Detalles();

            c.setTypmov(Tipo);
            c.setDocnum(Numero);
            c.setCodpro(rs.getString("fkcodpro"));
            c.setProducto(rs.getString("nombre"));
            c.setCodbar(rs.getString("codbar"));
            c.setId_Laboratorio(rs.getString("laboratorio"));
            c.setEmpaque(rs.getInt("empaque"));
            c.setStkprf(rs.getString("stkprf"));
            c.setLeido(rs.getString("leido"));
            c.setEstado(rs.getInt("estado"));
            c.setId_Revision(rs.getInt("id_Revision"));
            lista.add(c);
        }
        cnn.close();
        ps.close();
        return lista;
    }

    public static ArrayList<Guias> buscarGuias_His(String Tipo, String Numero) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Guias> lista = new ArrayList<Guias>();
        ps = cnn.prepareStatement("CALL GUIAS_HIS_X_TIPO_NUMERO(?,?)");
        ps.setString(1, Tipo);
        ps.setString(2, Numero);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Guias g = new Guias();

            g.setCodalm(rs.getString("codalm"));
            g.setTypmov(rs.getString("typmov"));
            g.setCodprv(rs.getString("codprv"));
            g.setDocnum(rs.getString("docnum"));
            g.setDatreg(rs.getString("datreg"));
            //c.setId_Revision(Integer.getInteger("Id_Revision"));
            g.setDocdat(rs.getString("docdat"));
            g.setId_Revision(rs.getInt("id_revision"));

            lista.add(g);
        }
        cnn.close();
        ps.close();
        return lista;
    }

    public static boolean eliminarGuias_His(String Tipo, String Numero) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps_cabecera = null;
        PreparedStatement ps_detalle = null;
        // se elimina la cabecera
        ps_cabecera = cnn.prepareStatement("delete from his_guias where typmov = ? and docnum=?");
        ps_cabecera.setString(1, Tipo);
        ps_cabecera.setString(2, Numero);
        int rowsUpdated_c = ps_cabecera.executeUpdate();
        // se elimina el detalle
        ps_detalle = cnn.prepareStatement("delete from his_guias_detalle where typmov = ? and docnum=?");
        ps_detalle.setString(1, Tipo);
        ps_detalle.setString(2, Numero);
        int rowsUpdated_d = ps_detalle.executeUpdate();
        cnn.close();
        ps_cabecera.close();
        ps_detalle.close();
        if (rowsUpdated_c > 0 && rowsUpdated_d > 0) {
            return true;
        } else {
            return false;
        }
    }
}
