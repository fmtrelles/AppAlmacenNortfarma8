/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenDatos;


import AlmacenClases.Personal_Grupo;
import ComponenteDatos.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;

/**
 *
 * @author jsarango
 */
public class DBGrupos_Personal {

    DateFormat VariableFecha = DateFormat.getDateInstance(DateFormat.MEDIUM);

    public static Personal_Grupo insertarGrupos_Personal(Personal_Grupo c) throws SQLException {

        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("INSERT INTO grupos_personal(Id_Grupo, Id_Personal, Fecha, Activo, cargo) VALUES (?,?,?,?,?)");
        ps.setInt(1, c.getId_Grupo());
        ps.setString(2, c.getId_Personal());
        ps.setString(3, c.getFecha());
        ps.setInt(4, c.getActivo());
        ps.setInt(5, c.getCargo());
        ps.executeUpdate();
        PreparedStatement ps2 = cnn.prepareStatement("select max(Id_grupo) from grupos_personal");
        ResultSet r = ps2.executeQuery();
        if (r.next()) {
            int lastID = r.getInt(1);
        }
        ps2.close();
        cnn.close();
        ps.close();
        return c;
    }

    public static Personal_Grupo buscarGrupos_Personal(int codg, String codp) throws SQLException {
        return buscarGrupos_Personal(codg, codp, null);
    }

    public static Personal_Grupo buscarGrupos_Personal(int idGrupos, String idPerson, Personal_Grupo c) throws SQLException {

        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL GRUPOS_PERSONAL_BUSCAR_GRUPO_DNI(?,?)");
        ps.setInt(1, idGrupos);
        ps.setString(2, idPerson);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (c == null) {
                c = new Personal_Grupo() {
                };
            }
            c.setId_Grupo(rs.getInt("Id_grupo"));
            c.setNomGrupo(rs.getString("Descripcion"));
            c.setId_Personal(rs.getString("Id_personal"));
            c.setApellidosNombres(rs.getString("apellido")+", "+rs.getString("nombre"));
            c.setApellidos(rs.getString("apellido"));
            c.setNombres(rs.getString("nombre"));
            c.setFecha(rs.getString("Fecha"));
            c.setActivo(rs.getInt("Activo"));
            c.setCargo(rs.getInt("cargo"));
            c.setNomCargo(rs.getString("nomcargo"));
        }
        cnn.close();
        ps.close();
        return c;
    }

    public static boolean eliminarGrupos_Personal(int idGrupos, String idPersonal) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("delete from grupos_personal WHERE Id_Grupo=? and Id_Personal=?");
        ps.setInt(1, idGrupos);
        ps.setString(2, idPersonal);
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean actualizarGrupos_Personal(Personal_Grupo c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("UPDATE grupos_personal SET Fecha=? , Activo=? , Cargo=? WHERE Id_Grupo=" + c.getId_Grupo() + " and Id_Personal=" + c.getId_Personal());
        ps.setString(1, c.getFecha().toString());
        ps.setInt(2, c.getActivo());
        ps.setInt(3, c.getCargo());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Personal_Grupo> mostrarGrupos_Personal(int grupo) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Personal_Grupo> lista = new ArrayList<Personal_Grupo>();
        ps = cnn.prepareStatement("CALL GRUPOS_PERSONAL_X_GRUPO(?)");
        ps.setInt(1, grupo);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Personal_Grupo c = new Personal_Grupo() {
            };
            c.setId_Grupo(rs.getInt("Id_Grupo"));
            c.setNomGrupo(rs.getString("descripcion"));
            c.setId_Personal(rs.getString("Id_Personal"));
            c.setApellidosNombres(rs.getString("apellido").toUpperCase()+", "+rs.getString("nombre"));
            c.setFecha(rs.getString("Fecha"));
            c.setActivo(rs.getInt("Activo"));
            c.setCargo(rs.getInt("cargo"));
            c.setNomCargo(rs.getString("nomcargo"));
            lista.add(c);
        }
        cnn.close();
        ps.close();
        return lista;
    }

    /*public static Date TextToDate(String strDate) {
     * SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-mm-dd");
     * Date ValorFecha = null;
     * 
     * try {
     * String Ffecha = strDate.substring(6, 10) + "-" + strDate.substring(3, 5) + "-" + strDate.substring(0, 2);
     * ValorFecha= formatoDelTexto.parse(VariableFecha.format(Ffecha).toString());
     * } catch (ParseException ex) {
     * Logger.getLogger(FrmGrupos_Personal.class.getName()).log(Level.SEVERE, null, ex);
     * }
     * 
     * return ValorFecha;
     * }*/
}
