/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteOtros;

import AlmacenClases.Grupos;
import AlmacenDatos.DBGrupos;
import ComponenteDatos.BD;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.JxlWriteException;

/**
 *
 * /**
 *
 * @author jsarango
 */
public class Leer_Escribir_Excel {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public static void ExportarRevisionxGrupos(int xmes) throws JxlWriteException, WriteException, FileNotFoundException, IOException, SQLException {
        List<Grupos> ListaGrupos;
        String NomArchivoXLS = JOptionPane.showInputDialog("Ingresar Nombre de Archivo");
         String Ruta=LeerTxt.LeerTexto("configalma.txt", 9, null);
        NomArchivoXLS = Ruta+NomArchivoXLS + ".XLS";
        File file = new File(NomArchivoXLS);
        int row = 0;
        //formato fuente para el contenido contenido
        WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
        WritableCellFormat cf = new WritableCellFormat(wf);

        WritableFont wf2 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
        WritableCellFormat cf2 = new WritableCellFormat(wf2);

        //Interfaz para una hoja de cálculo
        WritableSheet excelSheet = null;
        WritableWorkbook workbook = null;

        //Establece la configuración regional para generar la hoja de cálculo
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));

        try {
            workbook = Workbook.createWorkbook(file, wbSettings);

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        //hoja con nombre de la tabla


        ListaGrupos = DBGrupos.mostrarGrupos();
        for (int i = 0; i < ListaGrupos.size(); i++) {
            row=0;
            workbook.createSheet(ListaGrupos.get(i).getDescripcion(), 0);

            excelSheet = workbook.getSheet(0);
            System.out.println("creando hoja excel.....Listo");

            row++;
            Label tgrupo = new Label(1, row, "GRUPO", cf);
            Label tzona = new Label(2, row, "ZONA", cf);
            Label tbotica = new Label(3, row, "BOTICA", cf);
            Label t1 = new Label(4, row, "D1", cf2);
            Label t2 = new Label(5, row, "D2", cf2);
            Label t3 = new Label(6, row, "D3", cf2);
            Label t4 = new Label(7, row, "D4", cf2);
            Label t5 = new Label(8, row, "D5", cf2);
            Label t6 = new Label(9, row, "D6", cf2);
            Label t7 = new Label(10, row, "D7", cf2);
            Label t8 = new Label(11, row, "D8", cf2);
            Label t9 = new Label(12, row, "D9", cf2);
            Label t10 = new Label(13, row, "D10", cf2);
            Label t11 = new Label(14, row, "D11", cf2);
            Label t12 = new Label(15, row, "D12", cf2);
            Label t13 = new Label(16, row, "D13", cf2);
            Label t14 = new Label(17, row, "D14", cf2);
            Label t15 = new Label(18, row, "D15", cf2);
            Label t16 = new Label(19, row, "D16", cf2);
            Label t17 = new Label(20, row, "D17", cf2);
            Label t18 = new Label(21, row, "D18", cf2);
            Label t19 = new Label(22, row, "D19", cf2);
            Label t20 = new Label(23, row, "D20", cf2);
            Label t21 = new Label(24, row, "D21", cf2);
            Label t22 = new Label(25, row, "D22", cf2);
            Label t23 = new Label(26, row, "D23", cf2);
            Label t24 = new Label(27, row, "D24", cf2);
            Label t25 = new Label(28, row, "D25", cf2);
            Label t26 = new Label(29, row, "D26", cf2);
            Label t27 = new Label(30, row, "D27", cf2);
            Label t28 = new Label(31, row, "D28", cf2);
            Label t29 = new Label(32, row, "D29", cf2);
            Label t30 = new Label(33, row, "D30", cf2);
            Label t31 = new Label(34, row, "D31", cf2);
            //Label tt = new Label(35, row, "TOTAL", cf2);
            try {
                excelSheet.addCell(tgrupo);
                excelSheet.addCell(tzona);
                excelSheet.addCell(tbotica);
                excelSheet.addCell(t1);
                excelSheet.addCell(t2);
                excelSheet.addCell(t3);
                excelSheet.addCell(t4);
                excelSheet.addCell(t5);
                excelSheet.addCell(t6);
                excelSheet.addCell(t7);
                excelSheet.addCell(t8);
                excelSheet.addCell(t9);
                excelSheet.addCell(t10);
                excelSheet.addCell(t11);
                excelSheet.addCell(t12);
                excelSheet.addCell(t13);
                excelSheet.addCell(t14);
                excelSheet.addCell(t15);
                excelSheet.addCell(t16);
                excelSheet.addCell(t17);
                excelSheet.addCell(t18);
                excelSheet.addCell(t19);
                excelSheet.addCell(t20);
                excelSheet.addCell(t21);
                excelSheet.addCell(t22);
                excelSheet.addCell(t23);
                excelSheet.addCell(t24);
                excelSheet.addCell(t25);
                excelSheet.addCell(t26);
                excelSheet.addCell(t27);
                excelSheet.addCell(t28);
                excelSheet.addCell(t29);
                excelSheet.addCell(t30);
                excelSheet.addCell(t31);
                //excelSheet.addCell(tt);
            } catch (WriteException ex) {
                System.err.println(ex.getMessage());
            }
            //Consulta SQL 
            String sql = "CALL REVISION_CONSOLIDADO_X_MES_GRUPO(?,?)";
            try {
                Connection conn = BD.getConnection();
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.setInt(1,ListaGrupos.get(i).getId_Grupos());
                pstm.setInt(2, xmes);
                ResultSet res = pstm.executeQuery();
                System.out.println("obteniendo registros.....Listo");
                while (res.next()) {
                    row++;
                    //Number ci     = new Number( 0 , row, res.getLong( "ci" ) , cf );

                    Label dgrupo = new Label(1, row, res.getString("id_grupo"), cf);
                    Label dzona = new Label(2, row, res.getString("descripcion"), cf);
                    Label dbotica = new Label(3, row, res.getString("acronimo"), cf);
                    Number d1 = new Number(4, row, res.getFloat("d1"), cf);
                    Number d2 = new Number(5, row, res.getFloat("d2"), cf);
                    Number d3 = new Number(6, row, res.getFloat("d3"), cf);
                    Number d4 = new Number(7, row, res.getFloat("d4"), cf);
                    Number d5 = new Number(8, row, res.getFloat("d5"), cf);
                    Number d6 = new Number(9, row, res.getFloat("d6"), cf);
                    Number d7 = new Number(10, row, res.getFloat("d7"), cf);
                    Number d8 = new Number(11, row, res.getFloat("d8"), cf);
                    Number d9 = new Number(12, row, res.getFloat("d9"), cf);
                    Number d10 = new Number(13, row, res.getFloat("d10"), cf);
                    Number d11 = new Number(14, row, res.getFloat("d11"), cf);
                    Number d12 = new Number(15, row, res.getFloat("d12"), cf);
                    Number d13 = new Number(16, row, res.getFloat("d13"), cf);
                    Number d14 = new Number(17, row, res.getFloat("d14"), cf);
                    Number d15 = new Number(18, row, res.getFloat("d15"), cf);
                    Number d16 = new Number(19, row, res.getFloat("d16"), cf);
                    Number d17 = new Number(20, row, res.getFloat("d17"), cf);
                    Number d18 = new Number(21, row, res.getFloat("d18"), cf);
                    Number d19 = new Number(22, row, res.getFloat("d19"), cf);
                    Number d20 = new Number(23, row, res.getFloat("d20"), cf);
                    Number d21 = new Number(24, row, res.getFloat("d21"), cf);
                    Number d22 = new Number(25, row, res.getFloat("d22"), cf);
                    Number d23 = new Number(26, row, res.getFloat("d23"), cf);
                    Number d24 = new Number(27, row, res.getFloat("d24"), cf);
                    Number d25 = new Number(28, row, res.getFloat("d25"), cf);
                    Number d26 = new Number(29, row, res.getFloat("d26"), cf);
                    Number d27 = new Number(30, row, res.getFloat("d27"), cf);
                    Number d28 = new Number(31, row, res.getFloat("d28"), cf);
                    Number d29 = new Number(32, row, res.getFloat("d29"), cf);
                    Number d30 = new Number(33, row, res.getFloat("d30"), cf);
                    Number d31 = new Number(34, row, res.getFloat("d31"), cf);
                    //Number tt1 = new Number(35, row, res.getFloat("total"), cf);
                    try {

                        excelSheet.addCell(dgrupo);
                        excelSheet.addCell(dzona);
                        excelSheet.addCell(dbotica);
                        excelSheet.addCell(d1);
                        excelSheet.addCell(d2);
                        excelSheet.addCell(d3);
                        excelSheet.addCell(d4);
                        excelSheet.addCell(d5);
                        excelSheet.addCell(d6);
                        excelSheet.addCell(d7);
                        excelSheet.addCell(d8);
                        excelSheet.addCell(d9);
                        excelSheet.addCell(d10);
                        excelSheet.addCell(d11);
                        excelSheet.addCell(d12);
                        excelSheet.addCell(d13);
                        excelSheet.addCell(d14);
                        excelSheet.addCell(d15);
                        excelSheet.addCell(d16);
                        excelSheet.addCell(d17);
                        excelSheet.addCell(d18);
                        excelSheet.addCell(d19);
                        excelSheet.addCell(d20);
                        excelSheet.addCell(d21);
                        excelSheet.addCell(d22);
                        excelSheet.addCell(d23);
                        excelSheet.addCell(d24);
                        excelSheet.addCell(d25);
                        excelSheet.addCell(d26);
                        excelSheet.addCell(d27);
                        excelSheet.addCell(d28);
                        excelSheet.addCell(d29);
                        excelSheet.addCell(d30);
                        excelSheet.addCell(d31);
                        //excelSheet.addCell(tt);


                    } catch (WriteException ex) {
                        System.err.println(ex.getMessage());
                    }
                }

                res.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        //Escribe el archivo excel en disco
        try {
            workbook.write();
            workbook.close();
            System.out.println("Escribiendo en disco....Listo");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (WriteException ex) {
            System.err.println(ex.getMessage());
        }

        JOptionPane.showMessageDialog(null, "Proceso completado....");
        System.out.println("Proceso completado....");
    }

    public static void ExportarConteoMedicina(String Periodo) throws JxlWriteException, WriteException, FileNotFoundException, IOException {
        String NomArchivoXLS = JOptionPane.showInputDialog("Ingresar Nombre de Archivo");
         String Ruta=LeerTxt.LeerTexto("configalma.txt", 9, null);
        NomArchivoXLS = Ruta+NomArchivoXLS + ".XLS";
        File file = new File(NomArchivoXLS);
        int row = 0;
        //formato fuente para el contenido contenido
        WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
        WritableCellFormat cf = new WritableCellFormat(wf);

        WritableFont wf2 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
        WritableCellFormat cf2 = new WritableCellFormat(wf2);

        //Interfaz para una hoja de cálculo
        WritableSheet excelSheet = null;
        WritableWorkbook workbook = null;

        //Establece la configuración regional para generar la hoja de cálculo
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));



        try {
            workbook = Workbook.createWorkbook(file, wbSettings);
            //hoja con nombre de la tabla
            workbook.createSheet("MEDICINA", 0);
            excelSheet = workbook.getSheet(0);
            System.out.println("creando hoja excel.....Listo");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        row++;
        Label tperiodo = new Label(1, row, "Periodo", cf2);
        Label tapellido = new Label(2, row, "Apellidos y Nombres", cf2);
        Label tdni = new Label(3, row, "DNI", cf2);
        Label t1 = new Label(4, row, "D1", cf2);
        Label t2 = new Label(5, row, "D2", cf2);
        Label t3 = new Label(6, row, "D3", cf2);
        Label t4 = new Label(7, row, "D4", cf2);
        Label t5 = new Label(8, row, "D5", cf2);
        Label t6 = new Label(9, row, "D6", cf2);
        Label t7 = new Label(10, row, "D7", cf2);
        Label t8 = new Label(11, row, "D8", cf2);
        Label t9 = new Label(12, row, "D9", cf2);
        Label t10 = new Label(13, row, "D10", cf2);
        Label t11 = new Label(14, row, "D11", cf2);
        Label t12 = new Label(15, row, "D12", cf2);
        Label t13 = new Label(16, row, "D13", cf2);
        Label t14 = new Label(17, row, "D14", cf2);
        Label t15 = new Label(18, row, "D15", cf2);
        Label t16 = new Label(19, row, "D16", cf2);
        Label t17 = new Label(20, row, "D17", cf2);
        Label t18 = new Label(21, row, "D18", cf2);
        Label t19 = new Label(22, row, "D19", cf2);
        Label t20 = new Label(23, row, "D20", cf2);
        Label t21 = new Label(24, row, "D21", cf2);
        Label t22 = new Label(25, row, "D22", cf2);
        Label t23 = new Label(26, row, "D23", cf2);
        Label t24 = new Label(27, row, "D24", cf2);
        Label t25 = new Label(28, row, "D25", cf2);
        Label t26 = new Label(29, row, "D26", cf2);
        Label t27 = new Label(30, row, "D27", cf2);
        Label t28 = new Label(31, row, "D28", cf2);
        Label t29 = new Label(32, row, "D29", cf2);
        Label t30 = new Label(33, row, "D30", cf2);
        Label t31 = new Label(34, row, "D31", cf2);
        Label tt = new Label(35, row, "TOTAL", cf2);

        try {

            excelSheet.addCell(tperiodo);
            excelSheet.addCell(tapellido);
            excelSheet.addCell(tdni);
            excelSheet.addCell(t1);
            excelSheet.addCell(t2);
            excelSheet.addCell(t3);
            excelSheet.addCell(t4);
            excelSheet.addCell(t5);
            excelSheet.addCell(t6);
            excelSheet.addCell(t7);
            excelSheet.addCell(t8);
            excelSheet.addCell(t9);
            excelSheet.addCell(t10);
            excelSheet.addCell(t11);
            excelSheet.addCell(t12);
            excelSheet.addCell(t13);
            excelSheet.addCell(t14);
            excelSheet.addCell(t15);
            excelSheet.addCell(t16);
            excelSheet.addCell(t17);
            excelSheet.addCell(t18);
            excelSheet.addCell(t19);
            excelSheet.addCell(t20);
            excelSheet.addCell(t21);
            excelSheet.addCell(t22);
            excelSheet.addCell(t23);
            excelSheet.addCell(t24);
            excelSheet.addCell(t25);
            excelSheet.addCell(t26);
            excelSheet.addCell(t27);
            excelSheet.addCell(t28);
            excelSheet.addCell(t29);
            excelSheet.addCell(t30);
            excelSheet.addCell(t31);
            excelSheet.addCell(tt);
        } catch (WriteException ex) {
            System.err.println(ex.getMessage());
        }
        //Consulta SQL 
        String sql = "SELECT *,d1+d2+d3+d4+d5+d6+d7+d8+d9+d10+d11+d12+d13+d14+d15+d16+d17+d18+d19+d20+d21+d22+d23+d24+d25+d26+d27+d28+d29+d30+d31 as total FROM contar_medicina where periodo=?";
        try {
            Connection conn = BD.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, Periodo);
            ResultSet res = pstm.executeQuery();
            System.out.println("obteniendo registros.....Listo");
            while (res.next()) {
                row++;
                //Number ci     = new Number( 0 , row, res.getLong( "ci" ) , cf );

                Label periodo = new Label(1, row, res.getString("periodo"), cf);
                Label apellido = new Label(2, row, res.getString("apellidos_nombres"), cf);
                Label dni = new Label(3, row, res.getString("dni"), cf);
                Number d1 = new Number(4, row, res.getFloat("d1"), cf);
                Number d2 = new Number(5, row, res.getFloat("d2"), cf);
                Number d3 = new Number(6, row, res.getFloat("d3"), cf);
                Number d4 = new Number(7, row, res.getFloat("d4"), cf);
                Number d5 = new Number(8, row, res.getFloat("d5"), cf);
                Number d6 = new Number(9, row, res.getFloat("d6"), cf);
                Number d7 = new Number(10, row, res.getFloat("d7"), cf);
                Number d8 = new Number(11, row, res.getFloat("d8"), cf);
                Number d9 = new Number(12, row, res.getFloat("d9"), cf);
                Number d10 = new Number(13, row, res.getFloat("d10"), cf);
                Number d11 = new Number(14, row, res.getFloat("d11"), cf);
                Number d12 = new Number(15, row, res.getFloat("d12"), cf);
                Number d13 = new Number(16, row, res.getFloat("d13"), cf);
                Number d14 = new Number(17, row, res.getFloat("d14"), cf);
                Number d15 = new Number(18, row, res.getFloat("d15"), cf);
                Number d16 = new Number(19, row, res.getFloat("d16"), cf);
                Number d17 = new Number(20, row, res.getFloat("d17"), cf);
                Number d18 = new Number(21, row, res.getFloat("d18"), cf);
                Number d19 = new Number(22, row, res.getFloat("d19"), cf);
                Number d20 = new Number(23, row, res.getFloat("d20"), cf);
                Number d21 = new Number(24, row, res.getFloat("d21"), cf);
                Number d22 = new Number(25, row, res.getFloat("d22"), cf);
                Number d23 = new Number(26, row, res.getFloat("d23"), cf);
                Number d24 = new Number(27, row, res.getFloat("d24"), cf);
                Number d25 = new Number(28, row, res.getFloat("d25"), cf);
                Number d26 = new Number(29, row, res.getFloat("d26"), cf);
                Number d27 = new Number(30, row, res.getFloat("d27"), cf);
                Number d28 = new Number(31, row, res.getFloat("d28"), cf);
                Number d29 = new Number(32, row, res.getFloat("d29"), cf);
                Number d30 = new Number(33, row, res.getFloat("d30"), cf);
                Number d31 = new Number(34, row, res.getFloat("d31"), cf);
                Number tt1 = new Number(35, row, res.getFloat("total"), cf);


                try {

                    excelSheet.addCell(periodo);
                    excelSheet.addCell(apellido);
                    excelSheet.addCell(dni);
                    excelSheet.addCell(d1);
                    excelSheet.addCell(d2);
                    excelSheet.addCell(d3);
                    excelSheet.addCell(d4);
                    excelSheet.addCell(d5);
                    excelSheet.addCell(d6);
                    excelSheet.addCell(d7);
                    excelSheet.addCell(d8);
                    excelSheet.addCell(d9);
                    excelSheet.addCell(d10);
                    excelSheet.addCell(d11);
                    excelSheet.addCell(d12);
                    excelSheet.addCell(d13);
                    excelSheet.addCell(d14);
                    excelSheet.addCell(d15);
                    excelSheet.addCell(d16);
                    excelSheet.addCell(d17);
                    excelSheet.addCell(d18);
                    excelSheet.addCell(d19);
                    excelSheet.addCell(d20);
                    excelSheet.addCell(d21);
                    excelSheet.addCell(d22);
                    excelSheet.addCell(d23);
                    excelSheet.addCell(d24);
                    excelSheet.addCell(d25);
                    excelSheet.addCell(d26);
                    excelSheet.addCell(d27);
                    excelSheet.addCell(d28);
                    excelSheet.addCell(d29);
                    excelSheet.addCell(d30);
                    excelSheet.addCell(d31);
                    excelSheet.addCell(tt1);
                } catch (WriteException ex) {
                    System.err.println(ex.getMessage());
                }
            }

            res.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        //Escribe el archivo excel en disco
        try {
            workbook.write();
            workbook.close();
            System.out.println("Escribiendo en disco....Listo");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (WriteException ex) {
            System.err.println(ex.getMessage());
        }

        JOptionPane.showMessageDialog(null, "Proceso completado....");
        System.out.println("Proceso completado....");
    }

    public static void ExportarConteoLacteos(String Periodo) throws JxlWriteException, WriteException, FileNotFoundException, IOException {
        String NomArchivoXLS = JOptionPane.showInputDialog("Ingresar Nombre de Archivo");
         String Ruta=LeerTxt.LeerTexto("configalma.txt", 9, null);
        NomArchivoXLS = Ruta+NomArchivoXLS + ".XLS";
        File file = new File(NomArchivoXLS);
        int row = 0;
        //formato fuente para el contenido contenido
        WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
        WritableCellFormat cf = new WritableCellFormat(wf);
        WritableFont wf2 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
        WritableCellFormat cf2 = new WritableCellFormat(wf2);

        //Interfaz para una hoja de cálculo
        WritableSheet excelSheet = null;
        WritableWorkbook workbook = null;

        //Establece la configuración regional para generar la hoja de cálculo
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));

        try {
            workbook = Workbook.createWorkbook(file, wbSettings);
            //hoja con nombre de la tabla
            workbook.createSheet("LACTEOS", 0);
            excelSheet = workbook.getSheet(0);
            System.out.println("creando hoja excel.....Listo");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        row++;
        Label tperiodo = new Label(1, row, "Periodo", cf2);
        Label tapellido = new Label(2, row, "Apellidos y Nombres", cf2);
        Label tdni = new Label(3, row, "DNI", cf2);
        Label t1 = new Label(4, row, "D1", cf2);
        Label t2 = new Label(5, row, "D2", cf2);
        Label t3 = new Label(6, row, "D3", cf2);
        Label t4 = new Label(7, row, "D4", cf2);
        Label t5 = new Label(8, row, "D5", cf2);
        Label t6 = new Label(9, row, "D6", cf2);
        Label t7 = new Label(10, row, "D7", cf2);
        Label t8 = new Label(11, row, "D8", cf2);
        Label t9 = new Label(12, row, "D9", cf2);
        Label t10 = new Label(13, row, "D10", cf2);
        Label t11 = new Label(14, row, "D11", cf2);
        Label t12 = new Label(15, row, "D12", cf2);
        Label t13 = new Label(16, row, "D13", cf2);
        Label t14 = new Label(17, row, "D14", cf2);
        Label t15 = new Label(18, row, "D15", cf2);
        Label t16 = new Label(19, row, "D16", cf2);
        Label t17 = new Label(20, row, "D17", cf2);
        Label t18 = new Label(21, row, "D18", cf2);
        Label t19 = new Label(22, row, "D19", cf2);
        Label t20 = new Label(23, row, "D20", cf2);
        Label t21 = new Label(24, row, "D21", cf2);
        Label t22 = new Label(25, row, "D22", cf2);
        Label t23 = new Label(26, row, "D23", cf2);
        Label t24 = new Label(27, row, "D24", cf2);
        Label t25 = new Label(28, row, "D25", cf2);
        Label t26 = new Label(29, row, "D26", cf2);
        Label t27 = new Label(30, row, "D27", cf2);
        Label t28 = new Label(31, row, "D28", cf2);
        Label t29 = new Label(32, row, "D29", cf2);
        Label t30 = new Label(33, row, "D30", cf2);
        Label t31 = new Label(34, row, "D31", cf2);
        Label tt = new Label(35, row, "TOTAL", cf2);
        try {

            excelSheet.addCell(tperiodo);
            excelSheet.addCell(tapellido);
            excelSheet.addCell(tdni);
            excelSheet.addCell(t1);
            excelSheet.addCell(t2);
            excelSheet.addCell(t3);
            excelSheet.addCell(t4);
            excelSheet.addCell(t5);
            excelSheet.addCell(t6);
            excelSheet.addCell(t7);
            excelSheet.addCell(t8);
            excelSheet.addCell(t9);
            excelSheet.addCell(t10);
            excelSheet.addCell(t11);
            excelSheet.addCell(t12);
            excelSheet.addCell(t13);
            excelSheet.addCell(t14);
            excelSheet.addCell(t15);
            excelSheet.addCell(t16);
            excelSheet.addCell(t17);
            excelSheet.addCell(t18);
            excelSheet.addCell(t19);
            excelSheet.addCell(t20);
            excelSheet.addCell(t21);
            excelSheet.addCell(t22);
            excelSheet.addCell(t23);
            excelSheet.addCell(t24);
            excelSheet.addCell(t25);
            excelSheet.addCell(t26);
            excelSheet.addCell(t27);
            excelSheet.addCell(t28);
            excelSheet.addCell(t29);
            excelSheet.addCell(t30);
            excelSheet.addCell(t31);
            excelSheet.addCell(tt);
        } catch (WriteException ex) {
            System.err.println(ex.getMessage());
        }
        //Consulta SQL 
        String sql = "SELECT *,d1+d2+d3+d4+d5+d6+d7+d8+d9+d10+d11+d12+d13+d14+d15+d16+d17+d18+d19+d20+d21+d22+d23+d24+d25+d26+d27+d28+d29+d30+d31 as total FROM contar_lacteos where periodo=?";
        try {
            Connection conn = BD.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, Periodo);
            ResultSet res = pstm.executeQuery();
            System.out.println("obteniendo registros.....Listo");
            while (res.next()) {
                row++;
                //Number ci     = new Number( 0 , row, res.getLong( "ci" ) , cf );

                Label periodo = new Label(1, row, res.getString("periodo"), cf);
                Label apellido = new Label(2, row, res.getString("apellidos_nombres"), cf);
                Label dni = new Label(3, row, res.getString("dni"), cf);
                Number d1 = new Number(4, row, res.getFloat("d1"), cf);
                Number d2 = new Number(5, row, res.getFloat("d2"), cf);
                Number d3 = new Number(6, row, res.getFloat("d3"), cf);
                Number d4 = new Number(7, row, res.getFloat("d4"), cf);
                Number d5 = new Number(8, row, res.getFloat("d5"), cf);
                Number d6 = new Number(9, row, res.getFloat("d6"), cf);
                Number d7 = new Number(10, row, res.getFloat("d7"), cf);
                Number d8 = new Number(11, row, res.getFloat("d8"), cf);
                Number d9 = new Number(12, row, res.getFloat("d9"), cf);
                Number d10 = new Number(13, row, res.getFloat("d10"), cf);
                Number d11 = new Number(14, row, res.getFloat("d11"), cf);
                Number d12 = new Number(15, row, res.getFloat("d12"), cf);
                Number d13 = new Number(16, row, res.getFloat("d13"), cf);
                Number d14 = new Number(17, row, res.getFloat("d14"), cf);
                Number d15 = new Number(18, row, res.getFloat("d15"), cf);
                Number d16 = new Number(19, row, res.getFloat("d16"), cf);
                Number d17 = new Number(20, row, res.getFloat("d17"), cf);
                Number d18 = new Number(21, row, res.getFloat("d18"), cf);
                Number d19 = new Number(22, row, res.getFloat("d19"), cf);
                Number d20 = new Number(23, row, res.getFloat("d20"), cf);
                Number d21 = new Number(24, row, res.getFloat("d21"), cf);
                Number d22 = new Number(25, row, res.getFloat("d22"), cf);
                Number d23 = new Number(26, row, res.getFloat("d23"), cf);
                Number d24 = new Number(27, row, res.getFloat("d24"), cf);
                Number d25 = new Number(28, row, res.getFloat("d25"), cf);
                Number d26 = new Number(29, row, res.getFloat("d26"), cf);
                Number d27 = new Number(30, row, res.getFloat("d27"), cf);
                Number d28 = new Number(31, row, res.getFloat("d28"), cf);
                Number d29 = new Number(32, row, res.getFloat("d29"), cf);
                Number d30 = new Number(33, row, res.getFloat("d30"), cf);
                Number d31 = new Number(34, row, res.getFloat("d31"), cf);
                Number tt1 = new Number(35, row, res.getFloat("total"), cf);



                try {

                    excelSheet.addCell(periodo);
                    excelSheet.addCell(apellido);
                    excelSheet.addCell(dni);
                    excelSheet.addCell(d1);
                    excelSheet.addCell(d2);
                    excelSheet.addCell(d3);
                    excelSheet.addCell(d4);
                    excelSheet.addCell(d5);
                    excelSheet.addCell(d6);
                    excelSheet.addCell(d7);
                    excelSheet.addCell(d8);
                    excelSheet.addCell(d9);
                    excelSheet.addCell(d10);
                    excelSheet.addCell(d11);
                    excelSheet.addCell(d12);
                    excelSheet.addCell(d13);
                    excelSheet.addCell(d14);
                    excelSheet.addCell(d15);
                    excelSheet.addCell(d16);
                    excelSheet.addCell(d17);
                    excelSheet.addCell(d18);
                    excelSheet.addCell(d19);
                    excelSheet.addCell(d20);
                    excelSheet.addCell(d21);
                    excelSheet.addCell(d22);
                    excelSheet.addCell(d23);
                    excelSheet.addCell(d24);
                    excelSheet.addCell(d25);
                    excelSheet.addCell(d26);
                    excelSheet.addCell(d27);
                    excelSheet.addCell(d28);
                    excelSheet.addCell(d29);
                    excelSheet.addCell(d30);
                    excelSheet.addCell(d31);
                    excelSheet.addCell(tt1);

                } catch (WriteException ex) {
                    System.err.println(ex.getMessage());
                }
            }

            res.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        //Escribe el archivo excel en disco
        try {
            workbook.write();
            workbook.close();
            System.out.println("Escribiendo en disco....Listo");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (WriteException ex) {
            System.err.println(ex.getMessage());
        }

        JOptionPane.showMessageDialog(null, "Proceso completado....");
        System.out.println("Proceso completado....");
    }

    public static void ExportarReporteDiario(String Fecha) throws SQLException, FileNotFoundException, IOException
    {
        List<Grupos> ListaGrupos;
        
        
        String NomArchivoXLS = JOptionPane.showInputDialog("Ingresar Nombre de Archivo");
         String Ruta=LeerTxt.LeerTexto("configalma.txt", 9, null);
        NomArchivoXLS = Ruta+NomArchivoXLS + ".XLS";
        File file = new File(NomArchivoXLS);
        int row = 0;
        //formato fuente para el contenido contenido
        WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
        WritableCellFormat cf = new WritableCellFormat(wf);

        WritableFont wf2 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
        WritableCellFormat cf2 = new WritableCellFormat(wf2);

        //Interfaz para una hoja de cálculo
        WritableSheet excelSheet = null;
        WritableWorkbook workbook = null;

        //Establece la configuración regional para generar la hoja de cálculo
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));

        try {
            workbook = Workbook.createWorkbook(file, wbSettings);

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        //hoja con nombre de la tabla


        ListaGrupos = DBGrupos.mostrarGrupos();
        for (int i = 0; i < ListaGrupos.size(); i++) {
            row=0;
            workbook.createSheet(ListaGrupos.get(i).getDescripcion(), 0);

            excelSheet = workbook.getSheet(0);
            System.out.println("creando hoja excel.....Listo");

            row++;
            Label tgrupo = new Label(1, row, "GRUPO", cf);
            Label tfecha = new Label(2, row, "FECHA", cf);
            Label tbotica = new Label(3, row, "BOTICA", cf);
            Label thinicio = new Label(4, row, "HORA_INICIO", cf2);
            Label thfinal = new Label(5, row, "HORA FINAL", cf2);
            Label ttiempo = new Label(6, row, "TIEMPO REVISION", cf2);
            Label tccajas = new Label(7, row, "CANT.CAJAS", cf2);
            Label tcguias = new Label(8, row, "CANT.GUIAS", cf2);
            
            //Label tt = new Label(35, row, "TOTAL", cf2);
            try {
                excelSheet.addCell(tgrupo);
                excelSheet.addCell(tfecha);
                excelSheet.addCell(tbotica);
                excelSheet.addCell(thinicio);
                excelSheet.addCell(thfinal);
                excelSheet.addCell(ttiempo);
                excelSheet.addCell(tccajas);
                excelSheet.addCell(tcguias);
                
                //excelSheet.addCell(tt);
            } catch (WriteException ex) {
                System.err.println(ex.getMessage());
            }
            //Consulta SQL 
            String sql = "CALL REVISION_DIA_X_GRUPO_FECHA(?,?)";
            try {
                Connection conn = BD.getConnection();
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.setInt(1,ListaGrupos.get(i).getId_Grupos());
                pstm.setString(2, Fecha);
                ResultSet res = pstm.executeQuery();
                System.out.println("obteniendo registros.....Listo");
                while (res.next()) {
                    row++;
                    //Number ci     = new Number( 0 , row, res.getLong( "ci" ) , cf );
                    Label dgrupo = new Label(1, row, res.getString("grupo"), cf);
                    Label dfecha = new Label(2, row, res.getString("fecha"), cf);
                    Label dbotica = new Label(3, row, res.getString("botica"), cf);
                    Label dhinicio = new Label(4, row, res.getString("hora_inicio"), cf);
                    Label dhfinal = new Label(5, row, res.getString("Hora_Termino"), cf);
                    Label dtiempo = new Label(6, row, res.getString("tiempo_revision"), cf);
                    Number dccajas = new Number(7, row, res.getFloat("cantidad_cajas"), cf);
                    Number dcguias = new Number(8, row, res.getFloat("cantidad_guias"), cf);
                    //Number tt1 = new Number(35, row, res.getFloat("total"), cf);
                    try {
                        
                        excelSheet.addCell(dgrupo);
                        excelSheet.addCell(dfecha);
                        excelSheet.addCell(dbotica);
                        excelSheet.addCell(dhinicio);
                        excelSheet.addCell(dhfinal);
                        excelSheet.addCell(dtiempo);
                        excelSheet.addCell(dccajas);
                        excelSheet.addCell(dcguias);
                    


                    } catch (WriteException ex) {
                        System.err.println(ex.getMessage());
                    }
                }

             res.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        //Escribe el archivo excel en disco
        try {
            workbook.write();
            workbook.close();
            System.out.println("Escribiendo en disco....Listo");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (WriteException ex) {
            System.err.println(ex.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Proceso completado....");
        System.out.println("Proceso completado....");
    }  
    public static void ExportarReporteDiario_Guias(String Fecha) throws SQLException, FileNotFoundException, IOException
    {
        List<Grupos> ListaGrupos;
        
        
        String NomArchivoXLS = JOptionPane.showInputDialog("Ingresar Nombre de Archivo");
        String Ruta=LeerTxt.LeerTexto("configalma.txt", 9, null);
        NomArchivoXLS = Ruta+NomArchivoXLS + ".XLS";
        File file = new File(NomArchivoXLS);
        int row = 0;
        //formato fuente para el contenido contenido
        WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
        WritableCellFormat cf = new WritableCellFormat(wf);

        WritableFont wf2 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
        WritableCellFormat cf2 = new WritableCellFormat(wf2);

        //Interfaz para una hoja de cálculo
        WritableSheet excelSheet = null;
        WritableWorkbook workbook = null;

        //Establece la configuración regional para generar la hoja de cálculo
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));

        try {
            workbook = Workbook.createWorkbook(file, wbSettings);

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        //hoja con nombre de la tabla


        ListaGrupos = DBGrupos.mostrarGrupos();
        for (int i = 0; i < ListaGrupos.size(); i++) {
            row=0;
            workbook.createSheet(ListaGrupos.get(i).getDescripcion(), 0);

            excelSheet = workbook.getSheet(0);
            System.out.println("creando hoja excel.....Listo");

            row++;
            Label tgrupo = new Label(1, row, "GRUPO", cf);
            Label tfecha = new Label(2, row, "FECHA", cf);
            Label tbotica = new Label(3, row, "BOTICA", cf);
            Label thinicio = new Label(4, row, "HORA_INICIO", cf2);
            Label thfinal = new Label(5, row, "HORA FINAL", cf2);
            Label ttiempo = new Label(6, row, "TIEMPO REVISION", cf2);
            Label tccajas = new Label(7, row, "TIEMPO ABASTECEDOR", cf2);
            Label tnumdoc = new Label(8, row, "NUMERO DOCU", cf2);
            Label tfecdoc = new Label(9, row, "FECHA DOCU", cf2);
            Label tcitems = new Label(10, row, "CANT.ITEMS", cf2);
            Label tcartic = new Label(11, row, "CANT.ARTICULOS", cf2);
            
            
            //Label tt = new Label(35, row, "TOTAL", cf2);
            try {
                excelSheet.addCell(tgrupo);
                excelSheet.addCell(tfecha);
                excelSheet.addCell(tbotica);
                excelSheet.addCell(thinicio);
                excelSheet.addCell(thfinal);
                excelSheet.addCell(ttiempo);
                excelSheet.addCell(tccajas); 
                excelSheet.addCell(tnumdoc); 
                excelSheet.addCell(tfecdoc); 
                excelSheet.addCell(tcitems); 
                excelSheet.addCell(tcartic); 
                
                //excelSheet.addCell(tt);
            } catch (WriteException ex) {
                System.err.println(ex.getMessage());
            }
            //Consulta SQL 
            String sql = "CALL REVISION_GUIAS_DIA_X_GRUPO_FECHA(?,?)";
            try {
                Connection conn = BD.getConnection();
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.setInt(1,ListaGrupos.get(i).getId_Grupos());
                pstm.setString(2, Fecha);
                ResultSet res = pstm.executeQuery();
                System.out.println("obteniendo registros.....Listo");
                while (res.next()) {
                    row++;
                    //Number ci     = new Number( 0 , row, res.getLong( "ci" ) , cf );
                    Label dgrupo = new Label(1, row, res.getString("grupo"), cf);
                    Label dfecha = new Label(2, row, res.getString("fecha"), cf);
                    Label dbotica = new Label(3, row, res.getString("botica"), cf);
                    Label dhinicio = new Label(4, row, res.getString("hora_inicio"), cf);
                    Label dhfinal = new Label(5, row, res.getString("Hora_Termino"), cf);
                    Label dtiempo = new Label(6, row, res.getString("tiempo_revision"), cf);
                    Number dtabastecedor = new Number(7, row, res.getFloat("tiempo_abastecedor"), cf);
                    Label dnumdoc = new Label(8, row, res.getString("numero_guia"), cf);
                    Label dfecdoc = new Label(9, row, res.getString("fecha_documento"), cf);
                    Label dcitems = new Label(10, row, res.getString("cantidad_item"), cf);
                    Label dcartic = new Label(11, row, res.getString("cantidad_productos"), cf);
                    //Number tt1 = new Number(35, row, res.getFloat("total"), cf);
                    try {
                        excelSheet.addCell(dgrupo);
                        excelSheet.addCell(dfecha);
                        excelSheet.addCell(dbotica);
                        excelSheet.addCell(dhinicio);
                        excelSheet.addCell(dhfinal);
                        excelSheet.addCell(dtiempo);
                        excelSheet.addCell(dtabastecedor);
                        excelSheet.addCell(dnumdoc);
                        excelSheet.addCell(dfecdoc);
                        excelSheet.addCell(dcitems);
                        excelSheet.addCell(dcartic);
                 } catch (WriteException ex) {
                        System.err.println(ex.getMessage());
                    }
                }
                 res.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        //Escribe el archivo excel en disco
        try {
            workbook.write();
            workbook.close();
            System.out.println("Escribiendo en disco....Listo");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (WriteException ex) {
            System.err.println(ex.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Proceso completado....");
        //System.out.println("Proceso completado....");
    }  
}//--> fin clase
