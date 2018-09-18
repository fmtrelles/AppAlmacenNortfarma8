package ComponenteReportes;

import ComponenteDatos.BD;
import java.sql.Connection;
/*import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;*/

/**
 *
 * @author Richard
 */
public class ReporteEmpleado {

    private Connection cnn;

    public ReporteEmpleado() {
        cnn = BD.getConnection();
    }

    public void runReporteEmpleado() {
        /*
        try {

            String master = System.getProperty("user.dir") + "/src/ComponenteReportes/reporteEmpleado.jasper";
            System.out.println("master" + master);
            if (master == null) {
                System.out.println("no encuentro el archivo de reporte maestro");
                System.exit(2);
            }
            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(master);

            } catch (JRException e) {
                System.out.println("error cargando el reporte maestro:" + e.getMessage());
                System.exit(3);
            }
            Map parametro = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, cnn);
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("REPORTE DE EMPLEADOS");
            jviewer.setVisible(true);

        } catch (Exception j) {
            System.out.println("mensaje de error:" + j.getMessage());
        }
        */
    }
}
