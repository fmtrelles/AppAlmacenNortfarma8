/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenDatos;


import AlmacenClases.RevisionGuia;
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
public class DBRevisionGuias {
    public static int insertarRevisionGuias(RevisionGuia c) throws SQLException {
        int lastID=0;
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL REVISIONGUIAS_INSERTAR(?,?,?,?,?,?)");
        ps.setString(1, c.getId_Botica());
        ps.setInt(2, c.getId_grupo());
        ps.setString(3, c.getFecha());
        ps.setString(4, c.getHora_Inicio());
        ps.setString(5, c.getHora_Final());
        ps.setString(6, c.getTiempoAbastecedor());
        
        ps.executeUpdate();
        PreparedStatement ps2 = cnn.prepareStatement("select max(Id_Revision) as ultimo from revisionguias");
        ResultSet r = ps2.executeQuery();
        if (r.next()) {
            lastID=r.getInt(1);
            //c.setId_Revision(lastID);
        }
        ps2.close();
        cnn.close();
        ps.close();
        return lastID;
    }

    public static RevisionGuia buscarRevisionGuias(int Id) throws SQLException {
        return buscarRevisionGuias(Id, null);
    }

     public static RevisionGuia buscarRevisionGuias(int id, RevisionGuia r) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL REVISIONGUIAS_BUSCAR(?)");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (r == null) {
                r = new RevisionGuia() {};
            }
            r.setId_Revision(id);
            r.setId_Botica(rs.getString("Id_Botica"));
            r.setId_grupo(rs.getInt("Id_Grupo"));
            r.setFecha(rs.getString("Fecha"));
            r.setHora_Inicio(rs.getString("Hora_Inicio"));
            r.setHora_Final(rs.getString("Hora_Termino"));
            r.setTiempoAbastecedor(rs.getString("TiempoAbastecedor"));
        }
        cnn.close();
        ps.close();
        return r;
    }

    public static boolean eliminarRevisionGuias(int id) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("delete from revisionguias WHERE Id_Revision=?");
        ps.setInt(1, id);
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

     public static boolean actualizarRevisionGuias(RevisionGuia r) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("UPDATE revisionguias SET Descripcion=?, Id_Botica=?, Id_Grupo=?, Fecha=?, Hora_Inicio=?, Hora_Termino=?, TiempoAbastecedor=? WHERE Id_Revision="+r.getId_Revision()+"");
        
        ps.setString(1, r.getId_Botica());
        ps.setInt(2, r.getId_grupo());
        ps.setString(3, r.getFecha());
        ps.setString(4, r.getHora_Inicio());
        ps.setString(5, r.getHora_Final());
        ps.setString(6,r.getTiempoAbastecedor());
        
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

     public static ArrayList<RevisionGuia> mostrarRevisionGuias() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<RevisionGuia> lista = new ArrayList<RevisionGuia>();
        ps = cnn.prepareStatement("SELECT * FROM revisionguias");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
           RevisionGuia r = new RevisionGuia() {};
           r.setId_Revision(rs.getInt("Id_Revision"));
            r.setId_Botica(rs.getString("Id_Botica"));
            r.setId_grupo(rs.getInt("Id_Grupo"));
            r.setFecha(rs.getString("Fecha"));
            r.setHora_Inicio(rs.getString("Hora_Inicio"));
            r.setHora_Final(rs.getString("Hora_Termino"));
            r.setTiempoAbastecedor(rs.getString("TiempoAbastecedor"));
            lista.add(r);
        }
        cnn.close();
        ps.close();
        return lista;
    }   
}
