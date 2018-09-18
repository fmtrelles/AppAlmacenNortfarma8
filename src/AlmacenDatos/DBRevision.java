/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenDatos;


import AlmacenClases.Revision;
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
public class DBRevision {
    public static int insertarRevision(Revision c) throws SQLException {
        int lastID=0;
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL REVISION_INSERTAR(?,?,?,?,?,?,?)");
        ps.setString(1, c.getId_Botica());
        ps.setInt(2, c.getId_grupo());
        ps.setString(3, c.getFecha());
        ps.setString(4, c.getHora_Inicio());
        ps.setString(5, c.getHora_Final());
        ps.setInt(6, c.getCantidad_Cajas());
        ps.setInt(7, c.getCantidad_Guias());
        
        ps.executeUpdate();
        PreparedStatement ps2 = cnn.prepareStatement("select max(Id_Revision) as ultimo from revision");
        ResultSet r = ps2.executeQuery();
        if (r.next()) {
            lastID=r.getInt(1);
            c.setId_Revision(lastID);
        }
        ps2.close();
        cnn.close();
        ps.close();
        return lastID;
    }

    public static Revision buscarRevision(int Id) throws SQLException {
        return buscarRevision(Id, null);
    }

     public static Revision buscarRevision(int id, Revision r) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL REVISION_BUSCAR(?)");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (r == null) {
                r = new Revision() {};
            }
            r.setId_Revision(id);
            r.setId_Botica(rs.getString("Id_Botica"));
            r.setId_grupo(rs.getInt("Id_Grupo"));
            r.setFecha(rs.getString("Fecha"));
            r.setHora_Inicio(rs.getString("Hora_Inicio"));
            r.setHora_Final(rs.getString("Hora_Termino"));
            r.setCantidad_Cajas(rs.getInt("Cantidad_Cajas"));
            r.setCantidad_Guias(rs.getInt("Cantidad_Guias"));
        }
        cnn.close();
        ps.close();
        return r;
    }

    public static boolean eliminarRevision(int id) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("delete from revision WHERE Id_Revision=?");
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

     public static boolean actualizarRevision(Revision r) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("UPDATE revision SET Descripcion=?, Id_Botica=?, Id_Grupo=?, Fecha=?, Hora_Inicio=?, Hora_Termino=?, Cantidad_Cajas=?, Cantidad_Guias=? WHERE Id_Revision="+r.getId_Revision()+"");
        
        ps.setString(1, r.getId_Botica());
        ps.setInt(2, r.getId_grupo());
        ps.setString(3, r.getFecha());
        ps.setString(4, r.getHora_Inicio());
        ps.setString(5, r.getHora_Final());
        ps.setInt(6,r.getCantidad_Cajas());
        ps.setInt(7, r.getCantidad_Guias());
        
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

     public static ArrayList<Revision> mostrarRevision() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Revision> lista = new ArrayList<Revision>();
        ps = cnn.prepareStatement("SELECT * FROM revision");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
           Revision r = new Revision() {};
           r.setId_Revision(rs.getInt("Id_Revision"));
            r.setId_Botica(rs.getString("Id_Botica"));
            r.setId_grupo(rs.getInt("Id_Grupo"));
            r.setFecha(rs.getString("Fecha"));
            r.setHora_Inicio(rs.getString("Hora_Inicio"));
            r.setHora_Final(rs.getString("Hora_Termino"));
            r.setCantidad_Cajas(rs.getInt("Cantidad_Cajas"));
            r.setCantidad_Guias(rs.getInt("Cantidad_Guias"));
            
            lista.add(r);
        }
        cnn.close();
        ps.close();
        return lista;
    }   
}
