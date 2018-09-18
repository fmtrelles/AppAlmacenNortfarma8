/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentePresentacion;

import AlmacenClases.Resumen_cabecera;
import AlmacenClases.Resumen_detalle;
import AlmacenDatos.DBResumenCabecera;
import AlmacenDatos.DBResumenDetalle;
import com.sun.media.sound.ModelAbstractChannelMixer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author Fernando Muñoz
 */
public class FrmResumen extends javax.swing.JFrame {

    /**
     * Creates new form Resumen
     */
    private DefaultTableModel model;
    int x = 0;
    String fecha;

    public FrmResumen() {
        initComponents();
        model = new DefaultTableModel();
        jTableDatos.setModel(model);
        Calendar c2 = new GregorianCalendar();
        jDateChooser1.setCalendar(c2);
        cabeceras();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Resumen");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTableDatos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.", "Descripción", "Laboratorio", "Empaque", "Tipo", "Botica", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDatos);

        jButton1.setText("Cargar");
        jButton1.setName(""); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Fecha:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel2.setText("Observación");

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2)))
                            .addComponent(jLabel2))
                        .addGap(13, 13, 13)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(32, 32, 32)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 23, Short.MAX_VALUE))))
        );

        jButton1.getAccessibleContext().setAccessibleName("btnCargar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTableDatos.setShowGrid(false);
        model.setRowCount(0);
        model.setColumnCount(0);
        JFileChooser examinar = new JFileChooser();
        examinar.setFileFilter(new FileNameExtensionFilter("Archivos Excel", "xls", "xlsx"));
        int opcion = examinar.showOpenDialog(this);
        File archivoExcel = null;
        if (opcion == JFileChooser.APPROVE_OPTION) {
            try {
                archivoExcel = examinar.getSelectedFile().getAbsoluteFile();
                Workbook leerExcel = Workbook.getWorkbook(archivoExcel);
                for (int hoja = 0; hoja < leerExcel.getNumberOfSheets(); hoja++) {
                    Sheet hojaP = leerExcel.getSheet(hoja);
                    int columnas = hojaP.getColumns();
                    int filas = hojaP.getRows();
                    JOptionPane.showMessageDialog(rootPane, "Numero de filas: " + filas + "\nNúmero de columnas: " + columnas);
                    Object Data[] = new Object[columnas];
                    cabeceras();
                    for (int fila = 0; fila < filas; fila++) {
                        for (int columna = 0; columna < columnas; columna++) {
                            if (fila >= 1) {
                                Data[columna] = hojaP.getCell(columna, fila).getContents();
                            }
                        }
                        formatotable();
                        model.addRow(Data);
                    }
                }
                model.removeRow(0);
            } catch (IOException ex) {
                System.out.println("Error al guardar archivo" + ex);
                JOptionPane.showMessageDialog(null, "Error al guardar el archivo");
            } catch (BiffException ex) {
                System.out.println("Error al guardar archivo" + ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        List<Resumen_cabecera> lista;
        int dia, mes, anho, id = 0;
        anho = jDateChooser1.getCalendar().get(Calendar.YEAR);
        mes = jDateChooser1.getCalendar().get(Calendar.MONTH) + 1;
        dia = jDateChooser1.getCalendar().get(Calendar.DAY_OF_MONTH);
        fecha = anho + "-" + mes + "-" + dia;
        lista = DBResumenCabecera.BuscarCabecerasPorFecha(fecha);
        if (lista.size() > 0) {
            int respuesta = JOptionPane.showConfirmDialog(null, "Ya hay un archivo creado en esa fecha ¿Seguro que deseas guardar OTRO?");
            if (JOptionPane.OK_OPTION == respuesta) {
                guardar();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione otra fecha");
            }
        } else {
            guardar();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String fecha_eliminar;
        List<Resumen_detalle> lista;
        int anho, mes, dia;
        anho = jDateChooser1.getCalendar().get(Calendar.YEAR);
        mes = jDateChooser1.getCalendar().get(Calendar.MONTH) + 1;
        dia = jDateChooser1.getCalendar().get(Calendar.DAY_OF_MONTH);
        fecha_eliminar = anho + "-" + mes + "-" + dia;
        lista = DBResumenDetalle.BuscarDetallesTotal(fecha_eliminar);
        if (lista.size() > 0) {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar registros de esta fecha: " + fecha_eliminar + "?");
            if (JOptionPane.OK_OPTION == respuesta) {
                DBResumenDetalle.eliminar(fecha_eliminar);
                JOptionPane.showMessageDialog(null, "Los registros con fecha " + fecha_eliminar + " fueron eliminados!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros en esa fecha");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public void guardar() {
        List<Resumen_detalle> lista = new ArrayList<Resumen_detalle>();
        Resumen_cabecera cabecera = new Resumen_cabecera();
        String observacion;
        observacion = jTextArea1.getText();
        cabecera.setFecha(fecha);
        cabecera.setObservacion(observacion);
        int cantidad = jTableDatos.getRowCount();
        if (cantidad == 0) {
            JOptionPane.showMessageDialog(null, "Primero cargar Excel", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int cantidad2 = 0;
            cantidad2 = jTableDatos.getColumnCount();
            if (cantidad2 == 7) {
                DBResumenCabecera.InsertarCabecera(cabecera);
                int id = DBResumenCabecera.idmax();
                int total = jTableDatos.getRowCount();
                for (int filas = 0; filas < total; filas++) {
                    Resumen_detalle resumen = new Resumen_detalle();
                    resumen.setCodigo_producto(jTableDatos.getValueAt(filas, 0).toString());
                    resumen.setDescripcion_producto(jTableDatos.getValueAt(filas, 1).toString());
                    resumen.setCodigo_laboratorio(jTableDatos.getValueAt(filas, 2).toString());
                    resumen.setEmpaque(jTableDatos.getValueAt(filas, 3).toString());
                    resumen.setCodigo_tipo(jTableDatos.getValueAt(filas, 4).toString());
                    resumen.setId_botica(jTableDatos.getValueAt(filas, 5).toString());
                    resumen.setCantidad(Integer.parseInt(jTableDatos.getValueAt(filas, 6).toString()));
                    resumen.setFecha_guardado(fecha);
                    resumen.setIdcabecera(id);
                    lista.add(resumen);
                }
                DBResumenDetalle.InsertarDetalles(lista);
                JOptionPane.showMessageDialog(null, "Guardado correctamente");
                model.setRowCount(0);
                model.setColumnCount(0);
                cabeceras();
            } else {
                JOptionPane.showMessageDialog(null, "Error con archivo Excel, \nPor favor verificar datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void formatotable() {
        TableColumnModel columnModel = jTableDatos.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(40);
        columnModel.getColumn(4).setPreferredWidth(40);
        columnModel.getColumn(5).setPreferredWidth(40);
        columnModel.getColumn(6).setPreferredWidth(40);
    }

    public void cabeceras() {
        model.addColumn("Cod. Producto");
        model.addColumn("Descripción");
        model.addColumn("Laboratorio");
        model.addColumn("Empaque");
        model.addColumn("Tipo");
        model.addColumn("Botica");
        model.addColumn("Cantidad");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmResumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmResumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmResumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmResumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmResumen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableDatos;
    private javax.swing.JTextArea jTextArea1;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables
}
