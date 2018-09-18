
package AlmacenDatos;

import AlmacenClases.Revision_detalle;
import ComponenteDatos.BD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jsarango
 */
public class DBRevision_Detalle {
    public static Revision_detalle insertarRevision(Revision_detalle c) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("CALL REVISION_DETALLE_INSERTAR(?,?,?)");
        ps.setInt(1, c.getId_Revsion());
        ps.setInt(2, c.getGrupo());
        ps.setString(3, c.getId_Personal());
        ps.executeUpdate();
        cnn.close();
        ps.close();
        return c;
    }
}
