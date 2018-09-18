
package AlmacenDatos;


import AlmacenClases.RevisionGuia_detalle;
import ComponenteDatos.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jsarango
 */
public class DBRevisionGuias_Detalle {
    public static RevisionGuia_detalle insertarRevision(RevisionGuia_detalle c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL REVISIONGUIAS_DETALLE_INSERTAR(?,?,?)");
        ps.setInt(1, c.getId_Revsion());
        ps.setInt(2, c.getGrupo());
        ps.setString(3, c.getId_Personal());
        ps.executeUpdate();
        cnn.close();
        ps.close();
        return c;
    }
}
