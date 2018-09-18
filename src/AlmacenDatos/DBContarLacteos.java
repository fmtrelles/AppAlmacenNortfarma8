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
public class DBContarLacteos {

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

        ps = cnn.prepareStatement("insert into contar_lacteos(periodo, apellidos_nombres, dni) value (?,?,?)");
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
    
    public static ArrayList<ContarCajas> mostrarConteoLacteosDia(int dia, String periodo) throws SQLException {
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
            c.setDni(rs.getString("dni"));
            c.setGrupo(rs.getInt("id_grupo"));
            c.setPeriodo(rs.getString("periodo"));
            String ddia="D"+String.valueOf(dia).trim();
            c.setD1(rs.getInt(ddia));
            lista.add(c);
        }
        cnn.close();
        ps.close();
        return lista;
    }

    public static ArrayList<ContarCajas> mostrarConteoLacteosPeriodo(String periodo) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<ContarCajas> lista = new ArrayList<ContarCajas>();
        if (periodo.isEmpty()==false) {
            /*ps = cnn.prepareStatement("select grupos_personal.id_grupo,contar_lacteos.* from contar_lacteos inner join "
                    + "grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "
                    + "where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres");
            */
            ps = cnn.prepareStatement("call CONTAR_LACTEOS_MOSTRAR(?)");
            ps.setString(1, periodo);
        }
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ContarCajas c = new ContarCajas();
            c.setApellidosNombres(rs.getString("apellidos_nombres"));
            c.setDni(rs.getString("dni"));
            c.setPeriodo(rs.getString("periodo"));
            c.setGrupo(rs.getInt("id_grupo"));
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
                CadenaDia = "update contar_lacteos set d1=d1+? where periodo=? and dni=?";
                //CadenaMostrar = "SELECT periodo, apellidos_nombres, dni, d1 FROM contar_lacteos Where periodo=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 2:
                CadenaDia = "update contar_lacteos set d2=d2+? where periodo=? and dni=?";
                //CadenaMostrar = "SELECT periodo, apellidos_nombres, dni, d2 FROM contar_lacteos Where periodo=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 3:
                CadenaDia = "update contar_lacteos set d3=d3+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 4:
                CadenaDia = "update contar_lacteos set d4=d4+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 5:
                CadenaDia = "update contar_lacteos set d5=d5+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 6:
                CadenaDia = "update contar_lacteos set d6=d6+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 7:
                CadenaDia = "update contar_lacteos set d7=d7+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 8:
                CadenaDia = "update contar_lacteos set d8=d8+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 9:
                CadenaDia = "update contar_lacteos set d9=d9+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 10:
                CadenaDia = "update contar_lacteos set d10=d10+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 11:
                CadenaDia = "update contar_lacteos set d11=d11+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 12:
                CadenaDia = "update contar_lacteos set d12=d12+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 13:
                CadenaDia = "update contar_lacteos set d13=d13+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 14:
                CadenaDia = "update contar_lacteos set d14=d14+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 15:
                CadenaDia = "update contar_lacteos set d15=d15+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 16:
                CadenaDia = "update contar_lacteos set d16=d16+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 17:
                CadenaDia = "update contar_lacteos set d17=d17+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 18:
                CadenaDia = "update contar_lacteos set d18=d8+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 19:
                CadenaDia = "update contar_lacteos set d19=d9+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 20:
                CadenaDia = "update contar_lacteos set d20=d20+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 21:
                CadenaDia = "update contar_lacteos set d21=d21+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 22:
                CadenaDia = "update contar_lacteos set d22=d22+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 23:
                CadenaDia = "update contar_lacteos set d23=d23+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 24:
                CadenaDia = "update contar_lacteos set d24=d24+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 25:
                CadenaDia = "update contar_lacteos set d25=d25+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 26:
                CadenaDia = "update contar_lacteos set d26=d26+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 27:
                CadenaDia = "update contar_lacteos set d27=d27+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 28:
                CadenaDia = "update contar_lacteos set d28=d28+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 29:
                CadenaDia = "update contar_lacteos set d29=d29+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 30:
                CadenaDia = "update contar_lacteos set d30=d30+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
                break;
            case 31:
                CadenaDia = "update contar_lacteos set d31=d31+? where periodo=? and dni=?";
                CadenaMostrar = "select grupos_personal.id_grupo,periodo, apellidos_nombres, dni, d"+DiaS+ 
			" from contar_lacteos "+
				"inner join grupos_personal on contar_lacteos.dni=grupos_personal.id_personal "+
			"where periodo=? order by grupos_personal.id_grupo, contar_lacteos.apellidos_nombres";
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
