/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenDatos;

import AlmacenClases.Grupos;
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
public class DBGrupos {
   public static Grupos insertarGrupos(Grupos c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("INSERT INTO grupos(Id_Grupos, Descripcion) VALUES (?,?)");
        //ps.setString(1, c.getId_Cargo());
        ps.setInt(1, c.getId_Grupos());
        ps.setString(2, c.getDescripcion());
        ps.executeUpdate();
        PreparedStatement ps2 = cnn.prepareStatement("select max(Id_Grupos) from grupos");
        ResultSet r = ps2.executeQuery();
        if (r.next()) {
            int lastID = r.getInt(1);
            c.setId_Grupos(lastID);
        }
        ps2.close();
        cnn.close();
        ps.close();
        return c;
    }

   public static int BuscarNewIdGrupo() throws SQLException{
       Connection cnn = BD.getConnection();
       int lastID=0;
        PreparedStatement ps = cnn.prepareStatement("select max(Id_Grupos) from grupos");
        ResultSet r = ps.executeQuery();
        if (r.next()) {
            lastID = r.getInt(1);
        }
        
        cnn.close();
        ps.close();
       return lastID+1;
   }
    public static Grupos buscarGrupos(int cod) throws SQLException {
        return buscarGrupos(cod, null);
    }

     public static Grupos buscarGrupos(int idGrupos, Grupos c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select * from grupos where Id_Grupos=?");
        ps.setInt(1, idGrupos);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (c == null) {
                c = new Grupos() {};
            }
            c.setId_Grupos(idGrupos);
            c.setDescripcion(rs.getString("Descripcion"));
        }
        cnn.close();
        ps.close();
        return c;
    }

    public static Grupos buscarGruposDescripcion(String Descrip) throws SQLException {
        return buscarGruposDescripcion(Descrip, null);
    }

     public static Grupos buscarGruposDescripcion(String Descrip, Grupos g) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("select * from grupos where Descripcion Like ?");
        ps.setString(1, "%"+Descrip+"%");
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            g = new Grupos() ;
            g.setId_Grupos(rs.getInt("Id_Grupos"));
            g.setDescripcion(rs.getString("Descripcion"));
        }
        cnn.close();
        ps.close();
        return g;
    }

    public static boolean eliminarGrupos(int idGrupos) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("delete from grupos WHERE Id_cargo=?");
        ps.setInt(1, idGrupos);
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

     public static boolean actualizarGrupos(Grupos c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("UPDATE grupos SET Descripcion=? WHERE Id_cargo=" + c.getId_Grupos());
        ps.setString(1, c.getDescripcion());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

     public static ArrayList<Grupos> mostrarGrupos() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Grupos> lista = new ArrayList<Grupos>();

        ps = cnn.prepareStatement("SELECT * FROM grupos");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
           Grupos c = new Grupos() {};
           c.setId_Grupos(rs.getInt("Id_Grupos"));
            c.setDescripcion(rs.getString("Descripcion"));
            
            
            lista.add(c);
        }
        cnn.close();
        ps.close();
        return lista;
    } 
}
