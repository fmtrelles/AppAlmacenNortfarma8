/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteOtros;

/**
 *
 * @author jsarango
 */
import AlmacenClases.Guias;
import AlmacenClases.Guias_Detalles;
import AlmacenClases.ProductoAlmacen;
import AlmacenClases.Productos;
import AlmacenDatos.DBGuias;
import AlmacenDatos.DBGuias_Detalle;
import AlmacenDatos.DBProductos;
import AlmacenDatos.DBProductosAlmacen;
import ComponenteDatos.BD;
import com.linuxense.javadbf.*;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LeerDBF {
    DateFormat ValorFecha = DateFormat.getDateInstance(DateFormat.MEDIUM);
    //Date fecha = new Date();
    
    
    public static boolean LeerDBFProductos(String Archivo) throws SQLException {
        int contador=0;
        boolean TodoOK=false;
        Connection cnn = BD.getConnection();
        try {
            
            InputStream inputStream = new FileInputStream(Archivo); // dbf como argumento programa
            DBFReader reader = new DBFReader(inputStream);
            int numberOfFields = reader.getFieldCount();
            /*for (int i = 0; i < numberOfFields; i++) {
             * DBFField field = reader.getField(i);
             * System.out.println(field.getName());
             * }*/
            Object[] rowObjects;
            Productos prod = new Productos();
            int CantRegistros = reader.getRecordCount();
            //boolean EliminadoProductos = DBProductos.eliminarProductosAll();

            System.out.println("Productos: Iniciando");
            while ((rowObjects = reader.nextRecord()) != null) {
                contador++;
                
                //System.out.println("Productos: "+contador+" Registro(s) de : "+CantRegistros);
                
                /*for (int i = 0; i < rowObjects.length; i++) {
                 * System.out.println(rowObjects[i]);
                 * }*/
                //System.out.println(rowObjects[0]);
                prod.setId_Producto(rowObjects[1].toString());
                prod.setDescripcion(rowObjects[0].toString());
                prod.setId_Laboratorio(rowObjects[2].toString());
                //System.out.println(rowObjects[3].toString());
                prod.setEmpaque(Integer.parseInt(rowObjects[3].toString().trim()));
                //prod.setEmpaqueSubir(Double.valueOf(rowObjects[3].toString()));
                prod.setCodigo_Barras(rowObjects[4].toString());
                prod.setCodigo_Barras2(rowObjects[5].toString());
                prod.setEstadoProducto(Integer.parseInt(rowObjects[6].toString().trim()));
               
                
                DBProductos.insertarProductos(prod,cnn);
            }
            inputStream.close();
            TodoOK=true;
        } catch (DBFException e) {
            System.out.println(e.getMessage());
            TodoOK= false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            TodoOK= false;
        }
        cnn.close();
        System.out.println("Productos: Finalizando");
        return TodoOK;
    }

    public static boolean LeerDBFCabeceras(String Archivo) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Guias> lguias = null;
        int contador=0;
        boolean TodoOK=false;
        Connection cnn = BD.getConnection();
        try {
            InputStream inputStream = new FileInputStream(Archivo); // dbf como argumento programa
            DBFReader reader = new DBFReader(inputStream);
            int numberOfFields = reader.getFieldCount();
            //for (int i = 0; i < numberOfFields; i++) {
            //    DBFField field = reader.getField(i);
            //    System.out.println(field.getName());
            //}
            Object[] rowObjects;
            Guias guias = new Guias();
            int CantRegistros = reader.getRecordCount();
            boolean EliminoGuias = DBGuias.eliminarGuiasUltimosDias();
            System.out.println("Cabeceras: Iniciando");
            while ((rowObjects = reader.nextRecord()) != null) {
                contador++;
                //System.out.println("Cabeceras: "+contador+" Registro(s) de : "+CantRegistros);
                /*for (int i = 0; i < rowObjects.length; i++) {
                 * System.out.println(rowObjects[i]);
                 * }*/
                //System.out.println("C:"+rowObjects[1]+"---"+rowObjects[3]);
                Date fecha1 = rowObjects[4]!=null?(Date)rowObjects[4]:null;
                String fechadoc = sdf.format(fecha1);
                
                Date fecha2 = rowObjects[5]!=null?(Date)rowObjects[5]:(Date)rowObjects[4];
                String fechareg = sdf.format(fecha2);
                
                guias.setCodalm(rowObjects[0].toString());
                guias.setTypmov(rowObjects[1].toString());
                guias.setCodprv(rowObjects[2].toString());
                guias.setDocnum(rowObjects[3].toString());
                guias.setDocdat(fechadoc);
                guias.setDatreg(fechareg);

                lguias=DBGuias.ListarGuias(rowObjects[1].toString(), rowObjects[3].toString());
                if(lguias.isEmpty()) {
                    DBGuias.insertarGuiasSinCnn(guias,cnn);
                }
            }
            inputStream.close();
            TodoOK=true;
        } catch (DBFException e) {
            System.out.println(e.getMessage());
            TodoOK=false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            TodoOK=false;
        }
        cnn.close();
        System.out.println("Cabeceras: Finalizar");
        return TodoOK;
    }

    public static boolean LeerDBFDetalle(String Archivo) throws SQLException {
        int contador=0;
        List ListDetalle;
        boolean TodoOK=false;
        Connection cnn = BD.getConnection();
        try {
            InputStream inputStream = new FileInputStream(Archivo); // dbf como argumento programa
            DBFReader reader = new DBFReader(inputStream);
            int numberOfFields = reader.getFieldCount();
            /*for (int i = 0; i < numberOfFields; i++) {
             * DBFField field = reader.getField(i);
             * System.out.println(field.getName());
             * }*/
           Object[] rowObjects;
            Guias_Detalles guiasd = new Guias_Detalles();
            boolean EliminoGuiasDetalle = DBGuias_Detalle.eliminarGuiasDetalleUltimosDias();
            int CantRegistros = reader.getRecordCount();
            System.out.println("Detalle: Iniciando");
            while ((rowObjects = reader.nextRecord()) != null) {
                /*for (int i = 0; i < rowObjects.length; i++) {
                 * System.out.println(rowObjects[i]);
                 * }*/
                //System.out.println("D:"+rowObjects[0]+"---"+rowObjects[1]);
                contador++;
                //System.out.println("Detalle: "+contador+" Registro(s) de : "+CantRegistros);
                 guiasd.setTypmov(rowObjects[0].toString());
                 guiasd.setDocnum(rowObjects[1].toString());
                 guiasd.setCodpro(rowObjects[2].toString());
                 guiasd.setStkprf(rowObjects[3].toString());
                //ListDetalle = DBGuias_Detalle.mostrarGuiasDetalle(rowObjects[0].toString(),rowObjects[1].toString());
                //if (ListDetalle.isEmpty())
                //{
                    DBGuias_Detalle.insertarGuiasDetalleSinCnn(guiasd,cnn);
               // }
                
            }
            inputStream.close();
            TodoOK=true;
        } catch (DBFException e) {
            System.out.println(e.getMessage());
            TodoOK=false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            TodoOK=false;
        }
        cnn.close();
        System.out.println("Detalle: Finalizando");
        return TodoOK;
        
    }
    
    public static boolean LeerDBFProductosAlmacen(String Archivo) throws SQLException {
        int contador=0;
        boolean TodoOK=false;
        Connection cnn = BD.getConnection();
        try {
            InputStream inputStream = new FileInputStream(Archivo); // dbf como argumento programa
            DBFReader reader = new DBFReader(inputStream);
            Object[] rowObjects = new Object[12];
            ProductoAlmacen palma = new ProductoAlmacen();
            boolean EliminoProductosAlmacen = DBProductosAlmacen.eliminarProductosAll();
            System.out.println("Productos Almacen: Iniciando");
            while ((rowObjects = reader.nextRecord()) != null) {
                
                palma.setCodpro(rowObjects[0].toString());
                palma.setDespro(rowObjects[1].toString());
                palma.setCodlab(rowObjects[2].toString());
                palma.setDeslab(rowObjects[3].toString());
                 
                palma.setStkalm(rowObjects[4]!=null?(int)Double.parseDouble(rowObjects[4].toString().trim()):0);
                palma.setStkalm_m(rowObjects[5]!=null?(int)Double.parseDouble(rowObjects[5].toString().trim()):0);
                palma.setStkmos(rowObjects[6]!=null?(int)Double.parseDouble(rowObjects[6].toString().trim()):0);
                palma.setStkmos_m(rowObjects[7]!=null?(int)Double.parseDouble(rowObjects[7].toString().trim()):0);
                palma.setStktod(rowObjects[8]!=null?(int)Double.parseDouble(rowObjects[8].toString().trim()):0);
                palma.setStktod_m(rowObjects[9]!=null?(int)Double.parseDouble(rowObjects[9].toString().trim()):0);
                //palma.setCodbar(rowObjects[10].toString());
                palma.setCodbar(rowObjects[10]!=null?rowObjects[10].toString().trim():"");
                palma.setTempminima(rowObjects[11]!=null?Double.parseDouble(rowObjects[11].toString().trim()):0.00);
                palma.setTempmaxima(rowObjects[12]!=null?Double.parseDouble(rowObjects[12].toString().trim()):0.00);
                
                DBProductosAlmacen.insertarProductos(palma,cnn);
                contador++;
            }
            inputStream.close();
            TodoOK=true;
        } catch (DBFException e) {
            System.out.println(e.getMessage());
            TodoOK=false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            TodoOK=false;
        }
        cnn.close();
        System.out.println("Productos Almacen: Finalizando");
        return TodoOK;
        
    }
}