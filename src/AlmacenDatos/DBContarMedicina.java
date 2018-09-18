/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenDatos;

import AlmacenClases.ContarCajas;
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
public class DBContarMedicina {

    public static boolean ActualizarDiaConteo(int dia, String periodo, String dni, ContarCajas cc) throws SQLException {
        boolean Correcto = true;
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        if (CadenaDia(dia, 1).isEmpty()) {
            Correcto = false;
        } else {
            ps = cnn.prepareStatement(CadenaDia(dia, 1));

            ps.setInt(1, cc.getD1());
            ps.setString(2, cc.getPeriodo());
            ps.setString(3, cc.getDni());
            ps.executeUpdate();
            cnn.close();
            ps.close();
        }
        return Correcto;
    }

    public static void AgregarDiaConteo(ContarCajas cc) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("insert into contar_medicina(periodo, apellidos_nombres, dni) value (?,?,?)");
        ps.setString(1, cc.getPeriodo());
        ps.setString(2, cc.getApellidosNombres());
        ps.setString(3, cc.getDni());
        ps.executeUpdate();
        ps.close();
        cnn.close();
    }

    public static ArrayList<ContarCajas> AbrirPeriodoConteo(String periodo) throws SQLException {
        boolean Correcto = true;
        ArrayList<ContarCajas> lista = new ArrayList<ContarCajas>();
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        if (periodo.isEmpty()) {
            Correcto = false;
        } else {
            ps = cnn.prepareStatement("SELECT * FROM empleado WHERE eliminado=0");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ContarCajas cc = new ContarCajas();
                cc.setApellidosNombres(rs.getString("apellido").toUpperCase() + ", " + rs.getString("nombre"));
                cc.setPeriodo(periodo);
                cc.setDni(rs.getString("dni"));
                lista.add(cc);
            }


        }
        ps.close();
        cnn.close();
        return lista;
    }

    public static ArrayList<ContarCajas> mostrarConteoMedicinaDia(int dia, String periodo) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<ContarCajas> lista = new ArrayList<ContarCajas>();
        if (dia != 0 || dia <= 31) {
            ps = cnn.prepareStatement(CadenaDia(dia, 2));
            ps.setString(1, periodo);
        }
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ContarCajas c = new ContarCajas();
            c.setApellidosNombres(rs.getString("apellidos_nombres"));
            c.setGrupo(rs.getInt("id_grupo"));
            c.setDni(rs.getString("dni"));
            c.setPeriodo(rs.getString("periodo"));
            String ddia="D"+String.valueOf(dia).trim();
            c.setD1(rs.getInt(ddia));
            lista.add(c);
        }
        cnn.close();
        ps.close();
        return lista;
    }
    
    public static ArrayList<ContarCajas> mostrarConteoMedicinaPeriodo( String periodo) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<ContarCajas> lista = new ArrayList<ContarCajas>();
        if (periodo.isEmpty()==false) {
            ps = cnn.prepareStatement("select * from contar_medicina where periodo=?");
            ps.setString(1, periodo);
        }
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ContarCajas c = new ContarCajas();
            c.setApellidosNombres(rs.getString("apellidos_nombres"));
            c.setDni(rs.getString("dni"));
            c.setPeriodo(rs.getString("periodo"));
            
            lista.add(c);
        }
        cnn.close();
        ps.close();
        return lista;
    }

    public static String CadenaDia(int dia, int NroConsulta) {
        String CadenaDia = "";
        String CadenaMostrar = "";
        String DiaS = String.valueOf(dia).trim();
        switch (dia) {
            case 1:
                CadenaDia = "update contar_medicina set d1=? where periodo=? and dni=?";
                //CadenaMostrar = "SELECT periodo, apellidos_nombres, dni, d1 FROM contar_medicina Where periodo=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 2:
                CadenaDia = "update contar_medicina set d2=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 3:
                CadenaDia = "update contar_medicina set d3=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 4:
                CadenaDia = "update contar_medicina set d4=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 5:
                CadenaDia = "update contar_medicina set d5=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 6:
                CadenaDia = "update contar_medicina set d6=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 7:
                CadenaDia = "update contar_medicina set d7=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 8:
                CadenaDia = "update contar_medicina set d8=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 9:
                CadenaDia = "update contar_medicina set d9=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 10:
                CadenaDia = "update contar_medicina set d10=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 11:
                CadenaDia = "update contar_medicina set d11=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 12:
                CadenaDia = "update contar_medicina set d12=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 13:
                CadenaDia = "update contar_medicina set d13=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 14:
                CadenaDia = "update contar_medicina set d14=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 15:
                CadenaDia = "update contar_medicina set d15=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 16:
                CadenaDia = "update contar_medicina set d16=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 17:
                CadenaDia = "update contar_medicina set d17=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 18:
                CadenaDia = "update contar_medicina set d18=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 19:
                CadenaDia = "update contar_medicina set d19=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 20:
                CadenaDia = "update contar_medicina set d20=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 21:
                CadenaDia = "update contar_medicina set d21=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 22:
                CadenaDia = "update contar_medicina set d22=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 23:
                CadenaDia = "update contar_medicina set d23=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 24:
                CadenaDia = "update contar_medicina set d24=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 25:
                CadenaDia = "update contar_medicina set d25=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 26:
                CadenaDia = "update contar_medicina set d26=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 27:
                CadenaDia = "update contar_medicina set d27=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 28:
                CadenaDia = "update contar_medicina set d28=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 29:
                CadenaDia = "update contar_medicina set d29=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 30:
                CadenaDia = "update contar_medicina set d30=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            case 31:
                CadenaDia = "update contar_medicina set d31=? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_medicina "+
				"inner join grupos_personal on contar_medicina.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_medicina.apellidos_nombres";
                break;
            default:
                CadenaDia = "";
                CadenaMostrar = "";
                break;
        }
        if (NroConsulta == 1) {
            return CadenaDia;
        } else {
            return CadenaMostrar;
        }

    }
}
